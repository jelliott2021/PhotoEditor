package model.frequencies;

import java.util.HashMap;
import java.util.Map;

import model.IImage;
import model.IPixel;

/**
 * Gathers the frequencies of all the pixel components  in an image.
 */
public class Frequencies implements FrequencyCollector {

  @Override
  public Map<Integer, Integer>[] getFrequencies(IImage image) {
    Map<Integer, Integer> redHistogram = new HashMap<>();
    Map<Integer, Integer> blueHistogram = new HashMap<>();
    Map<Integer, Integer> greenHistogram = new HashMap<>();
    Map<Integer, Integer> intensityHistogram = new HashMap<>();

    for (int i = 0; i < 256; i += 1) {
      redHistogram.put(i, 0);
      blueHistogram.put(i, 0);
      greenHistogram.put(i, 0);
      intensityHistogram.put(i, 0);
    }

    for (int i = 0; i < image.getHeight(); i += 1) {
      for (int j = 0; j < image.getWidth(); j += 1) {
        IPixel pix = image.getPixelAt(i, j);
        int redVal = (int) pix.getRed();
        int greenVal = (int) pix.getGreen();
        int blueVal = (int) pix.getBlue();
        int intensityVal = (int) pix.getIntensity();

        int currRed = redHistogram.get(redVal);
        int currGreen = greenHistogram.get(greenVal);
        int currBlue = greenHistogram.get(blueVal);
        int currIntensity = greenHistogram.get(intensityVal);

        redHistogram.put(redVal, currRed + 1);
        greenHistogram.put(greenVal, currGreen + 1);
        blueHistogram.put(blueVal, currBlue + 1);
        intensityHistogram.put(intensityVal, currIntensity + 1);
      }
    }

    return (Map<Integer, Integer>[])
            new Map[]{redHistogram, greenHistogram, blueHistogram, intensityHistogram};
  }
}
