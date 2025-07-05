package dev.agiro.demo.claimservice.infrastructure.web.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BatchAssociationRequest {

    @NotEmpty(message = "Claim IDs list cannot be empty.")
    private List<Long> claimIds;

    @NotNull(message = "Entity ID cannot be null.")
    private Long entityId;

    @NotEmpty(message = "Entity type cannot be empty.")
    private String entityType;

    // Getters and Setters
    public List<Long> getClaimIds() {
        return claimIds;
    }

    public void setClaimIds(List<Long> claimIds) {
        this.claimIds = claimIds;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
}
