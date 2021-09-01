package boundary;

import control.Customer;
import control.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *  Class Name: PayController.java
 *  Intro: An control class control the actions of Pay.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class PayController implements Initializable, GeneralInfo {
    private Customer customer = Main.getCustomer();

    private String choice = "";

    @FXML
    private Button btnOK;

    @FXML
    private AnchorPane PayPnl;

    @FXML
    private Label AmonutLabel;
    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the payment page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AmonutLabel.setText(customer.calcOrderAmount() + "");
        ToggleGroup groupPay = new ToggleGroup();
        RadioButton credit = (RadioButton) PayPnl.lookup("#credit");
        credit.setToggleGroup(groupPay);
        credit.setUserData("credit");
        RadioButton paypal = (RadioButton) PayPnl.lookup("#paypal");
        paypal.setToggleGroup(groupPay);
        paypal.setUserData("paypal");
        RadioButton stamps = (RadioButton) PayPnl.lookup("#stamps");
        stamps.setToggleGroup(groupPay);
        stamps.setUserData("stamps");
        Label notice = (Label) PayPnl.lookup("#notice");
        if(customer.getUser() == null || customer.viewUserStamps() < 10){
            notice.setText("(Do not have enough stamps)");
            stamps.setDisable(true);
        }
        else{
            notice.setText("Use 10 stamps to pay ramens for free!");
            stamps.setDisable(false);
        }
        groupPay.selectedToggleProperty().addListener((changed, oldVal, newVal) -> choice = groupPay.getSelectedToggle().getUserData().toString());
        btnOK.setOnAction(event -> {
            if (choice.equals("")){
                showGeneralInfo("Please select a payment method.");
            }
            else{
                customer.formOrder(choice);
                if (customer.getUser() != null) {
                    if (choice.equals("stamps")) {
                        customer.refreshUserWithStamps();
                    } else {
                        customer.refreshUserWithoutStamps();
                    }
                }
                CartController.getPayStage().close();
            }
        });
    }
    /**
     * Method Name: showGeneralInfo(String notice)
     * Intro: initialize the generalInfo page, giving a notice to the user.
     *  @param notice Information that will give to the user
     */
    @Override
    public void showGeneralInfo(String notice) {
        Stage primaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/GeneralInfo.fxml"));
            Parent root = loader.load();
            Label text = (Label) root.lookup("#GeneralLab");
            text.setText(notice);
            primaryStage.setScene(new Scene(root));
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
            primaryStage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

