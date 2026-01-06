package io.github.lucabn.habittracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "habit_logs")
public class HabitLog {

  @Id
  @GeneratedValue(generator = "habit_log_seq")
  @SequenceGenerator(name = "habit_log_seq", sequenceName = "habit_logs_id_seq", allocationSize = 1)
  private Long id;
  @Column(name = "log_date")
  private LocalDateTime logDate;
  @Column(name = "log_status")
  private int logStatus;
  @Column(name = "habit_id")
  private Long habitId;

//  id              BIGINT PRIMARY KEY DEFAULT nextval('habit_logs_id_seq'),
//  habit_id		BIGINT not null references habits (id),
//  log_date		timestamp,
//  log_status		int

}
