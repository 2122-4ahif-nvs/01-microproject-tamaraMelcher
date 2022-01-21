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

insert into MP_CLIMBER (c_first_name, c_last_name, c_age, LEAGUE_L_ID, c_username, c_password, c_role)
values ('Tamara', 'Melcher', 18, 1,'tamaraMelcher', '1234', 'climber'),
       ('Jakob', 'Unterberger', 21, 2, 'jakobUnterberger', '4321', 'climber'),
       ('Julia', 'Koenig', 17, null, 'juliaKoenig', 'hello', 'trainer'),
       ('Alina', 'Schuster', 17, 2, 'alinaSchuster', 'hi', 'climber'),
       ('Anna', 'Wiesinger', 17, 1, 'annaWiesinger', 'juli', 'climber'),
       ('Elena', 'Heckmann', 17, 3, 'elenaHeckmann', 'einhorn', 'climber'),
       ('Jan', 'Melcher', 16, 3, 'janMelcher', 'pokemon', 'trainer');