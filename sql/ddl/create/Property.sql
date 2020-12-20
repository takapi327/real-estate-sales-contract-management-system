--- !Ups

CREATE TABLE `property` (
  `property_id`           BIGINT(20)   UNSIGNED NOT NULL,
  `address`               VARCHAR(255)          NOT NULL,
  `types`                 TINYINT      UNSIGNED NOT NULL,
  `price`                 BIGINT(20)   UNSIGNED NOT NULL,
  `date_built`            DATE                  NOT NULL,
  `structure`             TINYINT      UNSIGNED NOT NULL,
  `arrangement_of_rooms`  TINYINT      UNSIGNED NOT NULL,
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
