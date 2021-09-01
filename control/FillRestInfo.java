package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import entities.Restaurant;

/**
 *  Class Name: FillRestInfo.java
 *  Intro: A control class to fill in restaurant list info from RestInfo.csv.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class FillRestInfo {
	private Restaurant r = new Restaurant();// a local restaurant instance ready to be filled by constructor

	/**
	 * Method Name: FillRestInfo()
	 * Intro:When u create a FillRestInfo
	 * 	    u need to transmit the Restaurant ID into this constructor
	 * 	    only then the Restaurant info u want will be loaded into the local restaurant instance r
	 * @param restid chosen restaurant id
	 */
	public FillRestInfo(int restid) {
		try {
			File f = new File("data/RestInfo.csv");
			//System.out.println(f.getAbsoluteFile());
			if(!f.exists())
			{
				throw new RuntimeException("ERROR: Lack Of RestInfo.csv");
			}
			else {
				boolean cunzai = false;
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String content;
				while((content=br.readLine())!=null) {
					String[] splitstr = content.split(",");
					if(splitstr[0].equals(Integer.toString(restid)))
					{
						cunzai = true;
						r.setRestID(restid);
						r.setRestName(splitstr[1]);
						r.setRestIntro(splitstr[2].replace("`+`", "\n"));
						r.setRestAddress(splitstr[3]);
						r.setRestPostalcode(splitstr[4]);
						r.setRestRegistrationDate(splitstr[5]);
					}
				}
				br.close();
				fr.close();
				if(!cunzai) {
					throw new RuntimeException("ERROR: No Such Restaurant ID");
				}
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method: getRestaurant()
	 * Intro: getter of r
	 * @return Restaurant type
	 */
	public Restaurant getRestaurant() {
		return this.r;
	}
}

