

CREATE DATABASE Jianyi_shop CHARSET = UTF8;
USE Jianyi_shop;

DROP TABLE IF EXISTS USER;

CREATE TABLE USER(
	 id INT PRIMARY KEY AUTO_INCREMENT ,
	 user_name VARCHAR(21) NOT NULL, -- 用户名字
	 NAME VARCHAR(21) NOT NULL,
	 user_pwd VARCHAR(20) NOT NULL, -- 密码
	 user_sex VARCHAR(1) NOT NULL, -- T代表男性 F 代表女性
	 user_birth  DATETIME , -- 生日
	 user_idenity_code VARCHAR(60) , -- 扩充描述
	 user_email VARCHAR(20), -- 邮箱
	 user_phone VARCHAR(11) NOT NULL, -- 电话
	 user_address VARCHAR(200) NOT NULL, -- 地址
	 user_status DECIMAL(6,0) NOT NULL  -- 1 代表普通用户 2代表管理员
);

-- 测试数据
INSERT INTO USER() VALUES
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1),
(NULL,'王v啊','Jian','1234','f','2020-1-1',NULL,'1234132@q','111111','北京',1);
SELECT * FROM USER ;

-- 查询语句 对应JavaBean
SELECT  id id,              
NAME   NAME,          
user_address  userAddress,   
user_birth  userBirth,     
user_email  userEmail,     
user_idenity_code userIdenityCode,
user_name   userName,     
user_phone   userPone,    
user_pwd  userPwd,       
user_sex  userSex,       
user_status  userStatus    
 FROM USER WHERE 1 = 1   AND user_name LIKE '%Jianyi%' LIMIT 0 , 5 ;

SELECT  * FROM USER;