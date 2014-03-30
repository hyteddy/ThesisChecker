SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` INT NULL DEFAULT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `salt` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  `token` VARCHAR(255) NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT '1',
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `deleted_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`analysis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`analysis` (
  `id` INT NULL DEFAULT NULL AUTO_INCREMENT,
  `date` DATETIME NULL DEFAULT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  `result` DECIMAL(18,2) NULL DEFAULT NULL,
  `file_type` VARCHAR(255) NULL DEFAULT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `deleted_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`user_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`resource`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`resource` (
  `id` INT NULL DEFAULT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  `file_type` VARCHAR(255) NULL DEFAULT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `deleted_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`user_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`user_update`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_update` (
  `id` INT NULL DEFAULT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `token` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`user_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`analysis_has_resource`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`analysis_has_resource` (
  `analysis_id` INT NOT NULL,
  `resource_id` INT NOT NULL,
  PRIMARY KEY (`analysis_id`, `resource_id`),
  INDEX `fk_analysis_has_resource_resource1_idx` (`resource_id` ASC),
  INDEX `fk_analysis_has_resource_analysis1_idx` (`analysis_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`user_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_profile` (
  `id` INT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `postal_code` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `deleted_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_idx` (`user_id` ASC),
  CONSTRAINT `id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
