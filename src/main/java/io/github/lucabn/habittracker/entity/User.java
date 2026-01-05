package io.github.lucabn.habittracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  private long id;
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

