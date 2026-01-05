package io.github.lucabn.habittracker.rest.controller;

import io.github.lucabn.habittracker.entity.Habit;
import io.github.lucabn.habittracker.entity.HabitLog;
import io.github.lucabn.habittracker.repository.HabitLogRepository;
import io.github.lucabn.habittracker.repository.HabitRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/habits")
public class HabitRestController {

  private final HabitRepository habitRepository;
  private final HabitLogRepository habitLogRepository;

  @PostMapping
  public Habit create(@RequestBody Habit habit) {
    return habitRepository.save(habit);
  }

  @PutMapping
  public Habit update(@RequestBody Habit habit) {
    return habitRepository.save(habit);
  }

  @DeleteMapping("/{habit-id}")
  public String delete(@PathVariable("habit-id") Long habitId) {
    habitRepository.deleteById(habitId);
    return "OK";
  }

  @PutMapping("/log")
  public HabitLog createLog(@RequestBody HabitLog log) {
    return habitLogRepository.save(log);
  }

  @GetMapping("/{habit-id}/logs")
  public Iterable<HabitLog> getHistory(@PathVariable("habit-id") long habitId) {
    return habitLogRepository.findByHabit_Id(habitId);
  }

  @GetMapping("/all")
  public Iterable<Habit> getAll() {
    return habitRepository.findAll();
  }

}
