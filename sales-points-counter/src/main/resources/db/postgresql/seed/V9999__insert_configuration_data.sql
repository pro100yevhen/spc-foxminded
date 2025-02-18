-- Insert initial data into the table with current timestamps
INSERT INTO global_configuration (allowed_user_ids, deal_stages_ids, points_normative_challenge, created_date,
                                  updated_date)
VALUES ('1,2',
        '12,22,28,34,40,46,58,64,70,76,82,88,94,100,106,232,277,350,357,364,371,378,393',
        55,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP);

INSERT INTO owners (id, name, created_date, updated_date)
VALUES (1, 'owner1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO manager_points_configuration (owner_id,
                                          manager_points_normative,
                                          manager_points_call_coefficient,
                                          manager_points_test_period_coefficient,
                                          manager_points_bonus_under_3,
                                          manager_points_bonus_equal_3,
                                          manager_points_bonus_over_4,
                                          created_date,
                                          updated_date)
VALUES (1,
        55,
        2,
        8,
        0,
        5,
        20,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP);