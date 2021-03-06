/* DELETE 'productsdb' database*/
DROP SCHEMA IF EXISTS easybookingdb;
/* DELETE USER 'sd' AT LOCAL SERVER*/
DROP USER IF EXISTS 'sd'@'%';

/* CREATE ''productsdb' DATABASE */
CREATE SCHEMA easybookingdb;
/* CREATE THE USER 'sd' AT LOCAL SERVER WITH PASSWORD 'sd' */
CREATE USER IF NOT EXISTS 'sd'@'%' IDENTIFIED BY 'sd';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'sd' AT LOCAL SERVER*/
GRANT ALL ON easybookingdb.* TO 'sd'@'%';
