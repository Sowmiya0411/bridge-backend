package com.example.bridge.entity;

import com.example.bridge.enums.InquiryStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "project_inquiries")
public class ProjectInquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String siteName;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private SystemUser client;

    @Column(nullable = false)
    private String projectType;

    @Column(nullable = false)
    private String location;

    private Integer bhkCount;

    private Integer floorCount;

    @Column(precision = 15, scale = 2)
    private BigDecimal budget;

    private String duration;

    private LocalDate startDate;

    private LocalDate endDate;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id")
    private SystemUser contractor;

    @Enumerated(EnumType.STRING)
    private InquiryStatus status = InquiryStatus.PENDING;

    public ProjectInquiry() {
    }

    public ProjectInquiry(Long id, String siteName, SystemUser client,
                          String projectType, String location,
                          Integer bhkCount, Integer floorCount,
                          BigDecimal budget, String duration,
                          LocalDate startDate, LocalDate endDate,
                          SystemUser contractor, InquiryStatus status) {
        this.id = id;
        this.siteName = siteName;
        this.client = client;
        this.projectType = projectType;
        this.location = location;
        this.bhkCount = bhkCount;
        this.floorCount = floorCount;
        this.budget = budget;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractor = contractor;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public SystemUser getClient() {
        return client;
    }

    public void setClient(SystemUser client) {
        this.client = client;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getBhkCount() {
        return bhkCount;
    }

    public void setBhkCount(Integer bhkCount) {
        this.bhkCount = bhkCount;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public SystemUser getContractor() {
        return contractor;
    }

    public void setContractor(SystemUser contractor) {
        this.contractor = contractor;
    }

    public InquiryStatus getStatus() {
        return status;
    }

    public void setStatus(InquiryStatus status) {
        this.status = status;
    }
}