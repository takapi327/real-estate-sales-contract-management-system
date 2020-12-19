--- !Ups

CREATE TABLE `contract_information` (
  `id`          BIGINT(20)   UNSIGNED NOT NULL,
  `property_id` BIGINT(20)   UNSIGNED NOT NULL,
  `contents`    TEXT                  NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`property_id`) REFERENCES `property`(`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
