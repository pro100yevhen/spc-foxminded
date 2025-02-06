package ua.foxminded.domain.pipedriveapi.model.activity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Participant {

    @JsonProperty("person_id")
    private Long personId;

    @JsonProperty("primary_flag")
    private boolean primaryFlag;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personId) {
        this.personId = personId;
    }

    public boolean isPrimaryFlag() {
        return primaryFlag;
    }

    public void setPrimaryFlag(final boolean primaryFlag) {
        this.primaryFlag = primaryFlag;
    }
}
