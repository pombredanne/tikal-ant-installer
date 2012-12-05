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
package org.tp23.antinstaller.runtime.exe;

import org.tp23.antinstaller.InstallException;
import org.tp23.antinstaller.InstallerContext;


/**
 * Executes the Screens part of the build
 * @author Paul Hinds
 * @version $Id: ExecuteRunnerFilter.java,v 1.3 2006/12/21 01:48:51 teknopaul Exp $
 */
public class ExecuteRunnerFilter implements ExecuteFilter {

	/**
	 * @see org.tp23.antinstaller.runtime.exe.ExecuteFilter#exec(org.tp23.antinstaller.InstallerContext)
	 */
	public void exec(InstallerContext ctx) throws InstallException {
		if(ctx.getInstaller().isVerbose()){
			ctx.log("Starting UI Screens");
		}
		boolean ok = ctx.getRunner().runInstaller();
		if(!ok){
			throw new AbortException("Install Aborted");
		}
		ctx.log("Install screens rendered");
	}

	public static class AbortException extends InstallException{
		public AbortException(String message){
			super(message);
		}
	}
}
