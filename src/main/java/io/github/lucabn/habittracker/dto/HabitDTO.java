package io.github.lucabn.habittracker.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HabitDTO {

  private Long id;
  @NotBlank(message = "description cannot be empty")
  private String description;
  private String category;
  private Long userId;
  private List<HabitAdditionalDataDTO> additionalData;

}
