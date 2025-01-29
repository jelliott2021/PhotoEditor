package controller;

import java.io.IOException;

import model.IImage;
import view.ImageGUIView;

/**
 * A Mock HUI created for testing purposes.
 */
public class MockGUI implements ImageGUIView {
  Appendable app;

  /**
   * Creates a mock gui with a string builder to ensure that
   * the controller is accepted by the view.
   * @param sb the String Builder to take in.
   */
  MockGUI(StringBuilder sb) {
    this.app = sb;
  }

  @Override
  public void updateScreen(IImage img) {
    try {
      app.append("Updated");
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }

  @Override
  public void renderMessage(String message) {
    try {
      app.append("Rendered");
    } catch (IOException io) {
      throw new IllegalArgumentException(io.getMessage());
    }
  }
}
