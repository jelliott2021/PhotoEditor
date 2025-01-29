package controller.miscellaneous;

import controller.ImageCommand;
import model.IImage;
import model.IPixel;
import model.ImageModel;
import model.Pixel;

/**
 * Flips our image vertically.
 */
public class FlipVert implements ImageCommand {

  @Override
  public IImage process(IImage image, String name) {
    IPixel[][] vertGrid = this.flipHelperVert(image);
    return new ImageModel(vertGrid, name + " vertically-flipped");
  }



  /**
   * Helper method to flip the pixel grid vertically.
   * @param img the image we want we flip.
   * @return a new image that is the vertically flipped version of the given image.
   */
  private IPixel[][] flipHelperVert(IImage img) {
    IPixel[][] newGrid = new Pixel[img.getHeight()][img.getWidth()];
    for (int i = 0; i < img.getHeight(); i += 1) {
      int j = 0;
      int k = img.getWidth() - 1;
      while (j < k) {
        newGrid[i][j] = img.getPixelAt(i, k);
        newGrid[i][k] = img.getPixelAt(i, j);
        j += 1;
        k -= 1;
      }
      if (j == k) {
        newGrid[i][j] = img.getPixelAt(i, j);
      }
    }
    return newGrid;
  }



}
