package com.ironhack.consoletaskmanager.repository;

import com.ironhack.consoletaskmanager.model.Task;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository // == @Component
public class TaskRepository {

    private List<Task> list = new ArrayList<>();

    public Task create(Task task){
        list.add(task);
        return task;
    }

    public List<Task> findAll() {
        return list;
    }

    private int getIndexById (Long id){
        for(int i =0; i < list.size(); i++ ){
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Task getById(Long id) {
        var index = getIndexById(id);
        if (index >= 0){
            return list.get(index);
        }
        return null;
    }

    public Task update(Task task) {
        var index = getIndexById(task.getId());
        list.remove(index);
        list.add(task);
        return task;
    }
}
