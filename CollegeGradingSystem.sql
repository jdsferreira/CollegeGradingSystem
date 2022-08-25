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

INSERT INTO student (
    studentid,
    firstname,
    lastname,
    address,
    city
) VALUES (
    1,
    'Vanessa',
    'McDonald',
    'F',
    'Edmonton'
);

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

INSERT INTO course (
    courseid,
    coursename,
    creditnumber
) VALUES (
    10000,
    'Biologie',
    '3'
);

COMMIT;

---------------------------------------------------------------------------

-- SQL - Création de la table : 
CREATE TABLE grade (
    studentid INTEGER NOT NULL,
    courseid  INTEGER NOT NULL,
    semester   VARCHAR(50) NOT NULL,
    score     INTEGER NOT NULL
);

-- Contrainte de la clé primaire
ALTER TABLE grade ADD CONSTRAINT pk_result_id PRIMARY KEY ( studentid );

ALTER TABLE grade
    ADD CONSTRAINT fk_student_id FOREIGN KEY ( studentid )
        REFERENCES student ( studentid );

ALTER TABLE grade
    ADD CONSTRAINT fk_course_id FOREIGN KEY ( courseid )
        REFERENCES course ( courseid );

INSERT INTO grade (
    studentid,
    courseid,
    semester,
    score
) VALUES (
    1,
    '10000',
    'H-2022',
    '80'
);

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