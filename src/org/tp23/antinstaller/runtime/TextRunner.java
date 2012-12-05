/* 
 * Copyright 2005 Paul Hinds
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tp23.antinstaller.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ResourceBundle;

import org.tp23.antinstaller.InstallException;
import org.tp23.antinstaller.Installer;
import org.tp23.antinstaller.InstallerContext;
import org.tp23.antinstaller.page.Page;
import org.tp23.antinstaller.page.SimpleInputPage;
import org.tp23.antinstaller.renderer.AntOutputRenderer;
import org.tp23.antinstaller.renderer.RendererFactory;
import org.tp23.antinstaller.renderer.text.AbstractTextPageRenderer;
import org.tp23.antinstaller.renderer.text.TextMessageRenderer;



/**
 *
 * <p>Runs the installer from the text only command line (console) </p>
 * <p>This class uses the Installer object tree as its data source and renderers
 * from the org.tp23.antinstaller.renderer.text package </p>
 * <p>Copyright (c) 2004</p>
 * <p>Company: tp23</p>
 * @author Paul Hinds
 * @version $Id: TextRunner.java,v 1.10 2007/01/19 00:24:36 teknopaul Exp $
 */
public class TextRunner extends AntRunner 
	implements Runner {
	
	private static final ResourceBundle res = ResourceBundle.getBundle("org.tp23.antinstaller.renderer.Res");

	protected final InstallerContext ctx;
	protected final Installer installer;
	private final Logger logger;
	protected final IfPropertyHelper ifHelper;

	public TextRunner(InstallerContext ctx) throws IOException {
		super(ctx);
		this.ctx = ctx;
		this.installer = ctx.getInstaller();
		this.logger = ctx.getLogger();
		ctx.setMessageRenderer(new TextMessageRenderer());
		ctx.setAntOutputRenderer(new AntOutputRenderer(){
			public PrintStream getErr() {
				return System.err;
			}
			public PrintStream getOut() {
				return System.out;
			}

		});
		this.ifHelper = new IfPropertyHelper(ctx);
	}

	/**
	 * Renders the installer on the command line, this method blocks until
	 * the UI has finished
	 * @throws InstallException
	 * @return boolean false implies the install was aborted
	 */
	public boolean runInstaller() throws InstallException {
		try {
			return renderPages(installer.getPages());
		}
		catch (Exception ex) {
			logger.log("FATAL exception during installation:"+ex.getMessage());
            logger.log(installer, ex);
			
			ctx.getMessageRenderer().printMessage(res.getString("installationFailed") + ":" + ex.getMessage());
			//Fixed BUG: ctx.getMessageRenderer().printMessage("Installation failed:"+ex.getMessage());
			throw new InstallException("Installation failed", ex);
		}
	}


	private boolean renderPages(Page[] pages) throws ClassNotFoundException, InstallException{
		Page next = null;
		for (int i = 0; i < pages.length; i++) {
			next = pages[i];

			if(next instanceof SimpleInputPage){
				// skip iftarget specified and missing
				if(!ifHelper.ifTarget(next, pages))continue;
				// skip page if ifProperty is specified and property is missing
				if(!ifHelper.ifProperty(next))continue;
			}

			AbstractTextPageRenderer renderer = RendererFactory.getTextPageRenderer(next);
			renderer.setContext(ctx);
			renderer.init( new BufferedReader(new InputStreamReader(System.in)), System.out);
			ctx.setCurrentPage(next);
			renderer.renderPage(next);
			if (next.isAbort()){
				return false;
			}
			runPost(next);
		}
		return true;
	}
    public InstallerContext getInstallerContext() {
		return ctx;
    }



	/**
	 * Called when Ant has finished its work
	 */
	public void antFinished() {
		System.out.println(res.getString("finished"));
		//System.exit(0);
	}
	/**
	 * Called is Ant failed to install correctly
	 */
	public void fatalError(){
		System.out.println(res.getString("failed"));
		//System.exit(1);
	}

	public String toString() {
		return "TextRunner";
	}
}
