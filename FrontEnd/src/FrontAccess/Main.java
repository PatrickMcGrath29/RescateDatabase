package FrontAccess;

import FrontAccess.Controller.FrontEndController;
import FrontAccess.Model.FrontEndModel;
import FrontAccess.View.FrontPage;
import FrontAccess.View.IView;

/**
 * Class containing the main method to start the program.
 */
public class Main {

    public static void main(String[] args) {
        FrontEndController controller = new FrontEndController(new FrontEndModel());

    }

}
