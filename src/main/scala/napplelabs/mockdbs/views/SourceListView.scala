package napplelabs.mockdbs.views

import com.explodingpixels.macwidgets._
import com.explodingpixels.widgets.PopupMenuCustomizerUsingStrings
import javax.swing.{ImageIcon, JPanel}

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 19, 2009
 * Time: 11:38:42 PM
 * To change this template use File | Settings | File Templates.
 */

class SourceListView {
    val basicNeuronsCat = new SourceListCategory( "Basic Neurons" )

    val blueSliImageIcon = new ImageIcon( classOf[SourceListView].getResource( "/blue_sli.png" ) )
    val redSliImageIcon = new ImageIcon( classOf[SourceListView].getResource( "/red_sli.png" ) )
    val greenSliImageIcon = new ImageIcon( classOf[SourceListView].getResource( "/green_sli.png" ) )
    val model = new SourceListModel
    model.addCategory( basicNeuronsCat )
    model.addItemToCategory( new SourceListItem( "Hello", blueSliImageIcon ), basicNeuronsCat )
    model.addItemToCategory( new SourceListItem( "World", greenSliImageIcon ), basicNeuronsCat )
    model.addItemToCategory( new SourceListItem( "You", redSliImageIcon ), basicNeuronsCat )


    val sourceList = new SourceList( model )
    //sourceList.setColorScheme(new SourceListDarkColorScheme)

    val controlBar = new SourceListControlBar();
    sourceList.installSourceListControlBar( controlBar );
    controlBar.createAndAddButton( MacIcons.PLUS, null );
    controlBar.createAndAddButton( MacIcons.MINUS, null );
    controlBar.createAndAddPopdownButton( MacIcons.GEAR,
        new PopupMenuCustomizerUsingStrings( null, "Item One", "Item Two", "Item Three" ) );



    def getComponent = sourceList.getComponent
}