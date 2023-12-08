INSERT IGNORE INTO owner (id,name, email, password) VALUES
(1,'','eric@gmail.com', '1234'),
(2,'' ,'sarah@gmail.com', '1234');

INSERT IGNORE INTO role (id,name) VALUES
(1,'STUDENT'),
(2,'PROFESSOR');

INSERT IGNORE INTO owner_roles (owner_repository_model_id, roles_id) VALUES
(1,1),
(2,2);

INSERT IGNORE INTO student (owner_id, credits) VALUES
(1, 5);

INSERT IGNORE INTO professor (owner_id, credits) VALUES
(2, 0);

INSERT IGNORE INTO question (date, id, student_id, level, question, type) VALUES
('2023-11-22 10:56:54.000000', 1, 1, 'COLLEGE', 'Comment calculer la somme de deux fraction?', 'NORMAL'),
('2023-11-22 10:56:54.000000', 2, 1, 'COLLEGE', 'Comment diviser ...?', 'URGENT');

INSERT IGNORE INTO document_question (id, question_id, name, path) VALUES
(1, 1, 'Nom de la fiche n°1', 'path la fiche n°1'),
(2, 1, 'Nom de la fiche n°2', 'path la fiche n°2');

INSERT IGNORE INTO document_diplome (id, name, path, professor_id) VALUES
(1, 'Lova', 'Licence de math', 1);

INSERT IGNORE INTO transaction (id, date, type, amount, student_id, professor_id) VALUES
(1, '2023-11-22 10:56:54.000000', 'PURCHASE_CREDIT', 10, 1, null);

INSERT IGNORE INTO response (id, response, date, question_id, professor_id) VALUES
(1, 'response à la fiche n°1','2023-11-22 10:56:54.000000', 1, 2),
(2, 'response à la fiche n°2','2023-11-22 10:56:54.000000', 1, 2);

-- AJOUTER DOC DE REPONSE