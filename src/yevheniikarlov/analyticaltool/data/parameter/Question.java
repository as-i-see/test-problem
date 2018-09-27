package yevheniikarlov.analyticaltool.data.parameter;

import java.util.Objects;

public class Question {
  private Integer questionTypeId;
  private Integer categoryId;
  private Integer subCategoryId;

  protected Question() {}

  public Question(Integer questionTypeId, Integer categoryId,
      Integer subCategoryId) {
    this.questionTypeId = questionTypeId;
    this.categoryId = categoryId;
    this.subCategoryId = subCategoryId;
  }

  public boolean embraces(Question other) {
    boolean embraces = Objects.equals(questionTypeId, other.questionTypeId);
    if (this.hasCategory()) {
      embraces = Objects.equals(categoryId, other.categoryId);
      if (this.hasSubCategory()) {
        embraces = Objects.equals(subCategoryId, other.subCategoryId);
      }
    }
    return embraces;
  }

  private boolean hasCategory() {
    return Objects.nonNull(categoryId);
  }

  private boolean hasSubCategory() {
    return Objects.nonNull(subCategoryId);
  }
}