package control;
import entities.*;
import java.io.*;
import java.util.ArrayList;

/**
 *  Class Name: FillOrderList.java
 *  Intro: A control class to fill in order list info from OrderList.csv.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class FillOrderList extends Reader{
    private OrderList list= new OrderList();

    public FillOrderList(){
        Order temp = new Order();
        temp.setOrderID(Long.MAX_VALUE);
        FillUserList fillUserList = new FillUserList();
        try {
            BufferedReader textFile = reader("data/OrderList.csv");
            String lineDta=textFile.readLine();
            while ((lineDta=textFile.readLine()) != null) {
                String[] item = lineDta.split(",");
                if (temp.getOrderID()!=Long.parseLong(item[0]))
                {
                    temp = new Order();
                    if (item[0].endsWith("1"))  temp.setTakeAway(true);
                    else temp.setTakeAway(false);
                    temp.setOrderID(Long.parseLong(item[0]));
                    temp.setCode(Integer.parseInt(item[1]));
                    temp.setOrderAmount(Float.parseFloat(item[2]));
                    temp.setPaymentMethod(item[3]);
                    temp.setGenerateTime(item[4]);
                    temp.setUser(fillUserList.getUserByID(item[17]));
                    temp.setRamenList(new ArrayList<>());
                    list.getArraylist().add(temp);
                }
                Ramen temp_r = new Ramen();
                temp_r.setSoup(item[5]);
                temp_r.setNoodles(item[6]);
                temp_r.setOnion_level(Integer.parseInt(item[7]));
                temp_r.setNori(Boolean.parseBoolean(item[8]));
                temp_r.setChashu(Boolean.parseBoolean(item[9]));
                temp_r.setBoiled_egg(Boolean.parseBoolean(item[10]));
                temp_r.setSpiciness(Integer.parseInt(item[11]));
                temp_r.setExtra_nori(Integer.parseInt(item[12]));
                temp_r.setExtra_boiled_egg(Integer.parseInt(item[13]));
                temp_r.setBamboo_shoots(Integer.parseInt(item[14]));
                temp_r.setExtra_chashu(Integer.parseInt(item[15]));
                temp_r.setNum(Integer.parseInt(item[16]));
                temp.getRamenList().add(temp_r);
            }
            close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("Write/read error");
        }
    }

    /**
     * Method: getOrderlist()
     * Intro: getter of list
     * @return OrderList type
     */
    public OrderList getOrderlist(){
        return this.list;
    }
}
