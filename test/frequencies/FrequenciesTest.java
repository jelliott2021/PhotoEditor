package frequencies;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import model.IImage;
import model.ImageModel;
import model.Pixel;
import model.frequencies.Frequencies;

import static org.junit.Assert.assertEquals;

/**
 * Tests getting frequencies.
 */
public class FrequenciesTest {
  Pixel pxOne = new Pixel(241, 24, 41);
  Pixel pxTwo = new Pixel(255, 24, 44);
  Pixel pxThree = new Pixel(241, 24, 236);
  Pixel pxFour = new Pixel(4, 24, 35);

  Pixel[] row1 = new Pixel[]{pxOne, pxTwo};
  Pixel[] row2 = new Pixel[]{pxThree, pxFour};

  Pixel[][] img = new Pixel[][]{row1, row2};

  IImage coolImg = new ImageModel(img, "newImg");

  @Test
  public void testFreq() {
    Map<Integer, Integer> redFreqs = new HashMap<>();
    Map<Integer, Integer> greenFreqs = new HashMap<>();
    Map<Integer, Integer> blueFreqs = new HashMap<>();
    Map<Integer, Integer> intensityFreqs = new HashMap<>();

    for (int i = 0; i < 256; i += 1) {
      redFreqs.put(i, 0);
      blueFreqs.put(i, 0);
      greenFreqs.put(i, 0);
      intensityFreqs.put(i, 0);
    }

    redFreqs.put(241, 2);
    redFreqs.put(255, 1);
    redFreqs.put(4, 1);

    blueFreqs.put(41, 1);
    blueFreqs.put(44, 1);
    blueFreqs.put(236, 1);
    blueFreqs.put(35, 1);

    greenFreqs.put(24, 4);

    intensityFreqs.put(102, 1);
    intensityFreqs.put(107, 1);
    intensityFreqs.put(167, 1);
    intensityFreqs.put(21, 1);

    Map<Integer, Integer>[] arr = new Frequencies().getFrequencies(coolImg);
    Map<Integer, Integer> reds = arr[0];
    Map<Integer, Integer> greens = arr[1];
    Map<Integer, Integer> blues = arr[2];
    Map<Integer, Integer> intensities = arr[3];

    for (Map.Entry<Integer, Integer> pix : reds.entrySet()) {
      int compVal = pix.getKey();
      assertEquals(pix.getValue(), redFreqs.get(compVal));
    }

    for (Map.Entry<Integer, Integer> pix : blues.entrySet()) {
      int compVal = pix.getKey();
      assertEquals(pix.getValue(), blueFreqs.get(compVal));
    }

    for (Map.Entry<Integer, Integer> pix : greens.entrySet()) {
      int compVal = pix.getKey();
      assertEquals(pix.getValue(), greens.get(compVal));
    }

    for (Map.Entry<Integer, Integer> pix : intensities.entrySet()) {
      int compVal = pix.getKey();
      assertEquals(pix.getValue(), intensityFreqs.get(compVal));
    }
  }
}