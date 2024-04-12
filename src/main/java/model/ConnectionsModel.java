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
 * Package: model
 * Class: ConnectionsModel
 *
 * Description:
 *
 * ****************************************
 */
package model;

import java.util.ArrayList;

/**
 * Class that models playing Connections
 */
public class ConnectionsModel {

    /**
     * How many categories are left
     */
    private int remainingCategories;

    /**
     * Connections game board
     */
    private Board board;


    /**
     * Kind of like a state-check
     * Determines weather or not we are in game
     * Will probably need a getter
     */
    private boolean inGame;



    /**
     * Tracks how many guesses we have.
     */
    private int guesses;


    /**
     * Shouldn't have more than 4 guesses but we can change it if we need to
     */
    private final int MAX_GUESSES = 4;

    /**
     * ConnectionsModel constructor, initializes variables
     */
    public ConnectionsModel() {
        guesses = 0;
        inGame = false;
        remainingCategories = 4;

    }

    /**
     * Choose level to play
     */
    public void chooseLevel(Level level){
        // make board with level
        board = new Board(level);
        inGame = true;
    }

    /**
     * Check if selected tiles are a category
     */
    public void guess() {
        // Only guess if 4 tiles selected
        if(board.getNumSelected() == 4) {
            // Add guess only if wrong, reset if lose
            if (board.checkSelected()) {
                guesses++;
                if (guesses == MAX_GUESSES) {
                    reset();
                }
            }
            // Decrease remaining categories, reset if win
            else {
                remainingCategories--;
                if (remainingCategories == 0) {
                    reset();
                }
            }
        }
    }

    /**
     * Resets model to not be playing game
     */
    private void reset(){
        // Reset all variables
        inGame = false;
        guesses = 0;
        remainingCategories = 4;
    }

}
