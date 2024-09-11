package ua.foxminded.domain.deal.model.dto;

import ua.foxminded.common.model.dto.OwnerDto;
import ua.foxminded.common.model.entity.Owner;

import java.time.LocalDateTime;

public class DealDto {

    private Long id;

    private String personName;

    private Long stageId;

    private OwnerDto owner;

    private LocalDateTime updatedDealStageDate;

    protected LocalDateTime createdDate;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(final String personName) {
        this.personName = personName;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(final Long stageId) {
        this.stageId = stageId;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public void setOwner(final OwnerDto owner) {
        this.owner = owner;
    }

    public LocalDateTime getUpdatedDealStageDate() {
        return updatedDealStageDate;
    }

    public void setUpdatedDealStageDate(final LocalDateTime updatedDealStageDate) {
        this.updatedDealStageDate = updatedDealStageDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
