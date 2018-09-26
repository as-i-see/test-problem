package yevheniikarlov.analyticaltool.io.impl;

import yevheniikarlov.analyticaltool.data.Data;
import yevheniikarlov.analyticaltool.data.Query;
import yevheniikarlov.analyticaltool.data.WaitingTimeLine;
import yevheniikarlov.analyticaltool.data.parameter.*;

class Parser {
  Data parse(String dataLine) {
    String[] params = dataLine.split(" ");
    if (params[0].equals("C")) {
      return parseWaitingTimeLine(params);
    } else
      return parseQuery(params);
  }

  private Data parseWaitingTimeLine(String[] params) {
    Data data = parseData(params);
    Date date = parseDate(params[4]);
    Time time = parseTime(params[5]);
    return new WaitingTimeLine(data, date, time);
  }

  private Data parseQuery(String[] params) {
    Data data = parseData(params);
    Date[] dates = parseQueryDates(params[4]);
    return new Query(data, dates[0], dates[1]);
  }

  private Data parseData(String[] dataLine) {
    Service service = parseService(dataLine[1]);
    Question question = parseQuestion(dataLine[2]);
    ResponseType responseType = parseResponseType(dataLine[3]);
    return new Data(service, question, responseType);
  }

  private Service parseService(String s) {
    String[] strings = s.split(".", 2);
    Integer serviceId = Integer.valueOf(strings[0]);
    Integer variationId = null;
    if (!strings[1].equals("")) {
      variationId = Integer.valueOf(strings[1]);
    }
    return new Service(serviceId, variationId);

  }

  private Question parseQuestion(String s) {
    String[] strings = s.split(".", 3);
    Integer questionId = Integer.valueOf(strings[0]);
    Integer categoryId = null;
    Integer subCategoryId = null;
    if (!strings[1].equals("")) {
      categoryId = Integer.valueOf(strings[1]);
      if (!strings[2].equals(""))
        subCategoryId = Integer.valueOf(strings[2]);
    }
    return new Question(questionId, categoryId, subCategoryId);

  }

  private ResponseType parseResponseType(String s) {
    return ResponseType.valueOf(s);
  }

  private Date[] parseQueryDates(String s) {
    String[] datesStrings = s.split("-", 2);
    Date[] dates = new Date[2];
    dates[0] = parseDate(datesStrings[0]);
    dates[1] = parseDate(datesStrings[1]);
    return dates;
  }

  private Date parseDate(String s) {
    if (s.equals(""))
      return null;
    return new Date(s);
  }

  private Time parseTime(String s) {
    return new Time(Integer.valueOf(s));
  }
}
