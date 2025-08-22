
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements MouseListener {

   JPanel panel;
    JLabel imageLabe1;
    JButton loginButton, signupButton,infoButton;
	ImageIcon image,image2;

    public Interface() {

        this.setTitle("Interface");
        this.setSize(800, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(254, 255, 229));
        this.setResizable(false);

         image = new ImageIcon("Photos/home.jpg");
        JLabel imageLabel = new JLabel(image);
		 image2 = new ImageIcon("Photos/icon.png");
        
        imageLabel.setSize(image.getIconWidth(), image.getIconHeight());
        imageLabel.setVerticalAlignment(JLabel.TOP);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
		

         panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.CENTER);

        

        loginButton = new JButton("Login");
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        loginButton.setBounds(530, 180, 150, 60);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.black));
        loginButton.setBackground(new Color(78, 125, 207));
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
		loginButton.addMouseListener(this);
        imageLabel.add(loginButton);

        signupButton = new JButton("Sign up");
        signupButton.setFocusable(false);
        signupButton.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        signupButton.setBounds(530, 260, 150, 60);
        signupButton.setBackground(new Color(78, 125, 207));
        signupButton.setBorder(BorderFactory.createLineBorder(Color.black));
		signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupButton.addMouseListener(this);
		
		infoButton = new JButton(image2);
		
        infoButton.setFocusable(false);
        infoButton.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        infoButton.setBounds(33, 20, 38, 38);
		infoButton.setBorderPainted(false);
		infoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		imageLabel.add(infoButton);
		infoButton.addMouseListener(this);
		
		
        imageLabel.add(signupButton);
        this.add(imageLabel);
        this.setVisible(true);
    }

         public void  mouseClicked(MouseEvent e){
			 if (e.getSource() == loginButton) {
            dispose();
            new LoginForm();
        } else if (e.getSource() == signupButton) {
            dispose();
            new RegisterForm();

        }
		else if (e.getSource()== infoButton){
			dispose();
			new Contribution();
		}
		 };
         public void  	mouseEntered(MouseEvent e){
			 if(e.getSource() == loginButton){
			 loginButton.setBackground( Color.white);
			 }
			 else if(e.getSource() == signupButton){
				 signupButton.setBackground( Color.white);
			 }
		 };
         public void  mouseExited(MouseEvent e){
			 if(e.getSource() == loginButton){
			 loginButton.setBackground(new Color(78, 125, 207));
			 }
			 else if (e.getSource() == signupButton){
				 signupButton.setBackground(new Color(78, 125, 207));
			 }
			 
		 };
         public void  	mousePressed(MouseEvent e){};
         public void  mouseReleased(MouseEvent e){};
		 



    public static void main(String[] args) {
        new Interface();
    }
}
