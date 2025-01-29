package controller.brightness;

/**
 * Darkens an image by a given factor.
 */
public class Darken extends AbstractBrightnessCommand {

  /**
   * Creates a new Darken command using a given factor.
   * @param fact the factor we are darkening the image by.
   */
  public Darken(int fact) {
    super(fact, "darkened");
  }
}
