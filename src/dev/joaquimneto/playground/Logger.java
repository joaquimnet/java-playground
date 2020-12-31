package dev.joaquimneto.playground;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
  private Logger() {
    throw new IllegalStateException("Utility class");
  }

  public static void info(String line) {
    System.out.printf("%s %s%n", getFormattedDate(), line);
  }

  public static void inline(String line) {
    System.out.printf("%s %s", getFormattedDate(), line);
  }

  private static String getFormattedDate() {
    String pattern = "HH:mm:ssa  ";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    return simpleDateFormat.format(new Date());
  }
}
