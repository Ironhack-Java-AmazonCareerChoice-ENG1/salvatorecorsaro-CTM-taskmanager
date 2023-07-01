package com.ironhack.consoletaskmanager.repository;

import com.ironhack.consoletaskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
