package ua.foxminded.domain.pointsconfiguration.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import ua.foxminded.common.model.entity.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "manager_points_configuration")
public class ManagerPointsConfiguration extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "owner_id", nullable = false)
    private Long ownerId;
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

    public int getManagerPointsNormative() {
        return managerPointsNormative;
    }

    public void setManagerPointsNormative(final int managerPointsNormative) {
        this.managerPointsNormative = managerPointsNormative;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final Long owner) {
        this.ownerId = owner;
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

        final ManagerPointsConfiguration that = (ManagerPointsConfiguration) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "id=" + id +
                ", managerPointsNormative=" + managerPointsNormative +
                ", managerPointsCallCoefficient=" + managerPointsCallCoefficient +
                ", managerPointsTestPeriodCoefficient=" + managerPointsTestPeriodCoefficient +
                ", managerPointsBonusUnder3=" + managerPointsBonusUnder3 +
                ", managerPointsBonusEqual3=" + managerPointsBonusEqual3 +
                ", managerPointsBonusOver4=" + managerPointsBonusOver4 +
                '}';
    }
}