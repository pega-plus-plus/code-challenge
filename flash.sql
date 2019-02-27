/*
    This is flashcard program
*/

drop table flashcards;
drop table categories;
drop sequence flash_seq;
drop sequence category_seq;
drop view flashview;

create table categories (
    category_id number not null primary key,
    category_name varchar2(20)    
);

create table flashcards (
    flashcard_id NUMBER NOT NULL PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    answer VARCHAR(255),
    category_id NUMBER,
    CONSTRAINT fk_flash_category
    FOREIGN KEY (category_id)
    REFERENCES categories(category_id)
);

/* creating sequences for the flashcards and categories table*/
create sequence flash_seq
    start with 1
    increment by 1
    /
create sequence category_seq
    start with 1
    increment by 1
    /

/*
    populating the categories table
*/
insert into categories values(category_seq.nextval, 'General');
insert into categories values(category_seq.nextval, 'Programming');
insert into categories values(category_seq.nextval, 'Design Pattern');

/* 
    populating the flashcards table
*/
insert into flashcards values(flash_seq.nextval, 'What is a flashcard', 'It is page containing question and answers',1);
insert into flashcards values(flash_seq.nextval, 'What is Alhagie', 'A name signifying Hajj (pilgrim to Mecca)',1);
insert into flashcards values(flash_seq.nextval, 'What is POM', 'A Page Object Model',3);
insert into flashcards values(flash_seq.nextval, 'What is Angular', 'It is both a server and a compiler for a SPA',2);
insert into flashcards values(flash_seq.nextval, 'What is Hibernate', 'It is an ORM framework for persisting java objects in database',2);
insert into flashcards values(flash_seq.nextval, 'What is BEANS', 'A design pattern containing properties and functionality',3);

commit;

CREATE VIEW flashview AS
  SELECT flashcards.flashcard_id, flashcards.question, flashcards.answer, categories.category_name as category
  FROM flashcards
  LEFT OUTER JOIN categories
  ON flashcards.category_id = categories.category_id
  order by flashcard_id asc;
select * from flashview;