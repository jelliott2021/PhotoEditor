package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import controller.miscellaneous.Mosaic;
import controller.transformations.BlueTransform;
import controller.transformations.GreenTransform;
import controller.transformations.LumaColorTransform;
import controller.transformations.RedTransform;
import controller.transformations.SepiaTransform;
import controller.filters.BlurCommand;
import controller.filters.SharpenCommand;
import controller.grey.Intensity;
import controller.grey.ValueScale;
import controller.brightness.Brighten;
import controller.brightness.Darken;
import controller.miscellaneous.FlipHoriz;
import controller.miscellaneous.FlipVert;
import model.IImage;
import model.Pixel;


/**
 * Creates a controller for the user to be able to process an image.
 */
public class ImageController {
  private IImage img; // the model we are working with
  private final Appendable output; // shows the user what is up.
  private final Readable input; // takes in what the user gives.
  private Map<String, Function<Scanner, ImageCommand>> igCommand; // potential commands for the user
  private Pixel[][] grid;
  private String name;

  /**
   * Creates a new controller with a model to work with and an Appendable to communicate with the
   * user.
   * @param image the model or the image the user is manipulating.
   * @param app the appendable to communicate with the user.
   * @param read the readable that reads user inputs.
   * @param name the name of the image the controller is working with.
   * @throws IllegalArgumentException if either the model or the reader is null.
   */
  public ImageController(IImage image, Appendable app, Readable read, String name)
          throws IllegalArgumentException {
    if (image == null || app == null || read == null || name == null) {
      throw new IllegalArgumentException("Model, Readable, and Appendable cannot be null");
    }
    this.img = image;
    this.output = app;
    this.input = read;
    this.name = name;
    this.igCommand =  new HashMap<>();

    igCommand.put("red-scale", scan -> new RedTransform(this.name));
    igCommand.put("blue-scale", scan -> new BlueTransform(this.name));
    igCommand.put("green-scale", scan -> new GreenTransform(this.name));
    igCommand.put("flipHoriz", scan -> new FlipHoriz());
    igCommand.put("flipVert", scan -> new FlipVert());
    igCommand.put("luma", scan -> new LumaColorTransform(scan.next()));
    igCommand.put("intensity", scan -> new Intensity());
    igCommand.put("value-scale", scan -> new ValueScale());
    igCommand.put("brighten", scan -> new Brighten(scan.nextInt()));
    igCommand.put("darken", scan -> new Darken(scan.nextInt()));
    igCommand.put("blur", scan -> new BlurCommand(scan.next()));
    igCommand.put("sharpen", scan -> new SharpenCommand(scan.next()));
    igCommand.put("sepia", scan -> new SepiaTransform(scan.next()));
    igCommand.put("mosaic", scan -> new Mosaic(scan.nextInt()));
  }

  /**
   * Allows for the user to manipulate the image however so they choose.
   */
  public void processImage() {
    Scanner scanner = new Scanner(this.input);

    while (scanner.hasNext()) {
      String command = scanner.next();
      if (command.equalsIgnoreCase("q")) {
        return;
      }
      try {
        Function<Scanner, ImageCommand> comm = igCommand.getOrDefault(command, null);
        ImageCommand cd;
        if (comm == null && !(command.equals("load")) && !(command.equals("save"))) {
          throw new IllegalArgumentException("Not a valid command");
        } else if (command.equals("load")) {
          try {
            String path = scanner.next();
            String name = scanner.next();
            ImageLoad loadIm = new ImageLoad(path, name);
            this.img = loadIm.load();
            this.name = name;
          } catch (IllegalArgumentException ia) {
            throw new IllegalArgumentException(ia.getMessage());
          }
        } else if (command.equals("save")) {
          try {
            String name = scanner.next();
            ImageSaver saveIm = new ImageSaver(img, name);
            saveIm.makeFile(scanner.next());
          } catch (IOException io) {
            throw new IllegalArgumentException(io.getMessage());
          }
        }
        else {
          cd = comm.apply(scanner);
          this.img = cd.process(this.img, this.name);
          this.renderMessage(this.img.toString());
        }
      } catch (InputMismatchException in) {
        throw new IllegalArgumentException(in.getMessage());
      }
    }
    this.renderMessage("Ran out of inputs!");
  }

  /**
   * Renders a message for the user to respond to.
   * @param message the message to be rendered.
   * @throws IllegalArgumentException if the appendable cannot render the message for any reason.
   */
  public void renderMessage(String message) throws IllegalArgumentException {
    try {
      this.output.append(message);
    } catch (IOException ill) {
      throw new IllegalArgumentException(ill.getMessage());
    }
  }
}
