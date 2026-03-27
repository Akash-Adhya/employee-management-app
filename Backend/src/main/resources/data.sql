
------------------------------------
-- USERS (2 MANAGERS + 8 EMPLOYEES)
------------------------------------

INSERT INTO user
(name,email,contact_no,password,image_url,employee_id,role,
 department,manager_designation,manager_years_of_experience,office_location,
 emp_id,employee_designation,skills,employee_years_of_experience,joining_date,
 street,city,state,pin_code,country,
 provider,provider_id,email_verified)
VALUES

    ('Rahul Verma','rahul.manager@mail.com','9000000001','pass',NULL,'EMP001','MANAGER',
     'Engineering','Team Lead',8,'Bangalore',
     NULL,NULL,NULL,NULL,NULL,
     'MG Road','Bangalore','Karnataka','560001','India',
     'LOCAL',NULL,true),

    ('Sneha Iyer','sneha.manager@mail.com','9000000002','pass',NULL,'EMP002','MANAGER',
     'HR','HR Manager',10,'Mumbai',
     NULL,NULL,NULL,NULL,NULL,
     'Andheri','Mumbai','Maharashtra','400001','India',
     'LOCAL',NULL,true),

    ('Amit Das','amit@mail.com','9000000003','pass',NULL,'EMP003','EMPLOYEE',
     NULL,NULL,NULL,NULL,
     'E101','Software Engineer','Java,Spring Boot',3,'2023-01-10',
     'Sector 5','Kolkata','West Bengal','700091','India',
     'LOCAL',NULL,true),

    ('Priya Singh','priya@mail.com','9000000004','pass',NULL,'EMP004','EMPLOYEE',
     NULL,NULL,NULL,NULL,
     'E102','Frontend Developer','React,JavaScript',2,'2023-03-12',
     'Salt Lake','Kolkata','West Bengal','700064','India',
     'LOCAL',NULL,true),

    ('Rohan Gupta','rohan@mail.com','9000000005','pass',NULL,'EMP005','EMPLOYEE',
     NULL,NULL,NULL,NULL,
     'E103','Backend Developer','Spring Boot,SQL',4,'2022-05-01',
     'BTM','Bangalore','Karnataka','560076','India',
     'LOCAL',NULL,true),

    ('Neha Kapoor','neha@mail.com','9000000006','pass',NULL,'EMP006','EMPLOYEE',
     NULL,NULL,NULL,NULL,
     'E104','QA Engineer','Testing,Selenium',3,'2022-07-15',
     'Whitefield','Bangalore','Karnataka','560066','India',
     'LOCAL',NULL,true),

    ('Vikram Patel','vikram@mail.com','9000000007','pass',NULL,'EMP007','EMPLOYEE',
     NULL,NULL,NULL,NULL,
     'E105','DevOps Engineer','Docker,AWS',5,'2021-09-20',
     'Hinjewadi','Pune','Maharashtra','411057','India',
     'LOCAL',NULL,true),

    ('Anjali Mehta','anjali@mail.com','9000000008','pass',NULL,'EMP008','EMPLOYEE',
     NULL,NULL,NULL,NULL,
     'E106','UI Designer','Figma,UIUX',2,'2023-11-01',
     'Baner','Pune','Maharashtra','411045','India',
     'LOCAL',NULL,true),

    ('Karan Shah','karan@mail.com','9000000009','pass',NULL,'EMP009','EMPLOYEE',
     NULL,NULL,NULL,NULL,
     'E107','Data Analyst','SQL,Python',4,'2022-04-10',
     'Electronic City','Bangalore','Karnataka','560100','India',
     'LOCAL',NULL,true),

    ('Meera Nair','meera@mail.com','9000000010','pass',NULL,'EMP010','EMPLOYEE',
     NULL,NULL,NULL,NULL,
     'E108','ML Engineer','Python,Machine Learning',3,'2023-02-14',
     'Koramangala','Bangalore','Karnataka','560034','India',
     'LOCAL',NULL,true);



------------------------------------
-- ROOMS
------------------------------------

