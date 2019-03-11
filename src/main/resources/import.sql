INSERT INTO users (id, name, password) VALUES (1, 'test', 'pwd123');
INSERT INTO users (id, name, password) VALUES (2, 'scouter', '12345');

INSERT INTO tasks (id, description, completed, last_update, user_name) VALUES (1, 'finish landing page', true,'2019-01-28 22:58:51', 'test');
INSERT INTO tasks (id, description, completed, last_update, user_name) VALUES (2, 'buy food', false, '2019-03-12 22:01:51','scouter');