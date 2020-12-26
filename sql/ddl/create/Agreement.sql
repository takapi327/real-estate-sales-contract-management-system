--- !Ups

CREATE TABLE `agreement` (
  `id`                      VARCHAR(255) NOT NULL,
  `contract_information_id` VARCHAR(255) NOT NULL,
  `name`                    VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`contract_information_id`) REFERENCES `contract_information`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
