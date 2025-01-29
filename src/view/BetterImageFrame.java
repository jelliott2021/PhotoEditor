package view;

import javax.swing.*;
import javax.swing.event.ChangeListener;


public class BetterImageFrame extends ImageFrame {
  private final JButton mosaic;
  private final JSpinner mosaicSpinner;
  private int mosaicFactor;


  public BetterImageFrame() {
    super("newImage");

    SpinnerNumberModel mosaicImg =
            new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
    this.mosaicSpinner = new JSpinner(mosaicImg);
    this.add(mosaicSpinner);
    ChangeListener changeBrightVal = (ChangeListener) e -> this.mosaicFactor =
            (int) mosaicSpinner.getValue();
    mosaicSpinner.addChangeListener(changeBrightVal);

    this.mosaic = new JButton("mosaic");
    this.mosaic.setActionCommand("mosaic button");
    this.add(mosaic);
    this.setVisible(true);
  }

  public JButton getMosaic() {
    return mosaic;
  }

  public int getMosaicFactor() {
    return mosaicFactor;
  }
}
