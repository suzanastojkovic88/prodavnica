CREATE TABLE roba (
    ID BIGINT(20) NOT NULL,
    NAZIV VARCHAR(45) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE dokument (
    ID BIGINT(20) NOT NULL,
    NAZIV VARCHAR(45) NOT NULL,
    IZNOS DOUBLE NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE stavka_dokumenta (
    ID BIGINT(20) NOT NULL,
    KOLICINA INT NOT NULL,
    CENA DOUBLE NOT NULL,
    DOKUMENT_ID BIGINT(20) NOT NULL,
    ROBA_ID BIGINT(20) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (DOKUMENT_ID)
        REFERENCES dokument (ID),
    FOREIGN KEY (ROBA_ID)
        REFERENCES roba (ID)
);

insert into roba (ID, NAZIV) values (5,'Monitor');
insert into roba (ID, NAZIV) values (6,'Televizor');

insert into dokument (ID, NAZIV, IZNOS) values (10,'Racun-1', 0.0);

insert into stavka_dokumenta (ID, KOLICINA, CENA, DOKUMENT_ID, ROBA_ID) values (45, 2, 45.57, 10, 5);
insert into stavka_dokumenta (ID, KOLICINA, CENA, DOKUMENT_ID, ROBA_ID) values (55, 3, 67.23, 10, 6);
