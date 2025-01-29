package controller;

import org.junit.Test;

import controller.transformations.SepiaTransform;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests performing a sepia transformation on an image.
 */
public class SepiaTransformTest {
  Pixel pxOne = new Pixel(114, 8, 153);
  Pixel pxTwo = new Pixel(0, 0, 255);
  Pixel pxThree = new Pixel(242, 111, 155);
  Pixel pxFour = new Pixel(255, 203, 14);

  Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
  Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

  Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
  IImage rainbow = new ImageModel(arrImage, "rainbow");

  @Test
  public void testSepia() {
    Pixel pxOneSep = new Pixel(79.87, 70.98, 55.32);
    Pixel pxTwoSep = new Pixel(48.20, 42.84, 33.41);
    Pixel pxThreeSep = new Pixel(209.76, 186.64, 145.40);
    Pixel pxFourSep = new Pixel(255, 230.61, 179.60);

    Pixel[] rowOneSep = new Pixel[]{pxOneSep, pxTwoSep};
    Pixel[] rowTwoSep = new Pixel[]{pxThreeSep, pxFourSep};

    Pixel[][] arrImageSep = new Pixel[][]{rowOneSep, rowTwoSep};
    ImageModel rainbowSep = new ImageModel(arrImageSep, "rainbow sepia-scaled");

    SepiaTransform sepia = new SepiaTransform("rainbow");
    IImage sepiaIImage = sepia.process(rainbow, "rainbow");

    assertEquals(sepiaIImage, rainbowSep);
  }
}