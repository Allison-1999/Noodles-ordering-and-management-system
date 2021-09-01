package boundary;

import control.Business;
import control.Main;
import control.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *  Class Name: RestaurantController.java
 *  Intro: An control class control the actions of Restaurant.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class RestaurantController  implements Initializable, GeneralInfo {
    private Business business = Main.getBusiness();

    @FXML
    private Pane Restpln;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;
    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the restaurant page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setRestpln();
    }
    /**
     * Method Name: setRestpln()
     * Intro: cancel the modification of restaurant Info
     */
    public void setRestpln() {
        TextField restName = (TextField) Restpln.lookup("#restName");
        restName.setText(business.viewRestName());
        TextField address = (TextField) Restpln.lookup("#address");
        address.setText(business.viewRestAddress());
        TextField postal = (TextField) Restpln.lookup("#postal");
        postal.setText(business.viewRestPostalcode());
        TextField date = (TextField) Restpln.lookup("#date");
        date.setText(business.viewRestRegistrationDate());
        ScrollPane scrollPane = (ScrollPane) Restpln.lookup("#intro");
        TextArea intro = (TextArea) scrollPane.contentProperty().getValue();
        intro.setText(business.viewRestIntro());
        TextField RestNameField1 = (TextField) Restpln.lookup("#RestNameField1");
        RestNameField1.setText("");
        RadioButton sub = (RadioButton) Restpln.lookup("#subscribe");
        sub.setSelected(false);
    }
    /**
     * Method Name: saveRest()
     * Intro: confirm the modification of restaurant Info
     */
    public void saveRest(){
        TextField RestNameField1 = (TextField) Restpln.lookup("#RestNameField1");
        String email = RestNameField1.getText();
        RadioButton sub = (RadioButton) Restpln.lookup("#subscribe");
        boolean subscribe = sub.isSelected();
        Validation.setTest(email);
        if (!subscribe || (Validation.validateEmail() && !email.equals(""))){
            TextField restName = (TextField) Restpln.lookup("#restName");
            business.modifyRestName(restName.getText());
            TextField address = (TextField) Restpln.lookup("#address");
            business.modifyRestAddress(address.getText());
            TextField postal = (TextField) Restpln.lookup("#postal");
            business.modifyRestPostalcode(postal.getText());
            TextField date = (TextField) Restpln.lookup("#date");
            business.modifyRestRegistrationDate(date.getText());
            ScrollPane scrollPane = (ScrollPane) Restpln.lookup("#intro");
            TextArea intro = (TextArea) scrollPane.contentProperty().getValue();
            business.modifyRestIntro(intro.getText());
            if (subscribe){
                showGeneralInfo("Successfully subscribe sales analysis in every Monday.");
            }
        }
        else{
            showGeneralInfo("Please input a valid email.");
        }
    }
    /**
     * Method Name: handleClicks()
     * Intro: handle clicks of the button at this page.
     * @param actionEvent the action event
     */
    public void handleClicks(ActionEvent actionEvent){
        if (actionEvent.getSource() == btnOK) {
            saveRest();
        }
        if (actionEvent.getSource() == btnCancel) {
            setRestpln();
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
