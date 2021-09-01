package control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import entities.*;

/**
 *  Class Name: Business.java
 *  Intro: A control class to provide API for user interface -- a bridge between entity classes and boundary classes.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class Business {
    private Restaurant rest;
    private OrderList orderList;
    private ArrayList<User> userList;

    /**
     * Method Name: Business()
     * Intro: A constructor, input a ramen restaurant ID (multiple ramen restaurant for extensive use)
     *     and load data to java object (for preparation).
     * @param id ramen restaurant id in RestInfo.csv
     */
    public Business(int id){
        FillRestInfo fillRestInfo = new FillRestInfo(id);
        FillOrderList fillOrderList = new FillOrderList();
        this.rest = fillRestInfo.getRestaurant();
        this.orderList = fillOrderList.getOrderlist();
        FillUserList fillUserList = new FillUserList();
        this.userList = fillUserList.getUserList();
        FillMenu.fillMenu();
    }

    /**
     * Method Name: getOrderList()
     * Intro: return order list pointer
     * @return OrderList type
     */
    public OrderList getOrderList(){
        return this.orderList;
    }

    /**
     * Method Name: viewRestName()
     * Intro: return restaurant name
     * @return String type
     */
    public String viewRestName(){
        return rest.getRestName();
    }

    /**
     * Method Name: viewRestIntro()
     * Intro: return restaurant introduction
     * @return String type
     */
    public String viewRestIntro(){
        return rest.getRestIntro();
    }

    /**
     * Method Name: viewRestPostalcode()
     * Intro: return restaurant postal code
     * @return String type
     */
    public String viewRestPostalcode(){
        return rest.getRestPostalcode();
    }

    /**
     * Method Name: viewRestAddress()
     * Intro: return restaurant address
     * @return String type
     */
    public String viewRestAddress(){
        return rest.getRestAddress();
    }

    /**
     * Method Name: viewRestRegistrationDate()
     * Intro: return restaurant registration date
     * @return String type
     */
    public String viewRestRegistrationDate(){
        return rest.getRestRegistrationDate();
    }


    /**
     * Method Name: modifyRestName()
     * Intro: modify restaurant name
     * @param name String type
     */
    public void modifyRestName(String name) {
        rest.setRestName(name);
    }

    /**
     * Method Name: modifyRestIntro()
     * Intro: modify restaurant intro
     * @param intro String type
     */
    public void modifyRestIntro(String intro) {
        rest.setRestIntro(intro);
    }

    /**
     * Method Name: modifyRestPostalcode()
     * Intro: modify restaurant postal code
     * @param Postalcode String type
     */
    public void modifyRestPostalcode(String Postalcode) {
        rest.setRestPostalcode(Postalcode);
    }

    /**
     * Method Name: modifyRestAddress()
     * Intro: modify restaurant address
     * @param Address String type
     */
    public void modifyRestAddress(String Address) {
        rest.setRestAddress(Address);
    }

    /**
     * Method Name: modifyRestRegistrationDate()
     * Intro: modify restaurant registration date
     * @param RegistrationDate String type
     */
    public void modifyRestRegistrationDate(String RegistrationDate) {
        rest.setRestRegistrationDate(RegistrationDate);
    }

    /**
     * Method Name: saveRestInfo()
     * Intro: save restaurant info when close the windows
     */
    public void saveRestInfo (){
        new SaveRestInfo(this.rest);
    }


    /**
     * Method Name: viewTotalOrder()
     * Intro: return num of total order
     * @return int type
     */
    public int viewTotalOrder(){
        ArrayList<String> orderId = new ArrayList<>();
        int i;

        for(i=0;i < orderList.getArraylist().size();i++){
            if (!orderId.contains(orderList.getArraylist().get(i).getOrderID() + "")){
                orderId.add(orderList.getArraylist().get(i).getOrderID() + "");
            }
        }
        return orderId.size();
    }

    /**
     * Method Name: viewTotalAmount()
     * Intro: return amount of total order
     * @return String type
     */
    public String viewTotalAmount(){
        double Total_Amount=0;
        DecimalFormat df=new DecimalFormat("0.00");
        int i;

        for(i=0;i<orderList.getArraylist().size();i++){
            Total_Amount+=orderList.getArraylist().get(i).getOrderAmount();
        }
        return df.format(Total_Amount);
    }

    /**
     * Method Name: viewTodayOrder()
     * Intro: return num of orders generated today
     * @return int type
     */
    public int viewTodayOrder(){
        SystemTime systemTime = new SystemTime();
        String today = systemTime.getDateStringPro().substring(0, 8);
        String orderDay;
        int count = 0;
        for(int i = 0; i < orderList.getArraylist().size(); i++){
            orderDay = String.valueOf(orderList.getArraylist().get(i).getOrderID()).substring(0, 8);
            if (today.equals(orderDay)){
                count++;
            }
        }
        return count;
    }

    /**
     * Method Name: getSoupCount()
     * Intro: return num of current soup type with given name
     * @param name soup type (3 types)
     * @return int type
     */
    public int getSoupCount(String name){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getSoup().equals(name))
                    count++;
            }
        }
        return count;
    }

    /**
     * Method Name: getNoodleCount()
     * Intro: return num of current noodles type with given name
     * @param name noodles type (3 types)
     * @return int type
     */
    public int getNoodleCount(String name){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getNoodles().equals(name))
                    count++;
            }
        }
        return count;
    }

    /**
     * Method Name: getNoriCount()
     * Intro: return num of nori
     * @return int type
     */
    public int getNoriCount(){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getNori())
                    count++;
                count += orderList.getArraylist().get(i).getRamenList().get(j).getExtra_nori();
            }
        }
        return count;
    }

    /**
     * Method Name: getChashuCount()
     * Intro: return num of chashu
     * @return int type
     */
    public int getChashuCount(){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getChashu())
                    count++;
                count += orderList.getArraylist().get(i).getRamenList().get(j).getExtra_chashu();
            }
        }
        return count;
    }

    /**
     * Method Name: getEggCount()
     * Intro: return num of egg
     * @return int type
     */
    public int getEggCount(){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getBoiled_egg())
                    count++;
                count += orderList.getArraylist().get(i).getRamenList().get(j).getExtra_boiled_egg();
            }
        }
        return count;
    }

    /**
     * Method Name: getBambooCount()
     * Intro: return num of bamboo
     * @return int type
     */
    public int getBambooCount(){
        int count = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                count += orderList.getArraylist().get(i).getRamenList().get(j).getBamboo_shoots();
            }
        }
        return count;
    }

    /**
     * Method Name: getPopularOnion()
     * Intro: return the most popular level of onion
     * @return String type
     */
    public String getPopularOnion(){
        int No = 0;
        int Little = 0;
        int Lot = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                if (orderList.getArraylist().get(i).getRamenList().get(j).getOnion_level() == 0) {No++;}
                else if (orderList.getArraylist().get(i).getRamenList().get(j).getOnion_level() == 1) {Little++;}
                else{Lot++;}
            }
        }
        if (No >= Little && No >= Lot){
            return "No";
        }
        else if (Little >= No && Little >= Lot){
            return "A Little";
        }
        else{
            return "Lot";
        }
    }

    /**
     * Method Name: getPopularSpic()
     * Intro: return the most popular level of spic
     * @return String type
     */
    public String getPopularSpic(){
        int[] spic = {0, 0, 0, 0, 0, 0};
        int index = 0;
        int max = 0;
        int i;
        int j;
        for (i = 0; i < orderList.getArraylist().size(); i++){
            for (j = 0; j < orderList.getArraylist().get(i).getRamenList().size(); j++){
                spic[orderList.getArraylist().get(i).getRamenList().get(j).getSpiciness()]++;
            }
        }
        for (i = 0; i < 6; i ++){
            if (spic[i] > max)
                index = i;
        }
        return "" + index;
    }

    /**
     * Method Name: saveMenu()
     * Intro: save menu after modification
     * @throws IOException giving exception if error occurs in operating files
     */
    public void saveMenu() throws IOException { SaveMenu.saveMenu(); }

    /**
     * Method Name: getUserList()
     * Intro: return pointer of user list
     * @return array list User
     */
    public ArrayList<User> getUserList(){ return this.userList; }
}
