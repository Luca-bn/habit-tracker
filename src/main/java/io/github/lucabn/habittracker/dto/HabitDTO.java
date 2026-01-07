package io.github.lucabn.habittracker.dto;

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
  private String description;
  private String category;
  private Long userId;
  private List<HabitAdditionalDataDTO> additionalData;

}
