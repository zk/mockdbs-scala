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

import java.awt.BorderLayout
import edu.umd.cs.piccolo.{PLayer, PCanvas}
import edu.umd.cs.piccolo.util.PPaintContext
import edu.umd.cs.piccolo.nodes.PPath
import edu.umd.cs.piccolox.pswing.PSwing
import javax.swing.{JSlider, JScrollBar, JPanel}
import napplelabs.mockdbs.piccolo.{NeuronPath, NapPZoomEventHandler, Probe, BirdsEyeView}



class CanvasView() {
    private val component = new JPanel

    def getComponent = component

    private val canvas = new PCanvas

    def getCanvas = canvas

    component.setLayout( new BorderLayout )

    component.add( canvas, BorderLayout.CENTER )

    val backgroundLayer = new PLayer
    val foregroundLayer = new PLayer

    canvas.getCamera.addLayer( 1, backgroundLayer )
    //canvas.getCamera.addLayer( 2, foregroundLayer )
    canvas.setZoomEventHandler( new NapPZoomEventHandler )
    canvas.setAnimatingRenderQuality( PPaintContext.HIGH_QUALITY_RENDERING );
    canvas.setInteractingRenderQuality( PPaintContext.HIGH_QUALITY_RENDERING );

    val probe = new Probe

    probe.rotate( Math.Pi / 360 * 45 );

    backgroundLayer.addChild( probe )
    
    val birdsEyeView = new BirdsEyeView() 

    //def addNeuron(n:NeuronPath) = foregroundLayer.addChild(n)
    //def removeNeuron(n:NeuronPath) = foregroundLayer.removeChild(n)

    def addNeuron(n:NeuronPath) = canvas.getLayer.addChild( n )

    def removeNeuron(n:NeuronPath) = canvas.getLayer.removeChild( n )

    def centerView = {
        canvas.getCamera.setViewOffset( component.getWidth / 2, component.getHeight / 2 )
        canvas.getCamera.setViewScale( 1 )
    }

    /**
     * Depth in mm
     */
    def setProbeDepth(depth:Double) = {
        println( "SETTING DEPTH: " + depth )
        probe.setDepth( depth )
        canvas.repaint()
    }
}
