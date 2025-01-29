package controller;

import controller.miscellaneous.Mosaic;
import model.IImage;
import model.ImageModel;
import model.Pixel;
import view.BetterImageFrame;

public class BetterControllerFeatures implements ImageFeatures {
  private ControllerFeatures controller;
  private BetterImageFrame view;
  private IImage model;
  private String name;

  public BetterControllerFeatures() {
    this.name = "Image";
    this.view = new BetterImageFrame();
    this.model = new ImageModel(new Pixel[1][1], name);
    this.controller = new ControllerFeatures(name, view, model);
  }


  /**
   * Executes controller
   */
  @Override
  public void execute() {
    controller.execute();
    view.getMosaic().addActionListener(evt -> processCommand(new Mosaic(view.getMosaicFactor())));
  }

  private void processCommand(ImageCommand comm) {
    controller.processCommand(comm);
  }
}
