package controller;

import org.junit.Test;

import controller.brightness.Brighten;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our brighten command.
 */
public class BrightenTest {

  @Test
  public void testBrighten() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage mod = new ImageModel(arrImage, "rainbow");

    ImageCommand brighten = new Brighten(10);
    IImage newMod = brighten.process(mod, "rainbow");

    Pixel pxOneBr = new Pixel(124, 18, 163);
    Pixel pxTwoBr = new Pixel(10, 10, 255);
    Pixel pxThreeBr = new Pixel(252, 121, 165);
    Pixel pxFourBr = new Pixel(255, 213, 24);

    Pixel[] rowOneBr = new Pixel[]{pxOneBr, pxTwoBr};
    Pixel[] rowTwoBr = new Pixel[]{pxThreeBr, pxFourBr};

    Pixel[][] arrImageBr = new Pixel[][]{rowOneBr, rowTwoBr};
    IImage modBr = new ImageModel(arrImageBr, "rainbow brightened");

    assertEquals(modBr, newMod);
  }
}