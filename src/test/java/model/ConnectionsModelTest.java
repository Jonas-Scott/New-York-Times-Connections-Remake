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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    }
}