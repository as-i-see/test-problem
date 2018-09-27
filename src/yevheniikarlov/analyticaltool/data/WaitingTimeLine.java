package yevheniikarlov.analyticaltool.data;

import java.time.LocalDate;

public class WaitingTimeLine extends DataEntry {
  private LocalDate date;
  private int minutes;

  public WaitingTimeLine(DataEntry dataEntry, LocalDate date, int minutes) {
    super(dataEntry.getService(), dataEntry.getQuestion(),
        dataEntry.getResponseType());
    this.date = date;
    this.minutes = minutes;
  }

  public LocalDate getDate() {
    return date;
  }

  public int getMinutes() {
    return minutes;
  }
}
