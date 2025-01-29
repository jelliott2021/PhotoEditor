package controller.transformations;

/**
 * Green-scales the image using a matrix and uses the AbstractColorCommand class.
 */
public class GreenTransform extends AbstractColorCommand {
  private static double[] row = new double[]{0, 1, 0};

  /**
   * Creates a green color transform command given the kernel and name of the image.
   * @param name name of the image.
   */
  public GreenTransform(String name) {
    super(new double[][]{row, row, row}, name + " green-visualized");
  }
}