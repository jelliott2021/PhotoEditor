package controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import controller.filters.BlurCommand;
import model.IImage;
import model.ImageModel;
import model.Pixel;

/**
 * Tests blurring an image.
 */
public class BlurCommandTest {
  Pixel pxOne = new Pixel(241, 24, 41);
  Pixel pxTwo = new Pixel(255, 130, 44);
  Pixel pxThree = new Pixel(0, 164, 236);
  Pixel pxFour = new Pixel(4, 105, 35);
  Pixel pxFive = new Pixel(252, 241, 0);
  Pixel pxSix = new Pixel(197, 81, 214);
  Pixel pxSeven = new Pixel(181, 122, 88);
  Pixel pxEight = new Pixel(255, 171, 134);
  Pixel pxNine = new Pixel(252, 255, 239);
  Pixel pxTen = new Pixel(173, 168, 164);
  Pixel pxEleven = new Pixel(0, 4, 14);
  Pixel pxTwelve = new Pixel(193, 225, 20);
  Pixel pxThirteen = new Pixel(119, 2, 161);
  Pixel pxFourteen = new Pixel(0, 156, 227);
  Pixel pxFifteen = new Pixel(234, 118, 155);
  Pixel pxSixteen = new Pixel(255, 205, 17);

  Pixel[] rowOne = new Pixel[]{pxOne, pxTwo, pxThree, pxFour};
  Pixel[] rowTwo = new Pixel[]{pxFive, pxSix, pxSeven, pxEight};
  Pixel[] rowThree = new Pixel[]{pxNine, pxTen, pxEleven, pxTwelve};
  Pixel[] rowFour = new Pixel[]{pxThirteen, pxFourteen, pxFifteen, pxSixteen};

  Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};
  ImageModel rainbow = new ImageModel(arrImage, "rainbow");

  @Test
  public void testBlur() {
    Pixel pxOneBlur = new Pixel(135.94, 57.44, 29.13);
    Pixel pxTwoBlur = new Pixel(145.56, 88.81, 77.88);
    Pixel pxThreeBlur = new Pixel(83.25, 101.38, 101.63);
    Pixel pxFourBlur = new Pixel(44.19, 75.75, 60.5);
    Pixel pxFiveBlur = new Pixel(176, 123.88, 74.75);
    Pixel pxSixBlur = new Pixel(187.69, 130.81,123.63 );
    Pixel pxSevenBlur = new Pixel(140.81, 122.25, 113.19);
    Pixel pxEightBlur = new Pixel(111, 109.75, 67);
    Pixel pxNineBlur = new Pixel(143.31, 129.94, 127.94);
    Pixel pxTenBlur = new Pixel(148.50, 134.19, 153.00);
    Pixel pxElevenBlur = new Pixel(141.81, 118.44, 93.88);
    Pixel pxTwelveBlur = new Pixel(137.94, 118.75, 40.81);
    Pixel pxThirteenBlur = new Pixel(72.06, 62.38, 108.75);
    Pixel pxFourteenBlur = new Pixel(81.5, 91.19, 132.56);
    Pixel pxFifteenBlur = new Pixel(113.25, 99.69, 82.5);
    Pixel pxSixteenBlur = new Pixel(117.13, 94.38, 27);

    Pixel[] rowOneBlur = new Pixel[]{pxOneBlur, pxTwoBlur, pxThreeBlur, pxFourBlur};
    Pixel[] rowTwoBlur = new Pixel[]{pxFiveBlur, pxSixBlur, pxSevenBlur, pxEightBlur};
    Pixel[] rowThreeBlur = new Pixel[]{pxNineBlur, pxTenBlur, pxElevenBlur, pxTwelveBlur};
    Pixel[] rowFourBlur = new Pixel[]{pxThirteenBlur, pxFourteenBlur, pxFifteenBlur, pxSixteenBlur};

    Pixel[][] arrImageBlur = new Pixel[][]{rowOneBlur, rowTwoBlur, rowThreeBlur, rowFourBlur};

    ImageModel blurred = new ImageModel(arrImageBlur, "rainbow blurred");

    BlurCommand blur = new BlurCommand("rainbow");
    IImage blurRainbow = blur.process(rainbow, "rainbow");
    assertEquals(blurred, blurRainbow);
  }
}