package view;

import javafx.scene.layout.VBox;
import model.ConnectionsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionsViewTest {

    private ConnectionsView viewTester;

    @BeforeEach
    void setUp() {
        ConnectionsModel testModel = new ConnectionsModel();
        viewTester = new ConnectionsView(testModel);
    }

}