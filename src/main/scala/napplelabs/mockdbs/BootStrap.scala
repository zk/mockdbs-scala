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
            val frame = new MacFrame("MockDBS")

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