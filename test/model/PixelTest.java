package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests our Pixels and its methods.
 */
public class PixelTest {

  // Tests that a Pixel constructor works
  // If the constructor works, we should have a pixel of (121, 30, 75)
  // If we choose to brighten using a factor of 2, ideally we should get
  // (123, 32, 77)
  @Test
  public void testWorkingConstruct() {
    IPixel newPix = new Pixel(121, 30, 75);
    IPixel brightenedPix = newPix.brighten(2);
    IPixel otherBrightPix = new Pixel(123, 32, 77);
    assertEquals(brightenedPix, otherBrightPix);
  }

  // What happens if our red is too small
  @Test(expected = IllegalArgumentException.class)
  public void testRedSmall() {
    Pixel redSm = new Pixel(-3, 255, 255);
  }

  // What happens if our green is too small
  @Test(expected = IllegalArgumentException.class)
  public void testGreenSmall() {
    Pixel greenSm = new Pixel(20, 23, -10);
  }

  // What happens if our blue is too small
  @Test(expected = IllegalArgumentException.class)
  public void testBlueSmall() {
    Pixel blueSm = new Pixel(20, -10, 200);
  }

  // What happens if our red is too big
  @Test(expected = IllegalArgumentException.class)
  public void testRedBig() {
    Pixel redB = new Pixel(500, 100, 200);
  }

  // What happens if our green is too big
  @Test(expected = IllegalArgumentException.class)
  public void testGreenBig() {
    Pixel greenB = new Pixel(200, 200, 500);
  }

  // What happens if our blue is too big
  @Test(expected = IllegalArgumentException.class)
  public void testBlueBig() {
    Pixel blueB = new Pixel(200, 500, 200);
  }

  // Tests that we can create a grey scale using a red component
  @Test
  public void redScale() {
    IPixel redCom = new Pixel(255, 121, 34);
    IPixel redScaled = redCom.redScale();
    IPixel otherScaled = new Pixel(255, 255, 255);
    assertEquals(redScaled, otherScaled);
  }

  @Test
  public void blueScale() {
    IPixel blueCom = new Pixel(102, 34, 32);
    IPixel blueScaled = blueCom.blueScale();
    IPixel otherScaled = new Pixel(32, 32, 32);
    assertEquals(blueScaled, otherScaled);
  }

  @Test
  public void greenScale() {
    IPixel greenCom = new Pixel(102, 109, 32);
    IPixel greenScaled = greenCom.greenScale();
    IPixel otherScaled = new Pixel(109, 109, 109);
    assertEquals(greenScaled, otherScaled);
  }

  @Test
  public void valueScale() {
    IPixel valueCom = new Pixel(100, 11, 222);
    IPixel valueScaled = valueCom.valueScale();
    IPixel otherScaled = new Pixel(222,222,222);
    assertEquals(valueScaled, otherScaled);
  }

  @Test
  public void intensity() {
    IPixel intensityCom = new Pixel(121, 35, 77);
    IPixel intensified = intensityCom.intensity();
    IPixel otherScaled = new Pixel(77.67,77.67,77.67);
    assertEquals(intensified, otherScaled);
  }

  @Test
  public void luma() {
    IPixel lumaCom = new Pixel(50, 7, 12);
    IPixel lumad = lumaCom.luma();
    IPixel otherScaled = new Pixel(16.50,16.50,16.50);
    assertEquals(lumad, otherScaled);
  }

  @Test
  public void brightenRedMaxed() {
    IPixel redMax = new Pixel(254, 100, 47);
    IPixel maxed = redMax.brighten(5);
    IPixel otherMaxed = new Pixel(255, 105, 52);
    assertEquals(maxed, otherMaxed);
  }

  @Test
  public void brightenBlueMaxed() {
    IPixel blueMax = new Pixel(2, 241, 45);
    IPixel maxed = blueMax.brighten(100);
    IPixel otherMaxed = new Pixel(102, 255, 145);
    assertEquals(maxed, otherMaxed);
  }

  @Test
  public void brightenGreenMaxed() {
    IPixel greenMax = new Pixel(13, 67, 255);
    IPixel maxed = greenMax.brighten(1);
    IPixel otherMaxed = new Pixel(14, 68, 255);
    assertEquals(maxed, otherMaxed);
  }

  @Test
  public void brightenNoMax() {
    IPixel noMax = new Pixel(13, 67, 30);
    IPixel maxed = noMax.brighten(110);
    IPixel otherMaxed = new Pixel(123, 177, 140);
    assertEquals(maxed, otherMaxed);
  }

  @Test
  public void darkenRedMin() {
    IPixel redMin = new Pixel(4, 34, 120);
    IPixel min = redMin.darken(5);
    IPixel otherMin = new Pixel(0, 29, 115);
    assertEquals(min, otherMin);
  }

  @Test
  public void darkenBlueMin() {
    IPixel blueMin = new Pixel(255, 99, 125);
    IPixel min = blueMin.darken(100);
    IPixel otherMin = new Pixel(155, 0, 25);
    assertEquals(min, otherMin);
  }

  @Test
  public void darkenGreenMin() {
    IPixel greenMin = new Pixel(200, 170, 90);
    IPixel min = greenMin.darken(90);
    IPixel otherMin = new Pixel(110, 80, 0);
    assertEquals(min, otherMin);
  }

  @Test
  public void darkenNoMin() {
    IPixel noMin = new Pixel(255, 250, 245);
    IPixel min = noMin.darken(20);
    IPixel otherMin = new Pixel(235, 230, 225);
    assertEquals(min, otherMin);
  }

  @Test
  public void testMaxVal() {
    Pixel max = new Pixel(11,22,44);
    assertEquals(44, max.maxVal(), 0.01);
  }

  @Test
  public void testMultRed() {
    Pixel multR = new Pixel(10,20,30);
    assertEquals(20, multR.multRed(2), 0.01);
  }

  @Test
  public void testMultGreen() {
    Pixel multG = new Pixel(10,20,30);
    assertEquals(40, multG.multGreen(2), 0.01);
  }

  @Test
  public void testMultBlue() {
    Pixel multB = new Pixel(10,20,30);
    assertEquals(60, multB.multBlue(2), 0.01);
  }

  @Test
  public void testGetRed() {
    Pixel red = new Pixel(2,10,183);
    assertEquals(2, red.getRed(),0.01);
  }

  @Test
  public void testGetGreen() {
    Pixel green = new Pixel(2,219,183);
    assertEquals(219, green.getGreen(),0.01);
  }

  @Test
  public void testGetBlue() {
    Pixel blue = new Pixel(2,10,212);
    assertEquals(212, blue.getBlue(),0.01);
  }

}