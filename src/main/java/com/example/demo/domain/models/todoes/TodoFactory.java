package com.example.demo.domain.models.todoes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.application.TodoIdEntity;
import com.example.demo.infrastructure.EF.Todos.TodoIdRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TodoFactory implements ITodoFactory {
  private final TodoIdRepository todoIdRepository;
  private final JdbcTemplate jdbcTemplate;

  // 採番テーブルを利用する(シーケンス)。ドメインObjectのインスタンス生成時にID値が入力された状態にする！
  public Todo createtodo(String title, LocalDate deadline) {
    TodoIdEntity entity = new TodoIdEntity();
    LocalDateTime createTime = LocalDateTime.now();
    entity.setCreateTime(createTime);
    todoIdRepository.save(entity);

    List<Map<String, Object>> list = jdbcTemplate.queryForList("select max(id) from seq_ai");

    Long id = (long) Integer.parseInt(list.get(0).get("max(id)").toString());


    Todo todo = new Todo(id, title, deadline);

    // TodoIdEntity todoIdEntity = todoIdRepository.findByMaxId();

    return todo;



  }



}
