--- !Ups

CREATE TABLE `employee_detail` (
  `employee_id`    VARCHAR(255)          NOT NULL,
  `birth_year`     SMALLINT     UNSIGNED NOT NULL,
  `birth_month`    TINYINT      UNSIGNED NOT NULL,
  `birth_day`      TINYINT      UNSIGNED NOT NULL,
  `address`        VARCHAR(255)          NOT NULL,
  `phone_number`   VARCHAR(255)          NOT NULL,
  `email`          VARCHAR(255)          NOT NULL,
  `license_number` BIGINT(20)   UNSIGNED DEFAULT NULL,
  FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`),
  UNIQUE KEY (`email`, `phone_number`, `license_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;