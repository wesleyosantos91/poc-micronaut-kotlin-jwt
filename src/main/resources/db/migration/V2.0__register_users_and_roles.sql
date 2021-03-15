-- Insert Users
INSERT INTO users (code, name, email, password) values (1, 'Administrador', 'admin@github.com', '$2a$10$x6SC19AOjdOPkEYEMx7s.eetvgkAFa46.VSkkXHUgZ7O5ekt3GWxe');
INSERT INTO users (code, name, email, password) values (2, 'Wesley Oliveira', 'wesleyosantos91@gmail.com', '$2a$10$x6SC19AOjdOPkEYEMx7s.eetvgkAFa46.VSkkXHUgZ7O5ekt3GWxe');

-- Insert Roles
INSERT INTO roles (code, description) values (1, 'ROLE_CREATE_PERSON');
INSERT INTO roles (code, description) values (2, 'ROLE_READ_PERSON');
INSERT INTO roles (code, description) values (3, 'ROLE_UPDADE_PERSON');
INSERT INTO roles (code, description) values (4, 'ROLE_REMOVE_PERSON');

-- Admin
INSERT INTO roles_users (user_code, role_code) values (1, 1);
INSERT INTO roles_users (user_code, role_code) values (1, 2);
INSERT INTO roles_users (user_code, role_code) values (1, 3);
INSERT INTO roles_users (user_code, role_code) values (1, 4);

-- Wesley
INSERT INTO roles_users (user_code, role_code) values (2, 2);