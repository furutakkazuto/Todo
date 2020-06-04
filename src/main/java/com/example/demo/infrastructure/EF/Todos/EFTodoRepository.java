package com.example.demo.infrastructure.EF.Todos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.example.demo.application.TodoEntity;
import com.example.demo.application.TodoRepository;
import com.example.demo.domain.models.todoes.Todo;
import com.example.demo.domain.models.todoes.TodoDataModelBuilder;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EFTodoRepository implements TodoRepository {

  private final JpaJPQL jpaJPQL;

  public void Save(Todo todo) {
    TodoDataModelBuilder todoDataModeBuilder = new TodoDataModelBuilder();
    todo.Notify(todoDataModeBuilder);
    TodoEntity todoEntity = todoDataModeBuilder.Build();
    jpaJPQL.save(todoEntity);
  }

  public Todo findById(long id) {
    TodoEntity todoEntity = jpaJPQL.findByIdEquals(id);
    Todo todo = ToDomainObject(todoEntity);
    return todo;
  }

  public List<Todo> findTodoAll() {
    List<TodoEntity> todoEntityList = jpaJPQL.findAll();
    List<Todo> todoList = todoEntityList.stream().map(todoEntity -> new Todo(todoEntity))
        .collect(Collectors.toList());

    return todoList;
  }

  public void editTodo(long id, String title, LocalDate deadline) {
    TodoEntity editEntity = jpaJPQL.findByIdEquals(id);
    editEntity.setTitle(title);
    editEntity.setDeadline(deadline);
    jpaJPQL.save(editEntity);
  }

  private Todo ToDomainObject(TodoEntity todoEntity) {
    return new Todo(todoEntity);
  }


  public List<Todo> searchTitles(String titleName) {
    List<TodoEntity> resultEntityList = jpaJPQL.findByTitleContaining(titleName);
    List<Todo> resultTodoList =
        resultEntityList.stream().map(result -> new Todo(result)).collect(Collectors.toList());

    return resultTodoList;
  }



}
