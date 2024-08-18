-- Table for Deal entity
CREATE TABLE deals
(
    id                     BIGINT PRIMARY KEY,
    person_name            NVARCHAR(255),
    stage_id               BIGINT,
    owner_id               BIGINT,
    updated_deal_stage_date DATETIME2(0),
    created_date           DATETIME2(0) NOT NULL,
    updated_date           DATETIME2(0) NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES owners (id)
);