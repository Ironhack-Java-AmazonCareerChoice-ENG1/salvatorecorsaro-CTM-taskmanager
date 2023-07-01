package com.ironhack.consoletaskmanager.service;

import com.ironhack.consoletaskmanager.model.Task;
import com.ironhack.consoletaskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // == @Component
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task create(Task task){
        return taskRepository.create(task);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task updateStatus(Long id){
        var task = taskRepository.getById(id);
        task.changeStatus();
        return taskRepository.update(task);
    }

}
