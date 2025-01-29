package controller.transformations;

/**
 * Red-scales the image using a matrix and uses the AbstractColorCommand class.
 */
public class RedTransform extends AbstractColorCommand {
  private static double[] row = new double[]{1.0, 0, 0};

  /**
   * Creates a red color transform command given a kernel and name.
   * @param name name of the image.
   */
  public RedTransform(String name) {
    super(new double[][]{row, row, row}, name + " red-visualized");
  }
}
