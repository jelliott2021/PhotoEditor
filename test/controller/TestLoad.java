package controller;

import org.junit.Test;

import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our load command.
 */
public class TestLoad {

  @Test(expected = IllegalArgumentException.class)
  public void testNullImage() {
    ImageLoad nullImage = new ImageLoad(null, "rainbow");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    ImageLoad nullImage = new ImageLoad("pixil-frame-0.ppm", null);
  }

  @Test
  public void testLoadPPM() {
    ImageLoad load = new ImageLoad("res/pixil-frame-0.ppm", "rainbow");
    IImage rain = load.load();

    Pixel pxOne = new Pixel(237, 28, 36);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(12, 102, 36);
    Pixel pxFive = new Pixel(255, 242, 0);
    Pixel pxSix = new Pixel(205, 85, 207);
    Pixel pxSeven = new Pixel(185, 122, 87);
    Pixel pxEight = new Pixel(247, 171, 121);
    Pixel pxNine = new Pixel(255, 255, 255);
    Pixel pxTen = new Pixel(161, 161, 161);
    Pixel pxEleven = new Pixel(0, 0, 0);
    Pixel pxTwelve = new Pixel(181, 230, 29);
    Pixel pxThirteen = new Pixel(114, 8, 153);
    Pixel pxFourteen = new Pixel(0, 162, 232);
    Pixel pxFifteen = new Pixel(242, 111, 155);
    Pixel pxSixteen = new Pixel(255, 201, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo, pxThree, pxFour};
    Pixel[] rowTwo = new Pixel[]{pxFive, pxSix, pxSeven, pxEight};
    Pixel[] rowThree = new Pixel[]{pxNine, pxTen, pxEleven, pxTwelve};
    Pixel[] rowFour = new Pixel[]{pxThirteen, pxFourteen, pxFifteen, pxSixteen};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};
    IImage orig = new ImageModel(arrImage, "rainbow");

    assertEquals(orig, rain);

  }

  @Test
  public void testLoadPNG() {
    ImageLoad load = new ImageLoad("res/pixil-2-by-2.png", "small-rainbow");
    IImage small = load.load();

    Pixel pxOne = new Pixel(237, 28, 36);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(84, 135, 255);
    Pixel pxFour = new Pixel(30, 230, 86);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage orig = new ImageModel(arrImage, "small-rainbow");

    assertEquals(orig, small);
  }



  @Test
  public void testLoadJPG() {
    ImageLoad load = new ImageLoad("res/pixil-scary.jpg", "dark-colors");
    IImage scary = load.load();

    Pixel pxOne = new Pixel(114, 179, 95);
    Pixel pxTwo = new Pixel(240, 255, 255);
    Pixel pxThree = new Pixel(0, 10, 25);
    Pixel pxFour = new Pixel(106, 117, 222);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage orig = new ImageModel(arrImage, "dark-colors");

    assertEquals(orig, scary);
  }

  @Test
  public void testBMP() {
    ImageLoad load = new ImageLoad("res/pixil-scooby-colors.bmp", "scooby-colors");
    IImage purple = load.load();

    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage orig = new ImageModel(arrImage, "scooby-colors");

    assertEquals(orig, purple);
  }

}
