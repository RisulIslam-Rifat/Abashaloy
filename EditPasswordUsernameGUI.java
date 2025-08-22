import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import java.awt.event.ActionListener;

public class EditPasswordUsernameGUI extends JFrame {
    private String username;
    private String password;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField retypePasswordField;
    private JButton saveButton;
    private JButton backButton;
    private JCheckBox showPasswordCheckBox;
    private JLabel imageLabel;
     ImageIcon image,image2,image3;

    public EditPasswordUsernameGUI(String initialUsername, String initialPassword) {
        this.username = initialUsername;
        this.password = initialPassword;

        this.setTitle("Edit Profile");
        this.setSize(800, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        image = new ImageIcon("Photos/home9.png");
		image2= new ImageIcon("Photos/icon2.png");
		image3= new ImageIcon("Photos/icon3.png");
        imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, 800, 500);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(82, 59, 238, 55);
		 usernameLabel.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		 
		 
		 
        usernameField = new JTextField(initialUsername);
        usernameField.setBounds(320, 63, 415, 48);
		usernameField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		 usernameField.setBackground(new Color(0,74,173));
		 
		 usernameField.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		 
		 

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(82, 135, 238, 55);
		 passwordLabel.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		 
		 
        passwordField = new JPasswordField(initialPassword);
        passwordField.setBounds(320, 140, 370, 48);
		passwordField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
          passwordField.setFocusable(true);
		
		 passwordField.setBackground(new Color(0,74,173));
		 passwordField.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		 
		 

        JLabel retypePasswordLabel = new JLabel("Re-type Password:");
        retypePasswordLabel.setBounds(82, 223, 238, 30);
		 retypePasswordLabel.setFont(new Font("Cooper Black", Font.PLAIN, 24));
		 
		 
        retypePasswordField = new JPasswordField();
        retypePasswordField.setBounds(320, 217, 415, 48);
		retypePasswordField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
             retypePasswordField.setFocusable(true);
		 retypePasswordField.setBackground(new Color(0,74,173));
		 retypePasswordField.setFont(new Font("Cooper Black", Font.PLAIN, 25));

        showPasswordCheckBox = new JCheckBox();
        showPasswordCheckBox.setBounds(694, 145, 40, 35);
				showPasswordCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));

		 showPasswordCheckBox.setBackground(new Color(0,74,173));
		showPasswordCheckBox.setIcon(image2);
		
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
					showPasswordCheckBox.setIcon(image3);
                    passwordField.setEchoChar((char) 0);
                    retypePasswordField.setEchoChar((char) 0);
                } else {
					showPasswordCheckBox.setIcon(image2);
                    passwordField.setEchoChar('*');
                    retypePasswordField.setEchoChar('*');
                }
            }
        });

        saveButton = new JButton("Save");
        saveButton.setBounds(589, 325, 125, 47);
        saveButton.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.setBackground(new Color(92, 225, 230));
        saveButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });

        backButton = new JButton("Back");
        backButton.setBounds(107, 325, 125, 47);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        backButton.setBackground(new Color(92, 225, 230));
        backButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        imageLabel.add(usernameLabel);
        imageLabel.add(usernameField);
        imageLabel.add(passwordLabel);
        imageLabel.add(passwordField);
        imageLabel.add(retypePasswordLabel);
        imageLabel.add(retypePasswordField);
        imageLabel.add(showPasswordCheckBox);
        imageLabel.add(saveButton);
        imageLabel.add(backButton);

        this.add(imageLabel);

        this.setVisible(true);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private void saveChanges() {
        String newUsername = usernameField.getText();
        if (!newUsername.equals(username)) {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to change the username?", "Confirm Username Change", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.NO_OPTION) {
                return;
            }
        }

        this.username = usernameField.getText();
        this.password = new String(passwordField.getPassword());

        String retypePassword = new String(retypePasswordField.getPassword());
        if (!this.password.equals(retypePassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match. Please re-type the password correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Changes saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        this.dispose();
    }
}
