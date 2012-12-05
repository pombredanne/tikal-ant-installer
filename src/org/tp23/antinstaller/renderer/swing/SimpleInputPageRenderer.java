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
package org.tp23.antinstaller.renderer.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.tp23.antinstaller.ValidationException;
import org.tp23.antinstaller.input.CommentOutput;
import org.tp23.antinstaller.input.OutputField;
import org.tp23.antinstaller.page.SimpleInputPage;
import org.tp23.antinstaller.renderer.RendererFactory;
import org.tp23.gui.GBCF;

/**
 *
 * <p>This PageRenderer just renders a list of SwingInputRenderers using
* a BoxLayout </p>
 * <p> </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: tp23</p>
 * @author Paul Hinds
 * @version $Id: SimpleInputPageRenderer.java,v 1.6 2006/12/27 21:46:35 teknopaul Exp $
 */
public class SimpleInputPageRenderer
	extends SwingPageRenderer {

     //Prevent displayText and explanatoryText being rendered using different fonts
    private static final Font defaultFont = new JLabel().getFont();

	private JPanel contentPanel = new JPanel();
	
	private GridBagLayout gridLayout = new GridBagLayout();
	private GBCF cf = new GBCF(); // GridBagConstraintsFactory
	private boolean overflow = false;
	// used in overflow
	JScrollPane scroller = null;
	

	private ArrayList renderers = new ArrayList();

	public SimpleInputPageRenderer(){
	}
		
	public boolean validateFields() throws ValidationException {
		OutputField[] fields = page.getOutputField();
		for (int i = 0; i < fields.length; i++) {
			if(!fields[i].validate(ctx)){
				SwingOutputFieldRenderer renderer = (SwingOutputFieldRenderer)renderers.get(i);
				renderer.renderError();
				return false;
			}
		}
		return true;
	}
	public void updateInputFields(){
		for (int i = 0; i < renderers.size(); i++) {
			((SwingOutputFieldRenderer)renderers.get(i)).updateInputField();
		}
	}

	public void updateDefaultValues(){
		for (int i = 0; i < renderers.size(); i++) {
			((SwingOutputFieldRenderer)renderers.get(i)).updateDefaultValue();
		}
	}

	public void instanceInit() throws Exception {
		overflow = ((SimpleInputPage)page).isOverflow();
		if(overflow){
			//WARNING this causes flickering in the UI 
			contentPanel.setMaximumSize(new Dimension(SizeConstants.PAGE_WIDTH - 50, SizeConstants.PAGE_HEIGHT));
			scroller = new JScrollPane();
			scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroller.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createEmptyBorder(4,4,4,4),
							BorderFactory.createEtchedBorder()				
							));
			add(scroller, BorderLayout.CENTER);
			scroller.getViewport().add(contentPanel);
			//contentPanel.setBackground(Color.red);
		}
		else {
			this.add(contentPanel, BorderLayout.CENTER);
			contentPanel.setBorder(BorderFactory.createEmptyBorder(SizeConstants.TOP_INDENT, 4, 4, 4));
		}

		OutputField[] fields = page.getOutputField();
		contentPanel.setDoubleBuffered(true);
		contentPanel.setLayout(gridLayout);
		int row = 0;
		for (int i = 0; i < fields.length; i++) {
			SwingOutputFieldRenderer renderer = RendererFactory.getSwingRenderer(fields[i]);
			String text = fields[i].getExplanatoryText();
			if(fields[i].getExplanatoryText() != null){
				JTextArea area = new DisplayTextArea(contentPanel.getBackground(), contentPanel.getForeground());
				area.setIgnoreRepaint(true);
                area.setFont( defaultFont );
                area.setText(text);
				contentPanel.add(area, cf.getSpan(row++));
                if(fields[i] instanceof CommentOutput){
                    CommentOutputRenderer crenderer = (CommentOutputRenderer)renderer;
                    crenderer.setExplanatoryTextField(area);
                    if(fields[i].getDisplayText() == null){
                        continue;
                    }
				}
			}
			renderer.setOutputField(fields[i]);
			renderer.setInstallerContext(ctx);
			renderer.initComponent(contentPanel);
			row = renderer.addSelf(contentPanel, cf, row, overflow);
			renderers.add(renderer);
		}
		contentPanel.add(new JPanel(), cf.getVertGlue(row++));
	}
}
/**
 * A JTextArea that is not editable and looks like a JLabel but uses 
 * JTextAreas ability to wrap.  Also has a fixed prefered width; 
 * @author Paul Hinds
 * @version $Id: SimpleInputPageRenderer.java,v 1.6 2006/12/27 21:46:35 teknopaul Exp $
 */
class DisplayTextArea extends JTextArea{
	DisplayTextArea(Color back, Color fore){
		super();
		this.setBackground(back);
		this.setForeground(fore);
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		this.setEditable(false);
		this.setSelectionColor(back);
		this.setSelectionColor(back);
		this.setMargin(new Insets(5,0,0,0));
	}

	public Dimension getPreferredSize(){
		Dimension pref = super.getPreferredSize();
		return new Dimension(SizeConstants.PAGE_WIDTH - 40, pref.height);
	}
	public Dimension getMinimumSize(){
		Dimension pref = super.getMinimumSize();
		return new Dimension(SizeConstants.PAGE_WIDTH - 40, pref.height);
	}
}
