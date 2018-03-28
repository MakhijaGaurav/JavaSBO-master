/*@Author Dhananjay
* this will add all the pages to pagination
* so that we can easily change them on required events which
* also will be handled in this class*/

package sample.pages;

import  javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.util.Callback;
import sample.pages.constants.PageConstants;
public class PageKeeper implements PageConstants {
    /*Required objects of pageKeeper.fxml*/
    @FXML
    Pagination pageManager;

    /*Required object of fxml controllers*/
    Dashboard dashboard;

    /*Supporting Objects*/
    FXMLLoader dashboardFxmlLoader;


    /*this method will initialize other fxml files cotrollers and add them to pageManager*/
    @FXML
    protected void initialize() {
        System.out.println("Start of PageKeeper");
        try {
        /*initilize all the pages*/
            initPages();

        /*Calls and sets the reuired page to be shown*/
            pageManager.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer pageIndex) {
                    try {
                        return pageSelector(pageIndex);
                    } catch (Exception e) {
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            System.out.println("Inside initiakize in pagekeeper" + e);
        }
        System.out.println("End of PageKeeper");
    }

    /*This will init all the pages so that they can be added*/
    private void initPages() {
        try {
            dashboardFxmlLoader = new FXMLLoader();
            dashboardFxmlLoader.setLocation(getClass().getResource("fxml//dashboard.fxml"));
            dashboardFxmlLoader.load();
            dashboard = (Dashboard) dashboardFxmlLoader.getController();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Node pageSelector(int pageIndex) {
        if (pageIndex == PageConstants.DASHBOARD_PAGE)
            return dashboard.getRoot();
        return dashboard.getRoot();

    }
}
