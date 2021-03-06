DROP TABLE IF EXISTS `ast_TestFG_T`;

CREATE TABLE `ast_TestFG_T` ( `testFGid` VARCHAR(256) NOT NULL, `fgName` VARCHAR(256) NOT NULL, `fgDate` DATE NOT NULL, `fgDatetime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `versionId` INT(10) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(10) NULL DEFAULT NULL, PRIMARY KEY (`testFGid`));

