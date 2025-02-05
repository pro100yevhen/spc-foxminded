ALTER TABLE manager_points_configuration
    ADD COLUMN owner_id BIGINT NOT NULL,
ADD CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES owners(id);