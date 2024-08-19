package ua.foxminded.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagerPointsConfig {

    @Value("${manager.points.normative}")
    private int norm;

    @Value("${manager.points.call-coefficient}")
    private int callCoefficient;

    @Value("${manager.points.test-period-coefficient}")
    private int testPeriodCoefficient;

    @Value("${manager.points.bonus.under3}")
    private int bonusUnder3;

    @Value("${manager.points.bonus.equal3}")
    private int bonusEqual3;

    @Value("${manager.points.bonus.over4}")
    private int bonusOver4;

    public int getNorm() {
        return norm;
    }

    public int getCallCoefficient() {
        return callCoefficient;
    }

    public int getTestPeriodCoefficient() {
        return testPeriodCoefficient;
    }

    public int getBonusUnder3() {
        return bonusUnder3;
    }

    public int getBonusEqual3() {
        return bonusEqual3;
    }

    public int getBonusOver4() {
        return bonusOver4;
    }
}