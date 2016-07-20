package FrontAccess.View;

import FrontAccess.Controller.FrontEndController;

import java.util.ArrayList;

/**
 * Created by patrickmcgrath on 7/13/16.
 */
public interface IView {

    /**
     * Initialize the first instance of the view
     */
    void initialize();

    /**
     * Sets the controller for this view, allowing the controller to handle the action events
     */
    void setController(FrontEndController controller);

    ArrayList<String> getUserPass();

    void setNextWindow(String nextWindow);

    void setBrowseData(ArrayList<String> data);

    ArrayList<String> getOrgData();
}
