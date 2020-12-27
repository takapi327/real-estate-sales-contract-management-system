--- !Ups

CREATE TABLE `payment_slip` (
  `payment_slip_id`         VARCHAR(255)          NOT NULL,
  `contract_information_id` VARCHAR(255)          NOT NULL,
  `item_name`               VARCHAR(255)          NOT NULL,
  `price`                   BIGINT(20)   UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`contract_information_id`) REFERENCES `contract_information`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
