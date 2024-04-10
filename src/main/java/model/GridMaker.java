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
 * Class: GridMaker
 *
 * Description:
 *
 * ****************************************
 */
package model;

/**
 * Class that creates generates a list of Tile objects
 * for a game of Connections
 */
public class GridMaker {
    /**
     * Makes an easy mode board of Connections
     * @return 4x4 array of Tiles
     */
    public static Tile[][] makeEasyModeBoard(){
        Tile[][] easyModeBoard = {
                {new Tile("Roberts", "____ Hall"), new Tile("Bison", "Places to eat"),
                        new Tile("Depew", "Outdoor Sports Facilities"),
                        new Tile("Becker", "Outdoor Sports Facilities")},
                {new Tile("Duck", "Downtown Houses"), new Tile("Larison", "____ Hall"),
                        new Tile("Garage", "Downtown Houses"),
                        new Tile("Bostwick", "Places to eat")},
                {new Tile("Bodega", "Downtown Houses"), new Tile("Commons", "Places to eat"),
                        new Tile("Swartz", "____ Hall"),
                        new Tile("Graham", "Outdoor Sports Facilities")},
                {new Tile("Becker", "Outdoor Sports Facilities"), new Tile("Tank", "Downtown Houses"),
                        new Tile("Flyson", "Places to eat"),
                        new Tile("Vedder", "____ Hall")}
        };
        return easyModeBoard;
    }

    /**
     * Makes a medium mode board of Connections
     * @return 4x4 array of Tiles
     */
    public static Tile[][] makeMediumModeBoard() {
        Tile[][] placeHolder = {{new Tile("Place", "Holder")}};
        return placeHolder;
    }

    /**
     * Makes a hard mode board of Connections
     * @return 4x4 array of Tiles
     */
    public static Tile[][] makeHardModeBoard() {
        Tile[][] placeHolder = {{new Tile("Place", "Holder")}};
        return placeHolder;
    }

    /**
     * Makes an extreme mode board of Connections
     * @return 4x4 array of Tiles
     */
    public static Tile[][] makeExtremeModeBoard() {
        Tile[][] placeHolder = {{new Tile("Place", "Holder")}};
        return placeHolder;
    }

    public static void main(String[] args) {
        Tile[][] test = GridMaker.makeEasyModeBoard();

        for(Tile[] row: test){
            for ( Tile word: row){
                System.out.print(word.getWord() + " ");
            }
            System.out.println();
        }

    }
}