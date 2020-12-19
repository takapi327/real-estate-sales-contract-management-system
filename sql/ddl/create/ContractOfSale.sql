--- !Ups

CREATE TABLE `contract_of_sale` (
  `contract_information_id` BIGINT(20) UNSIGNED NOT NULL,
  `subscriber_id`           BIGINT(20) UNSIGNED NOT NULL,
  `employee_id`             BIGINT(20) UNSIGNED NOT NULL,
  FOREIGN KEY (`contract_information_id`, `subscriber_id`, `employee_id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
