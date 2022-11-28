insert into User_Emp(user_name,password,role) values ('user@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','USER');
insert into User_Emp(user_name,password,role) values ('admin@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','ADMIN');
insert into User_Emp(user_name,password,role) values ('doctor@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');


insert into Doctor(email_id,password,name,date_of_birth,specialization,contact_number) 
	values('drajaychekravarthi@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','Dr Ajay Chekravarthi','1988-05-25', 'Dermatology',7894561230);
	
	
insert into patient(contact_number)
	values(7894561230);

insert into report(id,day,bp_lvl1,bp_lvl2,sugar_lvl,contact_number)
	values(1,'2022-01-01',140,90,99,7894561230);