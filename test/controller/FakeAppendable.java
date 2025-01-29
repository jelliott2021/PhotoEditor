package controller;

import java.io.IOException;

/**
 * A fake Appendable that just throws IOExceptions.
 */
public class FakeAppendable implements Appendable {
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("WOOOH");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Uh oh");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Bad");
  }
}
