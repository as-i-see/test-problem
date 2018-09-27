package yevheniikarlov.analyticaltool.data;

import java.time.LocalDate;

public class Query extends DataEntry {
  private LocalDate dateFrom;
  private LocalDate dateTo;

  public Query(DataEntry dataEntry, LocalDate dateFrom, LocalDate dateTo) {
    super(dataEntry.getService(), dataEntry.getQuestion(),
        dataEntry.getResponseType());
    this.dateFrom = dateFrom;
    this.dateTo = dateTo;
  }

  public boolean embraces(WaitingTimeLine record) {
    return super.getService().embraces(record.getService())
        && super.getQuestion().embraces(record.getQuestion())
        && super.getResponseType().equals(record.getResponseType())
        && dateFrom.isBefore(record.getDate())
        && dateTo.isAfter(record.getDate());
  }
}
