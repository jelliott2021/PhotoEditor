package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import model.IImage;
import model.IPixel;
import model.Pixel;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static IPixel[][] readPPM(String filename) {
    Scanner sc;
    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("No file");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int height = sc.nextInt();
    int width = sc.nextInt();
    double max = sc.nextDouble();

    IPixel[][] data = new IPixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        double r = sc.nextDouble();
        double g = sc.nextDouble();
        double b = sc.nextDouble();
        data[i][j] = new Pixel(r, g, b);
      }
    }
    return data;
  }

  /**
   * Reads a file of a type other than PPM (like PNG, JPG, etc.) creates a Pixel Grid out of it.
   * @param filename the file to be read.
   * @return the 2D Pixel array of all the RGB values.
   * @throws IOException if the file cannot be read for some reason.
   */
  public static IPixel[][] readOtherTypes(String filename) throws IOException {
    BufferedImage buffer = ImageIO.read(new File(filename));
    IPixel[][] grid = new IPixel[buffer.getHeight()][buffer.getWidth()];
    for (int i = 0; i < buffer.getHeight(); i += 1) {
      for (int j = 0; j < buffer.getWidth(); j += 1) {
        int color = buffer.getRGB(j, i);
        Color col = new Color(color);
        IPixel pix = new Pixel(col.getRed(), col.getGreen(), col.getBlue());
        grid[i][j] = pix;
      }
    }
    return grid;
  }

  /**
   * A main that is used to name the file.
   * @param args the arguments that contain the name of the file.
   */
  //demo main
  public static void main(String[] args) {
    String filename;

    if (args.length > 0) {
      filename = args[0];
    } else {
      filename = "sample.ppm";
    }

    ImageUtil.readPPM(filename);
  }

  /**
   * Creates a BufferedImage representation of our given image.
   * @param img the image to convert.
   * @return the BufferedImage representation of our image.
   */
  public static BufferedImage createBufferedImage(IImage img) {
    BufferedImage buffer = new BufferedImage(img.getWidth(), img.getHeight(),
            BufferedImage.TYPE_INT_RGB);
    for (int i = 0; i < buffer.getWidth(); i += 1) {
      for (int j = 0; j < buffer.getHeight(); j += 1) {
        Color color = new Color((int) img.getPixelAt(j, i).getRed(),
                (int) img.getPixelAt(j, i).getGreen(),
                (int) img.getPixelAt(j, i).getBlue());
        buffer.setRGB(i, j, color.getRGB());
      }
    }
    return buffer;
  }
}

