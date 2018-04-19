-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 29 Mars 2018 à 16:01
-- Version du serveur :  5.7.21-0ubuntu0.16.04.1
-- Version de PHP :  7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `festival_billetterie`
--
CREATE DATABASE IF NOT EXISTS `festival_billetterie` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `festival_billetterie`;

-- --------------------------------------------------------

--
-- Structure de la table `Attribution`
--

DROP TABLE IF EXISTS `Attribution`;
CREATE TABLE IF NOT EXISTS `Attribution` (
  `idEtab` char(8) COLLATE utf8_unicode_ci NOT NULL,
  `idTypeChambre` char(2) COLLATE utf8_unicode_ci NOT NULL,
  `idGroupe` char(4) COLLATE utf8_unicode_ci NOT NULL,
  `nombreChambres` int(11) NOT NULL,
  PRIMARY KEY (`idEtab`,`idTypeChambre`,`idGroupe`),
  KEY `idTypeChambre` (`idTypeChambre`),
  KEY `idGroupe` (`idGroupe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Vider la table avant d'insérer `Attribution`
--

TRUNCATE TABLE `Attribution`;
--
-- Contenu de la table `Attribution`
--

INSERT INTO `Attribution` (`idEtab`, `idTypeChambre`, `idGroupe`, `nombreChambres`) VALUES
('0350773A', 'C2', 'g004', 2),
('0350773A', 'C3', 'g005', 1),
('0350785N', 'C1', 'g001', 1),
('0350785N', 'C1', 'g002', 2),
('0350785N', 'C1', 'g003', 2),
('0350785N', 'C2', 'g001', 2),
('0350785N', 'C2', 'g002', 1),
('0350785N', 'C3', 'g001', 2),
('0350785N', 'C3', 'g002', 1),
('0352072M', 'C1', 'g006', 1),
('0352072M', 'C2', 'g007', 3),
('0352072M', 'C3', 'g006', 3);

-- --------------------------------------------------------

--
-- Structure de la table `Etablissement`
--

DROP TABLE IF EXISTS `Etablissement`;
CREATE TABLE IF NOT EXISTS `Etablissement` (
  `id` char(8) COLLATE utf8_unicode_ci NOT NULL,
  `nom` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `adresseRue` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `codePostal` char(5) COLLATE utf8_unicode_ci NOT NULL,
  `ville` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `tel` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `adresseElectronique` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` tinyint(4) NOT NULL,
  `civiliteResponsable` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `nomResponsable` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `prenomResponsable` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Vider la table avant d'insérer `Etablissement`
--

TRUNCATE TABLE `Etablissement`;
--
-- Contenu de la table `Etablissement`
--

INSERT INTO `Etablissement` (`id`, `nom`, `adresseRue`, `codePostal`, `ville`, `tel`, `adresseElectronique`, `type`, `civiliteResponsable`, `nomResponsable`, `prenomResponsable`) VALUES
('0350773A', 'Collège Ste Jeanne d\'Arc-Choisy', '3, avenue de la Borderie BP 32', '35404', 'Paramé', '0299560159', '', 1, 'Madame', 'LEFORT', 'Anne'),
('0350785N', 'Collège de Moka', '2 avenue Aristide Briand BP 6', '35401', 'Saint-Malo', '0299206990', NULL, 1, 'Monsieur', 'DUPONT', 'Alain'),
('0352072M', 'Institution Saint-Malo Providence', '2 rue du collège BP 31863', '35418', 'Saint-Malo', '0299407474', NULL, 1, 'Monsieur', 'DURAND', 'Pierre');

-- --------------------------------------------------------

--
-- Structure de la table `Groupe`
--

DROP TABLE IF EXISTS `Groupe`;
CREATE TABLE IF NOT EXISTS `Groupe` (
  `id` char(4) COLLATE utf8_unicode_ci NOT NULL,
  `nom` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `identiteResponsable` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adressePostale` varchar(120) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombrePersonnes` int(11) NOT NULL,
  `nomPays` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `hebergement` char(1) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Vider la table avant d'insérer `Groupe`
--

TRUNCATE TABLE `Groupe`;
--
-- Contenu de la table `Groupe`
--

INSERT INTO `Groupe` (`id`, `nom`, `identiteResponsable`, `adressePostale`, `nombrePersonnes`, `nomPays`, `hebergement`) VALUES
('g001', 'Groupe folklorique du Bachkortostan', NULL, NULL, 40, 'Bachkirie', 'O'),
('g002', 'Marina Prudencio Chavez', NULL, NULL, 25, 'Bolivie', 'O'),
('g003', 'Nangola Bahia de Salvador', NULL, NULL, 34, 'Brésil', 'O'),
('g004', 'Bizone de Kawarma', NULL, NULL, 38, 'Bulgarie', 'O'),
('g005', 'Groupe folklorique camerounais', NULL, NULL, 22, 'Cameroun', 'O'),
('g006', 'Syoung Yaru Mask Dance Group', NULL, NULL, 29, 'Corée du Sud', 'O'),
('g007', 'Pipe Band', NULL, NULL, 19, 'Ecosse', 'O'),
('g008', 'Aira da Pedra', NULL, NULL, 5, 'Espagne', 'O'),
('g009', 'The Jersey Caledonian Pipe Band', NULL, NULL, 21, 'Jersey', 'O'),
('g010', 'Groupe folklorique des Émirats', NULL, NULL, 30, 'Emirats arabes unis', 'O'),
('g011', 'Groupe folklorique mexicain', NULL, NULL, 38, 'Mexique', 'O'),
('g012', 'Groupe folklorique de Panama', NULL, NULL, 22, 'Panama', 'O'),
('g013', 'Groupe folklorique papou', NULL, NULL, 13, 'Papouasie', 'O'),
('g014', 'Paraguay Ete', NULL, NULL, 26, 'Paraguay', 'O'),
('g015', 'La Tuque Bleue', NULL, NULL, 8, 'Québec', 'O'),
('g016', 'Ensemble Leissen de Oufa', NULL, NULL, 40, 'République de Bachkirie', 'O'),
('g017', 'Groupe folklorique turc', NULL, NULL, 40, 'Turquie', 'O'),
('g018', 'Groupe folklorique russe', NULL, NULL, 43, 'Russie', 'O'),
('g019', 'Ruhunu Ballet du village de Kosgoda', NULL, NULL, 27, 'Sri Lanka', 'O'),
('g020', 'L\'Alen', NULL, NULL, 34, 'France - Provence', 'O'),
('g021', 'L\'escolo Di Tourre', NULL, NULL, 40, 'France - Provence', 'O'),
('g022', 'Deloubes Kévin', NULL, NULL, 1, 'France - Bretagne', 'O'),
('g023', 'Daonie See', NULL, NULL, 5, 'France - Bretagne', 'O'),
('g024', 'Boxty', NULL, NULL, 5, 'France - Bretagne', 'O'),
('g025', 'Soeurs Chauvel', NULL, NULL, 2, 'France - Bretagne', 'O'),
('g026', 'Cercle Gwik Alet', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g027', 'Bagad Quic En Groigne', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g028', 'Penn Treuz', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g029', 'Savidan Launay', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g030', 'Cercle Boked Er Lann', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g031', 'Bagad Montfortais', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g032', 'Vent de Noroise', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g033', 'Cercle Strollad', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g034', 'Bagad An Hanternoz', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g035', 'Cercle Ar Vro Melenig', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g036', 'Cercle An Abadenn Nevez', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g037', 'Kerc\'h Keltiek Roazhon', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g038', 'Bagad Plougastel', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g039', 'Bagad Nozeganed Bro Porh-Loeiz', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g040', 'Bagad Nozeganed Bro Porh-Loeiz', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g041', 'Jackie Molard Quartet', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g042', 'Deomp', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g043', 'Cercle Olivier de Clisson', NULL, NULL, 0, 'France - Bretagne', 'N'),
('g044', 'Kan Tri', NULL, NULL, 0, 'France - Bretagne', 'N');

-- --------------------------------------------------------

--
-- Structure de la table `Lieu`
--

DROP TABLE IF EXISTS `Lieu`;
CREATE TABLE IF NOT EXISTS `Lieu` (
  `id` int(5) NOT NULL,
  `nom` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adr` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Vider la table avant d'insérer `Lieu`
--

TRUNCATE TABLE `Lieu`;
--
-- Contenu de la table `Lieu`
--

INSERT INTO `Lieu` (`id`, `nom`, `adr`, `capacite`) VALUES
(1, 'SALLE DU PANIER FLEURI', 'Rue de Boneville', 450),
(2, 'LE CABARET', 'MAIRIE ANNEXE DE PARAME, Place Georges COUDRAY', 250),
(3, 'LE PARC DES CHENES', '14 rue des chênes', 2000),
(4, 'LE VILLAGE', 'Ecole LEGATELOIS, 25 rue Général de Catselnau', 500);

-- --------------------------------------------------------

--
-- Structure de la table `Offre`
--

DROP TABLE IF EXISTS `Offre`;
CREATE TABLE IF NOT EXISTS `Offre` (
  `idEtab` char(8) COLLATE utf8_unicode_ci NOT NULL,
  `idTypeChambre` char(2) COLLATE utf8_unicode_ci NOT NULL,
  `nombreChambres` int(11) NOT NULL,
  PRIMARY KEY (`idEtab`,`idTypeChambre`),
  KEY `idTypeChambre` (`idTypeChambre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Vider la table avant d'insérer `Offre`
--

TRUNCATE TABLE `Offre`;
--
-- Contenu de la table `Offre`
--

INSERT INTO `Offre` (`idEtab`, `idTypeChambre`, `nombreChambres`) VALUES
('0350773A', 'C2', 15),
('0350773A', 'C3', 1),
('0350785N', 'C1', 5),
('0350785N', 'C2', 10),
('0350785N', 'C3', 5),
('0352072M', 'C1', 5),
('0352072M', 'C2', 10),
('0352072M', 'C3', 3);

-- --------------------------------------------------------

--
-- Structure de la table `Representation`
--

DROP TABLE IF EXISTS `Representation`;
CREATE TABLE IF NOT EXISTS `Representation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_rep` date NOT NULL,
  `id_lieu` int(11) NOT NULL,
  `id_groupe` char(4) COLLATE utf8_unicode_ci NOT NULL,
  `heureDebut` time DEFAULT NULL,
  `heureFin` time DEFAULT NULL,
  `nbPlace` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Lieu` (`id_lieu`),
  KEY `FK_Groupe` (`id_groupe`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Vider la table avant d'insérer `Representation`
--

TRUNCATE TABLE `Representation`;
--
-- Contenu de la table `Representation`
--

INSERT INTO `Representation` (`id`, `date_rep`, `id_lieu`, `id_groupe`, `heureDebut`, `heureFin`, `nbPlace`) VALUES
(1, '2017-07-11', 2, 'g024', '19:00:00', '20:00:00', 250),
(2, '2017-07-11', 3, 'g031', '11:00:00', '12:00:00', 2000),
(3, '2017-07-11', 3, 'g035', '12:00:00', '13:00:00', 2000),
(4, '2017-07-12', 1, 'g008', '20:30:00', '22:00:00', 450),
(5, '2017-07-12', 1, 'g009', '22:15:00', '23:30:00', 450),
(6, '2017-07-13', 2, 'g041', '20:30:00', '22:00:00', 250),
(7, '2017-07-14', 1, 'g020', '19:30:00', '21:00:00', 450),
(8, '2017-07-14', 1, 'g022', '21:15:00', '23:00:00', 450),
(9, '2017-07-14', 3, 'g010', '14:00:00', '14:30:00', 2000),
(10, '2017-07-14', 3, 'g011', '14:30:00', '15:00:00', 2000),
(11, '2017-07-14', 3, 'g012', '15:00:00', '15:30:00', 2000),
(12, '2017-07-14', 3, 'g013', '15:30:00', '16:00:00', 2000),
(13, '2017-07-14', 3, 'g017', '16:00:00', '16:30:00', 2000),
(14, '2017-07-14', 3, 'g018', '16:30:00', '17:00:00', 2000),
(15, '2017-07-14', 4, 'g032', '11:00:00', '12:00:00', 500),
(16, '2017-07-14', 4, 'g044', '15:00:00', '17:00:00', 500),
(17, '2017-07-14', 4, 'g042', '17:30:00', '19:30:00', 500),
(18, '2017-07-15', 4, 'g037', '11:00:00', '12:30:00', 500),
(19, '2017-07-15', 4, 'g025', '15:00:00', '16:00:00', 500),
(20, '2017-07-15', 4, 'g029', '16:30:00', '19:00:00', 500);

-- --------------------------------------------------------

--
-- Structure de la table `TypeChambre`
--

DROP TABLE IF EXISTS `TypeChambre`;
CREATE TABLE IF NOT EXISTS `TypeChambre` (
  `id` char(2) COLLATE utf8_unicode_ci NOT NULL,
  `libelle` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Vider la table avant d'insérer `TypeChambre`
--

TRUNCATE TABLE `TypeChambre`;
--
-- Contenu de la table `TypeChambre`
--

INSERT INTO `TypeChambre` (`id`, `libelle`) VALUES
('C1', '1 lit'),
('C2', '2 à 3 lits'),
('C3', '4 à 5 lits'),
('C4', '6 à 8 lits'),
('C5', '8 à 12 lits');

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

DROP TABLE IF EXISTS `Utilisateur`;
CREATE TABLE IF NOT EXISTS `Utilisateur` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(128) NOT NULL,
  `Password` varchar(128) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Vider la table avant d'insérer `Utilisateur`
--

TRUNCATE TABLE `Utilisateur`;
--
-- Contenu de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`Id`, `Login`, `Password`) VALUES
(1, '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Attribution`
--
ALTER TABLE `Attribution`
  ADD CONSTRAINT `fk1_Attribution` FOREIGN KEY (`idGroupe`) REFERENCES `Groupe` (`id`),
  ADD CONSTRAINT `fk2_Attribution` FOREIGN KEY (`idEtab`,`idTypeChambre`) REFERENCES `Offre` (`idEtab`, `idTypeChambre`);

--
-- Contraintes pour la table `Offre`
--
ALTER TABLE `Offre`
  ADD CONSTRAINT `fk1_Offre` FOREIGN KEY (`idEtab`) REFERENCES `Etablissement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_Offre` FOREIGN KEY (`idTypeChambre`) REFERENCES `TypeChambre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Representation`
--
ALTER TABLE `Representation`
  ADD CONSTRAINT `FK_Groupe` FOREIGN KEY (`id_groupe`) REFERENCES `Groupe` (`id`),
  ADD CONSTRAINT `FK_Lieu` FOREIGN KEY (`id_lieu`) REFERENCES `Lieu` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

--
-- Utilisateur festival
--
GRANT USAGE ON *.* TO 'festival'@'localhost' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON `festival_billetterie`.* TO 'festival'@'localhost' WITH GRANT OPTION;