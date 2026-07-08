package com.example.bridge.controller;

import com.example.bridge.entity.DailyWorkLog;
import com.example.bridge.service.WorkLogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "*")
public class WorkLogController {

    private final WorkLogService workLogService;

    public WorkLogController(WorkLogService workLogService) {
        this.workLogService = workLogService;
    }

    @PostMapping
    public ResponseEntity<DailyWorkLog> createLog(
            @Valid @RequestBody DailyWorkLog workLog) {

        return ResponseEntity.ok(workLogService.createLog(workLog));
    }

    @GetMapping
    public ResponseEntity<List<DailyWorkLog>> getAllLogs() {

        return ResponseEntity.ok(workLogService.getAllLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailyWorkLog> getLogById(
            @PathVariable Long id) {

        return ResponseEntity.ok(workLogService.getLogById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailyWorkLog> updateLog(
            @PathVariable Long id,
            @Valid @RequestBody DailyWorkLog workLog) {

        return ResponseEntity.ok(workLogService.updateLog(id, workLog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLog(
            @PathVariable Long id) {

        workLogService.deleteLog(id);
        return ResponseEntity.ok("Work log deleted successfully");
    }
}