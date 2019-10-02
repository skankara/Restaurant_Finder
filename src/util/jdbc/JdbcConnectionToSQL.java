package util.jdbc;

import java.sql.*;


public class JdbcConnectionToSQL extends Exception
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7888957898332343816L;
	public Connection JdbcConnection (){
	Connection con = null;

		try{
			 Driver myDriver = new oracle.jdbc.driver.OracleDriver();
			 DriverManager.registerDriver( myDriver );
			 String username = "FallProject";
			 String password = "qwerty123";
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
			   
		}
		catch(Exception ex){
			System.out.println("Error: unable to load driver class!");
			   System.exit(1);
		}
		return con ;
	}
} 
//}
