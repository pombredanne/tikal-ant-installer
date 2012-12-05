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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import org.tp23.antinstaller.InstallException;
import org.tp23.antinstaller.page.Page;
import org.tp23.antinstaller.page.TextPage;


public class TextPageRenderer
	extends AbstractTextPageRenderer {

	private static final ResourceBundle res = ResourceBundle.getBundle("org.tp23.antinstaller.renderer.text.Res");
	private static final String nextChar = res.getString("nextChar");

	public TextPageRenderer() {
	}

	public boolean renderPage(Page page) throws InstallException {
		if (page instanceof TextPage) {
			TextPage lPage = (TextPage) page;
			return renderTextPage(lPage);
		}
		else {
			throw new InstallException("Wrong Renderer in TextPageRenderer.renderPage");
		}
	}

	private boolean renderTextPage(TextPage page) throws InstallException {
		try {
			BufferedReader commandReader = reader;//new BufferedReader(new InputStreamReader(in));

			String resource = page.getTextResource();
			InputStream textin = this.getClass().getResourceAsStream(resource);
			BufferedReader reader = new BufferedReader(new InputStreamReader(textin));
			printHeader(page);
			String lineread = null;
			StringBuffer sb = new StringBuffer();

			while ( (lineread = reader.readLine()) != null) {
				sb.append(lineread);
				sb.append('\n');
			}
            // as per FindBugs
            reader.close();

			// parse property references
			String parsedText = getContext().getInstaller().getResultContainer().getDefaultValue(sb.toString());

			String command = null;
			Pager pager = new Pager(parsedText);
			do {
				if (!pager.next(out)) {
					break;
				}
				out.println();
				out.println(getNextInstructions());
				command = commandReader.readLine();
			}
			while (command.toUpperCase().startsWith(nextChar));
			pager.rest(out);

			for (int i = 0; i < PAGE_DECO_WIDTH; i++) {
				out.print('~');
			}
			
			out.println();
			out.println(res.getString("clickViewText"));
			commandReader.readLine();
			
			return true;
		}
		catch (IOException ex) {
			throw new InstallException("Not able to read text file", ex);
		}
	}

	private String getNextInstructions() {
		return res.getString("license_next");
	}
}

