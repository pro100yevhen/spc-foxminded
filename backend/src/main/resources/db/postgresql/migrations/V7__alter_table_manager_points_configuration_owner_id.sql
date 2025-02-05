ALTER TABLE manager_points_configuration
    ADD COLUMN owner_id BIGINT,
ADD CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES owners(id);