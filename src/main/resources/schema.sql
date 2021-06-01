DROP TABLE IF EXISTS user_account_storage.user_account;

CREATE TABLE user_account_storage.user_account
(
    id            BIGSERIAL PRIMARY KEY,
    username      VARCHAR(16) NOT NULL,
    password      VARCHAR(16) NOT NULL,
    first_name    VARCHAR(16),
    last_name     VARCHAR(16),
    role          VARCHAR(5) NOT NULL,
    status        VARCHAR(8) NOT NULL,
    creation_date DATE
);