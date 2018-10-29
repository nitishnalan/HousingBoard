package com.housingboard.dao;

public interface MyDB {

	String USER="root";
	String PASS="root";
//	String CONN_URL="jdbc:mysql://127.0.0.1:3306/coursedatabase";
	String CONN_URL="jdbc:mysql://127.0.0.1:3306/housingboard";
	
	
}
/**
CREATE TABLE `customer` (
`userId` char(20) NOT NULL,
`password` char(10) DEFAULT NULL,
`name` char(20) DEFAULT NULL
)


jdbc:mysql://127.0.0.1:3306/coursedatabase?user=coursedatabase_admin

*/
