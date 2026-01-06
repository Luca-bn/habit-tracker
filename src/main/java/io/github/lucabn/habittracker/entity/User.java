package io.github.lucabn.habittracker.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  List<Habit> habits;
  @Id
  @GeneratedValue(generator = "users_seq")
  @SequenceGenerator(name = "users_seq", sequenceName = "users_id_seq", allocationSize = 1)
  private Long id;
  private String username;
  private String email;
  @Column(name = "password_hash")
  private String pswHash;
  @Column(name = "is_active")
  private boolean isActive;
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

//  id              BIGINT PRIMARY KEY DEFAULT nextval('users_id_seq'),
//  username        VARCHAR(50) NOT NULL UNIQUE,
//  email           VARCHAR(255) NOT NULL UNIQUE,
//  password_hash   VARCHAR(255) NOT NULL,
//  is_active       BOOLEAN DEFAULT TRUE,
//  created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//  updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP

}

