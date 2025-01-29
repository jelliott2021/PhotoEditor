package view;

import controller.ImageFeatures;
import model.IImage;

/**
 * A GUI Based view for image processing fun.
 */
public interface ImageGUIView {

  /**
   * Updates the screen being looked at.
   */
  void updateScreen(IImage img);

  /**
   * Puts up a message on the screen for the user to see.
   * @param message the message to be rendered.
   */
  void renderMessage(String message);
}
