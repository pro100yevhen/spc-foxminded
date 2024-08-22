-- Table for Deal entity
CREATE TABLE deals
(
    id                      BIGINT PRIMARY KEY,
    person_name             VARCHAR(255),
    stage_id                BIGINT,
    owner_id                BIGINT,
    updated_deal_stage_date TIMESTAMP WITHOUT TIME ZONE,
    created_date            TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_date            TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES owners (id)
);