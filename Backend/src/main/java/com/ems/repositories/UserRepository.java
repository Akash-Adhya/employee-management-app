package com.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
