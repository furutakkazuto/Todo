package com.example.demo.infrastructure.EF.Todos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.application.TodoEntity;

public interface JpaJPQL extends JpaRepository<TodoEntity, Long> {
  TodoEntity findByIdEquals(long id);

  List<TodoEntity> findByTitleContaining(String title);

}
