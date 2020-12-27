--- !Ups

CREATE TABLE `contract_information` (
  `contract_information_id` VARCHAR(255) NOT NULL,
  `property_id`             VARCHAR(255) NOT NULL,
  `contents`                TEXT         NOT NULL,
  PRIMARY KEY (`contract_information_id`),
  FOREIGN KEY (`property_id`) REFERENCES `property`(`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
