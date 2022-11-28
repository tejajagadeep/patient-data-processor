insert into User_Emp(user_name,password,role) values ('user@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','USER');
insert into User_Emp(user_name,password,role) values ('admin@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','ADMIN');
insert into User_Emp(user_name,password,role) values ('doctor@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');


insert into Doctor(email_id,password,name,date_of_birth,specialization,contact_number) 
	values('drajaychekravarthi@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','Dr Ajay Chekravarthi','1988-05-25', 'Dermatology',7894561230);
	
	