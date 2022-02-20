CREATE TABLE IF NOT EXISTS users (

    id int NOT NULL PRIMARY KEY,
    type varchar(64),
    identity_id varchar(64),
    personal_information_id varchar(64),
    created_on timestamp,
    update_on timestamp

);