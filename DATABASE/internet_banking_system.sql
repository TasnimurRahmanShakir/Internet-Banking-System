-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2024 at 02:58 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `internet_banking_system`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteOldTransactions` ()   BEGIN
  DELETE FROM transaction
  WHERE date < DATE_SUB(NOW(), INTERVAL 1 MONTH);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `userName` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`userName`, `pass`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin_backup`
--

CREATE TABLE `adminlogin_backup` (
  `userName` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `adminlogin_backup`
--

INSERT INTO `adminlogin_backup` (`userName`, `pass`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `deposit`
--

CREATE TABLE `deposit` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `otp` varchar(20) NOT NULL,
  `amount` double(30,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `deposit`
--
DELIMITER $$
CREATE TRIGGER `after_deposit_delete` AFTER DELETE ON `deposit` FOR EACH ROW BEGIN
    INSERT INTO recycle_bin (accountNumber, name, otp, status, amount)
    VALUES (OLD.accountNumber, OLD.name, OLD.otp, 'Deposit', OLD.amount);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `deposit_backup`
--

CREATE TABLE `deposit_backup` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `otp` varchar(20) NOT NULL,
  `amount` double(30,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `recycle_bin`
--

CREATE TABLE `recycle_bin` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `otp` varchar(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `recycle_bin`
--

INSERT INTO `recycle_bin` (`accountNumber`, `name`, `otp`, `status`, `amount`) VALUES
(2598600001, 'Md Tasnimur Rahman Shakir', '3290', 'Deposit', 5000),
(2598600002, 'Md. Kaised Mollick', '1732', 'Withdraw', 500),
(2598600002, 'Md. Kaised Mollick', '116', 'Deposit', 500),
(2598600005, 'Maruf Hossain', '6175', 'Deposit', 500),
(2598600006, 'Kaised', '1525', 'Deposit', 500);

-- --------------------------------------------------------

--
-- Table structure for table `registerone`
--

CREATE TABLE `registerone` (
  `formNo` varchar(20) NOT NULL,
  `name` varchar(25) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `mname` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nid` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `maritalStatus` varchar(10) NOT NULL,
  `photo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registerone`
--

INSERT INTO `registerone` (`formNo`, `name`, `fname`, `mname`, `dob`, `contact`, `email`, `nid`, `gender`, `maritalStatus`, `photo`) VALUES
('7744', 'lll', 's', 's', 's', '01782433233', 'skk@.com', 's', 'Male', 'Married', 'null');

-- --------------------------------------------------------

--
-- Table structure for table `registerone_backup`
--

CREATE TABLE `registerone_backup` (
  `formNo` varchar(20) NOT NULL,
  `name` varchar(25) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `mname` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nid` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `maritalStatus` varchar(10) NOT NULL,
  `photo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `registerthree`
--

CREATE TABLE `registerthree` (
  `formNo` varchar(10) NOT NULL,
  `catagory` varchar(20) NOT NULL,
  `services` varchar(100) NOT NULL,
  `cardNumber` varchar(20) NOT NULL,
  `pinNumber` varchar(10) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `registerthree_backup`
--

CREATE TABLE `registerthree_backup` (
  `formNo` varchar(10) NOT NULL,
  `catagory` varchar(20) NOT NULL,
  `services` varchar(100) NOT NULL,
  `cardNumber` varchar(20) NOT NULL,
  `pinNumber` varchar(10) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `registertwo`
--

CREATE TABLE `registertwo` (
  `formNo` varchar(10) NOT NULL,
  `relegion` varchar(10) NOT NULL,
  `ocupation` varchar(10) NOT NULL,
  `education` varchar(20) NOT NULL,
  `income` varchar(15) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `postCode` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registertwo`
--

INSERT INTO `registertwo` (`formNo`, `relegion`, `ocupation`, `education`, `income`, `adress`, `postCode`) VALUES
('7744', 'Islam', 'Student', 'Non-Education', '< 100,000', 'www www ww ee ', '4444');

-- --------------------------------------------------------

--
-- Table structure for table `registertwo_backup`
--

CREATE TABLE `registertwo_backup` (
  `formNo` varchar(10) NOT NULL,
  `relegion` varchar(10) NOT NULL,
  `ocupation` varchar(10) NOT NULL,
  `education` varchar(20) NOT NULL,
  `income` varchar(15) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `postCode` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `otp` varchar(11) NOT NULL,
  `amount` double(30,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `request_backup`
--

CREATE TABLE `request_backup` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `otp` varchar(11) NOT NULL,
  `amount` double(30,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `cardNumber` varchar(20) DEFAULT NULL,
  `fromAccount` bigint(20) DEFAULT NULL,
  `toAccount` bigint(20) DEFAULT NULL,
  `discription` varchar(30) NOT NULL,
  `amount` double(30,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`accountNumber`, `name`, `date`, `cardNumber`, `fromAccount`, `toAccount`, `discription`, `amount`) VALUES
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:21:28', '5040935924734229', NULL, NULL, 'Deposit by ATM', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:21:41', '5040935924734229', NULL, NULL, 'Withdraw by ATM', 6000),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:21:47', '5040935924734229', NULL, NULL, 'Withdraw by ATM FastCash', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:22:00', '5040935924734229', NULL, NULL, 'Withdraw by ATM', 1000),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:22:08', '5040935924734229', NULL, NULL, 'Deposit by ATM', 1000),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:22:52', '5040935924734229', NULL, NULL, 'Deposit by ATM', 1000),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:24:27', '5040935924734229', NULL, NULL, 'Withdraw by ATM', 1000),
(2598600002, 'Md. Kaised Mollick', '2024-01-05 10:59:55', NULL, NULL, NULL, 'Withdraw by Agent', 500),
(2598600002, 'Md. Kaised Mollick', '2024-01-05 11:00:17', NULL, NULL, NULL, 'Deposit by Agent', 500),
(2598600005, 'Maruf Hossain', '2024-01-05 11:00:23', NULL, NULL, NULL, 'Deposit by Agent', 500),
(2598600002, 'null', '2024-01-05 11:00:39', NULL, NULL, NULL, 'Withdraw by Agent', 0),
(2598600005, 'null', '2024-01-05 11:00:51', NULL, NULL, NULL, 'Deposit by Agent', 0),
(2598600006, 'Kaised', '2024-01-05 11:13:58', NULL, NULL, NULL, 'Deposit by Agent', 500);

-- --------------------------------------------------------

--
-- Table structure for table `transaction_backup`
--

CREATE TABLE `transaction_backup` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `cardNumber` varchar(20) DEFAULT NULL,
  `fromAccount` bigint(20) DEFAULT NULL,
  `toAccount` bigint(20) DEFAULT NULL,
  `discription` varchar(30) NOT NULL,
  `amount` double(30,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction_backup`
--

INSERT INTO `transaction_backup` (`accountNumber`, `name`, `date`, `cardNumber`, `fromAccount`, `toAccount`, `discription`, `amount`) VALUES
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:21:28', '5040935924734229', NULL, NULL, 'Deposit by ATM', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:21:41', '5040935924734229', NULL, NULL, 'Withdraw by ATM', 6000),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:21:47', '5040935924734229', NULL, NULL, 'Withdraw by ATM FastCash', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:22:00', '5040935924734229', NULL, NULL, 'Withdraw by ATM', 1000),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:22:08', '5040935924734229', NULL, NULL, 'Deposit by ATM', 1000),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:22:52', '5040935924734229', NULL, NULL, 'Deposit by ATM', 1000),
(2598600001, 'Md Tasnimur Rahman Shakir', '2024-01-04 02:24:27', '5040935924734229', NULL, NULL, 'Withdraw by ATM', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `accountNumber` bigint(20) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `cardNumber` varchar(20) NOT NULL,
  `pinNumber` varchar(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `mname` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nid` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `maritalStatus` varchar(10) NOT NULL,
  `relegion` varchar(20) NOT NULL,
  `ocupation` varchar(20) NOT NULL,
  `education` varchar(20) NOT NULL,
  `income` varchar(20) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `postCode` varchar(10) NOT NULL,
  `catagory` varchar(20) NOT NULL,
  `services` varchar(100) NOT NULL,
  `balance` double DEFAULT 0,
  `photo` text NOT NULL,
  `point` int(11) NOT NULL DEFAULT 10
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`accountNumber`, `userName`, `pass`, `cardNumber`, `pinNumber`, `name`, `fname`, `mname`, `dob`, `contact`, `email`, `nid`, `gender`, `maritalStatus`, `relegion`, `ocupation`, `education`, `income`, `adress`, `postCode`, `catagory`, `services`, `balance`, `photo`, `point`) VALUES
(2598600001, 'Tasnim', '1234', '5040935924734229', '1234', 'Md Tasnimur Rahman Shakir', 'Md. Mahbubur Rahman', 'Mamotaj Nasrin', 'Jan 18, 2003', '01521549877', 'mtasnim051@gmail.com', '5111619069', 'Male', 'Unmarried', 'Islam', 'Student', 'HSC', '< 100,000', 'Barisal Patuakhali Patuakhali Sadar Town Kalikapur ', '8600', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service Cheque E-Statement ', 20000, 'https://scontent.fdac11-1.fna.fbcdn.net/v/t39.30808-6/323341052_1228253684736372_4637255627919182216_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=efb6e6&_nc_eui2=AeGqyLeAtECFCblPW2XCnyjKSELOGD3MNTRIQs4YPcw1NOhk9ZYbHafMYPv-U7v83DNKMhoZ_mZPowN6A3_638a_&_nc_ohc=UCURVxVM9JUAX_f4kqa&_nc_ht=scontent.fdac11-1.fna&oh=00_AfD2FE4RQ1-qxgn7Y_-RQ3Q039cmGJQRQaq6DpnFkJ-jTA&oe=659ACA71', 660),
(2598600002, 'kaised', '1234', '5040936084684617', '2661', 'Md. Kaised Mollick', 'Md. Masud Mollick', 'Rojina Begum', 'Dec 10, 2001', '01571400846', 'aa.r.kaaised.7596@gmial.com', '7814738485', 'Male', 'Unmarried', 'Islam', 'Student', 'HSC', '< 100,000', 'Khulna Jossore Obhay Nagar NoaPara ', '74600', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service Cheque E-Statement ', 9000, 'https://scontent.fdac11-1.fna.fbcdn.net/v/t39.30808-6/327172558_6432857773410384_197114375625078343_n.jpg?_nc_cat=102&cb=99be929b-3346023f&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=Nq_3qfXSLCYAX-K1Ojh&_nc_ht=scontent.fdac11-1.fna&oh=00_AfCa5WRlu2X_gPdLSnFacrALDNAEt7Tbx50EwSZ9DigHXA&oe=6497852A', 330),
(2598600003, 'Moin', '1234', '5040936024725325', '8614', 'Md. Abdullah Al Moin', 'Md. Tipu Sultan', 'Shima Begum', 'Jun 13, 2002', '01729702915', 'midul7714@gmil.com', '0', 'Male', 'Unmarried', 'Islam', 'Student', 'Non-Education', '< 100,000', 'Khulna Jashore Baghar para khajura ', '7460', 'Studen Account', 'ATM Card Mobile Banking Email Service Cheque ', 1000, 'https://scontent.fdac11-2.fna.fbcdn.net/v/t39.30808-6/280290750_132005429424305_7028968468491888238_n.jpg?_nc_cat=110&cb=99be929b-3346023f&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=FRU7FHVLia0AX-pDprN&_nc_ht=scontent.fdac11-2.fna&oh=00_AfBLlSC_kjwEYpa7Bb8IyyDmPicw3Vxt4VYE6F8Lk1ghkA&oe=64977795', 60),
(2598600004, 'Nabil', 'nabil1234', '5040935998630345', '2256', 'Naimul Hasan Nabil', 'Romij Uddin', 'Lovly Begum', 'May 15, 2003', '01833540907', 'naimulhasannabil@gmail.com', '8710373138', 'Male', 'Unmarried', 'Islam', 'Student', 'HSC', '< 100,000', 'Dhaka Munsiganj Gazaria Boroikandhi Baterchar , Mollah Bari ', '1510', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service E-Statement ', 1500, 'https://scontent.fdac11-2.fna.fbcdn.net/v/t39.30808-6/349171798_634645785193539_8578400129342846585_n.jpg?_nc_cat=105&cb=99be929b-3346023f&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=F6c02yCRFNAAX8_z31R&_nc_ht=scontent.fdac11-2.fna&oh=00_AfDRRgYb-lLYbRVRkNrOnM5eWKXC3usl51ytGQcHFQxSvw&oe=649759FD', 35),
(2598600005, 'maruf', '1234', '5040935985565303', '7899', 'Maruf Hossain', 'Anisur Rahman', 'Khaleda Parvin', 'Mar 19, 2001', '01912344231', 'maruf.bshs@gmail.com', '765442332', 'Male', 'Married', 'Islam', 'Student', 'HSC', '< 100,000', 'Khulna Satkhira Tala Kanchan ', '7890', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service Cheque E-Statement ', 500, 'null', 30),
(2598600006, 'kaisedgreen', '1234', '5040936039560794', '6887', 'Kaised', 'masud mollick', 'rojina Begum', 'Jan 11, 2001', '01794368824', 'a.r.kaised@gmail.com', '7878888', 'Male', 'Unmarried', 'Islam', 'Student', 'HSC', '< 100,000', 'khulna khulna khulna kanchan ', '7888', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service Cheque E-Statement ', 500, 'null', 20);

-- --------------------------------------------------------

--
-- Table structure for table `userdetails_backup`
--

CREATE TABLE `userdetails_backup` (
  `accountNumber` bigint(20) NOT NULL DEFAULT 0,
  `userName` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `cardNumber` varchar(20) NOT NULL,
  `pinNumber` varchar(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `mname` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nid` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `maritalStatus` varchar(10) NOT NULL,
  `relegion` varchar(20) NOT NULL,
  `ocupation` varchar(20) NOT NULL,
  `education` varchar(20) NOT NULL,
  `income` varchar(20) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `postCode` varchar(10) NOT NULL,
  `catagory` varchar(20) NOT NULL,
  `services` varchar(100) NOT NULL,
  `balance` double DEFAULT 0,
  `photo` text NOT NULL,
  `point` int(11) NOT NULL DEFAULT 10
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userdetails_backup`
--

INSERT INTO `userdetails_backup` (`accountNumber`, `userName`, `pass`, `cardNumber`, `pinNumber`, `name`, `fname`, `mname`, `dob`, `contact`, `email`, `nid`, `gender`, `maritalStatus`, `relegion`, `ocupation`, `education`, `income`, `adress`, `postCode`, `catagory`, `services`, `balance`, `photo`, `point`) VALUES
(2598600001, 'Tasnim', '1234', '5040935924734229', '1234', 'Md Tasnimur Rahman Shakir', 'Md. Mahbubur Rahman', 'Mamotaj Nasrin', 'Jan 18, 2003', '01521549877', 'mtasnim051@gmail.com', '5111619069', 'Male', 'Unmarried', 'Islam', 'Student', 'HSC', '< 100,000', 'Barisal Patuakhali Patuakhali Sadar Town Kalikapur ', '8600', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service Cheque E-Statement ', 20000, 'https://scontent.fdac11-1.fna.fbcdn.net/v/t39.30808-6/323341052_1228253684736372_4637255627919182216_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=efb6e6&_nc_eui2=AeGqyLeAtECFCblPW2XCnyjKSELOGD3MNTRIQs4YPcw1NOhk9ZYbHafMYPv-U7v83DNKMhoZ_mZPowN6A3_638a_&_nc_ohc=UCURVxVM9JUAX_f4kqa&_nc_ht=scontent.fdac11-1.fna&oh=00_AfD2FE4RQ1-qxgn7Y_-RQ3Q039cmGJQRQaq6DpnFkJ-jTA&oe=659ACA71', 660),
(2598600002, 'kaised', '1234', '5040936084684617', '2661', 'Md. Kaised Mollick', 'Md. Masud Mollick', 'Rojina Begum', 'Dec 10, 2001', '01571400846', 'aa.r.kaaised.7596@gmial.com', '7814738485', 'Male', 'Unmarried', 'Islam', 'Student', 'HSC', '< 100,000', 'Khulna Jossore Obhay Nagar NoaPara ', '74600', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service Cheque E-Statement ', 9000, 'https://scontent.fdac11-1.fna.fbcdn.net/v/t39.30808-6/327172558_6432857773410384_197114375625078343_n.jpg?_nc_cat=102&cb=99be929b-3346023f&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=Nq_3qfXSLCYAX-K1Ojh&_nc_ht=scontent.fdac11-1.fna&oh=00_AfCa5WRlu2X_gPdLSnFacrALDNAEt7Tbx50EwSZ9DigHXA&oe=6497852A', 300),
(2598600003, 'Moin', '1234', '5040936024725325', '8614', 'Md. Abdullah Al Moin', 'Md. Tipu Sultan', 'Shima Begum', 'Jun 13, 2002', '01729702915', 'midul7714@gmil.com', '0', 'Male', 'Unmarried', 'Islam', 'Student', 'Non-Education', '< 100,000', 'Khulna Jashore Baghar para khajura ', '7460', 'Studen Account', 'ATM Card Mobile Banking Email Service Cheque ', 1000, 'https://scontent.fdac11-2.fna.fbcdn.net/v/t39.30808-6/280290750_132005429424305_7028968468491888238_n.jpg?_nc_cat=110&cb=99be929b-3346023f&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=FRU7FHVLia0AX-pDprN&_nc_ht=scontent.fdac11-2.fna&oh=00_AfBLlSC_kjwEYpa7Bb8IyyDmPicw3Vxt4VYE6F8Lk1ghkA&oe=64977795', 60),
(2598600004, 'Nabil', 'nabil1234', '5040935998630345', '2256', 'Naimul Hasan Nabil', 'Romij Uddin', 'Lovly Begum', 'May 15, 2003', '01833540907', 'naimulhasannabil@gmail.com', '8710373138', 'Male', 'Unmarried', 'Islam', 'Student', 'HSC', '< 100,000', 'Dhaka Munsiganj Gazaria Boroikandhi Baterchar , Mollah Bari ', '1510', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service E-Statement ', 1500, 'https://scontent.fdac11-2.fna.fbcdn.net/v/t39.30808-6/349171798_634645785193539_8578400129342846585_n.jpg?_nc_cat=105&cb=99be929b-3346023f&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=F6c02yCRFNAAX8_z31R&_nc_ht=scontent.fdac11-2.fna&oh=00_AfDRRgYb-lLYbRVRkNrOnM5eWKXC3usl51ytGQcHFQxSvw&oe=649759FD', 35);

-- --------------------------------------------------------

--
-- Table structure for table `withdraw`
--

CREATE TABLE `withdraw` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `otp` varchar(10) NOT NULL,
  `amount` double(30,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `withdraw`
--

INSERT INTO `withdraw` (`accountNumber`, `name`, `otp`, `amount`) VALUES
(2598600006, 'Kaised', '1639', 500);

--
-- Triggers `withdraw`
--
DELIMITER $$
CREATE TRIGGER `after_withdraw_delete` AFTER DELETE ON `withdraw` FOR EACH ROW BEGIN
    INSERT INTO recycle_bin (accountNumber, name, otp, status, amount)
    VALUES (OLD.accountNumber, OLD.name, OLD.otp, 'Withdraw', OLD.amount);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `withdraw_backup`
--

CREATE TABLE `withdraw_backup` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `otp` varchar(10) NOT NULL,
  `amount` double(30,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminlogin`
--
ALTER TABLE `adminlogin`
  ADD PRIMARY KEY (`userName`);

--
-- Indexes for table `deposit`
--
ALTER TABLE `deposit`
  ADD PRIMARY KEY (`accountNumber`);

--
-- Indexes for table `recycle_bin`
--
ALTER TABLE `recycle_bin`
  ADD KEY `accountNumber` (`accountNumber`);

--
-- Indexes for table `registerone`
--
ALTER TABLE `registerone`
  ADD PRIMARY KEY (`formNo`);

--
-- Indexes for table `registerthree`
--
ALTER TABLE `registerthree`
  ADD UNIQUE KEY `userName` (`userName`),
  ADD KEY `registerthree` (`formNo`);

--
-- Indexes for table `registertwo`
--
ALTER TABLE `registertwo`
  ADD KEY `registertwo` (`formNo`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`accountNumber`);

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`accountNumber`),
  ADD UNIQUE KEY `userName` (`userName`),
  ADD UNIQUE KEY `uc_cardNumber` (`cardNumber`),
  ADD UNIQUE KEY `uc_email` (`email`),
  ADD UNIQUE KEY `uc_nid` (`nid`),
  ADD UNIQUE KEY `uc_contact` (`contact`);

--
-- Indexes for table `withdraw`
--
ALTER TABLE `withdraw`
  ADD PRIMARY KEY (`accountNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `accountNumber` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2598600007;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `deposit`
--
ALTER TABLE `deposit`
  ADD CONSTRAINT `accountNumber` FOREIGN KEY (`accountNumber`) REFERENCES `userdetails` (`accountNumber`) ON DELETE CASCADE;

--
-- Constraints for table `recycle_bin`
--
ALTER TABLE `recycle_bin`
  ADD CONSTRAINT `recycle_bin_ibfk_1` FOREIGN KEY (`accountNumber`) REFERENCES `userdetails` (`accountNumber`) ON DELETE CASCADE;

--
-- Constraints for table `registerthree`
--
ALTER TABLE `registerthree`
  ADD CONSTRAINT `registerthree` FOREIGN KEY (`formNo`) REFERENCES `registerone` (`formNo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `registertwo`
--
ALTER TABLE `registertwo`
  ADD CONSTRAINT `registertwo` FOREIGN KEY (`formNo`) REFERENCES `registerone` (`formNo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `withdraw`
--
ALTER TABLE `withdraw`
  ADD CONSTRAINT `withdraw` FOREIGN KEY (`accountNumber`) REFERENCES `userdetails` (`accountNumber`) ON DELETE CASCADE;

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `example` ON SCHEDULE EVERY 2 MINUTE STARTS '2023-05-28 19:13:31' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM internet_banking_system.request WHERE createTime < (NOW() - INTERVAL 2 MINUTE)$$

CREATE DEFINER=`root`@`localhost` EVENT `event_DeleteOldTransactions` ON SCHEDULE EVERY 1 DAY STARTS '2023-12-11 11:42:25' ON COMPLETION NOT PRESERVE ENABLE DO CALL DeleteOldTransactions()$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
