package entities;

/**
 *  Class Name: User.java
 *  Intro: An entity class to store user information.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class User {
	String UserID;
	String FirstName;
	String Surname;
	String Passcode;
	String PhoneNum;
	String Email;
	int totalOrders;
	int stamps;
	int usedStamps;

	/**
	 * Method Name: setUserID()
	 * Intro: set user id
	 * @param id String type
	 */
	public void setUserID(String id) {
		this.UserID=id;
	}

	/**
	 * Method Name: setFirstName()
	 * Intro: set user first name
	 * @param newName String type
	 */
	public void setFirstName(String newName) {
		this.FirstName=newName;
	}

	/**
	 * Method Name: setSurname()
	 * Intro: set user surname
	 * @param newName String type
	 */
	public void setSurname(String newName){ this.Surname=newName; }

	/**
	 * Method Name: setPasscode()
	 * Intro: set user password
	 * @param newPW String type
	 */
	public void setPasscode(String newPW) {
		this.Passcode=newPW;
	}

	/**
	 * Method Name: setPhoneNum()
	 * Intro: set user phone number
	 * @param phnum String type
	 */
	public void setPhoneNum(String phnum) {
		this.PhoneNum=phnum;
	}

	/**
	 * Method Name: setEmail()
	 * Intro: set user email
	 * @param email String type
	 */
	public void setEmail(String email) {
		this.Email=email;
	}

	/**
	 * Method Name: setTotalOrders()
	 * Intro: set user total orders
	 * @param num int type
	 */
	public void setTotalOrders(int num) {
		this.totalOrders=num;
	}

	/**
	 * Method Name: setStamps()
	 * Intro: set user unused stamps
	 * @param num int type
	 */
	public void setStamps(int num) {
		this.stamps=num;
	}

	/**
	 * Method Name: setUsedStamps()
	 * Intro: set user used stamps
	 * @param num int type
	 */
	public void setUsedStamps(int num) {
		this.usedStamps=num;
	}

	/**
	 * Method Name: getFirstName()
	 * Intro: get user first name
	 * @return String type
	 */
	public String getFirstName() {
		return this.FirstName;
	}

	/**
	 * Method Name: getSurname()
	 * Intro: get user surname
	 * @return String type
	 */
	public String getSurname(){ return this.Surname; }

	/**
	 * Method Name: getUserID()
	 * Intro: get user ID
	 * @return String type
	 */
	public String getUserID() {
		return this.UserID;
	}

	/**
	 * Method Name: getPasscode()
	 * Intro: get user password
	 * @return String type
	 */
	public String getPasscode() {
		return this.Passcode;
	}

	/**
	 * Method Name: getPhoneNum()
	 * Intro: get user phone number
	 * @return String type
	 */
	public String getPhoneNum() {
		return this.PhoneNum;
	}

	/**
	 * Method Name: getEmail()
	 * Intro: get user email
	 * @return String type
	 */
	public String getEmail() {
		return this.Email;
	}

	/**
	 * Method Name: getTotalOrders()
	 * Intro: get user total orders
	 * @return int type
	 */
	public int getTotalOrders() {
		return this.totalOrders;
	}

	/**
	 * Method Name: getStamps()
	 * Intro: get user unused stamps
	 * @return int type
	 */
	public int getStamps() {
		return this.stamps;
	}

	/**
	 * Method Name: getUsedStamps()
	 * Intro: get user used stamps
	 * @return int type
	 */
	public int getUsedStamps() {
		return this.usedStamps;
	}
}

