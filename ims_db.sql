-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2026 at 06:02 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ims_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `assets`
--

CREATE TABLE `assets` (
  `id` bigint(20) NOT NULL,
  `asset_tag` varchar(255) NOT NULL,
  `device_type` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `processor` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `storage` varchar(255) DEFAULT NULL,
  `operating_system` varchar(255) DEFAULT NULL,
  `asset_condition` varchar(255) DEFAULT NULL,
  `asset_status` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `notes` varchar(500) DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  `created_at` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assets`
--

INSERT INTO `assets` (`id`, `asset_tag`, `device_type`, `brand`, `model`, `serial_number`, `processor`, `ram`, `storage`, `operating_system`, `asset_condition`, `asset_status`, `department`, `location`, `notes`, `purchase_date`, `created_at`) VALUES
(64, 'AIR-LT-001', 'LAPTOP', 'Dell', 'Latitude 5420', 'SN123456', 'Intel Core i5-1135G7', '16GB', '512GB SSD', 'Windows 11 Pro', 'GOOD', 'Assigned', 'IT', 'Kigali HQ', NULL, '2024-01-15', '2026-04-26'),
(65, 'AIR-DT-002', 'DESKTOP', 'HP', 'EliteDesk 800', 'SN789012', 'Intel Core i7-10700', '32GB', '1TB SSD', 'Windows 11 Pro', 'GOOD', 'Available', 'Finance', 'Kigali HQ', NULL, '2024-02-20', '2026-04-26'),
(66, 'AIR-MB-003', 'MOBILE', 'Samsung', 'Galaxy S23', 'IMSI789012', 'Snapdragon 8 Gen 2', '8GB', '256GB', 'Android 14', 'NEW', 'AVAILABLE', 'Sales', 'Kigali HQ', NULL, '2024-03-10', '2026-04-26');

-- --------------------------------------------------------

--
-- Table structure for table `assignments`
--

CREATE TABLE `assignments` (
  `id` bigint(20) NOT NULL,
  `asset_id` bigint(20) NOT NULL,
  `assigned_to` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `issued_date` date DEFAULT NULL,
  `expected_return_date` date DEFAULT NULL,
  `returned_date` date DEFAULT NULL,
  `condition_at_issue` varchar(255) DEFAULT NULL,
  `condition_at_return` varchar(255) DEFAULT NULL,
  `purpose_of_use` varchar(500) DEFAULT NULL,
  `return_notes` varchar(500) DEFAULT NULL,
  `issued_by` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `issue_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assignments`
--

INSERT INTO `assignments` (`id`, `asset_id`, `assigned_to`, `employee_id`, `department`, `phone_number`, `issued_date`, `expected_return_date`, `returned_date`, `condition_at_issue`, `condition_at_return`, `purpose_of_use`, `return_notes`, `issued_by`, `status`, `issue_date`) VALUES
(1, 65, 'BAMURANGE SARAH', '12', 'IT', '0789999999', NULL, '2026-04-29', '2026-04-26', 'NEW', 'GOOD', 'work', 'no', NULL, 'Returned', '2026-04-26'),
(2, 64, 'ISHIMWE CUBAIN', '12345', 'Finance', '0789999997', '2026-04-26', '2026-04-30', NULL, 'GOOD', NULL, 'Dail operation', NULL, NULL, 'Active', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `sys_admin`
--

CREATE TABLE `sys_admin` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sys_admin`
--

INSERT INTO `sys_admin` (`id`, `username`, `password`, `full_name`, `role`, `enabled`) VALUES
(1, '24RP09739', '24rp06926', 'NDIKUMANA DERIC', 'SYSADMIN', b'1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assets`
--
ALTER TABLE `assets`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_asset_tag` (`asset_tag`);

--
-- Indexes for table `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_asset_id` (`asset_id`);

--
-- Indexes for table `sys_admin`
--
ALTER TABLE `sys_admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assets`
--
ALTER TABLE `assets`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `assignments`
--
ALTER TABLE `assignments`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sys_admin`
--
ALTER TABLE `sys_admin`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignments`
--
ALTER TABLE `assignments`
  ADD CONSTRAINT `FK_asset_id` FOREIGN KEY (`asset_id`) REFERENCES `assets` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
