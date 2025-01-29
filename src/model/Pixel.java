package model;

import java.util.Objects;

/**
 * Represents a pixel given certain red, blue, and green values.
 */
public class Pixel implements IPixel {

  private double red;
  private double blue;
  private double green;
  private double luma;
  private double intensity;
  private double value;
  private static double MAX = 255;
  private static double MIN = 0;


  /**
   * Constructs a pixel given certain red, blue, and green values.
   * @param r red value
   * @param b blue value
   * @param g green value
   * @throws IllegalArgumentException when the value is out of range.
   */
  public Pixel(double r, double g, double b) throws IllegalArgumentException {

    if (r > MAX || r < MIN) {
      throw new IllegalArgumentException(" Red value should be between 0- 255");
    }

    if (b > MAX || b < MIN) {
      throw new IllegalArgumentException(" Blue value should be between 0- 255");
    }

    if (g > MAX || g < MIN) {
      throw new IllegalArgumentException(" Green value should be between 0- 255");
    }
    this.red = r;
    this.blue = b;
    this.green = g;
    this.luma = 0.2126 * this.red + 0.7152 * this.green + 0.0722 * this.blue;
    this.intensity = ((this.red + this.blue + this.green) / 3);
    this.value = Math.max(this.green, Math.max(this.red, this.blue));
  }


  @Override
  public IPixel redScale() {
    return new Pixel(this.red, this.red, this.red);
  }

  @Override
  public IPixel blueScale() {
    return new Pixel(this.blue, this.blue, this.blue);
  }

  @Override
  public IPixel greenScale() {
    return new Pixel(this.green,this.green, this.green);
  }

  @Override
  public IPixel valueScale() {
    return new Pixel(this.value, this.value, this.value);
  }

  @Override
  public IPixel intensity() {
    return new Pixel(this.intensity, this.intensity, this.intensity);
  }

  @Override
  public IPixel luma() {
    return new Pixel(this.luma, this.luma, this.luma);
  }

  @Override
  public IPixel brighten(int factor) {

    double newRed = this.red + factor;
    if (newRed > MAX) {
      newRed = MAX;
    }
    double newBlue = this.blue + factor;
    if (newBlue > MAX) {
      newBlue = MAX;
    }
    double newGreen = this.green + factor;
    if (newGreen > MAX) {
      newGreen = MAX;
    }

    return new Pixel(newRed, newGreen, newBlue);
  }



  @Override
  public IPixel darken(int factor) {

    double newRed = this.red - factor;
    if (newRed < MIN) {
      newRed = MIN;
    }
    double newBlue = this.blue - factor;
    if (newBlue < MIN) {
      newBlue = MIN;
    }
    double newGreen = this.green - factor;
    if (newGreen < MIN) {
      newGreen = MIN;
    }

    return new Pixel(newRed, newGreen, newBlue);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (! (other instanceof Pixel)) {
      return false;
    }

    Pixel o = (Pixel) other;
    return Math.abs(this.red - o.red) <= 0.01
            && Math.abs(this.blue - o.blue) <= 0.01
            && Math.abs(this.green - o.green) <= 0.01;

  }

  @Override
  public int hashCode() {
    return Objects.hash(this.red, this.blue, this.green);
  }

  /**
   * Prints out the individual red, green, and blue values.
   * @return a String denoting what the red, green, and blue components are.
   */
  @Override
  public String toString() {
    return String.format("%.2f %.2f %.2f", this.red, this.green,
            this.blue);
  }

  @Override
  public double maxVal() {
    return this.value;
  }

  @Override
  public double multRed(double cont) {
    return this.red * cont;
  }

  @Override
  public double multGreen(double cont) {
    return this.green * cont;
  }

  @Override
  public double multBlue(double cont) {
    return this.blue * cont;
  }

  @Override
  public double getRed() {
    return this.red;
  }

  @Override
  public double getBlue() {
    return this.blue;
  }

  @Override
  public double getGreen() {
    return this.green;
  }

  @Override
  public double getIntensity() {
    return this.intensity;
  }

}