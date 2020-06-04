package com.example.demo.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TodoDto {

  private long idDto;

  private String titleDto;

  private Boolean todoFlagDto;

  private LocalDate deadLineDto;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;


}
