
CREATE DATABASE `mybatis` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

Create Table: CREATE TABLE `t_car` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `car_num` varchar(50) DEFAULT NULL,
    `brand` varchar(50) DEFAULT NULL,
    `guide_price` decimal(10,2) DEFAULT NULL,
    `produce_time` date DEFAULT NULL,
    `car_type` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Create Table: CREATE TABLE `t_account` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `actno` varchar(50) DEFAULT NULL,
    `balance` decimal(10,2) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


Create Table: CREATE TABLE `t_log_20250311` (
    `id` int NOT NULL AUTO_INCREMENT,
    `log` varchar(50) DEFAULT NULL,
    `time` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Create Table: CREATE TABLE `t_log_20250312` (
    `id` int NOT NULL AUTO_INCREMENT,
    `log` varchar(50) DEFAULT NULL,
    `time` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
insert into t_log_20250311 (log,time) values ('log_20250311','tttttt');
insert into t_log_20250312 (log,time) values ('log_20250312','rrrrrr');

Create Table: CREATE TABLE `t_student` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    `age` int DEFAULT NULL,
    `height` double DEFAULT NULL,
    `birth` date DEFAULT NULL,
    `sex` char(4) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `t_clazz` (
   `cid` int NOT NULL AUTO_INCREMENT,
   `cname` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `t_stu` (
   `sid` int NOT NULL AUTO_INCREMENT,
   `sname` varchar(50) DEFAULT NULL,
   `cid` int DEFAULT NULL,
                         PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into t_clazz(cname) values ('AA'),('BB'),('CC');
insert into t_stu (sname,cid) values ('zhang3',1),('li4',1),('wang5',1),('zhao6',2),('tian7',2),('哪吒',3);