INSERT INTO room(room_name,description,room_code,manager_id)
SELECT 'Backend Team','Handles Spring Boot APIs','ROOM101',id
FROM user WHERE employee_id='EMP001';

INSERT INTO room(room_name,description,room_code,manager_id)
SELECT 'Frontend Team','Handles React UI','ROOM102',id
FROM user WHERE employee_id='EMP002';



------------------------------------
-- ASSIGN EMPLOYEES TO ROOM
------------------------------------

UPDATE user
SET room_id = (SELECT id FROM room WHERE room_code='ROOM101')
WHERE employee_id IN ('EMP003','EMP005','EMP007','EMP009');

UPDATE user
SET room_id = (SELECT id FROM room WHERE room_code='ROOM102')
WHERE employee_id IN ('EMP004','EMP006','EMP008','EMP010');



------------------------------------
-- TASKS
------------------------------------

INSERT INTO task(title,description,due_date,task_status,status_last_updation_time,room_id,employee_id,manager_id)
SELECT
    'Build Login API',
    'JWT Authentication',
    '2026-04-01 18:00:00',
    'ASSIGNED',
    NOW(),
    r.id,
    e.id,
    m.id
FROM room r,user e,user m
WHERE r.room_code='ROOM101'
  AND e.employee_id='EMP003'
  AND m.employee_id='EMP001';



INSERT INTO task(title,description,due_date,task_status,status_last_updation_time,room_id,employee_id,manager_id)
SELECT
    'Create Dashboard UI',
    'React dashboard',
    '2026-04-02 18:00:00',
    'PENDING',
    NOW(),
    r.id,
    e.id,
    m.id
FROM room r,user e,user m
WHERE r.room_code='ROOM102'
  AND e.employee_id='EMP004'
  AND m.employee_id='EMP002';



------------------------------------
-- LEAVE REQUEST
------------------------------------

INSERT INTO leave_request(start_date,end_date,leave_status,applied_at,employee_id,manager_id,room_id)
SELECT
    '2026-04-10',
    '2026-04-12',
    'REQUESTED',
    NOW(),
    e.id,
    m.id,
    r.id
FROM user e,user m,room r
WHERE e.employee_id='EMP003'
  AND m.employee_id='EMP001'
  AND r.room_code='ROOM101';



------------------------------------
-- ROOM EXIT REQUEST
------------------------------------

INSERT INTO room_exit_request(reason,requested_time,status,employee_id,manager_id,room_id)
SELECT
    'Switching project',
    NOW(),
    'REQUESTED',
    e.id,
    m.id,
    r.id
FROM user e,user m,room r
WHERE e.employee_id='EMP004'
  AND m.employee_id='EMP002'
  AND r.room_code='ROOM102';



------------------------------------
-- NOTIFICATIONS
------------------------------------

INSERT INTO notification(message,is_read,created_at,notification_type,user_id)
SELECT
    'Task assigned to you',
    false,
    NOW(),
    'INDIVIDUAL',
    id
FROM user
WHERE employee_id='EMP003';



INSERT INTO notification(message,is_read,created_at,notification_type,user_id)
SELECT
    'Leave request submitted',
    false,
    NOW(),
    'INDIVIDUAL',
    id
FROM user
WHERE employee_id='EMP004';



------------------------------------
-- ATTENDANCE
------------------------------------

INSERT INTO attendance(date,check_in_time,check_out_time,attendance_status,remarks,employee_id,manager_id,room_id)
SELECT
    CURDATE(),
    NOW(),
    NOW(),
    'PRESENT',
    'On time',
    e.id,
    m.id,
    r.id
FROM user e,user m,room r
WHERE e.employee_id='EMP003'
  AND m.employee_id='EMP001'
  AND r.room_code='ROOM101';



INSERT INTO attendance(date,check_in_time,check_out_time,attendance_status,remarks,employee_id,manager_id,room_id)
SELECT
    CURDATE(),
    NOW(),
    NOW(),
    'HALF_DAY',
    'Doctor appointment',
    e.id,
    m.id,
    r.id
FROM user e,user m,room r
WHERE e.employee_id='EMP004'
  AND m.employee_id='EMP002'
  AND r.room_code='ROOM102';
