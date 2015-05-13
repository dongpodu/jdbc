package com.elisonwell.jdbc;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectionUtils {
	private static Connection con = null;
	
	public static Connection getConnection(){
		try {
			if(con!=null){
				return con;
			}
			Properties pro = new Properties();
			pro.load( new InputStreamReader(
					ConnectionUtils.class.getClassLoader().getResourceAsStream("global.properties")));
			pro.load(new InputStreamReader(
					ConnectionUtils.class.getClassLoader().getResourceAsStream("jdbc.properties")));
			String driver = pro.getProperty("driver");
			Class.forName(pro.getProperty(driver+".jdbc.driver"));
			con = DriverManager.getConnection(
					pro.getProperty(driver+".jdbc.url"),
					pro.getProperty(driver+".jdbc.user"),
					pro.getProperty(driver+".jdbc.password"));
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return con;
	}
		
	
	public static void main(String[] args){
		getConnection();
	}
}
