package napplelabs.mockdbs.implicits


import java.awt.event.{ActionListener, ActionEvent}

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 11, 2009
 * Time: 7:54:03 PM
 * To change this template use File | Settings | File Templates.
 */

object SwingImplicits {
  implicit def closure2ActionListener(f: (ActionEvent) => Any): ActionListener = new ActionListener() {
    override def actionPerformed(e: ActionEvent) {
      f(e);
    }
  }
}