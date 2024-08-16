package ua.foxminded.domain.manager.model.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ManagerPointsDto {

    private Long id;
    private Long managerId;
    private String managerName;
    private LocalDate date;
    private int points;
    private int bonuses;
    private int activitiesCount;
    private int testPeriodCount;
    private String formattedDate;

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(final String formattedDate) {
        this.formattedDate = formattedDate;
    }

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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(final String managerName) {
        this.managerName = managerName;
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

    public int getBonuses() {
        return bonuses;
    }

    public void setBonuses(final int bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ManagerPointsDto that = (ManagerPointsDto) o;
        return points == that.points && activitiesCount == that.activitiesCount && testPeriodCount == that.testPeriodCount && Objects.equals(
                id, that.id) && Objects.equals(managerId, that.managerId) && Objects.equals(managerName,
                that.managerName) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }
}
