package io.github.lucabn.habittracker.service;

import io.github.lucabn.habittracker.dto.UserDTO;
import io.github.lucabn.habittracker.entity.User;
import io.github.lucabn.habittracker.exception.InvalidParametersException;
import io.github.lucabn.habittracker.mapper.EntityMappers.UserMapper;
import io.github.lucabn.habittracker.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserDTO createUser(UserDTO user) {
    User entity = userMapper.toEntity(user);
    entity.setActive(true);
    entity.setCreatedAt(LocalDateTime.now());
    entity.setUpdatedAt(LocalDateTime.now());
    userRepository.save(entity);
    user.setId(entity.getId());
    return user;
  }

  public UserDTO updateUser(UserDTO user) throws Exception {
    User entity = userRepository.findById(user.getId())
        .orElseThrow(() -> new InvalidParametersException(
            String.format("user id [%s] not found", user.getId())));
    entity.setEmail(user.getEmail());
    entity.setUsername(user.getUsername());
    entity.setPswHash(user.getPswHash());
    entity.setActive(true);
    entity.setUpdatedAt(LocalDateTime.now());
    userRepository.save(entity);
    return userMapper.toDTO(entity);
  }

  public void deleteUser(Long userId) {
    userRepository.deleteById(userId);
  }

  public UserDTO findUser(Long userId) throws Exception {
    User entity = userRepository.findById(userId).orElseThrow(() -> new InvalidParametersException(
        String.format("user id [%s] not found", userId)));
    return userMapper.toDTO(entity);
  }

  public List<UserDTO> findUsers() {
    return StreamSupport.stream(userRepository.findAll().spliterator(), false)
        .map(userMapper::toDTO).toList();
  }

}
