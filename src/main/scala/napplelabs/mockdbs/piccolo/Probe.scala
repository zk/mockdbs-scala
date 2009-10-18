package napplelabs.mockdbs.piccolo

import edu.umd.cs.piccolo.PNode
import java.awt.geom.Point2D
import edu.umd.cs.piccolo.nodes.{PText, PPath}
import java.awt.{Font, Color, BasicStroke}

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 17, 2009
 * Time: 6:52:09 PM
 * To change this template use File | Settings | File Templates.
 */

class Probe extends PNode {
    val track = PPath.createLine( 0, -1000, 0, 2000 )
    track.setStroke( new BasicStroke( 3 ) );
    track.setPaint( Color.lightGray );
    track.setStrokePaint( Color.lightGray );

    val probe = PPath.createLine( 0, 0, 0, -3000 )
    //probe.setOffset( new Point2D.Double( 0, -2000 ) )
    probe.setStroke( new BasicStroke( 5 ) );

    addChild( track )
    addChild( probe )

    /**
     * in mm
     */
    def setDepth(depth:Double) = {
        probe.setOffset( 0, -depth * 100 )
    }


    ( -10 to 20 ).foreach {
        i =>
                val t = new PText( -i + "mm" );
                t.setFont( new Font( "Arial", Font.PLAIN, 16 ) );
                t.setOffset( new Point2D.Double( 30, i * 100 ) );
                t.setTextPaint( Color.lightGray );
                addChild( t );

//                ( 1 until 5 ).foreach {
//                    tick =>
//                            val tm = new PText( "-" );
//                            tm.setFont( new Font( "Arial", Font.PLAIN, 16 ) );
//                            tm.setOffset( new Point2D.Double( 40, (i * 100) + (tick * 10) + 3 ) );
//                            tm.setTextPaint( Color.lightGray );
//                            addChild(tm)
//                }
    }

}