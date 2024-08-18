-- Table for Manager Points entity
CREATE TABLE manager_points
(
    id               BIGINT PRIMARY KEY IDENTITY(1,1),
    manager_id       BIGINT NOT NULL,
    date             DATE NOT NULL,
    points           INT NOT NULL,
    bonuses          INT NOT NULL,
    activities_count INT NOT NULL,
    test_period_count INT NOT NULL,
    created_date     DATETIME2(0) NOT NULL,
    updated_date     DATETIME2(0) NOT NULL
);