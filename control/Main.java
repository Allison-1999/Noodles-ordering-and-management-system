package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

/**
 *  Class Name: Main.java
 *  Intro: A control class to initialize Stage and load LoginView.fxml file
 * @author Group 105, EBU6304
 * @version 5.0
 */

public class Main extends Application {
    private double x, y;
    private static Stage primaryStage = new Stage();
    private static Customer customer = new Customer(1); // set "1" as the default restaurant
    private static Business business = new Business(1);

    /**
     * Method Name: setPrimaryStage()
     * Intro: setter of static variable primaryStage
     * @param primaryStage new primaryStage
     */
    public static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }

    /**
     * Method Name: getPrimaryStage()
     * Intro: getter of primaryStage
     * @return Stage type
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Method Name: getCustomer()
     * Intro: getter of customer
     * @return Customer type
     */
    public static Customer getCustomer(){
        return customer;
    }

    /**
     * Method Name: setCustomer()
     * Intro: setter of customer
     * @param customer Customer type
     */
    public static void setCustomer(Customer customer){
        Main.customer = customer;
    }

    /**
     * Method Name: getBusiness()
     * Intro: getter of business
     * @return Business type
     */
    public static Business getBusiness(){
        return business;
    }

    /**
     * Method Name: start()
     * Intro: required method when usng JavaFx library
     * @param stage stage variable
     * @throws Exception thwo exception when error occurs
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../boundary/LoginView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });
        primaryStage.show();
    }

    /**
     * Method Name: main()
     * Intro: main method of the program
     * @param args typed-in arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method Name: stop()
     * Intro: run when window is closed
     * @throws IOException throw exception when error occurs
     */
    @Override
    public void stop() throws IOException {
        customer.saveOrderList();
        if (customer.getUser() != null){
            customer.saveUser();
            customer.logoutUser();
        }
    }
}
