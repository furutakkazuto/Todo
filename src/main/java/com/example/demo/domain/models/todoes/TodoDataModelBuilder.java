package com.example.demo.domain.models.todoes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.example.demo.application.TodoDto;
import com.example.demo.application.TodoEntity;
import com.example.demo.shared.ITodoNotification;

public class TodoDataModelBuilder implements ITodoNotification {

  private Long id;

  private String title;

  private LocalDate deadline;

  private Boolean status;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;

  public void Id(Long id) {
    this.id = id;
  }

  public void Title(String title) {

    this.title = title;

  }

  public void Deadline(LocalDate deadline) {

    this.deadline = deadline;

  }

  public void Status(Boolean status) {
    this.status = status;

  }

  public void CreateTime(LocalDateTime createTime) {
    this.createTime = createTime;

  }

  public void UpdateTime(LocalDateTime updateTime) {

    this.updateTime = updateTime;

  }


  // 通知オブジェクトのフィールド値をEntity(データモデル)に移し替える！！
  public TodoEntity Build() {
    TodoEntity todoEntity = new TodoEntity();
    todoEntity.setId(id);
    todoEntity.setTitle(title);
    todoEntity.setDeadline(deadline);
    todoEntity.setStatus(status);
    todoEntity.setCreateTime(createTime);
    todoEntity.setUpdateTime(updateTime);

    return todoEntity;
  }

  public TodoDto BuildTodoDto() {
    TodoDto todoDto = new TodoDto();
    todoDto.setIdDto(id);
    todoDto.setTitleDto(title);
    todoDto.setDeadLineDto(deadline);
    todoDto.setTodoFlagDto(status);
    todoDto.setCreateTime(createTime);
    todoDto.setUpdateTime(updateTime);
    return todoDto;

  }



}
