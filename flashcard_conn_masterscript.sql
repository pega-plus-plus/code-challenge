DROP TABLE fc_category CASCADE CONSTRAINTS;
DROP TABLE flashcard CASCADE CONSTRAINTS;

DROP SEQUENCE fc_category_seq;
DROP SEQUENCE flashcard_seq;

CREATE SEQUENCE fc_category_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE SEQUENCE flashcard_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE TABLE fc_category(
    fc_category_id      NUMBER(6)       PRIMARY KEY,
    fc_category_name    VARCHAR2(50)
);

CREATE TABLE flashcard(
    flashcard_id        NUMBER(6)       PRIMARY KEY,
    question            VARCHAR2(500),
    answer              VARCHAR2(500),
    category_id         NUMBER(6),
    CONSTRAINT category_id_fk FOREIGN KEY (category_id)
        REFERENCES fc_category(fc_category_id)
);

INSERT INTO fc_category VALUES(fc_category_seq.NEXTVAL,'Addition');
INSERT INTO fc_category VALUES(fc_category_seq.NEXTVAL,'Subtraction');
INSERT INTO fc_category VALUES(fc_category_seq.NEXTVAL,'Multiplication');
INSERT INTO fc_category VALUES(fc_category_seq.NEXTVAL,'Division');

INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'1 + 1 =','2',1);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'1 + 2 =','3',1);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'1 + 3 =','4',1);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'1 + 4 =','5',1);

INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'5 - 1 =','4',2);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'5 - 2 =','3',2);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'5 - 3 =','2',2);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'5 - 4 =','1',2);

INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'1 * 1 =','1',3);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'2 * 2 =','4',3);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'3 * 3 =','9',3);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'4 * 4 =','16',3);

INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'12 / 1 =','12',4);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'12 / 2 =','6',4);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'12 / 3 =','4',4);
INSERT INTO flashcard VALUES(flashcard_seq.NEXTVAL,'12 / 4 =','3',4);

commit;