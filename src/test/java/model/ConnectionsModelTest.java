/* ****************************************
CSCI 205 - Software Engineering and Design
Spring 2024
Instructor: Prof. Lily Romano / Prof. Joshua Stough
Name: Mikey Myro: 1 PM Lecture 3PM Lab Date: 4/15/24
Time: 1:19 PM
Project: csci205_final_project Package: model Class: ConnectionsModelTest
Description:
*
*
*
* 
* 
*
*
*
*
*
*
*
*
*
*
* **************************************** 
*/
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionsModelTest {

    private ConnectionsModel connectionsModel;

    @BeforeEach
    void setUp() {
        connectionsModel = new ConnectionsModel();
        connectionsModel.chooseLevel(Level.EASY);
    }

    @Test
    void chooseLevel() {
        assertTrue(connectionsModel.isInGame());
        assertNotNull(connectionsModel.getBoard());
    }

    @Test
    void guess() {
        connectionsModel.getBoard().select(0, 0);
        connectionsModel.getBoard().select(0, 1);
        connectionsModel.getBoard().select(0, 2);
        connectionsModel.getBoard().select(0, 3);

        // Make a guess
        connectionsModel.guess();

        // Check if remainingCategories has decreased
        assertEquals(3, connectionsModel.getRemainingCategories());

        // Check if the game is still in progress
        assertTrue(connectionsModel.isInGame());
    }

    }
