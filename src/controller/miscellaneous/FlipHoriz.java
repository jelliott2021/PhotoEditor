package controller.miscellaneous;

import controller.ImageCommand;
import model.IImage;
import model.IPixel;
import model.ImageModel;
import model.Pixel;

/**
 * Flips our image horizontally.
 */
public class FlipHoriz implements ImageCommand {

  /**
   * Creates a flip vertical command given a grid to vertically flip.
   */
  @Override
  public IImage process(IImage image, String name) {
    IPixel[][] horizGrid = this.flipHelperHorizontally(image);
    return new ImageModel(horizGrid, name + " horizontally-flipped");
  }

  /**
   * Helper method to flip the pixel grid horizontally.
   *
   * @param img the image we want to flip horizontally.
   * @return a new image that is the horizontally flipped version of the given image.
   */
  private IPixel[][] flipHelperHorizontally(IImage img) {
    IPixel[][] newGrid = new Pixel[img.getHeight()][img.getWidth()];
    for (int i = 0; i < img.getWidth(); i += 1) {
      int j = 0;
      int k = img.getHeight() - 1;
      while (j < k) {
        newGrid[k][i] = img.getPixelAt(j, i);
        newGrid[j][i] = img.getPixelAt(k, i);
        j += 1;
        k -= 1;
      }
      if (j == k) {
        newGrid[j][i] = img.getPixelAt(j, i);
      }
    }
    return newGrid;
  }
}
