package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridMakerTest {

    @Test
    void makeEasyModeBoard() {
        ArrayList<Tile> easyBoard = GridMaker.makeEasyModeBoard();
        assertNotNull(easyBoard);
        assertEquals(16, easyBoard.size());
//        for (ArrayList<Tile> row : easyBoard) {
//            assertEquals(4, row.size());
//        }
    }

    @Test
    void makeMediumModeBoard() {
        ArrayList<Tile> mediumBoard = GridMaker.makeMediumModeBoard();
        assertNotNull(mediumBoard);
        assertEquals(16, mediumBoard.size());
//        for (ArrayList<Tile> row : mediumBoard) {
//            assertEquals(4, row.size());
        }


    @Test
    void makeHardModeBoard() {
        ArrayList<Tile> hardBoard = GridMaker.makeHardModeBoard();
        assertNotNull(hardBoard);
        assertEquals(16, hardBoard.size());

        }


    @Test
    void makeExtremeModeBoard() {
        ArrayList<Tile> extremeBoard = GridMaker.makeExtremeModeBoard();
        assertNotNull(extremeBoard);
        assertEquals(16, extremeBoard.size());
//        for (ArrayList<Tile> row : extremeBoard) {
//            assertEquals(4, row.size());
//        }
    }

    @Test
    void makeHollywoodBoard(){
        ArrayList<Tile> hollywoodBoard = GridMaker.makeHollywoodBoard();
        assertNotNull(hollywoodBoard);
        assertEquals(16, hollywoodBoard.size());
    }
}