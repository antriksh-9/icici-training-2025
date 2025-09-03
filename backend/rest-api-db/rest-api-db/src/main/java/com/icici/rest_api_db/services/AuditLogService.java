package com.icici.rest_api_db.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icici.rest_api_db.entities.AuditLog;
import com.icici.rest_api_db.repos.AuditLogRepository;

import java.time.Instant;
import java.util.Map;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void log(String action, String entity, String entityId, String performedBy, Map<String, Object> details) {
        AuditLog log = AuditLog.builder()
                .action(action)
                .entity(entity)
                .entityId(entityId)
                .performedBy(performedBy)
                .timestamp(Instant.now())
                .details(details)
                .build();
        auditLogRepository.save(log);
    }
}
