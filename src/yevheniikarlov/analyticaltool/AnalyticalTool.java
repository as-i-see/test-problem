package yevheniikarlov.analyticaltool;

import java.util.Collection;

import yevheniikarlov.analyticaltool.data.Data;
import yevheniikarlov.analyticaltool.data.WaitingTimeLine;
import yevheniikarlov.analyticaltool.io.IO;

public class AnalyticalTool {
  private IO io;
  private Collection<Data> records;

  public void handleDataLine() {
    Data data = io.readDataLine();
    if (data instanceof WaitingTimeLine) {
      records.add(data);
    } else {
      String queryResult = handleQuery(data);
      io.printLine(queryResult);
    }
  }

  private String handleQuery(Data data) {
    return "-";
  }
}
