package yevheniikarlov.analyticaltool.io;

import yevheniikarlov.analyticaltool.data.Data;

public interface IO {
  Data readData();

  void printLine(String s);
}
