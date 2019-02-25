-- Flashcard Database


-- DDL
DROP TRIGGER fc_id_trigger;
DROP TRIGGER cat_id_trigger;

DROP SEQUENCE fc_id_seq;
DROP SEQUENCE cat_id_seq;

DROP TABLE flashcard;
DROP TABLE category;

CREATE TABLE category(
id INT PRIMARY KEY,
name VARCHAR2(1000)
);


CREATE TABLE flashcard(
id INT PRIMARY KEY,
question VARCHAR2(1000),
answer VARCHAR2(1000),
category INT,
FOREIGN KEY(category) REFERENCES category(id)
);


CREATE SEQUENCE fc_id_seq;
CREATE SEQUENCE cat_id_seq;

CREATE OR REPLACE TRIGGER  fc_id_trigger
  BEFORE INSERT ON flashcard          
  FOR EACH ROW
BEGIN   
  IF :NEW.id IS NULL THEN 
    SELECT fc_id_seq.NEXTVAL INTO :NEW.id FROM DUAL; 
  END IF;
END; 
/

CREATE OR REPLACE TRIGGER  cat_id_trigger
  BEFORE INSERT ON category          
  FOR EACH ROW
BEGIN   
  IF :NEW.id IS NULL THEN 
    SELECT cat_id_seq.NEXTVAL INTO :NEW.id FROM DUAL; 
  END IF;
END; 
/


COMMIT;