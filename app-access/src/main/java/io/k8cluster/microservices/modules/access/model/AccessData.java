package io.k8cluster.microservices.modules.access.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.k8cluster.microservices.modules.exception.AppException;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class AccessData {
    private String userId;
    private Set<ROLE> roleList;
    private String organizationId;
    private String companyId;
    private boolean samAuth;

    public AccessData(String userId, Set<ROLE> roleList, String organizationId, String companyId, boolean samAuth) {
        this.userId = userId;
        this.roleList = roleList;
        this.organizationId = organizationId;
        this.companyId = companyId;
        this.samAuth = samAuth;
    }

    public AccessData() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<ROLE> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<ROLE> roleList) {
        this.roleList = roleList;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public boolean isSamAuth() {
        return samAuth;
    }

    public void setSamAuth(boolean samAuth) {
        this.samAuth = samAuth;
    }

    public static AccessData fromString(String accessDataString) {
        AccessData accessData = null;
        if (accessDataString != null) {
            try {
                accessData = new ObjectMapper().readValue(accessDataString, AccessData.class);
            } catch (IOException e) {
                throw new AppException(AppException.ERROR_CODE.ACCESS_DENIED, "Failed to decode access data");
            }
        }
        return accessData;
    }

    public String toString() {
        String accessDataString;
        try {
            accessDataString = new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new AppException(AppException.ERROR_CODE.ACCESS_DENIED, "Failed to encode access data");
        }
        return accessDataString;
    }
}
