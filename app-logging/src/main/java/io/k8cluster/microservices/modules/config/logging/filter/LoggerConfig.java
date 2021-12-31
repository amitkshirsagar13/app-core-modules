package io.k8cluster.microservices.modules.config.logging.filter;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoggerConfig {

    private String companyId;
    private String orgId;
    private String uid;
    private String sessionId;
    private String correlationId;
    private String forwardIp;
    private String service;
    private String originator;
    private String method;
    private String path;
    private String status;
    private String duration;
}
