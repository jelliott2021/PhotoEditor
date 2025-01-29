package controller.transformations;

/**
 * Luma-scales the image using a hard coded matrix and uses the AbstractColorCommand class.
 */
public class LumaColorTransform extends AbstractColorCommand {
  private static double[] row = new double[]{0.2126, 0.7152, 0.0722};

  /**
   * Creates a luma color transform command given a kernel and name.
   * @param name name of the image.
   */
  public LumaColorTransform(String name) {
    super(new double[][]{row, row, row}, name + " luma-visualized");
  }
}