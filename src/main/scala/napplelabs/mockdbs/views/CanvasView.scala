package napplelabs.mockdbs.views

import java.awt.BorderLayout
import edu.umd.cs.piccolo.{PLayer, PCanvas}
import edu.umd.cs.piccolo.util.PPaintContext
import edu.umd.cs.piccolo.nodes.PPath
import edu.umd.cs.piccolox.pswing.PSwing
import javax.swing.{JSlider, JScrollBar, JPanel}
import napplelabs.mockdbs.piccolo.{NeuronPath, NapPZoomEventHandler, Probe}

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 17, 2009
 * Time: 6:38:23 PM
 * To change this template use File | Settings | File Templates.
 */

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

    //def addNeuron(n:NeuronPath) = foregroundLayer.addChild(n)
    //def removeNeuron(n:NeuronPath) = foregroundLayer.removeChild(n)

    def addNeuron(n:NeuronPath) = canvas.getLayer.addChild(n)
    def removeNeuron(n:NeuronPath) = canvas.getLayer.removeChild(n)

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
