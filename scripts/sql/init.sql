CREATE TABLE plant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    scientific_name VARCHAR(255) NOT NULL
);

INSERT INTO plant (name, scientific_name) VALUES ('Monstera', 'Monstera deliciosa');
INSERT INTO plant (name, scientific_name) VALUES ('Rubber Tree', 'Ficus elastica');