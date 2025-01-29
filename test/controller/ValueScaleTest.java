package controller;

import org.junit.Test;

import controller.grey.ValueScale;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our value scale command.
 */
public class ValueScaleTest {
  @Test
  public void testValue() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage mod = new ImageModel(arrImage, "rainbow");

    ImageCommand value = new ValueScale();
    IImage newMod = value.process(mod, "rainbow");

    Pixel pxOneV = new Pixel(153, 153, 153);
    Pixel pxTwoV = new Pixel(255, 255, 255);
    Pixel pxThreeV = new Pixel(242, 242, 242);
    Pixel pxFourV = new Pixel(255, 255, 255);

    Pixel[] rowOneV = new Pixel[]{pxOneV, pxTwoV};
    Pixel[] rowTwoV = new Pixel[]{pxThreeV, pxFourV};

    Pixel[][] arrImageB = new Pixel[][]{rowOneV, rowTwoV};
    IImage modB = new ImageModel(arrImageB, "rainbow value-visualized");

    assertEquals(modB, newMod);
  }
}