-- V2__AddUser.sql
-- Insert initial data
INSERT INTO User (email, username, password, role)
VALUES ('arpan@gmail.com', 'arpan','$2a$12$xwPoHyG6N0XTxDKMgW3/EubcrSagTtLin0SrB20Lh4e3ymmINIT3W', 'ROLE_NORMAL'),
       ('roshani@gmail.com', 'tapan', '$2a$12$hqMsMM3Wx3go/JHe.rbT4OpJWyxKIHgjxRnTs.GQPRedo9SELLcUS', 'ROLE_ADMIN');
