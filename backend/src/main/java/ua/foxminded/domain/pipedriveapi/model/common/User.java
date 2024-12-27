package ua.foxminded.domain.pipedriveapi.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private Long id;
    private String name;
    private String email;

    @JsonProperty("active_flag")
    private boolean activeFlag;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(final boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
