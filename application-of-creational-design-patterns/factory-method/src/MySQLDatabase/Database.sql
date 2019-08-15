/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.28-MariaDB : Database - paf4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`paf4` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `paf4`;

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `TableName` varchar(100) NOT NULL DEFAULT '',
  `Counter` int(11) DEFAULT '0',
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `counter` */

insert  into `counter`(`TableName`,`Counter`) values 
('DKIntervencija',21);

/*Table structure for table `dkintervencija` */

DROP TABLE IF EXISTS `dkintervencija`;

CREATE TABLE `dkintervencija` (
  `SifraIntervencije` int(11) NOT NULL DEFAULT '0',
  `JMBG` varchar(13) DEFAULT NULL,
  `SifraStomatologa` int(11) DEFAULT '0',
  `Usluga` varchar(20) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  PRIMARY KEY (`SifraIntervencije`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dkintervencija` */

insert  into `dkintervencija`(`SifraIntervencije`,`JMBG`,`SifraStomatologa`,`Usluga`,`Datum`) values 
(4,'125',0,'Pregled','2018-11-06'),
(11,'123',7,'Pregled','2018-11-06'),
(14,'17895',8,'Beljenje zuba','2018-11-06'),
(18,'137',9,'Vadjenje zuba','2018-11-06'),
(19,'0',12,'Vadjenje zuba','2018-11-06'),
(20,'0',17,'Skidanje kamenca','2018-11-06'),
(21,'158',0,'Popravka','2018-11-06');

/* Procedure structure for procedure `upgrade_database` */

/*!50003 DROP PROCEDURE IF EXISTS  `upgrade_database` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `upgrade_database`()
BEGIN
 DECLARE _count INT;
 SET _count = (  SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS  
 WHERE   TABLE_SCHEMA = 'PAF4' AND TABLE_NAME = 'Counter' AND COLUMN_NAME = 'TableName'); 
 IF _count = 0 THEN  ALTER TABLE Counter ADD COLUMN  `TableName` varchar(100)  ; END IF; 
   
 SET _count = (  SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS  
 WHERE   TABLE_SCHEMA = 'PAF4' AND TABLE_NAME = 'Counter' AND COLUMN_NAME = 'Counter'); 
 IF _count = 0 THEN  ALTER TABLE Counter ADD COLUMN  `Counter` int  DEFAULT 0; END IF;
SET _count = (  SELECT COUNT(*) FROM Counter);  
 IF _count = 0 THEN   insert  into `counter`(`TableName`,`Counter`) values  ('IspitnaPrijava',0); END IF; 
 
   
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
