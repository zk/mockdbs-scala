/*
	MockDBS: Deep Brain Stimulation Simulator
    Copyright (C) 2009 Zachary Kim

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package napplelabs.mockdbs


class Observable[T](private var member:T) {
    def value:T = member

    def value_=(t:T) = {
        if (t != member) {
            member = t;
            update( member )
        }
    }

    private var observers = List[(T) => Any]()

    def addObserver(f:(T) => Any) = observers = f :: observers

    def removeObserver(f:(T) => Any) = observers = observers - f

    def update(t:T) = {
        observers.foreach {_( t )}
    }

}

class BoundedObservable[T <% Ordered[T]](lowBound:T, highBound:T, default:T)
        extends Observable[T]( default ) {
    override def value_=(t:T) = {
        t match {
            case x:T if x < lowBound => super.value = lowBound
            case x:T if x > highBound => super.value = highBound
            case x:T => super.value = t
        }
    }
}