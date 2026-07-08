package com.example.bridge.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.bridge.enums.AssignmentStatus;

public class AssignmentRequestDto {

    private Long taskId;
    private Long contractorId;
    private LocalDate assignedDate;
    private BigDecimal hourlyRate;
    private Integer hoursAllocated;
    private AssignmentStatus status;

    public AssignmentRequestDto() {}

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
        this.contractorId = contractorId;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Integer getHoursAllocated() {
        return hoursAllocated;
    }

    public void setHoursAllocated(Integer hoursAllocated) {
        this.hoursAllocated = hoursAllocated;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }
}