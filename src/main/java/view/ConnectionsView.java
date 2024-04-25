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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.ConnectionsModel;
import model.Tile;

import java.util.ArrayList;
import java.util.Stack;

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
    public Button btnEasy, btnMedium, btnHard, btnExtreme;

    public ArrayList<StackPane> listOfSelectableWords;
    private Button checkSelectedButton;

    public ArrayList<StackPane> listOfCategoriesGuessed;


    /**
     * Constructor for ConnectionsView class
     *
     * @author - Jonas Scott
     */
    public ConnectionsView(ConnectionsModel theModel) {
        this.theModel = theModel;

        initSceneGraph();
        initStyling();

        gamePlayRoot = new GridPane();
        listOfCategoriesGuessed = new ArrayList<>();

    }

    /**
     * Init method to initialize all objects in the scene graph
     *
     * @author - Jonas Scott
     */
    private void initSceneGraph() {
        this.homeScreenRoot = new VBox();
        this.homeScreenRoot.setAlignment(Pos.CENTER);
        Text title = new Text("Welcome to Connections \n Select your Difficulty");
        title.setFont(Font.font("verdana", FontWeight.BOLD, 50));
        title.setTextAlignment(TextAlignment.CENTER);

        this.homeScreenRoot.getChildren().add(title);
        btnEasy = new Button("Easy");
        btnEasy.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnMedium = new Button("Medium");
        btnMedium.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnHard = new Button("Hard");
        btnHard.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnExtreme = new Button("Extreme");
        btnExtreme.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        this.homeScreenRoot.getChildren().addAll(btnEasy, btnMedium, btnHard, btnExtreme);

    }

    // This might be completely unnecessary we could maybe delete it since we are styling in a CSS file anyway
    private void initStyling() {
    }

    /**
     * Getter for the root of the Home Screen
     */
    public VBox getHomeScreenRoot() {
        return homeScreenRoot;
    }

    public Parent getGamePlayRoot() {
        return gamePlayRoot;
    }

    public ArrayList<StackPane> getListOfSelectableWords() {
        return listOfSelectableWords;
    }

    public void initGamePlayRoot() {

        listOfSelectableWords = new ArrayList<>();
        int yPos = 0;
        for(int i = 0; i < theModel.getBoard().getWords().size(); i++){
            Rectangle rect = new Rectangle(100,60);
            Text text = new Text(this.theModel.getBoard().getWords().get(i).getWord());
            text.setTextAlignment(TextAlignment.CENTER);
            StackPane newWordTile = new StackPane(rect, text);
            this.gamePlayRoot.add(newWordTile, i%4, yPos/4);
            listOfSelectableWords.add(newWordTile);
            yPos++;
        }
        checkSelectedButton = new Button("Submit");
        checkSelectedButton.setOnAction(e -> {
            int result = theModel.guess();
            if (result == 2) {
                reLayoutGamePlayRoot();
                theModel.getBoard().clearSelected();
            }
            else if (result == 0) {
                // call a method to lose one of the dots at the bottom
                // using theModel.userFeedback
            }
            else if (result == 1){
                // this means that we are 1 away
                // call a method that briefly puts up a "one away" sign
            }
            else if (result == 3){
                // game is over
                // call a method so that the screen shows the finalized answer screen
                // then gives the option to go to the original screen
            }
        });
        this.gamePlayRoot.add(checkSelectedButton, 2, 5, 2,1);

        gamePlayRoot.setPadding(new Insets(10));
        gamePlayRoot.setHgap(10);
        gamePlayRoot.setVgap(10);

    }

    public void reLayoutGamePlayRoot() {
        this.gamePlayRoot.getChildren().clear();

        for(int i = 0; i < listOfCategoriesGuessed.size(); i++) {
            StackPane catLbl = listOfCategoriesGuessed.get(i);
            gamePlayRoot.add(catLbl, 2, i);
        }
        String category = theModel.getBoard().getSelected().get(0).getCategory() + " ";
        String words = theModel.getBoard().getSelected().toString();
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
                catRect.setFill(Color.LIGHTBLUE);
                break;
            }
            case (4): {
                catRect.setFill(Color.PURPLE);
                break;
            }
        }
        Text catAndWords = new Text(category + words);
        catAndWords.setTextAlignment(TextAlignment.CENTER);
        StackPane catLbl = new StackPane(catRect, catAndWords);
        listOfCategoriesGuessed.add(catLbl);
        gamePlayRoot.add(catLbl, 2, listOfCategoriesGuessed.size() - 1);

        ArrayList<StackPane> newList = new ArrayList<>();

        for(StackPane wordTile : listOfSelectableWords) {
            Text text = (Text) wordTile.getChildren().get(1);
            String word = text.getText();
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
    }

    public boolean checkIfSelected(String word) {
        for(Tile tile : this.theModel.getBoard().getSelected()) {
            if (tile.getWord().equals(word)) {
                return true;
            }
        }
        return false;
    }
}