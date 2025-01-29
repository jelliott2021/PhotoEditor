package controller.filters;

/**
 * Blurs an image.
 */
public class BlurCommand extends AbstractFilterCommand {
  private static double[] row1 = new double[]{1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0};
  private static double[] row2 = new double[]{1.0 / 8.0, 1.0 / 4.0, 1.0 / 8.0};

  /**
   * Creates a new command to blur an image using a kernel and name.
   * @param name the new name to name the image.
   */
  public BlurCommand(String name) {
    super(new double[][]{row1, row2, row1}, name + " blurred");
  }
}

