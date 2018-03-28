/*@Author Ashutosh
* this will show a page which will contain a page manager and dashboard options*/

package sample.pages;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javafx.util.Duration;
import sample.pages.constants.BasicController;
import sample.pages.constants.PageConstants;
import sample.pages.constants.PageContantsForDashboard;


public class Dashboard implements PageConstants,BasicController{

    /*Required objects of pageKeeper.fxml*/
    @FXML
    StackPane dashboardRoot;/*the main pane which containes all the other pans*/

        @FXML
        BorderPane defaultHolder;/*the default page*/

            @FXML
            AnchorPane defaultHolderTop;/*this is used in borderpane top to hold logo and the button which will open dashboard */

        @FXML
        AnchorPane dashboardHolder;/*pane which conatines dashboard*/

            @FXML
            AnchorPane dashBoardControlsHolder;/*the original dashboard which will be shown*/

        @FXML
        AnchorPane pageHolder;/*pane which containas Pagination*/

            @FXML
            Pagination pageManager;/*pagination object inisde pageHolder*/

    /*Required object of fxml controllers*/
    CreateUser form;
    EditUser existing;
    Backup backup;
    Exit exit;

    /*Supporting Objects*/
    TranslateTransition translateTransitionForDashboard;

    FXMLLoader formLoader, existingLoader, backupLoader, exitLoader;

    /*this method will initialize other fxml files cotrollers and add them to pageManager*/
    @FXML protected void initialize() {
        try {

        /*initilize all the pages*/
            initControllers();
            /*Init top and add label and button of Borderpane*/
            initDefaultHolder();
            /*init the dashboard*/
            initDashboardHolder();
            /*inint pages in pagination*/
            initPageHolder();
        }catch(Exception e){
            System.out.println("Inside initiakize in pagekeeper"+e);
        }
        System.out.println("End of PageKeeper");
    }

