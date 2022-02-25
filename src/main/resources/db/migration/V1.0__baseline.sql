CREATE TABLE IF NOT EXISTS users (
    id                      SERIAL          NOT NULL,
    type                    VARCHAR(64)     NOT NULL,
    identity_id             SERIAL          NOT NULL,
    personal_information_id SERIAL          NOT NULL,
    created_on              TIMESTAMP       NOT NULL,
    update_on               TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS user_identity (
    id                      SERIAL          NOT NULL,
    email                   VARCHAR(64)     NOT NULL,
    phone                   VARCHAR(64)     NOT NULL,
    created_on              TIMESTAMP       NOT NULL,
    update_on               TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS person_information (
    id                      SERIAL          NOT NULL,
    address                 VARCHAR(128)    NOT NULL,
    birth_date              TIMESTAMP       NOT NULL,
    first_name              VARCHAR(64)     NOT NULL,
    last_name               VARCHAR(64)     NOT NULL,
    gender                  VARCHAR(64)     NOT NULL,
    created_on              TIMESTAMP       NOT NULL,
    update_on               TIMESTAMP,
    PRIMARY KEY(id)
);

ALTER TABLE users
    ADD CONSTRAINT FK_users_identity_id
            FOREIGN KEY (identity_id)
            REFERENCES user_identity(id);

ALTER TABLE users
    ADD CONSTRAINT FK_users_personal_information_id
            FOREIGN KEY (personal_information_id)
            REFERENCES person_information(id);

ALTER TABLE user_identity ADD CONSTRAINT UK_user_identity_email UNIQUE (email);
ALTER TABLE user_identity ADD CONSTRAINT UK_user_identity_phone UNIQUE (phone);
