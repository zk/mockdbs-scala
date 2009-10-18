package napplelabs.mockdbs.controllers

import com.google.inject.Inject
import napplelabs.mockdbs.models.DepthModel
import napplelabs.mockdbs.views.BottomBarView

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 11, 2009
 * Time: 8:03:25 PM
 * To change this template use File | Settings | File Templates.
 */

class DepthController @Inject()(dm:DepthModel, bv:BottomBarView) {
    dm.depthObs.addObserver( (d:Double) => bv.setDepth( d ) )
}