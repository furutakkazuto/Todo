package com.example.demo.domain.models.todoes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.example.demo.application.TodoEntity;
import com.example.demo.shared.ITodoNotification;


public class Todo {

  private final Long id;

  private String title;

  private LocalDate deadline;

  private Boolean status;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;


  public Todo(Long id, String title, LocalDate deadline) {
    this.id = id;
    this.title = title;
    this.deadline = deadline;
    this.status = false;
    this.createTime = LocalDateTime.now();
    this.updateTime = LocalDateTime.now();
  }

  // ここの記述を考える！！
  public Todo(TodoEntity todoEntity) {
    this.id = todoEntity.getId();
    this.title = todoEntity.getTitle();
    this.deadline = todoEntity.getDeadline();
    this.status = todoEntity.getStatus();
    this.createTime = todoEntity.getCreateTime();
    this.updateTime = todoEntity.getUpdateTime();
  }


  public void Notify(ITodoNotification note) {
    note.Id(id);
    note.Title(title);
    note.Deadline(deadline);
    note.Status(status);
    note.CreateTime(createTime);
    note.UpdateTime(updateTime);
  }



}
