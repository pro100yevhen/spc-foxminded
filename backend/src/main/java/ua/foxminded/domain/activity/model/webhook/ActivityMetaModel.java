package ua.foxminded.domain.activity.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ActivityMetaModel {
    private String action;

    @JsonProperty("change_source")
    private String changeSource;

    @JsonProperty("company_id")
    private Long companyId;

    private String host;

    private Long id;

    @JsonProperty("is_bulk_update")
    private boolean isBulkUpdate;

    @JsonProperty("matches_filters")
    private ActivityMatchesFiltersModel matchesFilters;

    private String object;

    @JsonProperty("permitted_user_ids")
    private List<Long> permittedUserIds;

    @JsonProperty("pipedrive_service_name")
    private String pipedriveServiceName;

    private Long timestamp;

    @JsonProperty("timestamp_micro")
    private Long timestampMicro;

    @JsonProperty("prepublish_timestamp")
    private Long prepublishTimestamp;

    @JsonProperty("trans_pending")
    private boolean transPending;

    @JsonProperty("user_id")
    private Long userId;

    private Long v;

    @JsonProperty("activity_notifications_language")
    private String activityNotificationsLanguage;

    @JsonProperty("send_activity_notifications")
    private boolean sendActivityNotifications;

    @JsonProperty("webhook_id")
    private String webhookId;

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public String getChangeSource() {
        return changeSource;
    }

    public void setChangeSource(final String changeSource) {
        this.changeSource = changeSource;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(final Long companyId) {
        this.companyId = companyId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean isBulkUpdate() {
        return isBulkUpdate;
    }

    public void setBulkUpdate(final boolean bulkUpdate) {
        isBulkUpdate = bulkUpdate;
    }

    public ActivityMatchesFiltersModel getMatchesFilters() {
        return matchesFilters;
    }

    public void setMatchesFilters(final ActivityMatchesFiltersModel matchesFilters) {
        this.matchesFilters = matchesFilters;
    }

    public String getObject() {
        return object;
    }

    public void setObject(final String object) {
        this.object = object;
    }

    public List<Long> getPermittedUserIds() {
        return permittedUserIds;
    }

    public void setPermittedUserIds(final List<Long> permittedUserIds) {
        this.permittedUserIds = permittedUserIds;
    }

    public String getPipedriveServiceName() {
        return pipedriveServiceName;
    }

    public void setPipedriveServiceName(final String pipedriveServiceName) {
        this.pipedriveServiceName = pipedriveServiceName;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTimestampMicro() {
        return timestampMicro;
    }

    public void setTimestampMicro(final Long timestampMicro) {
        this.timestampMicro = timestampMicro;
    }

    public Long getPrepublishTimestamp() {
        return prepublishTimestamp;
    }

    public void setPrepublishTimestamp(final Long prepublishTimestamp) {
        this.prepublishTimestamp = prepublishTimestamp;
    }

    public boolean isTransPending() {
        return transPending;
    }

    public void setTransPending(final boolean transPending) {
        this.transPending = transPending;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    public Long getV() {
        return v;
    }

    public void setV(final Long v) {
        this.v = v;
    }

    public String getActivityNotificationsLanguage() {
        return activityNotificationsLanguage;
    }

    public void setActivityNotificationsLanguage(final String activityNotificationsLanguage) {
        this.activityNotificationsLanguage = activityNotificationsLanguage;
    }

    public boolean isSendActivityNotifications() {
        return sendActivityNotifications;
    }

    public void setSendActivityNotifications(final boolean sendActivityNotifications) {
        this.sendActivityNotifications = sendActivityNotifications;
    }

    public String getWebhookId() {
        return webhookId;
    }

    public void setWebhookId(final String webhookId) {
        this.webhookId = webhookId;
    }

    @Override
    public String toString() {
        return "MetaEventModel{" +
                "action='" + action + '\'' +
                ", changeSource='" + changeSource + '\'' +
                ", companyId=" + companyId +
                ", host='" + host + '\'' +
                ", id=" + id +
                ", isBulkUpdate=" + isBulkUpdate +
                ", matchesFilters=" + matchesFilters +
                ", object='" + object + '\'' +
                ", permittedUserIds=" + permittedUserIds +
                ", pipedriveServiceName='" + pipedriveServiceName + '\'' +
                ", timestamp=" + timestamp +
                ", timestampMicro=" + timestampMicro +
                ", prepublishTimestamp=" + prepublishTimestamp +
                ", transPending=" + transPending +
                ", userId=" + userId +
                ", v=" + v +
                ", activityNotificationsLanguage='" + activityNotificationsLanguage + '\'' +
                ", sendActivityNotifications=" + sendActivityNotifications +
                ", webhookId='" + webhookId + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ActivityMetaModel that = (ActivityMetaModel) o;
        return isBulkUpdate == that.isBulkUpdate && transPending == that.transPending && sendActivityNotifications == that.sendActivityNotifications && Objects.equals(
                action, that.action) && Objects.equals(changeSource,
                that.changeSource) && Objects.equals(companyId, that.companyId) && Objects.equals(host,
                that.host) && Objects.equals(id, that.id) && Objects.equals(matchesFilters,
                that.matchesFilters) && Objects.equals(object, that.object) && Objects.equals(
                permittedUserIds, that.permittedUserIds) && Objects.equals(pipedriveServiceName,
                that.pipedriveServiceName) && Objects.equals(timestamp,
                that.timestamp) && Objects.equals(timestampMicro,
                that.timestampMicro) && Objects.equals(prepublishTimestamp,
                that.prepublishTimestamp) && Objects.equals(userId, that.userId) && Objects.equals(v,
                that.v) && Objects.equals(activityNotificationsLanguage,
                that.activityNotificationsLanguage) && Objects.equals(webhookId, that.webhookId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }
}
