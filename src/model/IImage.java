package model;

/**
 * Represents an image to work with and manipulate.
 */
public interface IImage {

  /**
   * Gives the height of our grid.
   *
   * @return the height of the 2D pixel array.
   */
  int getHeight();

  /**
   * Gives the width of our grid.
   *
   * @return the width of our 2D pixel array.
   */
  int getWidth();

  /**
   * Gets the pixel at the desired location.
   *
   * @param row the row of our desired Pixel.
   * @param col the column of our desired Pixel.
   * @return the Pixel at (row, col).
   */
  IPixel getPixelAt(int row, int col);

  /**
   * Visualizes the red component of the image.
   *
   * @return new image with visualized red component.
   */
  IImage redScale();

  /**
   * Visualizes the blue component of the image.
   *
   * @return new image with visualized blue component.
   */
  IImage blueScale();

  /**
   * Visualizes the green component of the image.
   *
   * @return new image with visualized green component.
   */
  IImage greenScale();

  /**
   * Visualizes the value scale of the image.
   *
   * @return new image with visualized value scale.
   */
  IImage valueScale();

  /**
   * Visualizes the luma of the image.
   *
   * @return new image with visualized luma.
   */
  IImage luma();

  /**
   * Visualizes the intensity  of the image.
   *
   * @return new image with visualized intensity.
   */
  IImage intensity();

  /**
   * Flips the image horizontally.
   *
   * @return flipped horizontally new image
   */
  IImage flipHoriz();

  /**
   * Flips the image vertically.
   *
   * @return flipped vertically new image
   */
  IImage flipVert();

  /**
   * Brightens the image by a given factor.
   *
   * @param factor the factor to brighten
   * @return new brightened image.
   */
  IImage brighten(int factor);

  /**
   * Darkens the image by a given factor.
   *
   * @param factor the factor to darken
   * @return new darkened image.
   */
  IImage darken(int factor);

  /**
   * Gives the user a copy of the pixel grid. It's a copy to avoid user manipulations.
   *
   * @return a 2D pixel array that is a copy of the one that represents this image.
   */
  IPixel[][] getGrid();

  /**
   * Blurs an image.
   *
   * @return new blurred image.
   */
  IImage blur();

  /**
   * Sharpens an image.
   *
   * @return new sharpened image.
   */
  IImage sharpen();

  /**
   * Performs a sepia color transformation on an image.
   *
   * @return new image with sepia colors.
   */
  IImage sepia();

  /**
   * Gets the maximum channel of each of the overall pixel grid.
   * @return max value
   */
  double maxVal();

}
