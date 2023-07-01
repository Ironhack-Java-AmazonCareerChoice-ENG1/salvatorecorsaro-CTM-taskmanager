package com.ironhack.consoletaskmanager.repository;

import com.ironhack.consoletaskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findFirstByDescription(String description);
}
