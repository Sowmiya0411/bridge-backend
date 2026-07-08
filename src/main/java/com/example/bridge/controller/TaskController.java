package com.example.bridge.controller;

import com.example.bridge.entity.ConstructionTask;
import com.example.bridge.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bridge.dto.TaskRequestDto;
import  java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<ConstructionTask> createTask(
            @Valid @RequestBody TaskRequestDto taskRequestDto) {

        return ResponseEntity.ok(taskService.createTask(taskRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConstructionTask> getTaskById(
            @PathVariable Long id) {

        return ResponseEntity.ok(taskService.getTaskById(id));
    }
    @GetMapping
    public ResponseEntity<List<ConstructionTask>>getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ConstructionTask> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody ConstructionTask task) {

        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}