package FrontAccess.View;

import FrontAccess.Controller.FrontEndController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * View Class that creates the front page for the front end application.
 */
public class FrontPage extends JFrame implements IView {
    private JTextField usernameText = new JTextField(20);
    private JPasswordField passwordText = new JPasswordField(20);

    private JPanel currentFrame;
    private FrontEndController controller;

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

    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
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
        return items;
    }

    private JPanel setBrowsePage() {
        JPanel panel = new JPanel(new GridLayout(0, 1));


        return panel;
    }

    private JPanel setAddDataPage() {
        JPanel panel = new JPanel(new GridLayout(0, 1));


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
        }
        this.add(currentFrame);
        this.revalidate();
        this.repaint();
    }

    private JPanel setMainPage() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JButton browse = new JButton("Browse Data");
        JButton addData = new JButton("Add Data");

        browse.setActionCommand("BROWSE");
        browse.addActionListener(controller);
        addData.setActionCommand("ADDDATA");
        addData.addActionListener(controller);

        panel.add(browse);
        panel.add(addData);

        return panel;
    }
}

