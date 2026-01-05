package io.github.lucabn.habittracker.rest.controller;

import io.github.lucabn.habittracker.entity.User;
import io.github.lucabn.habittracker.repository.UserRepository;
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
@RequestMapping("/api/v1/users")
public class UserRestController {

  private final UserRepository userRepository;

  @GetMapping("/{user-id}")
  public User getUser(@PathVariable("user-id") Long userId) {
    return userRepository.findById(userId).orElse(null);
  }

  @GetMapping("/all")
  public Iterable<User> getUsers() {
    return userRepository.findAll();
  }

  @PostMapping
  public User create(@RequestBody User user) {
    return userRepository.save(user);
  }

  @PutMapping
  public User update(@RequestBody User user) {
    return userRepository.save(user);
  }

  @DeleteMapping("/{user-id}")
  public String delete(@PathVariable("user-id") Long userId) {
    userRepository.deleteById(userId);
    return "OK";
  }

}
