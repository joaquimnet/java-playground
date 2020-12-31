package dev.joaquimneto.playground;

import java.io.IOException;
import java.util.Scanner;

public class App {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    System.out.println("\n");
    Logger.info("Welcome to the playground!");

    String[] options = { "IO" };
    String module = Prompter.picker("Which playground module would you like to run? [q to exit]", options);

    if (module != null) {
      switch (module) {
        case "IO":
          IO.run();
          break;
        default:
          break;
      }
    }

    scanner.close();
  }

  public static String ask(String question) {
    Logger.inline(question + " ");
    return scanner.nextLine();
  }
}
