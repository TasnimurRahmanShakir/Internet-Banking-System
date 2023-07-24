-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2023 at 04:36 AM
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
-- Table structure for table `deposit`
--

CREATE TABLE `deposit` (
  `accountNumber` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `otp` varchar(20) NOT NULL,
  `amount` double(30,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(2598600001, '', '2023-05-29 03:58:00', NULL, 2598600001, 2598600002, 'Fund-Transfer', 1000),
(2598600001, '', '2023-05-29 03:38:47', NULL, NULL, NULL, 'withdray by OTP', 500),
(2598600001, '', '2023-05-29 06:04:45', NULL, 2598600001, 2598600002, 'Fund-Transfer', 500),
(2598600001, '', '2023-05-29 06:06:50', NULL, 2598600001, 2598600002, 'Fund-Transfer', 500),
(2598600002, '', '2023-05-29 06:06:50', NULL, 2598600001, 2598600002, 'Fund-Received', 500),
(2598600002, '', '2023-05-31 03:33:26', NULL, 2598600002, 2598600001, 'Fund-Transfer', 500),
(2598600001, '', '2023-05-31 03:33:26', NULL, 2598600002, 2598600001, 'Fund-Received', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-05-31 13:39:58', NULL, 2598600001, 2598600002, 'Fund-Transfer', 1000),
(2598600002, NULL, '2023-05-31 13:39:58', NULL, 2598600001, 2598600002, 'Fund-Received', 1000),
(2598600002, 'Md. Kaised Mollick', '2023-06-02 05:31:17', NULL, 2598600002, 2598600001, 'Fund-Transfer', 500),
(2598600001, NULL, '2023-06-02 05:31:17', NULL, 2598600002, 2598600001, 'Fund-Received', 500),
(2598600002, 'Md. Kaised Mollick', '2023-06-02 06:37:42', NULL, NULL, NULL, 'Withdraw by OTP', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-06-02 06:43:52', NULL, NULL, NULL, 'Withdraw by OTP', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-06-02 13:14:38', '5040935924734229', NULL, NULL, 'Deposit by ATM', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-06-02 13:14:43', '5040935924734229', NULL, NULL, 'Withdraw by ATM', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-06-02 13:16:44', '5040935924734229', NULL, NULL, 'Withdraw by ATM FastCash', 500),
(2598600002, 'Md. Kaised Mollick', '2023-06-02 15:10:42', NULL, NULL, NULL, 'Withdraw by Agent', 500),
(2598600002, 'Md. Kaised Mollick', '2023-06-02 15:13:27', NULL, NULL, NULL, 'Withdraw by Agent', 500),
(2598600002, 'Md. Kaised Mollick', '2023-06-02 15:20:37', NULL, NULL, NULL, 'Deposit by Agent', 500),
(2598600003, 'Md. Abdullah Al Moin', '2023-06-17 05:54:55', NULL, NULL, NULL, 'Deposit by Agent', 1000),
(2598600003, 'Md. Abdullah Al Moin', '2023-06-17 06:00:13', NULL, NULL, NULL, 'Deposit by Agent', 1000),
(2598600003, 'Md. Abdullah Al Moin', '2023-06-17 06:08:40', NULL, NULL, NULL, 'Deposit by Agent', 1000),
(2598600003, 'null', '2023-06-17 06:09:11', NULL, NULL, NULL, 'Deposit by Agent', 0),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-06-17 08:08:51', NULL, NULL, NULL, 'Withdraw by Agent', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-06-17 09:02:38', '5040935924734229', NULL, NULL, 'Deposit by ATM', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-06-17 09:02:44', '5040935924734229', NULL, NULL, 'Withdraw by ATM FastCash', 500),
(2598600001, 'Md Tasnimur Rahman Shakir', '2023-06-17 09:02:52', '5040935924734229', NULL, NULL, 'Withdraw by ATM', 1000),
(2598600004, 'Naimul Hasan Nabil', '2023-06-17 10:30:15', NULL, NULL, NULL, 'Deposit by Agent', 1000),
(2598600004, 'Naimul Hasan Nabil', '2023-06-17 10:31:16', '5040935998630345 ', NULL, NULL, 'Deposit by ATM', 500);

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
(2598600001, 'Tasnim', '1234', '5040935924734229', '1234', 'Md Tasnimur Rahman Shakir', 'Md. Mahbubur Rahman', 'Mamotaj Nasrin', 'Jan 18, 2003', '01521549877', 'mtasnim051@gmail.com', '5111619069', 'Male', 'Unmarried', 'Islam', 'Student', 'HSC', '< 100,000', 'Barisal Patuakhali Patuakhali Sadar Town Kalikapur ', '8600', 'Studen Account', 'ATM Card Mobile Banking SMS Service Email Service Cheque E-Statement ', 26000, 'https://scontent.fdac11-2.fna.fbcdn.net/v/t39.30808-6/337530986_764300321734464_7404281818769262579_n.jpg?_nc_cat=109&cb=99be929b-3346023f&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=UkQkMCNlEVAAX8lKq62&_nc_ht=scontent.fdac11-2.fna&oh=00_AfBvbnCEhVnZiynaoNziHq2TndOX09Bd3a8grv0sEdB9Tw&oe=6497DE9C', 555),
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
-- Indexes for dumped tables
--

--
-- Indexes for table `deposit`
--
ALTER TABLE `deposit`
  ADD PRIMARY KEY (`accountNumber`);

--
-- Indexes for table `registerthree`
--
ALTER TABLE `registerthree`
  ADD UNIQUE KEY `userName` (`userName`);

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
  ADD UNIQUE KEY `userName` (`userName`);

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
  MODIFY `accountNumber` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2598600005;

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `example` ON SCHEDULE EVERY 2 MINUTE STARTS '2023-05-28 19:13:31' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM internet_banking_system.request WHERE createTime < (NOW() - INTERVAL 2 MINUTE)$$

CREATE DEFINER=`root`@`localhost` EVENT `One_month_old` ON SCHEDULE EVERY 1 MONTH STARTS '2023-05-29 12:10:03' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM internet_banking_system.transaction WHERE createTime < (NOW() - INTERVAL 1 MONTH)$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
