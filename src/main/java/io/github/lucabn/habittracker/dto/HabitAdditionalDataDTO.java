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
public class HabitAdditionalDataDTO {

  @NotBlank(message = "data name cannot be empty")
  private String dataName;
  @NotBlank(message = "data value cannot be empty")
  private String dataValue;
  @NotBlank(message = "data type cannot be empty")
  private String dataType;

}
