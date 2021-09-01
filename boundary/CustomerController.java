package boundary;

import control.Business;
import control.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Class Name: CustomerController.java
 *  Intro: A control class control the actions of Customer.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class CustomerController implements Initializable{
    private Business business = Main.getBusiness();

    @FXML
    private VBox CustomerItems;

    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the customer page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[business.getUserList().size()];
        for (int i = 0; i < nodes.length; i++) {
            try {
                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));
                //System.out.println(CustomerItems);
                Label userId = (Label) nodes[i].lookup("#userId");
                userId.setText(business.getUserList().get(i).getUserID());
                Label userName = (Label) nodes[i].lookup("#userName");
                userName.setText(business.getUserList().get(i).getFirstName() + " " + business.getUserList().get(i).getSurname() + "\t");
                Label email = (Label) nodes[i].lookup("#email");
                if (business.getUserList().get(i).getEmail().equals("")){
                    email.setText("  null  \t");
                }
                else{
                    email.setText(business.getUserList().get(i).getEmail() + "\t");
                }
                Label phone = (Label) nodes[i].lookup("#phone");
                if( business.getUserList().get(i).getPhoneNum().equals("")){
                    phone.setText("  null  \t");
                }
                else{
                    phone.setText(business.getUserList().get(i).getPhoneNum()+"\t");
                }
                Label amount = (Label) nodes[i].lookup("#amount");
                amount.setText(business.getUserList().get(i).getStamps() + "");

                CustomerItems.getChildren().add(nodes[i]);
                nodes[i].setOnMouseEntered(event -> nodes[j].setStyle("-fx-background-color : #0A0E3F"));
                nodes[i].setOnMouseExited(event -> nodes[j].setStyle("-fx-background-color : #02030A"));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
