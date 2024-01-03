INSERT IGNORE INTO owner (id,name, email, password) VALUES
(1, "Lova-admin" ,'lova@gmail.com', '$2a$10$wb/oW1/kTmxPGh0pxy5sY.enIXxHXO/LylZZ7VCMM8MSrupZeU0rW'),
(2, 'Eric','Student01@gmail.com', '$2a$10$3RsWxqNVOuWw/CbgV7SEkO3ycnUAv7dJ1eTfuaucUDCY.3UIcYh0y'),
(3, 'Césaire' ,'professor01@gmail.com', '$2a$10$wb/oW1/kTmxPGh0pxy5sY.enIXxHXO/LylZZ7VCMM8MSrupZeU0rW'),
(4, 'Lova','Student02@gmail.com', '$2a$10$3RsWxqNVOuWw/CbgV7SEkO3ycnUAv7dJ1eTfuaucUDCY.3UIcYh0y'),
(5, 'Ayoub' ,'professor02@gmail.com', '$2a$10$wb/oW1/kTmxPGh0pxy5sY.enIXxHXO/LylZZ7VCMM8MSrupZeU0rW');

INSERT IGNORE INTO role (id,name) VALUES
(1,'STUDENT'),
(2,'PROFESSOR'),
(3,'ADMIN'),
(4,'STUDENT-TP'),
(5,'PROFESSOR-TP');

INSERT IGNORE INTO owner_roles (owner_id, role_id) VALUES
(1,3),
(2,1),
(3,2),
(4,4),
(5,5);

INSERT IGNORE INTO student (owner_id, credits) VALUES
(2, 5),
(4,5);

INSERT IGNORE INTO professor (owner_id, credits) VALUES
(3, 0),
(5,0);

INSERT IGNORE INTO question ( id, date, student_id, level, question, type) VALUES
(1, '2023-11-22 10:56:54.000000', 2, 'COLLEGE', 'Comment calculer la somme de deux fraction?', 'NORMAL'),
(3, '2023-11-24 11:56:54.000000', 2, 'COLLEGE', 'Soit un triangle ABC avec les longueurs des côtés suivantes : AB = 5 cm, BC = 12 cm et AC = 13 cm. Est-ce que ce triangle est rectangle?', 'URGENT');

INSERT IGNORE INTO document_question (id, question_id, name, path) VALUES
(1, 1, 'Fraction', 'fraction.pdf'),
(2,3,'Triangle rectangle', 'Soit_un_triangle_ABC.pdf');


INSERT IGNORE INTO document_diplome (id, name, path, professor_id) VALUES
(1, 'professor01', 'Licence de math', 3);

INSERT IGNORE INTO transaction (id, date, type, amount, student_id, professor_id) VALUES
(1, '2023-11-22 10:56:54.000000', 'PURCHASE_CREDIT', 2, 3, null);

INSERT IGNORE INTO response (id, response, date, question_id, professor_id) VALUES
(1, 'Pour additionner deux fractions, trouvez un dénominateur commun, ajustez les fractions en conséquence, puis additionnez les numérateurs pour obtenir la fraction résultante.','2023-11-22 10:56:54.000000', 1, 3),

(3, 'Oui, le triangle ABC est un triangle rectangle. On peut utiliser le théorème de Pythagore pour le vérifier. Selon le théorème de Pythagore, dans un triangle rectangle, le carré de la longueur de l\'hypoténuse (le côté le plus long) est égal à la somme des carrés des longueurs des deux autres côtés. Dans ce cas, AC2=AB2+BC2AC2=AB2+BC2 est vrai, car 132=52+122132=52+122. Par conséquent, le triangle ABC est bien un triangle rectangle.','2023-11-22 10:56:54.000000', 3, 3);

-- AJOUTER DOC DE REPONSE