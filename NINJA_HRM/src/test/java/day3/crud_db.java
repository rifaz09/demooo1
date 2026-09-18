package day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class crud_db
{
	public static void main(String[] args) throws Exception {
		Driver d=new Driver();
		
		DriverManager.registerDriver(d);
		Connection con= DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		
		Statement st=con.createStatement();
		//st.execute("drop table rif1");
		
		//execute
		/*st.execute("create table rif1 (name VARCHAR(20))");
		st.execute("insert into rif1 values('rifaz')");
		boolean status=st.execute("select * from rif1");
		if(status==true)
			System.out.println("table created");
		else
			System.out.println("table not created");*/
		
		
		//2.execute query
		//2.1 reading data from database
		ResultSet set=st.executeQuery("select * from project;");
		while(set.next())
		{
			System.out.println("pid: "+set.getString(1) + "createdBy "+set.getString(2)+ "createdon: "+set.getNString(3));
		}
		
		//executeupdate
		int i=st.executeUpdate("insert into project values('NH_PROJ_9999','rif','03/09/2026','rif1','created','30')");
		System.out.println("I: "+i);
		
		
		con.close();
	}

}
