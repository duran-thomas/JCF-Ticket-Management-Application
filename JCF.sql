-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 27, 2017 at 05:56 PM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `JCF`
--

-- --------------------------------------------------------

--
-- Table structure for table `commuter`
--

CREATE TABLE `commuter` (
  `TRN` varchar(15) NOT NULL,
  `FirstName` varchar(15) NOT NULL,
  `LastName` varchar(15) NOT NULL,
  `PlateNumber` varchar(10) NOT NULL,
  `DOB` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commuter`
--

INSERT INTO `commuter` (`TRN`, `FirstName`, `LastName`, `PlateNumber`, `DOB`) VALUES
('122939620', 'Carlos', 'Burke', '2026 HD', NULL),
('123', 'Random', 'Name', '1234DC', NULL),
('123456', 'Duran', 'Thomas', '1234DC', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `commuter_logins`
--

CREATE TABLE `commuter_logins` (
  `TRN` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commuter_logins`
--

INSERT INTO `commuter_logins` (`TRN`, `Password`) VALUES
('122939620', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `officer`
--

CREATE TABLE `officer` (
  `Badge` int(10) NOT NULL,
  `FirstName` varchar(15) NOT NULL,
  `LastName` varchar(15) NOT NULL,
  `Precinct` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `officer`
--

INSERT INTO `officer` (`Badge`, `FirstName`, `LastName`, `Precinct`) VALUES
(5000, 'Barney', 'Rubble', 'Kingston');

-- --------------------------------------------------------

--
-- Table structure for table `officer_logins`
--

CREATE TABLE `officer_logins` (
  `Badge` int(10) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `officer_logins`
--

INSERT INTO `officer_logins` (`Badge`, `Password`) VALUES
(5000, '12345');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `TicketNum` int(15) NOT NULL,
  `Description` varchar(15) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `TotalDue` float NOT NULL,
  `TRN` varchar(15) DEFAULT NULL,
  `Badge` int(10) DEFAULT NULL,
  `IssueDate` date DEFAULT NULL,
  `CourtDate` date DEFAULT NULL,
  `Stat` int(2) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`TicketNum`, `Description`, `Location`, `TotalDue`, `TRN`, `Badge`, `IssueDate`, `CourtDate`, `Stat`) VALUES
(10000, 'Supm', 'Kingston', 2000, NULL, NULL, NULL, NULL, 0),
(10001, 'Supm Esle', 'Kingston', 5000, NULL, NULL, NULL, NULL, 0),
(10004, 'Driving', 'MayPen', 2500, '123456', NULL, NULL, NULL, 0),
(10008, 'Parking', 'Kingston', 7000, '122939620', 5000, NULL, NULL, 0),
(10009, 'Speeding', 'Kingston', 2000, '122939620', 5000, NULL, NULL, 0),
(10010, 'Driving', 'MayPen', 2500, '123456', 5000, '2017-03-23', '2017-06-23', 0),
(10011, 'Driving', 'MayPen', 2500, '123456', 5000, '2017-03-23', '2017-06-23', 0),
(10012, 'Driving', 'MayPen', 2500, '123456', 5000, '2017-03-23', '2017-06-23', 0),
(10013, 'Driving', 'MayPen', 2500, '123456', 5000, '2017-03-23', '2017-03-23', 0);

-- --------------------------------------------------------

--
-- Table structure for table `warrant`
--

CREATE TABLE `warrant` (
  `TRN` varchar(15) NOT NULL,
  `Offence` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `warrant`
--

INSERT INTO `warrant` (`TRN`, `Offence`) VALUES
('123', 'Speed'),
('123456', 'Speeding');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `commuter`
--
ALTER TABLE `commuter`
  ADD PRIMARY KEY (`TRN`);

--
-- Indexes for table `commuter_logins`
--
ALTER TABLE `commuter_logins`
  ADD PRIMARY KEY (`TRN`);

--
-- Indexes for table `officer`
--
ALTER TABLE `officer`
  ADD PRIMARY KEY (`Badge`);

--
-- Indexes for table `officer_logins`
--
ALTER TABLE `officer_logins`
  ADD PRIMARY KEY (`Badge`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`TicketNum`),
  ADD KEY `TRN` (`TRN`),
  ADD KEY `Badge` (`Badge`);

--
-- Indexes for table `warrant`
--
ALTER TABLE `warrant`
  ADD PRIMARY KEY (`TRN`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `TicketNum` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10014;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `commuter_logins`
--
ALTER TABLE `commuter_logins`
  ADD CONSTRAINT `Commuter_Logins_ibfk_1` FOREIGN KEY (`TRN`) REFERENCES `commuter` (`TRN`);

--
-- Constraints for table `officer_logins`
--
ALTER TABLE `officer_logins`
  ADD CONSTRAINT `Officer_Logins_ibfk_1` FOREIGN KEY (`Badge`) REFERENCES `officer` (`Badge`);

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `Ticket_ibfk_1` FOREIGN KEY (`TRN`) REFERENCES `commuter` (`TRN`),
  ADD CONSTRAINT `Ticket_ibfk_2` FOREIGN KEY (`Badge`) REFERENCES `officer` (`Badge`);

--
-- Constraints for table `warrant`
--
ALTER TABLE `warrant`
  ADD CONSTRAINT `Warrant_ibfk_1` FOREIGN KEY (`TRN`) REFERENCES `commuter` (`TRN`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
