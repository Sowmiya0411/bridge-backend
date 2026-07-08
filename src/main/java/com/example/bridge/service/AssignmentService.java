package com.example.bridge.service;

import com.example.bridge.dto.AssignmentRequestDto;
import com.example.bridge.entity.ConstructionTask;
import com.example.bridge.entity.ContractorAssignment;
import com.example.bridge.entity.SystemUser;
import com.example.bridge.exception.ResourceNotFoundException;
import com.example.bridge.repository.ConstructionTaskRepository;
import com.example.bridge.repository.ContractorAssignmentRepository;
import com.example.bridge.repository.SystemUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private final ContractorAssignmentRepository assignmentRepository;
    private final ConstructionTaskRepository taskRepository;
    private final SystemUserRepository userRepository;

    public AssignmentService(
            ContractorAssignmentRepository assignmentRepository,
            ConstructionTaskRepository taskRepository,
            SystemUserRepository userRepository) {

        this.assignmentRepository = assignmentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public ContractorAssignment createAssignment(AssignmentRequestDto dto) {

        ConstructionTask task = taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        SystemUser contractor = userRepository.findById(dto.getContractorId())
                .orElseThrow(() -> new ResourceNotFoundException("Contractor not found"));

        ContractorAssignment assignment = new ContractorAssignment();

        assignment.setTask(task);
        assignment.setContractor(contractor);
        assignment.setAssignedDate(dto.getAssignedDate());
        assignment.setHourlyRate(dto.getHourlyRate());
        assignment.setHoursAllocated(dto.getHoursAllocated());
        assignment.setStatus(dto.getStatus());

        return assignmentRepository.save(assignment);
    }

    public List<ContractorAssignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public ContractorAssignment getAssignmentById(Long id) {

        return assignmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assignment not found with id: " + id));
    }

    public ContractorAssignment updateAssignment(Long id,
                                                 ContractorAssignment assignment) {

        ContractorAssignment existing = getAssignmentById(id);

        existing.setTask(assignment.getTask());
        existing.setContractor(assignment.getContractor());
        existing.setAssignedDate(assignment.getAssignedDate());
        existing.setHourlyRate(assignment.getHourlyRate());
        existing.setHoursAllocated(assignment.getHoursAllocated());
        existing.setStatus(assignment.getStatus());

        return assignmentRepository.save(existing);
    }

    public void deleteAssignment(Long id) {

        ContractorAssignment existing = getAssignmentById(id);

        assignmentRepository.delete(existing);
    }
}