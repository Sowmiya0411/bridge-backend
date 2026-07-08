package com.example.bridge.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "daily_work_logs")
public class DailyWorkLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inquiry_id", nullable = false)
    private ProjectInquiry project;

    @ManyToOne
    @JoinColumn(name = "supervisor_id", nullable = false)
    private SystemUser supervisor;

    private LocalDate logDate;

    private Integer laborCount;

    private String weatherCondition;

    @Column(columnDefinition = "TEXT")
    private String notes;

    private Integer progressIncrement;

    public DailyWorkLog() {
    }

    public DailyWorkLog(Long id, ProjectInquiry project,
                        SystemUser supervisor,
                        LocalDate logDate,
                        Integer laborCount,
                        String weatherCondition,
                        String notes,
                        Integer progressIncrement) {
        this.id = id;
        this.project = project;
        this.supervisor = supervisor;
        this.logDate = logDate;
        this.laborCount = laborCount;
        this.weatherCondition = weatherCondition;
        this.notes = notes;
        this.progressIncrement = progressIncrement;
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

    public SystemUser getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(SystemUser supervisor) {
        this.supervisor = supervisor;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public Integer getLaborCount() {
        return laborCount;
    }

    public void setLaborCount(Integer laborCount) {
        this.laborCount = laborCount;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getProgressIncrement() {
        return progressIncrement;
    }

    public void setProgressIncrement(Integer progressIncrement) {
        this.progressIncrement = progressIncrement;
    }
}