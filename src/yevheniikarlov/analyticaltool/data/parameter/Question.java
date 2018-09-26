package yevheniikarlov.analyticaltool.data.parameter;

import java.util.Objects;

public class Question {
  private int questionTypeId;
  private int categoryId;
  private int subCategoryId;

  public Question(int questionTypeId, int categoryId, int subCategoryId) {
    this.questionTypeId = questionTypeId;
    this.categoryId = categoryId;
    this.subCategoryId = subCategoryId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Question question = (Question) o;
    return questionTypeId == question.questionTypeId
        && categoryId == question.categoryId
        && subCategoryId == question.subCategoryId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionTypeId, categoryId, subCategoryId);
  }
}
