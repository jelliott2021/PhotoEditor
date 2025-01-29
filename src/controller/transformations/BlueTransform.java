package controller.transformations;

/**
 * Blue-scales the image using a matrix and uses the AbstractColorCommand class.
 */
public class BlueTransform extends AbstractColorCommand {
  private static double[] row = new double[]{0, 0, 1};


  /**
   * Creates a blue color transform  command given the name of the image and a kernel.
   * @param name name of the image.
   */
  public BlueTransform(String name) {
    super(new double[][]{row, row, row}, name + " blue-visualized");
  }
}
