package io.github.lucabn.habittracker.rest.controller;

import io.github.lucabn.habittracker.dto.UserDTO;
import io.github.lucabn.habittracker.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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
@RequestMapping("/api/v1/users")
public class UserRestController {

  private final UserService userService;

  @GetMapping("/{user-id}")
  public UserDTO getUser(@Min(0) @PathVariable("user-id") Long userId) throws Exception {
    return userService.findUser(userId);
  }

  @GetMapping("/all")
  public List<UserDTO> getUsers() {
    return userService.findUsers();
  }

  @PostMapping
  public UserDTO create(@Valid @RequestBody UserDTO user) {
    return userService.createUser(user);
  }

  @PutMapping
  public UserDTO update(@Valid @RequestBody UserDTO user) throws Exception {
    return userService.updateUser(user);
  }

  @DeleteMapping("/{user-id}")
  public String delete(@Min(0) @PathVariable("user-id") Long userId) {
    userService.deleteUser(userId);
    return "OK";
  }

}
