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
@Table(name = "habits_additional_data")
public class HabitAdditionalData {

  @Id
  private long id;
  @Column(name = "data_name")
  private String dataName;
  @Column(name = "data_value")
  private String dataValue;
  @Column(name = "data_type")
  private String dataType;
  @ManyToOne
  @JoinColumn(name = "habit_id", referencedColumnName = "id")
  private Habit habit;

//  id              BIGINT PRIMARY KEY DEFAULT nextval('habits_additional_data_id_seq'),
//  habit_id		BIGINT not null references habits (id),
//  data_name		VARCHAR(255) NOT NULL,
//  data_value		VARCHAR(255) NOT NULL,
//  data_type		VARCHAR(50) NOT NULL

}
