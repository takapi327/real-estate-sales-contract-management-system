--- !Ups

CREATE TABLE `contract_of_buy` (
  `contract_information_id` BIGINT(20) UNSIGNED NOT NULL,
  `subscriber_id`           BIGINT(20) UNSIGNED NOT NULL,
  `employee_id`             BIGINT(20) UNSIGNED NOT NULL,
  FOREIGN KEY (`contract_information_id`) REFERENCES `contract_information`(`id`),
  FOREIGN KEY (`subscriber_id`)           REFERENCES `subscriber`(`subscriber_id`),
  FOREIGN KEY (`employee_id`)             REFERENCES `employee`(`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
