package com.example.demo.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

/**
 * todoEntity
 * 
 * @author furutakazuto
 */
@Entity
@Table(name = "furuta_todo")
@Data
public class TodoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;

  private LocalDate deadline;

  private Boolean status;

  @CreationTimestamp
  private LocalDateTime createTime;

  @UpdateTimestamp
  private LocalDateTime updateTime;



}
