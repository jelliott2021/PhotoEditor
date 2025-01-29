package model;

import java.util.Arrays;
import java.util.Objects;

import controller.transformations.BlueTransform;
import controller.filters.BlurCommand;
import controller.brightness.Brighten;
import controller.brightness.Darken;
import controller.miscellaneous.FlipHoriz;
import controller.miscellaneous.FlipVert;
import controller.transformations.GreenTransform;
import controller.ImageCommand;
import controller.grey.Intensity;
import controller.transformations.LumaColorTransform;
import controller.transformations.RedTransform;
import controller.transformations.SepiaTransform;
import controller.filters.SharpenCommand;
import controller.grey.ValueScale;

/**
 * Represents an image model.
 */
public class ImageModel implements IImage {

  private IPixel[][] image;// image
  private String name; //name of image


  /**
   * Constructs a model using the name of the image and the imageName.
   *
   * @param image     image
   * @param imageName imageName
   */
  public ImageModel(IPixel[][] image, String imageName) {
    if (image == null || imageName == null) {
      throw new IllegalArgumentException("Model and name cannot be null");
    }
    this.image = image;
    this.name = imageName;
  }

  /**
   * Accepts a command and performs it on our image.
   *
   * @param comm the command we want to run
   * @return the new image after being manipulated.
   */
  public IImage accept(ImageCommand comm, String name) {
    return comm.process(this, name);
  }

  @Override
  public IImage redScale() {
    return this.accept(new RedTransform(this.name), this.name);
  }

  @Override
  public IImage blueScale() {
    return this.accept(new BlueTransform(this.name), this.name);
  }

  @Override
  public IImage greenScale() {
    return this.accept(new GreenTransform(this.name), this.name);
  }

  @Override
  public IImage valueScale() {
    return this.accept(new ValueScale(), this.name);
  }


  @Override
  public IImage intensity() {
    return this.accept(new Intensity(), this.name);
  }

  @Override
  public IImage luma() {
    return this.accept(new LumaColorTransform(this.name), this.name);
  }


  @Override
  public IImage flipHoriz() {
    return this.accept(new FlipHoriz(), this.name);
  }


  @Override
  public IImage flipVert() {
    return this.accept(new FlipVert(), this.name);
  }


  @Override
  public IImage brighten(int factor) {
    return this.accept(new Brighten(factor), this.name);
  }


  @Override
  public IImage darken(int factor) {
    return this.accept(new Darken(factor), this.name);
  }

  @Override
  public IImage blur() {
    return this.accept(new BlurCommand(this.name), this.name);
  }

  @Override
  public IImage sharpen() {
    return this.accept(new SharpenCommand(this.name), this.name);
  }

  @Override
  public IImage sepia() {
    return this.accept(new SepiaTransform(this.name), this.name);
  }


  @Override
  public double maxVal() {
    double max = 0;
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        if (image[i][j].maxVal() > max) {
          max = image[i][j].maxVal();
        }
      }
    }
    return max;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ImageModel)) {
      return false;
    }

    ImageModel o = (ImageModel) other;
    if (this.image.length != o.image.length) {
      return false;
    }

    if (this.image[0].length != o.image[0].length) {
      return false;
    }

    if (!this.name.equals(o.name)) {
      return false;
    }

    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        if (!this.image[i][j].equals(o.image[i][j])) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.deepHashCode(this.image), this.name);
  }

  /**
   * Prints out the 2D pixel array representing our image. Also prints the updated name.
   *
   * @return A string denoting the individual pixels in the array.
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append(this.name + "\n");
    for (int i = 0; i < this.image.length; i += 1) {
      for (int j = 0; j < this.image[0].length; j += 1) {
        str.append(this.image[i][j].toString() + "\n");
      }
    }
    return str.toString();
  }

  @Override
  public int getHeight() {
    return this.image.length;
  }

  @Override
  public int getWidth() {
    return this.image[0].length;
  }

  @Override
  public IPixel getPixelAt(int row, int col) {
    if (row < 0 || row > this.getHeight() || col < 0 || col > this.getWidth()) {
      throw new IllegalArgumentException("Not valid coordinates");
    } else {
      return this.image[row][col];
    }
  }

  @Override
  public IPixel[][] getGrid() {
    return Arrays.copyOf(this.image, this.image.length);
  }
}


