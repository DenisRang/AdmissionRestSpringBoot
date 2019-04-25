DROP SCHEMA IF EXISTS web_admission;
CREATE SCHEMA web_admission;

USE `web_admission`;

SET FOREIGN_KEY_CHECKS = 0;

--
-- Table structure for table testEntity
--
DROP TABLE IF EXISTS test;
CREATE TABLE test
(
  id    int(11) NOT NULL AUTO_INCREMENT,
  title varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


DROP TABLE IF EXISTS question;
CREATE TABLE question
(
  id          int(11) NOT NULL AUTO_INCREMENT,
  test_id     int(11)     DEFAULT NULL,
  description varchar(45) DEFAULT NULL,
  weight      double  NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TEST_idx` (`test_id`),
  CONSTRAINT `FK_TEST` FOREIGN KEY (`test_id`)
    REFERENCES `test` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


DROP TABLE IF EXISTS text_question;
CREATE TABLE text_question
(
  id     int(11)     NOT NULL,
  answer varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `question` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


DROP TABLE IF EXISTS radio_question;
CREATE TABLE radio_question
(
  id int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `question` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


DROP TABLE IF EXISTS checklist_question;
CREATE TABLE checklist_question
(
  id int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `question` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;


DROP TABLE IF EXISTS answer_variant;
CREATE TABLE answer_variant
(
  id          int(11)     NOT NULL AUTO_INCREMENT,
  question_id int(11) DEFAULT NULL,
  text        varchar(45) NOT NULL,
  is_correct  boolean DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS test_attempt;
CREATE TABLE test_attempt
(
  id           int(11) NOT NULL AUTO_INCREMENT,
  candidate_id int(11) DEFAULT NULL,
  test_id      int(11) DEFAULT NULL,
  grade        double DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`test_id`) REFERENCES `test` (`id`),
  FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS question_attempt;
CREATE TABLE question_attempt
(
  id              int(11)     NOT NULL AUTO_INCREMENT,
  test_attempt_id int(11) DEFAULT NULL,
  question_id     int(11) DEFAULT NULL,
  type            ENUM ('TEXT', 'VARIANT'),
  answer          varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`test_attempt_id`) REFERENCES `test_attempt` (`id`),
  FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS question_attempt_answer_variant;
CREATE TABLE question_attempt_answer_variant
(
  question_attempt_id int(11) DEFAULT NULL,
  answer_variant_id   int(11) DEFAULT NULL,
  PRIMARY KEY (`question_attempt_id`, `answer_variant_id`),
  FOREIGN KEY (`question_attempt_id`) REFERENCES `question_attempt` (`id`),
  FOREIGN KEY (`answer_variant_id`) REFERENCES `answer_variant` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS program;
CREATE TABLE program
(
  id      int(11)     NOT NULL AUTO_INCREMENT,
  test_id int(11) DEFAULT NULL,
  title   varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TEST_idx` (`test_id`),
  FOREIGN KEY (`test_id`) REFERENCES `test` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS program_test;
CREATE TABLE program_test
(
  program_id int(11) DEFAULT NULL,
  test_id    int(11) DEFAULT NULL,
  PRIMARY KEY (`program_id`, `test_id`),
  FOREIGN KEY (`program_id`) REFERENCES `program` (`id`),
  FOREIGN KEY (`test_id`) REFERENCES `test` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS application;
CREATE TABLE application
(
  id           int(11) NOT NULL AUTO_INCREMENT,
  program_id   int(11) DEFAULT NULL,
  candidate_id int(11) DEFAULT NULL,
  status_id    int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`program_id`) REFERENCES `program` (`id`),
  FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`id`),
  FOREIGN KEY (`status_id`) REFERENCES `application_status` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS application_status;
CREATE TABLE application_status
(
  id             int(11) NOT NULL AUTO_INCREMENT,
  application_id int(11)   DEFAULT NULL,
  changed        TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`application_id`) REFERENCES `application` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS accepted_application_status;
CREATE TABLE accepted_application_status
(
  id       int(11) NOT NULL,
  comment  varchar(45) DEFAULT NULL,
  staff_id int(11)     DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS accepted_status;
CREATE TABLE accepted_status
(
  id       int(11) NOT NULL,
  comment  varchar(45) DEFAULT NULL,
  staff_id int(11)     DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS rejected_status;
CREATE TABLE rejected_status
(
  id      int(11) NOT NULL,
  reason  varchar(45) DEFAULT NULL,
  fixable boolean     DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS initial_status;
CREATE TABLE initial_status
(
  id int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS pending_interview_status;
CREATE TABLE pending_interview_status
(
  id       int(11) NOT NULL,
  date     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  staff_id int(11)   DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS pending_review_status;
CREATE TABLE pending_review_status
(
  id int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS system_user;
CREATE TABLE system_user
(
  id    int(11)     NOT NULL AUTO_INCREMENT,
  name  varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS candidate;
CREATE TABLE candidate
(
  id int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `system_user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS staff;
CREATE TABLE staff
(
  id int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `system_user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

DROP TABLE IF EXISTS manager;
CREATE TABLE manager
(
  id int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `system_user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

SET FOREIGN_KEY_CHECKS = 1;
