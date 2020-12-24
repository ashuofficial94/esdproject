
create table Domains (
                         domain_id int not null auto_increment,
                         program varchar(15) not null,
                         batch int not null,
                         capacity int not null,
                         qualification varchar(255),
                         primary key (domain_id)
);

create table Students (
                          student_id int not null auto_increment,
                          roll_number varchar(20) not null unique,
                          first_name varchar(20) not null,
                          last_name varchar(20),
                          email varchar(50) not null unique,
                          photograph_path varchar(255),
                          cgpa float not null default 0.0,
                          total_credits int not null,
                          graduation_year int,
                          domain int,
                          PRIMARY KEY (student_id),
                          FOREIGN KEY (domain) references Domains(domain_id)
);

create table Departments  (
                              department_id int not null auto_increment,
                              name varchar(20) not null,
                              capacity int not null,
                              primary key (department_id)
);

create table Employees (
                           employee_id int not null auto_increment,
                           first_name varchar(20) not null,
                           last_name varchar(20),
                           email varchar(50) not null unique,
                           title varchar(20),
                           photograph_path varchar(255),
                           department int,
                           primary key (employee_id),
                           foreign key (department) references Departments(department_id)
);




