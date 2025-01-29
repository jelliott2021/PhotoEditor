package model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests our model and its methods.
 */
public class ImageModelTest {

  Pixel pxOne = new Pixel(255, 0, 0);
  Pixel pxTwo = new Pixel(255, 127, 39);
  Pixel pxThree = new Pixel(0, 162, 232);
  Pixel pxFour = new Pixel(0, 255, 0);
  Pixel pxFive = new Pixel(255, 242, 0);
  Pixel pxSix = new Pixel(205, 85, 207);
  Pixel pxSeven = new Pixel(185, 121, 67);
  Pixel pxEight = new Pixel(247, 171, 121);
  Pixel pxNine = new Pixel(255, 255, 255);
  Pixel pxTen = new Pixel(161, 161, 161);
  Pixel pxEleven = new Pixel(0, 0, 0);
  Pixel pxTwelve = new Pixel(180, 230, 29);
  Pixel pxThirteen = new Pixel(114, 8, 153);
  Pixel pxFourteen = new Pixel(0, 0, 255);
  Pixel pxFifteen = new Pixel(242, 111, 155);
  Pixel pxSixteen = new Pixel(255, 203, 14);

  Pixel[] rowOne = new Pixel[]{pxOne, pxTwo, pxThree, pxFour};
  Pixel[] rowTwo = new Pixel[]{pxFive, pxSix, pxSeven, pxEight};
  Pixel[] rowThree = new Pixel[]{pxNine, pxTen, pxEleven, pxTwelve};
  Pixel[] rowFour = new Pixel[]{pxThirteen, pxFourteen, pxFifteen, pxSixteen};

  Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};


  @Test
  public void testConstructorOkay() {
    IImage works = new ImageModel(arrImage, "rainbow");

    Pixel pxOneRed = new Pixel(255, 255, 255);
    Pixel pxTwoRed = new Pixel(255, 255, 255);
    Pixel pxThreeRed = new Pixel(0, 0, 0);
    Pixel pxFourRed = new Pixel(0, 0, 0);
    Pixel pxFiveRed = new Pixel(255, 255, 255);
    Pixel pxSixRed = new Pixel(205, 205, 205);
    Pixel pxSevenRed = new Pixel(185, 185, 185);
    Pixel pxEightRed = new Pixel(247, 247, 247);
    Pixel pxNineRed = new Pixel(255, 255, 255);
    Pixel pxTenRed = new Pixel(161, 161, 161);
    Pixel pxElevenRed = new Pixel(0, 0, 0);
    Pixel pxTwelveRed = new Pixel(180, 180, 180);
    Pixel pxThirteenRed = new Pixel(114, 114, 114);
    Pixel pxFourteenRed = new Pixel(0, 0, 0);
    Pixel pxFifteenRed = new Pixel(242, 242, 242);
    Pixel pxSixteenRed = new Pixel(255, 255, 255);

    Pixel[] rowOne = new Pixel[]{pxOneRed, pxTwoRed, pxThreeRed, pxFourRed};
    Pixel[] rowTwo = new Pixel[]{pxFiveRed, pxSixRed, pxSevenRed, pxEightRed};
    Pixel[] rowThree = new Pixel[]{pxNineRed, pxTenRed, pxElevenRed, pxTwelveRed};
    Pixel[] rowFour = new Pixel[]{pxThirteenRed, pxFourteenRed, pxFifteenRed, pxSixteenRed};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};

    IImage red = works.redScale();

    IImage goodModel = new ImageModel(arrImageTwo, "rainbow red-visualized");

    assertEquals(red, goodModel);

  }


  @Test(expected = IllegalArgumentException.class)
  public void testNullArray() {
    ImageModel nullArr = new ImageModel(null, "rainbow");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {
    ImageModel nullStr = new ImageModel(arrImage, null);
  }


  @Test
  public void redScale() {
    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneRed = new Pixel(255, 255, 255);
    Pixel pxTwoRed = new Pixel(255, 255, 255);
    Pixel pxThreeRed = new Pixel(0, 0, 0);
    Pixel pxFourRed = new Pixel(0, 0, 0);
    Pixel pxFiveRed = new Pixel(255, 255, 255);
    Pixel pxSixRed = new Pixel(205, 205, 205);
    Pixel pxSevenRed = new Pixel(185, 185, 185);
    Pixel pxEightRed = new Pixel(247, 247, 247);
    Pixel pxNineRed = new Pixel(255, 255, 255);
    Pixel pxTenRed = new Pixel(161, 161, 161);
    Pixel pxElevenRed = new Pixel(0, 0, 0);
    Pixel pxTwelveRed = new Pixel(180, 180, 180);
    Pixel pxThirteenRed = new Pixel(114, 114, 114);
    Pixel pxFourteenRed = new Pixel(0, 0, 0);
    Pixel pxFifteenRed = new Pixel(242, 242, 242);
    Pixel pxSixteenRed = new Pixel(255, 255, 255);

    Pixel[] rowOneR = new Pixel[]{pxOneRed, pxTwoRed, pxThreeRed, pxFourRed};
    Pixel[] rowTwoR = new Pixel[]{pxFiveRed, pxSixRed, pxSevenRed, pxEightRed};
    Pixel[] rowThreeR = new Pixel[]{pxNineRed, pxTenRed, pxElevenRed, pxTwelveRed};
    Pixel[] rowFourR = new Pixel[]{pxThirteenRed, pxFourteenRed, pxFifteenRed, pxSixteenRed};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOneR, rowTwoR, rowThreeR, rowFourR};

    IImage red = orig.redScale();

    IImage goodModel = new ImageModel(arrImageTwo, "rainbow red-visualized");

    assertEquals(red, goodModel);
  }

  @Test
  public void blueScale() {
    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneBlue = new Pixel(0, 0, 0);
    Pixel pxTwoBlue = new Pixel(39, 39, 39);
    Pixel pxThreeBlue = new Pixel(232, 232, 232);
    Pixel pxFourBlue = new Pixel(0, 0, 0);
    Pixel pxFiveBlue = new Pixel(0, 0, 0);
    Pixel pxSixBlue = new Pixel(207, 207, 207);
    Pixel pxSevenBlue = new Pixel(67, 67, 67);
    Pixel pxEightBlue = new Pixel(121, 121, 121);
    Pixel pxNineBlue = new Pixel(255, 255, 255);
    Pixel pxTenBlue = new Pixel(161, 161, 161);
    Pixel pxElevenBlue = new Pixel(0, 0, 0);
    Pixel pxTwelveBlue = new Pixel(29, 29, 29);
    Pixel pxThirteenBlue = new Pixel(153, 153, 153);
    Pixel pxFourteenBlue = new Pixel(255, 255, 255);
    Pixel pxFifteenBlue = new Pixel(155, 155, 155);
    Pixel pxSixteenBlue = new Pixel(14, 14, 14);

    Pixel[] rowOneB = new Pixel[]{pxOneBlue, pxTwoBlue, pxThreeBlue, pxFourBlue};
    Pixel[] rowTwoB = new Pixel[]{pxFiveBlue, pxSixBlue, pxSevenBlue, pxEightBlue};
    Pixel[] rowThreeB = new Pixel[]{pxNineBlue, pxTenBlue, pxElevenBlue, pxTwelveBlue};
    Pixel[] rowFourB = new Pixel[]{pxThirteenBlue, pxFourteenBlue, pxFifteenBlue, pxSixteenBlue};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOneB, rowTwoB, rowThreeB, rowFourB};

    IImage blueV = orig.blueScale();
    IImage blue = new ImageModel(arrImageTwo, "rainbow blue-visualized");
    assertEquals(blue, blueV);
  }

  @Test
  public void greenScale() {
    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneGreen = new Pixel(0, 0, 0);
    Pixel pxTwoGreen = new Pixel(127, 127, 127);
    Pixel pxThreeGreen = new Pixel(162, 162, 162);
    Pixel pxFourGreen = new Pixel(255, 255, 255);
    Pixel pxFiveGreen = new Pixel(242, 242, 242);
    Pixel pxSixGreen = new Pixel(85, 85, 85);
    Pixel pxSevenGreen = new Pixel(121, 121, 121);
    Pixel pxEightGreen = new Pixel(171, 171, 171);
    Pixel pxNineGreen = new Pixel(255, 255, 255);
    Pixel pxTenGreen = new Pixel(161, 161, 161);
    Pixel pxElevenGreen = new Pixel(0, 0, 0);
    Pixel pxTwelveGreen = new Pixel(230, 230, 230);
    Pixel pxThirteenGreen = new Pixel(8, 8, 8);
    Pixel pxFourteenGreen = new Pixel(0, 0, 0);
    Pixel pxFifteenGreen = new Pixel(111, 111, 111);
    Pixel pxSixteenGreen = new Pixel(203, 203, 203);

    Pixel[] rowOneG = new Pixel[]{pxOneGreen, pxTwoGreen, pxThreeGreen, pxFourGreen};
    Pixel[] rowTwoG = new Pixel[]{pxFiveGreen, pxSixGreen, pxSevenGreen, pxEightGreen};
    Pixel[] rowThreeG = new Pixel[]{pxNineGreen, pxTenGreen, pxElevenGreen, pxTwelveGreen};
    Pixel[] rowFourG = new Pixel[]{pxThirteenGreen, pxFourteenGreen,
        pxFifteenGreen, pxSixteenGreen};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOneG, rowTwoG, rowThreeG, rowFourG};

    IImage greenSc = orig.greenScale();
    IImage greened = new ImageModel(arrImageTwo, "rainbow green-visualized");

    assertEquals(greenSc, greened);

  }

  @Test
  public void valueScale() {

    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneVal = new Pixel(255, 255, 255);
    Pixel pxTwoVal = new Pixel(255, 255, 255);
    Pixel pxThreeVal = new Pixel(232, 232, 232);
    Pixel pxFourVal = new Pixel(255, 255, 255);
    Pixel pxFiveVal = new Pixel(255, 255, 255);
    Pixel pxSixVal = new Pixel(207, 207, 207);
    Pixel pxSevenVal = new Pixel(185, 185, 185);
    Pixel pxEightVal = new Pixel(247, 247, 247);
    Pixel pxNineVal = new Pixel(255, 255, 255);
    Pixel pxTenVal = new Pixel(161, 161, 161);
    Pixel pxElevenVal = new Pixel(0, 0, 0);
    Pixel pxTwelveVal = new Pixel(230, 230, 230);
    Pixel pxThirteenVal = new Pixel(153, 153, 153);
    Pixel pxFourteenVal = new Pixel(255, 255, 255);
    Pixel pxFifteenVal = new Pixel(242, 242, 242);
    Pixel pxSixteenVal = new Pixel(255, 255, 255);

    Pixel[] rowOne = new Pixel[]{pxOneVal, pxTwoVal, pxThreeVal, pxFourVal};
    Pixel[] rowTwo = new Pixel[]{pxFiveVal, pxSixVal, pxSevenVal, pxEightVal};
    Pixel[] rowThree = new Pixel[]{pxNineVal, pxTenVal, pxElevenVal, pxTwelveVal};
    Pixel[] rowFour = new Pixel[]{pxThirteenVal, pxFourteenVal, pxFifteenVal, pxSixteenVal};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};

    IImage valSc = orig.valueScale();
    IImage valued = new ImageModel(arrImageTwo, "rainbow value-visualized");

    assertEquals(valSc, valued);


  }

  @Test
  public void intensity() {

    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneInt = new Pixel(85, 85, 85);
    Pixel pxTwoInt = new Pixel(140.33, 140.33, 140.33);
    Pixel pxThreeInt = new Pixel(131.33, 131.33, 131.33);
    Pixel pxFourInt = new Pixel(85, 85, 85);
    Pixel pxFiveInt = new Pixel(165.67, 165.67, 165.67);
    Pixel pxSixInt = new Pixel(165.67, 165.67, 165.67);
    Pixel pxSevenInt = new Pixel(124.33, 124.33, 124.33);
    Pixel pxEightInt = new Pixel(179.67, 179.67, 179.67);
    Pixel pxNineInt = new Pixel(255, 255, 255);
    Pixel pxTenInt = new Pixel(161, 161, 161);
    Pixel pxElevenInt = new Pixel(0, 0, 0);
    Pixel pxTwelveInt = new Pixel(146.33, 146.33, 146.33);
    Pixel pxThirteenInt = new Pixel(91.67, 91.67, 91.67);
    Pixel pxFourteenInt = new Pixel(85, 85, 85);
    Pixel pxFifteenInt = new Pixel(169.33, 169.33, 169.33);
    Pixel pxSixteenInt = new Pixel(157.33, 157.33, 157.33);

    Pixel[] rowOne = new Pixel[]{pxOneInt, pxTwoInt, pxThreeInt, pxFourInt};
    Pixel[] rowTwo = new Pixel[]{pxFiveInt, pxSixInt, pxSevenInt, pxEightInt};
    Pixel[] rowThree = new Pixel[]{pxNineInt, pxTenInt, pxElevenInt, pxTwelveInt};
    Pixel[] rowFour = new Pixel[]{pxThirteenInt, pxFourteenInt, pxFifteenInt, pxSixteenInt};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};

    IImage intensity = orig.intensity();
    IImage intensified = new ImageModel(arrImageTwo, "rainbow intensity-visualized");

    assertEquals(intensity, intensified);

  }

  @Test
  public void luma() {
    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneLum = new Pixel(54.21, 54.21, 54.21);
    Pixel pxTwoLum = new Pixel(147.86, 147.86, 147.86);
    Pixel pxThreeLum = new Pixel(132.61, 132.61, 132.61);
    Pixel pxFourLum = new Pixel(182.38, 182.38, 182.38);
    Pixel pxFiveLum = new Pixel(227.29, 227.29, 227.29);
    Pixel pxSixLum = new Pixel(119.32, 119.32, 119.32);
    Pixel pxSevenLum = new Pixel(130.71, 130.71, 130.71);
    Pixel pxEightLum = new Pixel(183.55, 183.55, 183.55);
    Pixel pxNineLum = new Pixel(255, 255, 255);
    Pixel pxTenLum = new Pixel(161, 161, 161);
    Pixel pxElevenLum = new Pixel(0, 0, 0);
    Pixel pxTwelveLum = new Pixel(204.86, 204.86, 204.86);
    Pixel pxThirteenLum = new Pixel(41.00, 41.00, 41.00);
    Pixel pxFourteenLum = new Pixel(18.41, 18.41, 18.41);
    Pixel pxFifteenLum = new Pixel(142.03, 142.03, 142.03);
    Pixel pxSixteenLum = new Pixel(200.41, 200.41, 200.41);

    Pixel[] rowOne = new Pixel[]{pxOneLum, pxTwoLum, pxThreeLum, pxFourLum};
    Pixel[] rowTwo = new Pixel[]{pxFiveLum, pxSixLum, pxSevenLum, pxEightLum};
    Pixel[] rowThree = new Pixel[]{pxNineLum, pxTenLum, pxElevenLum, pxTwelveLum};
    Pixel[] rowFour = new Pixel[]{pxThirteenLum, pxFourteenLum, pxFifteenLum, pxSixteenLum};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};

    IImage luma = orig.luma();
    IImage lumad = new ImageModel(arrImageTwo, "rainbow luma-visualized");

    assertEquals(luma, lumad);
  }

  @Test
  public void flipHoriz() {
    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneHf = new Pixel(114, 8, 153);
    Pixel pxTwoHf = new Pixel(0, 0, 255);
    Pixel pxThreeHf = new Pixel(242, 111, 155);
    Pixel pxFourHf = new Pixel(255, 203, 14);
    Pixel pxFiveHf = new Pixel(255, 255, 255);
    Pixel pxSixHf = new Pixel(161, 161, 161);
    Pixel pxSevenHf = new Pixel(0, 0, 0);
    Pixel pxEightHf = new Pixel(180, 230, 29);
    Pixel pxNineHf = new Pixel(255, 242, 0);
    Pixel pxTenHf = new Pixel(205, 85, 207);
    Pixel pxElevenHf = new Pixel(185, 121, 67);
    Pixel pxTwelveHf = new Pixel(247, 171, 121);
    Pixel pxThirteenHf = new Pixel(255, 0, 0);
    Pixel pxFourteenHf = new Pixel(255, 127, 39);
    Pixel pxFifteenHf = new Pixel(0, 162, 232);
    Pixel pxSixteenHf = new Pixel(0, 255, 0);

    Pixel[] rowOne = new Pixel[]{pxOneHf, pxTwoHf, pxThreeHf, pxFourHf};
    Pixel[] rowTwo = new Pixel[]{pxFiveHf, pxSixHf, pxSevenHf, pxEightHf};
    Pixel[] rowThree = new Pixel[]{pxNineHf, pxTenHf, pxElevenHf, pxTwelveHf};
    Pixel[] rowFour = new Pixel[]{pxThirteenHf, pxFourteenHf, pxFifteenHf, pxSixteenHf};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};

    IImage flipHoriz = orig.flipHoriz();
    IImage flippedH = new ImageModel(arrImageTwo, "rainbow horizontally-flipped");

    assertEquals(flipHoriz, flippedH);

  }

  @Test
  public void flipVert() {
    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneVf = new Pixel(0, 255, 0);
    Pixel pxTwoVf = new Pixel(0, 162, 232);
    Pixel pxThreeVf = new Pixel(255, 127, 39);
    Pixel pxFourVf = new Pixel(255, 0, 0);
    Pixel pxFiveVf = new Pixel(247, 171, 121);
    Pixel pxSixVf = new Pixel(185, 121, 67);
    Pixel pxSevenVf = new Pixel(205, 85, 207);
    Pixel pxEightVf = new Pixel(255, 242, 0);
    Pixel pxNineVf = new Pixel(180, 230, 29);
    Pixel pxTenVf = new Pixel(0, 0, 0);
    Pixel pxElevenVf = new Pixel(161, 161, 161);
    Pixel pxTwelveVf = new Pixel(255, 255, 255);
    Pixel pxThirteenVf = new Pixel(255, 203, 14);
    Pixel pxFourteenVf = new Pixel(242, 111, 155);
    Pixel pxFifteenVf = new Pixel(0, 0, 255);
    Pixel pxSixteenVf = new Pixel(114, 8, 153);

    Pixel[] rowOne = new Pixel[]{pxOneVf, pxTwoVf, pxThreeVf, pxFourVf};
    Pixel[] rowTwo = new Pixel[]{pxFiveVf, pxSixVf, pxSevenVf, pxEightVf};
    Pixel[] rowThree = new Pixel[]{pxNineVf, pxTenVf, pxElevenVf, pxTwelveVf};
    Pixel[] rowFour = new Pixel[]{pxThirteenVf, pxFourteenVf, pxFifteenVf, pxSixteenVf};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};

    IImage flipVert = orig.flipVert();
    IImage flippedV = new ImageModel(arrImageTwo, "rainbow vertically-flipped");

    assertEquals(flipVert, flippedV);
  }

  @Test
  public void brighten() {
    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneBr = new Pixel(255, 10, 10);
    Pixel pxTwoBr = new Pixel(255, 137, 49);
    Pixel pxThreeBr = new Pixel(10, 172, 242);
    Pixel pxFourBr = new Pixel(10, 255, 10);
    Pixel pxFiveBr = new Pixel(255, 252, 10);
    Pixel pxSixBr = new Pixel(215, 95, 217);
    Pixel pxSevenBr = new Pixel(195, 131, 77);
    Pixel pxEightBr = new Pixel(255, 181, 131);
    Pixel pxNineBr = new Pixel(255, 255, 255);
    Pixel pxTenBr = new Pixel(171, 171, 171);
    Pixel pxElevenBr = new Pixel(10, 10, 10);
    Pixel pxTwelveBr = new Pixel(190, 240, 39);
    Pixel pxThirteenBr = new Pixel(124, 18, 163);
    Pixel pxFourteenBr = new Pixel(10, 10, 255);
    Pixel pxFifteenBr = new Pixel(252, 121, 165);
    Pixel pxSixteenBr = new Pixel(255, 213, 24);

    Pixel[] rowOne = new Pixel[]{pxOneBr, pxTwoBr, pxThreeBr, pxFourBr};
    Pixel[] rowTwo = new Pixel[]{pxFiveBr, pxSixBr, pxSevenBr, pxEightBr};
    Pixel[] rowThree = new Pixel[]{pxNineBr, pxTenBr, pxElevenBr, pxTwelveBr};
    Pixel[] rowFour = new Pixel[]{pxThirteenBr, pxFourteenBr, pxFifteenBr, pxSixteenBr};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};

    IImage brighter = orig.brighten(10);
    IImage bright = new ImageModel(arrImageTwo, "rainbow brightened");
    assertEquals(brighter, bright);
  }


  @Test
  public void darken() {
    IImage orig = new ImageModel(arrImage, "rainbow");

    Pixel pxOneDa = new Pixel(245, 0, 0);
    Pixel pxTwoDa = new Pixel(245, 117, 29);
    Pixel pxThreeDa = new Pixel(0, 152, 222);
    Pixel pxFourDa = new Pixel(0, 245, 0);
    Pixel pxFiveDa = new Pixel(245, 232, 0);
    Pixel pxSixDa = new Pixel(195, 75, 197);
    Pixel pxSevenDa = new Pixel(175, 111, 57);
    Pixel pxEightDa = new Pixel(237, 161, 111);
    Pixel pxNineDa = new Pixel(245, 245, 245);
    Pixel pxTenDa = new Pixel(151, 151, 151);
    Pixel pxElevenDa = new Pixel(0, 0, 0);
    Pixel pxTwelveDa = new Pixel(170, 220, 19);
    Pixel pxThirteenDa = new Pixel(104, 0, 143);
    Pixel pxFourteenDa = new Pixel(0, 0, 245);
    Pixel pxFifteenDa = new Pixel(232, 101, 145);
    Pixel pxSixteenDa = new Pixel(245, 193, 4);


    Pixel[] rowOne = new Pixel[]{pxOneDa, pxTwoDa, pxThreeDa, pxFourDa};
    Pixel[] rowTwo = new Pixel[]{pxFiveDa, pxSixDa, pxSevenDa, pxEightDa};
    Pixel[] rowThree = new Pixel[]{pxNineDa, pxTenDa, pxElevenDa, pxTwelveDa};
    Pixel[] rowFour = new Pixel[]{pxThirteenDa, pxFourteenDa, pxFifteenDa, pxSixteenDa};

    Pixel[][] arrImageTwo = new Pixel[][]{rowOne, rowTwo, rowThree, rowFour};

    IImage darker = orig.darken(10);
    IImage dark = new ImageModel(arrImageTwo, "rainbow darkened");
    assertEquals(darker, dark);
  }

  @Test
  public void testGetPixelAt() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    IImage pix = new ImageModel(arrImage, "small");

    assertEquals(pxTwo, pix.getPixelAt(0, 1));

  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelAtBad() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    IImage pix = new ImageModel(arrImage, "small");

    assertEquals(pxTwo, pix.getPixelAt(-10, 0));

  }

  @Test
  public void testGetHeight() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage pix = new ImageModel(arrImage, "small");

    assertEquals(2, pix.getHeight());

  }


  @Test
  public void testGetWidth() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage pix = new ImageModel(arrImage, "small");

    assertEquals(2, pix.getWidth());

  }

  @Test
  public void testGetGrid() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage img = new ImageModel(arrImage, "copy");


    Pixel pxOneC = new Pixel(255, 0, 0);
    Pixel pxTwoC = new Pixel(255, 127, 39);
    Pixel pxThreeC = new Pixel(0, 162, 232);
    Pixel pxFourC = new Pixel(0, 255, 0);


    Pixel[] rowOneC = new Pixel[]{pxOneC, pxTwoC};
    Pixel[] rowTwoC = new Pixel[]{pxThreeC, pxFourC};

    Pixel[][] desired = new Pixel[][]{rowOneC, rowTwoC};


    assertTrue(Arrays.deepEquals(img.getGrid(), desired));


  }


  @Test
  public void testBlur() {
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

    Pixel pxOneBlur = new Pixel(135.94, 57.44, 29.13);
    Pixel pxTwoBlur = new Pixel(145.56, 88.81, 77.88);
    Pixel pxThreeBlur = new Pixel(83.25, 101.38, 101.63);
    Pixel pxFourBlur = new Pixel(44.19, 75.75, 60.5);
    Pixel pxFiveBlur = new Pixel(176, 123.88, 74.75);
    Pixel pxSixBlur = new Pixel(187.69, 130.81, 123.63);
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

    IImage blurred = new ImageModel(arrImageBlur, "rainbow blurred");

    IImage blurring = rainbow.blur();
    assertEquals(blurring, blurred);
  }

  @Test
  public void testSepia() {
    Pixel pxOne = new Pixel(114, 8, 153);
    Pixel pxTwo = new Pixel(0, 0, 255);
    Pixel pxThree = new Pixel(242, 111, 155);
    Pixel pxFour = new Pixel(255, 203, 14);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainbow = new ImageModel(arrImage, "rainbow");

    Pixel pxOneSep = new Pixel(79.87, 70.98, 55.32);
    Pixel pxTwoSep = new Pixel(48.20, 42.84, 33.41);
    Pixel pxThreeSep = new Pixel(209.76, 186.64, 145.40);
    Pixel pxFourSep = new Pixel(255, 230.61, 179.60);

    Pixel[] rowOneSep = new Pixel[]{pxOneSep, pxTwoSep};
    Pixel[] rowTwoSep = new Pixel[]{pxThreeSep, pxFourSep};

    Pixel[][] arrImageSep = new Pixel[][]{rowOneSep, rowTwoSep};
    IImage rainbowSep = new ImageModel(arrImageSep, "rainbow sepia-scaled");

    IImage sepaing = rainbow.sepia();
    assertEquals(sepaing, rainbowSep);

  }

  @Test
  public void testSharpen() {
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

    IImage rainbowSharpened = new ImageModel(arrImageSharpen, "rainbow sharpened");

    IImage sharping = rainbow.sharpen();
    assertEquals(sharping, rainbowSharpened);

  }


}



