package ua.foxminded.domain.activity.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityMetaModel {

    private String action;

    @JsonProperty("company_id")
    private String companyId;

    @JsonProperty("correlation_id")
    private String correlationId;

    @JsonProperty("entity_id")
    private String entityId;

    private String entity;

    private String id;

    @JsonProperty("is_bulk_edit")
    private boolean isBulkEdit;

    private String timestamp;

    private String type;

    @JsonProperty("user_id")
    private String userId;

    private String version;

    @JsonProperty("webhook_id")
    private String webhookId;

    @JsonProperty("webhook_owner_id")
    private String webhookOwnerId;

    private int attempt;

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

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
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

    public String getWebhookId() {
        return webhookId;
    }

    public void setWebhookId(final String webhookId) {
        this.webhookId = webhookId;
    }

    public String getWebhookOwnerId() {
        return webhookOwnerId;
    }

    public void setWebhookOwnerId(final String webhookOwnerId) {
        this.webhookOwnerId = webhookOwnerId;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(final int attempt) {
        this.attempt = attempt;
    }

    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }
}
