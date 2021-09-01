package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

/**
 *  Class Name: RegistrationTicket.java
 *  Intro: An entity class to initialize a registration ticket when user registers as a member.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class RegistrationTicket implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private User usr;

	/**
	 * Method Name: RegistrationTicket()
	 * Intro: A constructor, to pass on the User pointer.
	 * @param us User type
	 */
	public RegistrationTicket(User us) {
		this.usr=us;
	}

	/**
	 * Method Name: getUser()
	 * Intro: return User
	 * @return User type
	 */
	public User getUser() {
		return this.usr;
	}

	/**
	 * Method Name: setUser()
	 * Intro: set user pointer
	 * @param us User type
	 */
	public void setUser(User us) {
		this.usr=us;
	}

	/**
	 * Method Name: printRegistrationTicket()
	 * Intro: print out a RegTicket.txt file and show the registration info of the new member.
	 */
	public void printRegistrationTicket() {
		 try {
				File fl = new File("data/RegTicket_" + usr.getUserID() + ".txt");
	            FileWriter fw = new FileWriter(fl);
	            BufferedWriter bw = new BufferedWriter(fw);
	            SystemTime systemTime = new SystemTime();
	            String time = systemTime.getDateString();
	            String intro = "   Werlcome To Join Our Loyalty Scheme! :)\n";
	            intro += "===================================================\n";
	            intro += "\nUser ID: " + this.usr.getUserID();
                intro += "\nUser Name: " + this.usr.getFirstName() + "\t" + this.usr.getSurname();
                
	            intro += "\nEmail: " + this.usr.getEmail();
	            intro += "\nPhone Number: " + this.usr.getPhoneNum();
	            intro += "\nTicketPrint Time: "+time;
	            intro += "\n===================================================\n";
	            bw.write(intro);
				bw.flush();
				bw.close();
				fw.close();
			}
			catch(Exception e) {
				System.err.println("Class RegistrationTicket Method Error");
				e.printStackTrace();
			}
	}
}
