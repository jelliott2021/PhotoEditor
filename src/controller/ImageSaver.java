package controller;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.IImage;

/**
 * Saves an image onto a new file with a given name for the file.
 */
public class ImageSaver {
  private IImage img;
  private String fileName;

  /**
   * Creates a new Image Saver command that saves a given image onto a file.
   * with the given name.
   * @param image image we are taken in
   * @param name name of image.
   * @throws IllegalArgumentException if the image or name is null.
   */
  public ImageSaver(IImage image, String name) throws IllegalArgumentException {
    if (image == null || name == null) {
      throw new IllegalArgumentException("Image and Name cannot be null");
    }
    this.img = image;
    this.fileName = name;
  }

  /**
   * Writes our pixel grid to an App.
   * @throws IOException if a file can't be made.
   */
  public void makeFile(String fileType) throws IOException {
    boolean isFile = false;
    String[] arr = new String[]{".png", ".bmp", ".jpg", ".jpeg"};
    if (fileType.equals(".ppm")) {
      File txt = new File(this.fileName + fileType);
      this.writeToPPM(txt);
    } else {
      for (int i = 0; i < arr.length; i += 1) {
        if (fileType.equals(arr[i])) {
          isFile = true;
        }
      }
      if (!isFile) {
        throw new IllegalArgumentException("Not a valid file type");
      } else {
        File newFile = new File(this.fileName + fileType);
        BufferedImage buffer = ImageUtil.createBufferedImage(this.img);
        ImageIO.write(buffer, fileType.substring(1), newFile);
      }
    }
  }



  // Writes to a PPM file.
  private void writeToPPM(File file) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    writer.write("P3\n");
    writer.write(img.getHeight() + " " + img.getWidth() + "\n");
    writer.write("" + img.maxVal() + "\n");
    for (int i = 0; i < img.getHeight(); i++) {
      for (int j = 0; j < img.getWidth(); j++) {
        writer.write("" + img.getPixelAt(i, j));
        if (j != img.getWidth() - 1) {
          writer.write("  ");
        } else if (i != img.getHeight() - 1) {
          writer.write("\n");
        }
      }
    }
    writer.close();
  }

}
