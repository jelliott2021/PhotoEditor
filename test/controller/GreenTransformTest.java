package controller;

import org.junit.Test;

import controller.transformations.GreenTransform;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests green scaling an image using a color matrix.
 */
public class GreenTransformTest {
  @Test
  public void testGreenTransform() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage mod = new ImageModel(arrImage, "rainbow");

    ImageCommand green = new GreenTransform("rainbow");
    IImage newGreen = green.process(mod, "rainbow");

    Pixel pxOneG = new Pixel(8, 8, 8);
    Pixel pxTwoG = new Pixel(0, 0, 0);
    Pixel pxThreeG = new Pixel(111, 111, 111);
    Pixel pxFourG = new Pixel(203, 203, 203);

    Pixel[] rowOneG = new Pixel[]{pxOneG, pxTwoG};
    Pixel[] rowTwoG = new Pixel[]{pxThreeG, pxFourG};

    Pixel[][] arrImageB = new Pixel[][]{rowOneG, rowTwoG};
    IImage modB = new ImageModel(arrImageB, "rainbow green-visualized");

    assertEquals(modB, newGreen);
  }
}