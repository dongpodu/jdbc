package com.elisonwell.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 
 * @author duyisong  2015年5月13日
 *
 */
public class TestStatement {
	public static void main(String[] args) {
		try{
            Connection con = ConnectionUtils.getConnection();
            Statement  st = con.createStatement();
            ResultSet rs = null;
            for(int i = 0;i<2;i++){
            	rs = st.executeQuery("select * from jdbc where id="+i);
            	while(rs.next()){  
            		System.out.print(rs.getInt("Id") + "     ");  
            		System.out.print(rs.getString("Name") + "     ");  
            	}  
            }
            rs.close();  
            st.close();  
            con.close();  
        }  
        catch(Exception err){  
            err.printStackTrace(System.out);  
        }  
	}
	
}
