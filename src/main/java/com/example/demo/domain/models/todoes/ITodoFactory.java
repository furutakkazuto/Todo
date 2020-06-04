package com.example.demo.domain.models.todoes;

import java.time.LocalDate;

public interface ITodoFactory {
  Todo createtodo(String title, LocalDate deadline);

}
