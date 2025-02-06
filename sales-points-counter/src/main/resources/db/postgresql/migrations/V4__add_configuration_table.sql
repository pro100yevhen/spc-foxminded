-- Create the table
CREATE TABLE manager_points_configuration
(
    id                                     INTEGER PRIMARY KEY,
    allowed_user_ids                       TEXT    NOT NULL,
    deal_stages_ids                        TEXT    NOT NULL,
    manager_points_normative               INTEGER NOT NULL,
    manager_points_call_coefficient        INTEGER NOT NULL,
    manager_points_test_period_coefficient INTEGER NOT NULL,
    manager_points_bonus_under_3            INTEGER NOT NULL,
    manager_points_bonus_equal_3            INTEGER NOT NULL,
    manager_points_bonus_over_4             INTEGER NOT NULL
);