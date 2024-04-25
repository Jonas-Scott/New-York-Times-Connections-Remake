/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Owen Reilly
 * Section: 2pm
 * Date: 4/17/24
 * Time: 1:35 PM
 *
 * Project: csci205_final_project
 * Package: view
 * Class: ConnectionsController
 *
 * Description:
 *
 * ****************************************
 */
package view;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.ConnectionsModel;
import model.Level;
import model.Tile;

import java.util.ArrayList;

public class ConnectionsController {
    private ConnectionsModel theModel;
    private ConnectionsView theView;
    private Stage primaryStage;


    /**
     * Our controller
     *
     * @param theModel
     * @param theView
     *
     * @author Owen R
     */
    public ConnectionsController(ConnectionsModel theModel, ConnectionsView theView, Stage primaryStage){
        this.theModel = theModel;
        this.theView = theView;
        this.primaryStage = primaryStage;

        initLevelSelector();
    }

    private void initBindings(){
        //theModel.chooseLevel(Level.EASY).bind(theView.getHomeScreenRoot().getChildren());
    }

    /**
     * Binds all the buttons in the view to a specific action
     * each action chooses a level that we have in the model.
     *
     * @author Owen R
     */
    private void initLevelSelector() {
        this.theView.btnEasy.setOnAction(e -> switchToGameBoard(Level.EASY));
        this.theView.btnMedium.setOnAction(e -> switchToGameBoard(Level.MEDIUM));
        this.theView.btnHard.setOnAction(e -> switchToGameBoard(Level.HARD));
        this.theView.btnExtreme.setOnAction(e -> switchToGameBoard(Level.EXTREME));
    }

    private void switchToGameBoard(Level level) {
        theModel.chooseLevel(level);

        // Create the game board scene
        theView.initGamePlayRoot();
        Scene gameBoardScene = new Scene(theView.getGamePlayRoot());
        gameBoardScene.getStylesheets().add(
                getClass().getResource("/GameScreen.css")
                        .toExternalForm());

        initGameBoardBindings();

        // Set the scene in the primary stage
        primaryStage.setScene(gameBoardScene);
        primaryStage.setTitle("Connections");
        primaryStage.show();
    }

    private void initGameBoardBindings() {

        for(int i = 0; i < theView.getListOfSelectableWords().size(); i++){
                final int row = i;
                Tile tile = theModel.getBoard().getWords().get(i);
                StackPane wordTile = theView.getListOfSelectableWords().get(i);
                Rectangle rect = (Rectangle) wordTile.getChildren().get(0);
                rect.fillProperty().bind(tile.currentColorProperty());
                wordTile.onMouseClickedProperty().setValue(event -> theModel.getBoard().select(row));
        }
    }

}