package ua.foxminded.domain.pointsconfiguration.model.dto;

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


}
