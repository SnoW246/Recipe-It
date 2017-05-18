DROP DATABASE IF EXISTS recipeit;

CREATE DATABASE recipeit CHARACTER SET utf8 COLLATE UTF8_GENERAL_CI;
USE recipeit;
SHOW TABLES;

ALTER TABLE `recipes` DROP FOREIGN KEY `recipes_fk0`;
ALTER TABLE `recipes` DROP FOREIGN KEY `recipes_fk1`;
ALTER TABLE `recipe_ingredients` DROP FOREIGN KEY `recipe_ingredients_fk0`;
ALTER TABLE `recipe_ingredients` DROP FOREIGN KEY `recipe_ingredients_fk1`;
ALTER TABLE `recipe_steps` DROP FOREIGN KEY `recipe_steps_fk0`;
ALTER TABLE `user_credentials` DROP FOREIGN KEY `user_credentials_fk0`;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `ingredients`;
DROP TABLE IF EXISTS `recipes`;
DROP TABLE IF EXISTS `cuisines`;
DROP TABLE IF EXISTS `recipe_ingredients`;
DROP TABLE IF EXISTS `recipe_steps`;
DROP TABLE IF EXISTS `user_credentials`;

CREATE TABLE `users` (
	`userID` INT(20) NOT NULL AUTO_INCREMENT,
	`username` varchar(20) NOT NULL UNIQUE,
	`password` varchar(20) NOT NULL,
	`name` varchar(50),
	`surname` varchar(50),
	`dob` DATE NOT NULL,
	`recipeCount` INT(20),
	`privilage` varchar(20) NOT NULL DEFAULT 'regular',
	PRIMARY KEY (`userID`)
);

CREATE TABLE `ingredients` (
	`ingredientID` INT(20) NOT NULL,
	`name` varchar(50) NOT NULL,
	PRIMARY KEY (`ingredientID`)
);

CREATE TABLE `cuisines` (
	`cuisineID` INT(20) NOT NULL,
	`cuisineName` varchar(50) NOT NULL UNIQUE,
	PRIMARY KEY (`cuisineID`)
);

CREATE TABLE `recipes` (
	`recipeID` INT(20) NOT NULL,
	`name` INT(70) NOT NULL,
	`cusineName` varchar(50) NOT NULL,
	`userID` INT(20) NOT NULL,
	PRIMARY KEY (`recipeID`)
);

CREATE TABLE `recipe_ingredients` (
	`recipeID` INT(20) NOT NULL,
	`ingredientID` INT(20) NOT NULL,
	`amount` varchar(4) NOT NULL,
	`measure` varchar(50) NOT NULL,
	PRIMARY KEY (`recipeID`,`ingredientID`)
);

CREATE TABLE `recipe_steps` (
	`recipeID` INT(20) NOT NULL,
	`stepID` INT(20) NOT NULL AUTO_INCREMENT,
	`description` varchar(500) NOT NULL,
	PRIMARY KEY (`recipeID`,`stepID`)
);

ALTER TABLE `recipes` ADD CONSTRAINT `recipes_fk0` FOREIGN KEY (`cusineName`) REFERENCES `cuisines`(`cuisineName`);
ALTER TABLE `recipes` ADD CONSTRAINT `recipes_fk1` FOREIGN KEY (`userID`) REFERENCES `users`(`userID`);
ALTER TABLE `recipe_ingredients` ADD CONSTRAINT `recipe_ingredients_fk0` FOREIGN KEY (`recipeID`) REFERENCES `recipes`(`recipeID`);
ALTER TABLE `recipe_ingredients` ADD CONSTRAINT `recipe_ingredients_fk1` FOREIGN KEY (`ingredientID`) REFERENCES `ingredients`(`ingredientID`);
ALTER TABLE `recipe_steps` ADD CONSTRAINT `recipe_steps_fk0` FOREIGN KEY (`recipeID`) REFERENCES `recipes`(`recipeID`);

