/*
	MockDBS: Deep Brain Stimulation Simulator
    Copyright (C) 2009 Zachary Kim

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package napplelabs.mockdbs.views


import com.explodingpixels.macwidgets._
import com.explodingpixels.widgets.{WindowUtils, PopupMenuCustomizerUsingStrings}
import javax.swing.{BorderFactory, JSplitPane, JButton, JFrame}
import java.awt.{Component, BorderLayout}


class MacFrame(name:String) {
    val frame = new JFrame( name )
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE )
    frame.setSize( 800, 600 )
    frame.setLocationRelativeTo( null )
    frame.setLayout( new BorderLayout )
    MacUtils.makeWindowLeopardStyle( frame.getRootPane )
    WindowUtils.createAndInstallRepaintWindowFocusListener( frame );


    def setBottomBar(bb:BottomBar) = frame.add( bb.getComponent, BorderLayout.SOUTH )

    def setTopBar(tb:UnifiedToolBar) = frame.add( tb.getComponent, BorderLayout.NORTH )

    def setContent(content:Component) = frame.add( content, BorderLayout.CENTER )

    def setVisible(b:Boolean) = frame.setVisible( b )

    //
    //  val toolbar = new UnifiedToolBar();
    //  frame.add(toolbar.getComponent, BorderLayout.NORTH)
    //  val button = new JButton("Push Me!")
    //  button.putClientProperty("JButton.buttonType", "textured")
    //  toolbar.addComponentToLeft(button)
    //
    //  val bottombar = new BottomBar(BottomBarSize.LARGE);
    //  val bottomLabel = MacWidgetFactory.createEmphasizedLabel("Hello World")
    //  bottombar.addComponentToCenter(bottomLabel)
    //  frame.add(bottombar.getComponent, BorderLayout.SOUTH)
    //
    //  val splitPane = new JSplitPane();
    //  splitPane.setContinuousLayout(true)
    //  splitPane.setBorder(BorderFactory.createEmptyBorder)
    //  splitPane.setDividerSize(1)
    //
    //  val controlBar = new SourceListControlBar
    //  controlBar.createAndAddButton(MacIcons.PLUS, null);
    //  controlBar.createAndAddButton(MacIcons.MINUS, null);
    //  controlBar.createAndAddPopdownButton(MacIcons.GEAR,
    //    new PopupMenuCustomizerUsingStrings(null, "Item One", "Item Two", "Item Three"));
    //
    //  controlBar.installDraggableWidgetOnSplitPane(splitPane)
    //
    //  val model = new SourceListModel()
    //  val cat = new SourceListCategory("cat")
    //  model.addCategory(cat)
    //  model.addItemToCategory(new SourceListItem("Item"), cat)
    //  val sourceList = new SourceList(model)
    //  sourceList.installSourceListControlBar(controlBar);
    //
    //  splitPane.add(sourceList.getComponent, JSplitPane.LEFT);
    //
    //  frame.add(splitPane, BorderLayout.CENTER);
    //
    //  frame.setVisible(true);


}

object MacFrameTest extends Application {
    new MacFrame( "" )
}