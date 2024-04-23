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

    public ArrayList<ArrayList<StackPane>> listOfSelectableWords;


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

    public void selectTile() {
        for (ArrayList<Tile> row : theModel.getBoard().getWords()) {
            for (Tile tile : row) {
                Text tileText = new Text(tile.getWord());
                // Change text color if tile is selected
                if (tile.isSelected()) {
                    tileText.setFill(Color.GRAY); // Set text color to gray
                } else {
                    tileText.setFill(Color.WHITE); // Set text color to white
                }
                gamePlayRoot.getChildren().add(tileText);
            }
        }
    }

    public Parent getGamePlayRoot() {
        return gamePlayRoot;
    }

    public ArrayList<ArrayList<StackPane>> getListOfSelectableWords() {
        return listOfSelectableWords;
    }

    public void initGamePlayRoot() {

        listOfSelectableWords = new ArrayList<>();

        for(int i = 0; i < theModel.getBoard().getWords().size(); i++){
            this.listOfSelectableWords.add(new ArrayList<>());
            for(int j = 0; j < theModel.getBoard().getWords().get(i).size(); j++) {
                Rectangle rect = new Rectangle(100,100);
                Text text = new Text(this.theModel.getBoard().getWords().get(i).get(j).getWord());
                text.setTextAlignment(TextAlignment.CENTER);
                StackPane newWordTile = new StackPane(rect, text);
                this.gamePlayRoot.add(newWordTile, i, j);
                listOfSelectableWords.get(i).add(newWordTile);
            }
        }
        gamePlayRoot.setPadding(new Insets(10));
        gamePlayRoot.setHgap(10);
        gamePlayRoot.setVgap(10);

    }
}