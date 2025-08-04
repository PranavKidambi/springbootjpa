package com.springnew.repository;

import com.springnew.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    Optional<User> findByBirthday(LocalDate birthday);
    Optional<User> findBySalary(Double salary);
    List<User> findUsersByActive(boolean active);

    boolean Active(boolean active);

    Integer id(int id);
}
