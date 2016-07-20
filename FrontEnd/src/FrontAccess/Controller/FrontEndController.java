package FrontAccess.Controller;

import FrontAccess.Model.IModel;
import FrontAccess.View.FrontPage;
import FrontAccess.View.IView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Controller Class with all of the logic to manage the Views
 */
public class FrontEndController implements ActionListener {

    private Connection conn = null;
    private IModel model;
    private IView view;

    public FrontEndController(IModel model) {
        this.model = model;
        this.setConnectionSource();
        this.setView();
        this.view.setController(this);
        this.view.initialize();
    }

    private void setConnectionSource() {
        try {
            this.conn = EstablishConnection.getConnection();
            System.out.println("Connection Established.");
        } catch (SQLException e) {
            System.out.println("Connection could not be established.");
            e.printStackTrace();
        }
    }

    private void setView() {
        this.view = new FrontPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "LOGIN":
                if (this.model.verifyLogin(this.view.getUserPass())) {
                    this.view.setNextWindow("MAIN");
                } else {
                    JOptionPane pane = new JOptionPane("Invalid Login");
                    pane.setVisible(true);
                }
                break;
            case "BROWSE":
                this.view.setBrowseData(this.model.getBrowseData());
                this.view.setNextWindow("BROWSE");
                break;
            case "ADDDATA":
                this.view.setNextWindow("ADDDATA");
                break;
            case "SUBMIT":
                this.model.addData(this.view.getOrgData());
                break;
            case "BACK":
                this.view.setNextWindow("MAIN");
                break;
            case "LOGOUT":
                this.view.setNextWindow("LOGIN");
                break;
            default:
                throw new IllegalArgumentException("Unknown Action Command!");
        }

    }
}
