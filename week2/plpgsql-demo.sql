-- ==================== DEMO 1 =========================== --
create table departments (
	id SERIAL primary key,
	name VARCHAR(50) not NULL
);

insert into departments (name)
values 
('IT'),
('HR'),
('Finance'),
('C-Suite');

select *
from departments;

create table employees (
	id SERIAL primary key,
	first_name VARCHAR(100) not null,
	last_name VARCHAR(100) not null,
	salary INTEGER not null,
	department_id INTEGER not null references departments(id)
);

-- We have inserted 1000 employee records (below are a subset)
insert into employees (first_name, last_name, salary, department_id) values ('Darrel', 'Djuricic', 83962, 2);
insert into employees (first_name, last_name, salary, department_id) values ('Thorndike', 'Borton', 79245, 3);
insert into employees (first_name, last_name, salary, department_id) values ('Vassili', 'Nightingale', 68487, 3);
insert into employees (first_name, last_name, salary, department_id) values ('Desirae', 'Waterfall', 56957, 4);
insert into employees (first_name, last_name, salary, department_id) values ('Viki', 'Bennike', 73836, 1);
insert into employees (first_name, last_name, salary, department_id) values ('Garvey', 'Haggus', 57853, 2);
insert into employees (first_name, last_name, salary, department_id) values ('Rozanna', 'Cowdery', 66726, 2);
insert into employees (first_name, last_name, salary, department_id) values ('Yorgos', 'Hoyes', 90548, 3);
insert into employees (first_name, last_name, salary, department_id) values ('Rock', 'Swindley', 60696, 1);
insert into employees (first_name, last_name, salary, department_id) values ('Jackelyn', 'Kitchaside', 76259, 3);
insert into employees (first_name, last_name, salary, department_id) values ('Chad', 'Hauxwell', 70390, 3);
insert into employees (first_name, last_name, salary, department_id) values ('Karil', 'Allwright', 89321, 3);
insert into employees (first_name, last_name, salary, department_id) values ('Marianna', 'MacGillespie', 59652, 4);
insert into employees (first_name, last_name, salary, department_id) values ('Cele', 'Gadney', 70077, 2);
insert into employees (first_name, last_name, salary, department_id) values ('Felice', 'Davidof', 66352, 1);
insert into employees (first_name, last_name, salary, department_id) values ('Germana', 'Luckham', 84571, 1);
insert into employees (first_name, last_name, salary, department_id) values ('Lynnette', 'Denisard', 87992, 2);
insert into employees (first_name, last_name, salary, department_id) values ('Reagan', 'Ragate', 55891, 2);
insert into employees (first_name, last_name, salary, department_id) values ('Tobey', 'Athow', 68321, 3);
insert into employees (first_name, last_name, salary, department_id) values ('Zolly', 'Robillard', 83487, 4);
insert into employees (first_name, last_name, salary, department_id) values ('Jareb', 'Benwell', 81230, 4);
insert into employees (first_name, last_name, salary, department_id) values ('Alejoa', 'Wreath', 57434, 2);

-- Retrieve the average salary of department 'X'

-- All at once
select d.name, AVG(salary) -- aggregate function (AVG, SUM, MIN, MAX, COUNT)
from employees as e
inner join departments as d 
on e.department_id = d.id
group by d.name;

-- IT
select AVG(salary)
from employees as e
inner join departments as d 
on e.department_id = d.id
where d.name = 'IT';

-- HR
select AVG(salary)
from employees as e
inner join departments as d 
on e.department_id = d.id
where d.name = 'HR';

-- Finance
select AVG(salary)
from employees as e
inner join departments as d 
on e.department_id = d.id
where d.name = 'Finance';

-- C-Suite
select AVG(salary)
from employees as e
inner join departments as d 
on e.department_id = d.id
where d.name = 'C-Suite';



-- Input: department
-- Output: Average salary of the inputted department
-- Function: takes input, processes input, and provides output


-- plpgsql
create or replace function get_department_average_salary(department varchar(50))
returns integer
language plpgsql
as 
$$
declare
	average_salary integer;
begin
	
	select AVG(salary)
	into average_salary
	from employees as e
	inner join departments as d 
	on e.department_id = d.id
	where d.name = department;

	return average_salary;
end;
$$;

-- Invoke the function
select get_department_average_salary('Finance') as avg_salary; -- in JDBC: rs.getInt("avg_salary")
select get_department_average_salary('IT') as avg_salary;
select get_department_average_salary('HR') as avg_salary;



-- ==================== DEMO 2 =========================== --


-- A procedure is like a user defined function, except it does not return anything
-- Ex. Transferring money between bank accounts
create table bank_accounts (
	id SERIAL primary key,
	balance INTEGER not null
);

insert into bank_accounts (
	balance 
) values 
(5000),
(10000);

-- When you execute a user defined function OR procedure, all operations in them are considered
-- as a single transaction 
-- ACID transaction properties
-- Atomicity: "all or nothing" Either the transaction completely succeeds or not at all
-- Consistency: we must uphold all constraints placed on the data (ex. balance must be >= 0)
-- Isolation: if you have multiple transactions at a time, they shouldn't interfere with each other
-- Durability: When you commit a transaction, that is when it is permanently persisted to the database
create or replace procedure transfer_money(sender_id integer, receiver_id integer, amount integer)
language plpgsql
as 
$$
begin
	if (select balance from bank_accounts where id = sender_id) < amount then
		raise exception 'insufficient balance';
	end if;
	
	-- Decrease the balance of the first account by the amount we are sending
	update bank_accounts 
	set balance = balance - amount
	where id = sender_id;

	-- Increase the balance of the second account by the amount it is receiving
	update bank_accounts 
	set balance = balance + amount
	where id = receiver_id;

	commit; -- where DML operations are actually all persisted
end;
$$;

create table audit_log (
	id SERIAL primary key,
	bank_account_id INTEGER not null,
	previous_balance INTEGER not null,
	new_balance INTEGER not null,
	time_occurred TIMESTAMP not NULL
);

create or replace function log_bank_account_balance_change()
returns trigger
language plpgsql
as 
$$
begin 
	-- OLD: refers to the "previous" data for a particular row
	-- NEW: refers to the "updated" data for a particular row
	if old.balance != new.balance then
		insert into audit_log (bank_account_id, previous_balance, new_balance, time_occurred)
		values (old.id, old.balance, new.balance, now());
	end if;

	return new;
end;
$$;

create or replace trigger balance_changes
before update
on bank_accounts 
for each row 
execute procedure log_bank_account_balance_change();


update bank_accounts 
set balance = 1000
where id = 1;

select *
from bank_accounts;

call transfer_money(1, 2, 500);









