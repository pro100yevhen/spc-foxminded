package ua.foxminded.domain.deal.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class DealDetailsModel {

    private Long id;
    private String title;
    private Long value;
    private String status;

    @JsonProperty("add_time")
    private LocalDateTime addTime;

    @JsonProperty("update_time")
    private LocalDateTime updateTime;

    @JsonProperty("stage_change_time")
    private LocalDateTime stageChangeTime;

    @JsonProperty("person_id")
    private Long personId;

    @JsonProperty("owner_id")
    private Long ownerId;

    @JsonProperty("pipeline_id")
    private Long pipelineId;

    @JsonProperty("stage_id")
    private Long stageId;

    @JsonProperty("label_ids")
    private List<Long> labelIds;

    @JsonProperty("custom_fields")
    private Map<String, CustomFieldModel> customFields;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(final Long value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(final LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(final LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getStageChangeTime() {
        return stageChangeTime;
    }

    public void setStageChangeTime(final LocalDateTime stageChangeTime) {
        this.stageChangeTime = stageChangeTime;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(final Long pipelineId) {
        this.pipelineId = pipelineId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(final Long stageId) {
        this.stageId = stageId;
    }

    public List<Long> getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(final List<Long> labelIds) {
        this.labelIds = labelIds;
    }

    public Map<String, CustomFieldModel> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(
            final Map<String, CustomFieldModel> customFields) {
        this.customFields = customFields;
    }
}
