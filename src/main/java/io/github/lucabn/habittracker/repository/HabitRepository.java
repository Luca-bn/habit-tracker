package io.github.lucabn.habittracker.repository;

import io.github.lucabn.habittracker.entity.Habit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends CrudRepository<Habit, Long> {

}
