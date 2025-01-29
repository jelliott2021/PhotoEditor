package controller;

import org.junit.Test;

import controller.miscellaneous.FlipVert;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our flip vertical command.
 */
public class FlipVertTest {
  @Test
  public void testVertically() {

    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage mod = new ImageModel(arrImage, "rainbow");

    ImageCommand vertical = new FlipVert();
    IImage newMod = vertical.process(mod, "rainbow");

    Pixel pxOneFV = new Pixel(0, 0, 255);
    Pixel pxTwoFV = new Pixel(114, 8, 153);
    Pixel pxThreeFV = new Pixel(255, 203, 14);
    Pixel pxFourFV = new Pixel(242, 111, 155);

    Pixel[] rowOneFV = new Pixel[]{pxOneFV, pxTwoFV};
    Pixel[] rowTwoFV = new Pixel[]{pxThreeFV, pxFourFV};

    Pixel[][] arrImageB = new Pixel[][]{rowOneFV, rowTwoFV};
    IImage modB = new ImageModel(arrImageB, "rainbow vertically-flipped");

    assertEquals(modB, newMod);
  }
}
