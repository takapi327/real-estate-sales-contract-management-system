--- !Ups

CREATE TABLE `subscriber_detail` (
  `subscriber_id`  VARCHAR(255)          NOT NULL,
  `birth_year`     SMALLINT     UNSIGNED NOT NULL,
  `birth_month`    TINYINT      UNSIGNED NOT NULL,
  `birth_day`      TINYINT      UNSIGNED NOT NULL,
  `address`        VARCHAR(255)          NOT NULL,
  `phone_number`   VARCHAR(255)          NOT NULL,
  `email`          VARCHAR(255),
  FOREIGN KEY (`subscriber_id`) REFERENCES `subscriber`(`id`),
  UNIQUE KEY (`email`, `phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;