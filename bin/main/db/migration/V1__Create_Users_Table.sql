-- V1__Create_Users_Table.sql

CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    roles VARCHAR(255) NOT NULL
);
