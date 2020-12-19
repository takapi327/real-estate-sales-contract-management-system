--- !Ups

CREATE TABLE property (
  property_id           BIGINT       UNSIGNED NOT NULL,
  address               VARCHAR(255)          NOT NULL,
  types                 TINYINT	     UNSIGNED NOT NULL,
  price                 BIGINT	     UNSIGNED NOT NULL,
  age                   BIGINT       UNSIGNED NOT NULL,
  structure             TINYINT      UNSIGNED NOT NULL,
  arrangement_of_rooms  TINYINT      UNSIGNED NOT NULL,
  PRIMARY KEY (property_id),
);
