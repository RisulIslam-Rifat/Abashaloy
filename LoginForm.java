import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LoginForm extends JFrame implements ActionListener {

    

    JLabel usernameLabel, passwordLabel, imageLabe1, loginText;
    JTextField usernameTextField;
    JPasswordField passwordField;
    JCheckBox passwordshow;
	 static String loggedInUsername;
    JButton loginButton, backButton;
	ImageIcon image2;
    private File dataFile;

    public LoginForm() {
       
        this.setTitle("Login Form");
        this.setSize(800, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(254, 255, 229));
        this.setResizable(false);

        
        ImageIcon image = new ImageIcon("Photos/home2.jpg");
		image2 = new ImageIcon("Photos/icon4.gif");

        imageLabe1 = new JLabel();
        imageLabe1.setBounds(0, -10, 800, 500);

        imageLabe1.setIcon(image);
        imageLabe1.setVerticalAlignment(JLabel.TOP);
        imageLabe1.setHorizontalAlignment(JLabel.CENTER);

        loginText = new JLabel("LOGIN");
		loginText.setBounds(380, 129, 289, 91);
		loginText.setBackground(Color.white);
		loginText.setFont(new Font("Cooper Black",Font.BOLD,70));
		 imageLabe1.add(loginText);
		
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(173, 264, 363, 56);
		usernameLabel.setFont(new Font("Cooper Black",Font.PLAIN,30));
        imageLabe1.add(usernameLabel);
        
        
        usernameTextField = new JTextField();
        usernameTextField.setBounds(384, 267, 363, 56);
		usernameTextField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		usernameTextField.setFont(new Font("Cooper Black",Font.PLAIN,30));
        imageLabe1.add(usernameTextField);
        
        passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Cooper Black",Font.PLAIN,30));
        passwordLabel.setBounds(173, 343, 363, 56);
        imageLabe1.add(passwordLabel);
        
        passwordField = new JPasswordField();
		passwordField.setFont(new Font("Cooper Black",Font.PLAIN,30));
		passwordField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        passwordField.setBounds(384, 343, 363, 56);
		passwordField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        imageLabe1.add(passwordField);
		
		
		
        passwordshow = new JCheckBox();
		passwordshow.setText("show password");
		passwordshow.setFont(new Font("Cooper Black",Font.PLAIN,20));
		passwordshow.setBounds(384,410,200,30);
		passwordshow.setFocusable(false);
		passwordshow.addActionListener(this);
		passwordshow.setBackground( new Color(60,156,214));
		imageLabe1.add(passwordshow);
		
		
		
       loginButton = new JButton("Login");
        loginButton.setBounds( 631, 423, 116, 38);
		loginButton.setBackground( new Color(78, 125, 207));
		loginButton.setFocusable(false);
		loginButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this);
        imageLabe1.add(loginButton);
       
       
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
		backButton.setBackground( new Color(78, 125, 207));
		
        backButton.setBounds( 26, 423, 116, 38);
	backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(this);
        imageLabe1.add(backButton);
    this.add(imageLabe1);
    this.setVisible(true);
}

public void actionPerformed(ActionEvent event) {
    if (event.getSource() == loginButton) {
        handleSuccessfulLogin();
    } else if (event.getSource() == backButton) {
        this.dispose();
        new Interface();
    } else if (event.getSource() == passwordshow) {
        if (passwordshow.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('*');
        }
    }
}


public boolean checkLogin(String username, String password) {
    dataFile = new File("User Information/data.txt");
    boolean found = false;

    try {
        Scanner scanner = new Scanner(dataFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String storedUsername = parts[0];
            String storedPassword = parts[1];

            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                found = true;
                break;
            }
        }

        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    return found;
}




public void handleSuccessfulLogin() {
    String username2 = usernameTextField.getText();
    String password = new String(passwordField.getPassword());

    if (checkLogin(username2, password)) {
        JOptionPane.showMessageDialog(null, "Login successful!");
        loggedInUsername = username2;
        dispose();
        new HomePage(loggedInUsername); // Pass the username to HomePage constructor
    } else {
        JOptionPane.showMessageDialog(null, "Incorrect username or password. Please try again.");
        usernameTextField.setText("");
        passwordField.setText("");
    }
}



public static void main(String[] args) {
    new LoginForm();
}

}