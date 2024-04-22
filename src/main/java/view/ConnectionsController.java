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
import javafx.stage.Stage;
import model.ConnectionsModel;
import model.Level;

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
        Scene gameBoardScene = new Scene(theView.getGamePlayRoot());

        // Set the scene in the primary stage
        primaryStage.setScene(gameBoardScene);
        primaryStage.setTitle("Connections");
        primaryStage.show();
    }

}