package com.example.task_api.service;

import com.example.task_api.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    private long nextId = 1;

    public TaskService() {
        tasks.add(new Task(nextId++, "Learn DevOps", false));
        tasks.add(new Task(nextId++, "Build Jenkins Pipeline", false));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task addTask(String title) {
        Task task = new Task(nextId++, title, false);
        tasks.add(task);
        return task;
    }
}