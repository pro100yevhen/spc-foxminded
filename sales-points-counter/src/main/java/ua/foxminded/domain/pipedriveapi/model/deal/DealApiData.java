package ua.foxminded.domain.pipedriveapi.model.deal;

import com.fasterxml.jackson.annotation.JsonProperty;
import ua.foxminded.domain.pipedriveapi.model.common.Person;
import ua.foxminded.domain.pipedriveapi.model.common.User;

public class DealApiData {

    private int id;

    @JsonProperty("creator_user_id")
    private User creatorUser;

    @JsonProperty("user_id")
    private User user;

    @JsonProperty("person_id")
    private Person person;

    private String title;
    private int value;
    private String currency;

    @JsonProperty("add_time")
    private String addTime;

    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("last_activity_date")
    private String lastActivityDate;

    @JsonProperty("pipeline_id")
    private int pipelineId;

    @JsonProperty("stage_id")
    private int stageId;

    private String status;

    @JsonProperty("last_activity")
    private LastActivity lastActivity;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public User getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(final User creatorUser) {
        this.creatorUser = creatorUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(final String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(final String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public int getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(final int pipelineId) {
        this.pipelineId = pipelineId;
    }

    public int getStageId() {
        return stageId;
    }

    public void setStageId(final int stageId) {
        this.stageId = stageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public LastActivity getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(final LastActivity lastActivity) {
        this.lastActivity = lastActivity;
    }
}
