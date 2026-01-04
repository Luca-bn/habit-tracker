package io.github.lucabn.habittracker.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/habit")
public class HabitRestController {

  @PostMapping("/create")
  public String create(@RequestBody Object habit) {
    return "OK";
  }

  @PutMapping("/update")
  public String update(@RequestBody Object habit) {
    return "OK";
  }

  @DeleteMapping("/delete")
  public String delete(@RequestBody Object habit) {
    return "OK";
  }

  @PostMapping("/status")
  public String updateStatus(@RequestBody Object habit) {
    return "OK";
  }

  @GetMapping("/{habit-id}/status")
  public String getHistory(@PathVariable("habit-id") String habitId) {
    return habitId;
  }

  @GetMapping("/all")
  public String getAll() {
    return "OK";
  }

}
