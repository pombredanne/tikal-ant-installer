/*
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

import org.tp23.antinstaller.InstallerContext;
import org.tp23.antinstaller.input.HiddenPropertyInput;
import org.tp23.antinstaller.input.OutputField;

/**
 * Text UI Renderer for hidden properties - displays nothing
 *
 * @author mwilson
 * @version $Id
 * @since 0.7.4 patch 6
 */
public class HiddenPropertyInputRenderer implements TextOutputFieldRenderer
{

    public void setContext( InstallerContext ctx )
    {

    }

    public void renderOutput( OutputField field, BufferedReader reader, PrintStream out ) throws IOException
    {
        HiddenPropertyInput propertyField = (HiddenPropertyInput) field;

        if( !propertyField.isEditted() )
        {
            propertyField.setInputResult( propertyField.getDefaultValue() );
        }
    }

    public void renderError( OutputField field, BufferedReader reader, PrintStream out ) throws IOException
    {

    }

    public boolean isAbort()
    {
        return false;
    }
}
