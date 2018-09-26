package yevheniikarlov.analyticaltool.data.parameter;

import java.util.Objects;

public class Question {
  private Integer questionTypeId;
  private Integer categoryId;
  private Integer subCategoryId;

  public Question(Integer questionTypeId, Integer categoryId,
      Integer subCategoryId) {
    this.questionTypeId = questionTypeId;
    this.categoryId = categoryId;
    this.subCategoryId = subCategoryId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Question))
      return false;
    Question question = (Question) o;
    return Objects.equals(questionTypeId, question.questionTypeId)
        && Objects.equals(categoryId, question.categoryId)
        && Objects.equals(subCategoryId, question.subCategoryId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionTypeId, categoryId, subCategoryId);
  }
}
