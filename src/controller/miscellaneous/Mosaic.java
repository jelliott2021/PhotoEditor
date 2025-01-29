package controller.miscellaneous;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import controller.ImageCommand;
import model.IImage;
import model.IPixel;
import model.ImageModel;
import model.Pixel;

//todo
public class Mosaic implements ImageCommand {
  private Map<Point, ArrayList<Point>> seeds;
  private final int numSeeds;

  public Mosaic(int numSeeds) {
    this.numSeeds = numSeeds;
    this.seeds = new HashMap<Point, ArrayList<Point>>();
  }

  /**
   * Performs some sort of manipulation on a given image.
   *
   * @param image the image to be manipulated.
   * @param name  our desired name for this new image.
   * @return the new image that has been created after the manipulation.
   */
  @Override
  public IImage process(IImage image, String name) {
    int height = image.getHeight();
    int width = image.getWidth();
    Random rand = new Random(5);
    while (seeds.size() < numSeeds) {
      seeds.putIfAbsent(new Point(rand.nextInt(height), rand.nextInt(width)),
              new ArrayList<Point>());
    }

    Point[] seedsArray = seeds.keySet().toArray(new Point[0]);
    Point closest = seedsArray[0];
    for (int w = 0; w < height; w++) {
      for (int h = 0; h < width; h++) {
        Point pixel = new Point(w, h);
        for (Point p : seedsArray) {
          if (p.distance(pixel) < closest.distance(pixel)) {
            closest = p;
          }
        }
        seeds.get(closest).add(pixel);
      }
    }

    IPixel[][] mosaicPx = new IPixel[height][width];
    for (Point seed : seedsArray) {
      ArrayList<Point> cluster = seeds.get(seed);
      int rAvg = 0;
      int gAvg = 0;
      int bAvg = 0;
      for (Point pixel : cluster) {
        IPixel px = image.getPixelAt(pixel.x, pixel.y);
        rAvg += px.getRed();
        gAvg += px.getGreen();
        bAvg += px.getBlue();
      }
      rAvg /= cluster.size();
      gAvg /= cluster.size();
      bAvg /= cluster.size();

      for (Point pixel : cluster) {
        mosaicPx[pixel.x][pixel.y] = new Pixel(rAvg, gAvg, bAvg);
      }
    }
    return new ImageModel(mosaicPx, name);
  }
}
