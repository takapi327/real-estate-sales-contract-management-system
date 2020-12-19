--- !Ups

CREATE TABLE agreement (
  id                      BIGINT       UNSIGNED NOT NULL,
  contract_information_id BIGINT       UNSIGNED NOT NULL,
  name                    VARCHAR(255)          NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (contract_information_id)
);
