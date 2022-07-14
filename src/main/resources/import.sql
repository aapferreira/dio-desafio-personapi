INSERT INTO person (first_name, last_name, cpf, birth_date) VALUES ('aaaaa', 'aaaaaa', '1111111', '2022-09-17');
INSERT INTO person (first_name, last_name, cpf, birth_date) VALUES ('bbbbb', 'bbbbbb', '2222222', '2022-09-17');

INSERT INTO phone (phone_type, number) VALUES ('MOBILE', '1111111');
INSERT INTO phone (phone_type, number) VALUES ('MOBILE', '2222222');
INSERT INTO phone (phone_type, number) VALUES ('MOBILE', '3333333');
INSERT INTO phone (phone_type, number) VALUES ('MOBILE', '4444444');

INSERT INTO person_phones (person_id, phones_id) VALUES (1, 1);
INSERT INTO person_phones (person_id, phones_id) VALUES (1, 2);
INSERT INTO person_phones (person_id, phones_id) VALUES (2, 3);
INSERT INTO person_phones (person_id, phones_id) VALUES (2, 4);

