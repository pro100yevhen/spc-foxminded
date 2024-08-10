package ua.foxminded.domain.activity.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParticipantEventModel {

    @JsonProperty("primary_flag")
    private boolean primaryFlag;

    @JsonProperty("person_id")
    private Long personId;

    public boolean isPrimaryFlag() {
        return primaryFlag;
    }

    public void setPrimaryFlag(final boolean primaryFlag) {
        this.primaryFlag = primaryFlag;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }
}
