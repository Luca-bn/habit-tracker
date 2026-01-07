package io.github.lucabn.habittracker.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {

  private LocalDateTime timestamp;
  private String errorMessage;

}
