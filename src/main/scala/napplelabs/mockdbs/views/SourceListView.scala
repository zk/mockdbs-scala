package napplelabs.mockdbs.views

import com.explodingpixels.macwidgets._
import com.explodingpixels.widgets.PopupMenuCustomizerUsingStrings
import javax.swing.{ImageIcon, JPanel}

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