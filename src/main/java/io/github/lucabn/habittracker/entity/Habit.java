package io.github.lucabn.habittracker.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "habits")
public class Habit {

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "habit")
  List<HabitAdditionalData> additionalData;
  @Id
  @GeneratedValue(generator = "habit_seq")
  @SequenceGenerator(name = "habit_seq", sequenceName = "habits_id_seq", allocationSize = 1)
  private Long id;
  private String description;
  private String category;
  @Column(name = "user_id")
  private Long userId;

//  id              BIGINT PRIMARY KEY DEFAULT nextval('habits_id_seq'),
//  description		VARCHAR(255) NOT NULL,
//  category		VARCHAR(255) NOT NULL

}
