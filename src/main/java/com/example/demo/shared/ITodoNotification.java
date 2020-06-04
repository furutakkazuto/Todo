package com.example.demo.shared;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ITodoNotification {
  void Id(Long id);

  void Title(String title);

  void Deadline(LocalDate deadline);

  void Status(Boolean status);

  void CreateTime(LocalDateTime createTime);

  void UpdateTime(LocalDateTime updateTime);

}
