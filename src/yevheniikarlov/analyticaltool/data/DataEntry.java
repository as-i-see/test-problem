package yevheniikarlov.analyticaltool.data;

import yevheniikarlov.analyticaltool.data.parameter.Question;
import yevheniikarlov.analyticaltool.data.parameter.ResponseType;
import yevheniikarlov.analyticaltool.data.parameter.Service;

public class DataEntry {
  private Service service;
  private Question question;
  private ResponseType responseType;

  public DataEntry(Service service, Question question,
      ResponseType responseType) {
    this.service = service;
    this.question = question;
    this.responseType = responseType;
  }

  public Service getService() {
    return service;
  }

  public Question getQuestion() {
    return question;
  }

  public ResponseType getResponseType() {
    return responseType;
  }
}
