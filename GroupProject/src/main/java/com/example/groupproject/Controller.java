package com.example.groupproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    public void goTo(String whereTo, Node uiElement) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(whereTo));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) uiElement.getScene().getWindow();
            stage.setMaximized(true);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @FXML
    TextField usernameBox;

    @FXML
    PasswordField passwordBox;

    @FXML
    Text errorMessage;

    String[] usernames = {"Admin", "Tonning", "James", "Manager"};
    String[] passwords = {"Password", "Cheese51", "JamesIsACat", "123"}; // There should probably be some encryption on these, but that's above my pay grade.

    public void logIn(){
        String inputUsername = usernameBox.getText();
        String inputPassword = passwordBox.getText();

        boolean correctLogin = false;

        for (int i = 0; i < usernames.length; i++){
            if (inputUsername.equals(usernames[i]) && inputPassword.equals(passwords[i]))
                correctLogin = true;
        }

        if (correctLogin)
            goToOverview();

        else
            errorMessage.setOpacity(1);

    }

    @FXML
    Text welcomeMessage;

    String currentScene = "";

public void goToOverview() {
    goTo("overview.fxml", errorMessage);
    currentScene = "overview";
}
public void goToInventory(){
    goTo("inventory.fxml", welcomeMessage);
    currentScene = "inventory";
}

public void goToInvoice(){
    goTo("invoice.fxml", welcomeMessage);
    currentScene = "invoice";
}

public void goToRestock(){
    goTo("restock.fxml", welcomeMessage);
    currentScene = "restock";
}

@FXML
Text titleRestock, titleInventory, titleInvoice;

public void backFromInventory(){
    goTo("overview.fxml", titleInventory);
}

public void backFromInvoice(){
    goTo("overview.fxml", titleInvoice);
}

public void backFromRestock(){
    goTo("overview.fxml", titleRestock);
}
}