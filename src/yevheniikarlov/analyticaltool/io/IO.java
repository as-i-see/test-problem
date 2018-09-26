package yevheniikarlov.analyticaltool.io;

import yevheniikarlov.analyticaltool.data.Data;

public interface IO {
  Data readDataLine();

  void printLine(String s);
}
