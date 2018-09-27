package yevheniikarlov.analyticaltool.io;

import yevheniikarlov.analyticaltool.data.DataEntry;

public interface IO {
  int readCount();

  DataEntry readDataEntry();

  void printLine(String s);
}
