package com.ironhack.consoletaskmanager.menu;

import com.ironhack.consoletaskmanager.model.Task;
import com.ironhack.consoletaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TaskMenu {

    private final Scanner scanner;
    @Autowired
    private TaskService taskService;

    public void menu() {
        String answer;
        do {
            System.out.println("""
                Please pick an option:
                CREATE - create a new task
                READ - read all the task
                UPDATE - change the status of a task
                ---
                EXIT - close the program :(
                """);
            answer = scanner.nextLine().trim().toUpperCase();
            switch (answer) {
                case "CREATE" ->
                        createTaskMenu();
                case "READ" ->
                        readAllTasksMenu();
                case "UPDATE" ->
                        updateStatusMenu();
                case "EXIT" -> System.out.println("Exiting the program, see you soon!");
                case default -> System.out.println("Please pick a valid option");
            }
        } while (!answer.equals("EXIT"));
        }

        private void createTaskMenu() {
            System.out.println("Please introduce task description:");
            var description = scanner.nextLine().trim();
            var taskToStore = new Task(description);
            var storedTask = taskService.create(taskToStore);
            System.out.printf("A new task has been created with id: %s," +
                    " with description: %s, and status: %s. \n",
                    storedTask.getId(), storedTask.getDescription(), storedTask.getStatus());
        }

        private void readAllTasksMenu(){
            System.out.println("Printing all the tasks:");
            var allTask = taskService.findAll();
            allTask.forEach(System.out::println); // basically is a loop, just in a fancier way -> use the stream API of JAVA
        }

        private void updateStatusMenu() {
            System.out.println("Please introduce the id of the task we you want to change the status of:");
            var answer = Long.valueOf(scanner.nextLine().trim());
            var updatedTask = taskService.updateStatus(answer);
            System.out.println("Task has been updated with success: " + updatedTask);
        }





    public TaskMenu() {
        scanner = new Scanner(System.in);
    }
}
