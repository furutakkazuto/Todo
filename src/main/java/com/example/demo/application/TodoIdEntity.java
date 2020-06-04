package com.example.demo.application;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "seq_ai")
public class TodoIdEntity {

  @Id
  private long id;

  private LocalDateTime createTime;



}
