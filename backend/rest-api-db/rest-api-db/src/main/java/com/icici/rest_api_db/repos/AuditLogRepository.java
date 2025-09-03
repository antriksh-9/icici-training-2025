package com.icici.rest_api_db.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.icici.rest_api_db.entities.AuditLog;

public interface AuditLogRepository extends MongoRepository<AuditLog, String> {
    // Custom query methods if needed
}
