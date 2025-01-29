package controller;

import org.junit.Test;

import java.io.StringReader;

import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests with our controller.
 */
public class ImageControllerTest {

  @Test
  public void testOkayConstructor() {

    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    Readable read = new StringReader("red-scale q");
    Appendable builder = new StringBuilder();
    IImage valid = new ImageModel(arrImage, "rainbow");
    ImageController okay = new ImageController(valid, builder, read, "rainbow");
    StringBuilder output = new StringBuilder();
    IImage scaled = valid.redScale();
    output.append(scaled);
    okay.processImage();

    assertEquals(output.toString(), builder.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullImage() {
    StringBuilder builder = new StringBuilder();
    Readable read = new StringReader("red-scale");
    ImageController nullImage = new ImageController(null, builder, read, "rainbow");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullName() {

    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    StringBuilder builder = new StringBuilder();
    Readable read = new StringReader("red-scale");
    IImage valid = new ImageModel(arrImage, "rainbow");

    ImageController nullImage = new ImageController(valid, builder, read, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendable() {

    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    Readable read = new StringReader("red-scale");
    IImage okay = new ImageModel(arrImage, "rainbow");

    ImageController nullApp = new ImageController(okay, null, read, "rainbow");
  }


  @Test(expected = IllegalArgumentException.class)
  public void testNullReadable() {

    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    Appendable builder = new StringBuilder();
    IImage okay = new ImageModel(arrImage, "rainbow");

    ImageController nullRead = new ImageController(okay, builder, null, "rainbow");
  }



  @Test
  public void processRedScale() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneR = new Pixel(255, 255, 255);
    Pixel pxTwoR = new Pixel(255, 255, 255);
    Pixel pxThreeR = new Pixel(0, 0, 0);
    Pixel pxFourR = new Pixel(0, 0, 0);


    Pixel[] rowOneR = new Pixel[]{pxOneR, pxTwoR};
    Pixel[] rowTwoR = new Pixel[]{pxThreeR, pxFourR};
    Pixel[][] redRB = new Pixel[][]{rowOneR, rowTwoR};
    IImage redRainB = new ImageModel(redRB, "rainbow red-visualized");

    StringBuilder desired = new StringBuilder();
    desired.append(redRainB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("red-scale q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }

  @Test
  public void processGreenScale() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneG = new Pixel(0, 0, 0);
    Pixel pxTwoG = new Pixel(127, 127, 127);
    Pixel pxThreeG = new Pixel(162, 162, 162);
    Pixel pxFourG = new Pixel(255, 255, 255);


    Pixel[] rowOneG = new Pixel[]{pxOneG, pxTwoG};
    Pixel[] rowTwoG = new Pixel[]{pxThreeG, pxFourG};
    Pixel[][] greenRB = new Pixel[][]{rowOneG, rowTwoG};
    IImage greenRainB = new ImageModel(greenRB, "rainbow green-visualized");

    StringBuilder desired = new StringBuilder();
    desired.append(greenRainB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("green-scale q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }

  @Test
  public void processBlueScale() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneB = new Pixel(0, 0, 0);
    Pixel pxTwoB = new Pixel(39, 39, 39);
    Pixel pxThreeB = new Pixel(232, 232, 232);
    Pixel pxFourB = new Pixel(0, 0, 0);


    Pixel[] rowOneB = new Pixel[]{pxOneB, pxTwoB};
    Pixel[] rowTwoB = new Pixel[]{pxThreeB, pxFourB};
    Pixel[][] blueRB = new Pixel[][]{rowOneB, rowTwoB};
    IImage blueRainB = new ImageModel(blueRB, "rainbow blue-visualized");

    StringBuilder desired = new StringBuilder();
    desired.append(blueRainB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("blue-scale q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }

  @Test
  public void processValueScale() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    ImageModel rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneV = new Pixel(255, 255, 255);
    Pixel pxTwoV = new Pixel(255, 255, 255);
    Pixel pxThreeV = new Pixel(232, 232, 232);
    Pixel pxFourV = new Pixel(255, 255, 255);


    Pixel[] rowOneV = new Pixel[]{pxOneV, pxTwoV};
    Pixel[] rowTwoV = new Pixel[]{pxThreeV, pxFourV};
    Pixel[][] valueRB = new Pixel[][]{rowOneV, rowTwoV};
    IImage valueRainB = new ImageModel(valueRB, "rainbow value-visualized");

    StringBuilder desired = new StringBuilder();
    desired.append(valueRainB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("value-scale q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }


  @Test
  public void processIntensityScale() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneI = new Pixel(85, 85, 85);
    Pixel pxTwoI = new Pixel(140.33, 140.33, 140.33);
    Pixel pxThreeI = new Pixel(131.33, 131.33, 131.33);
    Pixel pxFourI = new Pixel(85, 85, 85);


    Pixel[] rowOneI = new Pixel[]{pxOneI, pxTwoI};
    Pixel[] rowTwoI = new Pixel[]{pxThreeI, pxFourI};
    Pixel[][] intensityRB = new Pixel[][]{rowOneI, rowTwoI};
    IImage intensityRainB = new ImageModel(intensityRB, "rainbow intensity-visualized");

    StringBuilder desired = new StringBuilder();
    desired.append(intensityRainB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("intensity q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }

  @Test
  public void processLuma() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneL = new Pixel(54.21, 54.21, 54.21);
    Pixel pxTwoL = new Pixel(147.86, 147.86, 147.86);
    Pixel pxThreeL = new Pixel(132.61, 132.61, 132.61);
    Pixel pxFourL = new Pixel(182.38, 182.38, 182.38);


    Pixel[] rowOneL = new Pixel[]{pxOneL, pxTwoL};
    Pixel[] rowTwoL = new Pixel[]{pxThreeL, pxFourL};
    Pixel[][] lumaRB = new Pixel[][]{rowOneL, rowTwoL};
    IImage lumaRainB = new ImageModel(lumaRB, "rainbow luma-visualized");

    StringBuilder desired = new StringBuilder();
    desired.append(lumaRainB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("luma rainbow q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }

  @Test
  public void processBrighten() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneBright = new Pixel(255, 10, 10);
    Pixel pxTwoBright = new Pixel(255, 137, 49);
    Pixel pxThreeBright = new Pixel(10, 172, 242);
    Pixel pxFourBright = new Pixel(10, 255, 10);


    Pixel[] rowOneBright = new Pixel[]{pxOneBright, pxTwoBright};
    Pixel[] rowTwoBright = new Pixel[]{pxThreeBright, pxFourBright};
    Pixel[][] brightRB = new Pixel[][]{rowOneBright, rowTwoBright};
    IImage brightRainB = new ImageModel(brightRB, "rainbow brightened");

    StringBuilder desired = new StringBuilder();
    desired.append(brightRainB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("brighten 10 q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }


  @Test (expected = IllegalArgumentException.class)
  public void testBrightenNoFactor() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("brighten q"), "rainbow");
    control.processImage();
  }


  @Test
  public void processDarken() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneD = new Pixel(245, 0, 0);
    Pixel pxTwoD = new Pixel(245, 117, 29);
    Pixel pxThreeD = new Pixel(0, 152, 222);
    Pixel pxFourD = new Pixel(0, 245, 0);


    Pixel[] rowOneD = new Pixel[]{pxOneD, pxTwoD};
    Pixel[] rowTwoD = new Pixel[]{pxThreeD, pxFourD};
    Pixel[][] darkRB = new Pixel[][]{rowOneD, rowTwoD};
    ImageModel darkRainB = new ImageModel(darkRB, "rainbow darkened");

    StringBuilder desired = new StringBuilder();
    desired.append(darkRainB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("darken 10 q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }

  @Test  (expected = IllegalArgumentException.class)
  public void processDarkenNoFactor() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("darken  q"), "rainbow");
    control.processImage();

  }


  @Test
  public void processFlipHoriz() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneFH = new Pixel(0, 162, 232);
    Pixel pxTwoFH = new Pixel(0, 255, 0);
    Pixel pxThreeFH = new Pixel(255, 0, 0);
    Pixel pxFourFH = new Pixel(255, 127, 39);


    Pixel[] rowOneFH = new Pixel[]{pxOneFH, pxTwoFH};
    Pixel[] rowTwoFH = new Pixel[]{pxThreeFH, pxFourFH};
    Pixel[][] flipRB = new Pixel[][]{rowOneFH, rowTwoFH};
    IImage flipB = new ImageModel(flipRB, "rainbow horizontally-flipped");

    StringBuilder desired = new StringBuilder();
    desired.append(flipB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("flipHoriz q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }


  @Test (expected = IllegalArgumentException.class)
  public void testNonsensicalCommand() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneFH = new Pixel(0, 162, 232);
    Pixel pxTwoFH = new Pixel(0, 255, 0);
    Pixel pxThreeFH = new Pixel(255, 0, 0);
    Pixel pxFourFH = new Pixel(255, 127, 39);


    Pixel[] rowOneFH = new Pixel[]{pxOneFH, pxTwoFH};
    Pixel[] rowTwoFH = new Pixel[]{pxThreeFH, pxFourFH};
    Pixel[][] flipRB = new Pixel[][]{rowOneFH, rowTwoFH};
    ImageModel flipB = new ImageModel(flipRB, "rainbow horizontally-flipped");

    StringBuilder desired = new StringBuilder();
    desired.append(flipB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("cars"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }




  @Test
  public void processFlipVert() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    ImageModel rainB = new ImageModel(arrImage, "rainbow");

    Pixel pxOneFV = new Pixel(255, 127, 39);
    Pixel pxTwoFV = new Pixel(255, 0, 0);
    Pixel pxThreeFV = new Pixel(0, 255, 0);
    Pixel pxFourFV = new Pixel(0, 162, 232);


    Pixel[] rowOneFV = new Pixel[]{pxOneFV, pxTwoFV};
    Pixel[] rowTwoFV = new Pixel[]{pxThreeFV, pxFourFV};
    Pixel[][] flipRB = new Pixel[][]{rowOneFV, rowTwoFV};
    IImage flipB = new ImageModel(flipRB, "rainbow vertically-flipped");

    StringBuilder desired = new StringBuilder();
    desired.append(flipB.toString());

    StringBuilder output = new StringBuilder();
    ImageController control = new ImageController(rainB, output,
            new StringReader("flipVert q"), "rainbow");
    control.processImage();

    assertEquals(desired.toString(), output.toString());

  }

  @Test
  public void testRenderMessage() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    Readable read = new StringReader("blue-scale");
    Appendable builder = new StringBuilder();
    IImage valid = new ImageModel(arrImage, "rainbow");
    ImageController okay = new ImageController(valid, builder, read, "rainbow");

    // I render a new message.
    okay.renderMessage("Hello");

    assertTrue(builder.toString().contains("Hello"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIOExceptions() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    Readable read = new StringReader("blue-scale");
    Appendable badBuild = new FakeAppendable();
    IImage valid = new ImageModel(arrImage, "rainbow");

    ImageController fakeApp = new ImageController(valid, badBuild, read, "rainbow");
    fakeApp.processImage();

  }

  @Test
  public void runOutOfInputs() {
    Pixel pxOne = new Pixel(255, 0, 0);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(0, 162, 232);
    Pixel pxFour = new Pixel(0, 255, 0);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    Readable read = new StringReader("");
    Appendable builder = new StringBuilder();
    IImage valid = new ImageModel(arrImage, "rainbow");
    ImageController okay = new ImageController(valid, builder, read, "rainbow");
    okay.processImage();
    assertEquals(builder.toString(), "Ran out of inputs!");
  }
}