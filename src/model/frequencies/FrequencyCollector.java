package model.frequencies;

import java.util.Map;

import model.IImage;

/**
 * Represents a histogram mapping frequencies of values.
 */
public interface FrequencyCollector {

  /**
   * Maps component values to their respective frequencies.
   * @param img an image to work with.
   * @return an array containing maps of component values to their frequencies.
   */

  Map<Integer, Integer>[] getFrequencies(IImage img);
}
