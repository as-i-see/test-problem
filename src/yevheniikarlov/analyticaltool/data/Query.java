package yevheniikarlov.analyticaltool.data;

import java.util.Objects;

import yevheniikarlov.analyticaltool.data.parameter.Date;

public class Query extends Data {
  private Date dateFrom;
  private Date dateTo;

  public Query(Data data, Date dateFrom, Date dateTo) {
    super(data.getService(), data.getQuestion(), data.getResponseType());
    this.dateFrom = dateFrom;
    this.dateTo = dateTo;
  }

  public boolean isMatching(WaitingTimeLine record) {
    return record.getService().isBelongs(super.getService())
        && record.getQuestion().isBelongs(super.getQuestion())
        && record.getResponseType().equals(super.getResponseType())
        && record.getDate().isBetween(dateFrom, dateTo);
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
