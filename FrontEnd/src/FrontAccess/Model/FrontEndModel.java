package FrontAccess.Model;

import FrontAccess.Controller.EstablishConnection;

import java.sql.*;
import java.util.ArrayList;

/**
 * Model class with the SQL logic in it, processing requests.
 */
public class FrontEndModel implements IModel {


    @Override
    public boolean verifyLogin(ArrayList<String> userAndPass) {
        try {
            Connection conn = EstablishConnection.getConnection();

            String sqlQuery = "SELECT count(DISTINCT user_name) FROM user WHERE user_name = ? AND " +
                    "user_pass = ?";
            PreparedStatement prep = conn.prepareStatement(sqlQuery);
            prep.setString(1, userAndPass.get(0));
            prep.setString(2, userAndPass.get(1));

            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not verify Username / Password. Database Error");
        }

        return false;
    }
}
