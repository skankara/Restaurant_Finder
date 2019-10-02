package util.user;


import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import util.SqlQueries.GetDetails;
import util.SqlQueries.GetRestaurant_Details_3_CPC;
import util.SqlQueries.StoreUserDetails;
  
@Path("/UserService") 
	
public class UserService {  
	
   @GET 
   @Path("/get/users/{USER_ID: .*}/{PARAPHRASE}") 
   @Produces(MediaType.APPLICATION_XML) 
   public User getUsers(@PathParam("USER_ID") final String USER_ID,
				@PathParam("PARAPHRASE") final String PARAPHRASE)
   { 
	   User l_user = new User();
	   GetDetails l_getDetails = new GetDetails();
	   l_user = l_getDetails.get_UserDetails(USER_ID, PARAPHRASE);
	   System.out.println("USER : "+l_user.getName());
	   return l_user; 
   } 
   
   @GET 
   @Path("/get/users/restaurant/{rid: .*}/{password}") 
   @Produces(MediaType.APPLICATION_XML) 
   public RestaurantUser get_RestaurantDetails(@PathParam("rid") final String rid,
				@PathParam("password") final String password)
   { 
	   RestaurantUser l_restaurantUser = new RestaurantUser();
	   GetDetails l_getDetails = new GetDetails();
	   l_restaurantUser = l_getDetails.get_RestaurantDetails(rid, password);
	   return l_restaurantUser; 
   } 
   
   @GET 
   @Path("/get/Neo4J/restaurant/{City}/{Price_range}/{Cuisine_Style}") 
   @Produces(MediaType.APPLICATION_XML) 
   public Response get_RestaurantDetails(@PathParam("City") final String City,
				@PathParam("Price_range") final String Price_range,
				@PathParam("Cuisine_Style") final String Cuisine_Style)
   { 
	   System.out.println(" IN get_RestaurantDetails");
	   ArrayList<Restaurant_details> l_Restaurant_details = new ArrayList<>();
	   System.out.println(" IN get_RestaurantDetails_1");
	   GetRestaurant_Details_3_CPC l_GetRestaurant_Details_3_CPC =
			   								new GetRestaurant_Details_3_CPC();
	   
	   System.out.println(" IN get_RestaurantDetails_2");
	   if(("null").equalsIgnoreCase(Price_range))
	   {
		   System.out.println(" IN Price_range");
		   l_Restaurant_details  = l_GetRestaurant_Details_3_CPC.getRestaurants_Cuisine_Style(City, Cuisine_Style);
	   }
	   else if(("null").equalsIgnoreCase(Cuisine_Style))
	   {
		   System.out.println(" IN Cuisine_Style");
		   l_Restaurant_details  = l_GetRestaurant_Details_3_CPC.getRestaurants_Price_range(City, Price_range);
	   }
	   else
	   {
		   System.out.println(" IN Fine Else");
		   l_Restaurant_details  = l_GetRestaurant_Details_3_CPC.getRestaurants_Cuisine_price(City,Price_range,Cuisine_Style);
	   }
	   System.out.println(" After Fine Else");
	   GenericEntity<ArrayList<Restaurant_details>> entity = new GenericEntity<ArrayList<Restaurant_details>>(l_Restaurant_details) {};
	   System.out.println(" After GenericEntity Else");
	   Response response = Response.ok(entity).build();
	   System.out.println(" After response Else");
	   return response; 
   }
   
   @POST
   @Path("/post/user/{USER_ID: .*}/{PARAPHRASE}/{USER_NAME}/{SUR_NAME}/{CITY}/{STATE}") 
   //@Consumes("application/json")
   public String storeUsers(@PathParam("USER_ID") final String USER_ID,
		   				@PathParam("PARAPHRASE") final String PARAPHRASE,
		   				@PathParam("USER_NAME") final String USER_NAME,
		   				@PathParam("SUR_NAME") final String SUR_NAME,
		   				@PathParam("CITY") final String CITY,
		   				@PathParam("STATE") final String STATE) 
   {
	   StoreUserDetails l_StoreUserDetails = new StoreUserDetails();
	   System.out.println("USER_ID : " + USER_ID);
	   l_StoreUserDetails.update_UserDetails(USER_ID, PARAPHRASE, USER_NAME, SUR_NAME, CITY, STATE); 
       return "Success";
	   // Store the message
   }
   
   @POST
   @Path("/post/restaurant/{rid: .*}/{password}/{name}/{city}/{state}/{pricerange}/{cuisinestyle}") 
   @Consumes("application/json")
   public String storeRestaurantDetails(@PathParam("rid") final String rid ,
		   				@PathParam("password") final String password ,
		   				@PathParam("name") final String name ,
		   				@PathParam("city") final String city ,
		   				@PathParam("state") final String state ,
		   				@PathParam("pricerange") final String pricerange ,
		   				@PathParam("cuisinestyle") final String cuisinestyle  ) 
   {
	   StoreUserDetails l_StoreUserDetails = new StoreUserDetails();
	   
	   l_StoreUserDetails.Store_RestaurantDetails(rid , password , name , city , state , pricerange ,cuisinestyle ); 
	   
       return "Success";
	   // Store the message
   }
   
   
}