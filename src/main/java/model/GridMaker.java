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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class that creates generates a list of Tile objects
 * for a game of Connections
 */
public class GridMaker {

    /** Map of easy mode categories and words */
    private static TreeMap<String, String[]> easyModeMap;

    /** Map of medium mode categories and words */
    private static TreeMap<String, String[]> mediumModeMap;

    /** Map of hard mode categories and words */
    private static TreeMap<String, String[]> hardModeMap;

    /** Map of extreme mode categories and words */
    private static TreeMap<String, String[]> extremeModeMap;

    /**
     * Makes an easy mode board of Connections
     * @return 4x4 array of Tiles
     */
    public static ArrayList<ArrayList<Tile>> makeEasyModeBoard() {
        easyModeMap = new TreeMap<>();

        easyModeMap.put("____ Hall", new String[]{"Roberts", "Larison", "Vedder", "Swartz"});
        easyModeMap.put("Downtown Houses", new String[]{"Duck", "Tank", "Garage", "Bodega"});
        easyModeMap.put("Places to Eat", new String[]{"Bostwick", "Flyson", "Bison", "Commons"});
        easyModeMap.put("Outdoor Sports Facilities", new String[]{"Emmet", "Graham", "Depew", "Becker"});

        return makeBoard(easyModeMap);
    }

    /**
     * Makes a medium mode board of Connections
     * @return 4x4 array of Tiles
     */
    public static ArrayList<ArrayList<Tile>> makeMediumModeBoard() {
       mediumModeMap = new TreeMap<>();

        mediumModeMap.put("Tennis Terms", new String[]{"Love", "Ace", "Deuce", "Fault"});
        mediumModeMap.put("Water____", new String[]{"Melon", "Color", "Way", "Fall"});
        mediumModeMap.put("Words with Colors in them", new String[]{"Brownie", "Bred", "Blueberry", "Whiteboard"});
        mediumModeMap.put("Letter Homophones", new String[]{"Why", "See", "Are", "Ex"});

        return makeBoard(mediumModeMap);
    }

    /**
     * Makes a hard mode board of Connections
     * @return 4x4 array of Tiles
     */
    public static ArrayList<ArrayList<Tile>> makeHardModeBoard() {
        hardModeMap = new TreeMap<>();

        hardModeMap.put("Legendary Athletes Last Names", new String[]{"Woods", "Ruth", "Bolt", "Phelps"});
        hardModeMap.put("Things in Nature", new String[]{"Forest", "River", "Mountain", "Desert"});
        hardModeMap.put("Palindromes", new String[]{"Racecar", "Deed", "Kayak", "Noon"});
        hardModeMap.put("Star____", new String[]{"Ship", "Fish", "Light", "Wars"});

        return makeBoard(hardModeMap);
    }

    /**
     * Makes an extreme mode board of Connections
     * @return 4x4 array of Tiles
     */
    public static ArrayList<ArrayList<Tile>> makeExtremeModeBoard() {
        extremeModeMap = new TreeMap<>();

        extremeModeMap.put("Musicals", new String[]{"Cats", "Hamilton", "Wicked", "Chicago"});
        extremeModeMap.put("Slang to Call Someone Cool", new String[]{"Dog", "Beast", "Animal", "Him"});
        extremeModeMap.put("Wizard of Oz Characters", new String[]{"Witch", "Lion", "Scarecrow", "Wizard"});
        extremeModeMap.put("ACC Team Names", new String[]{"Tiger", "Irish", "Orange", "Hurricane"});

        return makeBoard(extremeModeMap);
    }



    private static ArrayList<ArrayList<Tile>> makeBoard(TreeMap<String, String[]> mapOfWords) {

        ArrayList<ArrayList<Tile>> listOfTiles = new ArrayList<>();

        int currIndex = 0;

        for(Map.Entry<String, String[]> entry : mapOfWords.entrySet()){
            listOfTiles.add(new ArrayList<Tile>());
            for(String word : entry.getValue()) {
                listOfTiles.get(currIndex).add(new Tile(word, entry.getKey(), currIndex+1));
                //System.out.println(currIndex);
            }
            currIndex ++;
        }


        return listOfTiles;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Tile>> testList = GridMaker.makeEasyModeBoard();
        for(ArrayList<Tile> list : testList) {
            for (Tile tile : list) {
                System.out.print(tile.getWord() + " ");
            }
            System.out.println();
        }
    }

}