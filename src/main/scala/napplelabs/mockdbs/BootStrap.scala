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


import com.explodingpixels.macwidgets.{UnifiedToolBar}
import com.google.inject.{Guice, AbstractModule}
import controllers.{CanvasController, GlobalKeyController, NoiseController, DepthController}
import javax.swing.SwingUtilities
import models.{NoiseGenerator, NoiseVolumeModel, DepthModel}
import views.{CanvasView, TopBarView, BottomBarView, MacFrame}

object BootStrap extends Application {
    val i = Guice.createInjector( new AbstractModule() {
        override def configure() {

        }
    } )
    //    SwingUtilities.invokeLater( new Runnable() {
    //        override def run = {
    val frame = new MacFrame( "MockDBS" )

    val toolbar = new UnifiedToolBar
    toolbar.installWindowDraggerOnWindow( frame.frame )

    //Instantiate Models
    val depthModel = new DepthModel
    val noiseVolumeModel = new NoiseVolumeModel
    val noiseGenerator = new NoiseGenerator( noiseVolumeModel )

    val bottomBarView = new BottomBarView
    val topBarView = new TopBarView( toolbar )
    val canvasView = new CanvasView

    val depthController = new DepthController( depthModel, bottomBarView )
    val noiseController = new NoiseController( bottomBarView, topBarView, noiseVolumeModel )
    val globalKeyController = new GlobalKeyController( noiseVolumeModel, depthModel )
    val canvasController = new CanvasController( canvasView, topBarView, depthModel )

    frame.setTopBar( toolbar )
    frame.setBottomBar( bottomBarView.bottomBar )
    frame.setContent( canvasView.getComponent )
    frame.setVisible( true )
    canvasView.centerView
    //        }
    //    } )


}