-- Add columns for auditing
ALTER TABLE manager_points_configuration
    ADD COLUMN created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
ADD COLUMN updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL;

ALTER TABLE manager_points_configuration
    ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;