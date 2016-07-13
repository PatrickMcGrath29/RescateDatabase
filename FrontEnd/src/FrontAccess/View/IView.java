package FrontAccess.View;

import FrontAccess.Controller.IController;

import javax.swing.*;

/**
 * Created by patrickmcgrath on 7/13/16.
 */
public interface IView {

    /**
     * Initialize the first instance of the view
     */
    void initialize();

    /**
     *
     */
    void setController(IController controller);
}
