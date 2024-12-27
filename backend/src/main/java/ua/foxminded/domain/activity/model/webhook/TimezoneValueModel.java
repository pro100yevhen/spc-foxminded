package ua.foxminded.domain.activity.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimezoneValueModel {

    @JsonProperty("timezone_id")
    private String timezoneId;

    private String value;

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(final String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
