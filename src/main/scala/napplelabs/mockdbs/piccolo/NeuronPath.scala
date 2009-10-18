package napplelabs.mockdbs.piccolo

import edu.umd.cs.piccolo.nodes.PPath
import java.awt.Color
import edu.umd.cs.piccolo.PNode

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 18, 2009
 * Time: 4:22:12 PM
 * To change this template use File | Settings | File Templates.
 */

class NeuronPath(color:Color) extends PNode {
    
    val d = 50f
    val path:PPath = PPath.createEllipse( -d / 2, -d / 2, d, d )
    val c = new Color(color.getRed, color.getGreen, color.getBlue, 190)
    path.setPaint(c)

    addChild(path)
}