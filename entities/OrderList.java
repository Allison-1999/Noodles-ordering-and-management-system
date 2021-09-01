package entities;
import java.util.ArrayList;

/**
 *  Class Name: OrderList.java
 *  Intro: An entity class to store all the orders in one object.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class OrderList {
    private ArrayList<Order> list = new ArrayList<>();

    /**
     * Method Name: getArraylist()
     * Intro: return teh orders array list pointer.
     * @return ArrayList Orders
     */
    public ArrayList<Order> getArraylist()
    {
        return this.list;
    }
}
