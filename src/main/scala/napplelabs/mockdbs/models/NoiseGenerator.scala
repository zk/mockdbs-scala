package napplelabs.mockdbs.models


import _root_.processing.core.PApplet
import ddf.minim.Minim
import ddf.minim.signals.PinkNoise

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 16, 2009
 * Time: 12:38:29 AM
 * To change this template use File | Settings | File Templates.
 */

class NoiseGenerator(nv:NoiseVolumeModel) {
  val minim = new Minim(new PApplet())
  val out = minim.getLineOut(Minim.MONO)
  val pink = new PinkNoise(nv.noiseVolume.value.asInstanceOf[Float])
  out.addSignal(pink)

  nv.noiseVolume.addObserver((v:Double) => pink.setAmp(v.asInstanceOf[Float]))
}