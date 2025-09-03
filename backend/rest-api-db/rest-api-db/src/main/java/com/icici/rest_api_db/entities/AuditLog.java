package com.icici.rest_api_db.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Document(collection = "audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {
    @Id
    private String id;
    private String action; // e.g., CREATE, UPDATE, DELETE
    private String entity; // e.g., "Customer"
    private String entityId;
    private String performedBy;
    private Instant timestamp;
    private Map<String, Object> details; // Additional info
}
