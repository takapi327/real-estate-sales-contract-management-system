--- !Ups

CREATE TABLE `agreement` (
  `agreement_id`            VARCHAR(255) NOT NULL,
  `contract_information_id` VARCHAR(255) NOT NULL,
  `name`                    VARCHAR(255) NOT NULL,
  PRIMARY KEY (`agreement_id`),
  FOREIGN KEY (`contract_information_id`) REFERENCES `contract_information`(`contract_information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
