
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class HousePage12 extends JFrame implements MouseListener  {
	
	JLabel imageLabel1,Housenumber;
	JButton backButton,reviewButton;
	JTextArea Housedetails;
	static  String loggedInUsername;
	public HousePage12(String loggedInUsername){
		
		this.setTitle("House Page");
        this.setSize(800, 500);
        this.setLayout(null);
		this.loggedInUsername=loggedInUsername;
        this.getContentPane().setBackground(new Color(123, 205, 255));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon("Photos/home7.png");
        imageLabel1 = new JLabel();
        imageLabel1.setBounds(0, -10, 800, 500);
        imageLabel1.setIcon(image);
		
		Housenumber = new JLabel();
        Housenumber.setBounds(185, 189, 524, 50);
        Housenumber.setFont(new Font("Cooper Black", Font.PLAIN, 30));
        imageLabel1.add(Housenumber);
		
		
		Housedetails = new JTextArea();
		Housedetails.setBounds(187, 194, 524, 237);
        Housedetails.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		Housedetails.setEditable(false);
		 //Housedetails.setBackground(new Color(123,205,255));
		 Housedetails.setBackground(new Color(0,0,0,0));
        imageLabel1.add(Housedetails);
		
		
		// Create a file object for the text file
		File file = new File("House/houseno440.txt");
		// Create a string builder to store the file content
		StringBuilder sb = new StringBuilder();
		try {
			// Create a buffered reader to read the file
			BufferedReader br = new BufferedReader(new FileReader(file));
			// Read each line of the file and append it to the string builder
			String line = br.readLine();
			while (line != null) {
				sb.append(line).append("\n");
				line = br.readLine();
			}
			// Close the buffered reader
			br.close();
			// Set the text of the label to the string builder content
			//Housedetails.setText(sb.toString());
		} catch (IOException e) {
			// Handle the exception
			e.printStackTrace();
		}
		Housedetails.setText(sb.toString());
		
		
		
		
		
		backButton = new JButton("Back");
        backButton.setBounds(37, 429, 100, 36);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBackground(new Color(92, 225, 230));
        backButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        backButton.setFocusable(false);
        backButton.setBorderPainted(false);
        backButton.addMouseListener(this);
        imageLabel1.add(backButton);
		
		
		
		
		
		reviewButton = new JButton("Review");
        reviewButton.setBounds(647, 139, 105, 41);
        reviewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reviewButton.setBackground(new Color(92, 225, 230));
        reviewButton.setFont(new Font("Cooper Black", Font.PLAIN, 18));
        reviewButton.setFocusable(false);
        //reviewButton.setBorderPainted(false);
        reviewButton.addMouseListener(this);
        imageLabel1.add(reviewButton);
		
		
		
		
		 this.add(imageLabel1);
        this.setVisible(true);
		
	}
	
	public void mouseClicked(MouseEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new SearchPage10(loggedInUsername);
        }
		else if (e.getSource() == reviewButton){
			dispose();
			new ReviewPage12(loggedInUsername);
		}
		
    }

    
    public void mousePressed(MouseEvent e) {}

   
    public void mouseReleased(MouseEvent e) {}

   
    public void mouseEntered(MouseEvent e) {}

   
    public void mouseExited(MouseEvent e) {}

	
	
	
	
	
	
	public static void main ( String args[]){
		
		new HousePage12(loggedInUsername);
		
	}
	
}