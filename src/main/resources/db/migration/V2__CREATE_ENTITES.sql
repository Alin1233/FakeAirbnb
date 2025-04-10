CREATE TABLE IF NOT EXISTS city (
                                    id    SERIAL PRIMARY KEY,
                                    name  VARCHAR(255) NOT NULL
    );
CREATE TABLE IF NOT EXISTS booking (
                                       id             VARCHAR(255) PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    arrival_date   DATE NOT NULL,
    checkout_date  DATE NOT NULL,
    price          DECIMAL(10,2) NOT NULL,
    city_id        INTEGER NOT NULL,
    CONSTRAINT fk_city
    FOREIGN KEY (city_id) REFERENCES city(id)
    );
