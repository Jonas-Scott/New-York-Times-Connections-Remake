/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano
 *
 * Name: Casey King
 * Section: 1:00
 * Date: 4/10/24
 * Time: 1:46
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

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * Tile class, makes up the 16 words in Connections
 * @author Casey King
 */
public class Tile {

    /** Word stored in tile */
    private String word;

    /** Is the tile selected? */
    private SimpleBooleanProperty selected;

    /** Category */
    private String category;

    private Color selectedColor;

    private Color unselectedColor;


    /**
     * This will help us later, as far as determining what our color should be.
     */
    private int difficulty;


    private SimpleObjectProperty<Color> currentColor;


    /**
     * Tile constructor, initializes attributes
     * @param word word tile carries
     * @param category category word is in
     * @author Casey King
     */
    public Tile(String word, String category, int difficulty){
        this.word = word;
        this.category = category;
        this.selected = new SimpleBooleanProperty(false);
        this.difficulty = difficulty;
        this.selectedColor = Color.LAWNGREEN;
        this.unselectedColor = Color.ANTIQUEWHITE;
        this.currentColor = new SimpleObjectProperty<>();
        this.currentColor.set(unselectedColor);
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

    public boolean isSelected() {
        return selected.get();
    }

    public SimpleBooleanProperty selectedProperty() {
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

    public Color getCurrentColor() {
        return currentColor.get();
    }

    public SimpleObjectProperty<Color> currentColorProperty() {
        return currentColor;
    }

    /**
     * Select or unselect tile
     * @author Casey King
     */
    public void select(){
        this.selected.set(!this.isSelected());
        if(this.isSelected()){
            this.currentColor.set(selectedColor);
        }
        else {
            this.currentColor.set(unselectedColor);
        }
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