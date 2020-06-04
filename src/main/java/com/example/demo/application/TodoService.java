package com.example.demo.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.domain.models.todoes.ITodoFactory;
import com.example.demo.domain.models.todoes.Todo;
import com.example.demo.domain.models.todoes.TodoDataModelBuilder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;
  private final ITodoFactory iTodoFactory;



  // 採番テーブルに値を永続化して、取得
  public Todo createTodo(String title, LocalDate deadline) {
    Todo todo = iTodoFactory.createtodo(title, deadline);
    return todo;
  }


  public void saveTodo(Todo todo) {
    todoRepository.Save(todo);
  }



  public List<TodoDto> getFindAllTodoData() {
    List<Todo> todoList = todoRepository.findTodoAll();
    List<TodoDto> dtoList = new ArrayList<TodoDto>();
    for (Todo todo : todoList) {
      TodoDataModelBuilder todoDataModelBuilder = new TodoDataModelBuilder();
      todo.Notify(todoDataModelBuilder);
      dtoList.add(todoDataModelBuilder.BuildTodoDto());
    }
    return dtoList;

  }

  public TodoDto findById(long id) {
    Todo todo = todoRepository.findById(id);
    TodoDataModelBuilder todoDataModelBuilder = new TodoDataModelBuilder();
    todo.Notify(todoDataModelBuilder);
    return todoDataModelBuilder.BuildTodoDto();
  }

  public void editTodo(long id, String title, LocalDate deadline) {
    todoRepository.editTodo(id, title, deadline);
  }

  public List<TodoDto> searchTitles(String titleName) {
    List<Todo> todo = todoRepository.searchTitles(titleName);
    List<TodoDto> todoDtoList = new ArrayList<TodoDto>();

    for (Todo todoList : todo) {
      TodoDataModelBuilder todoDataModelBuilder = new TodoDataModelBuilder();
      todoList.Notify(todoDataModelBuilder);
      TodoDto tododto = todoDataModelBuilder.BuildTodoDto();
      todoDtoList.add(tododto);
    }


    return todoDtoList;
  }

}
