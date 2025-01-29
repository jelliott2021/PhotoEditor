package controller;

import org.junit.Test;

import controller.grey.BlueScale;
import controller.miscellaneous.Mosaic;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

public class MosaicTest {

  @Test
  public void testMosaic() {
    Pixel pxOne = new Pixel(153, 153, 153);
    Pixel pxTwo = new Pixel(255, 255, 255);
    Pixel pxThree = new Pixel(155, 155, 155);
    Pixel pxFour = new Pixel(14, 14, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage mod = new ImageModel(arrImage, "rainbow");

    ImageCommand mosaic = new Mosaic(3);
    IImage newMod = mosaic.process(mod, "rainbow mosaic");

    Pixel pxOneB = new Pixel(153, 153, 153);
    Pixel pxTwoB = new Pixel(255, 255, 255);
    Pixel pxThreeB = new Pixel(84, 84, 84);
    Pixel pxFourB = new Pixel(84, 84, 84);

    Pixel[] rowOneB = new Pixel[]{pxOneB, pxTwoB};
    Pixel[] rowTwoB = new Pixel[]{pxThreeB, pxFourB};

    Pixel[][] arrImageB = new Pixel[][]{rowOneB, rowTwoB};
    IImage modB = new ImageModel(arrImageB, "rainbow mosaic");

    assertEquals(modB, newMod);
  }
}
