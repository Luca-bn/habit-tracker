package io.github.lucabn.habittracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HabitAdditionalDataDTO {

  private String dataName;
  private String dataValue;
  private String dataType;

}
