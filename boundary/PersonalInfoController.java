package boundary;

import control.Customer;
import control.Main;
import control.Validation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *  Class Name: PersonalInfoController.java
 *  Intro: An control class control the actions of PersonalInfo.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class PersonalInfoController implements Initializable, GeneralInfo {
    private Customer customer = Main.getCustomer();

    @FXML
    private Label labUserID;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOK;

    @FXML
    private TextField NameField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField PhoneField;

    @FXML
    private TextField NameField1;

    @FXML
    private PasswordField PasswordField1;
    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the personal Info page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBtnCancel();
        btnCancel.setOnAction(event -> setBtnCancel());
        btnOK.setOnAction(event -> setBtnOK());
    }
    /**
     * Method Name: setBtnCancel()
     * Intro: cancel the modification of personal Info
     */
    public void setBtnCancel() {
        labUserID.setText(customer.getUser().getUserID());
        NameField.setText(customer.getUser().getFirstName());
        NameField1.setText(customer.getUser().getSurname());
        PhoneField.setText(customer.getUser().getPhoneNum());
        EmailField.setText(customer.getUser().getEmail());
        PasswordField1.setText("");
    }
    /**
     * Method Name: setBtnOK()
     * Intro: confirm the modification of personal Info
     */
    public void setBtnOK() {
        if (!NameField.getText().equals("") && !NameField1.getText().equals("") && (!PhoneField.getText().equals("") || !EmailField.getText().equals(""))){
            Validation.setTest(NameField.getText());
            if (Validation.validateName()){
                Validation.setTest(NameField1.getText());
                if (Validation.validateName()){
                    if (PhoneField.getText().equals("") || PhoneField.getText().charAt(0) == '+'){
                        Validation.setTest(PhoneField.getText());
                        if (Validation.validatePhone()){
                            Validation.setTest(EmailField.getText());
                            if(Validation.validateEmail()){
                                Validation.setTest(PasswordField1.getText());
                                if(Validation.validatePwd()){
                                    customer.getUser().setFirstName(NameField.getText());
                                    customer.getUser().setSurname(NameField1.getText());
                                    customer.getUser().setPhoneNum(PhoneField.getText());
                                    customer.getUser().setEmail(EmailField.getText());
                                    customer.getUser().setPasscode(PasswordField1.getText());
                                    customer.saveUser();
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
