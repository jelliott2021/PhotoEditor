package controller;

import org.junit.Test;

import controller.transformations.RedTransform;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests performing a red grey scale using a color matrix.
 */
public class RedTransformTest {
  Pixel pxOne = new Pixel(114, 8, 153);
  Pixel pxTwo = new Pixel(0, 0, 255);
  Pixel pxThree = new Pixel(242, 111, 155);
  Pixel pxFour = new Pixel(255, 203, 14);

  Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
  Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

  Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
  IImage mod = new ImageModel(arrImage, "rainbow");

  @Test
  public void testRedTransform() {
    Pixel pxOneR = new Pixel(114, 114, 114);
    Pixel pxTwoR = new Pixel(0, 0, 0);
    Pixel pxThreeR = new Pixel(242, 242, 242);
    Pixel pxFourR = new Pixel(255, 255, 255);

    Pixel[] rowOneR = new Pixel[]{pxOneR, pxTwoR};
    Pixel[] rowTwoR = new Pixel[]{pxThreeR, pxFourR};

    Pixel[][] arrImageR = new Pixel[][]{rowOneR, rowTwoR};
    ImageModel rainbowR = new ImageModel(arrImageR, "rainbow red-visualized");

    RedTransform red = new RedTransform("rainbow");
    IImage redRainbow = red.process(mod, "rainbow");

    assertEquals(redRainbow, rainbowR);

  }

}