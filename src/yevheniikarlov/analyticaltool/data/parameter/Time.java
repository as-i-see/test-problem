package yevheniikarlov.analyticaltool.data.parameter;

import java.util.Objects;

public class Time {
  private int minutes;

  public Time(int minutes) {
    this.minutes = minutes;
  }

  public int getMinutes() {
    return minutes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Time time1 = (Time) o;
    return minutes == time1.minutes;
  }

  @Override
  public int hashCode() {
    return Objects.hash(minutes);
  }
}
