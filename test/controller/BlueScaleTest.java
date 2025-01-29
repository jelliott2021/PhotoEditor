package controller;

import org.junit.Test;

import controller.grey.BlueScale;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our blue scale command.
 */
public class BlueScaleTest {

  @Test
  public void testBlue() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage mod = new ImageModel(arrImage, "rainbow");

    ImageCommand blue = new BlueScale();
    IImage newMod = blue.process(mod, "rainbow");

    Pixel pxOneB = new Pixel(153, 153, 153);
    Pixel pxTwoB = new Pixel(255, 255, 255);
    Pixel pxThreeB = new Pixel(155, 155, 155);
    Pixel pxFourB = new Pixel(14, 14, 14);

    Pixel[] rowOneB = new Pixel[]{pxOneB, pxTwoB};
    Pixel[] rowTwoB = new Pixel[]{pxThreeB, pxFourB};

    Pixel[][] arrImageB = new Pixel[][]{rowOneB, rowTwoB};
    IImage modB = new ImageModel(arrImageB, "rainbow blue-visualized");

    assertEquals(modB, newMod);
  }
}