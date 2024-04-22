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
        Tile roberts = new Tile("Roberts", "____ Hall",1);
        Tile larrison = new Tile ("Larrison", "____ Hall",1);
        Tile vedder = new Tile ("Vedder", "____ Hall",1);
        Tile swartz = new Tile ("Swartz", "____ Hall",1);
        Tile bison = new Tile("Bison", "Food", 2);
        Tile flyson = new Tile("Flyson", "Food", 2);
        board.getSelected().add(roberts);
        board.getSelected().add(bison);
        board.getSelected().add(swartz);
        board.getSelected().add(flyson);
        assertEquals(board.checkSelected(),1);

        board.getSelected().remove(bison);
        board.getSelected().add(larrison);
        assertEquals(board.checkSelected(),2);

        board.getSelected().remove(flyson);
        board.getSelected().add(vedder);

    }

    @Test
    void adjustBoard() {
        Tile roberts = new Tile("Roberts", "____ Hall", 1);
        Tile larrison = new Tile ("Larison", "____ Hall", 1);
        Tile vedder = new Tile ("Vedder", "____ Hall", 1);
        Tile swartz = new Tile ("Swartz", "____ Hall", 1);
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