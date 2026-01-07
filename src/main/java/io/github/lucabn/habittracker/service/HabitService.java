package io.github.lucabn.habittracker.service;

import io.github.lucabn.habittracker.dto.HabitAdditionalDataDTO;
import io.github.lucabn.habittracker.dto.HabitDTO;
import io.github.lucabn.habittracker.dto.HabitLogDTO;
import io.github.lucabn.habittracker.entity.Habit;
import io.github.lucabn.habittracker.entity.HabitAdditionalData;
import io.github.lucabn.habittracker.entity.HabitLog;
import io.github.lucabn.habittracker.exception.InvalidParametersException;
import io.github.lucabn.habittracker.repository.HabitLogRepository;
import io.github.lucabn.habittracker.repository.HabitRepository;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HabitService {

  private final HabitRepository habitRepository;
  private final HabitLogRepository habitLogRepository;

  public HabitDTO createHabit(HabitDTO habit) {
    Habit entity = new Habit();
    entity.setUserId(habit.getUserId());
    entity.setDescription(habit.getDescription());
    entity.setCategory(habit.getCategory());
    entity.setAdditionalData(Stream.ofNullable(habit.getAdditionalData()).flatMap(List::stream)
        .map(additionalData -> {
          HabitAdditionalData additionalDataEntity = new HabitAdditionalData();
          additionalDataEntity.setHabit(entity);
          additionalDataEntity.setDataName(additionalData.getDataName());
          additionalDataEntity.setDataType(additionalData.getDataType());
          additionalDataEntity.setDataValue(additionalData.getDataValue());
          return additionalDataEntity;
        }).toList());
    habitRepository.save(entity);
    habit.setId(entity.getId());
    return habit;
  }

  public HabitDTO updateHabit(HabitDTO habit) throws Exception {
    Habit entity = habitRepository.findById(habit.getId())
        .orElseThrow(() -> new InvalidParametersException(
            String.format("habit id [%s] not found", habit.getId())));
    entity.setUserId(habit.getUserId());
    entity.setDescription(habit.getDescription());
    entity.setCategory(habit.getCategory());
    entity.setAdditionalData(Stream.ofNullable(habit.getAdditionalData()).flatMap(List::stream)
        .map(additionalData -> {
          HabitAdditionalData additionalDataEntity = new HabitAdditionalData();
          additionalDataEntity.setHabit(entity);
          additionalDataEntity.setDataName(additionalData.getDataName());
          additionalDataEntity.setDataType(additionalData.getDataType());
          additionalDataEntity.setDataValue(additionalData.getDataValue());
          return additionalDataEntity;
        }).toList());
    habitRepository.save(entity);
    return habit;
  }

  public void deleteHabit(Long habitId) {
    habitRepository.deleteById(habitId);
  }

  public HabitLogDTO createLog(HabitLogDTO log) {
    HabitLog entity = new HabitLog();
    entity.setHabitId(log.getHabitId());
    entity.setLogStatus(log.getLogStatus());
    entity.setHabitId(log.getHabitId());
    habitLogRepository.save(entity);
    log.setId(entity.getId());
    return log;
  }

  public List<HabitLogDTO> getHabitLogs(long habitId) {
    return StreamSupport.stream(habitLogRepository.findByHabitId(habitId).spliterator(), false)
        .map(entity ->
            HabitLogDTO.builder()
                .id(entity.getId())
                .logDate(entity.getLogDate())
                .logStatus(entity.getLogStatus())
                .habitId(entity.getHabitId())
                .build()
        ).toList();
  }

  public List<HabitDTO> findAll() {
    return StreamSupport.stream(habitRepository.findAll().spliterator(), false)
        .map(entity ->
            HabitDTO.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .description(entity.getDescription())
                .category(entity.getCategory())
                .additionalData(
                    Stream.ofNullable(entity.getAdditionalData()).flatMap(List::stream)
                        .map(additionalDataEntity ->
                            HabitAdditionalDataDTO.builder()
                                .dataName(additionalDataEntity.getDataName())
                                .dataValue(additionalDataEntity.getDataValue())
                                .dataType(additionalDataEntity.getDataType())
                                .build()
                        )
                        .toList()
                )
                .build()).toList();
  }
}
