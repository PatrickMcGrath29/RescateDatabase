package FrontAccess.Controller;

import FrontAccess.Model.IModel;
import FrontAccess.View.FrontPage;
import FrontAccess.View.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Controller Class with all of the logic to manage the Views
 */
public class FrontEndController implements IController, ActionListener {

    private Connection conn = null;
    private IModel model;
    private IView view;

    public FrontEndController(IModel model) {
        this.model = model;
        this.setConnectionSource();
        this.setView();
        this.view.setController(this);
    }

    @Override
    public void run() {

    }

    private void setConnectionSource() {
        try {
            this.conn = EstablishConnection.getConnection();
            System.out.println("Connection Established.");
        } catch (SQLException e) {
            System.out.println("Connection could not be established.");
        }
    }

    @Override
    public void setView() {
        this.view = new FrontPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

        }

    }
}
