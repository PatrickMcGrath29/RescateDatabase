package FrontAccess.Model;

import FrontAccess.Controller.EstablishConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Model class with the SQL logic in it, processing requests.
 */
public class FrontEndModel implements IModel {
    private Connection conn;

    public FrontEndModel() {
        try {
            conn = EstablishConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean verifyLogin(ArrayList<String> userAndPass) {
        try {
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

    public ArrayList<String> getBrowseData() {
        ArrayList<String> data = new ArrayList<String>();

        ArrayList<String> components = new ArrayList<String>(Arrays.asList("Name: ", "Country: ",
                "Website: ", "Donated to date: " , "Area of focus: ", "Contact Info: ", "Call for" +
                        " Grants: "));

        for (String s : components) {
            components.set(components.indexOf(s), String.format("%" + 17 + "s", components.get
                    (components.indexOf(s))));
        }

        try {
            String sqlQuery = "SELECT * FROM organization";
            Statement stmt = conn.prepareStatement(sqlQuery);
            ResultSet rset = stmt.executeQuery(sqlQuery);

            while (rset.next()) {
                String addItem = "";

                addItem += components.get(0) + rset.getString(1) + "\n";
                addItem += components.get(1) + rset.getString(3) + "\n";
                addItem += components.get(2) + rset.getString(4) + "\n";
                addItem += components.get(3) + rset.getString(5) + "\n";
                addItem += components.get(4) + rset.getString(6) + "\n";
                addItem += components.get(5) + rset.getString(7) + "\n";
                boolean temp = rset.getBoolean(8);
                if (temp) {
                    addItem += components.get(6) + "Yes";
                } else {
                    addItem += components.get(6) + "No";
                }
                data.add(addItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void addData(ArrayList<String> data) {
        String sqlInsert = "INSERT INTO organization (org_name, org_country, org_website, " +
                "area_of_focus, contact_information, call_for_grants) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prep = conn.prepareStatement(sqlInsert);
            prep.setString(1, data.get(0));
            prep.setString(2, data.get(1));
            prep.setString(3, data.get(2));
            prep.setString(4, data.get(3));
            prep.setString(5, data.get(4));
            if (data.get(5).equals("Yes")) {
                prep.setBoolean(6, true);
            } else {
                prep.setBoolean(6, false);
            }
            prep.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error on Insert");
            e.printStackTrace();
        }

    }
}
