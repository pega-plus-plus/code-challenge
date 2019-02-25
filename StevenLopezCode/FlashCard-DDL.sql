CREATE TABLE category(
c_id NUMBER,
c_name VARCHAR2(30),
PRIMARY KEY (c_id)
);

CREATE SEQUENCE c_id_seq;

CREATE OR REPLACE TRIGGER  c_id_trigger
  BEFORE INSERT ON category              
  FOR EACH ROW
BEGIN   
  IF :NEW.c_id IS NULL THEN 
    SELECT c_id_seq.NEXTVAL INTO :NEW.c_id FROM DUAL; 
  END IF;
END; 
/
----------------------------------------------------------------------------
CREATE TABLE flashcard(
fc_id NUMBER,
fc_question VARCHAR2(50),
fc_answer VARCHAR2(1000),
fc_category NUMBER,

PRIMARY KEY (fc_id),
FOREIGN KEY (fc_category) REFERENCES category(c_id)
);
CREATE SEQUENCE fc_id_seq;

CREATE OR REPLACE TRIGGER  fc_id_trigger
  BEFORE INSERT ON flashcard              
  FOR EACH ROW
BEGIN   
  IF :NEW.fc_id IS NULL THEN 
    SELECT fc_id_seq.NEXTVAL INTO :NEW.fc_id FROM DUAL; 
  END IF;
END; 
/
--------------------------------------------------------------------------

