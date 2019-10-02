package util.user;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Restaurants")
public class Restaurant_details {
	
	private String City;
	private String Price_range;
	private String Cuisine_Style;
	private String Restaurant_Name;
	private String Restaurant_Rating;
	
	
	public String getRestaurant_Name() {
		return Restaurant_Name;
	}
	public void setRestaurant_Name(String restaurant_Name) {
		Restaurant_Name = restaurant_Name;
	}
	public String getRestaurant_Rating() {
		return Restaurant_Rating;
	}
	public void setRestaurant_Rating(String restaurant_Rating) {
		Restaurant_Rating = restaurant_Rating;
	}
	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPrice_range() {
		return Price_range;
	}

	public void setPrice_range(String price_range) {
		Price_range = price_range;
	}

	public String getCuisine_Style() {
		return Cuisine_Style;
	}

	public void setCuisine_Style(String cuisine_Style) {
		Cuisine_Style = cuisine_Style;
	}
	
}
