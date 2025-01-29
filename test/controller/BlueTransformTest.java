package controller;

import org.junit.Test;

import controller.transformations.BlueTransform;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests performing a blue scaling using a matrix on an image.
 */
public class BlueTransformTest {
  Pixel pxOne = new Pixel(114, 8, 153);
  Pixel pxTwo = new Pixel(0, 0, 255);
  Pixel pxThree = new Pixel(242, 111, 155);
  Pixel pxFour = new Pixel(255, 203, 14);

  Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
  Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

  Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
  IImage mod = new ImageModel(arrImage, "rainbow");

  @Test
  public void testBlueTranform() {
    ImageCommand blue = new BlueTransform("rainbow");
    IImage newBlue = blue.process(mod, "rainbow");

    Pixel pxOneB = new Pixel(153, 153, 153);
    Pixel pxTwoB = new Pixel(255, 255, 255);
    Pixel pxThreeB = new Pixel(155, 155, 155);
    Pixel pxFourB = new Pixel(14, 14, 14);

    Pixel[] rowOneB = new Pixel[]{pxOneB, pxTwoB};
    Pixel[] rowTwoB = new Pixel[]{pxThreeB, pxFourB};

    Pixel[][] arrImageB = new Pixel[][]{rowOneB, rowTwoB};
    IImage modB = new ImageModel(arrImageB, "rainbow blue-visualized");

    assertEquals(modB, newBlue);

  }
}