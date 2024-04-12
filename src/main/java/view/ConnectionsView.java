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

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.ConnectionsModel;

public class ConnectionsView {

    /** Model object for the ConnectionsModel Class */
    private ConnectionsModel theModel;

    /** Root object for the Connection game screen */
    private TilePane gamePlayRoot;

    /** Root object for the home screen */
    private VBox homeScreenRoot;

    /**
     * Constructor for ConnectionsView class
     * @author - Jonas Scott
     */
    public ConnectionsView(ConnectionsModel theModel) {
        this.theModel = theModel;

        initSceneGraph();
        initStyling();

    }

    /**
     * Init method to initialize all objects in the scene graph
     * @author - Jonas Scott
     */
    private void initSceneGraph() {
        this.homeScreenRoot = new VBox();
        this.homeScreenRoot.setAlignment(Pos.CENTER);

        this.homeScreenRoot.getChildren().add(new Text("Welcome to Connections \n Select your Difficulty"));
        this.homeScreenRoot.getChildren().add(new Button("Easy"));
        this.homeScreenRoot.getChildren().add(new Button("Medium"));
        this.homeScreenRoot.getChildren().add(new Button("Hard"));
        this.homeScreenRoot.getChildren().add(new Button("Extreme"));
    }

    // This might be completely unnecessary we could maybe delete it since we are styling in a CSS file anyway
    private void initStyling() {
    }

    /** Getter for the root of the Home Screen */
    public VBox getHomeScreenRoot() {
        return homeScreenRoot;
    }


}