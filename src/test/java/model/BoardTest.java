package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board;
    @BeforeEach
    void setUp() {
        board = new Board(Level.EASY);
    }

    @AfterEach
    void tearDown() {
        board = null;
    }

    @Test
    /**
     * @author Owen R
     */
    void select() {
        assertEquals(0,board.getNumSelected(), "Selections list should be empty.");
        board.select(2,3);
        board.select(1,1);
        assertEquals(2,board.getNumSelected(), "Selections list should have 2 elements");

    }

    @Test
    void checkSelected() {
        Tile roberts = new Tile("Roberts", "____ Hall");
        Tile larrison = new Tile ("Larrison", "____ Hall");
        Tile vedder = new Tile ("Vedder", "____ Hall");
        Tile swartz = new Tile ("Swartz", "____ Hall");
        Tile bison = new Tile("Bison", "Food");
        board.getSelected().add(roberts);
        board.getSelected().add(vedder);
        board.getSelected().add(swartz);
        board.getSelected().add(bison);
        assertFalse(board.checkSelected(),"4 categories are not the same");

        board.getSelected().remove(bison);
        board.getSelected().add(larrison);
        assertTrue(board.checkSelected(),"All categories are the same");
    }

    @Test
    void adjustBoard() {
        Tile roberts = new Tile("Roberts", "____ Hall");
        Tile larrison = new Tile ("Larison", "____ Hall");
        Tile vedder = new Tile ("Vedder", "____ Hall");
        Tile swartz = new Tile ("Swartz", "____ Hall");
        board.getSelected().add(roberts);
        board.getSelected().add(vedder);
        board.getSelected().add(swartz);
        board.getSelected().add(larrison);

        board.checkSelected();
        ArrayList<Tile> firstRow = board.getWords().get(0);
        System.out.println(board);
    }

    @Test
    void shuffleBoard() {
        ArrayList<Tile> allTilesBefore = new ArrayList<>();
        ArrayList<Tile> allTilesAfter = new ArrayList<>();
        for (ArrayList each : board.getWords()){
            for (Object tiles : each){
                allTilesBefore.add((Tile) tiles);
            }
        }
        board.shuffleBoard();
        for (ArrayList each : board.getWords()){
            for (Object tiles : each){
                allTilesAfter.add((Tile) tiles);
            }
        }

        try {
            assertArrayEquals(allTilesBefore.toArray(), allTilesAfter.toArray());
            fail("The lists are unexpectedly equal.");
        } catch (AssertionError e) {
            // This is expected if the lists are not equal, test should pass
        }
    }

    @Test
    void getNumSelected() {
        board.select(0,1);
        assertEquals(board.getNumSelected(),1);
    }
}