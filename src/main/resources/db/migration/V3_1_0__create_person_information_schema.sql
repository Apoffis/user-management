CREATE TABLE IF NOT EXISTS person_information (

    id int NOT NULL PRIMARY KEY,
    address varchar(128),
    birth_date timestamp,
    first_name varchar(64),
    last_name varchar(64),
    gender varchar(64),
    created_on timestamp,
    update_on timestamp

);