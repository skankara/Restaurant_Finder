/**
 * 
 */
package util.user;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Sreekanth
 *
 */

@XmlRootElement(name = "user")


public class User implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String userid ; 
	private String paraphrase ; 
	private String name ; 
	private String surname ; 
	private String city ; 
	private String state ; 
	private String lastsearched1 ;
	private String lastsearched2 ;
	private String lastsearched3 ;
	
	
	public User(){}


	public User(String userid, String paraphrase, String name, String surname, String city, String state,
			String lastsearched1, String lastsearched2, String lastsearched3) {
		super();
		this.userid = userid;
		this.paraphrase = paraphrase;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.state = state;
		this.lastsearched1 = lastsearched1;
		this.lastsearched2 = lastsearched2;
		this.lastsearched3 = lastsearched3;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getparaphrase() {
		return paraphrase;
	}


	public void setParaphrase(String paraphrase) {
		this.paraphrase = paraphrase;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
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


	public String getLastsearched1() {
		return lastsearched1;
	}


	public void setLastsearched1(String lastsearched1) {
		this.lastsearched1 = lastsearched1;
	}


	public String getLastsearched2() {
		return lastsearched2;
	}


	public void setLastsearched2(String lastsearched2) {
		this.lastsearched2 = lastsearched2;
	}


	public String getLastsearched3() {
		return lastsearched3;
	}


	public void setLastsearched3(String lastsearched3) {
		this.lastsearched3 = lastsearched3;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
