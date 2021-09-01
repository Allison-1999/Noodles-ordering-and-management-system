package control;

import entities.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  Class Name: SaveUserList.java
 *  Intro: A control class to save user info into Users.csv.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class SaveUserList {
	private User localusr = new User();

	/**
	 * Method Name: GenUser()
	 * @param firstname user first name
	 * @param surname user surname
	 * @param pw user password
	 * @param phnum user phone number
	 * @param mail user email
	 * @return user id
	 */
	public String GenUser(String firstname,String surname, String pw, String phnum, String mail) {
		String id=GenID();
		localusr.setTotalOrders(0); 
		localusr.setStamps(0);
		localusr.setUsedStamps(0);
		localusr.setFirstName(firstname);
		localusr.setSurname(surname);
		localusr.setPasscode(pw);
		localusr.setEmail(mail);
		localusr.setPhoneNum(phnum);
		localusr.setUserID(id);
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				String titleline = "UserID,firstname,surname,Passcode,Phone,Email,Stamps,UsedStamps,TotalOrders,Online";
				bw.write(titleline);
				bw.flush();
				bw.close();
				fw.close();
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content;
			List<String> userlist = new ArrayList<>();
			while((content=br.readLine())!=null) {
				userlist.add(content);
			}
			fr.close();
			br.close();
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			int i = 0;
			userlist.add(id+","+firstname+","+surname+","+pw+","+phnum+","+mail+",0,0,0,0");
			while(i<userlist.size()) {
				bw.write(userlist.get(i)+"\r\n");
				i++;
			}
			bw.flush();
			bw.close();
			fw.close();
			System.out.println("Successfully Generate New User!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * Method Name: GenID()
	 * @return user id
	 */
	public String GenID(){
		int i = 10000000;
	try {
		File f = new File("data/Users.csv");
		if(!f.exists())
		{
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			String titleline = "UserID,firstname,surname,Passcode,Phone,Email,Stamps,UsedStamps,TotalOrders,Online";
			bw.write(titleline);
			bw.flush();
			bw.close();
			fw.close();
		}
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		while(br.readLine() !=null) {
			i++;
		}
		fr.close();
		br.close();
		
	}
	catch(Exception e) {
		System.err.println("ERROR IN GenID()");
	}
	return i+"";
	}

	/**
	 * Method Name: PlusTotalOrders()
	 * Intro: When Successfully purchase new order, call this method to plus it into this User's TotalOrders
	 * @param usr user pointer
	 * @return User type
	 */
	public User PlusTotalOrders(User usr) {
		int num = usr.getTotalOrders();
		num++;
		usr.setTotalOrders(num);
		return usr;
	}

	/**
	 * Method Name: UseStamps()
	 * Intro: Every time You use a stamp, please call this method to fresh this User's Stamps and UsedStamps
	 * @param usr user pointer
	 * @return User type
	 */
	public User UseStamps(User usr) {
		int num1 = usr.getStamps();
		num1 -= 10;
		usr.setStamps(num1);
		
		int num2 = usr.getUsedStamps();
		num2 += 10;
		usr.setUsedStamps(num2);
		return usr;
	}

	/**
	 * Method Name: ScanStamps()
	 * Intro: Every time u operate on User's stamp, UsedStamps, or TotalOrders, please call this method to fresh data
	 * @param usr user pointer
	 * @return User type
	 */
	public User ScanStamps(User usr) {
		int num = usr.getTotalOrders();
		int num2 = usr.getUsedStamps();
		int num1 = num - num2/10 - num2;
		usr.setStamps(num1);
		return usr;
	}

	/**
	 * Method Name: SaveUserInfo()
	 * @param usr user pointer
	 */
	public void SaveUserInfo(User usr) {
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				throw new RuntimeException("No Users.csv");
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content;
			boolean cunzai = false;
			List<String> userlist = new ArrayList<>();
			while((content=br.readLine())!=null) {
				String[] str = content.split(",");
				if(usr.getUserID().equals(str[0])) {
					cunzai=true;
					userlist.add(str[0]+","+usr.getFirstName()+","+usr.getSurname()+","+usr.getPasscode()+","+usr.getPhoneNum()+","
						+usr.getEmail()+","+usr.getStamps()+","+usr.getUsedStamps()+","+usr.getTotalOrders()+","+str[9]);
				}
				else userlist.add(content);
			}
			fr.close();
			br.close();
			if(cunzai) {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("");
				int i = 0;
				while(i<userlist.size()) {
					bw.write(userlist.get(i)+"\r\n");
					i++;
				}
				bw.flush();
				bw.close();
				fw.close();
				System.out.println("Successfully Save User Info!");
			}
			else throw new RuntimeException("NO User:"+usr.getUserID());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method Name: Login()
	 * @param id user id
	 * @param pw user password
	 * @return login or not
	 */
	public boolean Login(String id, String pw) {
		boolean checker = false;
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				throw new RuntimeException("No Users.csv");
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content;
			boolean cunzai =false;
			List<String> userlist = new ArrayList<>();
			while((content=br.readLine())!=null) {
				String[] str = content.split(",");
				if(str[0].equals(id)&&str[3].equals(pw)) {
					if(str[9].equals("1"))
					{
						fr.close();
						br.close();
						throw new RuntimeException("Warninng: User Already Login");
					}
					else {
						cunzai=true;
						userlist.add(str[0]+","+str[1]+","+str[2]+","+str[3]+","+str[4]+","+str[5]+","+str[6]+","+str[7]+","+str[8]+",1");
					}
				}
				else userlist.add(content);
			}
			fr.close();
			br.close();

			if(cunzai) {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("");
				int i = 0;
				while(i<userlist.size()) {
					bw.write(userlist.get(i)+"\r\n");
					i++;
				}
				bw.flush();
				bw.close();
				fw.close();
				System.out.println("Successfully Login User:"+id);
				checker = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return checker;
	}

	/**
	 * Method Name: Logout()
	 * @param id user id
	 */
	public void Logout(String id) {
		try {
			File f = new File("data/Users.csv");
			if(!f.exists())
			{
				throw new RuntimeException("No Users.csv");
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String content;
			List<String> userlist = new ArrayList<>();
			while((content=br.readLine())!=null) {
				String[] str = content.split(",");
				if(str[0].equals(id)) {
					userlist.add(str[0]+","+str[1]+","+str[2]+","+str[3]+","+str[4]+","+str[5]+","+str[6]+","+str[7]+","+str[8]+",0");
				}
				else userlist.add(content);
			}
			fr.close();
			br.close();
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			int i = 0;
			while(i<userlist.size()) {
				bw.write(userlist.get(i)+"\r\n");
				i++;
			}
			bw.flush();
			bw.close();
			fw.close();
			System.out.println("Successfully Logout User:"+id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
