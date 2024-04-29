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
        board.select(2);
        board.select(1);
        assertEquals(2,board.getNumSelected(), "Selections list should have 2 elements");

    }

    @Test
    /**
     * @author Owen R
     */
    void checkSelected() {
        Tile roberts = new Tile("Roberts", "____ Hall",1);
        Tile larrison = new Tile ("Larrison", "____ Hall",1);
        Tile vedder = new Tile ("Vedder", "____ Hall",1);
        Tile swartz = new Tile ("Swartz", "____ Hall",1);
        Tile bison = new Tile("Bison", "Food",2);
        Tile bostwick = new Tile("Bostwick", "Food", 2);

        board.selected.add(roberts);
        board.selected.add(vedder);
        board.selected.add(bostwick);
        board.selected.add(bison);

        assertEquals(board.checkSelected(),0,"Not enough categories are the same");

        board.selected.remove(bostwick);
        board.selected.add(swartz);
        assertEquals(board.checkSelected(),1,"Not enough categories are the same");

        board.selected.remove(bison);
        board.selected.add(larrison);
        assertEquals(board.checkSelected(),2,"All categories are the same");
    }



    @Test
    /**
     * @author Owen R
     */
    void getNumSelected() {
        board.select(1);
        assertEquals(board.getNumSelected(),1);
    }
}