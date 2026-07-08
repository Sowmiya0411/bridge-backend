package com.example.bridge.repository;

import com.example.bridge.entity.ContractorAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractorAssignmentRepository
        extends JpaRepository<ContractorAssignment, Long> {

    List<ContractorAssignment> findByTaskId(Long taskId);

    List<ContractorAssignment> findByContractorId(Long contractorId);

}