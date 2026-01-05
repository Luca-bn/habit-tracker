package io.github.lucabn.habittracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "habit_logs")
public class HabitLog {

  @Id
  private long id;
  @Column(name = "log_date")
  private String logDate;
  @Column(name = "log_status")
  private int logStatus;
  @ManyToOne
  @JoinColumn(name = "habit_id", referencedColumnName = "id")
  private Habit habit;

//  id              BIGINT PRIMARY KEY DEFAULT nextval('habit_logs_id_seq'),
//  habit_id		BIGINT not null references habits (id),
//  log_date		timestamp,
//  log_status		int

}
