-- TRUNCATE TABLE GUEST;
-- TRUNCATE TABLE EVENT;
-- SET REFERENTIAL_INTEGRITY TRUE;

-- ALTER TABLE GUEST ALTER COLUMN id RESTART WITH 1;
-- ALTER TABLE EVENT ALTER COLUMN id RESTART WITH 1;

INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Coldplay Concert', '2022-11-23', 'London', 'England');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('AR Rahman', '2022-11-23' , 'Mumbai', 'India');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Guns and Roses North-Am', '2022-10-31', 'Vancouver', 'Canada');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('San Diego Comic Con', '2022-10-30', 'Sab Diego', 'California');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Maren Kroymann & Band: In my sixties', '2022-11-01', 'Berlin', 'Germany');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Lukas Graham', '2022-11-24', 'Cologne', 'Germany');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Beatles Concert', '2022-11-26', 'Liverpool', 'England');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Munich Career Fair', '2022-12-26', 'Munich', 'Germany');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Swedish House Mafia-Euro Tour', '2022-12-03', 'Amsterdam', 'Netherlands');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('New Years Eve Fireworks', '2023-01-15', 'Sydney', 'Australia');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Supermoon', '2023-11-02', 'Goa', 'India');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Sigur Ros-Back Home', '2023-02-20', 'Reykjavik', 'Iceland');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('The Muppet Christmas Carol in Concert', '2022-11-30', 'Edinburgh', 'Scotland');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Orpheus Choir', '2022-12-18', 'Wellington', 'New Zealand');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Broadway in Syracuse', '2023-01-23', 'Syracuse', 'United States');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Freedom Trail Tour', '2022-12-17', 'Boston', 'United States');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Stadium Arcadium-RHCP', '2022-12-07', 'Lisbon', 'Portugal');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('The Lion King-Broadway', '2023-04-11', 'New York', 'United States');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Dubai Expo 2022', '2023-03-19', 'Dubai', 'United Arab Emirates');
INSERT INTO EVENT(event_name, curr_date, city, country) VALUES('Nutcracker! Magical Christmas Ballet', '2022-12-18', 'San Antonio', 'United States');

INSERT INTO GUEST(id, name, city, event_id) VALUES(1, 'Chris Martin', 'London', 1);
INSERT INTO GUEST(id, name, city, event_id) VALUES(2, 'Balbir Pasha', 'Punjab', 2);
INSERT INTO GUEST(id, name, city, event_id) VALUES(3, 'Sachin Tendulkar', 'Mumbai', 3);
INSERT INTO GUEST(id, name, city, event_id) VALUES(4, 'Kyle Reese', 'Los Angeles', 4);
INSERT INTO GUEST(id, name, city, event_id) VALUES(5, 'Virgil Van Dijk', 'Amsterdam', 5);
INSERT INTO GUEST(id, name, city, event_id) VALUES(6, 'Phillip Lahm', 'Munich', 6);
INSERT INTO GUEST(id, name, city, event_id) VALUES(7, 'Andres Iniesta', 'Barcelona', 7);
INSERT INTO GUEST(id, name, city, event_id) VALUES(8, 'Tom Brady', 'Boston', 8);
INSERT INTO GUEST(id, name, city, event_id) VALUES(9, 'Mickey Mouse', 'Hallifax', 9);
INSERT INTO GUEST(id, name, city, event_id) VALUES(10, 'Chance Furlong', 'Kiev', 10);
INSERT INTO GUEST(id, name, city, event_id) VALUES(11, 'Jake Clawson', 'Lisbon', 11);
INSERT INTO GUEST(id, name, city, event_id) VALUES(12, 'Robert Downey Jr', 'Cologne', 13);
INSERT INTO GUEST(id, name, city, event_id) VALUES(13, 'Cersei Lannnister', 'Reykjavik', 14);
INSERT INTO GUEST(id, name, city, event_id) VALUES(14, 'Arya Stark', 'Syracuse', 15);
INSERT INTO GUEST(id, name, city, event_id) VALUES(15, 'Margot Robbie', 'Adelaide', 16);
INSERT INTO GUEST(id, name, city, event_id) VALUES(16, 'Martin Scorsese', 'New York', 17);
INSERT INTO GUEST(id, name, city, event_id) VALUES(17, 'Tyrion Lannister', 'Vancouver', 18);
INSERT INTO GUEST(id, name, city, event_id) VALUES(18, 'Luke Skywalker', 'Dubai', 19);
INSERT INTO GUEST(id, name, city, event_id) VALUES(19, 'Samwise Gamgee', 'Wellington', 20);
INSERT INTO GUEST(id, name, city, event_id) VALUES(20, 'Steven Gerrard', 'Liverpool', 12);


