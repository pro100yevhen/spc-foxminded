package ua.foxminded.domain.activity.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ActivityDataModel {

    @JsonProperty("active_flag")
    private boolean activeFlag;

    @JsonProperty("add_time")
    private String addTime;

    @JsonProperty("busy_flag")
    private boolean busyFlag;

    @JsonProperty("custom_fields")
    private Map<String, Object> customFields;

    @JsonProperty("deal_id")
    private Long dealId;

    private boolean done;

    @JsonProperty("due_date")
    private String dueDate;

    @JsonProperty("due_time")
    private TimezoneValueModel dueTime;

    @JsonProperty("duration")
    private TimezoneValueModel duration;

    private Long id;

    private String type;

    @JsonProperty("lead_id")
    private Long leadId;

    private String location;

    @JsonProperty("org_id")
    private Long orgId;

    @JsonProperty("owner_id")
    private Long ownerId;

    @JsonProperty("person_id")
    private Long personId;

    @JsonProperty("public_description")
    private String publicDescription;

    private String subject;

    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("update_user_id")
    private Long updateUserId;

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(final boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(final String addTime) {
        this.addTime = addTime;
    }

    public boolean isBusyFlag() {
        return busyFlag;
    }

    public void setBusyFlag(final boolean busyFlag) {
        this.busyFlag = busyFlag;
    }

    public Map<String, Object> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(final Map<String, Object> customFields) {
        this.customFields = customFields;
    }

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(final Long dealId) {
        this.dealId = dealId;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(final String dueDate) {
        this.dueDate = dueDate;
    }

    public TimezoneValueModel getDueTime() {
        return dueTime;
    }

    public void setDueTime(final TimezoneValueModel dueTime) {
        this.dueTime = dueTime;
    }

    public TimezoneValueModel getDuration() {
        return duration;
    }

    public void setDuration(final TimezoneValueModel duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(final Long leadId) {
        this.leadId = leadId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(final Long orgId) {
        this.orgId = orgId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(final String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(final Long updateUserId) {
        this.updateUserId = updateUserId;
    }
}
