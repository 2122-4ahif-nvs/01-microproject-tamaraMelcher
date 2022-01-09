insert into mp_league (l_difficulty, l_name_of_league)
values (1, 'League NR.3'),
       (2, 'League NR.2'),
       (3, 'League NR.1');

insert into MP_CLIMBER (c_first_name, c_last_name, c_age, LEAGUE_L_ID)
values ('Tamara', 'Melcher', 18, 3),
       ('Jakob', 'Unterberger', 21, 1),
       ('Julia', 'Koenig', 17, 1),
       ('Jan', 'Melcher', 16, 2);