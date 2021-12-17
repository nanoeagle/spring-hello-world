show DATABASES;
drop database musicdb;
CREATE DATABASE musicdb;

use musicdb;

drop table SINGER;
drop table ALBUM;

CREATE TABLE SINGER (
    ID INT NOT NULL AUTO_INCREMENT, 
    FIRST_NAME VARCHAR(60) NOT NULL, 
    LAST_NAME VARCHAR(40) NOT NULL, 
    BIRTH_DATE DATE, 
    PRIMARY KEY (ID),
    CONSTRAINT UQ_SINGER_1 UNIQUE (FIRST_NAME,LAST_NAME)
);

CREATE TABLE ALBUM (
    ID INT NOT NULL AUTO_INCREMENT, 
    SINGER_ID INT NOT NULL, 
    TITLE VARCHAR(100) NOT NULL, 
    RELEASE_DATE DATE, 
    PRIMARY KEY (ID), 
    CONSTRAINT UQ_SINGER_ALBUM_1 UNIQUE (SINGER_ID, TITLE),
    CONSTRAINT FK_ALBUM FOREIGN KEY (SINGER_ID) REFERENCES SINGER (ID)
);

delete from singer;
delete from album;

insert into singer (first_name, last_name, birth_date) 
    values ('John', 'Mayer', '1977-10-16');
insert into singer (first_name, last_name, birth_date) 
    values ('Eric', 'Clapton', '1945-03-30');
insert into singer (first_name, last_name, birth_date) 
    values ('John', 'Butler', '1975-04-01');
insert into album (singer_id, title, release_date) 
    values (1, 'The Search For Everything', '2017-01-20');
insert into album (singer_id, title, release_date) 
    values (1, 'Battle Studies', '2009-11-17');
insert into album (singer_id, title, release_date) 
    values (2, ' From The Cradle ', '1994-09-13');