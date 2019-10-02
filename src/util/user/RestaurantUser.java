package util.user;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RestaurantUser")
public class RestaurantUser {
	
	private String rid;
	private String password;
	private String name;
	private String city;
	private String state;
	private String pricerange;
	private String cuisinestyle;
	
	public RestaurantUser(){
		
	}
	public RestaurantUser(String rid, String password, String name, String city, String state, String pricerange,
			String cuisinestyle) {
		super();
		this.rid = rid;
		this.password = password;
		this.name = name;
		this.city = city;
		this.state = state;
		this.pricerange = pricerange;
		this.cuisinestyle = cuisinestyle;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPricerange() {
		return pricerange;
	}

	public void setPricerange(String pricerange) {
		this.pricerange = pricerange;
	}

	public String getCuisinestyle() {
		return cuisinestyle;
	}

	public void setCuisinestyle(String cuisinestyle) {
		this.cuisinestyle = cuisinestyle;
	}
	
}
