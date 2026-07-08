package com.example.bridge.service;

import com.example.bridge.entity.DailyWorkLog;
import com.example.bridge.exception.ResourceNotFoundException;
import com.example.bridge.repository.DailyWorkLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkLogService {

    private final DailyWorkLogRepository workLogRepository;

    public WorkLogService(DailyWorkLogRepository workLogRepository) {
        this.workLogRepository = workLogRepository;
    }

    public DailyWorkLog createLog(DailyWorkLog log) {
        return workLogRepository.save(log);
    }

    public List<DailyWorkLog> getAllLogs() {
        return workLogRepository.findAll();
    }

    public DailyWorkLog getLogById(Long id) {
        return workLogRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Log not found with id: " + id));
    }

    public DailyWorkLog updateLog(Long id, DailyWorkLog updatedLog) {

        DailyWorkLog existingLog = getLogById(id);

        existingLog.setProject(updatedLog.getProject());
        existingLog.setSupervisor(updatedLog.getSupervisor());
        existingLog.setLogDate(updatedLog.getLogDate());
        existingLog.setLaborCount(updatedLog.getLaborCount());
        existingLog.setWeatherCondition(updatedLog.getWeatherCondition());
        existingLog.setNotes(updatedLog.getNotes());
        existingLog.setProgressIncrement(updatedLog.getProgressIncrement());

        return workLogRepository.save(existingLog);
    }

    public void deleteLog(Long id) {
        DailyWorkLog log = getLogById(id);
        workLogRepository.delete(log);
    }

    public List<DailyWorkLog> getLogsByProjectId(Long projectId) {
        return workLogRepository.findByProjectId(projectId);
    }

    public List<DailyWorkLog> getLogsBySupervisorId(Long supervisorId) {
        return workLogRepository.findBySupervisorId(supervisorId);
    }
}