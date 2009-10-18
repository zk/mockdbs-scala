package napplelabs.mockdbs.controllers

import java.awt.event.KeyEvent
import java.awt.{KeyboardFocusManager, KeyEventDispatcher}
import org.slf4j.{LoggerFactory}
import napplelabs.mockdbs.models.{DepthModel, NoiseVolumeModel}

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 17, 2009
 * Time: 3:05:24 PM
 * To change this template use File | Settings | File Templates.
 */

class GlobalKeyController(nm:NoiseVolumeModel, dm: DepthModel) {
    val log = LoggerFactory.getLogger( classOf[GlobalKeyController] )
    KeyboardFocusManager.getCurrentKeyboardFocusManager.addKeyEventDispatcher( new KeyEventDispatcher() {
        override def dispatchKeyEvent(e:KeyEvent):Boolean = {
            if(e.getID == KeyEvent.KEY_PRESSED) {
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
        if(e.isMetaDown) {
            nm.toggleMuted()
        }
    }
}