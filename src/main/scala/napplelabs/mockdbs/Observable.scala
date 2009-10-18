package napplelabs.mockdbs

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 13, 2009
 * Time: 7:37:32 PM
 * To change this template use File | Settings | File Templates.
 */


class Observable[T](private var member:T) {

  def value : T = member
  def value_=(t:T) = {
    if(t != member) {
      member = t;
      update(member)
    }
  }

  private var observers = List[(T) => Any]()

  def addObserver(f: (T) => Any) = observers = f :: observers
  def removeObserver(f:(T) => Any) = observers = observers - f
  def update(t:T) = {
    observers.foreach { _(t) }
  }
  
}

class BoundedObservable[T <% Ordered[T]](lowBound:T, highBound:T, default:T)
        extends Observable[T](default) {
  override def value_=(t:T) = {
    t match {
      case x:T if x < lowBound => super.value = lowBound
      case x:T if x > highBound => super.value = highBound
      case x:T => super.value = t
    }
  }
}