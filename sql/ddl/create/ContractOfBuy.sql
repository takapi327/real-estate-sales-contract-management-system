--- !Ups

CREATE TABLE contract_of_buy (
  contract_information_id BIGINT UNSIGNED NOT NULL,
  subscriber_id           BIGINT UNSIGNED NOT NULL,
  employee_id             BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (contract_information_id, subscriber_id, employee_id),
);
