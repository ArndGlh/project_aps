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
  `LIEU` varchar(255) NOT NULL,
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

--
-- Structure de la table `PARTICIPANT`
--

CREATE TABLE `PARTICIPANT` (
  `IDUSER` int(40) NOT NULL,
  `IDEVENT` int(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `CONTACT`
--

CREATE TABLE `CONTACT` (
  `IDUSER1` int(40) NOT NULL,
  `IDUSER2` int(40) NOT NULL
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
-- Index pour les tables déchargées
--

--
-- Index pour la table `EVENT`
--
ALTER TABLE `EVENT`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `JEU`
--
ALTER TABLE `JEU`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `PARTICIPANT`
--
ALTER TABLE `PARTICIPANT`
  ADD PRIMARY KEY (`IDUSER`,`IDEVENT`),
  ADD KEY `FK_participant_event` (`IDEVENT`);

--
-- Index pour la table `CONTACT`
--
ALTER TABLE `CONTACT`
  ADD PRIMARY KEY (`IDUSER1`,`IDUSER2`),
  ADD KEY `FK_user1` (`IDUSER1`),
  ADD KEY `FK_user2` (`IDUSER2`);

--
-- Index pour la table `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `EVENT`
  MODIFY `ID` int(40) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `JEU`
--
ALTER TABLE `JEU`
  MODIFY `ID` int(40) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `USER`
--
ALTER TABLE `USER`
  MODIFY `ID` int(40) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `EVENT`
--
/*ALTER TABLE `EVENT`
  ADD CONSTRAINT `FK_lieu_EVENT` FOREIGN KEY (`IDLIEU`) REFERENCES `LIEU` (`ID`);*/

--
-- Contraintes pour la table `PARTICIPANT`
--
ALTER TABLE `PARTICIPANT`
  ADD CONSTRAINT `FK_participant_event` FOREIGN KEY (`IDEVENT`) REFERENCES `EVENT` (`ID`),
  ADD CONSTRAINT `FK_participant_user` FOREIGN KEY (`IDUSER`) REFERENCES `USER` (`ID`);

--
-- Contraintes pour la table `CONTACT`
--
ALTER TABLE `CONTACT`
  ADD CONSTRAINT `FK_user1` FOREIGN KEY (`IDUSER1`) REFERENCES `USER` (`ID`),
  ADD CONSTRAINT `FK_user2` FOREIGN KEY (`IDUSER2`) REFERENCES `USER` (`ID`);

--
-- Déchargement des données de la table `EVENT`
--
INSERT INTO `event` (`NAME`, `LIEU`, `DATE`, `DESCRIPTION`) VALUES ('Event 1', 'Montpellier', '2018-07-24', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar, nisi eget imperdiet ornare, risus neque ullamcorper augue, ullamcorper tempor felis nisl vel sapien. Nullam dui mauris, bibendum ut aliquet in, fringilla ac magna. Donec feugiat lorem id blandit facilisis. Sed luctus, magna eu scelerisque interdum, magna turpis viverra nunc, quis elementum nisi arcu eget metus. Quisque finibus turpis dui, vel consequat dolor ornare nec. Duis mi dui, euismod non finibus ac, imperdiet tempor nulla. Nam ante augue, tincidunt nec imperdiet nec, lobortis id purus. Aenean porttitor diam in velit vehicula sodales. Donec dapibus, enim vel blandit varius, libero augue.'),
('Event 2', 'Paris', '2018-07-11', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar, nisi eget imperdiet ornare, risus neque ullamcorper augue, ullamcorper tempor felis nisl vel sapien. Nullam dui mauris, bibendum ut aliquet in, fringilla ac magna. Donec feugiat lorem id blandit facilisis. Sed luctus, magna eu scelerisque interdum, magna turpis viverra nunc, quis elementum nisi arcu eget metus. Quisque finibus turpis dui, vel consequat dolor ornare nec. Duis mi dui, euismod non finibus ac, imperdiet tempor nulla. Nam ante augue, tincidunt nec imperdiet nec, lobortis id purus. Aenean porttitor diam in velit vehicula sodales. Donec dapibus, enim vel blandit varius, libero augue.');


--
-- Déchargement des données de la table `JEU`
--
INSERT INTO `jeu` (`NAME`, `REGLE`, `DE`, `CARTE`, `NOMBREJOUEURMIN`, `NOMBREJOUEURMAX`) VALUES ('Yahtzee', 'Les règles sont très variables et de nombreuses variantes existent dans l\'établissement de la feuille de score et dans le décompte des points. Cependant la logique de probabilité se doit d\'être respectée (par exemple, une petite suite ne peut pas être de 5 dés vu que la grande suite se compose également de 5 dés). Il est conseillé aux joueurs de s\'entendre au début de la partie. Les explications ci-dessous constituent un exemple de jeu courant.\r\n\r\nChaque joueur lance les dés lorsque vient son tour. Son but est, à l\'aide des cinq dés, de réaliser une figure (5 dés identiques, une paire, un triplet...). Pour réaliser cette figure, il a le droit à trois jets de dés par tour et il est à chaque jet libre de les relancer tous ou juste ceux de son choix.\r\n\r\nLe gagnant est celui qui a fait le plus de points, certaines figures donnant des points supplémentaires si elles sont réussies.\r\n\r\nLa feuille de score est généralement divisée en deux parties. Cependant, certaines versions acceptent une troisième partie, celle nommée partie intermédiaire.\r\n\r\nLe nombre maximal de points est de 390.', '1', '0', '2', '-1'),
('Président', 'L’ordre des cartes est le suivant : joker, 2, As, Roi, Dame, Valet, 10, 9, 8, 7, 6, 5, 4, 3.\r\n\r\nAu début de la partie, chaque joueur tire une carte. La plus forte désigne le président, la deuxième plus forte le vice président, etc… Si deux joueurs tirent une carte de même rang, ils retirent chacun une carte pour se départager.\r\n\r\nLes joueurs se placent autour de la table dans l’ordre des positions sociales (président, vice-président à sa gauche, puis trésorier, puis trou du cul).\r\n\r\nLe président distribue alors les cartes en commançant par lui et en continuant par le vice-président. A la fin de la distribution, le président a donc une carte de plus que les autres joueurs.\r\n\r\nLe président donne ses deux cartes les plus faibles au trou du cul, et inversement, le trou du cul donne ses deux meilleures cartes au président. Le trésorier échange sa meilleure carte contre la carte la plus faible du vice-président.\r\n\r\nLe président commence à jouer. Il pose une carte ou une combinaison de plusieurs cartes de même rang. Chaque joueur, en commançant par le vice-président, peut :\r\n\r\nsoit poser une combinaison identique, mais avec des cartes de plus fort rang (exemple : deux As sur deux Dames),\r\nsoit passer (un joueur n’est jamais obligé de poser une combinaison).\r\nLe joueur ayant posé la plus forte combinaison remporte le pli et peut entamer le tour suivant.\r\n\r\nLe joueur qui s’est débarassé de ses cartes le premier remporte la manche. Il deviendra président au tour suivant. Le deuxième deviendra vice-président ; le troisième trésorier et le dernier trou du cul. Les joueurs changent alors de place en fonction de leur nouveau rang social.\r\n\r\nLa partie s’arrête quand les joueurs le décident.', '0', '1', '3', '6');

-- --------------------------------------------------------

--
-- Déchargement des données de la table `USER`
--

INSERT INTO `user` (`USERNAME`, `USERPASSWORD`, `USERMAIL`) VALUES ('clement', 'clement', 'clement.correia@espi.fr'),
('arnaud', 'arnaud', 'arnaud.guilhaumon@espi.fr'),
('hugo', 'hugo', 'hugo.severin@espi.fr'),
('leonard', 'leonard', 'leonard.pasquier@espi.fr');



--
-- Déchargement des données de la table `PARTICIPANT`
--

INSERT INTO `participant` (`IDUSER`, `IDEVENT`) VALUES ('2', '1'), ('1', '1'), ('3', '2'), ('4', '2'), ('2', '2');

--
-- Déchargement des données de la table `CONTACT`
--
INSERT INTO `contact` (`IDUSER1`, `IDUSER2`) VALUES ('2', '1'), ('2', '3'), ('1', '4'), ('4', '3');