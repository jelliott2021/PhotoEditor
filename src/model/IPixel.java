package model;

/**
 * Represents an individual pixel of an image.
 */
public interface IPixel {
  /**
   * Sets all pixel values to red value.
   *
   * @return new pixel with all red values
   */
  IPixel redScale();

  /**
   * Sets all pixel values to blue value.
   *
   * @return new pixel with all blue values
   */
  IPixel blueScale();

  /**
   * Sets all pixel values to green value.
   *
   * @return new pixel with all green values
   */
  IPixel greenScale();

  /**
   * Sets all pixel values to value.
   *
   * @return new value with all value values
   */
  IPixel valueScale();

  /**
   * Sets all pixel values to intensity.
   *
   * @return new pixel with all intensity values
   */
  IPixel intensity();

  /**
   * Sets all pixel values to luma.
   *
   * @return new pixel with all luma values
   */
  IPixel luma();

  /**
   * Brightens a pixel by a given factor.
   *
   * @param factor the factor to brighten
   * @return new brightened pixel
   */
  IPixel brighten(int factor);


  /**
   * Darkens a pixel by a given factor.
   *
   * @param factor the factor to darken
   * @return new darkened pixel
   */
  IPixel darken(int factor);


  /**
   * Returns value of whole pixel.
   *
   * @return value of pixel
   */
  double maxVal();

  /**
   * Multiplies the red channel by a constant.
   *
   * @param cont the constant to multiply by
   * @return the product of the red channel val and the constant.
   */
  double multRed(double cont);


  /**
   * Multiplies the green channel by a constant.
   *
   * @param cont the constant to multiply by
   * @return the product of the green channel val and the constant.
   */
  double multGreen(double cont);


  /**
   * Multiplies the blue channel by a constant.
   *
   * @param cont the constant to multiply by
   * @return the product of the blue channel val and the constant.
   */
  double multBlue(double cont);

  /**
   * Returns the red component.
   *
   * @return the red component of the pixel
   */
  double getRed();

  /**
   * Returns the blue component.
   *
   * @return the blue component of the pixel
   */
  double getBlue();

  /**
   * Returns the green component.
   *
   * @return the green component of the pixel
   */
  double getGreen();

  /**
   * Returns the intensity component.
   *
   * @return the intensity component of the pixel
   */
  double getIntensity();
}
