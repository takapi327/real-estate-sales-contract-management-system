--- !Ups

CREATE TABLE `contract_of_buy` (
  `contract_information_id` VARCHAR(255) NOT NULL,
  `subscriber_id`           VARCHAR(255) NOT NULL,
  `employee_id`             VARCHAR(255) NOT NULL,
  FOREIGN KEY (`contract_information_id`) REFERENCES `contract_information`(`contract_information_id`),
  FOREIGN KEY (`subscriber_id`)           REFERENCES `subscriber`(`subscriber_id`),
  FOREIGN KEY (`employee_id`)             REFERENCES `employee`(`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
