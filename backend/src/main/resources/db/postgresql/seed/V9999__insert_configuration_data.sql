-- Insert initial data into the table
INSERT INTO manager_points_configuration (id,
                        allowed_user_ids,
                        deal_stages_ids,
                        manager_points_normative,
                        manager_points_call_coefficient,
                        manager_points_test_period_coefficient,
                        manager_points_bonus_under_3,
                        manager_points_bonus_equal_3,
                        manager_points_bonus_over_4)
VALUES (1,
        '13196919,13053732',
        '12,22,28,34,40,46,58,64,70,76,82,88,94,100,106,232,277,350,357,364,371,378,393',
        50,
        2,
        8,
        0,
        5,
        20);