package com.challenge.pharmainc.repository;

import com.challenge.pharmainc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
