package util.SqlQueries;

import java.util.ArrayList;

import util.Neo4J.ConnectToNeo4j;
import util.user.Restaurant_details;

public class GetRestaurant_Details_3_CPC {
	
	ArrayList<Restaurant_details> l_Restaurant_details = new ArrayList<Restaurant_details>();
	ConnectToNeo4j l_ConnectToNeo4j = new ConnectToNeo4j();
	
	public ArrayList<Restaurant_details>  getRestaurants_Cuisine_price(String City, String Cuisine_Style, String Price_range){
		
		System.out.println("Sree in getRestaurants_Cuisine_price");
		l_Restaurant_details = l_ConnectToNeo4j.get_Restaurants(City,Price_range,Cuisine_Style);
		for(int i = 0;i<l_Restaurant_details.size();i++)
		{
			System.out.println("Sree in getRestaurants_Cuisine_price"+l_Restaurant_details.get(i).getRestaurant_Name());
			System.out.println("Sree in getRestaurants_Cuisine_price"+l_Restaurant_details.get(i).getRestaurant_Rating());
		}
		return l_Restaurant_details ;
	}
	public ArrayList<Restaurant_details>  getRestaurants_Cuisine_Style(String City, String Cuisine_Style){
		
		
		l_Restaurant_details = l_ConnectToNeo4j.get_Restaurants(City,"",Cuisine_Style);
		System.out.println("Sree in getRestaurants_Cuisine_Style"+l_Restaurant_details.get(0).getRestaurant_Name());
		return l_Restaurant_details ;
	}
	public ArrayList<Restaurant_details>  getRestaurants_Price_range(String City, String Price_range){
		
		l_Restaurant_details = l_ConnectToNeo4j.get_Restaurants(City,Price_range,"");
		System.out.println("Sree in getRestaurants_Price_range"+l_Restaurant_details.get(0).getRestaurant_Rating());
		return l_Restaurant_details ;
	}
}
