DROP TABLE role,user_roles, user_table CASCADE;

INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

SELECT * FROM user_table;