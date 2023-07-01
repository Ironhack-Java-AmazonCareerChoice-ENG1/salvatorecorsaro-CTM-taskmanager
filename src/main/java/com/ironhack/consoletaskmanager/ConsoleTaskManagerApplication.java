package com.ironhack.consoletaskmanager;

import com.ironhack.consoletaskmanager.menu.TaskMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleTaskManagerApplication implements CommandLineRunner {

    @Autowired
    private TaskMenu taskMenu;

    public static void main(String[] args) {
        SpringApplication.run(ConsoleTaskManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to CTM, the best tool to track your TODO list!");
        taskMenu.menu();
    }
}
