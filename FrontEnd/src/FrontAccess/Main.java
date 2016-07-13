package FrontAccess;

import FrontAccess.View.FrontPage;
import FrontAccess.View.IView;

/**
 * Class containing the main method to start the program.
 */
public class Main {

    public static void main(String[] args) {
        IView view = new FrontPage();
        view.initialize();
    }

}
