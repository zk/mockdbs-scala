package napplelabs.mockdbs.processing

import _root_.processing.core.PApplet

/**
 * Manages the lifecycle of a PApplet
 */
class PAppletWrapper(private[this] val pa: PApplet) {
  def get = pa
}
