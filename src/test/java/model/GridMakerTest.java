package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridMakerTest {

    @Test
    /**
     * @author Mikey M, Owen R
     */
    void makeEasyModeBoard() {
        ArrayList<Tile> easyBoard = GridMaker.makeEasyModeBoard();
        assertNotNull(easyBoard);
        assertEquals(16, easyBoard.size());
    }

    @Test
    /**
     * @author Mikey M, Owen R
     */
    void makeMediumModeBoard() {
        ArrayList<Tile> mediumBoard = GridMaker.makeMediumModeBoard();
        assertNotNull(mediumBoard);
        assertEquals(16, mediumBoard.size());
        }


    @Test
    /**
     * @author Mikey M, Owen R
     */
    void makeHardModeBoard() {
        ArrayList<Tile> hardBoard = GridMaker.makeHardModeBoard();
        assertNotNull(hardBoard);
        assertEquals(16, hardBoard.size());

        }


    @Test
    /**
     * @author Mikey M, Owen R
     */
    void makeExtremeModeBoard() {
        ArrayList<Tile> extremeBoard = GridMaker.makeExtremeModeBoard();
        assertNotNull(extremeBoard);
        assertEquals(16, extremeBoard.size());
    }

    @Test
    /**
     * @author Mikey M, Owen R
     */
    void makeHollywoodBoard(){
        ArrayList<Tile> hollywoodBoard = GridMaker.makeHollywoodBoard();
        assertNotNull(hollywoodBoard);
        assertEquals(16, hollywoodBoard.size());
    }
}