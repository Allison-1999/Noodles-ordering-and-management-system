package entities;

/**
 *  Class Name: Restaurant.java
 *  Intro: An entity class to store restaurant information.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class Restaurant {
	
	private int restID;
	private String name; 
	private String intro;
	private String postal;
	private String address;
	private String registrationDate;

	/**
	 * Method Name: setRestID()
	 * Intro: set restaurant ID
	 * @param num int type
	 */
	public void setRestID(int num) {
		this.restID=num;
	}

	/**
	 * Method Name: setRestName()
	 * Intro: set restaurant name
	 * @param str String type
	 */
	public void setRestName(String str) {
		this.name=str;
	}

	/**
	 * Method Name: setRestIntro()
	 * Intro: set restaurant  introduction
	 * @param str String type
	 */
	public void setRestIntro(String str) {
		this.intro=str;
	}

	/**
	 * Method Name: getRestID()
	 * Intro: return restaurant ID
	 * @return int type
	 */
	public int getRestID() {
		return this.restID;
	}

	/**
	 * Method Name: getRestName()
	 * Intro: return restaurant name
	 * @return String type
	 */
	public String getRestName() {
		return this.name;
	}

	/**
	 * Method Name: getRestIntro()
	 * Intro: return restaurant introduction
	 * @return String type
	 */
	public String getRestIntro() {
		return this.intro;
	}

	/**
	 * Method Name: getRestPostalcode()
	 * Intro: return restaurant postal code
	 * @return String type
	 */
    public String getRestPostalcode() {
		return this.postal;
    }

	/**
	 * Method Name: getRestAddress()
	 * Intro: return restaurant address
	 * @return String type
	 */
	public String getRestAddress() {
		return this.address;
	}

	/**
	 * Method Name: getRestRegistrationDate()
	 * Intro: return restaurant registration date
	 * @return String type
	 */
	public String getRestRegistrationDate() {
		return this.registrationDate;
	}

	/**
	 * Method Name: setRestPostalcode()
	 * Intro: set restaurant postal code
	 * @param postalcode String type
	 */
	public void setRestPostalcode(String postalcode) {
		this.postal = postalcode;
	}

	/**
	 * Method Name: setRestAddress()
	 * Intro: set restaurant address
	 * @param address String type
	 */
	public void setRestAddress(String address) {
		this.address = address;
	}

	/**
	 * Method Name: setRestRegistrationDate()
	 * Intro: set restaurant registration date
	 * @param registrationDate String type
	 */
	public void setRestRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
}

