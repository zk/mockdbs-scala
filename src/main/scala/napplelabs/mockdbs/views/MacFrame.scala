package napplelabs.mockdbs.views


import com.explodingpixels.macwidgets._
import com.explodingpixels.widgets.{WindowUtils, PopupMenuCustomizerUsingStrings}
import javax.swing.{BorderFactory, JSplitPane, JButton, JFrame}
import java.awt.{Component, BorderLayout}

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 11, 2009
 * Time: 3:09:59 PM
 * To change this template use File | Settings | File Templates.
 */

class MacFrame(name:String) {
    val frame = new JFrame(name)
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
    new MacFrame("")
}