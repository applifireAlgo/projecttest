

ALTER TABLE `ast_Candidate_T` ADD CONSTRAINT FOREIGN KEY (`interviewere`) REFERENCES `ast_Interviewer_M`(`interviewrId`);

