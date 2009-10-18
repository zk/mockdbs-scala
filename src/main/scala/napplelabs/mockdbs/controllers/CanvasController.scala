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
package napplelabs.mockdbs.controllers

import napplelabs.mockdbs.views.{TopBarView, CanvasView}
import napplelabs.mockdbs.models.DepthModel
import napplelabs.mockdbs.piccolo.NeuronPath
import java.awt.Color
import edu.umd.cs.piccolo.event.{PInputEvent, PDragSequenceEventHandler}
import edu.umd.cs.piccolo.PNode

class CanvasController(canvasView:CanvasView, topBarView:TopBarView, depthModel:DepthModel) {
    topBarView.onResetViewButton( e => canvasView.centerView )
    depthModel.depthObs.addObserver( depth => canvasView.setProbeDepth( depth ) )
    canvasView.addNeuron( new NeuronPath( Color.GRAY ) )

    canvasView.getCanvas.addInputEventListener( new PDragSequenceEventHandler() {
        override def drag(e:PInputEvent) = {
            val neuron = {
                def findNeuron(n:PNode):NeuronPath = {
                    n.getParent match {
                        case null => null
                        case n if (n.isInstanceOf[NeuronPath]) => n.asInstanceOf[NeuronPath]
                        case _ => findNeuron( n.getParent )
                    }
                }

                findNeuron( e.getPickedNode )
            }

            if (neuron != null) {
                neuron.translate( e.getDelta.width, e.getDelta.height )
                e.setHandled( true )
            }

        }
    } )
}