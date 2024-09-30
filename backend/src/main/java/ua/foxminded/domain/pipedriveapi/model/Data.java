package ua.foxminded.domain.pipedriveapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {

    private Long id;

    @JsonProperty("company_id")
    private Long companyId;

    @JsonProperty("user_id")
    private Long userId;

    private boolean done;
    private String type;

    @JsonProperty("reference_type")
    private String referenceType;

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("due_date")
    private String dueDate;

    @JsonProperty("due_time")
    private String dueTime;

    @JsonProperty("busy_flag")
    private boolean busyFlag;

    @JsonProperty("add_time")
    private String addTime;

    @JsonProperty("marked_as_done_time")
    private String markedAsDoneTime;

    private String subject;
    private String note;

    @JsonProperty("person_id")
    private Long personId;

    @JsonProperty("deal_id")
    private Long dealId;

    @JsonProperty("active_flag")
    private boolean activeFlag;

    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("update_user_id")
    private Long updateUserId;

    @JsonProperty("private")
    private boolean isPrivate;

    private List<Participant> participants;

    @JsonProperty("person_name")
    private String personName;

    @JsonProperty("deal_title")
    private String dealTitle;

    @JsonProperty("owner_name")
    private String ownerName;

    @JsonProperty("person_dropbox_bcc")
    private String personDropboxBcc;

    @JsonProperty("deal_dropbox_bcc")
    private String dealDropboxBcc;

    @JsonProperty("assigned_to_user_id")
    private Long assignedToUserId;

    @JsonProperty("type_name")
    private String typeName;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(final Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(final String referenceType) {
        this.referenceType = referenceType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(final String referenceId) {
        this.referenceId = referenceId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(final String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(final String dueTime) {
        this.dueTime = dueTime;
    }

    public boolean isBusyFlag() {
        return busyFlag;
    }

    public void setBusyFlag(final boolean busyFlag) {
        this.busyFlag = busyFlag;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(final String addTime) {
        this.addTime = addTime;
    }

    public String getMarkedAsDoneTime() {
        return markedAsDoneTime;
    }

    public void setMarkedAsDoneTime(final String markedAsDoneTime) {
        this.markedAsDoneTime = markedAsDoneTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(final Long dealId) {
        this.dealId = dealId;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(final boolean activeFlag) {
        this.activeFlag = activeFlag;
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

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(final boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(final List<Participant> participants) {
        this.participants = participants;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(final String personName) {
        this.personName = personName;
    }

    public String getDealTitle() {
        return dealTitle;
    }

    public void setDealTitle(final String dealTitle) {
        this.dealTitle = dealTitle;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(final String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPersonDropboxBcc() {
        return personDropboxBcc;
    }

    public void setPersonDropboxBcc(final String personDropboxBcc) {
        this.personDropboxBcc = personDropboxBcc;
    }

    public String getDealDropboxBcc() {
        return dealDropboxBcc;
    }

    public void setDealDropboxBcc(final String dealDropboxBcc) {
        this.dealDropboxBcc = dealDropboxBcc;
    }

    public Long getAssignedToUserId() {
        return assignedToUserId;
    }

    public void setAssignedToUserId(final Long assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(final String typeName) {
        this.typeName = typeName;
    }
}
