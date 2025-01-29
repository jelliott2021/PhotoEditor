package view;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Map;
import java.util.Objects;

import javax.swing.JPanel;

import model.IImage;
import model.frequencies.Frequencies;

/**
 * Represents a panel that contains a histogram of components.
 */
public class HistogramPanel extends JPanel {
  private final Map<Integer, Integer> redFreq;
  private final Map<Integer, Integer> blueFreq;
  private final Map<Integer, Integer> greenFreq;
  private final Map<Integer, Integer> intensityFreq;
  private final IImage img;

  /**
   * Creates a panel to contain the histogram given an image to analyze.
   * @param image the image to analyze and make a histogram with.
   */
  public HistogramPanel(IImage image) {
    this.img = Objects.requireNonNull(image);
    Map<Integer, Integer>[] mapped = new Frequencies().getFrequencies(image);
    this.redFreq = mapped[0];
    this.greenFreq = mapped[1];
    this.blueFreq = mapped[2];
    this.intensityFreq = mapped[3];
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.black);
    g.drawLine(3, 300, 300, 300 - this.img.getHeight() * this.img.getWidth());
    g.drawLine(3, 300, 258, 300);

    g.setColor(Color.red);
    for (Map.Entry<Integer, Integer> pix : redFreq.entrySet()) {
      g.drawLine(3 + pix.getKey(), 300, 3 + pix.getKey(), 300 - pix.getValue());
    }

    g.setColor(Color.green);
    for (Map.Entry<Integer, Integer> pix : greenFreq.entrySet()) {
      g.drawLine(3 + pix.getKey(), 300, 3 + pix.getKey(), 300 - pix.getValue());
    }

    g.setColor(Color.blue);
    for (Map.Entry<Integer, Integer> pix : blueFreq.entrySet()) {
      g.drawLine(3 + pix.getKey(), 300, 3 + pix.getKey(), 300 - pix.getValue());
    }

    g.setColor(Color.yellow);
    for (Map.Entry<Integer, Integer> pix : intensityFreq.entrySet()) {
      g.drawLine(3 + pix.getKey(), 300, 3 + pix.getKey(), 300 - pix.getValue());
    }
  }
}
