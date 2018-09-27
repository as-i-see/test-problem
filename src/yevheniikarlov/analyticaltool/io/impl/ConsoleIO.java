package yevheniikarlov.analyticaltool.io.impl;

import java.util.Scanner;

import yevheniikarlov.analyticaltool.data.DataEntry;
import yevheniikarlov.analyticaltool.io.IO;

public class ConsoleIO implements IO {
  private Scanner scanner;
  private Parser parser;

  public ConsoleIO(Scanner scanner) {
    this.scanner = scanner;
    this.parser = new Parser();
  }

  @Override
  public int readCount() {
    return Integer.parseInt(scanner.nextLine());
  }

  @Override
  public DataEntry readDataEntry() {
    String dataLine = scanner.nextLine();
    return parser.parseDataEntry(dataLine);
  }

  @Override
  public void printLine(String s) {
    System.out.println(s);
  }
}
