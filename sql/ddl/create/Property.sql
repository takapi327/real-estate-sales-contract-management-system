--- !Ups

CREATE TABLE `property` (
  `id`                    VARCHAR(255)          NOT NULL,
  `address`               VARCHAR(255)          NOT NULL,
  `types`                 TINYINT      UNSIGNED NOT NULL,
  `price`                 VARCHAR(255)          NOT NULL,
  `date_built`            DATE                  NOT NULL,
  `structure`             TINYINT      UNSIGNED NOT NULL,
  `arrangement_of_rooms`  VARCHAR(255)          NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
