package yevheniikarlov.analyticaltool.data;

import java.util.Objects;

import yevheniikarlov.analyticaltool.data.parameter.Question;
import yevheniikarlov.analyticaltool.data.parameter.ResponseType;
import yevheniikarlov.analyticaltool.data.parameter.Service;

public class Data {
  protected Service service;
  protected Question question;
  protected ResponseType responseType;

  public Data(Service service, Question question, ResponseType responseType) {
    this.service = service;
    this.question = question;
    this.responseType = responseType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Data data = (Data) o;
    return Objects.equals(service, data.service)
        && Objects.equals(question, data.question)
        && responseType == data.responseType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(service, question, responseType);
  }
}
