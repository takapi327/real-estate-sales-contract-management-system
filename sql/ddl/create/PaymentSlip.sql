--- !Ups

CREATE TABLE payment_slip (
  id                      BIGINT       UNSIGNED NOT NULL,
  contract_information_id BIGINT       UNSIGNED NOT NULL,
  item_name               VARCHAR(255)          NOT NULL,
  price                   BIGINT       UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (contract_information_id)
);
