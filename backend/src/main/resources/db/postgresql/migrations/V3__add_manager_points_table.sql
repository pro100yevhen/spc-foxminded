-- Table for Manager Points entity
CREATE TABLE manager_points
(
    id                BIGSERIAL PRIMARY KEY,
    manager_id        BIGINT NOT NULL,
    date              DATE   NOT NULL,
    points            INT    NOT NULL,
    bonuses           INT    NOT NULL,
    activities_count  INT    NOT NULL,
    test_period_count INT    NOT NULL,
    normative         INT    NOT NULL,
    created_date      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_date      TIMESTAMP WITHOUT TIME ZONE NOT NULL
);