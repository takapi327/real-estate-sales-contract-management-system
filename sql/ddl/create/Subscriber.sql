--- !Ups

CREATE TABLE subscriber_id (
  subscriber_id  BIGINT       UNSIGNED NOT NULL,
  first_name     VARCHAR(255)          NOT NULL,
  last_name      VARCHAR(255)          NOT NULL,
  age            TINYINT      UNSIGNED NOT NULL,
  address        VARCHAR(255)          NOT NULL,
  phone_number   TINYINT      UNSIGNED NOT NULL,
  email          VARCHAR(255),
  PRIMARY KEY (employee_id),
  UNIQUE KEY (email)
);
