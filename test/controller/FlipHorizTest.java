package controller;

import org.junit.Test;

import controller.miscellaneous.FlipHoriz;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our flip horizontal command.
 */
public class FlipHorizTest {


  @Test
  public void testHoriz() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage mod = new ImageModel(arrImage, "rainbow");

    ImageCommand horizontal = new FlipHoriz();
    IImage newMod = horizontal.process(mod, "rainbow");

    Pixel pxOneFH = new Pixel(242, 111, 155);
    Pixel pxTwoFH = new Pixel(255, 203, 14);
    Pixel pxThreeFH = new Pixel(114, 8, 153);
    Pixel pxFourFH = new Pixel(0, 0, 255);

    Pixel[] rowOneFH = new Pixel[]{pxOneFH, pxTwoFH};
    Pixel[] rowTwoFH = new Pixel[]{pxThreeFH, pxFourFH};

    Pixel[][] arrImageB = new Pixel[][]{rowOneFH, rowTwoFH};
    IImage modB = new ImageModel(arrImageB, "rainbow horizontally-flipped");

    assertEquals(modB, newMod);
  }
}

