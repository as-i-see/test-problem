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

  public boolean isBelongs(Question holder) {
    if (Objects.isNull(holder))
      return true;
    boolean isBelongs = Objects.equals(holder.questionTypeId, questionTypeId);
    if (Objects.nonNull(holder.categoryId)) {
      isBelongs = Objects.equals(holder.categoryId, categoryId);
      if (Objects.nonNull(holder.subCategoryId)) {
        isBelongs = Objects.equals(holder.subCategoryId, subCategoryId);
      }
    }
    return isBelongs;
  }
}
