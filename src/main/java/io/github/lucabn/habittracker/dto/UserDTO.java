package io.github.lucabn.habittracker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private Long id;
  @NotBlank(message = "username cannot be empty")
  private String username;
  @NotBlank(message = "email cannot be empty")
  private String email;
  @NotBlank(message = "password cannot be empty")
  private String pswHash;

}
