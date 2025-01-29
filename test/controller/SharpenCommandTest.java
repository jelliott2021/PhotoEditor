package controller;

import org.junit.Test;

import controller.filters.SharpenCommand;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests sharpening an image.
 */
public class SharpenCommandTest {
  Pixel pxOne = new Pixel(255, 0, 0);
  Pixel pxTwo = new Pixel(255, 127, 39);
  Pixel pxThree = new Pixel(0, 162, 232);
  Pixel pxFour = new Pixel(0, 255, 0);
  Pixel pxFive = new Pixel(255, 0, 0);
  Pixel pxSix = new Pixel(255, 127, 39);
  Pixel pxSeven = new Pixel(255, 242, 0);
  Pixel pxEight = new Pixel(205, 85, 207);
  Pixel pxNine = new Pixel(185, 121, 67);
  Pixel pxTen = new Pixel(247, 171, 121);
  Pixel pxEleven = new Pixel(255, 242, 0);
  Pixel pxTwelve = new Pixel(205, 85, 207);
  Pixel pxThirteen = new Pixel(255, 255, 255);
  Pixel pxFourteen = new Pixel(161, 161, 161);
  Pixel pxFifteen = new Pixel(0, 0, 0);
  Pixel pxSixteen = new Pixel(180, 230, 29);
  Pixel pxSeventeen = new Pixel(255, 255, 255);
  Pixel pxEighteen = new Pixel(161, 161, 161);
  Pixel pxNineteen = new Pixel(114, 8, 153);
  Pixel pxTwenty = new Pixel(0, 0, 255);
  Pixel pxTwentyOne = new Pixel(242, 111, 155);
  Pixel pxTwentyTwo = new Pixel(255, 203, 14);
  Pixel pxTwentyThree = new Pixel(114, 8, 153);
  Pixel pxTwentyFour = new Pixel(0, 0, 255);
  Pixel pxTwentyFive = new Pixel(255, 255, 255);
  Pixel pxTwentySix = new Pixel(161, 161, 161);
  Pixel pxTwentySeven = new Pixel(0, 0, 0);
  Pixel pxTwentyEight = new Pixel(180, 230, 29);
  Pixel pxTwentyNine = new Pixel(255, 255, 255);
  Pixel pxThirty = new Pixel(161, 161, 161);
  Pixel pxThirtyOne = new Pixel(114, 8, 153);
  Pixel pxThirtyTwo = new Pixel(0, 0, 255);
  Pixel pxThirtyThree = new Pixel(242, 111, 155);
  Pixel pxThirtyFour = new Pixel(255, 203, 14);
  Pixel pxThirtyFive = new Pixel(114, 8, 153);
  Pixel pxThirtySix = new Pixel(0, 0, 255);

