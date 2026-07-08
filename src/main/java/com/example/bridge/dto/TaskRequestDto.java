package com.example.bridge.dto;

import com.example.bridge.enums.Priority;
import com.example.bridge.enums.TaskStatus;
import java.math.BigDecimal;

public class TaskRequestDto {

    private Long inquiryId;

    private String title;

    private String description;

    private Priority priority;

    private TaskStatus status;

    private BigDecimal estimatedCost;

    public TaskRequestDto() {
    }

    public TaskRequestDto(Long inquiryId,
                          String title,
                          String description,
                          Priority priority,
                          TaskStatus status,
                          BigDecimal estimatedCost) {

        this.inquiryId = inquiryId;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.estimatedCost = estimatedCost;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
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