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
    VERSION INT NOT NULL DEFAULT 0,
    PRIMARY KEY (ID),
    CONSTRAINT UQ_SINGER_1 UNIQUE (FIRST_NAME, LAST_NAME)
);

CREATE TABLE ALBUM (
    ID INT NOT NULL AUTO_INCREMENT, 
    SINGER_ID INT NOT NULL, 
    TITLE VARCHAR(100) NOT NULL, 
    RELEASE_DATE DATE, 
    VERSION INT NOT NULL DEFAULT 0,
    PRIMARY KEY (ID), 
    CONSTRAINT UQ_SINGER_ALBUM_1 UNIQUE (SINGER_ID, TITLE),
    CONSTRAINT FK_ALBUM FOREIGN KEY (SINGER_ID) REFERENCES SINGER (ID)
);

CREATE TABLE INSTRUMENT (
    ID INT NOT NULL AUTO_INCREMENT, 
    INSTRUMENT_NAME VARCHAR(40) NOT NULL, 
    VERSION INT NOT NULL DEFAULT 0,
    PRIMARY KEY (ID),
    CONSTRAINT UQ_INSTRUMENT UNIQUE (INSTRUMENT_NAME)
);

CREATE TABLE SINGER_INSTRUMENT (
    SINGER_ID INT NOT NULL, 
    INSTRUMENT_ID INT NOT NULL, 
    PRIMARY KEY (SINGER_ID, INSTRUMENT_ID), 
    CONSTRAINT FK_SINGER_INSTRUMENT_1 FOREIGN KEY (SINGER_ID) 
        REFERENCES SINGER (ID) ON DELETE CASCADE, 
    CONSTRAINT FK_SINGER_INSTRUMENT_2 FOREIGN KEY (INSTRUMENT_ID) 
        REFERENCES INSTRUMENT (ID)
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
    values (2, 'From The Cradle', '1994-09-13');

insert into instrument (instrument_name) values ('Guitar');
insert into instrument (instrument_name) values ('Piano');
insert into instrument (instrument_name) values ('Voice');
insert into instrument (instrument_name) values ('Drums');
insert into instrument (instrument_name) values ('Synthesizer');

insert into singer_instrument (singer_id, instrument_id) values (1, 1);
insert into singer_instrument (singer_id, instrument_id) values (1, 2);
insert into singer_instrument (singer_id, instrument_id) values (2, 1);