package util.SqlQueries;

import util.user.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.jdbc.JdbcConnectionToSQL;

public class GetDetails {
	
	JdbcConnectionToSQL jdbc ;
	Statement stmt = null ; 
	Connection con = null;
	
	public User get_UserDetails(String userid, String paraphrase) {
		User user_Details = new User();
		jdbc = new JdbcConnectionToSQL();
		con = jdbc.JdbcConnection();
		String l_RetreiveQuery = null;
		l_RetreiveQuery = "SELECT * FROM USER_INFORMATION WHERE USER_ID='"+userid+"'AND PARAPHRASE='"+paraphrase+"'";
		
		try{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(l_RetreiveQuery);
			while (rs.next())
		      {				
				user_Details.setUserid(rs.getString("USER_ID"));
				user_Details.setParaphrase(rs.getString("PARAPHRASE"));
				user_Details.setName(rs.getString("USER_NAME"));
				user_Details.setSurname(rs.getString("SUR_NAME"));
				user_Details.setCity(rs.getString("CITY"));
				user_Details.setState(rs.getString("STATE"));
				user_Details.setLastsearched1(rs.getString("LASTSEARCHED1"));
				user_Details.setLastsearched2(rs.getString("LASTSEARCHED2"));
				user_Details.setLastsearched3(rs.getString("LASTSEARCHED3"));
		      }
			con.close();
		}
		catch(Exception e){
			System.out.println("Error in retreiving the UserDetails");
			System.out.println("Error traceback : "+ e.getStackTrace());
			System.out.println("Error Message : "+ e.getMessage());
		}
		
		return user_Details;
	}
	
	public RestaurantUser get_RestaurantDetails(String rid , String password ){
		RestaurantUser l_RestaurantUser = new RestaurantUser();
		jdbc = new JdbcConnectionToSQL();
		con = jdbc.JdbcConnection();
		String l_RetreiveQuery = null;
		l_RetreiveQuery = "SELECT * FROM RESTAURANT WHERE rid='"+rid+"'AND password='"+password+"'";
		try{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(l_RetreiveQuery);
			while(rs.next()){
				l_RestaurantUser.setRid(rs.getString("rid"));
				l_RestaurantUser.setPassword(rs.getString("password"));
				l_RestaurantUser.setName(rs.getString("name"));
				l_RestaurantUser.setCity(rs.getString("city"));
				l_RestaurantUser.setState(rs.getString("state"));
				l_RestaurantUser.setPricerange(rs.getString("pricerange"));
				l_RestaurantUser.setCuisinestyle(rs.getString("cuisinestyle"));
			}
			con.close();
		}
		catch(Exception e){
			System.out.println("Error in retreiving the UserDetails");
			System.out.println("Error traceback : "+ e.getStackTrace());
			System.out.println("Error Message : "+ e.getMessage());
		}
		
		return l_RestaurantUser;
		
	}
}
