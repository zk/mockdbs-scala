package napplelabs.mockdbs.views


import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{ImageIcon, JButton, JToggleButton, JFrame}
import com.explodingpixels.macwidgets.{MacButtonFactory, UnifiedToolBar}

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 16, 2009
 * Time: 12:11:29 AM
 * To change this template use File | Settings | File Templates.
 */

class TopBarView(toolBar:UnifiedToolBar) {
    import napplelabs.mockdbs.implicits.SwingImplicits._

    val speakerIcon = new ImageIcon( classOf[TopBarView].getResource( "/speaker.png" ) )
    val muteButton = MacButtonFactory.makeUnifiedToolBarButton( new JToggleButton( "Toggle Mute", speakerIcon ) )
    muteButton.putClientProperty( "JButton.buttonType", "textured" )
    muteButton.setFocusable( false )
    toolBar.addComponentToRight( muteButton )


    val homeIcon = new ImageIcon( classOf[TopBarView].getResource( "/counterclockwise.png" ) )
    val resetViewButton = MacButtonFactory.makeUnifiedToolBarButton( new JButton( "Reset View", homeIcon ) )
    resetViewButton.setFocusable( false )
    resetViewButton.putClientProperty( "JButton.buttonType", "textured" )
    toolBar.addComponentToRight( resetViewButton )

    def onMuteButtonToggle(f:( Boolean ) => Any) = {
        muteButton.addActionListener( (e:ActionEvent) => f( muteButton.isSelected ) )
    }

    def onResetViewButton(f:( ActionEvent ) => Any) = {
        resetViewButton.addActionListener( (e:ActionEvent) => f( e ) )
    }

    def setMuteButtonSelected(b:Boolean) = muteButton.setSelected( b )
}