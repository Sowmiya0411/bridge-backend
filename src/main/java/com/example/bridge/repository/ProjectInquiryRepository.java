package com.example.bridge.repository;

import com.example.bridge.entity.ProjectInquiry;
import com.example.bridge.enums.InquiryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProjectInquiryRepository extends JpaRepository<ProjectInquiry, Long> {

 

    List<ProjectInquiry> findByClientId(Long clientId);

    List<ProjectInquiry> findByContractorId(Long contractorId);

    List<ProjectInquiry> findByStatus(InquiryStatus status);

}