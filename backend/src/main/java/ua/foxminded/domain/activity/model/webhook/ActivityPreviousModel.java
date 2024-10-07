package ua.foxminded.domain.activity.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityPreviousModel {

    @JsonProperty("update_time")
    private String updateTime;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(final String updateTime) {
        this.updateTime = updateTime;
    }
}
