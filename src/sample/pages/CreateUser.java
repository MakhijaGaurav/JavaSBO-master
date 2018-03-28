package sample.pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import sample.pages.constants.BasicController;


public class CreateUser implements BasicController {
    @FXML
    StackPane myRoot;

    public Node getRoot() {
        return myRoot;
    }

    //************PERSONAL DETAILS IDS*************/
    @FXML TextField nameID = new TextField();
    @FXML TextField dobID = new TextField();
    @FXML TextField mailID = new TextField();
    @FXML TextField frameID = new TextField();
    @FXML TextField glassesID = new TextField();
    @FXML TextArea addressID = new TextArea();
    @FXML TextArea detailsID = new TextArea();

    //***************optical RIGHT DETAILS ID************************
    @FXML TextField RIGHTSPHID = new TextField();
    @FXML TextField RIGHTCYLID = new TextField();
    @FXML TextField RIGHTAXISID = new TextField();
    @FXML TextField RIGHTADDID = new TextField();
    @FXML TextField RIGHTPDID = new TextField();

    //********************optical LEFT DETAILS ID*****************************
    @FXML TextField LEFTSPHID = new TextField();
    @FXML TextField LEFTCYLID = new TextField();
    @FXML TextField LEFTTAXISID = new TextField();
    @FXML TextField LEFTADDID = new TextField();
    @FXML TextField LEFTPDID = new TextField();

    //****************right contact lens ID*****************************
    @FXML TextField RIGHTCONTACTSPHID = new TextField();
    @FXML TextField RIGHTCONTACTCYLID = new TextField();
    @FXML TextField RIGHTCONTACTAXISID = new TextField();

    //**************************left contact lens ID**************************
    @FXML TextField LEFTCONTACTSPHID = new TextField();
    @FXML TextField LEFTCONTACTCYLID = new TextField();
    @FXML TextField LEFTCONTACTAXISID = new TextField();



    //******************GETTING VALUES FROM TEXTFIELD on FORM *****************
    public void getValues(ActionEvent event ){
        //******************personal details********************
        String Name = nameID.getText();
        String DOB = dobID.getText();
        String email = mailID.getText();
        String frame = frameID.getText();
        String glasses = glassesID.getText();
        String address = addressID.getText();
        String details = detailsID.getText();

        //*********************right eye details*********************
        String RIGHTSPH = RIGHTSPHID.getText();
        String RIGHTCYL = RIGHTCYLID.getText();
        String RIGHTAXIS = RIGHTAXISID.getText();
        String RIGHTADD = RIGHTADDID.getText();
        String RIGHTPD  = RIGHTPDID.getText();

        //***********************left eye details***********************
        String LEFTSPH = LEFTSPHID.getText();
        String LEFTCYL = LEFTCYLID.getText();
        String LEFTAXIS = LEFTTAXISID.getText();
        String LEFTADD = LEFTADDID.getText();
        String LEFTPD = LEFTPDID.getText();

        //*******************right contact lens*************************
        String RIGHTCONTACTSPH  = RIGHTCONTACTSPHID.getText();
        String RIGHTCONTACTCYL = RIGHTCONTACTCYLID.getText();
        String RIGHTCONTACTAXIS = RIGHTCONTACTAXISID.getText();

        //**********************left contact lens*******************
        String LEFTCONTACTSPH = LEFTCONTACTSPHID.getText();
        String LEFTCONTACTCYL = LEFTCONTACTCYLID.getText();
        String LEFTCONTACTAXIS = LEFTCONTACTAXISID.getText();

        System.out.println(Name+" "+DOB+" "+email+" "+frame+" "+glasses+" "+address+" "+details);

        /////////*************CREATING OBJECT OF CONNECTVITY CLASS AND PASSING VALUES BY CALLING INSERT
        Connectivity obj = new Connectivity();
        obj.insert(Name,DOB,address,email,frame,glasses,details,RIGHTSPH,RIGHTCYL,RIGHTAXIS,RIGHTADD,RIGHTPD,LEFTSPH,LEFTCYL,LEFTAXIS,LEFTADD,LEFTPD,RIGHTCONTACTSPH,RIGHTCONTACTCYL,RIGHTCONTACTAXIS,LEFTCONTACTSPH,LEFTCONTACTCYL,LEFTCONTACTAXIS);
    }
}

