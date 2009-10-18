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
package napplelabs.mockdbs.controllers

import java.awt.event.KeyEvent
import java.awt.{KeyboardFocusManager, KeyEventDispatcher}
import org.slf4j.{LoggerFactory}
import napplelabs.mockdbs.models.{DepthModel, NoiseVolumeModel}


class GlobalKeyController(nm:NoiseVolumeModel, dm:DepthModel) {
    val log = LoggerFactory.getLogger( classOf[GlobalKeyController] )
    KeyboardFocusManager.getCurrentKeyboardFocusManager.addKeyEventDispatcher( new KeyEventDispatcher() {
        override def dispatchKeyEvent(e:KeyEvent):Boolean = {
            if (e.getID == KeyEvent.KEY_PRESSED) {
                e.getKeyCode match {
                    case 37 => nm.noiseVolume.value = nm.noiseVolume.value - 0.01 //Left
                    case 39 => nm.noiseVolume.value = nm.noiseVolume.value + 0.01 //Right
                    case 40 => dm.depthObs.value = dm.depthObs.value - 0.01 //Down
                    case 38 => dm.depthObs.value = dm.depthObs.value + 0.01 //Up
                    case 77 => checkMute( e )
                    case k:Int => log.debug( "Key: " + k )
                }
            }
            true
        }
    } );

    def checkMute(e:KeyEvent) = {
        if (e.isMetaDown) {
            nm.toggleMuted()
        }
    }
}