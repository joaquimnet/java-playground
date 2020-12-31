package dev.joaquimneto.playground;

public class Prompter {
  private Prompter() {
    throw new IllegalStateException("Utility class");
  }

  public static String picker(String question, String[] options) {
    Boolean done = false;

    Logger.info(question);
    for (int i = 0; i < options.length; i++) {
      Logger.info((i + 1) + ". " + options[i]);
    }
    Logger.info("q. Exit");

    while (Boolean.FALSE.equals(done)) {

      String input = App.ask(">");

      int index;

      try {
        index = Integer.parseInt(input) - 1;
      } catch (NumberFormatException e) {
        index = -1;
      }

      if (0 <= index && index < options.length) {
        return options[index];
      }

      if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("exit")) {
        done = true;
      }
    }

    return null;
  }
}
