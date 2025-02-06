package ua.foxminded.domain.deal.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DealMetaModel {

    private String action;
    private String companyId;
    private String correlationId;

    @JsonProperty("entity_id")
    private String entityId;

    private String entity;

    @JsonProperty("is_bulk_edit")
    private boolean isBulkEdit;

    private String timestamp;
    private String type;

    @JsonProperty("user_id")
    private String userId;

    private String version;
    private String host;

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(final String companyId) {
        this.companyId = companyId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(final String correlationId) {
        this.correlationId = correlationId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(final String entityId) {
        this.entityId = entityId;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(final String entity) {
        this.entity = entity;
    }

    public boolean isBulkEdit() {
        return isBulkEdit;
    }

    public void setBulkEdit(final boolean bulkEdit) {
        isBulkEdit = bulkEdit;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }
}
