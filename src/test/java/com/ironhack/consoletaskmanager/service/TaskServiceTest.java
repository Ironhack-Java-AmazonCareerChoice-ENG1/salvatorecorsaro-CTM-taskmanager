package com.ironhack.consoletaskmanager.service;

import com.ironhack.consoletaskmanager.ConsoleTaskManagerApplication;
import com.ironhack.consoletaskmanager.enums.TaskStatus;
import com.ironhack.consoletaskmanager.model.Task;
import com.ironhack.consoletaskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {

    @MockBean
    ConsoleTaskManagerApplication consoleTaskManagerApplication;

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    String description;

    @BeforeEach
    void setup() {
        taskRepository.deleteAll();
        description = "Demo task 1";
        var task = new Task(description);
        taskRepository.save(task);
    }

    @Test
    public void myTest(){
        var allTask = taskService.findAll();
        assertEquals(1, allTask.size());
    }

    @Test
    public void update(){

        var taskFounded = taskRepository.findFirstByDescription(description);
        Long id;
        if (taskFounded.isPresent()){
            var originalStatus = taskFounded.get().getStatus();
            id = taskFounded.get().getId();
            var task = taskFounded.get();
            task.changeStatus();
            taskRepository.save(task);
            var updatedTask = taskRepository.findById(id).orElseThrow();
            assertNotEquals(originalStatus, task.getStatus() );
        }
    }

    @Test
    public void delete(){
        var taskToDelete = taskRepository.findFirstByDescription(description);
        taskRepository.deleteById(taskToDelete.get().getId());
        assertTrue(taskRepository.findFirstByDescription(description).isEmpty());
    }

    @Test
    public void addOne(){
        var before = taskRepository.findAll().size();
        var task2 = new Task("HAvin fun!");
        taskRepository.save(task2);
        var after = taskRepository.findAll().size();
        assertEquals(before + 1, after);
    }

}