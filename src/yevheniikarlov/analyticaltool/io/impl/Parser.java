package yevheniikarlov.analyticaltool.io.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import yevheniikarlov.analyticaltool.data.DataEntry;
import yevheniikarlov.analyticaltool.data.Query;
import yevheniikarlov.analyticaltool.data.WaitingTimeLine;
import yevheniikarlov.analyticaltool.data.parameter.Question;
import yevheniikarlov.analyticaltool.data.parameter.ResponseType;
import yevheniikarlov.analyticaltool.data.parameter.Service;

class Parser {
  private static final String PARAM_DELIM = " ";
  private static final String WAITING_TIME_LINE = "C";
  private static final String CATEGORY_DELIM = "\\.";
  private static final String ANY = "*";
  private static final String DATES_DELIM = "-";
  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter
      .ofPattern("dd.MM.yyyy");

  DataEntry parseDataEntry(String dataLine) {
    String[] params = dataLine.split(PARAM_DELIM);
    if (params[0].equals(WAITING_TIME_LINE)) {
      return parseWaitingTimeLine(params);
    } else
      return parseQuery(params);
  }

  private DataEntry parseWaitingTimeLine(String[] params) {
    DataEntry dataEntry = parseDataEntry(params);
    LocalDate date = parseDate(params[4]);
    int minutes = Integer.parseInt(params[5]);
    return new WaitingTimeLine(dataEntry, date, minutes);
  }

  private DataEntry parseQuery(String[] params) {
    DataEntry dataEntry = parseDataEntry(params);
    LocalDate[] dates = parseQueryDates(params[4]);
    return new Query(dataEntry, dates[0], dates[1]);
  }

  private DataEntry parseDataEntry(String[] dataLine) {
    Service service = parseService(dataLine[1]);
    Question question = parseQuestion(dataLine[2]);
    ResponseType responseType = ResponseType.valueOf(dataLine[3]);
    return new DataEntry(service, question, responseType);
  }

  private Service parseService(String s) {
    if (s.equals(ANY))
      return new AnyService();
    String[] strings = s.split(CATEGORY_DELIM);
    Integer serviceId = Integer.valueOf(strings[0]);
    Integer variationId = null;
    if (strings.length > 1) {
      variationId = Integer.valueOf(strings[1]);
    }
    return new Service(serviceId, variationId);
  }

  private Question parseQuestion(String s) {
    if (s.equals(ANY))
      return new AnyQuestion();
    String[] strings = s.split(CATEGORY_DELIM);
    Integer questionId = Integer.valueOf(strings[0]);
    Integer categoryId = null;
    Integer subCategoryId = null;
    if (strings.length > 1) {
      categoryId = Integer.valueOf(strings[1]);
      if (strings.length > 2)
        subCategoryId = Integer.valueOf(strings[2]);
    }
    return new Question(questionId, categoryId, subCategoryId);
  }

  private LocalDate[] parseQueryDates(String s) {
    String[] dates = s.split(DATES_DELIM);
    LocalDate dateFrom = parseDate(dates[0]);
    LocalDate dateTo = LocalDate.MAX;
    if (dates.length == 2)
      dateTo = parseDate(dates[1]);
    return new LocalDate[] {
        dateFrom, dateTo
    };
  }

  private LocalDate parseDate(String s) {
    return LocalDate.parse(s, DATE_FORMAT);
  }

  public class AnyService extends Service {
    @Override
    public boolean embraces(Service other) {
      return true;
    }
  }

  public class AnyQuestion extends Question {
    @Override
    public boolean embraces(Question other) {
      return true;
    }
  }
}
