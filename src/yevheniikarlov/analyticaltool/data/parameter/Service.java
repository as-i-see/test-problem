package yevheniikarlov.analyticaltool.data.parameter;

import java.util.Objects;

public class Service {
  private Integer serviceId;
  private Integer variationId;

  protected Service() {}

  public Service(Integer serviceId, Integer variationId) {
    this.serviceId = serviceId;
    this.variationId = variationId;
  }

  public boolean embraces(Service other) {
    boolean embraces = Objects.equals(serviceId, other.serviceId);
    if (this.hasVariation()) {
      embraces = Objects.equals(variationId, other.variationId);
    }
    return embraces;
  }

  private boolean hasVariation() {
    return Objects.nonNull(variationId);
  }
}
