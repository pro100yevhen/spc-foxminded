CREATE TABLE manager_points
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT,
    manager_id       BIGINT NOT NULL,
    date             DATE NOT NULL,
    points           INT NOT NULL,
    activities_count INT NOT NULL,
    test_period_count INT NOT NULL,
    created_date     TIMESTAMP NOT NULL,
    updated_date     TIMESTAMP NOT NULL
);