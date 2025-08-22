
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RegisterForm extends JFrame implements ActionListener,MouseListener  {
    
     // GUI Components
	
     JLabel registerLabel, nameLabel, emailLabel, passwordLabel,repasswordLabel,phoneNumberLabel,imageLabe1;
     JTextField nameTextField, emailTextField,passwordTextField,repasswordTextField,phoneNumberTextField;
     JButton submitButton, backButton;
	
     public RegisterForm() {
         
         // Set window properties
         this.setTitle("Register Form");
         this.setSize(800, 500);
         this.setLayout(null);
         this.getContentPane().setBackground(new Color(123,205,255));
         this.setResizable(false);
		 
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLocationRelativeTo(null);
         
         ImageIcon image = new ImageIcon("Photos/home3.jpg");
         imageLabe1 = new JLabel();
         imageLabe1.setBounds(30,-30,800, 500);
         imageLabe1.setIcon(image);
         
         registerLabel = new JLabel();
         registerLabel.setText("Register");
         registerLabel.setBounds(20,10,300,100);
         registerLabel.setForeground( new Color(0,74,173));
         registerLabel.setFont(new Font("Cooper Black",Font.BOLD,50));
         imageLabe1.add(registerLabel);
         
         // Initialize components
         nameLabel = new JLabel("Username :");
         nameLabel.setBounds(126, 101, 190, 51);
         nameLabel.setFont(new Font("Cooper Black",Font.PLAIN,30));
         imageLabe1.add(nameLabel);
         
         nameTextField = new JTextField();
         nameTextField.setBounds(327, 105, 388, 45);
         nameTextField.setFont(new Font("Cooper Black",Font.PLAIN,30));
         imageLabe1.add(nameTextField);
         
         emailLabel = new JLabel("Email :");
         emailLabel.setBounds(188, 171, 190, 51);
         emailLabel.setFont(new Font("Cooper Black",Font.PLAIN,30));
         imageLabe1.add(emailLabel);
         
         emailTextField = new JTextField();
         emailTextField.setBounds(327, 175, 388, 45);
         emailTextField.setFont(new Font("Cooper Black",Font.PLAIN,30));
         imageLabe1.add(emailTextField);
         
         phoneNumberLabel = new JLabel("Phone Number:");
         phoneNumberLabel.setBounds(55, 241, 280, 51);
         phoneNumberLabel.setLayout(null);
         phoneNumberLabel.setFont(new Font("Cooper Black",Font.PLAIN,30));
         imageLabe1.add(phoneNumberLabel);
         
         phoneNumberTextField = new JTextField();
         phoneNumberTextField.setBounds(327, 245, 388, 45);
         phoneNumberTextField.setFont(new Font("Cooper Black",Font.PLAIN,30));
         imageLabe1.add(phoneNumberTextField);
         
         passwordLabel = new JLabel("Password :");
         passwordLabel.setFont(new Font("Cooper Black",Font.PLAIN,30));
         passwordLabel.setBounds(128, 310, 190, 51);
         imageLabe1.add(passwordLabel);
         
         passwordTextField = new JTextField();
         passwordTextField.setBounds(327, 315, 388, 45);
         passwordTextField.setFont(new Font("Cooper Black",Font.PLAIN,30));
         imageLabe1.add(passwordTextField);
         
        repasswordLabel = new JLabel("Re-Type password :");
		repasswordLabel.setFont(new Font("Cooper Black",Font.PLAIN,28));
        repasswordLabel.setBounds(15, 380, 280, 51);
        imageLabe1.add(repasswordLabel);
		 
		 
		 
		 
		 
     repasswordTextField = new JTextField();
     repasswordTextField.setBounds(327, 385, 388, 45);
	 
     repasswordTextField.setFont(new Font("Cooper Black",Font.PLAIN,30));
     imageLabe1.add(repasswordTextField);
     
      submitButton = new JButton("Submit");
        submitButton.setBounds( 605, 439, 110, 45);
		submitButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
		submitButton.setBackground(new Color(0,74,173));
        submitButton.addActionListener(this);
		submitButton.setFocusable(false);
		submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submitButton.setBorderPainted(false);
		//submitButton.setVisible(false);
        imageLabe1.add(submitButton);
     
     backButton = new JButton("Back");
        backButton.setBounds(326, 443, 108, 41);
		backButton.setBackground(new Color(0,74,173));
		backButton.setFont(new Font("Cooper Black",Font.PLAIN,20));
		backButton.setBorderPainted(false);
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(this);
     imageLabe1.add(backButton);
     // Add image label to the frame
     this.add(imageLabe1);
     
     // Show the frame
     this.setVisible(true);
 }
 
 public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Get input values
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            String password = passwordTextField.getText();
            String repassword = repasswordTextField.getText();

            // Validate input values
            if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(repassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (isUsernameTaken(name)) {
                JOptionPane.showMessageDialog(this, "Username is already taken!", "Error", JOptionPane.ERROR_MESSAGE);
            } 
			
			
			else {
                // Save data to file
                try {
                    FileWriter writer = new FileWriter("User Information/data.txt", true);
                    writer.write(name + "," + password + "," + phoneNumber + "," + email + "\n");
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new Interface();
                    // Clear text fields
                    nameTextField.setText("");
                    emailTextField.setText("");
                    phoneNumberTextField.setText("");
                    passwordTextField.setText("");
                    repasswordTextField.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "An  Error Has Been occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == backButton) {
            // Go back to the main menu
            this.setVisible(false);
            new Interface();
        }
    }

    // Helper method to check if the username is already taken
    private boolean isUsernameTaken(String username) {
        try {
            FileReader reader = new FileReader("User Information/data.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userInfo = line.split(",");
                String existingUsername = userInfo[0];
                if (existingUsername.equals(username)) {
                    bufferedReader.close();
                    return true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

 // MouseListener methods for mouse clicks
 public void mouseClicked(MouseEvent e) {
     if (e.getSource() == nameTextField) {
         nameTextField.setText("");
     } else if (e.getSource() == emailTextField) {
         emailTextField.setText("");
     } else if (e.getSource() == phoneNumberTextField) {
         phoneNumberTextField.setText("");
     } else if (e.getSource() == passwordTextField) {
         passwordTextField.setText("");
     } else if (e.getSource() == repasswordTextField) {
         repasswordTextField.setText("");
     }
 }
 
 public void mouseEntered(MouseEvent e) {
	
	 
 }
 public void mouseExited(MouseEvent e) {}
 public void mousePressed(MouseEvent e) {}
 public void mouseReleased(MouseEvent e) {}
 
 // Main method to start the program
 public static void main(String[] args) {
     new RegisterForm();
}}

