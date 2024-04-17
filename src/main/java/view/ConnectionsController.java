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


import model.ConnectionsModel;
import model.Level;

public class ConnectionsController {
    private ConnectionsModel theModel;
    private ConnectionsView theView;


    /**
     * Our controller
     *
     * @param theModel
     * @param theView
     *
     * @authoer Owen R
     */
    public ConnectionsController(ConnectionsModel theModel, ConnectionsView theView){
        this.theModel = theModel;
        this.theView = theView;

        initLevelSelector();
    }

    private void initBindings(){
        //theModel.chooseLevel(Level.EASY).bind(theView.getHomeScreenRoot().getChildren());
    }

    /**
     * Binds all the buttons in the view to a specific action
     * each action chooses a level that we have in the model.
     */
    private void initLevelSelector() {
        this.theView.btnEasy.setOnAction(e -> this.theModel.chooseLevel(Level.EASY));
        this.theView.btnMedium.setOnAction(e -> this.theModel.chooseLevel(Level.MEDIUM));
        this.theView.btnHard.setOnAction(e -> this.theModel.chooseLevel(Level.HARD));
        this.theView.btnExtreme.setOnAction(e -> this.theModel.chooseLevel(Level.EXTREME));
    }
}