    /*This will init all the pages so that they can be added*/
    private void initControllers(){
        try{
            formLoader=new FXMLLoader();
            formLoader.setLocation(getClass().getResource("fxml//createUser.fxml"));
            formLoader.load();
            form=(CreateUser) formLoader.getController();

            existingLoader=new FXMLLoader();
            existingLoader.setLocation(getClass().getResource("fxml//editForm.fxml"));
            existingLoader.load();
            existing=(EditUser) existingLoader.getController();

            backupLoader=new FXMLLoader();
            backupLoader.setLocation(getClass().getResource("fxml//backup.fxml"));
            backupLoader.load();
            backup=(Backup) backupLoader.getController();

            exitLoader=new FXMLLoader();
            exitLoader.setLocation(getClass().getResource("fxml//exit.fxml"));
            exitLoader.load();
            exit=(Exit) exitLoader.getController();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Iniside Dashboard.java initnocntrollers exception");
        }
    }
    private void initDefaultHolder(){
        Button show_dashboard;
        Label defaultHolderTitle;
        FontAwesomeIconView show_dashboard_Icon;

        show_dashboard=new Button();
        defaultHolderTitle=new Label("");
        show_dashboard_Icon= new FontAwesomeIconView(FontAwesomeIcon.REORDER);

        defaultHolderTitle.setPrefSize(500,100);
        defaultHolderTitle.setFont(Font.font(27));
        show_dashboard.setGraphic(show_dashboard_Icon);
        //show_dashboard_Icon.setOpacity(0.1);
        show_dashboard_Icon.getStyleClass().add("show_icon");
        show_dashboard.getStyleClass().add("show_dashboard");

        show_dashboard.setPrefSize(50,50);
        show_dashboard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dashboardHolder.setVisible(true);
                animateIn();
            }
        });

        AnchorPane.setTopAnchor(show_dashboard, new Double("10"));
        AnchorPane.setLeftAnchor(show_dashboard,new Double("10"));
        AnchorPane.setTopAnchor(defaultHolderTitle,new Double("10"));
        AnchorPane.setLeftAnchor(defaultHolderTitle,new Double("340"));
        defaultHolderTop.getChildren().addAll(show_dashboard,defaultHolderTitle);
        //System.out.println("*********************************************"+scrollableRecent.getRoot());
       //defaultHolder.setBottom(scrollableRecent.getRoot());
        //defaultHolder.setCenter(yourIp.getRoot("192.767867"));
    }

    private void initDashboardHolder(){
        JFXButton hide_dashBoard;
        JFXButton showCreatePage;
        JFXButton showEditPage;
        JFXButton showBackupPage;
        JFXButton showExitPage;
        FontAwesomeIconView hide_dashboard_icon;

        hide_dashBoard=new JFXButton();
        showCreatePage=new JFXButton("Create User");
        showEditPage=new JFXButton("Edit Form");
        showBackupPage=new JFXButton("Backup");
        showExitPage=new JFXButton("Exit");

        hide_dashboard_icon = new FontAwesomeIconView(FontAwesomeIcon.REMOVE);
        hide_dashboard_icon.getStyleClass().add("hide_icon");
        hide_dashBoard.getStyleClass().add("hide_dashboard");
        hide_dashBoard.setGraphic(hide_dashboard_icon);
        hide_dashBoard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                animateOut();
            }
        });
        showCreatePage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dashboardHolder.setVisible(false);
                pageHolder.setVisible(true);
                pageManager.setCurrentPageIndex(PageContantsForDashboard.CREATE_PAGE);
            }
        });
        showEditPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dashboardHolder.setVisible(false);
                pageHolder.setVisible(true);
                pageManager.setCurrentPageIndex(PageContantsForDashboard.EXISTING_PAGE);
            }
        });
        showBackupPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dashboardHolder.setVisible(false);
                pageHolder.setVisible(true);
                pageManager.setCurrentPageIndex(PageContantsForDashboard.BACKUP_PAGE);
            }
        });
        showExitPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dashboardHolder.setVisible(false);
                pageHolder.setVisible(true);
                pageManager.setCurrentPageIndex(PageContantsForDashboard.EXIT_PAGE);
            }
        });

        AnchorPane.setTopAnchor(hide_dashBoard,new Double("0"));
        AnchorPane.setLeftAnchor(hide_dashBoard,new Double("252"));
        AnchorPane.setTopAnchor(showCreatePage,new Double("100"));
        AnchorPane.setLeftAnchor(showCreatePage,new Double("50"));
        AnchorPane.setTopAnchor(showEditPage,new Double("200"));
        AnchorPane.setLeftAnchor(showEditPage,new Double("50"));
        AnchorPane.setTopAnchor(showBackupPage,new Double("300"));
        AnchorPane.setLeftAnchor(showBackupPage,new Double("50"));
        AnchorPane.setTopAnchor(showExitPage,new Double("400"));
        AnchorPane.setLeftAnchor(showExitPage,new Double("50"));

        dashBoardControlsHolder.getChildren().addAll(hide_dashBoard,showCreatePage,showEditPage,showBackupPage,showExitPage);

        dashboardHolder.setVisible(false);
    }

    private void initPageHolder(){
         /*Calls and sets the reuired page to be shown*/
        JFXButton hideCurrentPage;
        hideCurrentPage=new JFXButton();

        FontAwesomeIconView hide_dashboard_icon = new FontAwesomeIconView(FontAwesomeIcon.REMOVE);
        hide_dashboard_icon.getStyleClass().add("hide_icon");
        hideCurrentPage.getStyleClass().add("btn-raised");
        hideCurrentPage.setGraphic(hide_dashboard_icon);
        hideCurrentPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pageHolder.setVisible(false);
            }
        });
        pageManager.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                try{
                    System.out.println("Showing page at index 0");
                    return pageSelector(pageIndex);}
                catch (Exception e){
                }
                return null;
            }
        });
        AnchorPane.setLeftAnchor(hideCurrentPage,new Double("770"));
        AnchorPane.setTopAnchor(hideCurrentPage,new Double("0"));

        pageHolder.getChildren().add(hideCurrentPage);
        pageHolder.setVisible(false);
    }

    private Node pageSelector(int pageIndex) {

        if (pageIndex==PageContantsForDashboard.CREATE_PAGE){
            System.out.println(form);
            return form.getRoot();
        }
        else if(pageIndex==PageContantsForDashboard.EXISTING_PAGE){
           return existing.getRoot();
        }
        else if(pageIndex==PageContantsForDashboard.BACKUP_PAGE){
            return backup.getRoot();
        }
        else if(pageIndex==PageContantsForDashboard.EXIT_PAGE){
            return exit.getRoot();
        }
        return new Button("Dhananjay");
    }


//    public void setPageKeeper(PageKeeper pk){
//        /*Not required here*/
//    }

    public Node getRoot(){
        refreshPage();
        return dashboardRoot;
    }

    public void refreshPage(){

    }

    public void animateIn(){
        translateTransitionForDashboard=new TranslateTransition(Duration.millis(600),dashBoardControlsHolder);
        translateTransitionForDashboard.setFromX(-600.0);
        translateTransitionForDashboard.setToX(0.0);
        translateTransitionForDashboard.play();
    }

    public void animateOut() {
        translateTransitionForDashboard=new TranslateTransition(Duration.millis(600),dashBoardControlsHolder);
        translateTransitionForDashboard.setFromX(0.0);
        translateTransitionForDashboard.setToX(-600.0);
        translateTransitionForDashboard.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dashboardHolder.setVisible(false);
            }
        });
        translateTransitionForDashboard.play();
    }

}
