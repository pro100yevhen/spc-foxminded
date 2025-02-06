package ua.foxminded.domain.pointsconfiguration.model.dto;

import java.util.Objects;

public class ManagerPointsConfigurationDto {
    private Long id;
    private int managerPointsNormative;
    private int managerPointsCallCoefficient;
    private int managerPointsTestPeriodCoefficient;
    private int managerPointsBonusUnder3;
    private int managerPointsBonusEqual3;
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

        final ManagerPointsConfigurationDto that = (ManagerPointsConfigurationDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }
}
