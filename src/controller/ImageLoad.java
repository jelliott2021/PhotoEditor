package controller;


import java.io.IOException;
import model.IImage;
import model.IPixel;
import model.ImageModel;

/**
 * Given a PPM file and a name, a new Image model is created using the pixels
 * within the PPM the name.
 */
public class ImageLoad {
  private final String file; // the name of the file we want to read
  private final String fileName; // the name we want to give this image

  /**
   * Constructs a new Load command given a file to load and a name we want the
   * image to be called.
   *
   * @param image The file we want to load.
   */
  public ImageLoad(String image, String name) {
    if (image == null || name == null) {
      throw new IllegalArgumentException("Image and Name cannot be null");
    }
    this.file = image;
    this.fileName = name;
  }

  /**
   * Reads the PPM file and converts it into a 2D Pixel array
   * that is then put into our image.
   * @return An Image model containing the converted Pixel array and the desired name.
   */
  private IImage loadPPM() {
    IPixel[][] grid = ImageUtil.readPPM(this.file);
    return new ImageModel(grid, this.fileName);
  }

  /**
   * Loads an given various types such as PPM, PNG, JPG, BMP, etc.
   * @return an ImageModel with a pixel grid and a name.
   */
  public IImage load() {
    int lastThree = this.file.length() - 4;
    if (file.charAt(lastThree) != '.') {
      if (!file.substring(this.file.length() - 5).equals(".jpeg")) {
        throw new IllegalArgumentException("This is not a file");
      }
    }
    if (file.substring(lastThree + 1).equals("ppm")) {
      return loadPPM();
    } else {
      try {
        return loadOtherTypes();
      } catch (IOException io) {
        throw new IllegalArgumentException(io.getMessage());
      }
    }
  }

  /**
   * Reads a PNG, JPG, etc. type of file and converts it into a 2D pixel array before
   * creating an image model out of it.
   * @return An Image Model containing the converted Pixel array and the desired name.
   * @throws IOException if the reading of the file goes wonky.
   */
  private IImage loadOtherTypes() throws IOException {
    IPixel[][] grid = ImageUtil.readOtherTypes(this.file);
    return new ImageModel(grid, this.fileName);
  }
}
