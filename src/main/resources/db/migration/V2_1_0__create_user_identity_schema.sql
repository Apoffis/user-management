CREATE TABLE IF NOT EXISTS user_identity (

    id int NOT NULL PRIMARY KEY,
    email varchar(64),
    phone_number varchar(64),
    created_on timestamp,
    update_on timestamp

);