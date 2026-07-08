package com.example.bridge.service;

import com.example.bridge.dto.InquiryRequestDto;
import com.example.bridge.entity.ProjectInquiry;
import com.example.bridge.entity.SystemUser;
import com.example.bridge.enums.InquiryStatus;
import com.example.bridge.exception.ResourceNotFoundException;
import com.example.bridge.repository.ProjectInquiryRepository;
import com.example.bridge.repository.SystemUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryService {

    private final ProjectInquiryRepository inquiryRepository;
    private final SystemUserRepository userRepository;

    public InquiryService(ProjectInquiryRepository inquiryRepository,
                          SystemUserRepository userRepository) {
        this.inquiryRepository = inquiryRepository;
        this.userRepository = userRepository;
    }

    public ProjectInquiry createInquiry(InquiryRequestDto dto,Long clientId) {
        SystemUser client=userRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Client not found"));


        ProjectInquiry inquiry = new ProjectInquiry();
        inquiry.setClient(client);
        inquiry.setSiteName(dto.getSiteName());
        inquiry.setProjectType(dto.getProjectType());
        inquiry.setLocation(dto.getLocation());
        inquiry.setBhkCount(dto.getBhkCount());
        inquiry.setFloorCount(dto.getFloorCount());
        inquiry.setBudget(dto.getBudget());
        inquiry.setDuration(dto.getDuration());
        inquiry.setStartDate(dto.getStartDate());
        inquiry.setEndDate(dto.getEndDate());
        inquiry.setStatus(InquiryStatus.PENDING);

        return inquiryRepository.save(inquiry);
    }

    public List<ProjectInquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    public List<ProjectInquiry> getMyInquiries(Long clientId) {
        return inquiryRepository.findByClientId(clientId);
    }

    public ProjectInquiry getInquiryById(Long id) {

        return inquiryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Inquiry not found with id: " + id));
    }

    public ProjectInquiry assignContractor(Long inquiryId, Long contractorId) {

        ProjectInquiry inquiry = getInquiryById(inquiryId);

        SystemUser contractor = userRepository.findById(contractorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contractor not found"));

        inquiry.setContractor(contractor);
        inquiry.setStatus(InquiryStatus.ASSIGNED);

        return inquiryRepository.save(inquiry);
    }

    public ProjectInquiry updateStatus(Long inquiryId,
                                       InquiryStatus status) {

        ProjectInquiry inquiry = getInquiryById(inquiryId);

        inquiry.setStatus(status);

        return inquiryRepository.save(inquiry);
    }

    public void deleteInquiry(Long inquiryId) {

        ProjectInquiry inquiry = getInquiryById(inquiryId);

        inquiryRepository.delete(inquiry);
    }
}