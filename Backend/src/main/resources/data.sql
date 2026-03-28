---------------------------------------------------
-- USERS (Managers + Employees)
---------------------------------------------------

INSERT INTO user
(name, email, contact_no, password, image_url, employee_id, role,
 department, manager_designation, manager_years_of_experience, office_location,
 emp_id, employee_designation, skills, employee_years_of_experience, joining_date,
 street, city, state, pin_code, country,
 provider, provider_id, email_verified,
 created_at, room_id)
VALUES
-- Managers
('Rahul Sharma','rahul@ems.com','9000000001','pass123',NULL,'M001','MANAGER',
 'Engineering','Senior Manager',10,'Bangalore',
 NULL,NULL,NULL,NULL,NULL,
 'MG Road','Bangalore','Karnataka','560001','India',
 'LOCAL',NULL,true,
 NOW(),NULL),

('Priya Mehta','priya@ems.com','9000000002','pass123',NULL,'M002','MANAGER',
 'Product','Product Manager',8,'Bangalore',
 NULL,NULL,NULL,NULL,NULL,
 'Whitefield','Bangalore','Karnataka','560066','India',
 'LOCAL',NULL,true,
 NOW(),NULL),

-- Employees
('Amit Das','amit@ems.com','9000000003','pass123',NULL,'E001','EMPLOYEE',
 NULL,NULL,NULL,NULL,
 'E001','Software Engineer','Java,Spring',3,'2023-06-01',
 'BTM','Bangalore','Karnataka','560076','India',
 'LOCAL',NULL,true,
 NOW(),NULL),

('Sneha Roy','sneha@ems.com','9000000004','pass123',NULL,'E002','EMPLOYEE',
 NULL,NULL,NULL,NULL,
 'E002','Frontend Developer','React,JS',2,'2023-07-15',
 'Marathahalli','Bangalore','Karnataka','560037','India',
 'LOCAL',NULL,true,
 NOW(),NULL),

('Arjun Singh','arjun@ems.com','9000000005','pass123',NULL,'E003','EMPLOYEE',
 NULL,NULL,NULL,NULL,
 'E003','Backend Developer','Node,Spring',4,'2022-09-10',
 'Indiranagar','Bangalore','Karnataka','560038','India',
 'LOCAL',NULL,true,
 NOW(),NULL);


---------------------------------------------------
-- ROOMS
---------------------------------------------------

INSERT INTO room
(room_name, description, room_code, manager_id, created_at)
VALUES
    ('Backend Team','Handles backend services','RM101',1,NOW()),
    ('Frontend Team','Handles UI development','RM102',2,NOW());


---------------------------------------------------
-- ASSIGN EMPLOYEES TO ROOMS
---------------------------------------------------

UPDATE user SET room_id = 1 WHERE employee_id IN ('E001','E003');
UPDATE user SET room_id = 2 WHERE employee_id = 'E002';


---------------------------------------------------
-- TASKS
---------------------------------------------------

INSERT INTO task
(title, description, due_date, room_id, manager_id)
VALUES
    ('Create Login API','Implement JWT authentication',DATE_ADD(NOW(), INTERVAL 5 DAY),1,1),

    ('Develop Dashboard UI','React dashboard page',DATE_ADD(NOW(), INTERVAL 7 DAY),2,2),

    ('API Documentation','Write swagger docs',DATE_ADD(NOW(), INTERVAL 3 DAY),1,1);


---------------------------------------------------
-- TASK ASSIGNMENTS (EmployeeToTask)
---------------------------------------------------

INSERT INTO employee_to_task
(task_id, employee_id, task_status, status_updation_time)
VALUES
    (1,3,'ASSIGNED',NOW()),
    (1,5,'ASSIGNED',NOW()),
    (2,4,'ASSIGNED',NOW()),
    (3,3,'PENDING',NOW());


---------------------------------------------------
-- LEAVE REQUESTS
---------------------------------------------------

INSERT INTO leave_request
(start_date,end_date,leave_status,applied_at,employee_id,manager_id,room_id)
VALUES
    ('2026-04-02','2026-04-04','REQUESTED',NOW(),3,1,1),

    ('2026-04-05','2026-04-06','GRANTED',NOW(),4,2,2);


---------------------------------------------------
-- ATTENDANCE
---------------------------------------------------

INSERT INTO attendance
(date,check_in_time,check_out_time,attendance_status,remarks,
 employee_id,manager_id,room_id)
VALUES
    (CURDATE(),NOW(),NULL,'PRESENT','On time',3,1,1),

    (CURDATE(),NOW(),NULL,'PRESENT','Working remotely',4,2,2);


---------------------------------------------------
-- NOTIFICATIONS
---------------------------------------------------

INSERT INTO notification
(message,is_read,created_at,notification_type,user_id)
VALUES
    ('New task assigned',false,NOW(),'INDIVIDUAL',3),

    ('Leave approved',false,NOW(),'INDIVIDUAL',4),

    ('Room announcement',false,NOW(),'ROOM',5);


---------------------------------------------------
-- ROOM EXIT REQUEST
---------------------------------------------------

INSERT INTO room_exit_request
(reason,requested_time,status,manager_id,employee_id,room_id)
VALUES
    ('Switching project',NOW(),'REQUESTED',1,5,1);