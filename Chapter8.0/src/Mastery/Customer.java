package Mastery;

public class Customer {
	private String firstName, lastName, street, city, province, postalCode;

	//create String variables street, city, province, postal code	

	
	/**
	 * constructor
	 * pre: none
	 * post: A Customer object has been created. 
	 * Customer data has been initialized with parameters.
	 */
	public Customer(String fName, String lName, String str, String c, String prov, String postal) //modify constructor to include street, city, province, postal code
	{
		firstName = fName;
		lastName = lName;
		street = str;
		city = c;
		province = prov;
		postalCode = postal;
	}
	
	//Modifier method
	public void setStreet(String str) {
		street = str;
	}
	public void setCity(String c) {
		city = c;
	}
	public void setProv(String prov) {
		province = prov;
	}
	public void setPostal(String postal) {
		postalCode = postal;
	}

	//Access method
	public String getStreet() {
		return(street);
	}
	public String getCity() {
		return(city);
	}
	public String getProv() {
		return(province);
	}
	public String getPostal() {
		return(postalCode);
	}

	/** 
	 * Returns a String that represents the Customer object.
	 * pre: none
	 * post: A string representing the Customer object has 
	 * been returned.
	 */
	public String toString() {
	 	return("Account Holder's Name: " + firstName + " " + lastName + "\n"
	 			+ "Adress: " + street + ", " + city + ", " + province + ", "
	 			+ postalCode + "\n");
	}

}