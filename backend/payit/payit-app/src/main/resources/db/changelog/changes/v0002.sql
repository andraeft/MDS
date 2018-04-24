ALTER TABLE `credentials`
CHANGE COLUMN `password` `password` BINARY(60) NOT NULL ,
ADD UNIQUE INDEX `username_UNIQUE` (`username` ASC);
