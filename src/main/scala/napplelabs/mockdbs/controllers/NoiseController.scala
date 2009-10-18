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


import com.google.inject.Inject
import com.google.inject.Singleton
import java.awt.event.KeyEvent
import java.awt.{KeyboardFocusManager, KeyEventDispatcher}
import napplelabs.mockdbs.models.NoiseVolumeModel
import napplelabs.mockdbs.views.{BottomBarView, TopBarView}


@Singleton
class NoiseController @Inject()(
        bottomBarView:BottomBarView,
        topBarView:TopBarView,
        noiseVolumeModel:NoiseVolumeModel) {

    //Init view
    bottomBarView.setNoiseVolumeSliderValue( noiseVolumeModel.noiseVolume.value )
    bottomBarView.onNoiseVolumeSliderChange( volume => noiseVolumeModel.noiseVolume.value = volume )

    noiseVolumeModel.noiseVolume.addObserver( volume => bottomBarView.setNoiseVolumeSliderValue( volume ) )
    noiseVolumeModel.noiseVolume.addObserver( volume => topBarView.setMuteButtonSelected( volume <= 0 ) )

    topBarView.onMuteButtonToggle( muted => noiseVolumeModel.setMuted( muted ) )

}