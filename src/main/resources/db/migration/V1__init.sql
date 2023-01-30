CREATE TABLE groups (
    id serial,
    prof VARCHAR(100) NOT NULL,
    count_ int NOT NULL,
    group_ int NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE teachers (
    id serial,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    CONSTRAINT authorities_idx UNIQUE (username, authority),

    CONSTRAINT authorities_ibfk_1
    FOREIGN KEY (username)
    REFERENCES users (username)
);

CREATE TABLE students (
    id serial,
    surname VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    fatherland VARCHAR(100),
    username VARCHAR(50) NOT NULL,
    form VARCHAR(50) NOT NULL,
    course VARCHAR(50) NOT NULL,
    telephone text NOT NULL,
    bd date NOT NULL,
    id_group int NOT NULL,

    PRIMARY KEY (id),

    FOREIGN KEY (username)
    REFERENCES users (username),

    FOREIGN KEY (id_group)
    REFERENCES groups (id)

);

CREATE TABLE objects (
    id serial,
    object VARCHAR(50) NOT NULL,
    id_teacher int NOT NULL,

    PRIMARY KEY (id),

    FOREIGN KEY (id_teacher)
    REFERENCES teachers (id)
);

CREATE TABLE estimate (
    id_student int NOT NULL,
    id_object int NOT NULL,
    estimate float NOT NULL,

    FOREIGN KEY (id_student)
    REFERENCES students (id),

    FOREIGN KEY (id_object)
    REFERENCES objects (id)
);