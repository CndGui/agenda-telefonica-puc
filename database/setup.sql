CREATE DATABASE phone_book;

\c phone_book

CREATE TABLE contacts (
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    phone   VARCHAR(20)  NOT NULL,
    email   VARCHAR(100)
);
