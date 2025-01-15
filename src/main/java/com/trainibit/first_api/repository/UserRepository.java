package com.trainibit.first_api.repository;

import com.trainibit.first_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
