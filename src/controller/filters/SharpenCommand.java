package controller.filters;

/**
 * Sharpens an image.
 */
public class SharpenCommand extends AbstractFilterCommand {
  private static double[] row1 = new double[]{-1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0,
      -1.0 / 8.0};
  private static double[] row2 = new double[]{-1.0 / 8.0, 1.0 / 4.0, 1.0 / 4.0, 1.0 / 4.0,
      -1.0 / 8.0};
  private static double[] row3 = new double[]{-1.0 / 8.0, 1.0 / 4.0, 1.0, 1.0 / 4.0, -1.0 / 8.0};

  /**
   * Creates a new command to sharpen an image using a given channel.
   * @param name the new name to name the image.
   */
  public SharpenCommand(String name) {
    super(new double[][]{row1, row2, row3, row2, row1},
            name + " sharpened");
  }
}
