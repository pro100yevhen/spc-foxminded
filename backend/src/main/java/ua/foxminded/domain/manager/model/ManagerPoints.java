package ua.foxminded.domain.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import ua.foxminded.common.model.entity.BaseEntity;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "manager_points")
public class ManagerPoints extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long managerId;
    private LocalDate date;
    private int points;
    private int activitiesCount;
    private int testPeriodCount;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(final Long managerId) {
        this.managerId = managerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(final int points) {
        this.points = points;
    }

    public int getActivitiesCount() {
        return activitiesCount;
    }

    public void setActivitiesCount(final int activitiesCount) {
        this.activitiesCount = activitiesCount;
    }

    public int getTestPeriodCount() {
        return testPeriodCount;
    }

    public void setTestPeriodCount(final int testPeriodCount) {
        this.testPeriodCount = testPeriodCount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ManagerPoints that = (ManagerPoints) o;
        return points == that.points && activitiesCount == that.activitiesCount && testPeriodCount == that.testPeriodCount && Objects.equals(
                id, that.id) && Objects.equals(managerId, that.managerId) && Objects.equals(date,
                that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }
}
