package util.Neo4J;

/*import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;*/

import org.neo4j.driver.v1.*;

import util.user.Restaurant_details;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ConnectToNeo4j implements AutoCloseable
{
    private final Driver driver = GraphDatabase.driver( "bolt://localhost:7474", AuthTokens.basic( "neo4j", "qwerty123" ) );;
    
    public ConnectToNeo4j() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void close() throws Exception
    {
        driver.close();
    }

    public ArrayList<Restaurant_details> get_Restaurants( String City, String Price_Range, String Cuisine_Style )
    {
    	ArrayList<Restaurant_details> l_Restaurant_details_list = new ArrayList<>();
    	Map<String, Object> parameters = new HashMap<String, Object>();
    	
   	 	parameters.put("city", City);
   	 	parameters.put("range",Price_Range);
   	 	parameters.put("style",Cuisine_Style);
   	 	System.out.println("in get_Restaurants");
   	 	
        try ( Session session = driver.session() )
        {
            /*String greeting = session.writeTransaction( new TransactionWork<String>()
            {
                @Override*/
                /*public String execute( Transaction tx )
                {*/
                	/*Transaction tx = graphDatabaseService.beginTx() ;*/
                	/*StatementResult result = tx.run("CREATE (a:Greeting1 {message:'New message'})"+
                			"RETURN a.message");*/
                    System.out.println("in execute ");
                	StatementResult result1 = session.run("Match (r:Restaurant)-[:LOCATION]-(l) WHERE r.style CONTAINS 'French'AND l.name= 'Amsterdam' RETURN r.name,r.ranking");
                	//StatementResult result1 = tx.run("Match (r:Restaurant)-[:LOCATION]-(l) WHERE r.style CONTAINS {style} AND l.name= {city} RETURN r.name");
                	System.out.println("Sree after result");
                	int i = 0;
                	while (result1.hasNext())
                	{
                		Restaurant_details l_resturant_deatails_local = new Restaurant_details();
                		l_resturant_deatails_local.setRestaurant_Name(result1.next().get(0).toString());
                		System.out.println("Getting Data : "+result1.next().get(0).toString()+ "  "+i++);
                		
                		l_resturant_deatails_local.setRestaurant_Rating(result1.next().get(1).toString());
                		System.out.println(" "+result1.next().get(1).toString());
                		
                		l_Restaurant_details_list.add(l_resturant_deatails_local);
                	}
                   // return result.single().get(0).asString();
                	System.out.println("Sree before success" + l_Restaurant_details_list.size());
                	//return "Success" ;
                /*}*/
           /* } );*/
            //System.out.println( greeting );
            System.out.println("Sree after success");
        }
        catch(Exception e)
        {
        	System.out.println("Message : "+e.getMessage());
        	System.out.println("StackException : "+e.getStackTrace());
        }
        /*finally
        {
        	
        }*/
        System.out.println("l_Restaurant_details_list[0] : "+l_Restaurant_details_list.get(0).getRestaurant_Name());
        return l_Restaurant_details_list ;
    }

    /*public static void main( String... args ) throws Exception
    {
    	
        try ( ConnectToNeo4j greeter = new ConnectToNeo4j( "bolt://localhost:7687", "neo4j", "qwerty123" ) )
        {
            greeter.printGreeting( "hello, world" );
        }
    }*/
}