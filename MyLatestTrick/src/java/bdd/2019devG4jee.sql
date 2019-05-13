-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 13 Mai 2019 à 11:34
-- Version du serveur :  5.5.59-0+deb8u1
-- Version de PHP :  5.6.33-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `2019devG4jee`
--

-- --------------------------------------------------------

--
-- Structure de la table `Commentaire`
--

CREATE TABLE IF NOT EXISTS `Commentaire` (
  `id_comment` int(11) NOT NULL,
  `text_comment` varchar(255) NOT NULL,
  `report` tinyint(1) NOT NULL,
  `id_video` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE IF NOT EXISTS `Utilisateur` (
`id_utilisateur` int(11) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `statut` varchar(30) NOT NULL,
  `pseudo_utilisateur` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Videos`
--

CREATE TABLE IF NOT EXISTS `Videos` (
`id_video` int(11) NOT NULL,
  `positive_vote` int(11) NOT NULL,
  `negative_vote` int(11) NOT NULL,
  `score` decimal(11,0) NOT NULL,
  `id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Commentaire`
--
ALTER TABLE `Commentaire`
 ADD KEY `id_video` (`id_video`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
 ADD PRIMARY KEY (`id_utilisateur`), ADD UNIQUE KEY `pseudo_utilisateur` (`pseudo_utilisateur`), ADD UNIQUE KEY `mail` (`mail`), ADD UNIQUE KEY `mail_2` (`mail`), ADD KEY `id_utilisateur` (`id_utilisateur`);

--
-- Index pour la table `Videos`
--
ALTER TABLE `Videos`
 ADD PRIMARY KEY (`id_video`), ADD KEY `id_utilisateur` (`id_utilisateur`), ADD KEY `id_utilisateur_2` (`id_utilisateur`), ADD KEY `id_utilisateur_3` (`id_utilisateur`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
MODIFY `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Videos`
--
ALTER TABLE `Videos`
MODIFY `id_video` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Commentaire`
--
ALTER TABLE `Commentaire`
ADD CONSTRAINT `Commentaire_ibfk_1` FOREIGN KEY (`id_video`) REFERENCES `Videos` (`id_video`);

--
-- Contraintes pour la table `Videos`
--
ALTER TABLE `Videos`
ADD CONSTRAINT `Videos_ibfk_1` FOREIGN KEY (`id_utilisateur`) REFERENCES `Utilisateur` (`id_utilisateur`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
