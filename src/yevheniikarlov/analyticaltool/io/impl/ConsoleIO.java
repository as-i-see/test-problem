package yevheniikarlov.analyticaltool.io.impl;

import java.util.Scanner;

import yevheniikarlov.analyticaltool.data.Data;
import yevheniikarlov.analyticaltool.io.IO;

public class ConsoleIO implements IO {
  private Scanner scanner;
  private Parser parser;

  public ConsoleIO(Scanner scanner) {
    this.scanner = scanner;
    this.parser = new Parser();
  }

  @Override
  public Data readDataLine() {
    String dataLine = scanner.nextLine();
    return parser.parse(dataLine);
  }

  @Override
  public void printLine(String s) {
    System.out.println(s);
  }
}
