CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fkCredentials` VARCHAR(64) NOT NULL,
  `email` VARCHAR(80) NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `profilePic` VARCHAR(64) NOT NULL DEFAULT 'defaultImage' ,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `fkCredentials_UNIQUE` (`fkCredentials` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_User_Cred`
    FOREIGN KEY (`fkCredentials`)
    REFERENCES `credentials` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
