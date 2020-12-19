--- !Ups

CREATE TABLE contract_information (
  id          BIGINT       UNSIGNED NOT NULL,
  property_id BIGINT       UNSIGNED NOT NULL,
  contents    VARCHAR(255)          NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (property_id),
);
