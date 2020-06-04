package com.example.demo.application;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.domain.models.todoes.Todo;


public interface TodoRepository {



  Todo findById(long id);

  void Save(Todo todo);

  List<Todo> findTodoAll();

  List<Todo> searchTitles(String titleName);

  void editTodo(long id, String title, LocalDate deadline);



}
