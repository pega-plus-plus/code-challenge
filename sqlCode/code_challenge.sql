DROP TABLE flashcard CASCADE CONSTRAINTS;
DROP TABLE category CASCADE CONSTRAINTS;

CREATE TABLE flashcard (
    f_id NUMBER(6),
    question varchar2(100),
    answer varchar2(100),
    cate number(6),
    CONSTRAINT flashcard_PK PRIMARY KEY (f_id),
    CONSTRAINT category_FK FOREIGN KEY (cate)
        REFERENCES types(t_id)
);

CREATE TABLE category (
    c_id NUMBER(6),
    name varchar2(100),
    CONSTRAINT category_PK PRIMARY KEY (c_id)
);

DROP SEQUENCE flashcard_seq;
CREATE SEQUENCE flashcard_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER flashcard_id_trig
BEFORE INSERT ON flashcard
FOR EACH ROW
BEGIN
    IF :new.f_id IS NULL THEN
        SELECT flashcard_seq.NEXTVAL into :new.f_id FROM dual;
    END IF;
END;

DROP SEQUENCE category_seq;
CREATE SEQUENCE category_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER category_id_trig
BEFORE INSERT ON category
FOR EACH ROW
BEGIN
    IF :new.c_id IS NULL THEN
        SELECT category_seq.NEXTVAL into :new.c_id FROM dual;
    END IF;
END;

INSERT INTO category VALUES (1, 'Food');
INSERT INTO category VALUES (2, 'Living');
INSERT INTO category VALUES (3, 'Vehicles');

INSERT INTO flashcard VALUES (null, 'What is Hamburger?', 'Food', 1);
INSERT INTO flashcard VALUES (null, 'What is Soda?', 'Drink', 1);
INSERT INTO flashcard VALUES (null, 'What is Salad?', 'Food', 1);

INSERT INTO flashcard VALUES (null, 'What is an Apartment', 'Building', 2);
INSERT INTO flashcard VALUES (null, 'What is a House', 'Housing', 2);
INSERT INTO flashcard VALUES (null, 'What is a RV', 'Mobile House', 2);

INSERT INTO flashcard VALUES (null, 'What is a Ford', 'Truck', 3);
INSERT INTO flashcard VALUES (null, 'What is a Honda', 'Car', 3);
INSERT INTO flashcard VALUES (null, 'What is a Harley', 'Motorcycle', 3);

SELECT * FROM flashcard;
SELECT * FROM category;

commit;