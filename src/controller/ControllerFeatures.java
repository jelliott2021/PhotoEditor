package controller;

import java.io.File;
import java.io.IOException;

import javax.swing.*;

import controller.brightness.Brighten;
import controller.brightness.Darken;
import controller.filters.BlurCommand;
import controller.filters.SharpenCommand;
import controller.grey.Intensity;
import controller.grey.ValueScale;
import controller.miscellaneous.FlipHoriz;
import controller.miscellaneous.FlipVert;
import controller.miscellaneous.Mosaic;
import controller.transformations.BlueTransform;
import controller.transformations.GreenTransform;
import controller.transformations.LumaColorTransform;
import controller.transformations.RedTransform;
import controller.transformations.SepiaTransform;
import model.IImage;
import model.ImageModel;
import model.Pixel;
import view.ImageFrame;

/**
 * Rerepsents a controller that connects commands to a GUI view.
 */
public class ControllerFeatures implements ImageFeatures {
  private final String name;
  private final ImageFrame view;
  private IImage model;

  /**
   * Creates a new features controller for the GUI to accept.
   */
  public ControllerFeatures() {
    this.name = "Image";
    this.view = new ImageFrame(this.name);
    this.model = new ImageModel(new Pixel[1][1], this.name);
  }

  public ControllerFeatures(String name, ImageFrame view, IImage model) {
    this.name = name;
    this.view = view;
    this.model = model;
  }

  public void execute() {
    view.getRedScale().addActionListener(evt -> processCommand((new RedTransform(this.name))));
    view.getBlueScale().addActionListener(evt -> processCommand(new BlueTransform(this.name)));
    view.getGreenScale().addActionListener(evt -> processCommand(new GreenTransform(this.name)));
    view.getValueScale().addActionListener(evt -> processCommand(new ValueScale()));
    view.getIntensityScale().addActionListener(evt -> processCommand(new Intensity()));
    view.getLuma().addActionListener(evt -> processCommand(new LumaColorTransform(this.name)));
    view.getBlur().addActionListener(evt -> processCommand(new BlurCommand(this.name)));
    view.getSharpen().addActionListener(evt -> processCommand(new SharpenCommand(this.name)));
    view.getSepia().addActionListener(evt -> processCommand(new SepiaTransform(this.name)));
    view.getFlipVert().addActionListener(evt -> processCommand(new FlipVert()));
    view.getFlipHoriz().addActionListener(evt -> processCommand(new FlipHoriz()));
    view.getLoad().addActionListener(evt -> chooseFile());
    view.getSave().addActionListener(evt -> saveFile());
    view.getBrighten().addActionListener(evt -> processCommand(new Brighten(
            view.getBrightenFactor())));
    view.getDarken().addActionListener(evt -> processCommand(new Darken(view.getDarkenFactor())));
  }

  // Creates a file chooser set to the desktop directory of this macbook to load an image.
  private void chooseFile() {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new File("/Users/raisabh/Desktop"));
    chooser.showOpenDialog(view.getLoad());
    File chosenOne = chooser.getSelectedFile();
    this.model = new ImageLoad(chosenOne.getPath(), this.name).load();
    view.updateScreen(this.model);
  }

  // Saves the current image we are working on as a file.
  private void saveFile() {
    String response = JOptionPane.showInputDialog(this, "File type to save to");
    ImageSaver canSave = new ImageSaver(this.model, this.name);
    try {
      canSave.makeFile(response);
    } catch (IOException io) {
      view.renderMessage(io.getMessage());
    }
  }

  /**
   * Perform a given command on a given image.
   *
   * @param comm  the command to perform.
   */
  public void processCommand(ImageCommand comm) {
    this.model = comm.process(this.model, this.name);
    view.updateScreen(this.model);
  }
}
