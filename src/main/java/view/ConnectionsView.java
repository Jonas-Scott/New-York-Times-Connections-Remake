/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano
 *
 * Name: Casey King
 * Section: 1:00
 * Date: 4/10/24
 * Time: 1:47 PM
 *
 * Project: csci205_final_project
 * Package: view
 * Class: ConnectionsView
 *
 * Description:
 *
 * ****************************************
 */
package view;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import model.ConnectionsModel;
import model.Level;
import model.Tile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ConnectionsView {

    /**
     * Model object for the ConnectionsModel Class
     */
    private ConnectionsModel theModel;

    /**
     * Root object for the Connection game screen
     */
    private GridPane gamePlayRoot;

    /**
     * Root object for the home screen
     */
    private VBox homeScreenRoot;

    /**
     * All of our buttons
     */
    public Button btnEasy, btnMedium, btnHard, btnExtreme, btnHollywood;

    public ArrayList<StackPane> listOfSelectableWords;
    private Button checkSelectedButton;

    public ArrayList<StackPane> listOfCategoriesGuessed;
    private HBox ballDisplay;
    private Label notificationLabel; // The notification label
    private Button shuffleButton;


    /**
     * Constructor for ConnectionsView class
     *
     * @author - Jonas Scott
     */
    public ConnectionsView(ConnectionsModel theModel) {
        this.theModel = theModel;

        initSceneGraph();
        gamePlayRoot = new GridPane();
        gamePlayRoot.getStyleClass().add("grid");
        listOfCategoriesGuessed = new ArrayList<>();

    }

    /**
     * Init method to initialize all objects in the scene graph
     * adding the title as well as the buttons for selecting difficulty
     *
     * @author - Jonas Scott
     */
    private void initSceneGraph() {
        this.homeScreenRoot = new VBox();
        Text title = new Text("Welcome to Connections \n Select your Difficulty");
        title.getStyleClass().add("title");

        this.homeScreenRoot.getChildren().add(title);
        addButtons();

    }




    private void addButtons() {
        btnEasy = new Button("Easy");

        btnMedium = new Button("Medium");

        btnHard = new Button("Hard");

        btnExtreme = new Button("Extreme");

        btnHollywood = new Button("Hollywood");



        this.homeScreenRoot.getChildren().addAll(btnEasy, btnMedium, btnHard, btnExtreme, btnHollywood);
    }

    /**
     * Getter for the root of the Home Screen
     */
    public VBox getHomeScreenRoot() {
        return homeScreenRoot;
    }

    /**
     * Getter for the gamePlayRoot
     */
    public Parent getGamePlayRoot() {
        return gamePlayRoot;
    }

    /**
     * Get the list of the still selectable words, used after a player gets the category right
     */
    public ArrayList<StackPane> getListOfSelectableWords() {
        return listOfSelectableWords;
    }

    public void initGamePlayRoot() throws FileNotFoundException {

        StackPane newWordTile;
        listOfSelectableWords = new ArrayList<>();
        int yPos = 0;
        for(int i = 0; i < theModel.getBoard().getWords().size(); i++){
            Rectangle rect = new Rectangle(100,60);
            if (this.theModel.getBoard().getLevel() == Level.HOLLYWOOD){
                //System.out.println("Hollywood");
                String imageUrl = this.theModel.getBoard().getWords().get(i).getWord();
                Image image = new Image(imageUrl, true);
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setId(imageUrl);
                imageView.setFitHeight(rect.getHeight());  // Set the ImageView height
                imageView.setFitWidth(rect.getWidth());    // Set the ImageView width
                imageView.setPreserveRatio(true);          // Preserve the aspect ratio

                newWordTile = new StackPane(rect, imageView);
                newWordTile.setAlignment(Pos.CENTER);
            }
            else {
                Text text = new Text(this.theModel.getBoard().getWords().get(i).getWord());
                text.setTextAlignment(TextAlignment.CENTER);
                newWordTile = new StackPane(rect, text);
            }

            this.gamePlayRoot.add(newWordTile, i%4, yPos/4);
            listOfSelectableWords.add(newWordTile);
            yPos++;
        }

        ballDisplay = new HBox(10);
        ballDisplay.setAlignment(Pos.BOTTOM_LEFT);

        addBallCounterToTheBottom(theModel.userFeedback());
        checkSelectedButton = new Button("Submit");
        checkSelectedButton.setOnAction(e -> {
            int result = theModel.guess();

            runTheCommandClick(result);


        });

        shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(e -> {
            shuffleButtons();
        });
        this.gamePlayRoot.add(ballDisplay,0,5);
        GridPane.setColumnSpan(ballDisplay, 2);
        this.gamePlayRoot.add(checkSelectedButton, 2, 5, 2,1);


        gamePlayRoot.add(shuffleButton, 3, 5);

    }

    private void shuffleButtons() {
        gamePlayRoot.getChildren().clear();
        for(int i = 0; i < listOfCategoriesGuessed.size(); i++) {
            StackPane catLbl = listOfCategoriesGuessed.get(i);
            gamePlayRoot.add(catLbl, 0, i);
        }
        Collections.shuffle(listOfSelectableWords);
        int yPos = listOfCategoriesGuessed.size() * 4;
        for(int i = 0; i < listOfSelectableWords.size(); i++){
            gamePlayRoot.add(listOfSelectableWords.get(i), i%4 , yPos/4);
            yPos++;
        }
        gamePlayRoot.add(shuffleButton, 3, 5);
        this.gamePlayRoot.add(ballDisplay,1,5);
        this.gamePlayRoot.add(checkSelectedButton, 2, 5, 2,1);

    }


    private void runTheCommandClick(int result) {
        if (result == 1){
            initNotificationLabel(14);
            messagePopUp("One Away!");
        }
        else if (result == 2) {
            reLayoutGamePlayRoot();
            theModel.getBoard().clearSelected();
            this.gamePlayRoot.add(ballDisplay,1,5);
        }
        else if (result == 3){
            // game is lost
            // make it so the remaining categories are placed as should be
            initLosingScreen();
            initNotificationLabel(30);
            messagePopUp("You lost!");
        }
        else if (result == 4){
            reLayoutGamePlayRoot();
            initNotificationLabel(30);
            messagePopUp("You won");
        }

        addBallCounterToTheBottom(theModel.userFeedback());
    }

    public void reLayoutGamePlayRoot() {
        this.gamePlayRoot.getChildren().clear();

        for(int i = 0; i < listOfCategoriesGuessed.size(); i++) {
            StackPane catLbl = listOfCategoriesGuessed.get(i);
            gamePlayRoot.add(catLbl, 0, i);
        }
        String words;
        String category = theModel.getBoard().getSelected().get(0).getCategory() + " ";
        if (this.theModel.getBoard().getLevel() != Level.HOLLYWOOD) {
            words = theModel.getBoard().getSelected().toString();
        }
        else {
            words = "";
        }
        Rectangle catRect = new Rectangle(440, 60);

        switch (this.theModel.getBoard().getSelected().get(0).getDifficulty()) {
            case (1): {
                catRect.setFill(Color.GREEN);
                break;
            }
            case (2): {
                catRect.setFill(Color.YELLOW);
                break;
            }
            case (3): {
                catRect.setFill(Color.INDIANRED);
                break;
            }
            case (4): {
                catRect.setFill(Color.MEDIUMPURPLE);
                break;
            }
        }
        Text catAndWords = new Text(category + words);
        catAndWords.setTextAlignment(TextAlignment.CENTER);
        StackPane catLbl = new StackPane(catRect, catAndWords);
        listOfCategoriesGuessed.add(catLbl);
//        gamePlayRoot.addRow(listOfCategoriesGuessed.size() - 1 ,catLbl);
//        GridPane.setColumnIndex(catLbl, 0);
//        GridPane.setColumnSpan(catLbl, 4);
        gamePlayRoot.add(catLbl, 0, listOfCategoriesGuessed.size() - 1, 4, 1);
        //GridPane.setColumnSpan(catLbl, 4);

        ArrayList<StackPane> newList = new ArrayList<>();


        for(StackPane wordTile : listOfSelectableWords) {
            String word;
            if (this.theModel.getBoard().getLevel() != Level.HOLLYWOOD){
            Text text = (Text) wordTile.getChildren().get(1);
            word = text.getText();
            }
            else{
                word = wordTile.getChildren().get(1).getId();
            }
            if(!checkIfSelected(word)) {
                newList.add(wordTile);
            }
        }
        int yPos = listOfCategoriesGuessed.size() * 4;
        listOfSelectableWords = newList;
        for(int i = 0; i < listOfSelectableWords.size(); i++){
            gamePlayRoot.add(listOfSelectableWords.get(i), i%4 , yPos/4);
            yPos++;
        }
        this.gamePlayRoot.add(checkSelectedButton, 2, 5, 2,1);
        this.gamePlayRoot.add(shuffleButton, 3,5);
    }


    /**
     * Add the ball counter to the bottom of the grid
     * add the appropriate number of balls for how many guesses are remaining
     * @param count - the number of guesses remaining
     * @author - Owen Reilly
     */
    public void addBallCounterToTheBottom(int count){
        ballDisplay.getChildren().clear();
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            Circle circle = new Circle(10, Color.RED);  // Create a new circle (ball) with radius 10
            ballDisplay.getChildren().add(circle);  // Add the circle to the display box
        }


    }

    public boolean checkIfSelected(String word) {
        for(Tile tile : this.theModel.getBoard().getSelected()) {
            if (tile.getWord().equals(word)) {
                return true;
            }
        }
        return false;
    }



    /**
     * screen that comes up when we lose
     */
    public void initLosingScreen(){

    }


    public void messagePopUp(String message) {
        notificationLabel.setText(message);
        notificationLabel.setVisible(true);
        notificationLabel.setOpacity(0);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), notificationLabel);
        fadeIn.setToValue(1);  // Fade in to fully opaque

        PauseTransition stayVisible = new PauseTransition(Duration.seconds(2));  // Stay visible for 2 seconds

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), notificationLabel);
        fadeOut.setToValue(0);  // Fade out to fully transparent

        SequentialTransition sequence = new SequentialTransition(fadeIn, stayVisible, fadeOut);
        sequence.setOnFinished(event -> notificationLabel.setVisible(false));  // Hide after animation
        sequence.play();
    }
    private void initNotificationLabel(int size) {
        notificationLabel = new Label();
        notificationLabel.getStyleClass().add("notificationText");
        //notificationLabel.setTextFill(Color.BLACK);
        notificationLabel.setFont(Font.font(size));
        //notificationLabel.setStyle("-fx-background-color: lightgrey; -fx-padding: 10;");
        //notificationLabel.setOpacity(0);  // Start fully transparent
        notificationLabel.setVisible(false);  // Start hidden
        this.gamePlayRoot.add(notificationLabel, 1,1);  // Adjust position as needed
    }

}