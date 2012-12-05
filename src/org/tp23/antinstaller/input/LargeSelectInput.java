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
package org.tp23.antinstaller.input;


import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.tp23.antinstaller.InstallerContext;
import org.tp23.antinstaller.ValidationException;



/**
 *
 * <p>Input type to choose a single value from a (numbered) list of options </p>
 * <p>This input is designed to handle larger lists of options </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: tp23</p>
 * @author Paul Hinds
 * @version $Id: LargeSelectInput.java,v 1.3 2006/12/07 02:50:27 teknopaul Exp $
 */
public class LargeSelectInput
	extends InputField{

	// i18n support
	private static ResourceBundle langPack = null;
	private int optionIdx = 0;
	static{
		try {
			langPack = ResourceBundle.getBundle("resources.LanguagePack");
		} catch (MissingResourceException e) {
			// ignore, signifies no lang packs installed  
		}
	}

	private LargeSelectInput.Option[] options;

	public LargeSelectInput() {
	}


	public LargeSelectInput.Option[] getOptions() {
		return options;
	}

	public void setOptions(LargeSelectInput.Option[] options) {
		this.options = options;
	}
	public Option getNewOption(){
		return new Option();
	}
	
	public class Option {

		private int idx = ++optionIdx;
		private String text;
		public String value;
		public void setText(String text) {
			this.text = text;
		}
		public String getText() {
			if(langPack != null){
				return langPack.getString(getProperty() + "." + idx +".displayText");
			}
			return text;
		}
	}
	
	public void setValue(String dir){
		setInputResult(dir);
	}
	/**
	 * Called to validate the user input
	 */
	public boolean validate(InstallerContext cxt) throws ValidationException{
		if(getInputResult()==null)return false;
		String value = getInputResult();
		boolean ok = false;
		for (int i = 0; i < options.length; i++) {
			ok |= options[i].value.equals(value);
		}
		return ok;
	}



	/**
	 * Used by checkConfig to validate the configuration file.
	 * Not used at runtime.
	 * @return boolean
	 */
	public boolean validateObject() {
		if(getDisplayText()==null){
			System.out.println("LargeSelect:displayText must be set");
			return false;
		}
		if(getProperty()==null){
			System.out.println("LargeSelect:property must be set");
			return false;
		}
		if(getDefaultValue()==null){
			System.out.println("LargeSelect:defaultValue must be set");
			return false;
		}
		if(getOptions()==null){
			System.out.println("LargeSelect:option must have at least two options");
			return false;
		}
		if(getOptions().length<2){
			System.out.println("LargeSelect:option must have at least two options");
			return false;
		}
		for (int i = 0; i < getOptions().length; i++) {
			Option o = getOptions()[i];
			if(o.getText()==null){
				System.out.println("LargeSelect:option:text must be set");
				return false;
			}
			if(o.value==null){
				System.out.println("LargeSelect:option:value must be set");
				return false;
			}
		}
		boolean defaultExists = false;
		for (int i = 0; i < getOptions().length; i++) {
			Option o = getOptions()[i];
			if(o.value.equals(getDefaultValue())){
				defaultExists=true;
			}
		}
		if(!defaultExists){
			System.out.println("LargeSelect:option:Default must be one of the options");
			return false;
		}
		return true;
	}
}
