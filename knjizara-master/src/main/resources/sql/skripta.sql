-- MySQL Script generated by MySQL Workbench
-- Mon Jan 18 12:19:10 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema knjizara
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Knjiga`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Knjiga` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Knjiga` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  `isbn` INT NOT NULL,
  `izdavackaKuca` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `godinaIzdavanja` DATE NOT NULL,
  `opis` VARCHAR(200) NOT NULL,
  `slika` VARCHAR(200) NOT NULL,
  `cena` REAL NOT NULL,
  `brojStranica` INT NOT NULL,
  `tipPoveza` VARCHAR(45) NOT NULL,
  `pismo` VARCHAR(45) NOT NULL,
  `jezik` VARCHAR(45) NOT NULL,
  `prosecnaOcena` REAL NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Knjiga_Zanr`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Knjiga_Zanr` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Knjiga_Zanr` (
  `Knjiga_id` INT NOT NULL,
  `Zanr_id` INT NOT NULL,
  INDEX `fk_Knjiga_Zanr_Knjiga1_idx` (`Knjiga_id` ASC),
  INDEX `fk_Knjiga_Zanr_Zanr1_idx` (`Zanr_id` ASC),
  CONSTRAINT `fk_Knjiga_Zanr_Knjiga1`
    FOREIGN KEY (`Knjiga_id`)
    REFERENCES `mydb`.`Knjiga` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Knjiga_Zanr_Zanr1`
    FOREIGN KEY (`Zanr_id`)
    REFERENCES `mydb`.`Zanr` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Komentar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Komentar` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Komentar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tekst` TEXT NOT NULL,
  `ocena` INT NOT NULL,
  `datum` DATE NOT NULL,
  `Korisnik_id` INT NOT NULL,
  `Knjiga_id` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Komentar_Korisnik1_idx` (`Korisnik_id` ASC),
  INDEX `fk_Komentar_Knjiga1_idx` (`Knjiga_id` ASC),
  CONSTRAINT `fk_Komentar_Korisnik1`
    FOREIGN KEY (`Korisnik_id`)
    REFERENCES `mydb`.`Korisnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Komentar_Knjiga1`
    FOREIGN KEY (`Knjiga_id`)
    REFERENCES `mydb`.`Knjiga` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Korisnik`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Korisnik` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Korisnik` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `korisnickoIme` VARCHAR(45) NOT NULL,
  `lozinka` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `datumRodjenja` DATE NOT NULL,
  `adresa` VARCHAR(45) NOT NULL,
  `brojTelefona` VARCHAR(45) NOT NULL,
  `datumVremeRegistracije` DATETIME NOT NULL,
  `uloga` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`KupljenaKnjiga`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`KupljenaKnjiga` ;

CREATE TABLE IF NOT EXISTS `mydb`.`KupljenaKnjiga` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brojPrimeraka` INT NOT NULL,
  `Knjiga_id` INT NOT NULL,
  `cena` REAL NOT NULL,
  `Kupovina_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_KupljenaKnjiga_Knjiga_idx` (`Knjiga_id` ASC),
  INDEX `fk_KupljenaKnjiga_Kupovina1_idx` (`Kupovina_id` ASC),
  CONSTRAINT `fk_KupljenaKnjiga_Knjiga`
    FOREIGN KEY (`Knjiga_id`)
    REFERENCES `mydb`.`Knjiga` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_KupljenaKnjiga_Kupovina1`
    FOREIGN KEY (`Kupovina_id`)
    REFERENCES `mydb`.`Kupovina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Kupovina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Kupovina` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Kupovina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cena` REAL NOT NULL,
  `datum` DATE NOT NULL,
  `brojKnjiga` INT NOT NULL,
  `Korisnik_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Kupovina_Korisnik1_idx` (`Korisnik_id` ASC),
  CONSTRAINT `fk_Kupovina_Korisnik1`
    FOREIGN KEY (`Korisnik_id`)
    REFERENCES `mydb`.`Korisnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LoyaltyKartica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LoyaltyKartica` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LoyaltyKartica` (
  `id` INT NOT NULL,
  `popust` INT NOT NULL,
  `poeni` INT NOT NULL,
  `Korisnik_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_LoyaltyKartica_Korisnik1_idx` (`Korisnik_id` ASC),
  CONSTRAINT `fk_LoyaltyKartica_Korisnik1`
    FOREIGN KEY (`Korisnik_id`)
    REFERENCES `mydb`.`Korisnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Zanr`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Zanr` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Zanr` (
  `id` INT NOT NULL,
  `ime` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
