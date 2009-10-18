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


import com.explodingpixels.macwidgets.{BottomBarSize, BottomBar}
import com.explodingpixels.swingx.EPPanel
import com.google.inject.Inject
import com.google.inject.Singleton
import java.awt.{FlowLayout, Font}
import java.lang.Runnable
import java.text.DecimalFormat
import javax.swing.event.{ChangeListener, ChangeEvent}
import javax.swing.{JPanel, JSlider, SwingUtilities, JLabel}


@Singleton
class BottomBarView @Inject()() {
    val bottomBar = new BottomBar( BottomBarSize.LARGE );
    val formatter = new DecimalFormat( "0.00 mm" )

    //Depth Label
    val label = new JLabel( formatter.format( 0.0 ) )
    label.setFont( new Font( "Arial", Font.PLAIN, 30 ) )
    bottomBar.addComponentToCenter( label );

    val noisePanel = new EPPanel()
    val fl = new FlowLayout
    fl.setHgap( 1 )

    noisePanel.setLayout( fl )
    val noiseLabel = new JLabel( "Noise" )
    val noiseSlider = new JSlider()

    noisePanel.add( noiseLabel )
    noisePanel.add( noiseSlider )
    bottomBar.addComponentToRight( noisePanel )

    def setDepth(d:Double) = {
        label.setText( formatter.format( d ) )
    }

    def setNoiseVolumeSliderValue(d:Double) = {
        noiseSlider.setValue( (d * 100).asInstanceOf[Int] )
    }

    def onNoiseVolumeSliderChange(f:(Double) => Any) = {
        noiseSlider.addChangeListener( new ChangeListener() {
            override def stateChanged(e:ChangeEvent) = f( noiseSlider.getValue.asInstanceOf[Double] / 100 )
        } )
    }
}