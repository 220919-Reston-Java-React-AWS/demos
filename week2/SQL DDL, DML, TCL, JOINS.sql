--DDL 

--CREATE SCHEMA other_schema2;
DROP TABLE IF EXISTS avengers;
DROP TABLE IF EXISTS homes;

CREATE TABLE avengers (
	hero_name VARCHAR(30),
	hero_power VARCHAR(30),
	real_name VARCHAR(40),
	power_level INTEGER
);

ALTER TABLE avengers ADD COLUMN active BOOLEAN DEFAULT(false);
--ALTER TABLE avengers ADD COLUMN age INTEGER DEFAULT(31);

TRUNCATE TABLE avengers;

--DML
INSERT INTO avengers (hero_name, hero_power, real_name, power_level) VALUES
('captain america', 'ultimate frisbee champion', 'Steve Rogers', 75),
('iron man', 'rich', 'Tony Stark', 225);

SELECT * FROM avengers; 

SELECT hero_name, real_name FROM avengers;

UPDATE avengers SET active = TRUE WHERE hero_name = 'iron man';

DELETE FROM avengers WHERE hero_name ='captain america';
DELETE FROM avengers WHERE hero_name ='iron man';

--DQL
SELECT * FROM avengers; 

--TCL
BEGIN;
	INSERT INTO avengers (hero_name, hero_power, real_name, power_level, age) VALUES
('spiderman', 'super spider', 'Peter Parker', 125, 25);
	UPDATE avengers SET hero_power = 'web shooting skills' WHERE hero_name = 'spiderman';
	UPDATE avengers SET active = TRUE WHERE hero_name = 'spiderman';
COMMIT;


-- Relationships 
--TRUNCATE TABLE avengers;
--TRUNCATE TABLE homes;

DROP TABLE avengers;
DROP TABLE homes;

CREATE TABLE homes (
	home_name VARCHAR(30) PRIMARY KEY,
	home_addr VARCHAR(150) 
);

ALTER TABLE avengers ADD COLUMN home VARCHAR REFERENCES homes(home_name);

INSERT INTO homes (home_name, home_addr) VALUES 
('Stark Tower', '123 Stark Lane, Manhattan, NY, 11001'),
('Spidermans Home', '123 Spider Lane, Manhattan, NY, 11001'),
('Shield Acedemy', '23 Secret Agent drive, Syracuse, NY, 13057'); 

INSERT INTO avengers (hero_name, hero_power, power_level, real_name, home)
	VALUES ('captain america', 'frisbee guy', 50, 'steve rogers', 'Shield Acedemy'),
	('iron man', 'rich smart guy', 250, 'tony stark', 'Stark Tower'),
	('spiderman', 'shoots spider webs', 150, 'peter parker', 'Spidermans Home');

INSERT INTO avengers (hero_name, hero_power, power_level, real_name, home)
	VALUES ('hulk', 'smashes stuff', 550, 'bruce banner', null);

INSERT INTO homes (home_name, home_addr) VALUES 
('No ones Home', '123 doesnt exist');

--Joins
--Inner Joins
SELECT * FROM avengers INNER JOIN homes ON avengers.home = homes.home_name;
--Left join
SELECT * FROM avengers LEFT JOIN homes ON avengers.home = homes.home_name;
-- Right Join
SELECT * FROM avengers RIGHT JOIN homes ON avengers.home = homes.home_name;

SELECT * FROM (SELECT * FROM avengers AS a RIGHT JOIN homes AS h ON a.home = h.home_name) AS avhome
	INNER JOIN avengers AS a2 ON avhome.hero_name = a2.hero_name;


--Altering and Updating the tables to allow for meaningful set operations
ALTER TABLE avengers ADD COLUMN active BOOLEAN DEFAULT(false);
UPDATE avengers SET active = TRUE WHERE hero_name = 'iron man';
UPDATE avengers SET active = TRUE WHERE hero_name = 'spiderman';
UPDATE avengers SET active = TRUE WHERE hero_name = 'hulk';


--Set Operations

--ORDER BY 
SELECT * FROM avengers ORDER BY power_level DESC;
SELECT * FROM avengers ORDER BY real_name ASC;

--GROUP BY uses HAVING to 
SELECT SUM(power_level), active FROM avengers GROUP BY active;

SELECT MIN(power_level), active FROM avengers GROUP BY active;


