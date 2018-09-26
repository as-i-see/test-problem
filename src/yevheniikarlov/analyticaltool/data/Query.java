package yevheniikarlov.analyticaltool.data;

import java.util.Objects;

import yevheniikarlov.analyticaltool.data.parameter.Date;
import yevheniikarlov.analyticaltool.data.parameter.Question;
import yevheniikarlov.analyticaltool.data.parameter.ResponseType;
import yevheniikarlov.analyticaltool.data.parameter.Service;

public class Query extends Data {
  private Date dateFrom;
  private Date dateTo;

  public Query(Data data, Date dateFrom, Date dateTo) {
    super(data.service, data.question, data.responseType);
    this.dateFrom = dateFrom;
    this.dateTo = dateTo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Query))
      return false;
    if (!super.equals(o))
      return false;
    Query query = (Query) o;
    return Objects.equals(dateFrom, query.dateFrom)
        && Objects.equals(dateTo, query.dateTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), dateFrom, dateTo);
  }
}
