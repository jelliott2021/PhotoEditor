package controller.brightness;

/**
 * Brightens an image by a given factor.
 */
public class Brighten extends AbstractBrightnessCommand {

  /**
   * Creates a new Brighten Command on an image using a factor.
   * @param fact the factor that we want to brighten our image by.
   */
  public Brighten(int fact) {
    super(fact, "brightened");
  }
}

