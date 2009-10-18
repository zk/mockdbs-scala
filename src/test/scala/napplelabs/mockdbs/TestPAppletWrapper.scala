package napplelabs.mockdbs


import _root_.processing.core.PApplet
import org.junit.Test
import org.junit.Assert._
import processing.PAppletWrapper

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 11, 2009
 * Time: 2:58:39 PM
 * To change this template use File | Settings | File Templates.
 */

class TestPAppletWrapper {
  @Test def testCreatePAppletWrapper = {
    val paw = new PAppletWrapper(new PApplet())

    assertNotNull(paw)
  }
}