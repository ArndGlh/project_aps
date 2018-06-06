-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le :  mer. 06 juin 2018 à 15:04
-- Version du serveur :  5.6.38
-- Version de PHP :  7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `projet_aps`
--

-- --------------------------------------------------------

--
-- Structure de la table `EVENT`
--

CREATE TABLE `EVENT` (
  `ID` int(40) NOT NULL,
  `NAME` varchar(80) NOT NULL,
  `IDLIEU` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `DESCRIPTION` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `JEU`
--

CREATE TABLE `JEU` (
  `ID` int(40) NOT NULL,
  `NAME` varchar(80) NOT NULL,
  `REGLE` longtext NOT NULL,
  `DE` tinyint(1) NOT NULL,
  `CARTE` tinyint(1) NOT NULL,
  `NOMBREJOUEURMIN` int(3) NOT NULL,
  `NOMBREJOUEURMAX` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `LIEU`
--

CREATE TABLE `LIEU` (
  `ID` int(40) NOT NULL,
  `NAME` varchar(80) NOT NULL,
  `LONG` varchar(80) NOT NULL,
  `LAT` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `PARTICIPANT`
--

CREATE TABLE `PARTICIPANT` (
  `IDUSER` int(40) NOT NULL,
  `IDEVENT` int(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `USER`
--

CREATE TABLE `USER` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(80) DEFAULT NULL,
  `USERPASSWORD` varchar(80) DEFAULT NULL,
  `USERMAIL` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `USER`
--

INSERT INTO `USER` (`ID`, `USERNAME`, `USERPASSWORD`, `USERMAIL`) VALUES
(1, 'p', 'p', NULL),
(2, 't', 't', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `EVENT`
--
ALTER TABLE `EVENT`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_lieu_EVENT` (`IDLIEU`);

--
-- Index pour la table `JEU`
--
ALTER TABLE `JEU`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `LIEU`
--
ALTER TABLE `LIEU`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `PARTICIPANT`
--
ALTER TABLE `PARTICIPANT`
  ADD PRIMARY KEY (`IDUSER`,`IDEVENT`),
  ADD KEY `FK_participant_event` (`IDEVENT`);

--
-- Index pour la table `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `EVENT`
--
ALTER TABLE `EVENT`
  MODIFY `ID` int(40) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `JEU`
--
ALTER TABLE `JEU`
  MODIFY `ID` int(40) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `LIEU`
--
ALTER TABLE `LIEU`
  MODIFY `ID` int(40) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `USER`
--
ALTER TABLE `USER`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `EVENT`
--
ALTER TABLE `EVENT`
  ADD CONSTRAINT `FK_lieu_EVENT` FOREIGN KEY (`IDLIEU`) REFERENCES `LIEU` (`ID`);

--
-- Contraintes pour la table `PARTICIPANT`
--
ALTER TABLE `PARTICIPANT`
  ADD CONSTRAINT `FK_participant_event` FOREIGN KEY (`IDEVENT`) REFERENCES `EVENT` (`ID`),
  ADD CONSTRAINT `FK_participant_user` FOREIGN KEY (`IDUSER`) REFERENCES `USER` (`ID`);
