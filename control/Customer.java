package control;

import java.io.IOException;

import entities.*;

/**
 *  Class Name: Customer.java
 *  Intro: A control class to provide API for user interface -- a bridge between entity classes and boundary classes.
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class Customer {
    private Restaurant rest;
    private Order draft = new Order();
    private Ramen ramen;
    private FillRestInfo fillRestInfo;
    private FillOrderList fillOrderList;
    private OrderList orderList;
    private FillUserList ful = new FillUserList();
    private SaveUserList sul = new SaveUserList();
    private User user;
    private int toPersonInfo = 0;
    private int nextCode = 0;

    /**
     * Method Name: Customer()
     * Intro: A constructor, input a ramen restaurant ID (multiple ramen restaurant for extensive use)
     *      and load data to java object (for preparation).
     * @param restID ramen restaurant id in RestInfo.csv
     */
    public Customer(int restID) {
        this.fillOrderList = new FillOrderList();
        this.fillRestInfo = new FillRestInfo(restID);
        this.fillInRest();
        this.fillInOrderList();
        this.setDraft(new Order());
        this.ramen = new Ramen();
        FillMenu.fillMenu();
    }

    /**
     * Method Name: getRamen()
     * Intro: getter of ramen
     * @return Ramen type
     */
    public Ramen getRamen() {
        return ramen;
    }

    /**
     * Method Name: setRamen()
     * Intro: setter of ramen
     * @param ramen new ramen
     */
    public void setRamen(Ramen ramen) {
        this.ramen = ramen;
    }

    /**
     * Method Name: setToPersonInfo()
     * Intro: an indicator to define the operation when showing personal info panel
     *     0 referred to as normal operation after login
     *     1 referred to as load sign up panel after click visitor button
     *     2 referred to as jump into sign up panel to register immediately
     * @param to int indicator
     */
    public void setToPersonInfo(int to){this.toPersonInfo = to;}

    /**
     * Method Name getToPersonInfo()
     * Intro: getter of tpPersonInfo
     * @return int type
     */
    public int getToPersonInfo(){return this.toPersonInfo;}

    /**
     * Method Name: getDraft()
     * Intro: getter of draft
     * @return Order type
     */
    public Order getDraft() {
		return draft;
	}

    /**
     * Method Name: setDraft()
     * Intro: setter of draft
     * @param draft new Order, empty one -> shopping cart
     */
	public void setDraft(Order draft) {
		this.draft = draft;
    }

    /**
     * Method Name: getRest()
     * Intro: getter of rest
     * @return Restaurant type
     */
    public Restaurant getRest(){
        return this.rest;
    }

    /**
     * Method Name: setNextCode()
     * Intro: setter of nextCode
     * @param code new code
     */
    public void setNextCode(int code){ this.nextCode = code; }

    /**
     * Method Name: getNextCode()
     * Intro: getter of nextCode
     * @return int type
     */
    public int getNextCode(){ return this.nextCode; }

    /**
     * Method Name: fillInRest()
     * Intro: fill restaurant info from RestInfo.csv to rest
     */
    public void fillInRest(){
        this.rest = this.fillRestInfo.getRestaurant();
    }

    /**
     * Method Name: fillInOrderList()
     * Intro: fill order info from OrderList.csv to orderList
     */
    public void fillInOrderList(){
        this.orderList = this.fillOrderList.getOrderlist();
    }

    /**
     * Method Name: formOrder()
     * Intro: When paying for an order, this method is called to store info to back-end
     * @param payment_method input chosen payment method
     */
    public void formOrder(String payment_method){
        this.draft.setPaymentMethod(payment_method);
        this.draft.setCode(this.nextCode);
        this.draft.setOrderAmount(this.calcOrderAmount());
        this.setNextCode(this.getNextCode() + 1);
        this.draft.setUser(this.user);
        this.orderList.getArraylist().add(this.draft);
        Ticket ticket = new Ticket(this.draft);
        ticket.printTicket();
        this.draft = new Order();
    }

    /**
     * Method Name: calcOrderAmount()
     * Intro: return order amount
     * @return float type
     */
    public float calcOrderAmount(){
        float amount = 0.0f;
        for(int i = 0; i < this.getDraft().getRamenList().size(); i++){
            amount += this.getDraft().getRamenList().get(i).calcRamenAmount();
        }
        return amount;
    }

    /**
     * Method Name: saveOrderList()
     * Intro: save order info to OrderList.csv after operations
     * @throws IOException throw out exception if error occurs in operating csv
     */
    public void saveOrderList() throws IOException{
        SaveOrderList save = new SaveOrderList(this.orderList);
        save.Save();
    }

    /**
     * Method Name: loginUser()
     * Intro: login when id and pw matches
     * @param id user id
     * @param pw user password
     * @return boolean type
     */
    public boolean loginUser(String id,String pw) {
        boolean success = sul.Login(id, pw);
        if(success) {
            this.user = ful.getUserByID(id);
        }
        return success;
    }

    /**
     * Method Name: logoutUser()
     * Intro: user logout
     */
    public void logoutUser() {
        sul.Logout(this.user.getUserID());
    }

    /**
     * Method Name: registUser()
     * Intro: membership registration
     * @param firstName user first name
     * @param surname user surname
     * @param pw user password
     * @param phone user phone number
     * @param mail user email address
     * @return return automatically generated user id
     */
    public String registUser(String firstName, String surname, String pw, String phone, String mail) {
        return sul.GenUser(firstName, surname, pw, phone, mail);
    }

    /**
     * Method Name: genRegTicket()
     * Intro: when membership registration succeed, this method will be called to print out relevant info.
     * @param usr User pointer
     */
    public void genRegTicket(User usr){
        RegistrationTicket regTicket = new RegistrationTicket(usr);
        regTicket.printRegistrationTicket();
    }

    /**
     * Method Name: viewUserStamps()
     * Intro: return user unused stamps
     * @return int type
     */
    public int viewUserStamps() {
        return this.user.getStamps();
    }

    /**
     * Method Name: refreshUserWithoutStamps()
     * Intro: when paying for order without stamps, using this methods
     */
    public void refreshUserWithoutStamps() {
        this.user = sul.PlusTotalOrders(this.user);
        this.user = sul.ScanStamps(this.user);
    }

    /**
     * Method Name: refreshUserWithStamps()
     * Intro: when paying for order with stamps, using this methods
     */
    public void refreshUserWithStamps() {
        this.user = sul.PlusTotalOrders(this.user);
        this.user = sul.UseStamps(this.user);
        this.user = sul.ScanStamps(this.user);
    }

    /**
     * Method Name: saveUser()
     * Intro: save user info
     */
    public void saveUser(){
        sul.SaveUserInfo(this.user);
    }

    /**
     * Method Name: getUser()
     * Intro: getter of user
     * @return
     */
    public User getUser(){return this.user;}
}