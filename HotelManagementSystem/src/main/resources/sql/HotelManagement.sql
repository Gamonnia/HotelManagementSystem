-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: HotelManagement
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Admin` (
  `adminAccount` int NOT NULL AUTO_INCREMENT,
  `adminPassword` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`adminAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=100006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` (`adminAccount`, `adminPassword`) VALUES (100001,'123456'),(100002,'123456'),(100003,'123456'),(100004,'123456'),(100005,'100004');
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CheckInRecord`
--

DROP TABLE IF EXISTS `CheckInRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CheckInRecord` (
  `checkInRecordID` int NOT NULL AUTO_INCREMENT,
  `customerID` int NOT NULL,
  `roomID` int NOT NULL,
  `checkInTime` datetime NOT NULL,
  `expectedCheckOut` datetime NOT NULL,
  `deposit` decimal(10,2) NOT NULL,
  `paymentAmount` decimal(10,2) NOT NULL,
  `staffID` int DEFAULT NULL,
  `recordTime` datetime NOT NULL,
  PRIMARY KEY (`checkInRecordID`),
  KEY `CustomerID` (`customerID`),
  KEY `RoomID` (`roomID`),
  KEY `StaffID` (`staffID`),
  CONSTRAINT `checkinrecord_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `Customer` (`customerID`),
  CONSTRAINT `checkinrecord_ibfk_2` FOREIGN KEY (`roomID`) REFERENCES `Room` (`roomID`),
  CONSTRAINT `checkinrecord_ibfk_3` FOREIGN KEY (`staffID`) REFERENCES `Staff` (`staffID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CheckInRecord`
--

LOCK TABLES `CheckInRecord` WRITE;
/*!40000 ALTER TABLE `CheckInRecord` DISABLE KEYS */;
INSERT INTO `CheckInRecord` (`checkInRecordID`, `customerID`, `roomID`, `checkInTime`, `expectedCheckOut`, `deposit`, `paymentAmount`, `staffID`, `recordTime`) VALUES (1,1,101,'2024-04-18 13:48:58','2024-04-19 12:49:00',40.00,200.00,100002,'2024-04-18 13:50:41'),(2,2,102,'2024-04-18 14:01:43','2024-04-21 14:01:44',120.00,600.00,100003,'2024-04-18 14:03:06'),(3,1,101,'2024-04-18 17:00:00','2024-04-18 20:00:00',40.00,300.00,100003,'2024-04-18 20:00:00'),(4,3,103,'2024-04-18 17:00:00','2024-04-18 20:00:00',40.00,300.00,100001,'2024-04-18 20:00:00'),(5,5,111,'2024-04-27 12:00:00','2024-04-27 22:00:00',0.00,0.00,100003,'2024-04-27 12:00:00');
/*!40000 ALTER TABLE `CheckInRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CheckOutRecord`
--

DROP TABLE IF EXISTS `CheckOutRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CheckOutRecord` (
  `checkOutRecordID` int NOT NULL AUTO_INCREMENT,
  `customerID` int NOT NULL,
  `roomID` int NOT NULL,
  `checkInTime` datetime NOT NULL,
  `checkOutTime` datetime NOT NULL,
  `staffID` int DEFAULT NULL,
  `recordTime` datetime DEFAULT NULL,
  PRIMARY KEY (`checkOutRecordID`),
  KEY `CustomerID` (`customerID`),
  KEY `RoomID` (`roomID`),
  KEY `StaffID` (`staffID`),
  CONSTRAINT `checkoutrecord_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `Customer` (`customerID`),
  CONSTRAINT `checkoutrecord_ibfk_2` FOREIGN KEY (`roomID`) REFERENCES `Room` (`roomID`),
  CONSTRAINT `checkoutrecord_ibfk_3` FOREIGN KEY (`staffID`) REFERENCES `Staff` (`staffID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CheckOutRecord`
--

LOCK TABLES `CheckOutRecord` WRITE;
/*!40000 ALTER TABLE `CheckOutRecord` DISABLE KEYS */;
INSERT INTO `CheckOutRecord` (`checkOutRecordID`, `customerID`, `roomID`, `checkInTime`, `checkOutTime`, `staffID`, `recordTime`) VALUES (1,1,101,'2024-04-18 17:00:00','2024-04-18 20:00:00',100003,'2024-04-18 20:00:00'),(2,1,101,'2024-04-18 17:00:00','2024-04-18 20:00:00',100003,'2024-04-18 20:00:00'),(3,1,101,'2024-04-18 17:00:00','2024-04-18 20:00:00',100003,'2024-04-18 20:00:00'),(4,1,101,'2024-04-18 17:00:00','2024-04-18 20:00:00',100003,'2024-04-18 20:00:00');
/*!40000 ALTER TABLE `CheckOutRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customer` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `customerName` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `IDNumber` varchar(18) COLLATE utf8mb4_general_ci NOT NULL,
  `phoneNumber` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` (`customerID`, `customerName`, `gender`, `IDNumber`, `phoneNumber`) VALUES (1,'Mr.D','Man','173646533747298798','19959118753'),(2,'Mrs.A','Woman','273748298467574893','18923421121'),(3,'ddd','Man','273748298467574893','17263547587'),(4,'ddd','Man','273748298467574893','17263547587'),(5,'FireLily','Woman','200048298467574800','35663547587');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Department`
--

DROP TABLE IF EXISTS `Department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Department` (
  `departmentID` int NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`departmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Department`
--

LOCK TABLES `Department` WRITE;
/*!40000 ALTER TABLE `Department` DISABLE KEYS */;
INSERT INTO `Department` (`departmentID`, `departmentName`) VALUES (1,'Front Office Department'),(2,'Housekeeping Department'),(3,'Security Department'),(4,'Personnel Department'),(5,'Finance Department'),(6,'Logistics Department'),(7,'Administration Department');
/*!40000 ALTER TABLE `Department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FinancialRecord`
--

DROP TABLE IF EXISTS `FinancialRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FinancialRecord` (
  `financialRecordID` int NOT NULL AUTO_INCREMENT,
  `incomeOrExpense` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`financialRecordID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FinancialRecord`
--

LOCK TABLES `FinancialRecord` WRITE;
/*!40000 ALTER TABLE `FinancialRecord` DISABLE KEYS */;
INSERT INTO `FinancialRecord` (`financialRecordID`, `incomeOrExpense`, `amount`, `date`) VALUES (1,'Staff Wage',310.00,'2024-04-18 13:42:20'),(2,'Human Resources',-8000.00,'2024-04-14 13:42:54');
/*!40000 ALTER TABLE `FinancialRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HotelProperty`
--

DROP TABLE IF EXISTS `HotelProperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HotelProperty` (
  `itemID` int NOT NULL AUTO_INCREMENT,
  `itemType` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `itemQuantity` int NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HotelProperty`
--

LOCK TABLES `HotelProperty` WRITE;
/*!40000 ALTER TABLE `HotelProperty` DISABLE KEYS */;
INSERT INTO `HotelProperty` (`itemID`, `itemType`, `itemQuantity`) VALUES (1,'Television Set',40),(2,'Air Conditioner',44);
/*!40000 ALTER TABLE `HotelProperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReservationRecord`
--

DROP TABLE IF EXISTS `ReservationRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ReservationRecord` (
  `reservationRecordID` int NOT NULL AUTO_INCREMENT,
  `customerName` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `customerPhone` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `roomTypeID` int NOT NULL,
  `expectedCheckIn` datetime NOT NULL,
  `staffID` int DEFAULT NULL,
  `recordTime` datetime NOT NULL,
  PRIMARY KEY (`reservationRecordID`),
  KEY `StaffID` (`staffID`),
  KEY `RoomTypeID` (`roomTypeID`),
  CONSTRAINT `reservationrecord_ibfk_1` FOREIGN KEY (`roomTypeID`) REFERENCES `RoomType` (`roomTypeID`),
  CONSTRAINT `reservationrecord_ibfk_2` FOREIGN KEY (`staffID`) REFERENCES `Staff` (`staffID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReservationRecord`
--

LOCK TABLES `ReservationRecord` WRITE;
/*!40000 ALTER TABLE `ReservationRecord` DISABLE KEYS */;
INSERT INTO `ReservationRecord` (`reservationRecordID`, `customerName`, `customerPhone`, `roomTypeID`, `expectedCheckIn`, `staffID`, `recordTime`) VALUES (1,'Mr.D','19959118753',1,'2024-04-18 13:32:27',100003,'2024-04-18 13:32:33'),(2,'adas','12312',3,'2024-04-27 12:00:00',100003,'2024-04-27 12:00:00');
/*!40000 ALTER TABLE `ReservationRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Room`
--

DROP TABLE IF EXISTS `Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Room` (
  `roomID` int NOT NULL,
  `roomTypeID` int NOT NULL,
  `roomStatusID` int NOT NULL,
  PRIMARY KEY (`roomID`),
  KEY `RoomStatusID` (`roomStatusID`),
  KEY `RoomTypeID` (`roomTypeID`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`roomTypeID`) REFERENCES `RoomType` (`roomTypeID`),
  CONSTRAINT `room_ibfk_2` FOREIGN KEY (`roomStatusID`) REFERENCES `RoomStatus` (`roomStatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
INSERT INTO `Room` (`roomID`, `roomTypeID`, `roomStatusID`) VALUES (101,1,1),(102,1,1),(103,1,1),(104,1,1),(105,1,1),(106,1,1),(107,2,1),(108,2,1),(109,2,1),(110,2,1),(111,3,1),(112,3,1),(113,3,1),(201,1,1);
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RoomStatus`
--

DROP TABLE IF EXISTS `RoomStatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RoomStatus` (
  `roomStatusID` int NOT NULL AUTO_INCREMENT,
  `roomStatusName` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`roomStatusID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RoomStatus`
--

LOCK TABLES `RoomStatus` WRITE;
/*!40000 ALTER TABLE `RoomStatus` DISABLE KEYS */;
INSERT INTO `RoomStatus` (`roomStatusID`, `roomStatusName`) VALUES (1,'Vacant'),(2,'Cleaning'),(3,'Occupied'),(4,'Reserved'),(5,'Out of Order'),(6,'To Be Cleaned'),(7,'To Be Reserved'),(8,'To Be Tidied'),(9,'To Be Inspected');
/*!40000 ALTER TABLE `RoomStatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RoomType`
--

DROP TABLE IF EXISTS `RoomType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RoomType` (
  `roomTypeID` int NOT NULL AUTO_INCREMENT,
  `roomTypeName` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `roomPrice` decimal(10,2) NOT NULL,
  `roomDeposit` decimal(10,2) NOT NULL,
  `roomSize` decimal(10,2) NOT NULL,
  PRIMARY KEY (`roomTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RoomType`
--

LOCK TABLES `RoomType` WRITE;
/*!40000 ALTER TABLE `RoomType` DISABLE KEYS */;
INSERT INTO `RoomType` (`roomTypeID`, `roomTypeName`, `roomPrice`, `roomDeposit`, `roomSize`) VALUES (1,'Single Room',200.00,40.00,37.00),(2,'Double Room',310.00,62.00,45.00),(3,'Triple Room',400.00,80.00,65.00);
/*!40000 ALTER TABLE `RoomType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Staff`
--

DROP TABLE IF EXISTS `Staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Staff` (
  `staffID` int NOT NULL AUTO_INCREMENT,
  `staffName` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `position` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  `departmentID` int NOT NULL,
  `gender` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`staffID`),
  KEY `Staff_ibfk_1` (`departmentID`),
  CONSTRAINT `Staff_Admin_adminAccount_fk` FOREIGN KEY (`staffID`) REFERENCES `Admin` (`adminAccount`),
  CONSTRAINT `Staff_ibfk_1` FOREIGN KEY (`departmentID`) REFERENCES `Department` (`departmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=100005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Staff`
--

LOCK TABLES `Staff` WRITE;
/*!40000 ALTER TABLE `Staff` DISABLE KEYS */;
INSERT INTO `Staff` (`staffID`, `staffName`, `position`, `salary`, `departmentID`, `gender`) VALUES (100001,'LiHong Wang','General Manager',8000.00,7,'Man'),(100002,'MingYang Zhang','Security Manager',8000.00,3,'Man'),(100003,'Bochao Duan','Receptionist',3000.00,1,'Man'),(100004,'kaf','Virtual Singer',10000.00,1,'Woman');
/*!40000 ALTER TABLE `Staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-03 20:44:35
