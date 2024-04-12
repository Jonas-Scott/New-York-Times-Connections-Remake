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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

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
        Tile tile = this.words.get(row).get(col);
        if(selected.contains(tile)){
            selected.remove(tile);
        }
        else {
            selected.add(tile);
        }
        tile.select();
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
        adjustBoard();
        return true;
    }

    /**
     * After a correct guess adjust the board
     */
    public void adjustBoard() {

        ArrayList<ArrayList<Tile>> newList = new ArrayList<>();
        newList.add(new ArrayList<>());
        int currIndex = 0;

        for(ArrayList<Tile> list: words) {
            for(Tile tile : selected) {
                if(list.contains(tile)){
                   list.remove(tile);
                }
                else {
                    newList.get(currIndex).add(tile);
                    if(newList.size() == 4) {
                        currIndex++;
                        newList.add(new ArrayList<>());
                    }
                }
            }
        }
    }


    /**
     * Empties out the 4x4 into one array and then uses the collections. Shuffle method.
     * This lets us put it back into a new 4x4
     * then we replace the words attribute with the new 4x4
     * @author Owen R
     */
    public void shuffleBoard(){
        ArrayList<Tile> allTiles = new ArrayList<>();
        ArrayList<Tile> firstRow = new ArrayList<>();
        ArrayList<Tile>  secondRow = new ArrayList<>();
        ArrayList<Tile> thirdRow = new ArrayList<>();
        ArrayList<Tile> fourthRow = new ArrayList<>();
        for (ArrayList each : words){
            for (Object tiles : each){
                allTiles.add((Tile) tiles);
            }
        }
        Collections.shuffle(allTiles);

        for (int i = 0; i == 3; i++){
            firstRow.add(allTiles.get(i));
        }
        for (int i = 4; i == 7; i++){
            firstRow.add(allTiles.get(i));
        }
        for (int i = 8; i == 11; i++){
            firstRow.add(allTiles.get(i));
        }
        for (int i = 12; i == 15; i++){
            firstRow.add(allTiles.get(i));
        }

        words.clear();
        words.add(firstRow);
        words.add(secondRow);
        words.add(thirdRow);
        words.add(fourthRow);


    }
    /**
     * Give number of tiles selected
     * @return size of selected list
     */
    public int getNumSelected(){
        return selected.size();
    }
}