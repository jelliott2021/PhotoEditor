package controller.transformations;

import controller.ImageCommand;
import model.IImage;
import model.IPixel;
import model.ImageModel;
import model.Pixel;

/**
 * Represents a color command that takes in a certain color command and a kernel.
 */
public class AbstractColorCommand implements ImageCommand {
  protected final double[][] matrix;
  protected final String nameOfCommand;

  /**
   * Constructs a color command based on an array and the name of the command.
   * @param arr array we are taking in.
   * @param nameOfCommand the name of the command.
   */
  public AbstractColorCommand(double[][] arr, String nameOfCommand) {
    if (arr == null || arr.length != arr[0].length || arr.length != 3) {
      throw new IllegalArgumentException("The matrix must be a 3 x 3 array");
    }
    if (nameOfCommand == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.matrix = arr;
    this.nameOfCommand = nameOfCommand;
  }

  @Override
  public IImage process(IImage image, String name) {
    IPixel[][] newImg = new Pixel[image.getHeight()][image.getWidth()];
    for (int i = 0; i < image.getHeight(); i += 1) {
      for (int j = 0; j < image.getWidth(); j += 1) {
        double newRed = image.getPixelAt(i, j).multRed(this.matrix[0][0])
                + image.getPixelAt(i, j).multGreen(this.matrix[0][1])
                + image.getPixelAt(i, j).multBlue(this.matrix[0][2]);

        double newGreen = image.getPixelAt(i, j).multRed(this.matrix[1][0])
                + image.getPixelAt(i, j).multGreen(this.matrix[1][1])
                + image.getPixelAt(i, j).multBlue(this.matrix[1][2]);

        double newBlue = image.getPixelAt(i, j).multRed(this.matrix[2][0])
                + image.getPixelAt(i, j).multGreen(this.matrix[2][1])
                + image.getPixelAt(i, j).multBlue(this.matrix[2][2]);

        if (newRed < 0) {
          newRed = 0;
        }
        if (newRed > 255) {
          newRed = 255;
        }

        if (newGreen < 0) {
          newGreen = 0;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }

        if (newBlue < 0) {
          newBlue = 0;
        }

        if (newGreen > 255) {
          newGreen = 255;
        }

        newImg[i][j] = new Pixel(newRed, newGreen, newBlue);
      }
    }
    return new ImageModel(newImg, nameOfCommand);
  }
}
