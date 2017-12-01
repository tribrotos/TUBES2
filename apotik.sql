-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2017 at 01:25 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotik`
--

-- --------------------------------------------------------

--
-- Table structure for table `detiltransaksi`
--

CREATE TABLE `detiltransaksi` (
  `idobat` int(11) NOT NULL,
  `idtransaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detiltransaksi`
--

INSERT INTO `detiltransaksi` (`idobat`, `idtransaksi`) VALUES
(8, 13),
(9, 13),
(8, 14),
(9, 14),
(8, 15),
(9, 15),
(8, 16),
(9, 16);

-- --------------------------------------------------------

--
-- Table structure for table `distributor`
--

CREATE TABLE `distributor` (
  `iddistributor` int(11) NOT NULL,
  `namadistributor` varchar(25) NOT NULL,
  `kontakditributor` varchar(25) NOT NULL,
  `alamatdistributor` varchar(25) NOT NULL,
  `password` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `distributor`
--

INSERT INTO `distributor` (`iddistributor`, `namadistributor`, `kontakditributor`, `alamatdistributor`, `password`) VALUES
(1, 'dini', '085745234312', 'magelang', '1234'),
(2, 'budi', '085741434445', 'bandung', 'zxc');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `idobat` int(11) NOT NULL,
  `namaobat` varchar(25) NOT NULL,
  `hargaobat` int(11) NOT NULL,
  `jenisobat` varchar(25) NOT NULL,
  `jumlahobat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`idobat`, `namaobat`, `hargaobat`, `jenisobat`, `jumlahobat`) VALUES
(8, 'konidin', 20000, 'umum', 31),
(9, 'paramex', 15000, 'umum', 8);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `idpegawai` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `shift` int(11) NOT NULL,
  `jabatan` varchar(25) NOT NULL,
  `gaji` double NOT NULL,
  `password` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`idpegawai`, `nama`, `shift`, `jabatan`, `gaji`, `password`) VALUES
(6, 'budi', 1, 'kasir', 50000000, 'qwe');

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `idpembeli` int(11) NOT NULL,
  `namapembeli` varchar(25) NOT NULL,
  `password` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`idpembeli`, `namapembeli`, `password`) VALUES
(1, 'dino', '123'),
(2, 'doni', 'asd'),
(3, 'dono', 'asdf');

-- --------------------------------------------------------

--
-- Table structure for table `restock`
--

CREATE TABLE `restock` (
  `idrestock` int(11) NOT NULL,
  `iddistributor` int(11) NOT NULL,
  `idpegawai` int(11) NOT NULL,
  `idobat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restock`
--

INSERT INTO `restock` (`idrestock`, `iddistributor`, `idpegawai`, `idobat`) VALUES
(2, 1, 6, 8),
(3, 1, 6, 8),
(4, 1, 6, 8),
(5, 1, 6, 8),
(6, 2, 6, 9);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idtransaksi` int(11) NOT NULL,
  `idpembeli` int(11) NOT NULL,
  `idpegawai` int(11) NOT NULL,
  `totalharga` int(11) NOT NULL,
  `jumlahobat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idtransaksi`, `idpembeli`, `idpegawai`, `totalharga`, `jumlahobat`) VALUES
(13, 1, 6, 125000, 7),
(14, 1, 6, 115000, 6),
(15, 2, 6, 330000, 19),
(16, 1, 6, 350000, 20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detiltransaksi`
--
ALTER TABLE `detiltransaksi`
  ADD KEY `idobat` (`idobat`),
  ADD KEY `idtransaksi` (`idtransaksi`);

--
-- Indexes for table `distributor`
--
ALTER TABLE `distributor`
  ADD PRIMARY KEY (`iddistributor`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`idobat`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`idpegawai`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`idpembeli`);

--
-- Indexes for table `restock`
--
ALTER TABLE `restock`
  ADD PRIMARY KEY (`idrestock`),
  ADD KEY `iddistributor` (`iddistributor`),
  ADD KEY `idpegawai` (`idpegawai`),
  ADD KEY `idobat` (`idobat`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idtransaksi`),
  ADD KEY `idpembeli` (`idpembeli`),
  ADD KEY `idpegawai` (`idpegawai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `distributor`
--
ALTER TABLE `distributor`
  MODIFY `iddistributor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `obat`
--
ALTER TABLE `obat`
  MODIFY `idobat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `idpegawai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `pembeli`
--
ALTER TABLE `pembeli`
  MODIFY `idpembeli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `restock`
--
ALTER TABLE `restock`
  MODIFY `idrestock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idtransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `detiltransaksi`
--
ALTER TABLE `detiltransaksi`
  ADD CONSTRAINT `detiltransaksi_ibfk_1` FOREIGN KEY (`idobat`) REFERENCES `obat` (`idobat`),
  ADD CONSTRAINT `detiltransaksi_ibfk_2` FOREIGN KEY (`idtransaksi`) REFERENCES `transaksi` (`idtransaksi`);

--
-- Constraints for table `restock`
--
ALTER TABLE `restock`
  ADD CONSTRAINT `restock_ibfk_1` FOREIGN KEY (`iddistributor`) REFERENCES `distributor` (`iddistributor`),
  ADD CONSTRAINT `restock_ibfk_3` FOREIGN KEY (`idpegawai`) REFERENCES `pegawai` (`idpegawai`),
  ADD CONSTRAINT `restock_ibfk_4` FOREIGN KEY (`idobat`) REFERENCES `obat` (`idobat`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`idpembeli`) REFERENCES `pembeli` (`idpembeli`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`idpegawai`) REFERENCES `pegawai` (`idpegawai`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
