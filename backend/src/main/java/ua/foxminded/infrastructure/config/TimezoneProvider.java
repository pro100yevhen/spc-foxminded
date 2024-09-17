package ua.foxminded.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class TimezoneProvider {

    // This reads the timezone from application.properties or defaults to system's timezone
    @Value("${app.timezone:#{null}}")
    private String timezone;

    public ZoneId getZoneId() {
        // Fallback to system's default timezone if no value is provided in application.properties
        return timezone != null && !timezone.isBlank() ? ZoneId.of(timezone) : ZoneId.systemDefault();
    }
}