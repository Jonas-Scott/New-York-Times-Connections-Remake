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
     * Tile constructor, initializes attributes
     * @param word word tile carries
     * @param category category word is in
     * @author Casey King
     */
    public Tile(String word, String category){
        this.word = word;
        this.category = category;
        this.selected = false;
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
}