package com.example.bridge.entity;

import com.example.bridge.enums.AssignmentStatus;
import jakarta.persistence.*;
import com.example.bridge.entity.SystemUser;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "contractor_assignments")
public class ContractorAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonIgnoreProperties({"project"})
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private ConstructionTask task;

    @ManyToOne
    @JoinColumn(name = "contractor_id", nullable = false)
    private SystemUser contractor;

    private LocalDate assignedDate;

    private BigDecimal hourlyRate;

    private Integer hoursAllocated;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    public ContractorAssignment() {
    }

    public ContractorAssignment(Long id, ConstructionTask task,
                                SystemUser contractor,
                                LocalDate assignedDate,
                                BigDecimal hourlyRate,
                                Integer hoursAllocated,
                                AssignmentStatus status) {
        this.id = id;
        this.task = task;
        this.contractor = contractor;
        this.assignedDate = assignedDate;
        this.hourlyRate = hourlyRate;
        this.hoursAllocated = hoursAllocated;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConstructionTask getTask() {
        return task;
    }

    public void setTask(ConstructionTask task) {
        this.task = task;
    }

    public SystemUser getContractor() {
        return contractor;
    }

    public void setContractor(SystemUser contractor) {
        this.contractor = contractor;
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