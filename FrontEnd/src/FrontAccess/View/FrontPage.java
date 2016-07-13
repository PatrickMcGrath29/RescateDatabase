package FrontAccess.View;

import FrontAccess.Controller.IController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * View Class that creates the front page for the front end application.
 */
public class FrontPage extends JFrame implements IView {

    private JPanel currentFrame;
    private IController controller;

    public FrontPage() {
        this.setVisible(true);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("Rescate Database Manager");
    }


    @Override
    public void setController(IController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize() {
        this.currentFrame = this.setFrontPage();
        this.add(currentFrame);
        this.pack();
    }

    private JPanel setFrontPage() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JTextField usernameText = new JTextField(15);
        JPasswordField passwordText = new JPasswordField(15);
        JButton login = new JButton("Login");

        panel.add(username);
        panel.add(usernameText);
        panel.add(password);
        panel.add(passwordText);
        panel.add(login);

        login.setActionCommand("LOGIN");
        login.addActionListener();

        return panel;
    }

}

