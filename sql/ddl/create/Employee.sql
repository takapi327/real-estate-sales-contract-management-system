--- !Ups

CREATE TABLE employee (
  employee_id    BIGINT       UNSIGNED NOT NULL,
  first_name     VARCHAR(255)          NOT NULL,
  last_name      VARCHAR(255)          NOT NULL,
  age            TINYINT      UNSIGNED NOT NULL,
  address        VARCHAR(255)          NOT NULL,
  phone_number   TINYINT      UNSIGNED NOT NULL,
  email          VARCHAR(255),
  license_number BIGINT       UNSIGNED,
  PRIMARY KEY (employee_id),
  UNIQUE KEY (email, license_number)
);
