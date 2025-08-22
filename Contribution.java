


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contribution extends JFrame implements MouseListener {

   JPanel panel;
    JLabel imageLabel1;
    ImageIcon image;
    Image img;
    JButton  BackButton;
    public Contribution() {

        this.setTitle("Contribution Page");
        this.setSize(800, 500);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(123, 205, 255));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

         image = new ImageIcon("Photos/contribution.png");
        
        imageLabel1 = new JLabel(image);
        imageLabel1.setBounds(0, -12, 800, 500);
        imageLabel1.setIcon(image);
        
        BackButton = new JButton("Back");
        BackButton.setBounds(647, 15, 102, 42);
        BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BackButton.setBackground(new Color(92, 225, 230));
        BackButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        BackButton.setFocusable(false);
        BackButton.setBorderPainted(true);
        BackButton.addMouseListener(this);
        imageLabel1.add(BackButton);
        
         this.add(imageLabel1);
        this.setVisible(true);
        
    }
         public void mouseClicked(MouseEvent e) {
        if (e.getSource() == BackButton) {
            dispose();
            new Interface();
        }
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == BackButton) {
            BackButton.setBackground(Color.red);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == BackButton) {
            BackButton.setBackground(new Color(92, 225, 230));
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public static void main ( String args[]){
        
        new Contribution();
        
}}
