--- !Ups

CREATE TABLE `agreement` (
  `id`                      BIGINT(20)   UNSIGNED NOT NULL,
  `contract_information_id` BIGINT(20)   UNSIGNED NOT NULL,
  `name`                    VARCHAR(255)          NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`contract_information_id`) REFERENCES `contract_information`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
