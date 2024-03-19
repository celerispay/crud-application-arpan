-- V2__AddUser.sql
-- Insert initial data
INSERT INTO User (email, username, password, role)
VALUES ('arpan@gmail.com', 'arpan', '$10$N6oFBj8hlOXcwVJ/7fY7QesmCG0G6qrxlTKXyPzi9TxyPQqZTj76i', 'ROLE_NORMAL'),
       ('roshani@gmail.com', 'roshani', '<$10$.HiTjWAL2g7/VrXA4NBTbec8tx9i4qAJfrUOs5OOHTKSk9HrttSU.>', 'ROLE_ADMIN');
