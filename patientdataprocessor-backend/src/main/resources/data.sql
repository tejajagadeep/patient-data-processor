insert into User_Emp(user_name,password,role) values ('user@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','USER');
insert into User_Emp(user_name,password,role) values ('admin@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','ADMIN');
insert into User_Emp(user_name,password,role) values ('doctor@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');
insert into User_Emp(user_name,password,role) values ('drajaychekravarthi@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');


insert into Doctor(email_id,password,first_name,last_name,date_of_birth,gender,address,specialization,contact_number) 
	values('drajaychekravarthi@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm',' Chekravarthi','Dr Ajay','1988-05-25','Female','hyderabad', 'Dermatology',7894561230);
	
	
insert into patient(contact_number,address,first_name,last_name,gender,date_of_birth,marital_status,emergency_contact_number,email,blood_group,disease,date_visited,treatment_start_date,treatment_end_date,prescription,height,weight)
	values(7894561230,'hyderabad','Rakel','Ramesh','Male','1999-05-28','single',7894561231,'ramesh@gmail.com','O+','High BP','2022-11-28','2021-11-28','2023-11-28','Diuretics','170cms','75kgs');

insert into report(id,day,bp_lvl1,bp_lvl2,sugar_lvl,contact_number)
	values(1,'2022-01-01',140,90,99,7894561230);