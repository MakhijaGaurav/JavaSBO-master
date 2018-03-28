package sample.pages;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Exit {
    @FXML
    AnchorPane myRoot;
    StackPane myStackPane;

    public void setMyRoot(AnchorPane ap) {
        myRoot = ap;
    }

    public void setMyStackPane(StackPane sp) {
        myStackPane = sp;
    }

    public Node getRoot() {
        return myRoot;
    }

}
