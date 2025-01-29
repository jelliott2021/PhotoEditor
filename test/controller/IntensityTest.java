package controller;

import org.junit.Test;

import controller.grey.Intensity;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our intensity scale command.
 */
public class IntensityTest {

  @Test
  public void testValue() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    ImageModel mod = new ImageModel(arrImage, "rainbow");

    ImageCommand intensity = new Intensity();
    IImage newMod = intensity.process(mod, "rainbow");

    Pixel pxOneI = new Pixel(91.67, 91.67, 91.67);
    Pixel pxTwoI = new Pixel(85, 85, 85);
    Pixel pxThreeI = new Pixel(169.33, 169.33, 169.33);
    Pixel pxFourI = new Pixel(157.33, 157.33, 157.33);

    Pixel[] rowOneI = new Pixel[]{pxOneI, pxTwoI};
    Pixel[] rowTwoI = new Pixel[]{pxThreeI, pxFourI};

    Pixel[][] arrImageB = new Pixel[][]{rowOneI, rowTwoI};
    IImage modB = new ImageModel(arrImageB, "rainbow intensity-visualized");

    assertEquals(modB, newMod);
  }
}

