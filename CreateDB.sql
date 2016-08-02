DROP DATABASE IF EXISTS rescate_orgs;

CREATE DATABASE rescate_orgs;
USE rescate_orgs;
DROP TABLE IF EXISTS organization;

CREATE TABLE organization 
(
	org_name			VARCHAR(50) 	NOT NULL,
    org_id				INT				PRIMARY KEY		AUTO_INCREMENT,
    org_country			VARCHAR(30),
    org_website			VARCHAR(100),
    donated_to_date		VARCHAR(100),
    area_of_focus		TINYTEXT,
    contact_information	TEXT			NOT NULL,
    call_for_grants		BOOLEAN 		NOT NULL
);

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
	user_name		VARCHAR(50)		NOT NULL	PRIMARY KEY,
    user_pass		VARCHAR(50)		NOT NULL		
);

INSERT INTO user (user_name, user_pass) VALUES ("patrickmcgrath", "rescatelogin!");


