-- MariaDB dump 10.19  Distrib 10.5.20-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: ECOMMERCE_VKU
-- ------------------------------------------------------
-- Server version	10.5.20-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ta_aut_address`
--

DROP TABLE IF EXISTS `ta_aut_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_address` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `I_ID_USER` bigint(20) NOT NULL,
  `T_ADDRESS` varchar(100) NOT NULL,
  PRIMARY KEY (`I_ID`),
  KEY `ta_aut_address_FK` (`I_ID_USER`),
  CONSTRAINT `ta_aut_address_FK` FOREIGN KEY (`I_ID_USER`) REFERENCES `ta_aut_user` (`I_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_address`
--

LOCK TABLES `ta_aut_address` WRITE;
/*!40000 ALTER TABLE `ta_aut_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `ta_aut_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_brand`
--

DROP TABLE IF EXISTS `ta_aut_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_brand` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `T_NAME_BRAND` varchar(255) NOT NULL,
  `T_CODE` varchar(100) NOT NULL,
  `D_CREATED_AT` datetime DEFAULT NULL,
  `D_MODIFIED_AT` datetime DEFAULT NULL,
  PRIMARY KEY (`I_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_brand`
--

LOCK TABLES `ta_aut_brand` WRITE;
/*!40000 ALTER TABLE `ta_aut_brand` DISABLE KEYS */;
INSERT INTO `ta_aut_brand` VALUES (1,'Asus','asus',NULL,NULL),(2,'Acer','acer',NULL,NULL),(3,'Lenovo','lenovo',NULL,NULL),(4,'Dell','dell',NULL,NULL),(5,'HP','hp',NULL,NULL),(6,'MSI','msi',NULL,NULL),(7,'Huawei','huawei',NULL,NULL);
/*!40000 ALTER TABLE `ta_aut_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_category`
--

DROP TABLE IF EXISTS `ta_aut_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_category` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `T_CATEGORY_NAME` varchar(100) NOT NULL,
  `T_CATEGORY_CODE` varchar(100) NOT NULL,
  `D_CREATED_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  PRIMARY KEY (`I_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_category`
--

LOCK TABLES `ta_aut_category` WRITE;
/*!40000 ALTER TABLE `ta_aut_category` DISABLE KEYS */;
INSERT INTO `ta_aut_category` VALUES (1,'Laptops','lap-top','2023-09-26',NULL),(2,'Phụ kiện','phu-kien','2023-09-26',NULL),(3,'Cameras','camera','2023-09-26',NULL),(4,'Smartphones','dien-thoai','2023-09-26',NULL),(7,'Televisions','tv','2023-09-26',NULL),(8,'Smart Watches','smart-watch','2023-09-26',NULL);
/*!40000 ALTER TABLE `ta_aut_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_order_details`
--

DROP TABLE IF EXISTS `ta_aut_order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_order_details` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `I_ID_ORDER` bigint(20) NOT NULL,
  `I_ID_PRODUCT` bigint(20) NOT NULL,
  `I_QUANTITY` int(11) NOT NULL,
  `F_TOTAL_PRICE` double NOT NULL,
  `I_STATUS` int(11) DEFAULT NULL,
  `T_DESCRIPTION` varchar(100) DEFAULT NULL,
  `D_CREATED_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  PRIMARY KEY (`I_ID`),
  KEY `ta_aut_order_details_FK` (`I_ID_ORDER`),
  KEY `ta_aut_order_details_FK_1` (`I_ID_PRODUCT`),
  CONSTRAINT `ta_aut_order_details_FK` FOREIGN KEY (`I_ID_ORDER`) REFERENCES `ta_aut_orders` (`I_ID`),
  CONSTRAINT `ta_aut_order_details_FK_1` FOREIGN KEY (`I_ID_PRODUCT`) REFERENCES `ta_aut_product` (`I_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_order_details`
--

LOCK TABLES `ta_aut_order_details` WRITE;
/*!40000 ALTER TABLE `ta_aut_order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `ta_aut_order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_orders`
--

DROP TABLE IF EXISTS `ta_aut_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_orders` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `I_ID_USER` bigint(20) NOT NULL,
  `I_TYPE_ORDER` int(11) NOT NULL,
  `F_TOTAL` double NOT NULL,
  `I_ORDER_DETAIL_AMOUNT` int(11) NOT NULL,
  `T_DESCRIPTION` varchar(100) DEFAULT NULL,
  `D_CREATED_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  PRIMARY KEY (`I_ID`),
  KEY `ta_aut_orders_FK` (`I_ID_USER`),
  CONSTRAINT `ta_aut_orders_FK` FOREIGN KEY (`I_ID_USER`) REFERENCES `ta_aut_user` (`I_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_orders`
--

LOCK TABLES `ta_aut_orders` WRITE;
/*!40000 ALTER TABLE `ta_aut_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `ta_aut_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_price`
--

DROP TABLE IF EXISTS `ta_aut_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_price` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `I_ID_UNIT` bigint(20) NOT NULL,
  `I_ID_PRODUCT` bigint(20) NOT NULL,
  `F_CURRENT_VALUE` double NOT NULL,
  `F_OLD_VALUE` double DEFAULT NULL,
  `D_CREATED_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  PRIMARY KEY (`I_ID`),
  KEY `ta_aut_price_FK` (`I_ID_UNIT`),
  KEY `ta_aut_price_FK_1` (`I_ID_PRODUCT`),
  CONSTRAINT `ta_aut_price_FK` FOREIGN KEY (`I_ID_UNIT`) REFERENCES `ta_aut_unit` (`I_ID`),
  CONSTRAINT `ta_aut_price_FK_1` FOREIGN KEY (`I_ID_PRODUCT`) REFERENCES `ta_aut_product` (`I_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_price`
--

LOCK TABLES `ta_aut_price` WRITE;
/*!40000 ALTER TABLE `ta_aut_price` DISABLE KEYS */;
INSERT INTO `ta_aut_price` VALUES (1,1,1,980,NULL,'2023-09-26',NULL),(2,1,2,1000,NULL,'2023-09-26',NULL),(3,1,3,980,NULL,'2023-09-26',NULL),(4,1,4,980,NULL,'2023-09-26',NULL),(5,1,5,980,NULL,'2023-09-26',NULL),(6,1,6,980,NULL,'2023-09-26',NULL),(9,1,7,980,NULL,'2023-09-26',NULL),(10,1,8,980,NULL,'2023-09-26',NULL),(11,1,9,980,NULL,'2023-09-26',NULL),(12,1,10,980,NULL,'2023-09-26',NULL),(13,1,11,980,NULL,'2023-09-26',NULL),(14,1,12,980,NULL,'2023-09-26',NULL),(15,1,13,980,NULL,'2023-09-26',NULL),(16,1,14,980,NULL,'2023-09-26',NULL),(17,1,15,980,NULL,'2023-09-26',NULL),(18,1,16,980,NULL,'2023-09-26',NULL),(19,1,17,980,NULL,'2023-09-26',NULL),(20,1,18,980,NULL,'2023-11-02',NULL),(21,1,19,980,NULL,'2023-11-02',NULL),(22,1,20,980,NULL,'2023-11-02',NULL),(23,1,21,980,NULL,'2023-11-02',NULL);
/*!40000 ALTER TABLE `ta_aut_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_product`
--

DROP TABLE IF EXISTS `ta_aut_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_product` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `I_UUID_PRODUCT` varchar(100) DEFAULT NULL,
  `T_NAME_PRODUCT` varchar(255) NOT NULL,
  `T_DESCRIPTION` varchar(255) DEFAULT NULL,
  `I_ID_BRAND` bigint(20) DEFAULT NULL,
  `I_ID_CATEGORY` bigint(20) NOT NULL,
  `I_TYPE_01` int(11) DEFAULT 0 COMMENT 'san pham ban chay',
  `I_TYPE_02` int(11) DEFAULT 0 COMMENT 'san pham giam gia',
  `I_TYPE_03` int(11) DEFAULT 0 COMMENT 'san pham new',
  `I_TYPE_04` int(11) DEFAULT 0 COMMENT 'san pham best saler',
  `D_CREATED_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  PRIMARY KEY (`I_ID`),
  KEY `ta_aut_product_FK` (`I_ID_CATEGORY`),
  KEY `ta_aut_product_FK_1` (`I_ID_BRAND`),
  CONSTRAINT `ta_aut_product_FK` FOREIGN KEY (`I_ID_CATEGORY`) REFERENCES `ta_aut_category` (`I_ID`),
  CONSTRAINT `ta_aut_product_FK_1` FOREIGN KEY (`I_ID_BRAND`) REFERENCES `ta_aut_brand` (`I_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_product`
--

LOCK TABLES `ta_aut_product` WRITE;
/*!40000 ALTER TABLE `ta_aut_product` DISABLE KEYS */;
INSERT INTO `ta_aut_product` VALUES (1,'a831c7c1-4448-4888-ba5d-6cdb064e7a06','MacBook Pro 13\" Display, i5','MacBook Pro 13\" Display, i5',1,1,0,0,0,0,'2023-09-26',NULL),(2,'f143c438-2b5c-444e-868a-18454765a40f','Bose - SoundLink Bluetooth Speaker','Bose - SoundLink Bluetooth Speaker',1,2,0,0,0,0,'2023-09-26',NULL),(3,'b0a7c457-2e56-43ff-94f9-4284c3a70818','Apple - 11 Inch iPad Pro  with Wi-Fi 256GB ','Apple - 11 Inch iPad Pro  with Wi-Fi 256GB ',NULL,4,0,0,0,0,'2023-09-26',NULL),(4,'091430f8-6aed-48ce-84c6-02454ddec440','Beats by Dr. Dre Wireless  Headphones','Beats by Dr. Dre Wireless  Headphones',1,2,0,0,0,0,'2023-09-26',NULL),(5,'838f39d6-dac6-48a5-a6d2-d2d90adaca4a','Google - Pixel 3 XL  128GB','Google - Pixel 3 XL  128GB',1,2,0,0,0,0,'2023-09-26',NULL),(6,'3f95a981-7a14-4b78-a163-3ce485dc22eb','Samsung - 55\" Class  LED 2160p Smart','Samsung - 55\" Class  LED 2160p Smart',NULL,7,0,0,0,0,'2023-09-26',NULL),(7,'d9371038-2d42-4a3d-89b7-7020e7588b7a','GoPro - HERO7 Black HD Waterproof Action','Samsung - 55\" GoPro - HERO7 Black HD Waterproof ActionClass  LED 2160p Smart',1,2,0,0,0,0,'2023-09-26',NULL),(8,'2753c377-eb79-417b-857d-088bfeed9d45','Bose - SoundSport  wireless headphones','Bose - SoundSport  wireless headphones',1,2,0,0,0,0,'2023-09-26',NULL),(9,'1336b512-394e-4ff2-bb7e-5c73ffd9ffa4','Microsoft - Refurbish Xbox One S 500GB','Microsoft - Refurbish Xbox One S 500GB',1,2,0,0,0,0,'2023-09-26',NULL),(10,'8754f89d-7375-4ac6-bf37-a6a8fc836918','Apple Watch Series 4 Gold Aluminum Case','Apple Watch Series 4 Gold Aluminum Case',NULL,8,0,0,0,0,'2023-09-26',NULL),(11,'d417686b-faea-49f7-9cf7-80bd2d5f71c9','Sony - Class LED 2160p Smart 4K Ultra HD','Sony - Class LED 2160p Smart 4K Ultra HD',NULL,7,0,0,0,0,'2023-09-26',NULL),(12,'e02238ae-00a9-4346-8533-7163f9ebfb79','Apple - Apple Watch Series 3 with White Sport Band','Apple - Apple Watch Series 3 with White Sport Band',NULL,8,0,0,0,0,'2023-09-26',NULL),(13,'0d161656-790c-43fa-8dfd-9dd22ba3d343','Lenovo - 330-15IKBR 15.6\"','Lenovo - 330-15IKBR 15.6\"',1,1,0,0,0,0,'2023-09-26',NULL),(14,'b37bd554-18ce-4bbf-96f9-2ff19b8961df','Sony - Alpha a5100 Mirrorless Camera','Sony - Alpha a5100 Mirrorless Camera',NULL,3,0,0,0,0,'2023-09-26',NULL),(15,'c4723fbd-8d20-46ea-8feb-e154631c486a','Home Mini - Smart Speaker  with Google Assistant','Home Mini - Smart Speaker  with Google Assistant',2,2,0,0,0,0,'2023-09-26',NULL),(16,'f3558059-b411-4d0c-89bb-e2727a070d4b','WONDERBOOM Portable Bluetooth Speaker','WONDERBOOM Portable Bluetooth Speaker',1,2,0,0,0,0,'2023-09-26',NULL),(17,'ac8fc40d-5424-4f77-a0ea-9e579a60228b','Google - Home Hub with  Google Assistant','Google - Home Hub with  Google Assistant',NULL,7,0,0,0,0,'2023-09-26',NULL),(18,'1f8a1d0b-9dd8-4fcd-84b9-8147131713c6','Chuột không dây Dareu LM106G Black','Chuột không dây Dareu LM106G Black',2,2,0,0,0,0,'2023-11-02',NULL),(19,'4c7d1ed9-4446-4074-bb81-31642f45f0fc','Laptop Acer Predator Helios Neo PHN16-71-7460','Laptop Acer Predator Helios Neo PHN16-71-7460',1,1,0,0,0,0,'2023-11-02',NULL),(20,'acfd1771-23f8-48dd-9508-2c619164cbd3','ACER GAMING NITRO V - RTX 4050, CORE I5 GEN 13','ACER GAMING NITRO V - RTX 4050, CORE I5 GEN 13',1,1,0,0,0,0,'2023-11-02',NULL),(21,'5cb1ee62-63f9-4673-956a-294e54a4f30d','Laptop MSI Gaming Cyborg 15 A12UCX i5 12450H','Laptop MSI Gaming Cyborg 15 A12UCX i5 12450H',1,1,0,0,0,0,'2023-11-02',NULL);
/*!40000 ALTER TABLE `ta_aut_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_product_images`
--

DROP TABLE IF EXISTS `ta_aut_product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_product_images` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `I_ID_PRODUCT` bigint(20) NOT NULL,
  `T_URL_IMAGE` text NOT NULL,
  `T_DESCRIPTION` text DEFAULT NULL,
  `D_CREATED_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  `I_TYPE` int(11) DEFAULT NULL,
  PRIMARY KEY (`I_ID`),
  KEY `ta_aut_product_images_FK` (`I_ID_PRODUCT`),
  CONSTRAINT `ta_aut_product_images_FK` FOREIGN KEY (`I_ID_PRODUCT`) REFERENCES `ta_aut_product` (`I_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_product_images`
--

LOCK TABLES `ta_aut_product_images` WRITE;
/*!40000 ALTER TABLE `ta_aut_product_images` DISABLE KEYS */;
INSERT INTO `ta_aut_product_images` VALUES (1,1,'/template/web/images/demos/demo-4/products/product-1.jpg','Ảnh Laptop','2023-09-26',NULL,1),(2,2,'/template/web/images/demos/demo-4/products/product-2.jpg','Ảnh Laptop','2023-09-26',NULL,1),(3,3,'/template/web/images/demos/demo-4/products/product-3.jpg','Ảnh Laptop','2023-09-26',NULL,1),(4,4,'/template/web/images/demos/demo-4/products/product-10.jpg','Ảnh Tai Nghe','2023-09-26',NULL,1),(5,5,'/template/web/images/demos/demo-4/products/product-4.jpg','Ảnh Laptop','2023-09-26',NULL,1),(6,6,'/template/web/images/demos/demo-4/products/product-5.jpg','Ảnh Laptop','2023-09-26',NULL,1),(7,7,'/template/web/images/demos/demo-4/products/product-11.jpg','Ảnh Laptop','2023-09-26',NULL,1),(8,8,'/template/web/images/demos/demo-4/products/product-6.jpg','Ảnh Laptop','2023-09-26',NULL,1),(9,9,'/template/web/images/demos/demo-4/products/product-7.jpg','Ảnh Laptop','2023-09-26',NULL,1),(10,10,'/template/web/images/demos/demo-4/products/product-8.jpg','Ảnh Laptop','2023-09-26',NULL,1),(11,11,'/template/web/images/demos/demo-4/products/product-9.jpg','Ảnh Laptop','2023-09-26',NULL,1),(12,12,'/template/web/images/demos/demo-4/products/product-12.jpg','Ảnh Laptop','2023-09-26',NULL,1),(13,13,'/template/web/images/demos/demo-4/products/product-13.jpg','Ảnh Laptop','2023-09-26',NULL,1),(14,14,'/template/web/images/demos/demo-4/products/product-1.jpg','Ảnh Laptop','2023-09-26',NULL,1),(15,15,'/template/web/images/demos/demo-4/products/product-15.jpg','Ảnh Laptop','2023-09-26',NULL,1),(16,16,'/template/web/images/demos/demo-4/products/product-16.jpg','Ảnh Laptop','2023-09-26',NULL,1),(17,17,'/template/web/images/demos/demo-4/products/product-17.jpg','Ảnh Laptop','2023-09-26',NULL,1),(18,18,'/template/web/images/demos/demo-4/products/product-1.jpg','Ảnh Laptop','2023-11-02',NULL,1),(19,19,'/template/web/images/demos/demo-4/products/product-1.jpg','Ảnh Laptop','2023-11-02',NULL,1),(20,20,'/template/web/images/demos/demo-4/products/product-1.jpg',NULL,'2023-11-02',NULL,1),(21,21,'/template/web/images/demos/demo-4/products/product-1.jpg',NULL,'2023-11-02',NULL,1);
/*!40000 ALTER TABLE `ta_aut_product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_reviews`
--

DROP TABLE IF EXISTS `ta_aut_reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_reviews` (
  `I_ID` bigint(20) NOT NULL,
  `T_COMMENT` varchar(100) DEFAULT NULL,
  `I_ID_PRODUCT` bigint(20) NOT NULL,
  `I_ID_USER` bigint(20) NOT NULL,
  `I_ID_ORDER_DETAIL` bigint(20) NOT NULL,
  `D_CREATE_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  PRIMARY KEY (`I_ID`),
  KEY `ta_aut_reviews_FK` (`I_ID_ORDER_DETAIL`),
  KEY `ta_aut_reviews_FK_1` (`I_ID_PRODUCT`),
  KEY `ta_aut_reviews_FK_2` (`I_ID_USER`),
  CONSTRAINT `ta_aut_reviews_FK` FOREIGN KEY (`I_ID_ORDER_DETAIL`) REFERENCES `ta_aut_order_details` (`I_ID`),
  CONSTRAINT `ta_aut_reviews_FK_1` FOREIGN KEY (`I_ID_PRODUCT`) REFERENCES `ta_aut_product` (`I_ID`),
  CONSTRAINT `ta_aut_reviews_FK_2` FOREIGN KEY (`I_ID_USER`) REFERENCES `ta_aut_user` (`I_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_reviews`
--

LOCK TABLES `ta_aut_reviews` WRITE;
/*!40000 ALTER TABLE `ta_aut_reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `ta_aut_reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_unit`
--

DROP TABLE IF EXISTS `ta_aut_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_unit` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `T_UNIT_NAME` varchar(100) NOT NULL,
  `I_RATIO` int(11) NOT NULL,
  `D_CREATED_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  PRIMARY KEY (`I_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_unit`
--

LOCK TABLES `ta_aut_unit` WRITE;
/*!40000 ALTER TABLE `ta_aut_unit` DISABLE KEYS */;
INSERT INTO `ta_aut_unit` VALUES (1,'Máy',1,'2023-11-08',NULL);
/*!40000 ALTER TABLE `ta_aut_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_aut_user`
--

DROP TABLE IF EXISTS `ta_aut_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_aut_user` (
  `I_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `T_USERNAME` varchar(100) DEFAULT NULL,
  `T_PASSWORD` varchar(100) DEFAULT NULL,
  `I_ROLE` int(11) NOT NULL,
  `T_EMAIL` varchar(100) DEFAULT NULL,
  `T_FIST_NAME` varchar(100) NOT NULL,
  `T_LAST_NAME` varchar(100) NOT NULL,
  `T_TELEPHONE` varchar(100) DEFAULT NULL,
  `I_STATUS` int(11) NOT NULL,
  `T_HASHED_PASSWORD` varchar(255) DEFAULT NULL,
  `D_CREATED_AT` date DEFAULT NULL,
  `D_MODIFIED_AT` date DEFAULT NULL,
  PRIMARY KEY (`I_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_aut_user`
--

LOCK TABLES `ta_aut_user` WRITE;
/*!40000 ALTER TABLE `ta_aut_user` DISABLE KEYS */;
INSERT INTO `ta_aut_user` VALUES (1,'admin','admin@11',1,'nguyendangha2405@gmail.com','Hạ','Nguyễn Đăng','0388529096',1,'1000:4f8a9aa61a2f06aca28c5b9d1005fab0:b9d4f21cb01e265326f38329dc532414dd8ae318d4b62a1b0f93fffc307ac2b5ceb690e6ad94369cc7abd7132003c8992ea0d00bfaee59a2e1d3ce3a96d4ca20','2023-10-04',NULL),(2,'user1','user1@12',2,'nguyendangha2405@gmail.com','Đức','Phạm Phú','0388529096',1,'1000:ec46d967a57bf7e9fcf02936a814bcbb:c6e003ff0f5fd0e54d252c7248df7f38647f4f5201cf22d310daab379a97f4dbc197f8819eb378c1e17ef79cdf74d1129070799238e8d94e0cb6247023f2b070','2023-10-04',NULL),(3,'nguyenvana','user1@12',2,'nguyendangha2405@gmail.com','Dương','Nguyễn Đăng',NULL,1,'1000:ec46d967a57bf7e9fcf02936a814bcbb:c6e003ff0f5fd0e54d252c7248df7f38647f4f5201cf22d310daab379a97f4dbc197f8819eb378c1e17ef79cdf74d1129070799238e8d94e0cb6247023f2b070',NULL,NULL),(4,'nguyenvana1','user1@12',2,'nguyendangha2405@gmail.com','Lê','Thương',NULL,1,'1000:ec46d967a57bf7e9fcf02936a814bcbb:c6e003ff0f5fd0e54d252c7248df7f38647f4f5201cf22d310daab379a97f4dbc197f8819eb378c1e17ef79cdf74d1129070799238e8d94e0cb6247023f2b070',NULL,NULL),(5,'dangha2405','user1122312#A',2,'nguyendangha2405@gmail.com','Nguyễn','Thương',NULL,1,'1000:cf5be10b0a819b9c8c1f15c7f999e2f1:6bad2ce70a7b3efafce90cb2f5dcadb83eb9ebca7224b8586a54f0a8eb4e09aba99ea9ef1d6b0bb0c6f7b10025426f90eb1279390879bcf3351d4e9acdb9e760',NULL,NULL),(6,'dangha24052003','Dangha2405*#',2,'hand.22itb@vku.udn.vn','Nguyễn','Văn A',NULL,1,'1000:aba5bf7a649b2e87611c94764d758031:587df896bb47622359e601f5383627a6469d9cdad6d2752ae3a42f63cabdd2fe8408fa4d892b20b9b97d16b625a40f551e5ef79178897ed0e27bba37889b62f1',NULL,NULL),(7,'dangha2412','Dangha2405*#',2,'dangha24052003@gmail.com','Lê','Tuân',NULL,1,'1000:0081408aafbcc92b09f30f6f5a4a884a:4ee375d1272918454590fe59682e9798d5a259d4f33d27612e25dffb35fb892b0ba9dd1854063d531e016b797115ca3a3faa7c7a364ce9ab4b5216e6be5efdd4',NULL,NULL);
/*!40000 ALTER TABLE `ta_aut_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_brand_categories`
--

DROP TABLE IF EXISTS `ta_brand_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_brand_categories` (
  `I_ID_BRAND` bigint(20) NOT NULL,
  `I_ID_CATEGORIES` bigint(20) NOT NULL,
  KEY `I_BRAND_CATEGORIES_FK` (`I_ID_BRAND`),
  KEY `I_BRAND_CATEGORIES_FK_1` (`I_ID_CATEGORIES`),
  CONSTRAINT `I_BRAND_CATEGORIES_FK` FOREIGN KEY (`I_ID_BRAND`) REFERENCES `ta_aut_brand` (`I_ID`),
  CONSTRAINT `I_BRAND_CATEGORIES_FK_1` FOREIGN KEY (`I_ID_CATEGORIES`) REFERENCES `ta_aut_category` (`I_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_brand_categories`
--

LOCK TABLES `ta_brand_categories` WRITE;
/*!40000 ALTER TABLE `ta_brand_categories` DISABLE KEYS */;
INSERT INTO `ta_brand_categories` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(1,2);
/*!40000 ALTER TABLE `ta_brand_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_user_otp`
--

DROP TABLE IF EXISTS `ta_user_otp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ta_user_otp` (
  `I_ID` int(11) NOT NULL AUTO_INCREMENT,
  `I_ID_USER` bigint(20) NOT NULL,
  `T_TOKEN` varchar(100) NOT NULL,
  `I_STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`I_ID`),
  KEY `ta_user_otp_FK` (`I_ID_USER`),
  CONSTRAINT `ta_user_otp_FK` FOREIGN KEY (`I_ID_USER`) REFERENCES `ta_aut_user` (`I_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_user_otp`
--

LOCK TABLES `ta_user_otp` WRITE;
/*!40000 ALTER TABLE `ta_user_otp` DISABLE KEYS */;
INSERT INTO `ta_user_otp` VALUES (1,2,'2934',2),(2,7,'931951',2),(3,7,'584079',2),(4,7,'648408',2),(5,2,'218124',2),(6,7,'149232',2),(7,4,'439999',2),(8,7,'968369',2),(9,7,'245296',2),(10,7,'759933',2),(11,7,'742301',2),(12,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyODg5ODcsImlkIjo3fQ.dpxMkx-o03wG8LUrLDwydMXg2BBxSB1869YGR0ylbBg',2),(13,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTAyNDEsImlkIjo3fQ.J0g4KeS9mu3tEhGls-8JAwdfm7gzkmgkcL9Fv7a_-EA',1),(14,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTA1MjUsImlkIjo3fQ.uczdXcg7yRoAZDCC3QefyDEU1DbfstUiDf9xOu5hmgc',1),(15,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTExOTYsImlkIjo3fQ.zh1iMrGmZR0I9hiQeyUVYEjHu-TscIlAtt3FlZyq2Y0',1),(16,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTE4MjUsImlkIjo3fQ.8N7g0yIl16yOPhoqS2Pl1HthiZ4u6BSxVfakT3We6Fo',1),(17,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTMwODMsImlkIjo3fQ.MO_cQEwMFdCzGIREkzZUAPp14hwjD9W3aecSFjPq-aM',1),(18,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTMxNTMsImlkIjo3fQ.wZI3Zb3XPfThCm6akQZBhiCpN68bNpq2ilizq0wNOL0',1),(19,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTMxODcsImlkIjo3fQ.X1stLWxr2U8OqLLS32-GAOQpQpXfE5JAkgbQ51qh4gQ',1),(20,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTQwNzUsImlkIjo3fQ.OcLgM7-xSlJ4jJGzT9QA7TnCZs_T4JnTQHeeIg-EaRg',1),(21,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTUyNjcsImlkIjo3fQ.3sFWqttnBnj8jNmO9gk2ZcYEo-rN2vwkWLv1zOv7OkM',1),(22,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcyOTU2MDEsImlkIjo3fQ.LrQfWbmwKsGofMorc16bUPR4kjwBiFbymcjmI-6V-Dc',1),(23,7,'eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDA2MjM5MDUsImlkIjo3fQ.YGFvbrw7DB_IiML1yyS8g6qQP3xTMPoap5MRq6GiW8M',1);
/*!40000 ALTER TABLE `ta_user_otp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-01 13:33:46
