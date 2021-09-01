package boundary;

import control.Customer;
import control.Main;
import entities.Ramen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *  Class Name: CartController.java
 *  Intro: A control class control the actions of Cart.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class CartController implements Initializable, GeneralInfo{
    private Customer customer = Main.getCustomer();
    private static Stage payStage;
    private ArrayList<String> ramenList = new ArrayList<>();

    @FXML
    private VBox ramenItems;

    @FXML
    private Label AmonutLabel;

    @FXML
    private AnchorPane CartPnl;

    @FXML
    private Button btnPay;

    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the cart page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AmonutLabel.setText("Amount: " + customer.calcOrderAmount() + "");
        ToggleGroup group = new ToggleGroup();
        RadioButton takeAway = (RadioButton) CartPnl.lookup("#takeAway");
        takeAway.setToggleGroup(group);
        takeAway.setUserData("Take Away");
        RadioButton eatIn = (RadioButton) CartPnl.lookup("#eatIn");
        eatIn.setToggleGroup(group);
        eatIn.setUserData("Eat In");
        group.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (group.getSelectedToggle().getUserData().toString().equals("Take Away")) {
                customer.getDraft().setTakeAway(true);
            } else {
                customer.getDraft().setTakeAway(false);
            }
        });
        btnPay.setOnAction(event -> {
            if (customer.getDraft().getRamenList().size() == 0) {
                showGeneralInfo("No ramen selected.");
            } else {
                if (customer.getDraft().getTakeAway() == null) {
                    showGeneralInfo("Please Choose Eat in or Take away");
                } else {
                    showPayPage();
                    refresh();
                }
            }
        });
        Node[] RamenNodes = new Node[customer.getDraft().getRamenList().size()];
        for (int i = 0; i < RamenNodes.length; i++) {
            try {
                final int j = i;
                ramenList.add(j + "");
                Ramen ramen =customer.getDraft().getRamenList().get(i);
                RamenNodes[i] = FXMLLoader.load(getClass().getResource("RamenItem1.fxml"));
                Label amount = (Label) RamenNodes[i].lookup("#amount");
                amount.setText(ramen.calcRamenAmount() + "");
                Button btnDeletRamen = (Button) RamenNodes[i].lookup("#btnDeletRamen");
                btnDeletRamen.setOnAction(event -> {
                    ramenItems.getChildren().remove(ramenList.indexOf(j + ""));
                    customer.getDraft().getRamenList().remove(ramenList.indexOf(j + ""));
                    ramenList.remove(j + "");
                    AmonutLabel.setText(customer.calcOrderAmount() + "");
                });
                Label soup = (Label) RamenNodes[i].lookup("#soup");
                soup.setText("Soup: " + ramen.getSoup());
                Label noodles = (Label) RamenNodes[i].lookup("#noodles");
                noodles.setText("Noodles: " + ramen.getNoodles());
                Label onion = (Label) RamenNodes[i].lookup("#onion");
                onion.setText("Spring onion: " + ramen.getOnion_level());
                Label Nori = (Label) RamenNodes[i].lookup("#Nori");
                Nori.setText("Nori: " + ramen.getNori());
                Label Chashu = (Label) RamenNodes[i].lookup("#Chashu");
                Chashu.setText("Chashu: " + ramen.getChashu());
                Label egg = (Label) RamenNodes[i].lookup("#egg");
                egg.setText("Boiled egg: " + ramen.getBoiled_egg());
                Label spiciness = (Label) RamenNodes[i].lookup("#spiciness");
                spiciness.setText("Spiciness: " + ramen.getSpiciness());
                Label extraNori = (Label) RamenNodes[i].lookup("#extraNori");
                extraNori.setText("Extra Nori: " + ramen.getExtra_nori());
                Label extraEgg = (Label) RamenNodes[i].lookup("#extraEgg");
                extraEgg.setText("Extra boiled egg: " + ramen.getExtra_boiled_egg());
                Label extraChashu = (Label) RamenNodes[i].lookup("#extraChashu");
                extraChashu.setText("Extra Chashu: " + ramen.getExtra_chashu());
                Label bamboo = (Label) RamenNodes[i].lookup("#bamboo");
                bamboo.setText("Bamboo shoots: " + ramen.getBamboo_shoots());

                ramenItems.getChildren().add(RamenNodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method Name: showPayPage()
     * Intro: initialize the payment page.
     */
    public void showPayPage(){
        payStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../boundary/Pay.fxml"));
            Parent root = loader.load();
            payStage.setScene(new Scene(root));
            payStage.initStyle(StageStyle.DECORATED);
            payStage.show();
            payStage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method Name: Stage getPayStage(
     * Intro: initialize the payment page.
     * @return payStage the payment page
     */
    public static Stage getPayStage(){
        return payStage;
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
    /**
     * Method Name: refresh()
     * Intro: reset the ramen page, after the last ramen added to cart
     */
    public void refresh(){
        int length = ramenItems.getChildren().size();
        RadioButton eatIn = (RadioButton) CartPnl.lookup("#eatIn");
        eatIn.setSelected(true);
        AmonutLabel.setText("Amount: 0");
        if (length > 0) {
            ramenItems.getChildren().subList(0, length).clear();
        }
    }
}
