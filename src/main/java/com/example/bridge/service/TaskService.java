package com.example.bridge.service;

import com.example.bridge.entity.ConstructionTask;
import com.example.bridge.entity.ProjectInquiry;
import com.example.bridge.enums.TaskStatus;
import com.example.bridge.exception.ResourceNotFoundException;
import com.example.bridge.repository.ConstructionTaskRepository;
import com.example.bridge.repository.ProjectInquiryRepository;

import org.springframework.stereotype.Service;
import com.example.bridge.dto.TaskRequestDto;

import java.util.List;

@Service
public class TaskService {
    
     private final ConstructionTaskRepository taskRepository;
     private final ProjectInquiryRepository inquiryRepository;

     public TaskService(ConstructionTaskRepository taskRepository,
                       ProjectInquiryRepository inquiryRepository) {
        this.taskRepository = taskRepository;
        this.inquiryRepository = inquiryRepository;
    }
    public ConstructionTask createTask(TaskRequestDto dto) {
        ProjectInquiry inquiry = inquiryRepository.findById(dto.getInquiryId())
        .orElseThrow(() -> new RuntimeException("Inquiry not found"));

        ConstructionTask task = new ConstructionTask();

        task.setProject(inquiry);
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setStatus(dto.getStatus());
        task.setEstimatedCost(dto.getEstimatedCost());
        return taskRepository.save(task);
    }

    public List<ConstructionTask> getAllTasks() {
        return taskRepository.findAll();
    }

    public ConstructionTask getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id));
    }

    public ConstructionTask updateTask(Long id, ConstructionTask updatedTask) {

        ConstructionTask existingTask = getTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setEstimatedCost(updatedTask.getEstimatedCost());
       // existingTask.setProject(updatedTask.getProject());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {

        ConstructionTask task = getTaskById(id);
        taskRepository.delete(task);
    }

    public ConstructionTask updateTaskStatus(Long id, TaskStatus status) {

        ConstructionTask task = getTaskById(id);
        task.setStatus(status);

        return taskRepository.save(task);
    }
    
}