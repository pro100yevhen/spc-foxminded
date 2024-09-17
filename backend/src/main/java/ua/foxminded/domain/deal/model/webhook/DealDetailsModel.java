package ua.foxminded.domain.deal.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DealDetailsModel {

    private Long id;

    @JsonProperty("formatted_value")
    private String formattedValue;

    private String status;

    @JsonProperty("weighted_value_currency")
    private String weightedValueCurrency;

    @JsonProperty("weighted_value")
    private Long weightedValue;

    @JsonProperty("pipeline_id")
    private Long pipelineId;

    @JsonProperty("stage_id")
    private Long stageId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("creator_user_id")
    private Long creatorUserId;

    @JsonProperty("activities_count")
    private Long activitiesCount;

    @JsonProperty("done_activities_count")
    private Long doneActivitiesCount;

    @JsonProperty("files_count")
    private Long filesCount;

    @JsonProperty("notes_count")
    private Long notesCount;

    @JsonProperty("followers_count")
    private Long followersCount;

    @JsonProperty("formatted_weighted_value")
    private String formattedWeightedValue;

    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("add_time")
    private String addTime;

    @JsonProperty("owner_name")
    private String ownerName;

    @JsonProperty("person_name")
    private String personName;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("last_activity_date")
    private String lastActivityDate;

    @JsonProperty("title")
    private String title;

    @JsonProperty("value")
    private Long value;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFormattedValue() {
        return formattedValue;
    }

    public void setFormattedValue(final String formattedValue) {
        this.formattedValue = formattedValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getWeightedValueCurrency() {
        return weightedValueCurrency;
    }

    public void setWeightedValueCurrency(final String weightedValueCurrency) {
        this.weightedValueCurrency = weightedValueCurrency;
    }

    public Long getWeightedValue() {
        return weightedValue;
    }

    public void setWeightedValue(final Long weightedValue) {
        this.weightedValue = weightedValue;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public Long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(final Long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public Long getActivitiesCount() {
        return activitiesCount;
    }

    public void setActivitiesCount(final Long activitiesCount) {
        this.activitiesCount = activitiesCount;
    }

    public Long getDoneActivitiesCount() {
        return doneActivitiesCount;
    }

    public void setDoneActivitiesCount(final Long doneActivitiesCount) {
        this.doneActivitiesCount = doneActivitiesCount;
    }

    public Long getFilesCount() {
        return filesCount;
    }

    public void setFilesCount(final Long filesCount) {
        this.filesCount = filesCount;
    }

    public Long getNotesCount() {
        return notesCount;
    }

    public void setNotesCount(final Long notesCount) {
        this.notesCount = notesCount;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(final Long followersCount) {
        this.followersCount = followersCount;
    }

    public String getFormattedWeightedValue() {
        return formattedWeightedValue;
    }

    public void setFormattedWeightedValue(final String formattedWeightedValue) {
        this.formattedWeightedValue = formattedWeightedValue;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(final String addTime) {
        this.addTime = addTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(final String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(final String personName) {
        this.personName = personName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(final String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final DealDetailsModel that = (DealDetailsModel) o;
        return Objects.equals(id, that.id) && Objects.equals(formattedValue,
                that.formattedValue) && Objects.equals(status, that.status) && Objects.equals(
                weightedValueCurrency, that.weightedValueCurrency) && Objects.equals(weightedValue,
                that.weightedValue) && Objects.equals(pipelineId, that.pipelineId) && Objects.equals(
                stageId, that.stageId) && Objects.equals(userId, that.userId) && Objects.equals(
                creatorUserId, that.creatorUserId) && Objects.equals(activitiesCount,
                that.activitiesCount) && Objects.equals(doneActivitiesCount,
                that.doneActivitiesCount) && Objects.equals(filesCount,
                that.filesCount) && Objects.equals(notesCount, that.notesCount) && Objects.equals(
                followersCount, that.followersCount) && Objects.equals(formattedWeightedValue,
                that.formattedWeightedValue) && Objects.equals(updateTime,
                that.updateTime) && Objects.equals(addTime, that.addTime) && Objects.equals(ownerName,
                that.ownerName) && Objects.equals(personName, that.personName) && Objects.equals(origin,
                that.origin) && Objects.equals(lastActivityDate,
                that.lastActivityDate) && Objects.equals(title, that.title) && Objects.equals(value,
                that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }

    @Override
    public String toString() {
        return "DealDetailsModel{" +
                "id=" + id +
                ", formattedValue='" + formattedValue + '\'' +
                ", status='" + status + '\'' +
                ", weightedValueCurrency='" + weightedValueCurrency + '\'' +
                ", weightedValue=" + weightedValue +
                ", pipelineId=" + pipelineId +
                ", stageId=" + stageId +
                ", userId=" + userId +
                ", creatorUserId=" + creatorUserId +
                ", activitiesCount=" + activitiesCount +
                ", doneActivitiesCount=" + doneActivitiesCount +
                ", filesCount=" + filesCount +
                ", notesCount=" + notesCount +
                ", followersCount=" + followersCount +
                ", formattedWeightedValue='" + formattedWeightedValue + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", addTime='" + addTime + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", personName='" + personName + '\'' +
                ", origin='" + origin + '\'' +
                ", lastActivityDate='" + lastActivityDate + '\'' +
                ", title='" + title + '\'' +
                ", value=" + value +
                '}';
    }
}
