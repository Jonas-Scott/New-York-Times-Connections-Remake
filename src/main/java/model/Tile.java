/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano
 *
 * Name: Casey King
 * Section: 1:00
 * Date: 4/10/24
 * Time: 1:46 PM
 *
 * Project: csci205_final_project
 * Package: model
 * Class: Tile
 *
 * Description:
 *
 * ****************************************
 */
package model;

/**
 * Tile class, makes up the 16 words in Connections
 * @author Casey King
 */
public class Tile {

    /** Word stored in tile */
    private String word;

    /** Is the tile selected? */
    private boolean selected;

    /** Category */
    private String category;


    /**
     * This will help us later, as far as determining what our color should be.
     */
    private int difficulty;

    /**
     * Tile constructor, initializes attributes
     * @param word word tile carries
     * @param category category word is in
     * @author Casey King
     */
    public Tile(String word, String category, int difficulty){
        this.word = word;
        this.category = category;
        this.selected = false;
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * Returns stored word
     * @return
     * @author Casey King
     */
    public String getWord() {
        return word;
    }

    /**
     * Return if tile is selected
     * @return
     * @author Casey King
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Return category of word
     * @return
     * @author Casey King
     */
    public String getCategory() {
        return category;
    }

    /**
     * Select or unselect tile
     * @author Casey King
     */
    public void select(){
        this.selected = !this.selected;
    }

    /**
     * Prints word of Tile
     * @return
     */
    public String toString() {
        return(word);
    }


    public boolean equals(Object obj) {
        return obj.toString().equals( this.toString());
    }
}