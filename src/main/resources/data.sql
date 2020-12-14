DROP TABLE IF EXISTS STATION;
CREATE TABLE STATION (stationId varchar(45) PRIMARY KEY NOT NULL, name varchar(45) DEFAULT NULL, hd_Enabled tinyint DEFAULT '0',callSign varchar(45) DEFAULT NULL);

INSERT INTO Station VALUES('710WOR','News and Talk',1,'WOR');
INSERT INTO Station VALUES( 'KFIAM40', 'More Simulating Talk',0,'KFI');
INSERT INTO Station VALUES( 'Z100', 'Hit Music',1,'WHTZ');
INSERT INTO Station VALUES( 'Z1002', 'Hit Music',1,'WHTZ2');
INSERT INTO Station VALUES ('KOST103', 'KOST 103.5', '0', 'KOST');

CREATE INDEX IDXID ON Station(stationId);
CREATE INDEX IDXNAME ON Station(name);