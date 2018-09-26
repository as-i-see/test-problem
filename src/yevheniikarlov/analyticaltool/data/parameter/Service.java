package yevheniikarlov.analyticaltool.data.parameter;

import java.util.Objects;

public class Service {
  private Integer serviceId;
  private Integer variationId;

  public Service(Integer serviceId, Integer variationId) {
    this.serviceId = serviceId;
    this.variationId = variationId;
  }

  public boolean isBelongs(Service holder) {
    if (Objects.isNull(holder))
      return true;
    boolean isBelongs = Objects.equals(holder.serviceId, serviceId);
    if (Objects.nonNull(holder.variationId)) {
      isBelongs = Objects.equals(holder.variationId, variationId);
    }
    return isBelongs;
  }
}
