package yevheniikarlov.analyticaltool.data;

import java.util.Objects;

import yevheniikarlov.analyticaltool.data.parameter.Date;
import yevheniikarlov.analyticaltool.data.parameter.Time;

public class WaitingTimeLine extends Data {
  private Date date;
  private Time time;

  public WaitingTimeLine(Data data, Date date, Time time) {
    super(data.getService(), data.getQuestion(), data.getResponseType());
    this.date = date;
    this.time = time;
  }

  public Date getDate() {
    return date;
  }

  public Time getTime() {
    return time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof WaitingTimeLine))
      return false;
    if (!super.equals(o))
      return false;
    WaitingTimeLine that = (WaitingTimeLine) o;
    return Objects.equals(date, that.date) && Objects.equals(time, that.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), date, time);
  }
}
