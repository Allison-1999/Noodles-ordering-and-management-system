package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  Class Name: Order.java
 *  Intro: An entity class to store Order information, such as order Id, user, time and ramens in the order.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class Order implements Serializable{
    // private static final long serialVersionUID = 1L;
    private long order_ID;
    private int code; // the sequence code when you take food.
    private float order_amount; 
    private String payment_method;
    private String generateTime;
    private ArrayList<Ramen> ramenList;
    private Boolean takeAway = null;
    private User user;

    /**
     * Method Name: Order()
     * Intro: A constructor to generate basic information when an order is established.
     */
    public Order(){
        SystemTime systemTime = new SystemTime();
        this.generateTime = systemTime.getDateString();
        this.order_ID = Long.parseLong(systemTime.getDateStringPro());
        this.ramenList = new ArrayList<>();
    }

    /**
     * Method Name: getOrderID()
     * Intro: return order ID
     * @return order ID
     */
    public long getOrderID(){
        return this.order_ID;
    }

    /**
     * Method Name: setOrderID()
     * Intro: set order ID
     * @param order_ID order ID
     */
    public void setOrderID(long order_ID){
        this.order_ID = order_ID;
    }

    /**
     * Method Name: getCode()
     * Intro: return sequence code when you take food
     * @return code
     */
    public int getCode(){
        return this.code;
    }

    /**
     * Method Name: setCode()
     * Intro: set sequence code
     * @param code sequence code
     */
    public void setCode(int code){
        this.code = code;
    }

    /**
     * Method Name: getOrderAmount()
     * Intro: return order amount after setting it
     * @return order amount
     */
    public float getOrderAmount(){
        return this.order_amount;
    }

    /**
     * Method Name: setOrderAmount()
     * Intro: set order amount before get value from it.
     * @param order_amount order total amount
     */
    public void setOrderAmount(float order_amount){
        this.order_amount = order_amount;
    }

    /**
     * Method Name: getPaymentMethod()
     * Intro: return payment method.
     * @return payment method
     */
    public String getPaymentMethod(){
        return this.payment_method;
    }

    /**
     * Method Name: setPaymentMethod()
     * Intro: set payment method before using it.
     * @param inputMethod payment method of current order.
     */
    public void setPaymentMethod(String inputMethod){
        this.payment_method = inputMethod;
    }

    /**
     * Method Name: getGenerateTime()
     * Intro: return generate time -- String type
     * @return generate time
     */
    public String getGenerateTime(){
        return this.generateTime;
    }

    /**
     * Method Name: setGenerateTime()
     * Intro: set generate time, input a String variable
     * @param generateTime generate time, String type
     */
    public void setGenerateTime(String generateTime){
        this.generateTime = generateTime;
    }

    /**
     * Method Name: getRamenList()
     * Intro: return the pointer of the ramen list of the order.
     * @return arraylist, ramen
     */
    public ArrayList<Ramen> getRamenList(){
        return this.ramenList;
    }

    /**
     * Method Name: setRamenList()
     * Intro: set ramen list pointer.
     * @param ramenList ramen list pointer.
     */
    public void setRamenList(ArrayList<Ramen> ramenList){
        this.ramenList = ramenList;
    }

    /**
     * Method Name: setTakeAway()
     * Intro: set take away -> true or eat in -> false
     * @param takeAway a boolean value, take away -> true; eat in -> false
     */
    public void setTakeAway(Boolean takeAway){
        this.takeAway = takeAway;
    }

    /**
     * Method Name: getTakeAway()
     * Intro: get the choice of taking away or eating in
     * @return boolean value, take away -> true; eat in -> false
     */
    public Boolean getTakeAway(){
        return this.takeAway;
    }

    /**
     * Method Name: setUser()
     * Intro: set the user pointer linking to the order.
     * @param user User type
     */
    public void setUser(User user){
        this.user = user;
    }

    /**
     * Method Name: getUser()
     * Intro: return the User pointer after setting it.
     * @return User type
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Method Name: get a ramen in the ramen list
     * @param index the index of the needed ramen
     * @return Ramen type
     */
    public Ramen getRamen(int index){
        return this.ramenList.get(index);
    }
}