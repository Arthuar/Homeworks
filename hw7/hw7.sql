CREATE SCHEMA IF NOT EXISTS osbb2;
USE osbb2;
CREATE TABLE IF NOT EXISTS  osbb2.building (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
adress VARCHAR(45) NOT NULL);

CREATE TABLE IF NOT EXISTS osbb2.members (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
first_name VARCHAR(45) NOT NULL,
last_name VARCHAR(45) NOT NULL,
allow2drive ENUM('1','0') NULL DEFAULT '0',
mail VARCHAR(45) NOT NULL,
ownership ENUM('1','0') NULL DEFAULT '1',
id_flat INT NOT NULL,
INDEX member2flat_idx (id_flat ASC) VISIBLE,
CONSTRAINT member2flat
FOREIGN KEY (id_flat)
REFERENCES osbb2.flat (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS osbb2.flat (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
flat_level TINYINT(2) NOT NULL,
flat_area DOUBLE NOT NULL,
flat_number INT NOT NULL,
id_building INT NOT NULL,
id_member INT NOT NULL,
INDEX flat2building_idx (id_building ASC) VISIBLE,
INDEX flat2member_idx (id_member ASC) VISIBLE,
CONSTRAINT flat2building
FOREIGN KEY (id_building)
REFERENCES osbb2.building(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT flat2member
FOREIGN KEY (id_member)
REFERENCES osbb2.member(id)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;



