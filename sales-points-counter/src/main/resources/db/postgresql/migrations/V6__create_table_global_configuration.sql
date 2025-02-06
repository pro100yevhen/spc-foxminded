CREATE TABLE global_configuration
(
    id                         SERIAL PRIMARY KEY,
    allowed_user_ids           TEXT                                NOT NULL,
    deal_stages_ids            TEXT                                NOT NULL,
    points_normative_challenge INTEGER                             NOT NULL,
    created_date               TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_date               TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);