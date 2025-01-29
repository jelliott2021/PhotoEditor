package controller;

import org.junit.Test;

import controller.brightness.Darken;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our darken command.
 */
public class DarkenTest {

  @Test
  public void testDarken() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    ImageModel mod = new ImageModel(arrImage, "rainbow");

    ImageCommand darken = new Darken(10);
    IImage newMod = darken.process(mod, "rainbow");

    Pixel pxOneDa = new Pixel(104, 0, 143);
    Pixel pxTwoDa = new Pixel(0, 0, 245);
    Pixel pxThreeDa = new Pixel(232, 101, 145);
    Pixel pxFourDa = new Pixel(245, 193, 4);

    Pixel[] rowOneDa = new Pixel[]{pxOneDa, pxTwoDa};
    Pixel[] rowTwoDa = new Pixel[]{pxThreeDa, pxFourDa};

    Pixel[][] arrImageDa = new Pixel[][]{rowOneDa, rowTwoDa};
    IImage modBr = new ImageModel(arrImageDa, "rainbow darkened");

    assertEquals(modBr, newMod);
  }

}