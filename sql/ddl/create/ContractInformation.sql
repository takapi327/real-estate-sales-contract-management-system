--- !Ups

CREATE TABLE `contract_information` (
  `id`           VARCHAR(255) NOT NULL,
  `property_id`  VARCHAR(255) NOT NULL,
  `contents`     TEXT         NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`property_id`) REFERENCES `property`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
