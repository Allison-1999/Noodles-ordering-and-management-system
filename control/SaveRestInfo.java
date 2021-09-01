package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import entities.Restaurant;

/**
 *  Class Name: SaveRestInfo.java
 *  Intro: A control class to save restaurant list info into RestInfo.csv.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class SaveRestInfo {
	/**
	 * Method Name: FillRestInfo()
	 * Intro: This is a constructor
	 *  When u create a new SaveRestInfo instance
	 * 	u need to transmit a Restaurant pointer into this constructor
	 * 	And in this way, it will automatically save your restaurant info into the csv file
	 *
	 * @param rst chosen restaurant id
	 */
	public SaveRestInfo(Restaurant rst) {
		int id = rst.getRestID();
		String name = rst.getRestName();
		String intro = rst.getRestIntro();
		String postalcode = rst.getRestPostalcode();
		String address = rst.getRestAddress();
		String register = rst.getRestRegistrationDate();
		try {
			File fl = new File("data/RestInfo.csv");
			if(!fl.exists())
			{
				fl.createNewFile();
				FileWriter fw = new FileWriter(fl);
				BufferedWriter bw = new BufferedWriter(fw);
				String titleline = "RestID,Name,Introduction,Address,Postal,RegistDate";
				bw.write(titleline);
				bw.flush();
				bw.close();
				fw.close();
			}
			FileReader fr = new FileReader(fl);
			BufferedReader br = new BufferedReader(fr);
			String content;
			//Boolean duplicate=false;
			List<String> restlist = new ArrayList<>();
			while((content=br.readLine())!=null) {
				String[] contentlist = content.split(",");
				if(contentlist[0].equals(Integer.toString(id))) {
					//duplicate=true;
				}
				else restlist.add(content);
			}
			fr.close();
			br.close();
			FileWriter fw = new FileWriter(fl);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			int i = 0;
			intro=intro.replace("\n", "`+`");
			restlist.add(id+","+name+","+intro+","+address+","+postalcode+","+register);
			while(i<restlist.size()) {
				bw.write(restlist.get(i)+"\r\n");
				i++;
			}
			bw.flush();
			bw.close();
			fw.close();
			System.out.println("Successfully Save New RestInfo!");
		}
		catch(Exception e) {
			System.err.println("Class Restaurant Constructor() Error");
			e.printStackTrace();
		}
	}
}

