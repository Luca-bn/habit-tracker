package io.github.lucabn.habittracker.repository;

import io.github.lucabn.habittracker.entity.HabitAdditionalData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitAdditionalDataRepository extends CrudRepository<HabitAdditionalData, Long> {

}
