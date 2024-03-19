-- V2__AddUser.sql
-- Insert initial data
INSERT INTO User (email, username, password, role)
VALUES ('arpan@gmail.com', 'arpan','$2a$12$yW5PL.Ilrtsb/HAPHcDUouAFABgtsdRBjdXZt7Bz8OWqvcoJON73q', 'ROLE_NORMAL'),
       ('roshani@gmail.com', 'tapan', '$2a$12$o8lEnn9VMWzpNnnFbM1gfe/WA83GFw8RIFbjeq6AjW2zcDZOudELW', 'ROLE_ADMIN');
