--- !Ups

CREATE TABLE `payment_slip` (
  `payment_slip_id`         VARCHAR(255) NOT NULL,
  `contract_information_id` VARCHAR(255) NOT NULL,
  `item_name`               VARCHAR(255) NOT NULL,
  `price`                   VARCHAR(255) NOT NULL,
  PRIMARY KEY (`payment_slip_id`),
  FOREIGN KEY (`contract_information_id`) REFERENCES `contract_information`(`contract_information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
