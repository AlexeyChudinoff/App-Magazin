package org.skypro.skyshop.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class SimpleLogger {
  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

  private SimpleLogger() {}

  public static void info(String message) {
    log("INFO", message, ConsoleColors.GREEN);
  }

  public static void error(String message) {
    log("ERROR", message, ConsoleColors.RED);
  }

  public static void debug(String message) {
    log("DEBUG", message, ConsoleColors.BLUE);
  }

  public static void warn(String message) {
    log("WARN", message, ConsoleColors.YELLOW);
  }

  public static void test(String message) {
    log("TEST", message, ConsoleColors.CYAN);
  }

  private static void log(String level, String message, String color) {
    String timestamp = LocalDateTime.now().format(formatter);
    String formattedMessage = String.format("%s [%s] - %s",
        ConsoleColors.colorize(timestamp, ConsoleColors.PURPLE),
        ConsoleColors.colorize(level, color),
        message);

    if (level.equals("ERROR")) {
      System.err.println(formattedMessage);
    } else {
      System.out.println(formattedMessage);
    }
  }
}