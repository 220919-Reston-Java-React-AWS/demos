drop table if exists assignments;
drop table if exists users;
drop table if exists role;

create table role (
	id SERIAL primary key, -- SERIAL autoincrementing INTEGER
	role_name VARCHAR(50)
);

create table users (
	id SERIAL primary key, -- autoincrementing INTEGER
	username VARCHAR(50) not null unique,
	password VARCHAR(50) not null,
	first_name VARCHAR(200) not null,
	last_name VARCHAR(200) not null,
	role_id INTEGER references role(id) not NULL
);

create table assignments (
	id SERIAL primary key,
	assignment_name VARCHAR(50) not null,
	grade INTEGER check (grade >= 0),
	student_id INTEGER references users(id) not NULL,
	grader_id INTEGER references users(id)
);

insert into role (role_name)
values
('student'),
('trainer');

insert into users (username, password, first_name, last_name, role_id)
values
('john_doe', 'password123', 'John', 'Doe', 1), -- student
('bach_tran', 'pass12345', 'Bach', 'Tran', 2),
('jane_doe', 'tx123', 'Jane', 'Doe', 1); -- student

insert into assignments (assignment_name, student_id)
values 
('Midterm 1', 1), -- belongs to John
('Midterm 2', 1), -- belongs to John
('Midterm 1', 3); -- belongs to Jane


select * from role;
select * from users;
select * from assignments;

select * from users where username = 'bach_tran' and password = 'pass12345';


-- Assigns a grade of 95 to assignment 1, where the grader is Bach
update assignments 
set 
grade = 95,
grader_id = 2
where id = 1;

