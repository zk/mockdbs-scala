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
package napplelabs.mockdbs.piccolo

import edu.umd.cs.piccolo.PNode
import java.awt.geom.Point2D
import edu.umd.cs.piccolo.nodes.{PText, PPath}
import java.awt.{Font, Color, BasicStroke}

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


    (-20 to 10).foreach {
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