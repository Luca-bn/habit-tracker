package io.github.lucabn.habittracker.repository;

import io.github.lucabn.habittracker.entity.HabitLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitLogRepository extends CrudRepository<HabitLog, Long> {

  Iterable<HabitLog> findByHabitId(long habitId);

}
