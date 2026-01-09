package io.github.lucabn.habittracker.service;

import io.github.lucabn.habittracker.dto.HabitDTO;
import io.github.lucabn.habittracker.dto.HabitLogDTO;
import io.github.lucabn.habittracker.entity.Habit;
import io.github.lucabn.habittracker.entity.HabitAdditionalData;
import io.github.lucabn.habittracker.entity.HabitLog;
import io.github.lucabn.habittracker.exception.InvalidParametersException;
import io.github.lucabn.habittracker.mapper.EntityMappers.HabitAdditionalDataMapper;
import io.github.lucabn.habittracker.mapper.EntityMappers.HabitLogMapper;
import io.github.lucabn.habittracker.mapper.EntityMappers.HabitMapper;
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
  private final HabitMapper habitMapper;
  private final HabitAdditionalDataMapper habitAdditionalDataMapper;
  private final HabitLogMapper habitLogMapper;

  public HabitDTO createHabit(HabitDTO habit) {
    Habit entity = habitMapper.toEntity(habit);
    entity.setAdditionalData(
        Stream.ofNullable(habit.getAdditionalData()).flatMap(List::stream).map(data -> {
          HabitAdditionalData additionalDataEntity = habitAdditionalDataMapper.toEntity(data);
          additionalDataEntity.setHabit(entity);
          return additionalDataEntity;
        }).toList());
    habitRepository.save(entity);
    habit.setId(entity.getId());
    return habit;
  }

  public HabitDTO updateHabit(HabitDTO habit) throws Exception {
    Habit entity = habitRepository.findById(habit.getId()).orElseThrow(
        () -> new InvalidParametersException(
            String.format("habit id [%s] not found", habit.getId())));
    entity.setUserId(habit.getUserId());
    entity.setDescription(habit.getDescription());
    entity.setCategory(habit.getCategory());
    entity.setAdditionalData(
        Stream.ofNullable(habit.getAdditionalData()).flatMap(List::stream).map(data -> {
          HabitAdditionalData additionalDataEntity = habitAdditionalDataMapper.toEntity(data);
          additionalDataEntity.setHabit(entity);
          return additionalDataEntity;
        }).toList());
    habitRepository.save(entity);
    return habit;
  }

  public void deleteHabit(Long habitId) {
    habitRepository.deleteById(habitId);
  }

  public HabitLogDTO createLog(HabitLogDTO log) {
    HabitLog entity = habitLogMapper.toEntity(log);
    habitLogRepository.save(entity);
    log.setId(entity.getId());
    return log;
  }

  public List<HabitLogDTO> getHabitLogs(long habitId) {
    return StreamSupport.stream(habitLogRepository.findByHabitId(habitId).spliterator(), false).map(
        entity -> HabitLogDTO.builder().id(entity.getId()).logDate(entity.getLogDate())
            .logStatus(entity.getLogStatus()).habitId(entity.getHabitId()).build()).toList();
  }

  public List<HabitDTO> findAll() {
    return StreamSupport.stream(habitRepository.findAll().spliterator(), false)
        .map(habitMapper::toDTO).toList();
  }
}
