package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridMakerTest {

    @Test
    void makeEasyModeBoard() {
        ArrayList<ArrayList<Tile>> easyBoard = GridMaker.makeEasyModeBoard();
        assertNotNull(easyBoard);
        assertEquals(4, easyBoard.size());
        for (ArrayList<Tile> row : easyBoard) {
            assertEquals(4, row.size());
        }
    }

    @Test
    void makeMediumModeBoard() {
        ArrayList<ArrayList<Tile>> mediumBoard = GridMaker.makeMediumModeBoard();
        assertNotNull(mediumBoard);
        assertEquals(4, mediumBoard.size());
        for (ArrayList<Tile> row : mediumBoard) {
            assertEquals(4, row.size());
        }
    }

    @Test
    void makeHardModeBoard() {
        ArrayList<ArrayList<Tile>> hardBoard = GridMaker.makeHardModeBoard();
        assertNotNull(hardBoard);
        assertEquals(4, hardBoard.size());
        for (ArrayList<Tile> row : hardBoard) {
            assertEquals(4, row.size());
        }
    }

    @Test
    void makeExtremeModeBoard() {
        ArrayList<ArrayList<Tile>> extremeBoard = GridMaker.makeExtremeModeBoard();
        assertNotNull(extremeBoard);
        assertEquals(4, extremeBoard.size());
        for (ArrayList<Tile> row : extremeBoard) {
            assertEquals(4, row.size());
        }
    }
}