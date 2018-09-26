package yevheniikarlov;

import java.util.Scanner;

import yevheniikarlov.analyticaltool.AnalyticalTool;
import yevheniikarlov.analyticaltool.io.IO;
import yevheniikarlov.analyticaltool.io.impl.ConsoleIO;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    IO io = new ConsoleIO(scanner);
    AnalyticalTool analyticalTool = new AnalyticalTool(io);
    for (int i = 0; i < 7; i++) {
      analyticalTool.handleDataLine();
    }
  }
}
