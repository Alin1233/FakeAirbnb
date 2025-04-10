ALTER TABLE booking
    ADD COLUMN user_id VARCHAR(255);
ALTER TABLE booking
    ADD CONSTRAINT fk_booking_user
        FOREIGN KEY (user_id) REFERENCES users (id);