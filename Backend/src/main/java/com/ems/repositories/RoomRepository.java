package com.ems.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ems.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomCode(String roomCode);
}
