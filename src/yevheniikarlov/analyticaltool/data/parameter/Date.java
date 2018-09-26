package yevheniikarlov.analyticaltool.data.parameter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Date {
  private static final DateTimeFormatter format = DateTimeFormatter
      .ofPattern("dd.MM.yyyy");
  private LocalDate date;

  public Date(String s) {
    this.date = LocalDate.parse(s, format);
  }

  public boolean isBetween(Date dateFrom, Date dateTo) {
    boolean isBetween = date.isAfter(dateFrom.date);
    if (Objects.nonNull(dateTo)) {
      isBetween = date.isBefore(dateTo.date);
    }
    return isBetween;
  }
}
