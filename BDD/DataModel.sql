SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Compte`;
DROP TABLE IF EXISTS `Transaction`;
DROP TABLE IF EXISTS `Message`;
DROP TABLE IF EXISTS `Cours_de_la_bourse`;
DROP TABLE IF EXISTS `Actualite`;
DROP TABLE IF EXISTS `Services_de_la_banque`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `User` (
    `id_user` INTEGER NOT NULL,
    `categorie_user` VARCHAR(15) NOT NULL,
    `nom` VARCHAR(15) NOT NULL,
    `prenon` VARCHAR(15) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `adresse` VARCHAR(50) NOT NULL,
    `telephone` INTEGER(30) NOT NULL,
    `ville` VARCHAR(15) NOT NULL,
    `pays` VARCHAR(15) NOT NULL,
    `dateNaissance` DATE NOT NULL,
    PRIMARY KEY (`id_user`)
);

CREATE TABLE `Compte` (
    `id_compte` INTEGER NOT NULL,
    `id_user` INTEGER NOT NULL,
    `categorie_compte` VARCHAR(15) NOT NULL,
    `etat` VARCHAR(15) NOT NULL,
    `solde` BIGINT NOT NULL,
    `date_create` DATE NOT NULL,
    `date_delete` DATE NOT NULL,
    PRIMARY KEY (`id_compte`)
);

CREATE TABLE `Transaction` (
    `id_transaction` INTEGER NOT NULL,
    `categorie_transaction` VARCHAR(15) NOT NULL,
    `id_compte_emetteur` INTEGER NOT NULL,
    `id_compte_recepteur` INTEGER NOT NULL,
    `date` DATE NOT NULL,
    `Somme` BIGINT NOT NULL,
    `description` TEXT NOT NULL,
    PRIMARY KEY (`id_transaction`)
);

CREATE TABLE `Message` (
    `id_message` INTEGER NOT NULL,
    `nom` VARCHAR(15) NOT NULL,
    `prenon` VARCHAR(15) NOT NULL,
    `numphone` INTEGER(30) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `problem` TEXT NOT NULL,
    `reponse` TEXT NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (`id_message`)
);

CREATE TABLE `Cours_de_la_bourse` (
    `id_entreprise` INTEGER NOT NULL,
    `entreprise` VARCHAR(15) NOT NULL,
    `prix` INTEGER NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (`id_entreprise`)
);

CREATE TABLE `Actualite` (
    `id_actualite` INTEGER NOT NULL,
    `date` DATE NOT NULL,
    `title` TEXT NOT NULL,
    `text` TEXT NOT NULL,
    PRIMARY KEY (`id_actualite`)
);

CREATE TABLE `Services_de_la_banque` (
    `id_service` INTEGER NOT NULL,
    `nom_service` VARCHAR(15) NOT NULL,
    `prix` INTEGER NOT NULL,
    `description` TEXT NOT NULL,
    PRIMARY KEY (`id_service`)
);
