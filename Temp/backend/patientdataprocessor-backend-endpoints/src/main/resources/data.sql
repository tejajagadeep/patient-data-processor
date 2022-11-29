insert into User_Emp(user_name,password,role) values ('user@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','USER');
insert into User_Emp(user_name,password,role) values ('admin@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','ADMIN');
insert into User_Emp(user_name,password,role) values ('doctor@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');
insert into User_Emp(user_name,password,role) values ('drajaychekravarthi@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');
insert into User_Emp(user_name,password,role) values ('drvallika@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');
insert into User_Emp(user_name,password,role) values ('drchandhrakalasidagam@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');
insert into User_Emp(user_name,password,role) values ('dreswarreddy@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');
insert into User_Emp(user_name,password,role) values ('drpattabhikopparthi@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');
insert into User_Emp(user_name,password,role) values ('drcharanteja@gmail.com', '{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','DOCTOR');


insert into Doctor(email_id,password,first_name,last_name,date_of_birth,gender,address,contact_number) 
	values('drajaychekravarthi@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm',' Chekravarthi','Dr Ajay','1988-05-25','Female','hyderabad',7894561230);

insert into Doctor(email_id,password,first_name,last_name,date_of_birth,gender,address,contact_number) 
	values('drvallika@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm',' Jaddu','Dr Vallika','1991-07-15','Female','hyderabad',9959019263);

insert into Doctor(email_id,password,first_name,last_name,date_of_birth,gender,address,contact_number) 
	values('drchandhrakalasidagam@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','Sidagam','Dr Chandhrakala','1985-03-20','Female','hyderabad',9359753113);

insert into Doctor(email_id,password,first_name,last_name,date_of_birth,gender,address,contact_number) 
	values('dreswarreddy@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','Reddy','Dr Eswar','1981-11-28','Male','hyderabad',7799022533);

insert into Doctor(email_id,password,first_name,last_name,date_of_birth,gender,address,contact_number) 
	values('drcharanteja@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','koyya','Dr Charan','1988-10-14','Male','hyderabad',8885621839);

insert into Doctor(email_id,password,first_name,last_name,date_of_birth,gender,address,contact_number) 
	values('drpattabhikopparthi@gmail.com','{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm','Kopparthi','Dr Pattabhi','1983-10-01','Male','hyderabad',9133442576);

insert into patient(contact_number,address,first_name,last_name,gender,date_of_birth,marital_status,emergency_contact_number,email,blood_group,disease,date_visited,treatment_start_date,treatment_end_date,prescription,height,weight)
	values(7894561230,'hyderabad','Rakel','Ramesh','Male','1999-05-28','single',7894561231,'ramesh@gmail.com','O+','High BP','2022-11-28','2021-11-28','2023-11-28','Diuretics','170cms','75kgs');

insert into patient(contact_number,address,first_name,last_name,gender,date_of_birth,marital_status,emergency_contact_number,email,blood_group,disease,date_visited,treatment_start_date,treatment_end_date,prescription,height,weight)
	values(9977055233,'Rajamundry','Lavanya','Jampa','Female','1978-08-21','Maried',7093761871,'lavanyajampa@gmail.com','A-','Cardiomyopathy Prophlaxis','2022-10-12','2021-12-28','2023-10-21','Zinecard','165cms','82kgs');
	
insert into patient(contact_number,address,first_name,last_name,gender,date_of_birth,marital_status,emergency_contact_number,email,blood_group,disease,date_visited,treatment_start_date,treatment_end_date,prescription,height,weight)
	values(6281369288,'Bhimavaram','Kishore','Das','Male','1991-08-01','Maried',6303843351,'kishoredas@gmail.com','B+','Diabetes','2022-11-11','2020-06-14','2024-12-28','Lantus','178cms','70kgs');	
	
insert into patient(contact_number,address,first_name,last_name,gender,date_of_birth,marital_status,emergency_contact_number,email,blood_group,disease,date_visited,treatment_start_date,treatment_end_date,prescription,height,weight)
	values(9381058211,'Tanuku','Pushkar','Gupta','Male','1988-08-21','Maried',8381230113,'pushkargupta@gmail.com','A-','High Cholesterol','2022-11-28','2022-10-27','2025-10-16','Praluent','168cms','89kgs');	
	
insert into patient(contact_number,address,first_name,last_name,gender,date_of_birth,marital_status,emergency_contact_number,email,blood_group,disease,date_visited,treatment_start_date,treatment_end_date,prescription,height,weight)
	values(9993885348,'Rajamundry','Mahesh','Kankatala','Male','1998-08-21','single',9963549497,'Maheshk@gmail.com','AB-','Constipation','2022-10-20','2021-11-02','2023-07-11','MiraLax','180cms','83kgs');	
	
insert into patient(contact_number,address,first_name,last_name,gender,date_of_birth,marital_status,emergency_contact_number,email,blood_group,disease,date_visited,treatment_start_date,treatment_end_date,prescription,height,weight)
	values(9762534308,'Vijaywada','Atmaram','Rao','Male','1995-07-11','Maried',9893561731,'atmaram@gmail.com','A+','High BP','2022-11-22','2021-11-22','2023-06-20','Diuretics','175cms','75kgs');

insert into report(id,day,bp_lvl1,bp_lvl2,sugar_lvl,contact_number)
	values(1,'2022-01-01',140,90,99,7894561230);	