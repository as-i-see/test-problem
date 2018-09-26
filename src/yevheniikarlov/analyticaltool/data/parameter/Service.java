package yevheniikarlov.analyticaltool.data.parameter;

import java.util.Objects;

public class Service {
  private int serviceId;
  private int variationId;

  public Service(int serviceId, int variationId) {
    this.serviceId = serviceId;
    this.variationId = variationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Service service = (Service) o;
    return serviceId == service.serviceId && variationId == service.variationId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, variationId);
  }
}
