package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

/**
 *  Class Name: Ticket.java
 *  Intro: An entity class to generate and print out a ticket.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class Ticket implements Serializable{
    private static final long serialVersionUID = 1L;
    private Order order;

    /**
     * Method Name: Ticket()
     * Intro: pass on order pointer of the current order
     * @param order Order type
     */
    public Ticket(Order order){
        this.order = order;
    }

    /**
     * Method Name: getOrder()
     * Intro: return current order
     * @return Order type
     */
    public Order getOrder(){
        return this.order;
    }

    /**
     * Method Name: setOrder()
     * Intro: set Order
     * @param order Order type
     */
    public void setOrder(Order order){
        this.order = order;
    }

    /**
     * Method Name: printTicket()
     * Intro: print out a ticket when an order is paid.
     */
    public void printTicket() { 
        try {
			File fl = new File("data/ticket_" + order.getOrderID() + ".txt");
            FileWriter fw = new FileWriter(fl);
            BufferedWriter bw = new BufferedWriter(fw);
            SystemTime systemTime = new SystemTime();
            String time = systemTime.getDateString();
            String intro = "Werlcome to Totoro Ramen!\n";
            if(this.order.getUser() != null){
                intro += "\nUser ID: " + this.order.getUser().getUserID();
                intro += "\nUser Name: " + this.order.getUser().getFirstName() + "\t" + this.order.getUser().getSurname();
            }
            else{
                intro += "\nUser ID: null";
                intro += "\nUser Name: Visitor";
            }
            intro += "\nDate: " + time;
            intro += "\nOrder ID: " + this.order.getOrderID();
            intro += "\nOrder Amount: " + this.order.getOrderAmount();
            intro += "\nCode: " + this.order.getCode();
            if(order.getTakeAway()){
                intro += "\nTake Away";
            }
            else{
                intro += "\nEat in";
            }
            intro += "\n=================================\n";
            bw.write(intro);
			bw.flush();
            for(int i=0; i<this.order.getRamenList().size(); i++){
                Ramen ramen = this.order.getRamenList().get(i);
                bw.write(printRamen(ramen, i));
                bw.flush();
            } 
			bw.close();
			fw.close();
		}
		catch(Exception e) {
			System.err.println("Class Restaurant Constructor Error");
			e.printStackTrace();
		}
    }

    public String printRamen(Ramen ramen, int count){
        String ramenInfo = "---------------  "+ count +"  --------------";
        ramenInfo += "\nSoup: " + ramen.getSoup();
        ramenInfo += "\nNoodles: " + ramen.getNoodles();
        ramenInfo += "\nOnion Level: : " + ramen.getOnion_level();
        ramenInfo += "\nBamboo Shoots: " + ramen.getBamboo_shoots();
        ramenInfo += "\nNori : " + ramen.getNori() + "  Extra: " + ramen.getExtra_nori();
        ramenInfo += "\nChashu: " + ramen.getChashu() + "  Extra: " + ramen.getExtra_chashu();
        ramenInfo += "\nBoiled Egg: " + ramen.getBoiled_egg() + "   Extra: " + ramen.getExtra_boiled_egg();
        ramenInfo += "\nSpiciness: " + ramen.getSpiciness();
        ramenInfo += "\nNumber : " + ramen.getNum();
        ramenInfo += "\n---------------------------------\n\n";

        return ramenInfo;
    }
}
