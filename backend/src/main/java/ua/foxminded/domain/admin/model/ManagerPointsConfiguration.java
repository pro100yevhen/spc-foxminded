package ua.foxminded.domain.admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "manager_points_configuration")
public class ManagerPointsConfiguration {

    @Id
    private Long id;
    @Column(name = "allowed_user_ids")
    private String allowedUserIds;
    @Column(name = "deal_stages_ids")
    private String dealStagesIds;
    @Column(name = "manager_points_normative")
    private int managerPointsNormative;
    @Column(name = "manager_points_call_coefficient")
    private int managerPointsCallCoefficient;
    @Column(name = "manager_points_test_period_coefficient")
    private int managerPointsTestPeriodCoefficient;
    @Column(name = "manager_points_bonus_under_3")
    private int managerPointsBonusUnder3;
    @Column(name = "manager_points_bonus_equal_3")
    private int managerPointsBonusEqual3;
    @Column(name = "manager_points_bonus_over_4")
    private int managerPointsBonusOver4;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getAllowedUserIds() {
        return allowedUserIds;
    }

    public void setAllowedUserIds(final String allowedUserIds) {
        this.allowedUserIds = allowedUserIds;
    }

    public String getDealStagesIds() {
        return dealStagesIds;
    }

    public void setDealStagesIds(final String dealStagesIds) {
        this.dealStagesIds = dealStagesIds;
    }

    public int getManagerPointsNormative() {
        return managerPointsNormative;
    }

    public void setManagerPointsNormative(final int managerPointsNormative) {
        this.managerPointsNormative = managerPointsNormative;
    }

    public int getManagerPointsCallCoefficient() {
        return managerPointsCallCoefficient;
    }

    public void setManagerPointsCallCoefficient(final int managerPointsCallCoefficient) {
        this.managerPointsCallCoefficient = managerPointsCallCoefficient;
    }

    public int getManagerPointsTestPeriodCoefficient() {
        return managerPointsTestPeriodCoefficient;
    }

    public void setManagerPointsTestPeriodCoefficient(final int managerPointsTestPeriodCoefficient) {
        this.managerPointsTestPeriodCoefficient = managerPointsTestPeriodCoefficient;
    }

    public int getManagerPointsBonusUnder3() {
        return managerPointsBonusUnder3;
    }

    public void setManagerPointsBonusUnder3(final int managerPointsBonusUnder3) {
        this.managerPointsBonusUnder3 = managerPointsBonusUnder3;
    }

    public int getManagerPointsBonusEqual3() {
        return managerPointsBonusEqual3;
    }

    public void setManagerPointsBonusEqual3(final int managerPointsBonusEqual3) {
        this.managerPointsBonusEqual3 = managerPointsBonusEqual3;
    }

    public int getManagerPointsBonusOver4() {
        return managerPointsBonusOver4;
    }

    public void setManagerPointsBonusOver4(final int managerPointsBonusOver4) {
        this.managerPointsBonusOver4 = managerPointsBonusOver4;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ManagerPointsConfiguration managerPointsConfiguration = (ManagerPointsConfiguration) o;
        return managerPointsNormative == managerPointsConfiguration.managerPointsNormative && managerPointsCallCoefficient == managerPointsConfiguration.managerPointsCallCoefficient && managerPointsTestPeriodCoefficient == managerPointsConfiguration.managerPointsTestPeriodCoefficient && managerPointsBonusUnder3 == managerPointsConfiguration.managerPointsBonusUnder3 && managerPointsBonusEqual3 == managerPointsConfiguration.managerPointsBonusEqual3 && managerPointsBonusOver4 == managerPointsConfiguration.managerPointsBonusOver4 && Objects.equals(
                id, managerPointsConfiguration.id) && Objects.equals(allowedUserIds,
                managerPointsConfiguration.allowedUserIds) && Objects.equals(dealStagesIds, managerPointsConfiguration.dealStagesIds);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "id=" + id +
                ", allowedUserIds='" + allowedUserIds + '\'' +
                ", dealStagesIds='" + dealStagesIds + '\'' +
                ", managerPointsNormative=" + managerPointsNormative +
                ", managerPointsCallCoefficient=" + managerPointsCallCoefficient +
                ", managerPointsTestPeriodCoefficient=" + managerPointsTestPeriodCoefficient +
                ", managerPointsBonusUnder3=" + managerPointsBonusUnder3 +
                ", managerPointsBonusEqual3=" + managerPointsBonusEqual3 +
                ", managerPointsBonusOver4=" + managerPointsBonusOver4 +
                '}';
    }
}