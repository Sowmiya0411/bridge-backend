package com.example.bridge.entity;

import com.example.bridge.enums.Priority;
import com.example.bridge.enums.TaskStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "construction_tasks")
public class ConstructionTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id", nullable = false)
    private ProjectInquiry project;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(precision = 15, scale = 2)
    private BigDecimal estimatedCost;

    public ConstructionTask() {
    }

    public ConstructionTask(Long id, ProjectInquiry project, String title,
                            String description, Priority priority,
                            TaskStatus status, BigDecimal estimatedCost) {
        this.id = id;
        this.project = project;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.estimatedCost = estimatedCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectInquiry getProject() {
        return project;
    }

    public void setProject(ProjectInquiry project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(BigDecimal estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}