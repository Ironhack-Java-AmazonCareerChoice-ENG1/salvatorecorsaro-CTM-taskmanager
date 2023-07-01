package com.ironhack.consoletaskmanager.service;

import com.ironhack.consoletaskmanager.model.Task;
import com.ironhack.consoletaskmanager.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // == @Component
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task create(Task task){
        return taskRepository.save(task);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Transactional
    public Task updateStatus(Long id){
        var task = taskRepository.getById(id);
        task.changeStatus();
       return task;
    }

}
