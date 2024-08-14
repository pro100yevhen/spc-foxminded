package ua.foxminded.domain.deal.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import ua.foxminded.common.model.entity.BaseEntity;
import ua.foxminded.common.model.entity.Owner;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "deals")
public class Deal extends BaseEntity {

    @Id
    private Long id;

    @Column(name = "deal_id")
    private Long dealId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "stage_id")
    private Long stageId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "updated_deal_stage_date")
    private LocalDateTime updatedDealStageDate;

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

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(final Long stageId) {
        this.stageId = stageId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    public LocalDateTime getUpdatedDealStageDate() {
        return updatedDealStageDate;
    }

    public void setUpdatedDealStageDate(final LocalDateTime updatedDealStageDate) {
        this.updatedDealStageDate = updatedDealStageDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Deal deal = (Deal) o;
        return Objects.equals(id, deal.id) && Objects.equals(dealId,
                deal.dealId) && Objects.equals(personName, deal.personName) && Objects.equals(stageId,
                deal.stageId) && Objects.equals(owner, deal.owner) && Objects.equals(
                updatedDealStageDate, deal.updatedDealStageDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", dealId=" + dealId +
                ", personName='" + personName + '\'' +
                ", stageId='" + stageId + '\'' +
                ", owner=" + owner +
                ", updatedDealStageDate=" + updatedDealStageDate +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
