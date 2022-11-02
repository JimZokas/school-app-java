-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema schoolDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schoolDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schoolDB` DEFAULT CHARACTER SET utf8 ;
USE `schoolDB` ;

-- -----------------------------------------------------
-- Table `schoolDB`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolDB`.`teachers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `lastname_idx` (`lastname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schoolDB`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolDB`.`students` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `lastname_idx` (`lastname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schoolDB`.`courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolDB`.`courses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NULL,
  `teacher_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `teacher_id_idx` (`teacher_id` ASC) VISIBLE,
  CONSTRAINT `teacher_fk`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `schoolDB`.`teachers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schoolDB`.`student_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoolDB`.`student_course` (
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`student_id`, `course_id`),
  INDEX `students_fk_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `courses_fk`
    FOREIGN KEY (`course_id`)
    REFERENCES `schoolDB`.`courses` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `students_fk`
    FOREIGN KEY (`student_id`)
    REFERENCES `schoolDB`.`students` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE USER 'jim' IDENTIFIED BY '123456';

GRANT ALL ON `schoolDB`.* TO 'jim';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
