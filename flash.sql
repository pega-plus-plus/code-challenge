CREATE TABLE flashcards (
    flash_id NUMBER NOT NULL PRIMARY KEY,
    question VARCHAR2 NOT NULL,
    answer VARCHAR2,
    category_id NUMBER
);

CREATE SEQUENCE flash_seq
    START WITH 1
    INCREMENT by 1;
    /
    
    
create table category (
    category_id NUMBER NOT NULL PRIMARY KEY,
    category_name varchar2
);
CREATE SEQUENCE category_seq
    START WITH 1
    INCREMENT by 1;
    /
    
    