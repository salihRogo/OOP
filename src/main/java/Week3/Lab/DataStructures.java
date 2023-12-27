package Week3.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1, "Push lab code to the github", Status.TO_DO),
                new TaskItem(2, "Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3, "Go over tasks from lab2", Status.COMPLETED));
    }

    // TODO create a method to get all objects

    public List<TaskItem> getAll() {
        return this.tasks;
    }

    // TODO create a method getByStatus that will accept a Status parameter and filter the tasks with the provided status

    public Optional<TaskItem> getByStatus(Status status) {
        return tasks
                .stream()
                .filter(tasks -> {
                    return tasks.getStatus().equals(status);
                }).findFirst();
    }

    // TODO create a method to find tasks whose id parameter greater than or equal to 2

    public List<TaskItem> findAgeGreaterThan() {
        return tasks
                .stream()
                .filter(tasks -> tasks.getId() >= (2))
                .collect(Collectors.toList());
    }

    // TODO create a method that will, by using the forEach stream method, print to the console the description of each task

    public void printDescription(){
        for (TaskItem t : tasks){
            System.out.println(t.getDescription());
        }
    }
}

