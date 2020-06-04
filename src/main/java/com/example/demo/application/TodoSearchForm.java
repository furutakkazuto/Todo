package com.example.demo.application;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoSearchForm {

  @NotBlank(message = "文字を入力してください。")
  private String searchTitleName;

}
