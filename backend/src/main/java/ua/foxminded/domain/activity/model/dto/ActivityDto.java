package ua.foxminded.domain.activity.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ua.foxminded.common.model.dto.OwnerDto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ActivityDto {

    private Long id;

    private Long dealId;

    private String personName;

    private boolean busy;

    private String type;

    private OwnerDto owner;

    private LocalDateTime updatedActivityDate;

    private LocalDateTime createdActivityDate;

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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(final String personName) {
        this.personName = personName;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(final boolean busy) {
        this.busy = busy;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public void setOwner(final OwnerDto owner) {
        this.owner = owner;
    }

    public LocalDateTime getUpdatedActivityDate() {
        return updatedActivityDate;
    }

    public void setUpdatedActivityDate(final LocalDateTime updatedActivityDate) {
        this.updatedActivityDate = updatedActivityDate;
    }

    public LocalDateTime getCreatedActivityDate() {
        return createdActivityDate;
    }

    public void setCreatedActivityDate(final LocalDateTime createdActivityDate) {
        this.createdActivityDate = createdActivityDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ActivityDto activity = (ActivityDto) o;
        return busy == activity.busy && Objects.equals(id, activity.id) && Objects.equals(dealId,
                activity.dealId) && Objects.equals(personName, activity.personName) && Objects.equals(
                type, activity.type) && Objects.equals(owner, activity.owner) && Objects.equals(
                updatedActivityDate, activity.updatedActivityDate) && Objects.equals(createdActivityDate,
                activity.createdActivityDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
