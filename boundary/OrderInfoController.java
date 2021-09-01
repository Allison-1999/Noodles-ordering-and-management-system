package boundary;

import entities.Order;
import entities.Ramen;
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
 *  Class Name: OrderInfoController.java
 *  Intro: An control class control the actions of order Info pane
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class OrderInfoController implements Initializable{
    private Order currentOrder = OrderController.getCurrentOrder();
    @FXML
    private VBox RamenItem;

    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the order Info pane.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[currentOrder.getRamenList().size()];
        for (int i = 0; i < nodes.length; i++) {
            try {
                final int j = i;
                Ramen ramen = currentOrder.getRamenList().get(i);
                nodes[i] = FXMLLoader.load(getClass().getResource("RamenItem.fxml"));

                Label index = (Label) nodes[i].lookup("#index");
                index.setText("Ramen " + i);
                Label soup = (Label) nodes[i].lookup("#soup");
                soup.setText("Soup: " + ramen.getSoup());
                Label noodles = (Label) nodes[i].lookup("#noodles");
                noodles.setText("Noodles: " + ramen.getNoodles());
                Label onion = (Label) nodes[i].lookup("#onion");
                onion.setText("Spring onion: " + ramen.getOnion_level());
                Label Nori = (Label) nodes[i].lookup("#Nori");
                Nori.setText("Nori: " + ramen.getNori());
                Label Chashu = (Label) nodes[i].lookup("#Chashu");
                Chashu.setText("Chashu: " + ramen.getChashu());
                Label egg = (Label) nodes[i].lookup("#egg");
                egg.setText("Boiled egg: " + ramen.getBoiled_egg());
                Label spiciness = (Label) nodes[i].lookup("#spiciness");
                spiciness.setText("Spiciness: " + ramen.getSpiciness());
                Label extraNori = (Label) nodes[i].lookup("#extraNori");
                extraNori.setText("Extra Nori: " + ramen.getExtra_nori());
                Label extraEgg = (Label) nodes[i].lookup("#extraEgg");
                extraEgg.setText("Extra boiled egg: " + ramen.getExtra_boiled_egg());
                Label extraChashu = (Label) nodes[i].lookup("#extraChashu");
                extraChashu.setText("Extra Chashu: " + ramen.getExtra_chashu());
                Label bamboo = (Label) nodes[i].lookup("#bamboo");
                bamboo.setText("Bamboo shoots: " + ramen.getBamboo_shoots());
                //System.out.println(CustomerItems);
                RamenItem.getChildren().add(nodes[i]);
                nodes[i].setOnMouseEntered(event -> nodes[j].setStyle("-fx-background-color : #0A0E3F"));
                nodes[i].setOnMouseExited(event -> nodes[j].setStyle("-fx-background-color : #02030A"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
