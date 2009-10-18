package napplelabs.mockdbs.controllers


import com.google.inject.Inject
import com.google.inject.Singleton
import java.awt.event.KeyEvent
import java.awt.{KeyboardFocusManager, KeyEventDispatcher}
import napplelabs.mockdbs.models.NoiseVolumeModel
import napplelabs.mockdbs.views.{BottomBarView, TopBarView}

/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 13, 2009
 * Time: 8:38:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Singleton
class NoiseController @Inject()(
        bottomBarView: BottomBarView,
        topBarView: TopBarView,
        noiseVolumeModel: NoiseVolumeModel) {

    //Init view
    bottomBarView.setNoiseVolumeSliderValue( noiseVolumeModel.noiseVolume.value )
    bottomBarView.onNoiseVolumeSliderChange( volume => noiseVolumeModel.noiseVolume.value = volume )

    noiseVolumeModel.noiseVolume.addObserver( volume => bottomBarView.setNoiseVolumeSliderValue(volume) )
    noiseVolumeModel.noiseVolume.addObserver( volume => topBarView.setMuteButtonSelected(volume <= 0) )

    topBarView.onMuteButtonToggle( muted => noiseVolumeModel.setMuted(muted) )

}