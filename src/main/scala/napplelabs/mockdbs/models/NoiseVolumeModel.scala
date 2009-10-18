package napplelabs.mockdbs.models


import com.google.inject.{Inject, Singleton}
import napplelabs.mockdbs.BoundedObservable

@Singleton
class NoiseVolumeModel @Inject()() {
    val noiseVolume = new BoundedObservable[Double]( 0, 1, 0 )

    var lastVolume = noiseVolume.value
    var muted = false

    def setMuted( b:Boolean ) = {
        muted = b
        if(b) {
            lastVolume = noiseVolume.value
            noiseVolume.value = 0
        } else {
            noiseVolume.value = lastVolume
        }
    }

    def toggleMuted() = {muted = !muted; setMuted( muted )}
}
