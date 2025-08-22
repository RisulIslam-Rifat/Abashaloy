import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends JFrame implements MouseListener {
    static String loggedInUsername;
    JLabel username, email, phonenumber, password, imageLabel1, usernamefiledata, emailfiledata, phonenumberfiledata, passwordfiledata;
    String line;
    ImageIcon image;
    JButton backButton, logoutButton, editButton;
 EditPasswordUsernameGUI editGUI;
    public ProfilePage(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
        this.setTitle("Profile Page");
        this.setSize(800, 500);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(123, 205, 255));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        image = new ImageIcon("Photos/home5.png");
        imageLabel1 = new JLabel();
        imageLabel1.setBounds(0, -10, 800, 500);
        imageLabel1.setIcon(image);

        username = new JLabel("Username :");
        username.setBounds(100, 153, 237, 53);
        username.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        imageLabel1.add(username);

        usernamefiledata = new JLabel();
        usernamefiledata.setBounds(350, 153, 400, 53);
        usernamefiledata.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        imageLabel1.add(usernamefiledata);

        email = new JLabel("E-mail :");
        email.setBounds(155, 220, 237, 53);
        email.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        imageLabel1.add(email);

        emailfiledata = new JLabel();
        emailfiledata.setBounds(350, 220, 400, 53);
        emailfiledata.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        imageLabel1.add(emailfiledata);

        phonenumber = new JLabel("Phone Number:");
        phonenumber.setBounds(51, 286, 237, 60);
        phonenumber.setFont(new Font("Cooper Black", Font.PLAIN, 28));
        imageLabel1.add(phonenumber);

        phonenumberfiledata = new JLabel();
        phonenumberfiledata.setBounds(350, 286, 400, 60);
        phonenumberfiledata.setFont(new Font("Cooper Black", Font.PLAIN, 28));
        imageLabel1.add(phonenumberfiledata);

        password = new JLabel("Password :");
        password.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        password.setBounds(100, 354, 237, 53);
        imageLabel1.add(password);

        passwordfiledata = new JLabel();
        passwordfiledata.setBounds(350, 354, 400, 53);
        passwordfiledata.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        imageLabel1.add(passwordfiledata);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(339, 419, 123, 44);
        logoutButton.setBackground(new Color(60, 156, 214));
        logoutButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutButton.setFocusable(false);
        logoutButton.setBorderPainted(false);
        logoutButton.addMouseListener(this);
        imageLabel1.add(logoutButton);

        backButton = new JButton("Back");
        backButton.setBounds(50, 55, 141, 48);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBackground(new Color(92, 225, 230));
        backButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        backButton.setFocusable(false);
        backButton.setBorderPainted(false);
        backButton.addMouseListener(this);
        imageLabel1.add(backButton);

        editButton = new JButton("Edit");
        editButton.setBounds(600, 419, 123, 44);
        editButton.setBackground(new Color(60, 156, 214));
        editButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editButton.setFocusable(false);
		 editButton.setBorder(BorderFactory.createLineBorder(Color.black,3));
        //editButton.setBorderPainted(false);
        editButton.addMouseListener(this);
        imageLabel1.add(editButton);

        this.add(imageLabel1);
        this.setVisible(true);

        // Read data from file
        String[] fields;
        List<String> usernames = new ArrayList<>();
        List<String> passwords = new ArrayList<>();
        List<String> phonenumbers = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("User Information/data.txt"));

            while ((line = reader.readLine()) != null) {
                fields = line.split(",");
                usernames.add(fields[0]);
                passwords.add(fields[1]);
                phonenumbers.add(fields[2]);
                emails.add(fields[3]);
            }
            reader.close();
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }

        // Find and display profile information
        String inputUsername = loggedInUsername; // Replace with the actual username to display

        int index = usernames.indexOf(inputUsername);

        if (index != -1) {
            String usernameToDisplay = usernames.get(index);
            String emailToDisplay = emails.get(index);
            String phoneNumberToDisplay = phonenumbers.get(index);
            String passwordToDisplay = passwords.get(index);

            usernamefiledata.setText(usernameToDisplay);
            emailfiledata.setText(emailToDisplay);
            phonenumberfiledata.setText(phoneNumberToDisplay);
            passwordfiledata.setText(passwordToDisplay);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == logoutButton) {
            dispose();
            new LoginForm();
        } else if (e.getSource() == backButton) {
             if (editGUI != null) {
				 dispose();
        new HomePage(editGUI.getUsername());
    } else {
		dispose();
        new HomePage(loggedInUsername);
    }
        } else if (e.getSource() == editButton) {
			
             editGUI = new EditPasswordUsernameGUI(usernamefiledata.getText(), passwordfiledata.getText());
editGUI.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosed(WindowEvent e) {
        // Update the displayed username and password
        usernamefiledata.setText(editGUI.getUsername());
        passwordfiledata.setText(editGUI.getPassword());

        // Call the method to update the username and password in the file
        ProfilePage.updateUserInfoInFile(loggedInUsername, editGUI.getUsername(), editGUI.getPassword());
    }
});

        }
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == logoutButton) {
            logoutButton.setBackground(Color.RED);
        } else if (e.getSource() == backButton) {
            backButton.setBackground(Color.RED);
        } else if (e.getSource() == editButton) {
            editButton.setBackground(Color.RED);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == logoutButton) {
            logoutButton.setBackground(new Color(60, 156, 214));
        } else if (e.getSource() == backButton) {
            backButton.setBackground(new Color(92, 225, 230));
        } else if (e.getSource() == editButton) {
            editButton.setBackground(new Color(60, 156, 214));
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
public static void updateUserInfoInFile(String username, String newUsername, String newPassword) {
    // Read the file and update the user information for the given username
    String filePath = "User Information/data.txt";
    String tempFile = "User Information/temp.txt";
    File oldFile = new File(filePath);
    File newFile = new File(tempFile);

    try {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields[0].equals(username)) {
                fields[0] = newUsername;
                fields[1] = newPassword;
                line = String.join(",", fields);
            }
            writer.write(line + System.lineSeparator());
        }

        reader.close();
        writer.close();

        oldFile.delete();
        newFile.renameTo(oldFile);
    } catch (IOException e) {
        System.err.println("Error updating user information: " + e.getMessage());
    }
}



   private static void updatePasswordInFile(String username, String newPassword) {
    // Read the file and update the password for the given username
    String filePath = "User Information/data.txt";
    String tempFile = "User Information/temp.txt";
    File oldFile = new File(filePath);
    File newFile = new File(tempFile);

    try {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields[0].equals(username)) {
                fields[1] = newPassword;
                line = String.join(",", fields);
            }
            writer.write(line + System.lineSeparator());
        }

        reader.close();
        writer.close();

        oldFile.delete();
        newFile.renameTo(oldFile);
    } catch (IOException e) {
        System.err.println("Error updating password: " + e.getMessage());
    }
}


    public static void main(String[] args) {
        new ProfilePage(loggedInUsername);
    }
}
