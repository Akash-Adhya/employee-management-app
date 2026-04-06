--------------------------------------------------
-- USER
--------------------------------------------------
INSERT INTO user
(id,name,email,contact_no,password,dob,account_status,image_url,employee_id,role,
 street,city,state,pin_code,country,
 provider,provider_id,email_verified,email_verification_token,email_verification_token_expiry,
 reset_password_token,reset_password_expiry,
 created_at)
VALUES

    (1,'Rahul Sharma','rahul@ems.com','9000000001','pass123','1990-05-10','ACTIVE',NULL,'EMP001','MANAGER',
     'BTM Layout','Bangalore','Karnataka','560076','India',
     'LOCAL',NULL,true,NULL,NULL,NULL,NULL,NOW()),

    (2,'Amit Das','amit@ems.com','9000000002','pass123','1998-03-15','ACTIVE',NULL,'EMP002','EMPLOYEE',
     'Whitefield','Bangalore','Karnataka','560066','India',
     'LOCAL',NULL,true,NULL,NULL,NULL,NULL,NOW()),

    (3,'Priya Singh','priya@ems.com','9000000003','pass123','1997-07-21','ACTIVE',NULL,'EMP003','EMPLOYEE',
     'Indiranagar','Bangalore','Karnataka','560038','India',
     'LOCAL',NULL,true,NULL,NULL,NULL,NULL,NOW());


--------------------------------------------------
-- MANAGER
--------------------------------------------------
INSERT INTO manager
(id,department,manager_designation,manager_years_of_experience,office_location)
VALUES
    (1,'IT','Engineering Manager',10,'Bangalore');


--------------------------------------------------
-- ROOM
--------------------------------------------------
INSERT INTO room
(id,room_name,description,is_locked,room_code,manager_id,created_at)
VALUES
    (1,'Backend Team','Handles Spring Boot APIs',false,'ROOM001',1,NOW()),

    (2,'Frontend Team','Handles React UI',false,'ROOM002',1,NOW());


--------------------------------------------------
-- EMPLOYEE
--------------------------------------------------
INSERT INTO employee
(id,employee_designation,skills,employee_years_of_experience,joining_date,office_location,room_id)
VALUES

    (2,'Software Engineer','Java, Spring Boot',3,'2022-06-01','Bangalore',1),

    (3,'Frontend Developer','React, JavaScript',2,'2023-01-15','Bangalore',2);


--------------------------------------------------
-- TASK
--------------------------------------------------
INSERT INTO task
(id,title,description,due_date,room_id,manager_id)
VALUES

    (1,'Develop Auth API','JWT login system',NOW(),1,1),

    (2,'Build Dashboard UI','Create responsive dashboard',NOW(),2,1);


--------------------------------------------------
-- EMPLOYEE TASK MAP
--------------------------------------------------
INSERT INTO employee_to_task
(id,task_id,employee_id,task_status,status_updation_time)
VALUES

    (1,1,2,'ASSIGNED',NOW()),

    (2,2,3,'ASSIGNED',NOW());


--------------------------------------------------
-- LEAVE REQUEST
--------------------------------------------------
INSERT INTO leave_request
(id,title,description,category,start_date,end_date,leave_status,
 applied_at,status_updated_at,
 employee_id,manager_id,room_id)
VALUES

    (1,'Medical Leave','Fever and rest','SICK_LEAVE',
     '2026-04-10','2026-04-12','REQUESTED',
     NOW(),NULL,
     2,1,1);


--------------------------------------------------
-- ATTENDANCE
--------------------------------------------------
INSERT INTO attendance
(id,date,check_in_time,check_out_time,attendance_status,remarks,
 employee_id,manager_id,room_id)
VALUES

    (1,'2026-04-05',NOW(),NOW(),'PRESENT','On time',2,1,1),

    (2,'2026-04-05',NOW(),NOW(),'PRESENT','Completed UI tasks',3,1,2);


--------------------------------------------------
-- NOTIFICATION
--------------------------------------------------
INSERT INTO notification
(id,message,is_read,created_at,notification_type,user_id)
VALUES

    (1,'New Task Assigned',false,NOW(),'INDIVIDUAL',2),

    (2,'Room Announcement',false,NOW(),'ROOM',3);


--------------------------------------------------
-- ROOM EXIT REQUEST
--------------------------------------------------
INSERT INTO room_exit_request
(id,reason,requested_time,status,manager_id,employee_id,room_id)
VALUES

    (1,'Doctor Appointment',NOW(),'REQUESTED',1,2,1);