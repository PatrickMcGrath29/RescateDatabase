package FrontAccess.Model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Model interface, to be implemented by each model class.
 */
public interface IModel {

    boolean verifyLogin(ArrayList<String> userAndPass);

}
