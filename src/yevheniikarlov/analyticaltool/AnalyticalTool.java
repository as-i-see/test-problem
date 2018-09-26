package yevheniikarlov.analyticaltool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.OptionalDouble;

import yevheniikarlov.analyticaltool.data.Data;
import yevheniikarlov.analyticaltool.data.Query;
import yevheniikarlov.analyticaltool.data.WaitingTimeLine;
import yevheniikarlov.analyticaltool.io.IO;

public class AnalyticalTool {
  private IO io;
  private Collection<WaitingTimeLine> records;

  public AnalyticalTool(IO io) {
    this.io = io;
    this.records = new ArrayList<>();
  }

  public void handleDataLine() {
    Data data = io.readDataLine();
    if (data instanceof WaitingTimeLine) {
      records.add((WaitingTimeLine) data);
    } else {
      String queryResult = handleQuery((Query) data);
      io.printLine(queryResult);
    }
  }

  private String handleQuery(Query query) {
    OptionalDouble optionalAverage = records.stream().filter(query::isMatching)
        .mapToInt(record -> record.getTime().getMinutes()).average();
    if (optionalAverage.isPresent()) {
      double average = optionalAverage.getAsDouble();
      long roundedAverage = Math.round(average);
      return Long.toString(roundedAverage);
    }
    return "-";
  }
}
