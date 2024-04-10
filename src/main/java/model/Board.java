/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano
 *
 * Name: Casey King
 * Section: 1:00
 * Date: 4/10/24
 * Time: 1:45 PM
 *
 * Project: csci205_final_project
 * Package: model
 * Class: Board
 *
 * Description:
 *
 * ****************************************
 */
package model;

import java.util.ArrayList;

/**
 * Board of words for Connections
 */
public class Board {

    /**
     * 4x4 array of tiles containing words to be guessed
     */
    Tile[][] words;

    /**
     * Array of selected words
     */
    ArrayList<Tile> selected;

    /**
     * Initialize board according to level
     * @param level difficulty of
     */
    public Board(Level level){
        switch (level) {
            case EASY: {
                this.words = GridMaker.makeEasyModeBoard();
                break;
            }
            case MEDIUM: {
                this.words =  GridMaker.makeMediumModeBoard();
                break;
            }
            case HARD: {
                this.words =  GridMaker.makeHardModeBoard();
                break;
            }
            case EXTREME: {
                this.words =  GridMaker.makeExtremeModeBoard();
                break;
            }
        }
        selected = new ArrayList<>();
    }
}