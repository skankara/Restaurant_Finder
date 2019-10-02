package util.SqlQueries;


import java.sql.*;

import util.jdbc.JdbcConnectionToSQL;

public class StoreUserDetails {
	
	JdbcConnectionToSQL jdbc ;
	
	Statement stmt = null ; 
	Connection con = null;
	
	public void update_UserDetails(String USER_ID, String PARAPHRASE,String USER_NAME, String SUR_NAME,
										String CITY,String STATE) {
		jdbc = new JdbcConnectionToSQL();
		con = jdbc.JdbcConnection();
		System.out.println("Sree inside the void main");
		String l_UpdateQuery = null;
							 		
		l_UpdateQuery = "INSERT INTO USER_INFORMATION VALUES('" +USER_ID+"','"+PARAPHRASE+"','"+USER_NAME+"','"+SUR_NAME
				+"','"+CITY+"','"+STATE+"','"+null+"','"+null+"','"+null+"')";
		System.out.println("l_UpdateQuery : "+l_UpdateQuery);
		
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(l_UpdateQuery);
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error in Updating the UserDetails");
			System.out.println("Error traceback : "+ e.getStackTrace());
			System.out.println("Error Message : "+ e.getMessage());
		}
		
	}
	
	public void Store_RestaurantDetails(String rid, String password, String name,
			 String city,String state,String pricerange,String cuisinestyle)
	 {
		 jdbc = new JdbcConnectionToSQL();
		 con = jdbc.JdbcConnection();
		 String l_UpdateQuery = null;
			
			l_UpdateQuery = "INSERT INTO RESTAURANT VALUES('" +rid+"','"+password+"','"+name+"','"+city+"','"+state+"','"
							+pricerange+"','"+cuisinestyle+"')";
			System.out.println("l_UpdateQuery : "+ l_UpdateQuery);
			try{
				stmt = con.createStatement();
				stmt.executeUpdate(l_UpdateQuery);
				con.close();
			}
			catch(Exception e)
			{
				System.out.println("Error in Updating the UserDetails");
				System.out.println("Error traceback : "+ e.getStackTrace());
				System.out.println("Error Message : "+ e.getMessage());
			}
	 }
}
