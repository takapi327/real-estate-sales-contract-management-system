--- !Ups

CREATE TABLE `subscriber` (
  `subscriber_id`  BIGINT(20)   UNSIGNED NOT NULL,
  `first_name`     VARCHAR(255)          NOT NULL,
  `last_name`      VARCHAR(255)          NOT NULL,
  `birth_year`     TINYINT      UNSIGNED NOT NULL,
  `birth_month`    TINYINT      UNSIGNED NOT NULL,
  `birth_day`      TINYINT      UNSIGNED NOT NULL,
  `address`        VARCHAR(255)          NOT NULL,
  `phone_number`   TINYINT      UNSIGNED NOT NULL,
  `email`          VARCHAR(255),
  PRIMARY KEY (`subscriber_id`),
  UNIQUE KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
