DROP DATABASE IF EXISTS rescate_orgs;

CREATE DATABASE rescate_orgs;
USE rescate_orgs;
DROP TABLE IF EXISTS organization;

CREATE TABLE organization 
(
	org_name			VARCHAR(50) 	NOT NULL,
    org_id				INT				PRIMARY KEY,
    org_country			VARCHAR(30),
    org_website			VARCHAR(100),
    donated_to_date		INT,
    area_of_focus		TINYTEXT,
    contact_information	TEXT			NOT NULL,
    call_for_grants		BOOLEAN 		NOT NULL
);

