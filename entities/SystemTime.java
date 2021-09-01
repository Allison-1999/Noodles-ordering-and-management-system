package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Class Name: SystemTime.java
 *  Intro: An entity class to generate current time.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class SystemTime implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Method Name: getDate()
	 * Intro: get current date
	 * @return Date type
	 */
	public Date getDate() {
		Date date = new Date();
		long timeGap = 0L;
		date.setTime(date.getTime() + timeGap * 1000);
		return date;

	}

	/**
	 * Method Name: getDateStringPro()
	 * Intro: get date as a string with all digits
	 * @return String type
	 */
	public String getDateStringPro() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(getDate());
	}

	/**
	 * Method Name: getDateString()
	 * Intro: get date as a string with normal format
	 * @return String type
	 */
	public String getDateString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(getDate());
	}
}
