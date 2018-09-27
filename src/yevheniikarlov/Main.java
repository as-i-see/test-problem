package yevheniikarlov;

import java.util.Optional;
import java.util.Scanner;

import yevheniikarlov.analyticaltool.AnalyticalTool;
import yevheniikarlov.analyticaltool.data.DataEntry;
import yevheniikarlov.analyticaltool.io.IO;
import yevheniikarlov.analyticaltool.io.impl.ConsoleIO;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    IO consoleIO = new ConsoleIO(scanner);
    AnalyticalTool analyticalTool = new AnalyticalTool();

    int count = consoleIO.readCount();
    for (int i = 0; i < count; i++) {
      DataEntry dataEntry = consoleIO.readDataEntry();
      Optional<String> queryResult = analyticalTool.handleDataEntry(dataEntry);
      queryResult.ifPresent(consoleIO::printLine);
    }
  }
}
