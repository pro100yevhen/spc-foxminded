-- Table for Owner entity
CREATE TABLE owners
(
    id           BIGINT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    created_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

-- Table for Activity entity
CREATE TABLE activities
(
    id                    BIGINT PRIMARY KEY,
    deal_id               BIGINT,
    person_id             BIGINT,
    person_name           VARCHAR(255),
    busy_flag             BOOLEAN NOT NULL,
    type                  VARCHAR(255),
    owner_id              BIGINT,
    updated_activity_date TIMESTAMP WITHOUT TIME ZONE,
    marked_as_done_time   TIMESTAMP WITHOUT TIME ZONE,
    created_date          TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_date          TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES owners (id)
);