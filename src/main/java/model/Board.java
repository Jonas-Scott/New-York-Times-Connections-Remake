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
    ArrayList<ArrayList<Tile>> words;

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

    /**
     * Selects a tile on the board
     * @param row
     * @param col
     */
    public void select(int row, int col) {
        selected.add(this.words.get(row).get(col));
        this.words.get(row).get(col).select();
    }

    /**
     * Check if selected tiles are in correct category
     * @return if tiles are correct
     */
    public boolean checkSelected(){
        // see if categories all match
        String choosenCategory = this.selected.get(0).getCategory();
        for (int i = 1; i < this.selected.size(); i++){
            if(this.selected.get(i).getCategory() != choosenCategory) {
                return false;
            }
        }
        return true;
    }
}