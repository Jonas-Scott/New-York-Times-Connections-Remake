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

public class ConnectionsModel {


    /**
     * Array of all possible levels to chose from
     * Can be easy, medium, hard
     */
    private ArrayList<String> levels;


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
    private final int maxGuesses = 4;

    /**
     *
     */
    public void chooseLevel(){

    }


    public void enterGame(){

    }


    private void reset(){

    }

}
