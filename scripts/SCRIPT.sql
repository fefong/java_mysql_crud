/* --------------------------------------- Database ---------------------------------------- */

DROP DATABASE IF EXISTS database_test;
CREATE DATABASE database_test;
USE database_test;

/* --------------------------------------- Tables ---------------------------------------- */

CREATE TABLE t_person(
 id_person INT(11) NOT NULL AUTO_INCREMENT  ,
 name_person VARCHAR(80) NOT NULL           ,
 date_person DATE NOT NULL                  , 
 
 PRIMARY KEY (id_person)
);

/* --------------------------------------- Procedures ---------------------------------------- */

DELIMITER $$
CREATE PROCEDURE stp_insert_person
(
 IN IN_name_person VARCHAR(80)             ,
 IN IN_date_person DATE                  
)
BEGIN
	INSERT INTO t_person 
    (name_person, date_person)
	VALUES 
    (IN_name_person, IN_date_person);
END $$

CREATE PROCEDURE stp_update_person
(
IN IN_id_person INT(11)                      , 
INOUT INOUT_name_person VARCHAR(80)          ,
INOUT INOUT_date_person DATE                    
)
BEGIN
	UPDATE t_person
    SET
		name_person  =  INOUT_name_person,
        date_person  =  INOUT_date_person
	WHERE 
		id_person    =  IN_id_person;
END $$

CREATE PROCEDURE stp_delete_person
(
IN IN_id_person INT(11)                                    
)
BEGIN
	DELETE FROM t_person
    WHERE
    id_person    =  IN_id_person;
END $$

DELIMITER ;

/* --------------------------------------- Views ---------------------------------------- */

CREATE VIEW view_person AS
SELECT id_person, name_person, date_person  FROM t_person;