  Pixel[] rowOne = new Pixel[]{pxOne, pxTwo, pxThree, pxFour, pxFive, pxSix};
  Pixel[] rowTwo = new Pixel[]{pxSeven, pxEight, pxNine, pxTen, pxEleven, pxTwelve};
  Pixel[] rowThree = new Pixel[]{pxThirteen, pxFourteen, pxFifteen, pxSixteen, pxSeventeen,
      pxEighteen};
  Pixel[] rowFour = new Pixel[]{pxNineteen, pxTwenty, pxTwentyOne, pxTwentyTwo, pxTwentyThree,
      pxTwentyFour};
  Pixel[] rowFive = new Pixel[]{pxTwentyFive, pxTwentySix, pxTwentySeven, pxTwentyEight,
      pxTwentyNine, pxThirty};
  Pixel[] rowSix = new Pixel[]{pxThirtyOne, pxThirtyTwo, pxThirtyThree, pxThirtyFour,
      pxThirtyFive, pxThirtySix};

  Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour, rowFive, rowSix};

  IImage rainbow = new ImageModel(arrImage, "rainbow");

  @Test
  public void testSharpen() {
    Pixel pxOneSharpen = new Pixel(255, 26.13, 0);
    Pixel pxTwoSharpen = new Pixel(255, 145.5, 94.75);
    Pixel pxThreeSharpen = new Pixel(0, 178.63, 253.00);
    Pixel pxFourSharpen = new Pixel(25.88, 255, 0);
    Pixel pxFiveSharpen = new Pixel(255, 103.88, 0);
    Pixel pxSixSharpen = new Pixel(255, 74.75, 20);
    Pixel pxSevenSharpen = new Pixel(255, 255, 57.75);
    Pixel pxEightSharpen = new Pixel(255, 229.75, 255);
    Pixel pxNineSharpen = new Pixel(165.13, 253.25, 109.25);
    Pixel pxTenSharpen = new Pixel(255, 255, 61);
    Pixel pxElevenSharpen = new Pixel(255, 255, 93.50);
    Pixel pxTwelveSharpen = new Pixel(255, 172.88, 249.25);
    Pixel pxThirteenSharpen = new Pixel(255, 255, 255);
    Pixel pxFourteenSharpen = new Pixel(251.50, 142.25, 255);
    Pixel pxFifteenSharpen = new Pixel(10.75, 0, 28.88);
    Pixel pxSixteenSharpen = new Pixel(255, 255, 0);
    Pixel pxSeventeenSharpen = new Pixel(255, 255, 255);
    Pixel pxEighteenSharpen = new Pixel(144.75, 104.5, 255);
    Pixel pxNineteenSharpen = new Pixel(166.63, 131.25, 255);
    Pixel pxTwentySharpen = new Pixel(32.25, 37.25, 255);
    Pixel pxTwentyOneSharpen = new Pixel(86.25, 78.88, 10.88);
    Pixel pxTwentyTwoSharpen = new Pixel(255, 255, 0);
    Pixel pxTwentyThreeSharpen = new Pixel(255, 250.25, 255);
    Pixel pxTwentyFourSharpen = new Pixel(25.13, 38.5, 255);
    Pixel pxTwentyFiveSharpen = new Pixel(239.75, 219.50, 255);
    Pixel pxTwentySixSharpen = new Pixel(242, 124, 255);
    Pixel pxTwentySevenSharpen = new Pixel(106.63, 74.38, 31.75);
    Pixel pxTwentyEightSharpen = new Pixel(255, 255, 10.25);
    Pixel pxTwentyNineSharpen = new Pixel(255, 255, 255);
    Pixel pxThirtySharpen = new Pixel(121, 68.5, 255);
    Pixel pxThirtyOneSharpen = new Pixel(143.25, 83.25, 231);
    Pixel pxThirtyTwoSharpen = new Pixel(62.25, 39.38, 255);
    Pixel pxThirtyThreeSharpen = new Pixel(208.13, 152.5, 76.5);
    Pixel pxThirtyFourSharpen = new Pixel(255, 255, 0);
    Pixel pxThirtyFiveSharpen = new Pixel(220.13, 166.13, 240);
    Pixel pxThirtySixSharpen = new Pixel(32, 25.5, 255);

    Pixel[] rowOneSharpen = new Pixel[]{pxOneSharpen, pxTwoSharpen, pxThreeSharpen,
        pxFourSharpen, pxFiveSharpen, pxSixSharpen};
    Pixel[] rowTwoSharpen = new Pixel[]{pxSevenSharpen, pxEightSharpen, pxNineSharpen, pxTenSharpen,
        pxElevenSharpen, pxTwelveSharpen};
    Pixel[] rowThreeSharpen = new Pixel[]{pxThirteenSharpen, pxFourteenSharpen, pxFifteenSharpen,
        pxSixteenSharpen, pxSeventeenSharpen, pxEighteenSharpen};
    Pixel[] rowFourSharpen = new Pixel[]{pxNineteenSharpen, pxTwentySharpen, pxTwentyOneSharpen,
        pxTwentyTwoSharpen, pxTwentyThreeSharpen, pxTwentyFourSharpen};
    Pixel[] rowFiveSharpen = new Pixel[]{pxTwentyFiveSharpen, pxTwentySixSharpen,
        pxTwentySevenSharpen, pxTwentyEightSharpen, pxTwentyNineSharpen, pxThirtySharpen};
    Pixel[] rowSixSharpen = new Pixel[]{pxThirtyOneSharpen, pxThirtyTwoSharpen,
        pxThirtyThreeSharpen, pxThirtyFourSharpen, pxThirtyFiveSharpen, pxThirtySixSharpen};

    Pixel[][] arrImageSharpen = new Pixel[][]{rowOneSharpen, rowTwoSharpen, rowThreeSharpen,
        rowFourSharpen, rowFiveSharpen, rowSixSharpen};

    SharpenCommand sharp = new SharpenCommand("rainbow");

    IImage sharpened = new ImageModel(arrImageSharpen, "rainbow sharpened");

    IImage sharpRainbow = sharp.process(rainbow, "rainbow");
    assertEquals(sharpened, sharpRainbow);
  }
}