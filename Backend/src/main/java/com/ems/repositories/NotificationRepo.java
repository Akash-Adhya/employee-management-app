package com.ems.repositories;

import com.ems.entities.Notification;
import com.ems.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification,Long> {
    List<Notification> findByUser(User user);
}
