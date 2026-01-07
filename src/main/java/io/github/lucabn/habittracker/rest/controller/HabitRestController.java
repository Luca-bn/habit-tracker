package io.github.lucabn.habittracker.rest.controller;

import io.github.lucabn.habittracker.dto.HabitDTO;
import io.github.lucabn.habittracker.dto.HabitLogDTO;
import io.github.lucabn.habittracker.service.HabitService;
import java.util.List;
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

  private final HabitService habitService;

  @PostMapping
  public HabitDTO create(@RequestBody HabitDTO habit) {
    return habitService.createHabit(habit);
  }

  @PutMapping
  public HabitDTO update(@RequestBody HabitDTO habit) throws Exception {
    return habitService.updateHabit(habit);
  }

  @DeleteMapping("/{habit-id}")
  public String delete(@PathVariable("habit-id") Long habitId) {
    habitService.deleteHabit(habitId);
    return "OK";
  }

  @PutMapping("/log")
  public HabitLogDTO createLog(@RequestBody HabitLogDTO log) {
    return habitService.createLog(log);
  }

  @GetMapping("/{habit-id}/logs")
  public List<HabitLogDTO> getHabitLogs(@PathVariable("habit-id") long habitId) {
    return habitService.getHabitLogs(habitId);
  }

  @GetMapping("/all")
  public List<HabitDTO> findAll() {
    return habitService.findAll();
  }

}
