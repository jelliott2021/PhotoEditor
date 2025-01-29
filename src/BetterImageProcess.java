import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import controller.BetterControllerFeatures;
import controller.ImageController;
import controller.ImageFeatures;
import controller.ImageLoad;
import model.IImage;

/**
 * Processes an image given a script file to work with.
 */
public class BetterImageProcess {

  /**
   * Main method that takes in a script file and runs the commands.
   *
   * @param args the arguments provided by the user.
   * @throws IOException if for some reason processing doesn't work properly
   *                     specifically with loading.
   */
  public static void main(String[] args) throws IOException {
    IImage model;
    if (args.length == 0) {
      ImageFeatures controller = new BetterControllerFeatures();
      controller.execute();
    } else if (args[0].equals("-text")) {
      Scanner scan = new Scanner(System.in);
      if (!scan.next().equals("load")) {
        throw new IllegalArgumentException("No image to work with");
      } else {
        try {
          ImageLoad loader = new ImageLoad(scan.next(), scan.next());
          model = loader.load();
          ImageController controller = new ImageController(model, System.out,
                  new InputStreamReader(System.in), "newImage");
        } catch (IllegalArgumentException ia) {
          throw new IllegalArgumentException(ia.getMessage());
        }
      }
    } else if (args[0].equals("-file")) {
      if (args.length == 1) {
        throw new IllegalArgumentException("No file to work with");
      } else {
        BufferedReader reader = new BufferedReader(new FileReader(args[1]));
        String secondLine = reader.readLine();
        if (!secondLine.startsWith("load")) {
          throw new IllegalArgumentException("No image to work with");
        } else {
          String fileName = "";
          int charVal = 5;
          while (secondLine.charAt(charVal) != ('.')) {
            fileName = fileName.concat(secondLine.substring(charVal, charVal + 1));
            charVal += 1;
          }
          fileName = fileName.concat(secondLine.substring(charVal, charVal + 4));
          String name = secondLine.substring(charVal + 5);
          model = new ImageLoad(fileName, name).load();
          ImageController controller = new ImageController(model, System.out,
                  reader, name);
          controller.processImage();
        }
      }
    }
  }
}




