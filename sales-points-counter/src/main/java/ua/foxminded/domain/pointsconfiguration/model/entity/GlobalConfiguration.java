package ua.foxminded.domain.pointsconfiguration.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import ua.foxminded.common.model.entity.BaseEntity;

import java.util.Objects;

@Entity
@Table(name = "global_configuration")
public class GlobalConfiguration extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "allowed_user_ids")
    private String allowedUserIds;
    @Column(name = "deal_stages_ids")
    private String dealStagesIds;
    @Column(name = "points_normative_challenge")
    private int pointsNormativeChallenge;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final GlobalConfiguration that = (GlobalConfiguration) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }

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

    public int getPointsNormativeChallenge() {
        return pointsNormativeChallenge;
    }

    public void setPointsNormativeChallenge(final int pointsNormativeChallenge) {
        this.pointsNormativeChallenge = pointsNormativeChallenge;
    }
}

