package yevheniikarlov.analyticaltool.data.parameter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Date {
  public static final DateTimeFormatter format = DateTimeFormatter
      .ofPattern("dd.MM.yyyy");
  private LocalDate date;

  public Date(String s) {
    this.date = LocalDate.parse(s, format);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Date date1 = (Date) o;
    return Objects.equals(date, date1.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date);
  }
}
