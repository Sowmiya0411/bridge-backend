package com.example.bridge.controller;

import com.example.bridge.dto.InquiryRequestDto;
import com.example.bridge.entity.ProjectInquiry;
import com.example.bridge.enums.InquiryStatus;
import com.example.bridge.service.InquiryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "*")
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    // Create a new inquiry
    @PostMapping
    public ResponseEntity<ProjectInquiry> createInquiry(
            @RequestParam Long clientId,
            @Valid @RequestBody InquiryRequestDto inquiryRequestDto) {

        ProjectInquiry inquiry = inquiryService.createInquiry(inquiryRequestDto, clientId);

        return ResponseEntity.ok(inquiry);
    }

    // Get inquiries for a specific client
    @GetMapping("/my")
    public ResponseEntity<List<ProjectInquiry>> getMyInquiries(
            @RequestParam Long clientId) {

        List<ProjectInquiry> inquiries = inquiryService.getMyInquiries(clientId);

        return ResponseEntity.ok(inquiries);
    }

    // Get all inquiries (Admin)
    @GetMapping("/all")
    public ResponseEntity<List<ProjectInquiry>> getAllInquiries() {

        List<ProjectInquiry> inquiries = inquiryService.getAllInquiries();

        return ResponseEntity.ok(inquiries);
    }

    // Assign contractor
    @PostMapping("/{id}/assign")
    public ResponseEntity<ProjectInquiry> assignContractor(
            @PathVariable Long id,
            @RequestParam Long contractorId) {

        ProjectInquiry inquiry =
                inquiryService.assignContractor(id, contractorId);

        return ResponseEntity.ok(inquiry);
    }

    // Update inquiry status
    @PatchMapping("/{id}/status")
    public ResponseEntity<ProjectInquiry> updateStatus(
            @PathVariable Long id,
            @RequestParam InquiryStatus status) {

        ProjectInquiry inquiry =
                inquiryService.updateStatus(id, status);

        return ResponseEntity.ok(inquiry);
    }

    // Delete inquiry
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInquiry(
            @PathVariable Long id) {

        inquiryService.deleteInquiry(id);

        return ResponseEntity.ok("Inquiry deleted successfully.");
    }
}