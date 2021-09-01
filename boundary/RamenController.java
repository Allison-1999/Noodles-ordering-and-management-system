package boundary;

import control.Customer;
import control.Main;
import entities.Menu;
import entities.Ramen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 *  Class Name: RamenController.java
 *  Intro: An control class control the actions of Ramen.fxml
 * @author Group 105, EBU6304
 * @version 5.0
 */
public class RamenController implements Initializable {
    private Customer customer = Main.getCustomer();

    @FXML
    private AnchorPane RamenPnl;
    /**
     * Method Name: handleClicks()
     * Intro: handle clicks of the button at this page.
     * @param actionEvent the action event
     */
    public void handleClicks(ActionEvent actionEvent) {
        actionEvent.getSource();
    }
    /**
     * Method Name: initialize(URL location, ResourceBundle resources)
     * Intro: initialize the Ramen page.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label Amount = (Label) RamenPnl.lookup("#Amount");
        Amount.setText(Menu.getFixed_price() + "");
        //初始化Ramen
        ArrayList<Ramen> tempRamen = new ArrayList<>();
        tempRamen.add(new Ramen());

        
        Label ExtraNori = (Label) RamenPnl.lookup("#ExtraNori");
        Button addNori = (Button) RamenPnl.lookup("#addNori");
        addNori.setDisable(true);
        addNori.setOnAction(event -> {
            if (!ExtraNori.getText().equals("100")) {
                ExtraNori.setText(String.valueOf(Integer.parseInt(ExtraNori.getText()) + 1));
                tempRamen.get(tempRamen.size() - 1).setExtra_nori(Integer.parseInt(ExtraNori.getText()));
                Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
            }
        });
        Button subNori = (Button) RamenPnl.lookup("#subNori");
        subNori.setDisable(true);
        subNori.setOnAction(event -> {
            if (!ExtraNori.getText().equals("0")) {
                ExtraNori.setText(String.valueOf(Integer.parseInt(ExtraNori.getText()) - 1));
                tempRamen.get(tempRamen.size() - 1).setExtra_nori(Integer.parseInt(ExtraNori.getText()));
                Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
            }
        });

        
        Label ExtraChashu = (Label) RamenPnl.lookup("#ExtraChashu");
        Button addChashu = (Button) RamenPnl.lookup("#addChashu");
        addChashu.setDisable(true);
        addChashu.setOnAction(event -> {
            if (!ExtraChashu.getText().equals("100")) {
                ExtraChashu.setText(String.valueOf(Integer.parseInt(ExtraChashu.getText()) + 1));
                tempRamen.get(tempRamen.size() - 1).setExtra_chashu(Integer.parseInt(ExtraChashu.getText()));
                Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
            }
        });
        Button subChashu = (Button) RamenPnl.lookup("#subChashu");
        subChashu.setDisable(true);
        subChashu.setOnAction(event -> {
            if (!ExtraChashu.getText().equals("0")) {
                ExtraChashu.setText(String.valueOf(Integer.parseInt(ExtraChashu.getText()) - 1));
                tempRamen.get(tempRamen.size() - 1).setExtra_chashu(Integer.parseInt(ExtraChashu.getText()));
                Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
            }
        });

        
        Label ExtraBoiledEgg = (Label) RamenPnl.lookup("#ExtraBoiledEgg");
        Button addBoiledEgg = (Button) RamenPnl.lookup("#addBoiledEgg");
        addBoiledEgg.setDisable(true);
        addBoiledEgg.setOnAction(event -> {
            if (!ExtraBoiledEgg.getText().equals("100")) {
                ExtraBoiledEgg.setText(String.valueOf(Integer.parseInt(ExtraBoiledEgg.getText()) + 1));
                tempRamen.get(tempRamen.size() - 1).setExtra_boiled_egg(Integer.parseInt(ExtraBoiledEgg.getText()));
                Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
            }
        });
        Button subBoiledEgg = (Button) RamenPnl.lookup("#subBoiledEgg");
        subBoiledEgg.setDisable(true);
        subBoiledEgg.setOnAction(event -> {
            if (!ExtraBoiledEgg.getText().equals("0")) {
                ExtraBoiledEgg.setText(String.valueOf(Integer.parseInt(ExtraBoiledEgg.getText()) - 1));
                tempRamen.get(tempRamen.size() - 1).setExtra_boiled_egg(Integer.parseInt(ExtraBoiledEgg.getText()));
                Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
            }
        });

        
        Label BambooShoots = (Label) RamenPnl.lookup("#BambooShoots");
        Button addBambooShoot = (Button) RamenPnl.lookup("#addBambooShoot");
        addBambooShoot.setOnAction(event -> {
            if (!BambooShoots.getText().equals("100")) {
                BambooShoots.setText(String.valueOf(Integer.parseInt(BambooShoots.getText()) + 1));
                tempRamen.get(tempRamen.size() - 1).setBamboo_shoots(Integer.parseInt(BambooShoots.getText()));
                Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
            }
        });
        Button subBambooShoot = (Button) RamenPnl.lookup("#subBambooShoot");
        subBambooShoot.setOnAction(event -> {
            if (!BambooShoots.getText().equals("0")) {
                BambooShoots.setText(String.valueOf(Integer.parseInt(BambooShoots.getText()) - 1));
                tempRamen.get(tempRamen.size() - 1).setBamboo_shoots(Integer.parseInt(BambooShoots.getText()));
                Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
            }
        });
        if (!Menu.isBamboo_shoots()){
            addBambooShoot.setDisable(true);
            subBambooShoot.setDisable(true);
        }

        
        ToggleGroup groupSoup = new ToggleGroup();
        RadioButton Tonkotsu = (RadioButton) RamenPnl.lookup("#Tonkotsu");
        Tonkotsu.setToggleGroup(groupSoup);
        Tonkotsu.setUserData("Tonkotsu");
        if (!Menu.isSoup_Tonkotsu())
            Tonkotsu.setDisable(true);
        RadioButton Shoyu = (RadioButton) RamenPnl.lookup("#Shoyu");
        Shoyu.setToggleGroup(groupSoup);
        Shoyu.setUserData("Shoyu");
        if (!Menu.isSoup_Shoyu())
            Shoyu.setDisable(true);
        RadioButton Shio = (RadioButton) RamenPnl.lookup("#Shio");
        Shio.setToggleGroup(groupSoup);
        Shio.setUserData("Shio");
        if (!Menu.isSoup_Shio())
            Shio.setDisable(true);
        groupSoup.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (groupSoup.getSelectedToggle() != null) {
                tempRamen.get(tempRamen.size() - 1).setSoup(groupSoup.getSelectedToggle().getUserData().toString());
            }
        });

        
        ToggleGroup groupNoddles = new ToggleGroup();
        RadioButton NoodleSoft = (RadioButton) RamenPnl.lookup("#NoodleSoft");
        NoodleSoft.setToggleGroup(groupNoddles);
        NoodleSoft.setUserData("Soft");
        if (!Menu.isNoodles_Soft())
            NoodleSoft.setDisable(true);
        RadioButton NoodleMedium = (RadioButton) RamenPnl.lookup("#NoodleMedium");
        NoodleMedium.setToggleGroup(groupNoddles);
        NoodleMedium.setUserData("Medium");
        if (!Menu.isNoodles_Medium())
            NoodleMedium.setDisable(true);
        RadioButton NoodleFirm = (RadioButton) RamenPnl.lookup("#NoodleFirm");
        NoodleFirm.setToggleGroup(groupNoddles);
        NoodleFirm.setUserData("Firm");
        if (!Menu.isNoodles_Firm())
            NoodleFirm.setDisable(true);

        groupNoddles.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (groupNoddles.getSelectedToggle() != null) {
                tempRamen.get(tempRamen.size() - 1).setNoodles(groupNoddles.getSelectedToggle().getUserData().toString());
            }
        });

        
        ToggleGroup groupOnion = new ToggleGroup();
        RadioButton OnionNo = (RadioButton) RamenPnl.lookup("#OnionNo");
        OnionNo.setToggleGroup(groupOnion);
        OnionNo.setUserData("No");
        RadioButton OnionLittle = (RadioButton) RamenPnl.lookup("#OnionLittle");
        OnionLittle.setToggleGroup(groupOnion);
        OnionLittle.setUserData("Little");
        RadioButton OnionLot = (RadioButton) RamenPnl.lookup("#OnionLot");
        OnionLot.setToggleGroup(groupOnion);
        OnionLot.setUserData("Lot");
        groupOnion.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (groupOnion.getSelectedToggle() != null) {
                if (groupOnion.getSelectedToggle().getUserData().equals("NO"))
                    tempRamen.get(tempRamen.size() - 1).setOnion_level(0);
                else if (groupOnion.getSelectedToggle().getUserData().equals("Little"))
                    tempRamen.get(tempRamen.size() - 1).setOnion_level(1);
                else
                    tempRamen.get(tempRamen.size() - 1).setOnion_level(2);
            }
        });

        
        ToggleGroup groupNori = new ToggleGroup();
        RadioButton NoriYes = (RadioButton) RamenPnl.lookup("#NoriYes");
        NoriYes.setToggleGroup(groupNori);
        NoriYes.setUserData("Yes");
        RadioButton NoriNo = (RadioButton) RamenPnl.lookup("#NoriNo");
        NoriNo.setToggleGroup(groupNori);
        NoriNo.setUserData("No");
        if (!Menu.isNori()){
            NoriYes.setDisable(true);
            NoriNo.setDisable(true);
        }
        groupNori.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (groupNori.getSelectedToggle() != null) {
                if (groupNori.getSelectedToggle().getUserData().equals("Yes")) {
                    addNori.setDisable(false);      //根据选择来判断是否需要禁用相关button
                    subNori.setDisable(false);
                    tempRamen.get(tempRamen.size() - 1).setNori(true);
                } else {
                    addNori.setDisable(true);
                    subNori.setDisable(true);
                    tempRamen.get(tempRamen.size() - 1).setNori(false);
                    tempRamen.get(tempRamen.size() - 1).setExtra_nori(0);
                    ExtraNori.setText("0");
                    Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
                }
            }
        });

        
        ToggleGroup groupchashu = new ToggleGroup();
        RadioButton chashuYes = (RadioButton) RamenPnl.lookup("#chashuYes");
        chashuYes.setToggleGroup(groupchashu);
        chashuYes.setUserData("Yes");
        RadioButton chashuNo = (RadioButton) RamenPnl.lookup("#chashuNo");
        chashuNo.setToggleGroup(groupchashu);
        chashuNo.setUserData("No");
        if (!Menu.isChashu()){
            chashuYes.setDisable(true);
            chashuNo.setDisable(true);
        }
        groupchashu.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (groupchashu.getSelectedToggle() != null) {
                if (groupchashu.getSelectedToggle().getUserData().equals("Yes")) {
                    addChashu.setDisable(false);      //根据选择来判断是否需要禁用相关button
                    subChashu.setDisable(false);
                    tempRamen.get(tempRamen.size() - 1).setChashu(true);
                } else {
                    addChashu.setDisable(true);
                    subChashu.setDisable(true);
                    tempRamen.get(tempRamen.size() - 1).setChashu(false);
                    tempRamen.get(tempRamen.size() - 1).setExtra_chashu(0);
                    ExtraChashu.setText("0");
                    Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
                }
            }
        });

        
        ToggleGroup groupBoiledEgg = new ToggleGroup();
        RadioButton BoiledEggYes = (RadioButton) RamenPnl.lookup("#BoiledEggYes");
        BoiledEggYes.setToggleGroup(groupBoiledEgg);
        BoiledEggYes.setUserData("Yes");
        RadioButton BoiledEggNo = (RadioButton) RamenPnl.lookup("#BoiledEggNo");
        BoiledEggNo.setToggleGroup(groupBoiledEgg);
        BoiledEggNo.setUserData("No");
        if (!Menu.isBoiled_egg()){
            BoiledEggYes.setDisable(true);
            BoiledEggNo.setDisable(true);
        }
        groupBoiledEgg.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (groupBoiledEgg.getSelectedToggle() != null) {
                if (groupBoiledEgg.getSelectedToggle().getUserData().equals("Yes")) {
                    addBoiledEgg.setDisable(false);      
                    subBoiledEgg.setDisable(false);
                    tempRamen.get(tempRamen.size() - 1).setBoiled_egg(true);
                } else {
                    addBoiledEgg.setDisable(true);
                    subBoiledEgg.setDisable(true);
                    tempRamen.get(tempRamen.size() - 1).setBoiled_egg(false);
                    tempRamen.get(tempRamen.size() - 1).setExtra_boiled_egg(0);
                    ExtraBoiledEgg.setText("0");
                    Amount.setText(tempRamen.get(tempRamen.size() - 1).calcRamenAmount() + "");
                }
            }
        });

        
        ToggleGroup groupSpiciness = new ToggleGroup();
        RadioButton[] rSpiciness = new RadioButton[6];
        for (int i=0;i<6;i++) {
            rSpiciness[i] = (RadioButton) RamenPnl.lookup("#Spic"+i);
            rSpiciness[i].setToggleGroup(groupSpiciness);
            rSpiciness[i].setUserData(""+i);
        }
        groupSpiciness.selectedToggleProperty().addListener((changed, oldVal, newVal) -> {
            if (groupSpiciness.getSelectedToggle() != null) {
                tempRamen.get(tempRamen.size() - 1).setSpiciness(Integer.parseInt(
                        groupSpiciness.getSelectedToggle().getUserData().toString()));
            }
        });

        Button addCart = (Button) RamenPnl.lookup("#addcart");
        addCart.setOnAction(actionEvent -> {
            customer.getDraft().getRamenList().add(tempRamen.get(tempRamen.size() - 1));
            //System.out.println(tempRamen.get(tempRamen.size()-1));
            customer.getDraft().setOrderAmount(customer.getDraft().getOrderAmount()
                    + tempRamen.get(tempRamen.size() - 1).calcRamenAmount());
            tempRamen.add(new Ramen());
            rSpiciness[0].setSelected(true);    //reset all
            BoiledEggNo.setSelected(true);
            chashuNo.setSelected(true);
            NoriNo.setSelected(true);
            OnionNo.setSelected(true);
            Tonkotsu.setSelected(true);
            NoodleSoft.setSelected(true);
            BambooShoots.setText("0");
            Amount.setText(Menu.getFixed_price() + "");
        });
    }
}
