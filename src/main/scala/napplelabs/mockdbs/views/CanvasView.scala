package napplelabs.mockdbs.views

import java.awt.BorderLayout
import edu.umd.cs.piccolo.{PLayer, PCanvas}
import napplelabs.mockdbs.piccolo.{NapPZoomEventHandler, Probe}
import edu.umd.cs.piccolo.util.PPaintContext
import edu.umd.cs.piccolo.nodes.PPath
import javax.swing.{JScrollBar, JPanel}
import edu.umd.cs.piccolox.pswing.PSwing

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

    component.setLayout( new BorderLayout )

    component.add( canvas, BorderLayout.CENTER )

    val backgroundLayer = new PLayer
    canvas.getCamera.addLayer( 1, backgroundLayer )
    canvas.setZoomEventHandler( new NapPZoomEventHandler )
    canvas.setAnimatingRenderQuality( PPaintContext.HIGH_QUALITY_RENDERING );
    canvas.setInteractingRenderQuality( PPaintContext.HIGH_QUALITY_RENDERING );

    val probe = new Probe

    probe.rotate( Math.Pi / 360 * 45 );

    backgroundLayer.addChild( probe )

    val scroll = new JScrollBar()

    val swingNode = new PSwing(scroll)

    backgroundLayer.addChild(swingNode)

    def centerView = {
        canvas.getCamera.setViewOffset(component.getWidth/2, component.getHeight/2)
        canvas.getCamera.setViewScale(1)
    }

    /**
     * Depth in mm
     */
    def setProbeDepth(depth:Double) = {
        println("SETTING DEPTH: " + depth)
        probe.setDepth(depth)
        canvas.repaint()
    }
}
