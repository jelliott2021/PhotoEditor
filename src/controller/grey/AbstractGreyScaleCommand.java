package controller.grey;

import controller.ImageCommand;
import model.IImage;
import model.IPixel;
import model.ImageModel;
import model.Pixel;

/**
 * Performs any gray scale command on an image.
 */
public class AbstractGreyScaleCommand implements ImageCommand {
  private String type;
  private String[] types = new String[]{"red", "blue", "green", "value", "intensity", "luma"};

  /**
   * Creates a new gray scale command where all 3 channels are equal to one value.
   * @param type the type of grey scaling we want to do.
   */
  public AbstractGreyScaleCommand(String type) {
    boolean isType = false;
    for (int i = 0; i < types.length; i += 1) {
      if (type.equals(types[i])) {
        isType = true;
      }
    }
    if (isType) {
      this.type = type;
    } else {
      throw new IllegalArgumentException("Not a valid type");
    }
  }

  @Override
  public IImage process(IImage image, String name) {
    IPixel[][] newImage = new Pixel[image.getHeight()][image.getWidth()];
    ImageModel newModel = new ImageModel(newImage, name + " blue-visualized");
    for (int i = 0; i < newImage.length; i++) {
      for (int j = 0; j < newImage[0].length; j++) {
        newImage[i][j] = image.getPixelAt(i, j).redScale();
        if (type.equals("red")) {
          newImage[i][j] = image.getPixelAt(i, j).redScale();
        } else if (type.equals("blue")) {
          newImage[i][j] = image.getPixelAt(i, j).blueScale();
        } else if (type.equals("green")) {
          newImage[i][j] = image.getPixelAt(i, j).greenScale();
        } else if (type.equals("value")) {
          newImage[i][j] = image.getPixelAt(i, j).valueScale();
        } else if (type.equals("intensity")) {
          newImage[i][j] = image.getPixelAt(i, j).intensity();
        } else {
          newImage[i][j] = image.getPixelAt(i, j).luma();
        }
      }
    }
    return newModel;
  }
}
