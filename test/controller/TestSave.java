package controller;

import org.junit.Test;
import java.io.IOException;

import controller.transformations.BlueTransform;
import controller.transformations.GreenTransform;
import controller.transformations.LumaColorTransform;
import controller.transformations.RedTransform;
import controller.transformations.SepiaTransform;
import controller.filters.BlurCommand;
import controller.filters.SharpenCommand;
import model.IImage;
import model.ImageModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests our saving.
 */
public class TestSave {

  @Test(expected = IllegalArgumentException.class)
  public void testNullImage() {
    ImageSaver nullImage = new ImageSaver(null, "rainbow");
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

    ImageModel valid = new ImageModel(arrImage, "smaller!");

    ImageSaver nullName = new ImageSaver(valid, null);
  }

  @Test
  public void testSavePPM() {
    Pixel pxOne = new Pixel(237, 28, 36);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(255, 242, 0);
    Pixel pxFour = new Pixel(205, 85, 207);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    IImage toSave = new ImageModel(arrImage, "smallRainbow");
    ImageSaver save = new ImageSaver(toSave, "smallR");
    try {
      save.makeFile(".ppm");
      ImageLoad loadPPM = new ImageLoad("smallR.ppm", "smallRainbow");
      IImage sR = loadPPM.load();
      assertEquals(sR, toSave);
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }

  @Test
  public void testSavePNG() {
    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);


    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    IImage toSave = new ImageModel(arrImage, "scoobyColors");
    ImageSaver save = new ImageSaver(toSave, "scooby");
    try {
      save.makeFile(".png");
      IImage loaded = new ImageLoad("scooby.png", "scoobyColors").load();
      assertEquals(loaded, toSave);
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }

  @Test
  public void testCreateBlurPNG() {
    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage colors = new ImageModel(arrImage, "randomColors");

    ImageCommand blur = new BlurCommand("randomColors");
    IImage blurred = blur.process(colors, "randomColors");
    ImageSaver save = new ImageSaver(blurred, "blurred");
    try {
      save.makeFile(".png");
      IImage loaded = new ImageLoad("blurred.png", "randomColors "
              + "blurred").load();
      for (int i = 0; i < blurred.getHeight(); i += 1) {
        for (int j = 0; j < blurred.getWidth(); j += 1) {
          int red = (int) blurred.getPixelAt(i, j).getRed();
          int green = (int) blurred.getPixelAt(i, j).getGreen();
          int blue = (int) blurred.getPixelAt(i, j).getBlue();
          assertEquals(red, (int) loaded.getPixelAt(i, j).getRed());
          assertEquals(green, (int) loaded.getPixelAt(i, j).getGreen());
          assertEquals(blue, (int) loaded.getPixelAt(i, j).getBlue());
        }
      }
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }


  @Test
  public void testCreateLuma() {
    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage colors = new ImageModel(arrImage, "randomColors");

    ImageCommand luma = new LumaColorTransform("randomColors");
    IImage lumad = luma.process(colors, "randomColors");
    ImageSaver save = new ImageSaver(lumad, "luma-scaled");
    try {
      save.makeFile(".png");
      IImage loaded = new ImageLoad("luma-scaled.png", "randomColors "
              + "luma-visualized").load();
      for (int i = 0; i < lumad.getHeight(); i += 1) {
        for (int j = 0; j < lumad.getWidth(); j += 1) {
          int red = (int) lumad.getPixelAt(i, j).getRed();
          int green = (int) lumad.getPixelAt(i, j).getGreen();
          int blue = (int) lumad.getPixelAt(i, j).getBlue();
          assertEquals(red, (int) loaded.getPixelAt(i, j).getRed());
          assertEquals(green, (int) loaded.getPixelAt(i, j).getGreen());
          assertEquals(blue, (int) loaded.getPixelAt(i, j).getBlue());
        }
      }
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }


  @Test
  public void testCreateRed() {
    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage colors = new ImageModel(arrImage, "randomColors");

    ImageCommand red = new RedTransform("randomColors");
    IImage redder = red.process(colors, "randomColors");
    ImageSaver save = new ImageSaver(redder, "red-scaled");
    try {
      save.makeFile(".png");
      IImage loaded = new ImageLoad("red-scaled.png", "randomColors "
              + "red-visualized").load();
      assertEquals(redder, loaded);
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }

  @Test
  public void testCreateBlue() {
    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage colors = new ImageModel(arrImage, "randomColors");

    ImageCommand blue = new BlueTransform("randomColors");
    IImage bluer = blue.process(colors, "randomColors");
    ImageSaver save = new ImageSaver(bluer, "blue-scaled");
    try {
      save.makeFile(".png");
      IImage loaded = new ImageLoad("blue-scaled.png", "randomColors "
              + "blue-visualized").load();
      assertEquals(bluer, loaded);
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }

  @Test
  public void testCreateGreen() {
    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage colors = new ImageModel(arrImage, "randomColors");

    ImageCommand green = new GreenTransform("randomColors");
    IImage greener = green.process(colors, "randomColors");
    ImageSaver save = new ImageSaver(greener, "green-scaled");
    try {
      save.makeFile(".png");
      IImage loaded = new ImageLoad("green-scaled.png", "randomColors "
              + "green-visualized").load();
      assertEquals(greener, loaded);
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }

  @Test
  public void testCreateSepia() {
    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage colors = new ImageModel(arrImage, "randomColors");

    ImageCommand sepia = new SepiaTransform("randomColors");
    IImage sepiad = sepia.process(colors, "randomColors");
    ImageSaver save = new ImageSaver(sepiad, "sepia-scaled");
    try {
      save.makeFile(".png");
      IImage loaded = new ImageLoad("sepia-scaled.png",
              "randomColors sepia-scaled").load();
      for (int i = 0; i < sepiad.getHeight(); i += 1) {
        for (int j = 0; j < sepiad.getWidth(); j += 1) {
          int red = (int) sepiad.getPixelAt(i, j).getRed();
          int green = (int) sepiad.getPixelAt(i, j).getGreen();
          int blue = (int) sepiad.getPixelAt(i, j).getBlue();
          assertEquals(red, (int) loaded.getPixelAt(i, j).getRed());
          assertEquals(green, (int) loaded.getPixelAt(i, j).getGreen());
          assertEquals(blue, (int) loaded.getPixelAt(i, j).getBlue());
        }
      }
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }



  @Test
  public void testCreateSharpPNG() {
    Pixel pxOne = new Pixel(204, 71, 31);
    Pixel pxTwo = new Pixel(143, 241, 118);
    Pixel pxThree = new Pixel(0, 57, 140);
    Pixel pxFour = new Pixel(255, 185, 252);

    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};
    IImage colors = new ImageModel(arrImage, "randomColors");

    ImageCommand sharpen = new SharpenCommand("randomColors");
    IImage sharpened = sharpen.process(colors, "randomColors");
    ImageSaver save = new ImageSaver(sharpened, "sharpened");
    try {
      save.makeFile(".png");
      IImage loaded = new ImageLoad("sharpened.png", "randomColors sharpened").load();
      for (int i = 0; i < sharpened.getHeight(); i += 1) {
        for (int j = 0; j < sharpened.getWidth(); j += 1) {
          int red = (int) sharpened.getPixelAt(i, j).getRed();
          int green = (int) sharpened.getPixelAt(i, j).getGreen();
          int blue = (int) sharpened.getPixelAt(i, j).getBlue();
          assertEquals(red, (int) loaded.getPixelAt(i, j).getRed());
          assertEquals(green, (int) loaded.getPixelAt(i, j).getGreen());
          assertEquals(blue, (int) loaded.getPixelAt(i, j).getBlue());
        }
      }
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }

  @Test
  public void testSaveBMP() {
    Pixel pxOne = new Pixel(237, 28, 36);
    Pixel pxTwo = new Pixel(255, 127, 39);
    Pixel pxThree = new Pixel(255, 242, 0);
    Pixel pxFour = new Pixel(205, 85, 207);



    Pixel[] rowOne = new Pixel[]{pxOne, pxTwo};
    Pixel[] rowTwo = new Pixel[]{pxThree, pxFour};

    Pixel[][] arrImage = new Pixel[][]{rowOne, rowTwo};

    IImage toSave = new ImageModel(arrImage, "smallRainbow");
    ImageSaver save = new ImageSaver(toSave, "smallR4");
    try {
      save.makeFile(".bmp");
      IImage loaded = new ImageLoad("smallR4.bmp", "smallRainbow").load();
      assertEquals(toSave, loaded);
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }


  }


}
