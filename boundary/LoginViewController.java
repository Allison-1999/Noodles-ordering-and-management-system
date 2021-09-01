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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Class Name: LoginViewController.java
 *  Intro: An control class control the actions of LoginView.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class LoginViewController implements Initializable, GeneralInfo{
    Customer customer = Main.getCustomer();
    @FXML
    private TextField usernameField;

    @FXML
    private Button SignInButton;

    @FXML
    private Label DateLab;

    @FXML
    private VBox loginBox;

    @FXML
    private Button ForgetButton;

    @FXML
    private Button VisitorButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private Pane InfoPane;

    @FXML
    private Label AddressLab;

    @FXML
    private Label PostalLab;

    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the log in page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label restName = (Label) InfoPane.lookup("#restName");
        restName.setText(customer.getRest().getRestName());

        Label restInfo = (Label) InfoPane.lookup("#restInfo");
        restInfo.setText(customer.getRest().getRestIntro());

        AddressLab.setText("Address:\t" + customer.getRest().getRestAddress());
        PostalLab.setText("Postal code:\t" + customer.getRest().getRestPostalcode());
        DateLab.setText("Registration Date:\t" + customer.getRest().getRestRegistrationDate());

        TextField userIDField = (TextField) loginBox.lookup("#userIDField");
        TextField passwordField = (TextField) loginBox.lookup("#passwordField");

        SignInButton.setOnAction(event -> {
            String usrid = userIDField.getText();
            String pw = passwordField.getText();
            if (customer.loginUser(usrid, pw)) {
                showDashboard();
            } else {
                showGeneralInfo("Action Failed! Please input correct id and password.");
            }
        });

        VisitorButton.setOnAction(event -> {
            customer.setToPersonInfo(2);
            showDashboard();
            showGeneralInfo("Click Sign Up to register to become an affiliate! Enjoy ramen for free!");
        });
        SignUpButton.setOnAction(event -> {
            customer.setToPersonInfo(1);
            showDashboard();
        });

        ForgetButton.setOnAction(actionEvent -> showBusiness());
    }

    /**
     * Method Name: showDashboard()
     * Intro: initialize the Home page of customer side.
     */
    public void showDashboard() {
        Stage primaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/Home1.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 1050, 576));
            Main.getPrimaryStage().close();
            Main.setPrimaryStage(primaryStage);
            Main.getPrimaryStage().initStyle(StageStyle.UNDECORATED);
            Main.getPrimaryStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method Name: showBusiness()
     * Intro: initialize the Home page of business side.
     */
    public void showBusiness() {
        Stage primaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/Home.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, 1050, 576));
            Main.getPrimaryStage().close();
            Main.setPrimaryStage(primaryStage);
            Main.getPrimaryStage().initStyle(StageStyle.UNDECORATED);
            Main.getPrimaryStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method Name: showGeneralInfo(String notice)
     * Intro: initialize the generalInfo page, giving a notice to the user.
     *  @param notice Information that will give to the user
     */
    @Override
    public void showGeneralInfo(String notice){
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
