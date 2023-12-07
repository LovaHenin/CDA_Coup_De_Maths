INSERT IGNORE INTO student (credits, id, email, name, password) VALUES
(1, 1, 'eric@gmail.com', 'eric', '1234'),
(5, 2, 'sarah@gmail.com', 'sarah', '1234');

INSERT IGNORE INTO question (date, id, student_id, level, question, type) VALUES
('2023-11-22 10:56:54.000000', 1, 1, 'COLLEGE', 'Comment calculer la somme de deux fraction?', 'NORMAL'),
('2023-11-22 10:56:54.000000', 2, 1, 'COLLEGE', 'Comment diviser ...?', 'URGENT');

INSERT IGNORE INTO document_question (id, question_id, name, path) VALUES
(1, 1, 'Nom de la fiche n°1', 'path la fiche n°1'),
(2, 1, 'Nom de la fiche n°2', 'path la fiche n°2');

INSERT IGNORE INTO professor (id, name, email, password, credits) VALUES
(1, 'Lova', 'lova@gmail.com', '123456', '10');

INSERT IGNORE INTO document_diplome (id, name, path, professor_id) VALUES
(1, 'Lova', 'Licence de math', 1);

INSERT IGNORE INTO transaction (id, date, type, amount, student_id, professor_id) VALUES
(1, '2023-11-22 10:56:54.000000', 'PROFESSOR_PAYMENT', 10, 1, 1),
(1, '2023-10-01 12:56:54.000000', 'PROFESSOR_PAYMENT', 20, 1, 1);

INSERT IGNORE INTO response (id, response, date, question_id, professor_id) VALUES
(1, 'response à la fiche n°1','2023-11-22 10:56:54.000000', 1, 1),
(2, 'response à la fiche n°2','2023-11-22 10:56:54.000000', 1, 1);

-- AJOUTER DOC DE REPONSE