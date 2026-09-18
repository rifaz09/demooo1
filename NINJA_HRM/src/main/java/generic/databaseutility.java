package generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class databaseutility {
	
	public Connection getdbconnection(String url,String un,String pwd)throws Exception
	{
		Driver d= new Driver();
		DriverManager.registerDriver(d);
		return DriverManager.getConnection(url,un,pwd);
	}
	
	public boolean validdataentry(String tname,String cname,String data,String url,String un,String pwd)throws Exception
	{
		Driver d=new Driver();
		
		Connection c=DriverManager.getConnection(url,un,pwd);
		Statement st=c.createStatement();
		return st.execute("select * from"+tname+" where "+cname+"='"+data+"'");
	}
	public ResultSet readdatafromdb(String url,String pwd,String query)throws Exception
	{
		Connection con=getdbconnection(url, query, pwd);
		Statement s=con.createStatement();
		return s.executeQuery(query);
		
	}
	public void clodeconnection(Connection con)throws Exception
	{
		con.close();
		
	}

}
