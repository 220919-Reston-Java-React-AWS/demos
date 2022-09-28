-- PRIMARY KEY, FOREIGN KEY, DEFAULT, UNIQUE, NOT NULL, CHECK

drop table if exists student;
drop table if exists cohort;

create table cohort (
	id SERIAL primary key,
	cohort_name VARCHAR(100) not null,
	cohort_city VARCHAR(50) not null,
	cohort_country VARCHAR(50) not null
);

create table zipcodes (
	id INTEGER primary key,
	city VARCHAR(50) not NULL
);

create table student (
	id SERIAL primary KEY, -- SERIAL is an auto-incrementing version of INTEGER
	first_name VARCHAR(200) not null, 
	last_name VARCHAR(200) not null,
	zipcode INTEGER not null,
	cohort_id INTEGER not null,
	constraint fk_student_cohort foreign KEY(cohort_id) references cohort(id) on delete cascade, -- on delete cascade means that if you delete a cohort, the students belonging
	-- to the cohort will get deleted as well
	constraint fk_student_zipcodes foreign key (zipcode) references zipcodes(id)
);


insert into cohort (cohort_name, cohort_city, cohort_country) 
values 
('220928 Java React AWS', 'Arlington', 'United States'),
('211018 Java Automation AWS', 'Reston', 'United States');


insert into zipcodes (id, city) 
values 
(78749, 'Austin'),
(75001, 'Dallas'),
(18704, 'Kingston');

insert into student (first_name, last_name, zipcode, cohort_id)
values 
('Byron', 'Brett', 78749, 1),
('Raymond', 'Pritchard', 75001, 1),
('Eryk', 'Martinez', 18704, 2),
('Torin', 'Brookes', 78749, 2);


select *
from cohort;

select *
from zipcodes;

select *
from student;


-- Query the city in which the student with id 1 lives
select city
FROM student as s
inner join zipcodes as zc 
on s.zipcode = zc.id
where s.id = 1;

-- Query the name of the cohort in which the student belongs (id 1)
select cohort_name
from student as s
inner join cohort as c
on s.cohort_id = c.id
where s.id = 1;

-- Get all the information for students that live in Austin
select s.*
from student as s
inner join zipcodes as zc 
on s.zipcode = zc.id
where zc.city = 'Austin';

-- JOIN multiple tables together 
select *
from student as s
inner join zipcodes as zc 
on s.zipcode = zc.id 
inner join cohort c 
on s.cohort_id = c.id;










