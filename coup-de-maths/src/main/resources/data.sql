INSERT IGNORE INTO owner (id,name, email, password) VALUES
(1, 'student01','student01@gmail.com', '$2a$10$3RsWxqNVOuWw/CbgV7SEkO3ycnUAv7dJ1eTfuaucUDCY.3UIcYh0y'),
(2, 'professor01' ,'professor01@gmail.com', '$2a$10$wb/oW1/kTmxPGh0pxy5sY.enIXxHXO/LylZZ7VCMM8MSrupZeU0rW'),
(3, "Lova-admin" ,'lova@gmail.com', '$2a$10$wb/oW1/kTmxPGh0pxy5sY.enIXxHXO/LylZZ7VCMM8MSrupZeU0rW');

INSERT IGNORE INTO role (id,name) VALUES
(1,'STUDENT'),
(2,'PROFESSOR'),
(3,'ADMIN'),
(4,'STUDENT-TP'),
(5,'PROFESSOR-TP');

INSERT IGNORE INTO owner_roles (owner_id, role_id) VALUES
(1,1),
(2,2),
(3,3);

INSERT IGNORE INTO student (owner_id, credits) VALUES
(1, 10);

INSERT IGNORE INTO professor (owner_id, credits) VALUES
(2, 0);

INSERT IGNORE INTO question ( id, date, student_id, level, question, type) VALUES
(1, '2023-11-22 10:56:54.000000', 1, 'COLLEGE', 'Comment calculer la somme de deux fraction?', 'NORMAL'),
(2, '2023-11-22 10:56:54.000000', 1, 'COLLEGE', 'Comment diviser ...?', 'URGENT');

INSERT IGNORE INTO document_question (id, question_id, name, path) VALUES
(1, 1, 'Nom de la fiche n°1', 'path la fiche n°1'),
(2, 1, 'Nom de la fiche n°2', 'path la fiche n°2');

INSERT IGNORE INTO document_diplome (id, name, path, professor_id) VALUES
(1, 'professor01', 'Licence de math', 2);

INSERT IGNORE INTO transaction (id, date, type, amount, student_id, professor_id) VALUES
(1, '2023-11-22 10:56:54.000000', 'PURCHASE_CREDIT', 10, 1, null);

INSERT IGNORE INTO response (id, response, date, question_id, professor_id) VALUES
(1, 'response à la fiche n°1','2023-11-22 10:56:54.000000', 1, 2),
(2, 'response à la fiche n°2','2023-11-22 10:56:54.000000', 1, 2);

-- AJOUTER DOC DE REPONSE