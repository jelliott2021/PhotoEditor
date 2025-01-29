package controller.filters;

import controller.ImageCommand;
import model.IImage;
import model.IPixel;
import model.ImageModel;
import model.Pixel;

/**
 * Represents an abstract filter command that takes in the name of the command and an array.
 */
public class AbstractFilterCommand implements ImageCommand {
  protected final double[][] kernel;
  protected final String nameOfCommand;

  /**
   * Constructs a  filter command that takes in the array and command name.
   * @param arr array we want to take in.
   * @param nameOfCommand the name of the filter command we want to take in.
   */
  public AbstractFilterCommand(double[][] arr, String nameOfCommand) {
    if (arr == null || arr.length != arr[0].length || arr.length % 2 == 0) {
      throw new
              IllegalArgumentException("The kernel must be a 2D square matrix with odd dimensions");
    }
    if (nameOfCommand == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.kernel = arr;
    this.nameOfCommand = nameOfCommand;
  }

  @Override
  public IImage process(IImage image, String name) {
    IPixel[][] newImg = new Pixel[image.getHeight()][image.getWidth()];
    for (int i = 0; i < image.getHeight(); i += 1) {
      for (int j = 0; j < image.getWidth(); j += 1) {
        int distanceToCenter = this.getCenter(this.kernel);
        newImg[i][j] = this.performFilter(image, i - distanceToCenter,
                j - distanceToCenter, i + distanceToCenter,
                j + distanceToCenter);
      }
    }
    return new ImageModel(newImg, this.nameOfCommand);
  }

  /**
   * Given a square array, return the center value for it.
   * @return the center value for a square array.
   */
  private int getCenter(double[][] arr) {
    return arr.length / 2;
  }

  /**
   * Performs a filtration on a set of pixels.
   * @return a new Pixel that contains the effects of the filtration.
   */
  private IPixel performFilter(IImage img, int startRow, int startCol, int endRow, int endCol) {
    double redSum = 0;
    double greenSum = 0;
    double blueSum = 0;
    for (int i = startRow; i <= endRow; i += 1) {
      for (int j = startCol; j <= endCol; j += 1) {
        if (i > img.getHeight() - 1 || i < 0 || j > img.getWidth() - 1 || j  < 0) {
          redSum += 0;
          greenSum += 0;
          blueSum += 0;
        } else {
          redSum += img.getPixelAt(i, j).multRed(this.kernel[i - startRow][j - startCol]);
          greenSum += img.getPixelAt(i, j).multGreen(this.kernel[i - startRow][j - startCol]);
          blueSum += img.getPixelAt(i, j).multBlue(this.kernel[i - startRow][j - startCol]);
        }
      }
    }
    if (redSum > 255) {
      redSum = 255;
    }
    if (redSum < 0) {
      redSum = 0;
    }
    if (greenSum > 255) {
      greenSum = 255;
    }
    if (greenSum < 0) {
      greenSum = 0;
    }
    if (blueSum > 255) {
      blueSum = 255;
    }
    if (blueSum < 0) {
      blueSum = 0;
    }
    return new Pixel(redSum, greenSum, blueSum);
  }
}