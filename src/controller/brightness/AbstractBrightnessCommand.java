package controller.brightness;

import controller.ImageCommand;
import model.IImage;
import model.IPixel;
import model.ImageModel;
import model.Pixel;

/**
 * Abstracted brighten and darken commands. Manipulates the brightness level of an image.
 */
public class AbstractBrightnessCommand implements ImageCommand {
  private int factor;
  private String type;

  /**
   * Creates a new brightness command on an image using a factor that manipulates
   * brightness levels.
   * @param fact the factor that we want to brighten our image by.
   */
  public AbstractBrightnessCommand(int fact, String type) {
    if (type == null) {
      throw new IllegalArgumentException("Type cannot be null");
    }
    if (!type.equals("brightened") && !type.equals("darkened")) {
      throw new IllegalArgumentException("Not a brightness argument");
    }
    this.factor = fact;
    this.type = type;
  }

  @Override
  public IImage process(IImage image, String name) {
    IPixel[][] newImage = new Pixel[image.getHeight()][image.getWidth()];
    ImageModel newModel = new ImageModel(newImage, name + " " + type);
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        if (type.equals("brightened")) {
          newImage[i][j] = image.getPixelAt(i, j).brighten(factor);
        } else {
          newImage[i][j] = image.getPixelAt(i, j).darken(factor);
        }
      }
    }
    return newModel;
  }
}
