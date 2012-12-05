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
import java.util.ResourceBundle;

import org.tp23.antinstaller.InstallerContext;
import org.tp23.antinstaller.input.OutputField;
import org.tp23.antinstaller.input.UnvalidatedTextInput;


public class UnvalidatedTextInputRenderer
	implements TextOutputFieldRenderer {

	private static final ResourceBundle res = ResourceBundle.getBundle("org.tp23.antinstaller.renderer.text.Res");

	protected InstallerContext ctx;
	public UnvalidatedTextInputRenderer() {
	}

	public void setContext(InstallerContext ctx) {
		this.ctx = ctx;
	}

	public void renderOutput(OutputField field, BufferedReader reader, PrintStream out) throws IOException {
		UnvalidatedTextInput iField = (UnvalidatedTextInput) field;
		out.print(field.getDisplayText());

		out.print("   [");
		out.print(res.getString("_default_"));
		out.print(":");
		out.print(iField.getDefaultValue());
		out.print("]");


		//BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		out.println();
		String input = reader.readLine();
		out.println();
		if(input==null || input.equals(""))input=iField.getDefaultValue();
		iField.setInputResult(input);
	}
	public boolean isAbort(){
		return false;
	}



	/**
	 * renderError
	 *
	 * @param field InputField
	 * @param in InputStream
	 * @param out PrintStream
	 */
	public void renderError(OutputField field, BufferedReader reader, PrintStream out) {
	}
}
