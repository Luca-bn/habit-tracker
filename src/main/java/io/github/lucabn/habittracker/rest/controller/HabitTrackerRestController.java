package io.github.lucabn.habittracker.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HabitTrackerRestController {

  @GetMapping("/health")
  public String health() {
    return "OK";
  }



}
