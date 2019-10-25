package com.ndmitrenko.dinosystemsrestapi.repository;

import com.ndmitrenko.dinosystemsrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findByFirstName(String firstName);
    Optional<User> findUserBySecondName(String secondName);
}
