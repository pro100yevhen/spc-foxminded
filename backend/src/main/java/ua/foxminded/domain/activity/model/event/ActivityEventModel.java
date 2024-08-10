package ua.foxminded.domain.activity.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityEventModel {

    @JsonProperty("last_notification_time")
    private Long lastNotificationTime;

    @JsonProperty("location_street_number")
    private String locationStreetNumber;

    @JsonProperty("local_sorting_due_date")
    private String localSortingDueDate;

    @JsonProperty("type_name")
    private String typeName;

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("location_route")
    private String locationRoute;

    @JsonProperty("public_description")
    private String publicDescription;

    @JsonProperty("notification_language_id")
    private String notificationLanguageId;

    private String subject;

    private String type;

    @JsonProperty("activity_note")
    private String activityNote;

    @JsonProperty("project_id")
    private String projectId;

    @JsonProperty("deal_title")
    private String dealTitle;

    @JsonProperty("original_start_time")
    private Long originalStartTime;

    private Long id;

    @JsonProperty("deal_id")
    private Long dealId;

    @JsonProperty("busy_flag")
    private boolean busyFlag;

    @JsonProperty("person_id")
    private Long personId;

    @JsonProperty("owner_name")
    private String ownerName;

    private String attendees;

    @JsonProperty("person_name")
    private String personName;

    @JsonProperty("project_title")
    private String projectTitle;

    @JsonProperty("rec_rule_extension")
    private String recRuleExtension;

    private String priority;

    private boolean done;

    @JsonProperty("created_by_user_id")
    private Long createdByUserId;

    @JsonProperty("location_sublocality")
    private String locationSublocality;

    @JsonProperty("rec_rule")
    private String recRule;

    @JsonProperty("location_admin_area_level_2")
    private String locationAdminAreaLevel2;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("location_admin_area_level_1")
    private String locationAdminAreaLevel1;

    @JsonProperty("org_id")
    private String orgId;

    @JsonProperty("conference_meeting_client")
    private String conferenceMeetingClient;

    private String note;

    @JsonProperty("due_time")
    private String dueTime;

    @JsonProperty("rec_master_activity_id")
    private String recMasterActivityId;

    @JsonProperty("is_private")
    private boolean isPrivate;

    @JsonProperty("location_country")
    private String locationCountry;

    @JsonProperty("active_flag")
    private boolean activeFlag;

    private String duration;

    @JsonProperty("location_postal_code")
    private String locationPostalCode;

    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("update_user_id")
    private Long updateUserId;

    @JsonProperty("lead_title")
    private String leadTitle;

    @JsonProperty("source_timezone")
    private String sourceTimezone;

    @JsonProperty("person_dropbox_bcc")
    private String personDropboxBcc;

    @JsonProperty("conference_meeting_id")
    private String conferenceMeetingId;

    @JsonProperty("org_name")
    private String orgName;

    @JsonProperty("location_locality")
    private String locationLocality;

    @JsonProperty("assigned_to_user_id")
    private Long assignedToUserId;

    @JsonProperty("lead_id")
    private String leadId;

    @JsonProperty("is_recurring")
    private Boolean isRecurring;

    private List<ParticipantEventModel> participants;

    @JsonProperty("location_subpremise")
    private String locationSubpremise;

    @JsonProperty("company_id")
    private Long companyId;

    @JsonProperty("due_date")
    private String dueDate;

    private String lead;

    @JsonProperty("reference_type")
    private String referenceType;

    @JsonProperty("last_notification_user_id")
    private Long lastNotificationUserId;

    @JsonProperty("calendar_sync_include_context")
    private String calendarSyncIncludeContext;

    @JsonProperty("marked_as_done_time")
    private String markedAsDoneTime;

    @JsonProperty("location_formatted_address")
    private String locationFormattedAddress;

    private String series;

    @JsonProperty("conference_meeting_url")
    private String conferenceMeetingUrl;

    private String location;

    @JsonProperty("deal_dropbox_bcc")
    private String dealDropboxBcc;

    @JsonProperty("add_time")
    private String addTime;

    private UserEventModel user;

    @JsonProperty("service_reference")
    private List<Object> serviceReference;

    public String getActivityNote() {
        return activityNote;
    }

    public void setActivityNote(final String activityNote) {
        this.activityNote = activityNote;
    }

    public Long getLastNotificationTime() {
        return lastNotificationTime;
    }

    public void setLastNotificationTime(final Long lastNotificationTime) {
        this.lastNotificationTime = lastNotificationTime;
    }

    public String getLocationStreetNumber() {
        return locationStreetNumber;
    }

    public void setLocationStreetNumber(final String locationStreetNumber) {
        this.locationStreetNumber = locationStreetNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(final String typeName) {
        this.typeName = typeName;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(final String referenceId) {
        this.referenceId = referenceId;
    }

    public String getLocationRoute() {
        return locationRoute;
    }

    public void setLocationRoute(final String locationRoute) {
        this.locationRoute = locationRoute;
    }

    public String getLocalSortingDueDate() {
        return localSortingDueDate;
    }

    public void setLocalSortingDueDate(final String localSortingDueDate) {
        this.localSortingDueDate = localSortingDueDate;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(final String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public String getNotificationLanguageId() {
        return notificationLanguageId;
    }

    public void setNotificationLanguageId(final String notificationLanguageId) {
        this.notificationLanguageId = notificationLanguageId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(final String projectId) {
        this.projectId = projectId;
    }

    public String getDealTitle() {
        return dealTitle;
    }

    public void setDealTitle(final String dealTitle) {
        this.dealTitle = dealTitle;
    }

    public Long getOriginalStartTime() {
        return originalStartTime;
    }

    public void setOriginalStartTime(final Long originalStartTime) {
        this.originalStartTime = originalStartTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(final Long dealId) {
        this.dealId = dealId;
    }

    public boolean isBusyFlag() {
        return busyFlag;
    }

    public void setBusyFlag(final boolean busyFlag) {
        this.busyFlag = busyFlag;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(final String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(final String attendees) {
        this.attendees = attendees;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(final String personName) {
        this.personName = personName;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(final String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getRecRuleExtension() {
        return recRuleExtension;
    }

    public void setRecRuleExtension(final String recRuleExtension) {
        this.recRuleExtension = recRuleExtension;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(final String priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(final Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getLocationSublocality() {
        return locationSublocality;
    }

    public void setLocationSublocality(final String locationSublocality) {
        this.locationSublocality = locationSublocality;
    }

    public String getRecRule() {
        return recRule;
    }

    public void setRecRule(final String recRule) {
        this.recRule = recRule;
    }

    public String getLocationAdminAreaLevel2() {
        return locationAdminAreaLevel2;
    }

    public void setLocationAdminAreaLevel2(final String locationAdminAreaLevel2) {
        this.locationAdminAreaLevel2 = locationAdminAreaLevel2;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public String getLocationAdminAreaLevel1() {
        return locationAdminAreaLevel1;
    }

    public void setLocationAdminAreaLevel1(final String locationAdminAreaLevel1) {
        this.locationAdminAreaLevel1 = locationAdminAreaLevel1;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(final String orgId) {
        this.orgId = orgId;
    }

    public String getConferenceMeetingClient() {
        return conferenceMeetingClient;
    }

    public void setConferenceMeetingClient(final String conferenceMeetingClient) {
        this.conferenceMeetingClient = conferenceMeetingClient;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(final String dueTime) {
        this.dueTime = dueTime;
    }

    public String getRecMasterActivityId() {
        return recMasterActivityId;
    }

    public void setRecMasterActivityId(final String recMasterActivityId) {
        this.recMasterActivityId = recMasterActivityId;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(final boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(final String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(final boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(final String duration) {
        this.duration = duration;
    }

    public String getLocationPostalCode() {
        return locationPostalCode;
    }

    public void setLocationPostalCode(final String locationPostalCode) {
        this.locationPostalCode = locationPostalCode;
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

    public String getLeadTitle() {
        return leadTitle;
    }

    public void setLeadTitle(final String leadTitle) {
        this.leadTitle = leadTitle;
    }

    public String getSourceTimezone() {
        return sourceTimezone;
    }

    public void setSourceTimezone(final String sourceTimezone) {
        this.sourceTimezone = sourceTimezone;
    }

    public String getPersonDropboxBcc() {
        return personDropboxBcc;
    }

    public void setPersonDropboxBcc(final String personDropboxBcc) {
        this.personDropboxBcc = personDropboxBcc;
    }

    public String getConferenceMeetingId() {
        return conferenceMeetingId;
    }

    public void setConferenceMeetingId(final String conferenceMeetingId) {
        this.conferenceMeetingId = conferenceMeetingId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(final String orgName) {
        this.orgName = orgName;
    }

    public String getLocationLocality() {
        return locationLocality;
    }

    public void setLocationLocality(final String locationLocality) {
        this.locationLocality = locationLocality;
    }

    public Long getAssignedToUserId() {
        return assignedToUserId;
    }

    public void setAssignedToUserId(final Long assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(final String leadId) {
        this.leadId = leadId;
    }

    public Boolean getRecurring() {
        return isRecurring;
    }

    public void setRecurring(final Boolean recurring) {
        isRecurring = recurring;
    }

    public List<ParticipantEventModel> getParticipants() {
        return participants;
    }

    public void setParticipants(final List<ParticipantEventModel> participants) {
        this.participants = participants;
    }

    public String getLocationSubpremise() {
        return locationSubpremise;
    }

    public void setLocationSubpremise(final String locationSubpremise) {
        this.locationSubpremise = locationSubpremise;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(final Long companyId) {
        this.companyId = companyId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(final String dueDate) {
        this.dueDate = dueDate;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(final String lead) {
        this.lead = lead;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(final String referenceType) {
        this.referenceType = referenceType;
    }

    public Long getLastNotificationUserId() {
        return lastNotificationUserId;
    }

    public void setLastNotificationUserId(final Long lastNotificationUserId) {
        this.lastNotificationUserId = lastNotificationUserId;
    }

    public String getCalendarSyncIncludeContext() {
        return calendarSyncIncludeContext;
    }

    public void setCalendarSyncIncludeContext(final String calendarSyncIncludeContext) {
        this.calendarSyncIncludeContext = calendarSyncIncludeContext;
    }

    public String getMarkedAsDoneTime() {
        return markedAsDoneTime;
    }

    public void setMarkedAsDoneTime(final String markedAsDoneTime) {
        this.markedAsDoneTime = markedAsDoneTime;
    }

    public String getLocationFormattedAddress() {
        return locationFormattedAddress;
    }

    public void setLocationFormattedAddress(final String locationFormattedAddress) {
        this.locationFormattedAddress = locationFormattedAddress;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(final String series) {
        this.series = series;
    }

    public String getConferenceMeetingUrl() {
        return conferenceMeetingUrl;
    }

    public void setConferenceMeetingUrl(final String conferenceMeetingUrl) {
        this.conferenceMeetingUrl = conferenceMeetingUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getDealDropboxBcc() {
        return dealDropboxBcc;
    }

    public void setDealDropboxBcc(final String dealDropboxBcc) {
        this.dealDropboxBcc = dealDropboxBcc;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(final String addTime) {
        this.addTime = addTime;
    }

    public UserEventModel getUser() {
        return user;
    }

    public void setUser(final UserEventModel user) {
        this.user = user;
    }

    public List<Object> getServiceReference() {
        return serviceReference;
    }

    public void setServiceReference(final List<Object> serviceReference) {
        this.serviceReference = serviceReference;
    }
}
