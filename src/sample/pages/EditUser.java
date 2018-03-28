package sample.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class EditUser{
    @FXML
    StackPane myRoot;

    public Node getRoot() {
        return myRoot;
    }

    @FXML ListView listNameView;//creating ListView to add buttons
    Connectivity object = new Connectivity();//object to get ArrayList from viewName() in Connectivity class



    /*************INITIALIZING COMPONENTS********************/
    public void initialize(){
        object.connect();//connecting to database
        ArrayList<String> printNameList = new ArrayList<>();
        ObservableList nameList;
        listNameView.setOrientation(Orientation.VERTICAL);
        printNameList = object.viewName();//getting returned ArrayList from Connectivity class viewName();
        int countOfButtons = printNameList.size();
        Button[]nameButton = new Button[countOfButtons];//creating ButtonArray for Names
        for(int i=0;i<countOfButtons;i++)
        {
            String ButtonText = printNameList.get(i);//getting text of Button
            System.out.println(ButtonText);
            nameButton[i] = new Button(ButtonText);//Assigning Button
            nameButton[i].setOnMouseClicked(event -> {//******ADDING LISTENER*******
                if(event.getClickCount()==2)
                    //*********************YOU HAVE TO OPEN FORM HERE******************

                    System.out.println("You selected" +ButtonText);
            });
        }//end of for loop
        nameList = FXCollections.observableArrayList(nameButton);//adding Buttons to the Obeservable List
        listNameView.setItems(nameList);//adding buttons from Obervable list into List View


    }


}
