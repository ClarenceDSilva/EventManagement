-- TRUNCATE TABLE GUEST;
-- TRUNCATE TABLE EVENT;
-- SET REFERENTIAL_INTEGRITY TRUE;
-- ALTER TABLE GUEST ALTER COLUMN id RESTART WITH 1;
-- ALTER TABLE EVENT ALTER COLUMN id RESTART WITH 1;

DROP TABLE IF EXISTS EVENT cascade;
DROP TABLE IF EXISTS GUEST cascade;

CREATE TABLE EVENT (
                       id INT NOT NULL ,
                       event_name VARCHAR(50) NOT NULL,
                       curr_date DATE NOT NULL ,
                       city VARCHAR(50) NOT NULL,
                       country VARCHAR(50) NOT NULL ,
                       PRIMARY KEY(id)
);

CREATE TABLE GUEST (
                       id INT NOT NULL ,
                       name VARCHAR(50) NOT NULL ,
                       city VARCHAR(50) NOT NULL ,
                       event_id INT NOT NULL
                           references EVENT,
                       PRIMARY KEY (id)
);