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
package org.tp23.antinstaller.renderer.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import org.tp23.antinstaller.InstallException;
import org.tp23.antinstaller.InstallerContext;
import org.tp23.antinstaller.ValidationException;
import org.tp23.antinstaller.input.OutputField;
import org.tp23.antinstaller.page.Page;
import org.tp23.antinstaller.page.SimpleInputPage;
import org.tp23.antinstaller.renderer.RendererFactory;

public class SimpleInputPageRenderer
	extends AbstractTextPageRenderer {
	
	public SimpleInputPageRenderer() {
	}

	public boolean renderPage(Page page) throws InstallException{
		if (page instanceof SimpleInputPage) {
			try {
				return renderSimpleInputPage( (SimpleInputPage) page);
			}
			catch (ClassNotFoundException ex) {
				// this would be a code error
				throw new InstallException("Cant find acceptable TextField renderer in SimpleInputPageRenderer.renderPage:" + ex.getMessage(),
										   ex);
			}
		}
		else {
			//this would be a code error
			throw new InstallException("Wrong Renderer in SimpleInputPageRenderer.renderPage");
		}
	}

	private boolean renderSimpleInputPage(SimpleInputPage page)
            throws InstallException, ClassNotFoundException, ValidationException
    {

		try {
			printHeader(page);
			OutputField[] fields = page.getOutputField();
            return renderFields( getContext(), fields, reader, out );
		}
		catch (IOException ex) {
			// If you cant write to the console there is not much you can do
			throw new InstallException("IOException",ex);
		}
	}

    public static boolean renderFields( InstallerContext context, OutputField[] fields, BufferedReader reader, PrintStream out )
            throws ClassNotFoundException, IOException, ValidationException, InstallException
    {

        for (int f = 0; f < fields.length; f++) {
            String text = fields[f].getExplanatoryText();
            if(text != null){
                out.println(text);
                out.println();
            }

            TextOutputFieldRenderer frenderer = RendererFactory.getTextRenderer(fields[f]);
            frenderer.setContext( context );
            frenderer.renderOutput(fields[f], reader, out);
            if (frenderer.isAbort()) {
                return false;
            }
            while(!fields[f].validate( context ) ){
                frenderer.renderError(fields[f], reader, out);
            };
        }
        return true;
    }
}
