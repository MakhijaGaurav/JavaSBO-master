package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.pages.constants.ScreenSize;
import sample.pages.Connectivity;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root;
        Scene scene;
        root = FXMLLoader.load(getClass().getResource("pages\\fxml\\pageKeeper.fxml"));
        System.out.println("Loaded pageKeeper.fxml");
        primaryStage.setTitle("SBO");
        System.out.println(ScreenSize.MAX_SCREEN_WIDTH);
        scene=new Scene(root,ScreenSize.MAX_SCREEN_WIDTH*0.6,ScreenSize.MAX_SCREEN_HEIGHT*0.91);
        //scene.getStylesheets().add(getClass().getResource("pages//css//applicationStyles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception
    {
        Connectivity con = new Connectivity();
        con.connect();
        con.create();
        launch(args);
    }
}
