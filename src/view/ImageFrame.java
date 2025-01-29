package view;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;

import controller.ImageFeatures;
import controller.ImageLoad;
import controller.ImageSaver;
import controller.ImageUtil;
import controller.brightness.Brighten;
import controller.brightness.Darken;
import controller.filters.BlurCommand;
import controller.filters.SharpenCommand;
import controller.grey.Intensity;
import controller.grey.ValueScale;
import controller.miscellaneous.FlipHoriz;
import controller.miscellaneous.FlipVert;
import controller.transformations.BlueTransform;
import controller.transformations.GreenTransform;
import controller.transformations.LumaColorTransform;
import controller.transformations.RedTransform;
import controller.transformations.SepiaTransform;
import model.IImage;

/**
 * Creates an ImagePanel to put our image and buttons on.
 */
public class ImageFrame extends JFrame {
  private IImage currImage;
  private final JLabel imgLabel;
  private final String name;
  private final JButton redScale;
  private final JButton blueScale;
  private final JButton greenScale;
  private final JButton valueScale;
  private final JButton intensityScale;
  private final JButton flipHoriz;
  private final JButton flipVert;
  private final JButton luma;
  private final JButton blur;
  private final JButton sharpen;
  private final JButton sepia;
  private final JButton load;
  private final JButton save;
  private final JButton brighten;
  private final JSpinner brightenSpinner;
  private final JSpinner darkenSpinner;
  private final JButton darken;
  private int brightenFactor;
  private int darkenFactor;
  private JPanel histogram;
  private final JScrollPane panel;
  
  /**
   * Creates a new frame to put all the imaging process operations on.
   * @param name the name to refer to an image as.
   */
  public ImageFrame(String name) {
    this.name = name;
    this.setLayout(new FlowLayout());
    imgLabel = new JLabel();
    JScrollPane pane = new JScrollPane();
    pane.setPreferredSize(new Dimension(700, 700));
    pane.setViewportView(imgLabel);
    pane.setVisible(true);
    this.add(pane);

    panel = new JScrollPane();
    panel.setPreferredSize(new Dimension(300, 300));
    panel.setViewportView(this.histogram);
    panel.setVisible(true);
    this.add(panel);


    this.setDefaultCloseOperation(3);
    this.setVisible(true);

    SpinnerNumberModel brightenImg =
            new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    this.brightenSpinner = new JSpinner(brightenImg);
    this.add(brightenSpinner);
    ChangeListener changeBrightVal = (ChangeListener) e -> this.brightenFactor =
            (int) brightenSpinner.getValue();
    brightenSpinner.addChangeListener(changeBrightVal);
    this.setVisible(true);

    SpinnerNumberModel darkenImg =
            new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    this.darkenSpinner = new JSpinner(darkenImg);
    this.add(darkenSpinner);
    ChangeListener changeDarkVal = (ChangeListener) e -> this.darkenFactor =
            (int) darkenSpinner.getValue();
    darkenSpinner.addChangeListener(changeDarkVal);
    this.setVisible(true);

    this.redScale = new JButton("Red-visualize");
    this.redScale.setActionCommand("Red-scale button");
    this.add(redScale);

    this.blueScale = new JButton("Blue-visualize");
    this.blueScale.setActionCommand("Blue-scale button");
    this.add(blueScale);

    this.greenScale = new JButton("Green-visualize");
    this.greenScale.setActionCommand("Green-scale button");
    this.add(greenScale);

    this.valueScale = new JButton("Value-visualize");
    this.valueScale.setActionCommand("Value-scale button");
    this.add(valueScale);

    this.intensityScale = new JButton("Intensity-visualize");
    this.intensityScale.setActionCommand("Intensity-scale button");
    this.add(intensityScale);

    this.luma = new JButton("Luma-visualize");
    this.luma.setActionCommand("Luma button");
    this.add(luma);

    this.blur = new JButton("Blur");
    this.blur.setActionCommand("Blur button");
    this.add(blur);

    this.sharpen = new JButton("Sharpen");
    this.sharpen.setActionCommand("Sharpen button");
    this.add(sharpen);

    this.sepia = new JButton("Sepia");
    this.sepia.setActionCommand("Sepia button");
    this.add(sepia);

    this.flipHoriz = new JButton("Flip horizontally");
    this.flipHoriz.setActionCommand("Flip horiz button");
    this.add(flipHoriz);

    this.flipVert = new JButton("Flip vertically");
    this.flipVert.setActionCommand("Flip vert button");
    this.add(flipVert);

    this.brighten = new JButton("Brighten");
    this.brighten.setActionCommand("Brighten button");
    this.add(brighten);

    this.darken = new JButton("Darken");
    this.darken.setActionCommand("Darken button");
    this.add(darken);

    this.load = new JButton("Load");
    this.load.setActionCommand("Load buttton");
    this.add(load);

    this.save = new JButton("Save");
    this.save.setActionCommand("Save button");
    this.add(save);

    this.setMinimumSize(new Dimension(800, 800));
  }

  public void updateScreen(IImage img) {
    this.currImage = img;
    BufferedImage newBuff =  ImageUtil.createBufferedImage(currImage);
    imgLabel.setIcon(new ImageIcon(newBuff));
    this.histogram = new HistogramPanel(img);
    this.panel.setViewportView(this.histogram);
  }

  public void renderMessage(String message) {
    JLabel messenger = new JLabel();
    messenger.setText(message);
    messenger.setVisible(true);
    this.add(messenger);
  }

  public JButton getRedScale() {
    return redScale;
  }

  public JButton getBlueScale() {
    return blueScale;
  }

  public JButton getGreenScale() {
    return greenScale;
  }

  public JButton getValueScale() {
    return valueScale;
  }

  public JButton getIntensityScale() {
    return intensityScale;
  }

  public JButton getFlipHoriz() {
    return flipHoriz;
  }

  public JButton getFlipVert() {
    return flipVert;
  }

  public JButton getLuma() {
    return luma;
  }

  public JButton getBlur() {
    return blur;
  }

  public JButton getSharpen() {
    return sharpen;
  }

  public JButton getSepia() {
    return sepia;
  }

  public JButton getLoad() {
    return load;
  }

  public JButton getSave() {
    return save;
  }

  public JButton getBrighten() {
    return brighten;
  }

  public JButton getDarken() {
    return darken;
  }

  public int getBrightenFactor() {
    return brightenFactor;
  }

  public int getDarkenFactor() {
    return darkenFactor;
  }
}
