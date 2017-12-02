-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: apotik2
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detiltransaksi`
--

DROP TABLE IF EXISTS `detiltransaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detiltransaksi` (
  `idobat` int(11) NOT NULL,
  `idtransaksi` int(11) NOT NULL,
  KEY `idobat` (`idobat`),
  KEY `idtransaksi` (`idtransaksi`),
  CONSTRAINT `detiltransaksi_ibfk_1` FOREIGN KEY (`idobat`) REFERENCES `obat` (`idobat`),
  CONSTRAINT `detiltransaksi_ibfk_2` FOREIGN KEY (`idtransaksi`) REFERENCES `transaksi` (`idtransaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detiltransaksi`
--

LOCK TABLES `detiltransaksi` WRITE;
/*!40000 ALTER TABLE `detiltransaksi` DISABLE KEYS */;
INSERT INTO `detiltransaksi` VALUES (8,13),(9,13),(8,14),(9,14),(8,15),(9,15),(8,16),(9,16),(8,17),(9,17),(8,18),(9,18),(10,19),(9,19);
/*!40000 ALTER TABLE `detiltransaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distributor`
--

DROP TABLE IF EXISTS `distributor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distributor` (
  `iddistributor` int(11) NOT NULL AUTO_INCREMENT,
  `namadistributor` varchar(25) NOT NULL,
  `kontakditributor` varchar(25) NOT NULL,
  `alamatdistributor` varchar(25) NOT NULL,
  `password` varchar(5) NOT NULL,
  PRIMARY KEY (`iddistributor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributor`
--

LOCK TABLES `distributor` WRITE;
/*!40000 ALTER TABLE `distributor` DISABLE KEYS */;
INSERT INTO `distributor` VALUES (1,'dini','085745234312','magelang','1234'),(2,'budi','085741434445','bandung','zxc');
/*!40000 ALTER TABLE `distributor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obat`
--

DROP TABLE IF EXISTS `obat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obat` (
  `idobat` int(11) NOT NULL AUTO_INCREMENT,
  `namaobat` varchar(25) NOT NULL,
  `hargaobat` int(11) NOT NULL,
  `jenisobat` varchar(25) NOT NULL,
  `jumlahobat` int(11) NOT NULL,
  PRIMARY KEY (`idobat`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obat`
--

LOCK TABLES `obat` WRITE;
/*!40000 ALTER TABLE `obat` DISABLE KEYS */;
INSERT INTO `obat` VALUES (8,'konidin',20000,'umum',28),(9,'paramex',15000,'umum',3),(10,'amoksilin',7000,'umum',9);
/*!40000 ALTER TABLE `obat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pegawai`
--

DROP TABLE IF EXISTS `pegawai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pegawai` (
  `idpegawai` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(25) NOT NULL,
  `shift` int(11) NOT NULL,
  `gaji` double NOT NULL,
  `password` varchar(5) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpegawai`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pegawai`
--

LOCK TABLES `pegawai` WRITE;
/*!40000 ALTER TABLE `pegawai` DISABLE KEYS */;
INSERT INTO `pegawai` VALUES (6,'budi',1,50000000,'qwe','budi'),(7,'ghalih',1,20000,'gh1',NULL);
/*!40000 ALTER TABLE `pegawai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pembeli`
--

DROP TABLE IF EXISTS `pembeli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pembeli` (
  `idpembeli` int(11) NOT NULL AUTO_INCREMENT,
  `namapembeli` varchar(25) NOT NULL,
  `password` varchar(5) DEFAULT NULL,
  `noHp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpembeli`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pembeli`
--

LOCK TABLES `pembeli` WRITE;
/*!40000 ALTER TABLE `pembeli` DISABLE KEYS */;
INSERT INTO `pembeli` VALUES (1,'dino','123','08114'),(2,'doni','asd','0812222'),(3,'dono','asdf','0812312'),(4,'test','null','088324'),(5,'akmal',NULL,'097123');
/*!40000 ALTER TABLE `pembeli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restock`
--

DROP TABLE IF EXISTS `restock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restock` (
  `idrestock` int(11) NOT NULL AUTO_INCREMENT,
  `iddistributor` int(11) NOT NULL,
  `idpegawai` int(11) NOT NULL,
  `idobat` int(11) NOT NULL,
  PRIMARY KEY (`idrestock`),
  KEY `iddistributor` (`iddistributor`),
  KEY `idpegawai` (`idpegawai`),
  KEY `idobat` (`idobat`),
  CONSTRAINT `restock_ibfk_1` FOREIGN KEY (`iddistributor`) REFERENCES `distributor` (`iddistributor`),
  CONSTRAINT `restock_ibfk_3` FOREIGN KEY (`idpegawai`) REFERENCES `pegawai` (`idpegawai`),
  CONSTRAINT `restock_ibfk_4` FOREIGN KEY (`idobat`) REFERENCES `obat` (`idobat`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restock`
--

LOCK TABLES `restock` WRITE;
/*!40000 ALTER TABLE `restock` DISABLE KEYS */;
INSERT INTO `restock` VALUES (2,1,6,8),(3,1,6,8),(4,1,6,8),(5,1,6,8),(6,2,6,9);
/*!40000 ALTER TABLE `restock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksi` (
  `idtransaksi` int(11) NOT NULL AUTO_INCREMENT,
  `idpembeli` int(11) NOT NULL,
  `idpegawai` int(11) NOT NULL,
  `totalharga` int(11) NOT NULL,
  `jumlahobat` int(11) NOT NULL,
  PRIMARY KEY (`idtransaksi`),
  KEY `idpembeli` (`idpembeli`),
  KEY `idpegawai` (`idpegawai`),
  CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`idpembeli`) REFERENCES `pembeli` (`idpembeli`),
  CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`idpegawai`) REFERENCES `pegawai` (`idpegawai`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksi`
--

LOCK TABLES `transaksi` WRITE;
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
INSERT INTO `transaksi` VALUES (13,1,6,125000,7),(14,1,6,115000,6),(15,2,6,330000,19),(16,1,6,350000,20),(17,1,6,55000,3),(18,1,6,50000,3),(19,3,6,37000,3);
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'apotik2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-02 12:20:58
