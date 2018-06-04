CREATE TABLE `dataToBeSold`.`transactions` (
  `transactionId` INT NOT NULL AUTO_INCREMENT,
  `bankId` INT NOT NULL,
  `slaveId` INT NOT NULL,
  `value` FLOAT NOT NULL,
  `endDate` DATE NULL,
  `completed` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`transactionId`),
  UNIQUE INDEX `transactionId_UNIQUE` (`transactionId` ASC),
  INDEX `fk_lender_idx` (`bankId` ASC),
  INDEX `fk_borrower_idx` (`slaveId` ASC),
  CONSTRAINT `fk_lender`
    FOREIGN KEY (`bankId`)
    REFERENCES `dataToBeSold`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_borrower`
    FOREIGN KEY (`slaveId`)
    REFERENCES `dataToBeSold`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);