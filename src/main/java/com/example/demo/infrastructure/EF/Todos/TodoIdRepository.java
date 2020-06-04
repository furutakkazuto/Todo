package com.example.demo.infrastructure.EF.Todos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.application.TodoIdEntity;


public interface TodoIdRepository extends JpaRepository<TodoIdEntity, Long> {
}
