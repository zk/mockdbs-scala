package napplelabs.mockdbs


import mockdbs.Observable
import org.junit.Test
import org.junit.Assert._
import org.scalatest.junit.AssertionsForJUnit

class TestObservable extends AssertionsForJUnit {
  @Test def testObservableInt() {
    var x = 0;
    val f = (i:Int) => (x = i)

    val obs = new Observable[Int](0)
    obs.addObserver(f)

    obs.value = 12;

    assertEquals(12, x)
  }

  case class ComplexObservable(var x:String, var y:Int)

  @Test def testComplexObservable = {
    var x = ComplexObservable("hello", 1)
    val f = (i:ComplexObservable) => { x.x = i.x; x.y = i.y }

    val obs = new Observable[ComplexObservable](ComplexObservable("Blah!!!", -1))
    obs.addObserver(f)

    obs.value = ComplexObservable("world", 2)

    assertEquals("world", x.x)
    assertEquals(2, x.y)
  }
}