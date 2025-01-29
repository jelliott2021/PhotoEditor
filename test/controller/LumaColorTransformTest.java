package controller;

import org.junit.Test;

import controller.transformations.LumaColorTransform;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests performing a luma grey scale using a color matrix.
 */
public class LumaColorTransformTest {

  Pixel pxOne = new Pixel(114, 8, 153);
  Pixel pxTwo = new Pixel(0, 0, 255);
  Pixel pxThree = new Pixel(242, 111, 155);
  Pixel pxFour = new Pixel(255, 203, 14);

  Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
  Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

  Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
  ImageModel mod = new ImageModel(arrImage, "rainbow");

  @Test
  public void testLumaCommand() {
    Pixel pxOneL = new Pixel(41.00, 41.00, 41.00);
    Pixel pxTwoL = new Pixel(18.41, 18.41, 18.41);
    Pixel pxThreeL = new Pixel(142.03, 142.03, 142.03);
    Pixel pxFourL = new Pixel(200.41, 200.41, 200.41);

    Pixel[] rowOneL = new Pixel[]{pxOneL, pxTwoL};
    Pixel[] rowTwoL = new Pixel[]{pxThreeL, pxFourL};

    Pixel[][] arrImageL = new Pixel[][]{rowOneL, rowTwoL};
    IImage rainbowL = new ImageModel(arrImageL, "rainbow luma-visualized");

    LumaColorTransform luma = new LumaColorTransform("rainbow");
    IImage rainbowLuma = luma.process(mod, "rainbow");

    assertEquals(rainbowLuma, rainbowL);
  }

}