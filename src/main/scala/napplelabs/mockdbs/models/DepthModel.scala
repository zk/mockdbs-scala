package napplelabs.mockdbs.models

import com.google.inject.Inject
import napplelabs.mockdbs.Observable

class DepthModel @Inject() () {
  val depthObs : Observable[Double] = new Observable[Double](0)
}


