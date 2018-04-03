SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Compte`;
DROP TABLE IF EXISTS `Transaction`;
DROP TABLE IF EXISTS `Message`;
DROP TABLE IF EXISTS `CoursDeLaBourse`;
DROP TABLE IF EXISTS `Actualite`;
DROP TABLE IF EXISTS `ServicesDeLaBanque`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `User` (
    `id_user` INTEGER NOT NULL AUTO_INCREMENT,
    `categorie_user` VARCHAR(15) NOT NULL,
    `nom` VARCHAR(15) NOT NULL,
    `prenon` VARCHAR(15) NOT NULL,
    `email` VARCHAR(30) NOT NULL UNIQUE,
    `adresse` VARCHAR(50),
    `telephone` VARCHAR(30),
    `ville` VARCHAR(15),
    `pays` VARCHAR(15),
    `password` VARCHAR(30) NOT NULL,
    `dateNaissance` DATE,
    PRIMARY KEY (`id_user`)
) ENGINE=InnoDB;

CREATE TABLE `Compte` (
    `id_compte` INTEGER NOT NULL AUTO_INCREMENT,
    `id_user` INTEGER NOT NULL,
    `categorie_compte` VARCHAR(15) NOT NULL,
    `etat` VARCHAR(15) NOT NULL,
    `solde` FLOAT NOT NULL,
    `date_create` DATE NOT NULL,
    `date_delete` DATE NOT NULL,
    PRIMARY KEY (`id_compte`)
) ENGINE=InnoDB;

CREATE TABLE `Transaction` (
    `id_transaction` INTEGER NOT NULL AUTO_INCREMENT,
    `categorie_transaction` VARCHAR(15) NOT NULL,
    `id_compte_emetteur` INTEGER,
    `id_compte_recepteur` INTEGER,
    `date` DATE NOT NULL,
    `somme` FLOAT NOT NULL,
    `description` TEXT NOT NULL,
    PRIMARY KEY (`id_transaction`)
) ENGINE=InnoDB;

CREATE TABLE `Message` (
    `id_message` INTEGER NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(15) NOT NULL,
    `prenom` VARCHAR(15) NOT NULL,
    `numphone` VARCHAR(30) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `problem` VARCHAR(300) NOT NULL UNIQUE,
    `reponse` TEXT,
    `date` DATETIME NOT NULL,
    PRIMARY KEY (`id_message`)
) ENGINE=InnoDB;

CREATE TABLE `CoursDeLaBourse` (
    `id_entreprise` INTEGER NOT NULL AUTO_INCREMENT,
    `entreprise` VARCHAR(15) NOT NULL,
    `prix` FLOAT NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (`id_entreprise`)
) ENGINE=InnoDB;

CREATE TABLE `Actualite` (
    `id_actualite` INTEGER NOT NULL AUTO_INCREMENT,
    `date` DATE NOT NULL,
    `title` TEXT NOT NULL,
    `text` TEXT NOT NULL,
    PRIMARY KEY (`id_actualite`)
) ENGINE=InnoDB;

CREATE TABLE `ServicesDeLaBanque` (
    `id_service` INTEGER NOT NULL AUTO_INCREMENT,
    `nom_service` VARCHAR(15) NOT NULL,
    `prix` FLOAT NOT NULL,
    `description` TEXT NOT NULL,
    PRIMARY KEY (`id_service`)
) ENGINE=InnoDB;

ALTER TABLE `Compte` ADD FOREIGN KEY (`id_user`) REFERENCES `User`(`id_user`);
ALTER TABLE `Transaction` ADD FOREIGN KEY (`id_compte_emetteur`) REFERENCES `Compte`(`id_compte`);
ALTER TABLE `Transaction` ADD FOREIGN KEY (`id_compte_recepteur`) REFERENCES `Compte`(`id_compte`);