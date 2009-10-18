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
package napplelabs.mockdbs.models


import _root_.processing.core.PApplet
import ddf.minim.Minim
import ddf.minim.signals.PinkNoise


class NoiseGenerator(nv:NoiseVolumeModel) {
    val minim = new Minim( new PApplet() )
    val out = minim.getLineOut( Minim.MONO )
    val pink = new PinkNoise( nv.noiseVolume.value.asInstanceOf[Float] )
    out.addSignal( pink )

    nv.noiseVolume.addObserver( (v:Double) => pink.setAmp( v.asInstanceOf[Float] ) )
}