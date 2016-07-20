package FrontAccess.View;

import FrontAccess.Controller.FrontEndController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * View Class that creates the front page for the front end application.
 */
public class FrontPage extends JFrame implements IView {
    private JTextField usernameText = new JTextField(20);
    private JPasswordField passwordText = new JPasswordField(20);
    private ArrayList<String> browseData;
    private int currentBrowse;
    private JLabel textArea = new JLabel();
    private JPanel currentFrame;
    private FrontEndController controller;
    private JTextField name, country, website, areaOfFocus, contactInfo;
    private JComboBox callForGrants;


    public FrontPage() {
        this.setVisible(true);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("Rescate Database Manager");
    }

    @Override
    public void setController(FrontEndController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize() {
        this.currentFrame = setFrontPage();
        this.add(currentFrame);

    }

    private JPanel setFrontPage() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JButton login = new JButton("Login");

        login.setActionCommand("LOGIN");
        login.addActionListener(controller);

        panel.add(username);
        panel.add(usernameText);
        panel.add(password);
        panel.add(passwordText);
        panel.add(login);

        return panel;
    }


    @Override
    public ArrayList<String> getUserPass() {
        ArrayList<String> items = new ArrayList<String>();
        items.add(this.usernameText.getText());

        StringBuilder password = new StringBuilder();
        for (char c : this.passwordText.getPassword()) {
            password.append(c);
        }
        items.add(password.toString());

        this.usernameText.setText("");
        this.passwordText.setText("");

        return items;
    }

    private JPanel setBrowsePage() {
        JPanel panel = new JPanel(new FlowLayout());
        if (!(this.browseData.size() < 1)) {
            this.textArea.setText(this.browseData.get(0));
        }
        JButton next = new JButton("Next");
        JButton previous = new JButton("Previous");
        JLabel searchLabel = new JLabel("Search:");
        JTextField search = new JTextField(15);
        JButton searchButton = new JButton("Search");

        panel.add(textArea);
        panel.add(previous);
        panel.add(next);
        panel.add(searchLabel);
        panel.add(search);
        panel.add(searchButton);
        return panel;
    }

    private JPanel setAddDataPage() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        this.name = new JTextField(15);
        this.country = new JTextField(15);
        this.website = new JTextField(25);
        this.areaOfFocus = new JTextField(25);
        this.contactInfo = new JTextField(15);
        this.callForGrants = new JComboBox(new ArrayList<String>(Arrays.asList("Yes", "No"))
                .toArray());
        JButton submit = new JButton("Enter Data");
        JButton back = new JButton("Back");

        panel.add(new JLabel("Name:"));
        panel.add(this.name);
        panel.add(new JLabel("Country:"));
        panel.add(this.country);
        panel.add(new JLabel("Website:"));
        panel.add(this.website);
        panel.add(new JLabel("Area of Focus:"));
        panel.add(this.areaOfFocus);
        panel.add(new JLabel("Contact Info:"));
        panel.add(this.contactInfo);
        panel.add(new JLabel("Call For Grants:"));
        panel.add(this.callForGrants);

        submit.setActionCommand("SUBMIT");
        submit.addActionListener(this.controller);
        back.setActionCommand("BACK");
        back.addActionListener(this.controller);

        panel.add(submit);
        panel.add(back);
        return panel;
    }

    @Override
    public void setNextWindow(String nextWindow) {
        this.remove(currentFrame);
        switch (nextWindow) {
            case "MAIN":
                currentFrame = this.setMainPage();
                break;
            case "BROWSE":
                currentFrame = this.setBrowsePage();
                break;
            case "ADDDATA":
                currentFrame = this.setAddDataPage();
                break;
            case "LOGIN":
                currentFrame = this.setFrontPage();
                break;
        }
        this.add(currentFrame);
        this.revalidate();
        this.repaint();
        this.setSize(500, 500);
        this.pack();
    }

    private JPanel setMainPage() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JButton browse = new JButton("          Browse Data          ");
        JButton addData = new JButton("          Add Data          ");
        JButton logout = new JButton("          Logout          ");
        browse.setActionCommand("BROWSE");
        browse.addActionListener(this.controller);
        addData.setActionCommand("ADDDATA");
        addData.addActionListener(this.controller);
        logout.setActionCommand("LOGOUT");
        logout.addActionListener(this.controller);

        panel.add(browse);
        panel.add(addData);
        panel.add(logout);

        return panel;
    }

    @Override
    public ArrayList<String> getOrgData() {
        ArrayList<String> data = new ArrayList<String>();

        data.add(this.name.getText());
        data.add(this.country.getText());
        data.add(this.website.getText());
        data.add(this.areaOfFocus.getText());
        data.add(this.contactInfo.getText());
        data.add(this.callForGrants.getSelectedItem().toString());

        this.name.setText("");
        this.country.setText("");
        this.website.setText("");
        this.areaOfFocus.setText("");
        this.contactInfo.setText("");
        this.callForGrants.setSelectedIndex(0);

        return data;
    }

    public void setBrowseData(ArrayList<String> browseData) {
        this.browseData = browseData;
    }
}

