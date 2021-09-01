package control;
import entities.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  Class Name: SaveOrderList.java
 *  Intro: A control class to fill in order list info from OrderList.csv.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class SaveOrderList extends Writer{
    private OrderList list;

    /**
     * Method Name: SaveOrderList()
     * @param list OrderList list
     */
    public SaveOrderList(OrderList list){
        this.list = list;
    }


    /**
     * Method Name: Save()
     * @throws IOException throws exceptions
     */
    public void Save() throws IOException {
        BufferedWriter bw = writer("data/OrderList.csv");
        bw.write("OrderId,Code,Amount,Method,GenerateTime," +
                "Soup,Noodles,Level,Nori,Chashu,B_egg,Spic,E_nori,E_egg,Bambs,E_cha,Num,UserID,Name\r\n");
        for (int i = 0; i< list.getArraylist().size(); i++) {
            for (int j = 0; j< list.getArraylist().get(i).getRamenList().size(); j++) {
                bw.write(list.getArraylist().get(i).getOrderID() + ",");
                bw.write(list.getArraylist().get(i).getCode()+",");
                bw.write(list.getArraylist().get(i).getOrderAmount()+",");
                bw.write(list.getArraylist().get(i).getPaymentMethod()+",");
                bw.write(list.getArraylist().get(i).getGenerateTime()+",");
                bw.write(list.getArraylist().get(i).getRamen(j).getSoup()+",");
                bw.write(list.getArraylist().get(i).getRamen(j).getNoodles()+",");
                bw.write(list.getArraylist().get(i).getRamen(j).getOnion_level()+",");
                bw.write(list.getArraylist().get(i).getRamen(j).getNori() +",");
                bw.write(list.getArraylist().get(i).getRamen(j).getChashu() +",");
                bw.write(list.getArraylist().get(i).getRamen(j).getBoiled_egg() +",");
                bw.write(list.getArraylist().get(i).getRamen(j).getSpiciness() +",");
                bw.write(list.getArraylist().get(i).getRamen(j).getExtra_nori() +",");
                bw.write(list.getArraylist().get(i).getRamen(j).getExtra_boiled_egg() +",");
                bw.write(list.getArraylist().get(i).getRamen(j).getBamboo_shoots() +",");
                bw.write(list.getArraylist().get(i).getRamen(j).getExtra_chashu() +",");
                bw.write(list.getArraylist().get(i).getRamen(j).getNum()+",");
                if(list.getArraylist().get(i).getUser() != null){
                    bw.write(list.getArraylist().get(i).getUser().getUserID()+",");
                    bw.write(list.getArraylist().get(i).getUser().getFirstName() + list.getArraylist().get(i).getUser().getSurname() +"\r\n");
                }
                else{
                    bw.write("null"+",");
                    bw.write("nullnull" +"\r\n");
                }
            }
        }
        close();
    }
}
