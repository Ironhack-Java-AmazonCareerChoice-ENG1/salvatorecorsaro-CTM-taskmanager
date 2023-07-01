package com.ironhack.consoletaskmanager.model;

import com.ironhack.consoletaskmanager.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    public Task(String description) {
        this.description = description;
        status = TaskStatus.TODO;
    }

    public void changeStatus(){
        if (status.equals(TaskStatus.DONE)){
            setStatus(TaskStatus.TODO);
        } else if(status.equals(TaskStatus.TODO)){
            setStatus(TaskStatus.DONE);
        }
    }
}