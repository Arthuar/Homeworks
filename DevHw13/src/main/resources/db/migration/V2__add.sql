INSERT INTO client (name)
VALUES
    ( 'John' ),
    ( 'Doo' ),
    ( 'Petter' ),
    ( 'Maks' ),
    ( 'Marry' ),
    ( 'Arthur' ),
    ( 'Eugene' ),
    ( 'Clara' ),
    ( 'Sara' ),
    ( 'Scott' );

INSERT INTO planet (name)
VALUES
    ( 'Earth' ),
    ( 'Mars' ),
    ( 'AWS B' ),
    ( 'Spite 667 C' ),
    ( 'Flay 85512 b' );

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES
    ( '2023-10-18 11:00:00', 1 , 1, 2),
    ( '2023-01-19 12:00:00', 1 , 2, 1),
    ( '2023-01-20 13:00:00', 3 , 3, 5),
    ( '2023-01-21 14:00:00', 7 , 2, 3),
    ( '2023-01-22 15:00:00', 2 , 1, 2),
    ( '2023-01-23 16:00:00', 4 , 3, 4),
    ( '2023-01-24 17:00:00', 5 , 4, 2),
    ( '2023-01-25 18:00:00', 6 , 4, 2),
    ( '2023-01-26 19:00:00', 8 , 1, 5),
    ( '2023-01-27 20:30:00', 9 , 3, 2);