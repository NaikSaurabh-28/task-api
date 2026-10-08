package com.example.task_api.controller;

import com.example.task_api.model.Task;
import com.example.task_api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Map<String, String> request) {
        return taskService.addTask(request.get("title"));
    }

    @GetMapping("/tasks/count")
    public Map<String, Integer> getTaskCount() {
        return Map.of("count", taskService.getAllTasks().size());
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}