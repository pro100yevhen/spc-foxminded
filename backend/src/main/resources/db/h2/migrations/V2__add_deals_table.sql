-- Table for Deal entity
CREATE TABLE deals
(
    id                     BIGINT PRIMARY KEY,
    deal_id                BIGINT,
    person_name            VARCHAR(255),
    stage_id               BIGINT,
    owner_id               BIGINT,
    updated_deal_stage_date TIMESTAMP,
    created_date           TIMESTAMP NOT NULL,
    updated_date           TIMESTAMP NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES owners (id)
);