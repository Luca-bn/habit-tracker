package io.github.lucabn.habittracker.repository;

import io.github.lucabn.habittracker.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
