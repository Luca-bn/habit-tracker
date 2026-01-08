package io.github.lucabn.habittracker.mapper;

import io.github.lucabn.habittracker.dto.HabitAdditionalDataDTO;
import io.github.lucabn.habittracker.dto.HabitDTO;
import io.github.lucabn.habittracker.dto.HabitLogDTO;
import io.github.lucabn.habittracker.dto.UserDTO;
import io.github.lucabn.habittracker.entity.Habit;
import io.github.lucabn.habittracker.entity.HabitAdditionalData;
import io.github.lucabn.habittracker.entity.HabitLog;
import io.github.lucabn.habittracker.entity.User;
import org.mapstruct.Mapper;

public interface EntityMappers {

  interface GenericEntityMapper<D, E> {

    E toEntity(D dto);

    D toDTO(E entity);
  }

  @Mapper(componentModel = "spring")
  interface UserMapper extends GenericEntityMapper<UserDTO, User> {

  }

  @Mapper(componentModel = "spring")
  interface HabitMapper extends GenericEntityMapper<HabitDTO, Habit> {

  }

  @Mapper(componentModel = "spring")
  interface HabitAdditionalDataMapper extends
      GenericEntityMapper<HabitAdditionalDataDTO, HabitAdditionalData> {

  }

  @Mapper(componentModel = "spring")
  interface HabitLogMapper extends GenericEntityMapper<HabitLogDTO, HabitLog> {

  }

}
