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
import napplelabs.mockdbs.models.DepthModel
import napplelabs.mockdbs.views.BottomBarView


class DepthController @Inject()(dm:DepthModel, bv:BottomBarView) {
    dm.depthObs.addObserver( (d:Double) => bv.setDepth( d ) )
}