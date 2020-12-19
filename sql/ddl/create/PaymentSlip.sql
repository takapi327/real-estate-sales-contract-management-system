--- !Ups

CREATE TABLE `payment_slip` (
  `id`                      BIGINT(20)   UNSIGNED NOT NULL,
  `contract_information_id` BIGINT(20)   UNSIGNED NOT NULL,
  `item_name`               VARCHAR(255)          NOT NULL,
  `price`                   BIGINT(20)   UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`contract_information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
