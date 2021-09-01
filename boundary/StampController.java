package boundary;

import control.Customer;
import control.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
/**
 *  Class Name: StampController.java
 *  Intro: An control class control the actions of Stamp.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class StampController implements Initializable {
    private Customer customer = Main.getCustomer();

    @FXML
    private Label StampLab;

    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the stamp page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (customer.getUser() != null){
            StampLab.setText(customer.viewUserStamps() + "");
        }
        else{
            StampLab.setText("0");
        }
    }
}
