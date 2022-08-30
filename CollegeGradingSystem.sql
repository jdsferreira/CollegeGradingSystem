-- SQL - Supression des tables : 
DROP TABLE student;

DROP TABLE course;

DROP TABLE grade;

---------------------------------- Table student -----------------------------------------

-- SQL - Création de la table : 
CREATE TABLE student (
    studentid INTEGER NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname  VARCHAR(50) NOT NULL,
    address   VARCHAR(50) NOT NULL,
    city      VARCHAR(50) NOT NULL
);

-- Contrainte de la clé primaire
ALTER TABLE student ADD CONSTRAINT pk_student_id PRIMARY KEY ( studentid );

INSERT INTO student (studentid, firstname, lastname, address,city) VALUES (1,'Vanessa','McDonald','10838 114 St NW','Edmonton');
INSERT INTO student (studentid, firstname, lastname, address,city) VALUES(2,'Andrew','Fuller','6350 Av. des Erables','Montreal');
INSERT INTO student (studentid, firstname, lastname, address,city) VALUES(3,'Janet','Leverling','27 Rue Principale O','Ascension');
INSERT INTO student (studentid, firstname, lastname, address,city) VALUES(4,'Margaret','Peacock','43 Bell St N','Ottawa');
INSERT INTO student (studentid, firstname, lastname, address,city) VALUES(5,'Steven','Buchanan','72 Courton Dr','Toronto');

COMMIT;

---------------------------------------------------------------------------

-- SQL - Création de la table : 
CREATE TABLE course (
    courseid     INTEGER NOT NULL,
    coursename   VARCHAR(50) NOT NULL,
    creditnumber INTEGER NOT NULL
);

-- Contrainte de la clé primaire
ALTER TABLE course ADD CONSTRAINT pk_course_id PRIMARY KEY ( courseid );

INSERT INTO course (courseid, coursename, creditnumber)
 VALUES (10000,'Biologie', 3);
INSERT INTO course (courseid, coursename, creditnumber)
 VALUES (20000,'Mathematique', 2);

COMMIT;

---------------------------------------------------------------------------

-- SQL - Création de la table : 
CREATE TABLE grade (
    gradeid INTEGER NOT NULL,
    studentid INTEGER NOT NULL,
    courseid  INTEGER NOT NULL,
    semester   VARCHAR(50) NOT NULL,
    score     INTEGER NOT NULL
);

-- Contrainte de la clé primaire
ALTER TABLE grade ADD CONSTRAINT pk_result_id PRIMARY KEY ( gradeid );

ALTER TABLE grade
    ADD CONSTRAINT fk_student_id FOREIGN KEY ( studentid )
        REFERENCES student ( studentid ) ON DELETE CASCADE;

ALTER TABLE grade
    ADD CONSTRAINT fk_course_id FOREIGN KEY ( courseid )
        REFERENCES course ( courseid ) ON DELETE CASCADE;

INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (1,1, 10000,'H-2022',80);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (2,1, 20000,'H-2022',90);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (3,2, 10000,'H-2022',89);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (4,2, 20000,'H-2022',87);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (5,3, 10000,'H-2022',67);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (6,3, 20000,'H-2022',99);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (7,4, 10000,'H-2022',59);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (8,4, 20000,'H-2022',66);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (9,5, 10000,'H-2022',76);
INSERT INTO grade (gradeid, studentid, courseid, semester, score) 
VALUES (10,5, 20000,'H-2022',84);

COMMIT;

---------------------------------------------------------------------------

-- Vérification

SELECT
    *
FROM
    student;

SELECT
    *
FROM
    course;

SELECT
    *
FROM
    grade;