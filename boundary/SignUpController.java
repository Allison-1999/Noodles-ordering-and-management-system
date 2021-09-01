package boundary;

import control.Customer;
import control.Main;
import control.Validation;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *  Class Name: SignUpController.java
 *  Intro: An control class control the actions of SignUp.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class SignUpController implements Initializable, GeneralInfo {
    private Customer customer = Main.getCustomer();

    private String preNum = "";

    @FXML
    private Button btnCancel;

    @FXML
    private AnchorPane SignUpPnl;

    @FXML
    private Button btnOK;

    @FXML
    private TextField NameField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField PhoneField;

    @FXML
    private TextField SurnameField;

    @FXML
    private ChoiceBox<String> phoneChoicebox;
    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the restaurant page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBtnCancel();
        ObservableList<String> choiceItems = FXCollections.observableArrayList();
        choiceItems.add(0, "+86");
        choiceItems.add(1, "+44");
        phoneChoicebox.setItems(choiceItems);
        phoneChoicebox.setValue("1");
        phoneChoicebox.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->{
            if (new_val.intValue() == 0){
                preNum = "+86";
            }
            else{
                preNum = "+44";
            }
        });
        btnCancel.setOnAction(event -> setBtnCancel());
        btnOK.setOnAction(event -> setBtnOK());
    }
    /**
     * Method Name: setBtnCancel()
     * Intro: cancel the modification of Sign up Info
     */
    public void setBtnCancel(){
        NameField.setText("");
        SurnameField.setText("");
        PhoneField.setText("");
        EmailField.setText("");
        PasswordField passwordField = (PasswordField) SignUpPnl.lookup("#password");
        passwordField.setText("");
    }
    /**
     * Method Name: setBtnOK()
     * Intro: confirm the modification of Sign up Info
     */
    public void setBtnOK(){
        PasswordField passwordField = (PasswordField) SignUpPnl.lookup("#password");
        if (!NameField.getText().equals("") && !SurnameField.getText().equals("") && (!PhoneField.getText().equals("") || !EmailField.getText().equals(""))){
            Validation.setTest(NameField.getText());
            if (Validation.validateName()){
                Validation.setTest(SurnameField.getText());
                if (Validation.validateName()){
                    if (!preNum.equals("") || PhoneField.getText().equals("")){
                        Validation.setTest(preNum + PhoneField.getText());
                        if (Validation.validatePhone()){
                            Validation.setTest(EmailField.getText());
                            if(Validation.validateEmail()){
                                Validation.setTest(passwordField.getText());
                                if(Validation.validatePwd()){
                                    String id = customer.registUser(NameField.getText(), SurnameField.getText(), passwordField.getText(), preNum + PhoneField.getText(), EmailField.getText());
                                    customer.setToPersonInfo(0);
                                    customer.loginUser(id, passwordField.getText());
                                    customer.genRegTicket(customer.getUser());
                                    showGeneralInfo("Welcome to Ramen Membership Family! You will receive an email/SNS showing membership info!");
                                }
                                else{
                                    showGeneralInfo("Composition of password: 6~10 char of a~z, A~Z, 0~9.");
                                }
                            }
                            else{
                                showGeneralInfo("Please fill in email address in valid format.");
                            }
                        }
                        else{
                            showGeneralInfo("Phone Number: 11 digits, first digit 0 for +44 and first digit 1 for +86.");
                        }
                    }
                    else {
                        showGeneralInfo("Please choose prefix of the phone. +44 for British or +86 for Chinese.");
                    }
                }
                else{
                    showGeneralInfo("Please input a valid Surname.");
                }
            }
            else{
                showGeneralInfo("Please input a valid First Name");
            }
        }
        else {
            showGeneralInfo("First Name and Surname are compulsory. Fill in Email or Phone Number.");
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
