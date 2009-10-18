package napplelabs.mockdbs


import org.junit.Test
import org.junit.Assert._
import org.scalatest.junit.AssertionsForJUnit

class TestBoundedObservable extends AssertionsForJUnit {
  @Test def testBoundedObservableDouble() {
    val nv = new BoundedObservable[Double](0, 1, 0.5);
    assertEquals(0.5, nv.value, 0.0001)
    nv.value = -10
    assertEquals(0, nv.value, 0.0001)

    nv.value = 1000
    assertEquals(1, nv.value, 0.0001)
  }
}