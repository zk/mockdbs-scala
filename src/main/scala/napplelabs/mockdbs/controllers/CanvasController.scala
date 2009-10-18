package napplelabs.mockdbs.controllers

import napplelabs.mockdbs.views.{TopBarView, CanvasView}
import napplelabs.mockdbs.models.DepthModel

/**
 * Created by IntelliJ IDEA.           o
 * User: zkim
 * Date: Oct 17, 2009
 * Time: 8:22:52 PM
 * To change this template use File | Settings | File Templates.
 */

class CanvasController(canvasView:CanvasView, topBarView:TopBarView, depthModel: DepthModel) {
    topBarView.onResetViewButton(e => canvasView.centerView)

    depthModel.depthObs.addObserver(depth => canvasView.setProbeDepth(depth))
}