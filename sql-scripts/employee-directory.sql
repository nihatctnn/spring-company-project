CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `company` (`company_name`) VALUES
('Company1'),
('Company2'),
('Company3'),
('Company4'),
('Company5'),
('Company6'),
('Company7'),
('Company8'),
('Company9'),
('Company10'),
('Company11'),
('Company12'),
('Company13'),
('Company14'),
('Company15');


