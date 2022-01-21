insert into mp_league (l_difficulty, l_name_of_league)
values (1, 'League NR.1'),
       (2, 'League NR.2'),
       (3, 'League NR.3');

insert into MP_CLIMBER (c_first_name, c_last_name, c_age, LEAGUE_L_ID)
values ('Tamara', 'Melcher', 18, 1),
       ('Jakob', 'Unterberger', 21, 2),
       ('Julia', 'Koenig', 17, null),
       ('Alina', 'Schuster', 17, 2),
       ('Anna', 'Wiesinger', 17, 1),
       ('Elena', 'Heckmann', 17, 3),
       ('Jan', 'Melcher', 16, 3);