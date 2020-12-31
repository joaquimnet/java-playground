package dev.joaquimneto.playground;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class IO {
  private IO() {
    throw new IllegalStateException("Utility class");
  }

  public static void run() throws IOException {
    Logger.info("This is the IO module.");

    String[] options = { "Console", "Read File", "Write File" };
    String program = Prompter.picker("Which IO program would you like to run?", options);

    if (program == null) {
      return;
    }

    switch (program) {
      case "Console":
        console();
        break;
      case "Read File":
        readFile();
        break;
      case "3":
      case "Write File":
        writeFile();
        break;
      default:
        break;
    }
  }

  private static void console() {
    Console c = System.console();
    Logger.inline("");
    String username = c.readLine("username: ");
    Logger.inline("");
    char[] password = c.readPassword("password: ");

    Logger.info("Welcome back " + username + "!");
    Logger.info("Your password is " + password.length + " characters long.");
  }

  private static void readFile() {
    Scanner reader;
    try {
      reader = new Scanner(Path.of("boop.txt"), StandardCharsets.UTF_8);
    } catch (IOException e) {
      Logger.info("Looks like the file hasn't been created yet. Try running the write file program first ;)");
      return;
    }
    // telling it to delimit the input with \Z, which is the end of the string
    // anchor
    reader.useDelimiter("\\Z");
    Logger.info(reader.next());
    reader.close();
  }

  private static void writeFile() throws IOException {
    PrintWriter writer = new PrintWriter("boop.txt");
    writer.write("boop! ⭐");
    Logger.info("Done!");
    writer.close();
  }
}
