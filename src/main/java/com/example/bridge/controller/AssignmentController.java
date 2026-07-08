package com.example.bridge.controller;

import com.example.bridge.dto.AssignmentRequestDto;
import com.example.bridge.entity.ContractorAssignment;
import com.example.bridge.service.AssignmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public ResponseEntity<ContractorAssignment> createAssignment(
            @Valid @RequestBody AssignmentRequestDto assignment) {

        return ResponseEntity.ok(
                assignmentService.createAssignment(assignment));
    }

    @GetMapping
    public ResponseEntity<List<ContractorAssignment>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractorAssignment> getAssignmentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                assignmentService.getAssignmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractorAssignment> updateAssignment(
            @PathVariable Long id,
            @Valid @RequestBody ContractorAssignment assignment) {

        return ResponseEntity.ok(
                assignmentService.updateAssignment(id, assignment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(
            @PathVariable Long id) {

        assignmentService.deleteAssignment(id);
        return ResponseEntity.ok("Assignment deleted successfully");
    }
}