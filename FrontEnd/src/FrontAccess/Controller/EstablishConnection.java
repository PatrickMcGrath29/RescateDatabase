package FrontAccess.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class to create a connection to the SQL server
 */
public class EstablishConnection {


    public static Connection getConnection() throws SQLException {
        String serverName = "cs3200db.crhtlnps61ag.us-east-1.rds.amazonaws.com";
        int portNumber = 3307;
        String dbName = "rescate_orgs";
        String dbuserName = "PatrickMcGrath29";
        String dbpassword = "zilbyrox";

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", dbuserName);
        connectionProps.put("password", dbpassword);
        conn = DriverManager.getConnection("jdbc:mysql://" + serverName
                + ":" + portNumber + "/"
                + dbName, connectionProps);
        return conn;
    }

}
