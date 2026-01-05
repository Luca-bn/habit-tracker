package io.github.lucabn.habittracker.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "habits")
public class Habit {

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "habit")
  List<HabitAdditionalData> additionalData;
  @Id
  private long id;
  private String description;
  private String category;
  @Column(name = "user_id")
  private long userId;

//  id              BIGINT PRIMARY KEY DEFAULT nextval('habits_id_seq'),
//  description		VARCHAR(255) NOT NULL,
//  category		VARCHAR(255) NOT NULL

}
