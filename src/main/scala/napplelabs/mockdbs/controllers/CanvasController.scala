package napplelabs.mockdbs.controllers

import napplelabs.mockdbs.views.{TopBarView, CanvasView}
import napplelabs.mockdbs.models.DepthModel
import napplelabs.mockdbs.piccolo.NeuronPath
import java.awt.Color
import edu.umd.cs.piccolo.event.{PInputEvent, PDragSequenceEventHandler}
import edu.umd.cs.piccolo.PNode

class CanvasController(canvasView:CanvasView, topBarView:TopBarView, depthModel: DepthModel) {
    topBarView.onResetViewButton(e => canvasView.centerView)
    depthModel.depthObs.addObserver(depth => canvasView.setProbeDepth(depth))
    canvasView.addNeuron(new NeuronPath(Color.GRAY))

    canvasView.getCanvas.addInputEventListener(new PDragSequenceEventHandler() {

        getEventFilter.setMarksAcceptedEventsAsHandled(true)

        override def drag(e:PInputEvent) = {
            val neuron = {
                def findNeuron(n: PNode) : NeuronPath = {
                    n.getParent match {
                        case null => null
                        case n if(n.isInstanceOf[NeuronPath]) => n.asInstanceOf[NeuronPath]
                        case _ => findNeuron(n.getParent)
                    }
                }

                findNeuron(e.getPickedNode)  
            }

            if(neuron != null) {
                neuron.translate(e.getDelta.width, e.getDelta.height)
            }
            
        }
    })
}