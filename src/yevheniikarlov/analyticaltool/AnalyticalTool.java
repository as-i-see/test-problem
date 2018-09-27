package yevheniikarlov.analyticaltool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.OptionalDouble;

import yevheniikarlov.analyticaltool.data.DataEntry;
import yevheniikarlov.analyticaltool.data.Query;
import yevheniikarlov.analyticaltool.data.WaitingTimeLine;

public class AnalyticalTool {
  private static final String NOT_DEFINED = "-";
  private Collection<WaitingTimeLine> records;

  public AnalyticalTool() {
    this.records = new ArrayList<>();
  }

  public Optional<String> handleDataEntry(DataEntry dataEntry) {
    if (dataEntry instanceof WaitingTimeLine) {
      records.add((WaitingTimeLine) dataEntry);
      return Optional.empty();
    } else {
      return Optional.of(handleQuery((Query) dataEntry));
    }
  }

  private String handleQuery(Query query) {
    OptionalDouble optionalAverage = records.stream().filter(query::embraces)
        .mapToInt(WaitingTimeLine::getMinutes).average();
    if (optionalAverage.isPresent()) {
      long roundedAverage = Math.round(optionalAverage.getAsDouble());
      return Long.toString(roundedAverage);
    }
    return NOT_DEFINED;
  }
}
