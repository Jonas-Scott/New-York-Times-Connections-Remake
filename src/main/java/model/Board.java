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
import java.util.HashMap;
import java.util.Map;

/**
 * Board of words for Connections
 */
public class Board {

    public ArrayList<ArrayList<Tile>> getWords() {
        return words;
    }

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
     *
     * @param level difficulty of
     */
    public Board(Level level) {
        switch (level) {
            case EASY: {
                this.words = GridMaker.makeEasyModeBoard();
                //System.out.println(this.words);
                break;
            }
            case MEDIUM: {
                this.words = GridMaker.makeMediumModeBoard();
                break;
            }
            case HARD: {
                this.words = GridMaker.makeHardModeBoard();
                break;
            }
            case EXTREME: {
                this.words = GridMaker.makeExtremeModeBoard();
                break;
            }
        }
        //shuffleBoard();
        //System.out.println(this.words);
        selected = new ArrayList<>();
    }

    /**
     * Selects a tile on the board
     *
     * @param row
     * @param col
     */
    public void select(int row, int col) {
        //System.out.println(this.words);
        Tile tile = this.words.get(row).get(col);
        if (selected.contains(tile)) {
            selected.remove(tile);
            tile.select();
        } else if (selected.size() < 4) {
            selected.add(tile);
            tile.select();
        }
    }

    public ArrayList<Tile> getSelected() {
        return selected;
    }

    /**
     * Check if selected tiles are in correct category
     *
     * @return 0 if its incorrect, 1 if there are 3 of the same category, and 2 if there are all 4
     */
    public int checkSelected() {
        // see if categories all match
        Map<Integer, Integer> guessesPer = new HashMap<>(); // Mutable map
        guessesPer.put(1, 0);
        guessesPer.put(2, 0);
        guessesPer.put(3, 0);
        guessesPer.put(4, 0);

        //String choosenCategory = this.selected.get(0).getCategory();
        for (int i = 0; i < 4; i++) {
            guessesPer.put(this.selected.get(i).getDifficulty(), guessesPer.get(this.selected.get(i).getDifficulty()) + 1);
        }

        int keyWithMaxValue = 0;
        Integer maxValue = 0;

        for (int i = 1; i <= 4; i++) {
            int currentCount = guessesPer.get(i);
            if (currentCount > maxValue) {
                maxValue = currentCount;  // Update maxValue to the current highest count
                keyWithMaxValue = i;      // Track the key with the highest count
            }
        }

        // Return based on the max count found
        if (maxValue < 3) {
            return 0;  // Less than three of any category
        } else if (maxValue == 3) {
            return 1;  // Exactly three of one category
        } else {
            adjustBoard();  // Assuming adjustBoard() makes necessary modifications based on this check
            return 2;       // Four of one category
        }
    }


    /**
     * After a correct guess adjust the board
     * Very similar logic to the shuffleBoard except the first row is now fixed.
     */
    public void adjustBoard() {

        ArrayList<ArrayList<Tile>> newList = new ArrayList<>();
        ArrayList<Tile> bigList = new ArrayList<>();
        ArrayList<Tile> firstRow = new ArrayList<>();
        ArrayList<Tile> secondRow = new ArrayList<>();
        ArrayList<Tile> thirdRow = new ArrayList<>();
        ArrayList<Tile> fourthRow = new ArrayList<>();
        for (Tile tile : selected) {
            firstRow.add(tile);
        }


        for (ArrayList<Tile> list : words) {
            for (Tile tile : list) {
                //System.out.println(tile.getWord());
                if (!selected.contains(tile)) {
                    bigList.add(tile);
                }
            }
        }
        Collections.shuffle((bigList));

        for (int i = 4; i <= 7; i++) {
            secondRow.add(bigList.get(i));
        }
        for (int i = 8; i <= 11; i++) {
            thirdRow.add(bigList.get(i));
        }
        for (int i = 12; i <= 15; i++) {
            fourthRow.add(bigList.get(i));
        }

        words.clear();
        words.add(firstRow);
        words.add(secondRow);
        words.add(thirdRow);
        words.add(fourthRow);
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

        for (int i = 0; i <= 3; i++){
            firstRow.add(allTiles.get(i));
        }
        for (int i = 4; i <= 7; i++){
            secondRow.add(allTiles.get(i));
        }
        for (int i = 8; i <= 11; i++){
            thirdRow.add(allTiles.get(i));
        }
        for (int i = 12; i <= 15; i++){
            fourthRow.add(allTiles.get(i));
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
        //System.out.println(selected.size());
        return selected.size();
    }
}