package com.yash.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection	con=DriverManager.getConnection("jdbc:mysql://localHost:3306/test", "root", "root");
		
		
		return con;
	}

	
	
	
}
