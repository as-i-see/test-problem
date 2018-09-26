package yevheniikarlov.analyticaltool.data.parameter;

import java.util.Objects;

public class Service {
  private Integer serviceId;
  private Integer variationId;

  public Service(Integer serviceId, Integer variationId) {
    this.serviceId = serviceId;
    this.variationId = variationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Service))
      return false;
    Service service = (Service) o;
    return Objects.equals(serviceId, service.serviceId)
        && Objects.equals(variationId, service.variationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, variationId);
  }
}
