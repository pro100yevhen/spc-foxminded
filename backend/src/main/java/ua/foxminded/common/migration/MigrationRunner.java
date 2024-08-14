package ua.foxminded.common.migration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.flywaydb.core.api.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MigrationRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MigrationRunner.class);

    private final String dataSourceUrl;
    private final String dataSourceUsername;
    private final String dataSourcePassword;

    private final boolean migrationEnabled;

    public MigrationRunner(
            @Value("${spring.datasource.url}") final String dataSourceUrl,
            @Value("${spring.datasource.username}") final String dataSourceUsername,
            @Value("${spring.datasource.password}") final String dataSourcePassword,
            @Value("${migration.enabled}") final boolean migrationEnabled
    ) {
        this.dataSourceUrl = dataSourceUrl;
        this.dataSourceUsername = dataSourceUsername;
        this.dataSourcePassword = dataSourcePassword;
        this.migrationEnabled = migrationEnabled;
    }

    @Override
    public void run(final String... args) {
        if (migrationEnabled) {
            final Configuration configuration = buildFlywayConfiguration();

            final Flyway flyway = new Flyway(configuration);
            flyway.migrate();

            LOG.info("Database migrations have been successfully applied.");
        } else {
            LOG.info("Database migrations are disabled.");
        }
    }

    private Configuration buildFlywayConfiguration() {
        final ClassicConfiguration config = new ClassicConfiguration();

        config.setDataSource(dataSourceUrl, dataSourceUsername, dataSourcePassword);
//        config.setLocations(new Location("classpath:db/h2/migrations"));
        config.setValidateOnMigrate(false);
        return config;
    }
}