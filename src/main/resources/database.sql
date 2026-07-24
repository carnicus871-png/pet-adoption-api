CREATE
DATABASE IF NOT EXISTS pet_adoption;

USE
pet_adoption;

CREATE TABLE IF NOT EXISTS pets
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    species VARCHAR
(
    255
),
    breed VARCHAR
(
    255
),
    age INT,
    available BOOLEAN
    );

INSERT INTO pets (name, species, breed, age, available)
VALUES ('Chunk', 'Cat', 'Ragdoll', 2, TRUE);