-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2022 at 02:49 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `baju`
--

CREATE TABLE `baju` (
  `id_baju` int(11) NOT NULL,
  `id_jenis` int(11) NOT NULL,
  `nama_baju` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL,
  `ukuran` enum('S','M','L','XL','XXL','XXXL') NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `baju`
--

INSERT INTO `baju` (`id_baju`, `id_jenis`, `nama_baju`, `harga`, `ukuran`, `stok`) VALUES
(3, 1, 'VANSA', 121121, 'S', 987),
(4, 2, 'UNIQLO', 879878, 'XXL', 99),
(5, 8, 'ARMORY', 100000, 'XXL', 8),
(6, 2, 'Terserah', 200000, 'M', 0),
(8, 1, 'HushPuppies L', 200000, 'L', 99);

-- --------------------------------------------------------

--
-- Table structure for table `jenis`
--

CREATE TABLE `jenis` (
  `id_jenis` int(11) NOT NULL,
  `nama_jenis` varchar(255) NOT NULL,
  `keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenis`
--

INSERT INTO `jenis` (`id_jenis`, `nama_jenis`, `keterangan`) VALUES
(1, 'Denim', 'kaku seperti hatimu'),
(2, 'Flanel', ''),
(3, 'Dingin', 'Baju adem seperti senyumanmu'),
(4, 'Hangat', 'Baju hangat senyaman pelukanmu'),
(8, 'TNI', 'Bersembunyi dari kenyataan'),
(10, 'Jc&J', 'Baju kelen segala kalangan');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(11) NOT NULL,
  `nama_pelanggan` varchar(255) NOT NULL,
  `notelp` varchar(80) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `jk` enum('Lk','PR') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `notelp`, `alamat`, `jk`) VALUES
(2, 'Ucok', '089123123', 'Jl. Jalan', 'Lk'),
(3, 'Jaenal', '089123123', 'Jalan. Bunaa', 'Lk'),
(4, 'Argya', '081231231', 'Jalan. Bukan Jalan', 'Lk'),
(5, 'Jupri', '081212112', 'Jalanan Dekat Taman', 'Lk'),
(6, 'Farrel', '435677', 'Jalan Kenanga', 'Lk'),
(7, 'Farah', '012121', 'Jl. Jalan', 'PR');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `id_pelanggan` int(11) NOT NULL,
  `namaBayar` varchar(255) NOT NULL,
  `nominal` int(11) NOT NULL,
  `tipebayar` enum('debit','kredit') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_pelanggan`, `namaBayar`, `nominal`, `tipebayar`) VALUES
(3, 2, 'BSI', 199001, 'debit'),
(4, 2, 'PayLater', 2701998, 'kredit'),
(5, 3, 'BCA', 678879, 'debit'),
(6, 3, 'Gopaylater', 521121, 'kredit'),
(8, 7, 'BNI', 11800000, 'debit');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_baju` int(11) NOT NULL,
  `id_pelanggan` int(11) NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_baju`, `id_pelanggan`, `tanggal_transaksi`, `jumlah_beli`, `total_harga`) VALUES
(1, 3, 2, '2022-10-02', 10, 1211210),
(2, 3, 2, '2022-06-10', 5, 605605),
(5, 4, 2, '2022-12-10', 1, 879878),
(6, 4, 2, '2000-12-10', 1, 879878),
(8, 4, 2, '2020-12-10', 1, 879878),
(9, 4, 2, '2022-12-10', 1, 879878),
(10, 3, 2, '2002-10-12', 1, 121121),
(11, 5, 2, '2010-10-11', 1, 100000),
(12, 5, 2, '2010-10-20', 1, 100000),
(13, 6, 3, '2022-12-10', 1, 200000),
(14, 6, 3, '2022-12-10', 1, 200000),
(15, 3, 3, '2022-12-10', 1, 121121),
(16, 3, 3, '2022-12-10', 1, 121121),
(17, 8, 7, '2022-10-11', 1, 200000),
(19, 4, 3, '2022-10-12', 1, 879878),
(20, 3, 2, '2022-10-12', 1, 121121);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baju`
--
ALTER TABLE `baju`
  ADD PRIMARY KEY (`id_baju`),
  ADD KEY `id_jenis` (`id_jenis`);

--
-- Indexes for table `jenis`
--
ALTER TABLE `jenis`
  ADD PRIMARY KEY (`id_jenis`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_baju` (`id_baju`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `baju`
--
ALTER TABLE `baju`
  MODIFY `id_baju` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `jenis`
--
ALTER TABLE `jenis`
  MODIFY `id_jenis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `baju`
--
ALTER TABLE `baju`
  ADD CONSTRAINT `baju_ibfk_1` FOREIGN KEY (`id_jenis`) REFERENCES `jenis` (`id_jenis`);

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_baju`) REFERENCES `baju` (`id_baju`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
