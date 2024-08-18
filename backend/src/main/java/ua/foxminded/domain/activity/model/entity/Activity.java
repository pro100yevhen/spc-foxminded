package ua.foxminded.domain.activity.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import ua.foxminded.common.model.entity.BaseEntity;
import ua.foxminded.common.model.entity.Owner;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "activities")
public class Activity extends BaseEntity {

    @Id
    private Long id;

    @Column(name = "deal_id")
    private Long dealId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "busy_flag")
    private boolean busyFlag;

    @Column(name = "type")
    private String typeName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "updated_activity_date")
    private LocalDateTime updatedActivityDate;

    @Column(name = "marked_as_done_time")
    private LocalDateTime markedAsDoneTime;

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

    public boolean isBusyFlag() {
        return busyFlag;
    }

    public void setBusyFlag(final boolean busy) {
        this.busyFlag = busy;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(final String type) {
        this.typeName = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    public LocalDateTime getUpdatedActivityDate() {
        return updatedActivityDate;
    }

    public void setUpdatedActivityDate(final LocalDateTime updatedActivityDate) {
        this.updatedActivityDate = updatedActivityDate;
    }

    public LocalDateTime getMarkedAsDoneTime() {
        return markedAsDoneTime;
    }

    public void setMarkedAsDoneTime(final LocalDateTime createdActivityDate) {
        this.markedAsDoneTime = createdActivityDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Activity activity = (Activity) o;
        return busyFlag == activity.busyFlag && Objects.equals(id, activity.id) && Objects.equals(dealId,
                activity.dealId) && Objects.equals(personName, activity.personName) && Objects.equals(
                typeName, activity.typeName) && Objects.equals(owner, activity.owner) && Objects.equals(
                updatedActivityDate, activity.updatedActivityDate) && Objects.equals(markedAsDoneTime,
                activity.markedAsDoneTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", dealId=" + dealId +
                ", personName='" + personName + '\'' +
                ", busyFlag=" + busyFlag +
                ", typeName='" + typeName + '\'' +
                ", owner=" + owner +
                ", updatedActivityDate=" + updatedActivityDate +
                ", markedAsDoneTime=" + markedAsDoneTime +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
