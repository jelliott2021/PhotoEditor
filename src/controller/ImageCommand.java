package controller;

import model.IImage;


/**
 * Represents an Image Command that is enacted upon an image.
 */
public interface ImageCommand {

  /**
   * Performs some sort of manipulation on a given image.
   * @param image the image to be manipulated.
   * @param name our desired name for this new image.
   * @return the new image that has been created after the manipulation.
   */
  IImage process(IImage image, String name);
}
