package controller;

import org.junit.Test;

import controller.grey.RedScale;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our red scale command.
 */
public class RedScaleTest {

  @Test
  public void testRed() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    ImageModel mod = new ImageModel(arrImage, "rainbow");

    ImageCommand red = new RedScale();
    IImage newMod = red.process(mod, "rainbow");

    Pixel pxOneR = new Pixel(114, 114, 114);
    Pixel pxTwoR = new Pixel(0, 0, 0);
    Pixel pxThreeR = new Pixel(242, 242, 242);
    Pixel pxFourR = new Pixel(255, 255, 255);

    Pixel[] rowOneR = new Pixel[]{pxOneR, pxTwoR};
    Pixel[] rowTwoR = new Pixel[]{pxThreeR, pxFourR};

    Pixel[][] arrImageB = new Pixel[][]{rowOneR, rowTwoR};
    IImage modB = new ImageModel(arrImageB, "rainbow red-visualized");

    assertEquals(modB, newMod);
  }
}

