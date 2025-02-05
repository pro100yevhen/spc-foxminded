package ua.foxminded.domain.pointsconfiguration.model.dto;

import ua.foxminded.domain.pointsconfiguration.model.entity.GlobalConfiguration;

import java.util.Objects;

public class GlobalConfigurationDto {

    private Long id;
    private String allowedUserIds;
    private String dealStagesIds;
    private int pointsNormativeChallenge;

    public int getPointsNormativeChallenge() {
        return pointsNormativeChallenge;
    }

    public void setPointsNormativeChallenge(final int pointsNormativeChallenge) {
        this.pointsNormativeChallenge = pointsNormativeChallenge;
    }

    public String getDealStagesIds() {
        return dealStagesIds;
    }

    public void setDealStagesIds(final String dealStagesIds) {
        this.dealStagesIds = dealStagesIds;
    }

    public String getAllowedUserIds() {
        return allowedUserIds;
    }

    public void setAllowedUserIds(final String allowedUserIds) {
        this.allowedUserIds = allowedUserIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final GlobalConfiguration that = (GlobalConfiguration) o;
        return Objects.equals(id, that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }
}
