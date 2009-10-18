package napplelabs.mockdbs.views


import com.explodingpixels.macwidgets.{BottomBarSize, BottomBar}
import com.explodingpixels.swingx.EPPanel
import com.google.inject.Inject
import com.google.inject.Singleton
import java.awt.{FlowLayout, Font}
import java.lang.Runnable
import java.text.DecimalFormat
import javax.swing.event.{ChangeListener, ChangeEvent}
import javax.swing.{JPanel, JSlider, SwingUtilities, JLabel}
/**
 * Created by IntelliJ IDEA.
 * User: zkim
 * Date: Oct 11, 2009
 * Time: 8:08:58 PM
 * To change this template use File | Settings | File Templates.
 */


@Singleton
class BottomBarView @Inject()() {
  val bottomBar = new BottomBar(BottomBarSize.LARGE);
  val formatter = new DecimalFormat("0.00 mm")

  //Depth Label
  val label = new JLabel(formatter.format(0.0))
  label.setFont(new Font("Arial", Font.PLAIN, 30))
  bottomBar.addComponentToCenter(label);

  val noisePanel = new EPPanel()
  val fl = new FlowLayout
  fl.setHgap(1)
  
  noisePanel.setLayout(fl)
  val noiseLabel = new JLabel("Noise")
  val noiseSlider = new JSlider()

  noisePanel.add(noiseLabel)
  noisePanel.add(noiseSlider)
  bottomBar.addComponentToRight(noisePanel)

  def setDepth(d: Double) = {
    label.setText(formatter.format(d))
  }

  def setNoiseVolumeSliderValue(d:Double) = {
    noiseSlider.setValue( (d * 100).asInstanceOf[Int])
  }
  def onNoiseVolumeSliderChange(f:(Double) => Any) = {
    noiseSlider.addChangeListener(new ChangeListener() {
      override def stateChanged(e: ChangeEvent) = f(noiseSlider.getValue.asInstanceOf[Double] / 100)
    })
  }
}