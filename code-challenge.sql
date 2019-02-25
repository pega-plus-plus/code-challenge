-- creates new table
CREATE TABLE FLASHCARDS (
    cardID number(2) NOT NULL,
    cardCategory varchar2(20),
    cardQuestion varchar2(20),
    cardAnswer varchar2(20),
    CONSTRAINT pk_Flashcards_cardID PRIMARY KEY (cardID)
);

-- CRUD - 
-- creates new flashcard entry
CREATE OR REPLACE PROCEDURE CREATE_FLASHCARD ( cardCat IN VARCHAR2, cardQstn IN VARCHAR2,
cardAnsr IN VARCHAR2)
AS
BEGIN
    INSERT INTO FLASHCARDS VALUES(CardID_SEQ.NEXTVAL, cardCat, cardQstn, cardAnsr);
END;
/

-- updates flashcard question
CREATE OR REPLACE PROCEDURE UPDATE_FLASHCARD (card_id IN NUMBER, cardCat IN VARCHAR2, cardQstn IN VARCHAR2,
cardAnsr IN VARCHAR2)
AS
BEGIN
    UPDATE FLASHCARDS SET cardCategory = cardCat,
                         cardQuestion = cardQstn,
                         cardAnswer   = cardAnsr
                     WHERE FLASHCARDS.cardID = card_id;
END;
/

-- Creating sequence for card ID
CREATE SEQUENCE CardID_SEQ
START WITH 1
INCREMENT BY 1;
