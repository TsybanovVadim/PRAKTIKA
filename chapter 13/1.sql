CREATE TABLE cities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    foundation_year INTEGER NOT NULL,
    area DECIMAL(10, 2) NOT NULL
);

CREATE TABLE inhabitants (
    id SERIAL PRIMARY KEY,
    city_id INTEGER REFERENCES cities(id),
    type_id INTEGER REFERENCES inhabitant_types(id),
    population INTEGER NOT NULL
);

CREATE TABLE inhabitant_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    language VARCHAR(255) NOT NULL
);

CREATE TABLE city_inhabitants (
    city_id INTEGER REFERENCES cities(id),
    inhabitant_id INTEGER REFERENCES inhabitants(id),
    PRIMARY KEY (city_id, inhabitant_id)
);