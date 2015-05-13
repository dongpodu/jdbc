package com.elisonwell.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * @author duyisong  2015年5月13日
 *
 */
public class TestPreParedStatement {
	public static void main(String[] args) {
		try{
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement  pre = con.prepareStatement("select * from jdbc where id=?");
            ResultSet rs = null;
            for(int i = 0;i<2;i++){
            	pre.setInt(1, i);
            	rs = pre.executeQuery();
            	while(rs.next()){  
            		System.out.print(rs.getInt("Id") + "     ");  
            		System.out.print(rs.getString("Name") + "     ");  
            	}  
            }
            rs.close();  
            pre.close();  
            con.close();  
        }  
        catch(Exception err){  
            err.printStackTrace(System.out);  
        }  
	}
	
}
