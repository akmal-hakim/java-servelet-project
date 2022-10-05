-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 04, 2022 at 06:57 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ketupatdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(10) NOT NULL,
  `admin_name` varchar(100) NOT NULL,
  `admin_password` varchar(100) NOT NULL,
  `admin_username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_name`, `admin_password`, `admin_username`) VALUES
(5, 'AMIRUL HAKIM', '123', 'amirul66'),
(15, 'MUHAMMAD AKMAL', '1234', 'akmaldokmano'),
(17, 'MUHAMMAD AINUL', '123', 'ainul123'),
(18, 'MUHAMMAD FIRDAUS', '123', 'firdaus33'),
(21, 'Hanif', '1234', 'amiruot665');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(10) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `customer_email` varchar(100) NOT NULL,
  `customer_phonenum` varchar(20) NOT NULL,
  `customer_address` varchar(200) NOT NULL,
  `customer_password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_name`, `customer_email`, `customer_phonenum`, `customer_address`, `customer_password`) VALUES
(4, 'MUHAMMAD FIRDAUS', 'firdauskacak@gmail.com', '0123456789', 'kuala lumpur', '123'),
(5, 'AM HAKIM', 'amirul@gmail.com', '0123456789', 'kuala lumpur', '123'),
(6, 'MUHAMMAD LUQMAN', 'luqman99@gmail.com', '0123456789', 'kuala lumpur', '123'),
(7, 'MUHAMMAD HAKIM', 'hakim69@gmail.com', '0123456789', 'kuala lumpur', '123');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(10) NOT NULL,
  `payment_price` double NOT NULL,
  `payment_date` varchar(30) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `product_id` int(10) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `payment_price`, `payment_date`, `customer_id`, `product_id`, `quantity`) VALUES
(12, 125, '01/17/2021 22:32:46', 4, 7, 2),
(13, 750.5, '01/17/2021 22:46:21', 4, 7, 5),
(14, 300, '01/17/2021 23:06:35', 4, 7, 2),
(15, 300, '01/17/2021 23:38:58', 5, 7, 2),
(16, 150, '01/18/2021 12:56:34', 6, 11, 1),
(17, 300, '01/18/2021 12:57:29', 5, 8, 2),
(18, 2000, '01/18/2021 12:58:14', 5, 10, 10),
(19, 450, '01/18/2021 12:58:42', 5, 12, 3),
(20, 450, '01/18/2021 14:08:25', 5, 11, 3),
(21, 300, '01/18/2021 14:46:16', 7, 7, 2),
(22, 1000, '01/26/2021 16:58:58', 5, 7, 5);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(10) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_description` varchar(200) NOT NULL,
  `product_count` int(10) NOT NULL,
  `product_price` double NOT NULL,
  `admin_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_description`, `product_count`, `product_price`, `admin_id`) VALUES
(7, 'BAJU MELAYU CEKAK MUSANG', 'SIZE L', 3, 200, 15),
(8, 'BAJU MELAYU TELUK BELANGA', 'SIZE M', 8, 200, 5),
(10, 'BAJU MELAYU BATIK', 'SIZE M', 0, 200, 15),
(11, 'BAJU MELAYU MODEN', 'SIZE M', 21, 150, 15),
(12, 'BAJU MELAYU CHEONGSAM', 'SIZE M', 17, 150, 17),
(14, 'BAJU MELAYU CHEONGSAM', 'SIZE XL', 10, 250, 15);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `review_id` int(10) NOT NULL,
  `review_text` varchar(200) NOT NULL,
  `review_star` int(10) NOT NULL,
  `payment_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`review_id`, `review_text`, `review_star`, `payment_id`) VALUES
(18, 'Barang sangat bagus. Recommended !', 5, 12),
(19, 'Barang sampai laju. Nice!', 5, 13),
(21, 'Barang bagus, kualiti terbaik. Boleh repeat order!', 5, 16),
(22, 'Barang lambat sampai, tapi kualiti semua terbaik.', 3, 15),
(23, 'Baju is not delivered yet.', 5, 17),
(25, '****', 4, 19),
(27, 'Barang bagus.', 4, 22),
(28, 'nice', 5, 18),
(29, 'bagus sangat', 5, 20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `admin_id` (`admin_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `payment_id` (`payment_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `review_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
