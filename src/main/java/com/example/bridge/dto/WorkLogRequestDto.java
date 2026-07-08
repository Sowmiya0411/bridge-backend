package com.example.bridge.dto;

import java.time.LocalDate;

public class WorkLogRequestDto {

    private Long inquiryId;
    private Long supervisorId;
    private LocalDate logDate;
    private Integer laborCount;
    private String weatherCondition;
    private String notes;
    private Integer progressIncrement;

    public WorkLogRequestDto() {
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
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