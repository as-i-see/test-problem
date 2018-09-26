package yevheniikarlov;

import java.util.Scanner;

import yevheniikarlov.analyticaltool.io.IO;
import yevheniikarlov.analyticaltool.io.impl.ConsoleIO;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int S = scanner.nextInt();
    IO io = new ConsoleIO(scanner);
  }
}
