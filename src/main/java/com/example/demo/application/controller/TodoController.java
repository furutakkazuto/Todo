package com.example.demo.application.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.application.TodoDto;
import com.example.demo.application.TodoForm;
import com.example.demo.application.TodoSearchForm;
import com.example.demo.application.TodoService;
import com.example.demo.domain.models.todoes.Todo;
import lombok.RequiredArgsConstructor;


/**
 * Todoコントローラ
 *
 * @author furutakazuto
 *
 */
@Controller
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;


  @GetMapping
  public String index(@ModelAttribute("todoForm") TodoForm todoForm, Model model) {
    List<TodoDto> todoAllList = todoService.getFindAllTodoData();
    model.addAttribute("todoAllList", todoAllList);

    return "index";
  }

  @GetMapping(path = "register")
  public String indexPost(@Validated @ModelAttribute TodoForm todoForm, BindingResult result,
      Model userInfo) {
    if (result.hasErrors()) {
      List<String> errorList = result.getFieldErrors().stream()
          .map(errorMessage -> errorMessage.getDefaultMessage()).collect(Collectors.toList());
      userInfo.addAttribute("validationError", errorList);
      return "index";
    }

    // Long todoId = todoService.createTodoId();
    // Todo todo = new Todo(todoId, todoForm.getTitleName(), todoForm.getDeadlineTime());
    Todo todo = todoService.createTodo(todoForm.getTitleName(), todoForm.getDeadlineTime());
    todoService.saveTodo(todo);
    List<TodoDto> todoAllList = todoService.getFindAllTodoData();
    userInfo.addAttribute("todoAllList", todoAllList);

    return "index";


  }

  @GetMapping(path = "edit/{id}")
  public String show(@PathVariable("id") long id, @ModelAttribute("editForm") TodoForm todoForm,
      Model userShowInfo) {

    TodoDto todoDto = todoService.findById(id);
    todoForm.setTitleName(todoDto.getTitleDto());
    todoForm.setDeadlineTime(todoDto.getDeadLineDto());
    userShowInfo.addAttribute("editId", id);

    return "show";

  }

  @PutMapping(path = "edit/{id}/complete")
  public String edit(@Validated @ModelAttribute("editForm") TodoForm todoForm,
      BindingResult binding, @PathVariable("id") Long id, Model userInfo) {
    if (binding.hasErrors()) {
      List<String> Errors = binding.getFieldErrors().stream()
          .map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
      userInfo.addAttribute("fieldErrors", Errors);
      userInfo.addAttribute("editId", id);

      return "show";
    }
    todoService.editTodo(id, todoForm.getTitleName(), todoForm.getDeadlineTime());
    return "redirect:/";
  }


  @GetMapping(path = "/search")
  public String search(@ModelAttribute("searchForm") TodoSearchForm searchForm) {
    return "search";
  }

  @GetMapping(path = "/search/result")
  public String searchResult(@Validated @ModelAttribute("searchForm") TodoSearchForm searchForm,
      BindingResult bindingResult, Model todoInfo,
      @RequestParam(value = "searchTitleName", required = false) String titleName) {

    if (bindingResult.hasErrors()) {
      List<String> Errors = bindingResult.getFieldErrors().stream()
          .map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
      todoInfo.addAttribute("fieldErrors", Errors);
      return "search";
    }

    List<TodoDto> resultTodoList = todoService.searchTitles(titleName);

    if (resultTodoList.size() == 0) {
      todoInfo.addAttribute("noResultSearch", "検索結果が見つかりませんでした。");
      return "search";
    }

    todoInfo.addAttribute("ResultSearch", resultTodoList);
    return "search";


  }

}
