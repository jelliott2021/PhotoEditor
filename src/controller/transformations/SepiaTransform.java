package controller.transformations;

/**
 * Sepia-scales the image using a hard coded matrix and uses the AbstractColorCommand class.
 */
public class SepiaTransform extends AbstractColorCommand {
  private static double[] rowOne = new double[]{0.393, 0.769, 0.189};
  private static double[] rowTwo = new double[]{0.349, 0.686, 0.168};
  private static double[] rowThree = new double[]{0.272, 0.534, 0.131};

  /**
   * Creates a sepia color transform command given a kernel and name.
   * @param name name of the image.
   */
  public SepiaTransform(String name) {
    super(new double[][]{rowOne, rowTwo, rowThree}, name + " sepia-scaled");
  }
}

