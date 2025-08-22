


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchPage7 extends JFrame implements MouseListener{

    JButton backButton,House1;
    JLabel imageLabel;
    ImageIcon image;
 static  String loggedInUsername;
    public SearchPage7(  String loggedInUsername) {
        setTitle("Search Page");
        setSize(800, 500);
        setLayout(null);
		this.loggedInUsername=loggedInUsername;
        getContentPane().setBackground(new Color(123, 205, 255));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        image = new ImageIcon("Photos/home8.png");
        imageLabel = new JLabel();
        imageLabel.setBounds(0, -10, 800, 500);
        imageLabel.setIcon(image);

        ImageIcon image2 = new ImageIcon("Photos/profile3.png");
        
		JPanel panel = new JPanel();
		panel.setBounds(15, 55, 69, 69);
		panel.setBackground(new Color (123,205,255));
		imageLabel.add(panel);
		
		
        backButton = new JButton("Back");
        backButton.setBounds(37, 421, 98, 38);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBackground(new Color(92, 225, 230));
        backButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        backButton.setFocusable(false);
        backButton.setBorderPainted(false);
        backButton.addMouseListener(this);
        imageLabel.add(backButton);


        House1 = new JButton("HOUSE NO.790");
        House1.setBounds(245, 190, 300, 48);
        House1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		House1.setForeground(new Color(0, 0, 0));
        House1.setBackground(new Color(0, 74, 173));
        House1.setFont(new Font("Cooper Black", Font.BOLD, 25));
        House1.setFocusable(false);
        House1.setBorderPainted(false);
        House1.addMouseListener(this);
        imageLabel.add(House1);
		
		
		
		
		

        add(imageLabel);
        setVisible(true);
    }

    
    public void mouseClicked(MouseEvent e) {
         if (e.getSource() == backButton) {
            dispose();
            new HomePage(loggedInUsername);
        }
		
		else if (e.getSource() == House1) {
            dispose();
            new HousePage9(loggedInUsername);
        }
		
		
		
		
    }

    
    public void mousePressed(MouseEvent e) {}

   
    public void mouseReleased(MouseEvent e) {}

   
    public void mouseEntered(MouseEvent e) {}

   
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new SearchPage7(   loggedInUsername);
    }
}

