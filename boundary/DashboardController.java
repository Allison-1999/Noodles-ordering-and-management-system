package boundary;

import control.Customer;
import control.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *  Class Name: DashboardController.java
 *  Intro: A control class control the actions of Home1.fxml. It control the page switch of the customer side
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class DashboardController implements Initializable{
    private Customer customer = Main.getCustomer();

    @FXML
    private Label userLab;

    @FXML
    private Pane pnlPersonalInfo;

    @FXML
    private Pane pnlStamp;

    @FXML
    private Button btnSignOut;

    @FXML
    private Pane pnlRamen;

    @FXML
    private Button btnStamp;

    @FXML
    private Button btnRamen;

    @FXML
    private Button btnPersonalInfo;

    @FXML
    private Button btnCart;

    @FXML
    private Pane pnlCart;

    @FXML
    private Pane pnlWelcome;

    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the Home page of customer side.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (customer.getToPersonInfo() !=0 ){
            btnPersonalInfo.setText("Sign Up");
            userLab.setText("Visitor");
        }
        else{
            btnPersonalInfo.setText("Personal Info");
            userLab.setText(customer.getUser().getFirstName());
        }
        if (customer.getToPersonInfo() == 1) {
            pnlWelcome.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                pnlWelcome.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            pnlPersonalInfo.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
                pnlPersonalInfo.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Method Name: handleClicks()
     * Intro: handle clicks of the button at the left windon.
     * @param actionEvent the action event
     */
    public void handleClicks(ActionEvent actionEvent) {
        if(customer.getToPersonInfo() != 0){
            btnPersonalInfo.setText("Sign Up");
            userLab.setText("Visitor");
        }
        else{
            btnPersonalInfo.setText("Personal Info");
            userLab.setText(customer.getUser().getFirstName());
        }
        if (actionEvent.getSource() == btnRamen) {
            pnlRamen.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Ramen.fxml"));
                pnlRamen.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == btnCart) {
            pnlCart.toFront();
            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Cart.fxml"));
                pnlCart.getChildren().add(nodes[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == btnStamp) {
            pnlStamp.toFront();

            Node[] nodes = new Node[1];

            try {
                nodes[0] = FXMLLoader.load(getClass().getResource("Stamp.fxml"));
                pnlStamp.getChildren().add(nodes[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==btnPersonalInfo)
        {
            pnlPersonalInfo.toFront();
            int length = pnlPersonalInfo.getChildren().size();
            if (length > 0) {
                pnlPersonalInfo.getChildren().subList(0, length).clear();
            }
            Node[] nodes = new Node[1];
            try {
                if(customer.getToPersonInfo() == 0){
                    nodes[0] = FXMLLoader.load(getClass().getResource("PersonalInfo.fxml"));
                }
                else{
                    nodes[0] = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                }
                pnlPersonalInfo.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==btnSignOut)
        {
            Main.getPrimaryStage().close();
        }
    }
}


