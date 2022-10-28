SET REFERENTIAL_INTEGRITY FALSE;
DROP TABLE IF EXISTS EVENT cascade;
DROP TABLE IF EXISTS GUEST cascade;
SET REFERENTIAL_INTEGRITY TRUE;

CREATE TABLE EVENT (
                       id INT AUTO_INCREMENT,
                       event_name VARCHAR(50) NOT NULL,
                       curr_date DATE NOT NULL ,
                       city VARCHAR(50) NOT NULL,
                       country VARCHAR(50) NOT NULL ,
                       PRIMARY KEY(id)
);

CREATE TABLE GUEST (
                       id INT AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL ,
                       city VARCHAR(50) NOT NULL ,
                       event_id INT NOT NULL
                           references EVENT,
                       PRIMARY KEY (id)
);