package com.ironhack.consoletaskmanager.model;

import com.ironhack.consoletaskmanager.enums.TaskStatus;
import lombok.*;

@Getter
@Setter
@ToString
public class Task {
    private static Long taskCounter = 1L;

    private Long id;
    private String description;
    private TaskStatus status;

    public Task(String description) {
        id = taskCounter++;
        this.description = description;
        status = TaskStatus.TODO;
    }

    public void changeStatus(){
        if (status == TaskStatus.DONE){
            status = TaskStatus.TODO;
        } else if(status == TaskStatus.TODO){
            status = TaskStatus.DONE;
        }
    }
}
