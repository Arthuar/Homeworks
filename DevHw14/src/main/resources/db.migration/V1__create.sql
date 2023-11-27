CREATE TABLE IF NOT EXISTS client
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    CONSTRAINT check_client_name
    CHECK (LENGTH(name) >= 2)
    );

CREATE TABLE IF NOT EXISTS planet
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    CONSTRAINT check_planet_name
    CHECK (LENGTH(name) >= 1)
    );

CREATE TABLE IF NOT EXISTS ticket
(
    id IDENTITY PRIMARY KEY,
    created_at TIMESTAMP,
    client_id BIGINT NOT NULL,
    from_planet_id BIGINT NOT NULL,
    to_planet_id BIGINT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES planet(id) ON DELETE CASCADE,
    FOREIGN KEY (to_planet_id) REFERENCES planet(id) ON DELETE CASCADE
    );