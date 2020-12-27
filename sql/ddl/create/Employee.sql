--- !Ups

CREATE TABLE `employee` (
  `employee_id`    VARCHAR(255)          NOT NULL,
  `first_name`     VARCHAR(255)          NOT NULL,
  `last_name`      VARCHAR(255)          NOT NULL,
  `birth_year`     SMALLINT     UNSIGNED NOT NULL,
  `birth_month`    TINYINT      UNSIGNED NOT NULL,
  `birth_day`      TINYINT      UNSIGNED NOT NULL,
  `address`        VARCHAR(255)          NOT NULL,
  `phone_number`   VARCHAR(255)          NOT NULL,
  `email`          VARCHAR(255)          NOT NULL,
  `license_number` BIGINT(20)   UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY (`email`, `phone_number`, `license_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
