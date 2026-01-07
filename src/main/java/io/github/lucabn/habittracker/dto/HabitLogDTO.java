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
public class HabitLogDTO {

  private Long id;
  private LocalDateTime logDate;
  private int logStatus;
  private Long habitId;

}
