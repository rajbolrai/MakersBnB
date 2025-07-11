DROP TABLE IF EXISTS spaces;
DROP SEQUENCE IF EXISTS spaces_id_seq;
CREATE SEQUENCE IF NOT EXISTS spaces_id_seq;
CREATE TABLE spaces(
    id SERIAL PRIMARY KEY,
    name varchar(100),
    weather TEXT,
    price FLOAT,
    available_date DATE
);

INSERT INTO spaces (name, weather, price, available_date) VALUES('Spain', 'sunny', 10.0, '2025-07-12');
INSERT INTO spaces (name, weather, price, available_date) VALUES('Berlin', 'cold', 5, '2025-07-20');
INSERT INTO spaces (name, weather, price, available_date) VALUES('Norway', 'cold', 2, '2025-08-05');
INSERT INTO spaces (name, weather, price, available_date) VALUES('Mongolia', 'warm', 2, '2025-08-05');
INSERT INTO spaces (name, weather, price, available_date) VALUES('Nepal', 'hot', 2, '2025-08-05');
