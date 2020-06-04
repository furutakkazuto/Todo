package com.example.demo.application;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class TodoForm {

  @NotBlank(message = "{error.message}")
  private String titleName;

  @NotNull(message = "{error.price.max}")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate deadlineTime;

}
