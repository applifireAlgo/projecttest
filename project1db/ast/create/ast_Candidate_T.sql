DROP TABLE IF EXISTS `ast_Candidate_T`;

CREATE TABLE `ast_Candidate_T` ( `candidateId` VARCHAR(256) NOT NULL, `candidateName` VARCHAR(256) NOT NULL, `interviewere` VARCHAR(256) NOT NULL, `recommendHire` VARCHAR(256) NOT NULL, `emailid` VARCHAR(256) NOT NULL, `datee` DATE NOT NULL, `skillFit` VARCHAR(256) NOT NULL, `cultureFit` VARCHAR(256) NOT NULL, `growthPotential` VARCHAR(256) NOT NULL, `star` VARCHAR(256) NOT NULL, `note` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `versionId` INT(10) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(10) NULL DEFAULT NULL, PRIMARY KEY (`candidateId`));

