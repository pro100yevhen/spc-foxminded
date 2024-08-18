-- Table for Owner entity
CREATE TABLE owners
(
    id           BIGINT PRIMARY KEY,
    name         NVARCHAR(255) NOT NULL,
    created_date DATETIME2(0) NOT NULL,
    updated_date DATETIME2(0) NOT NULL
);

-- Table for Activity entity
CREATE TABLE activities
(
    id                    BIGINT PRIMARY KEY,
    deal_id               BIGINT,
    person_name           NVARCHAR(255),
    busy_flag             BIT NOT NULL,
    type                  NVARCHAR(255),
    owner_id              BIGINT,
    updated_activity_date DATETIME2(0),
    marked_as_done_time   DATETIME2(0),
    created_date DATETIME2(0) NOT NULL,
    updated_date DATETIME2(0) NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES owners (id)
);