 /* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'flipo', '$2a$12$dA70.eW4pS9xXcJsws6MsO2w6fq4/pOEfPyplrI/izLxQo1KsIL2C');
INSERT INTO users (id_user, username, password) VALUES (default, 'felipe', '$2a$12$fw8qjZwWYhvR.xzLUN5LuejC03NqCFuJQYwnstpBWki.Yi4L64MkW');

INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2); 
INSERT INTO roles_users (role_id, user_id) VALUES (3, 3); 

