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


import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{ImageIcon, JButton, JToggleButton, JFrame}
import com.explodingpixels.macwidgets.{MacButtonFactory, UnifiedToolBar}


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
    
    
//    val birdsEyeButton = new JToggleButton("Toggle Bird's Eye")
//    birdsEyeButton.setFocusable(false)
//    birdsEyeButton.putClientProperty( "JButton.buttonType", "textured")
//    toolBar.addComponentToLeft( birdsEyeButton )
    

    def onMuteButtonToggle(f:(Boolean) => Any) = {
        muteButton.addActionListener( (e:ActionEvent) => f( muteButton.isSelected ) )
    }

    def onResetViewButton(f:(ActionEvent) => Any) = {
        resetViewButton.addActionListener( (e:ActionEvent) => f( e ) )
    }

    def setMuteButtonSelected(b:Boolean) = muteButton.setSelected( b )
}