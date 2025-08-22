import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements MouseListener {

    JButton profileButton, searchButton;
    JComboBox District, Area, Road, Block;
    JLabel imageLabel1;
    ImageIcon image;
    static String loggedInUsername;
    JComboBox<String> areaComboBox, blockComboBox, roadComboBox;

    public HomePage(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;

        this.setTitle("Home Page");
        this.setSize(800, 500);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(123, 205, 255));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        image = new ImageIcon("Photos/home4.jpg");
        imageLabel1 = new JLabel();
        imageLabel1.setBounds(0, 0, 800, 500);
        imageLabel1.setIcon(image);

        String[] Districtname = {"Dhaka"};

        District = new JComboBox(Districtname);
        District.setFont(new Font("Cooper Black", Font.PLAIN, 20));
        District.setBounds(35, 210, 141, 37);
        District.setFocusable(false);
        District.setBackground(new Color(123, 205, 255));
        District.setCursor(new Cursor(Cursor.HAND_CURSOR));
        District.setForeground(Color.black);
        imageLabel1.add(District);

        String[] areaNames = {"Area", "Basundhara", "Mirpur", "N/A"};

        areaComboBox = new JComboBox<>(areaNames);
        areaComboBox.setFont(new Font("Cooper Black", Font.PLAIN, 20));
        areaComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        areaComboBox.setFocusable(false);
        areaComboBox.setBounds(218, 210, 141, 37);
        areaComboBox.setBackground(new Color(123, 205, 255));
        areaComboBox.setForeground(Color.black);

        String[] defaultBlockNames = {"Block"};
        String[] basundharaBlockNames = {"Block", "A", "B", "C"};
        String[] mirpurBlockNames = {"Sector", "1", "2", "6", "7"};
        String[] naBlockNames = {"N/A"};

        blockComboBox = new JComboBox<>(defaultBlockNames);
        blockComboBox.setFont(new Font("Cooper Black", Font.PLAIN, 20));
        blockComboBox.setBounds(402, 210, 141, 37);
        blockComboBox.setFocusable(false);
        blockComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        blockComboBox.setForeground(Color.black);
        blockComboBox.setBackground(new Color(123, 205, 255));

        String[] defaultRoadNo = {"Road No"};
        String[] basundharaNARoadNo = {"N/A"};
        String[] basundharaAR = {"Road No", "1", "2", "3"};
        String[] basundharaBR = {"Road No", "1", "2"};
        String[] basundharaCR = {"Road No", "1"};
        String[] mirpurSONER = {"Road No", "1", "2"};
        String[] mirpurSTWOR = {"Road No", "1"};
        String[] mirpurSSIXR = {"Road No", "4"};
        String[] mirpurSSEVENR = {"Road No", "44"};

        roadComboBox = new JComboBox<>(defaultRoadNo);
        roadComboBox.setFont(new Font("Cooper Black", Font.PLAIN, 20));
        roadComboBox.setBounds(620, 210, 141, 37);
        roadComboBox.setFocusable(false);
        roadComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        roadComboBox.setForeground(Color.black);
        roadComboBox.setBackground(new Color(123, 205, 255));

        areaComboBox.addActionListener(e -> {
            String selectedArea = (String) areaComboBox.getSelectedItem();
            switch (selectedArea) {
                case "Basundhara":
                    blockComboBox.setModel(new DefaultComboBoxModel<>(basundharaBlockNames));
                    break;
                case "Mirpur":
                    blockComboBox.setModel(new DefaultComboBoxModel<>(mirpurBlockNames));
                    break;
                case "N/A":
                    blockComboBox.setModel(new DefaultComboBoxModel<>(basundharaNARoadNo));
                    break;
                default:
                    blockComboBox.setModel(new DefaultComboBoxModel<>(defaultBlockNames));
                    break;
            }
        });

        blockComboBox.addActionListener(e -> {
            String selectedRoad = (String) blockComboBox.getSelectedItem();
            switch (selectedRoad) {
                case "A":
                    roadComboBox.setModel(new DefaultComboBoxModel<>(basundharaAR));
                    break;
                case "B":
                    roadComboBox.setModel(new DefaultComboBoxModel<>(basundharaBR));
                    break;
                case "C":
                    roadComboBox.setModel(new DefaultComboBoxModel<>(basundharaCR));
                    break;
                case "1":
                    roadComboBox.setModel(new DefaultComboBoxModel<>(mirpurSONER));
                    break;
                case "2":
                    roadComboBox.setModel(new DefaultComboBoxModel<>(mirpurSTWOR));
                    break;
                case "6":
                    roadComboBox.setModel(new DefaultComboBoxModel<>(mirpurSSIXR));
                    break;
                case "7":
                    roadComboBox.setModel(new DefaultComboBoxModel<>(mirpurSSEVENR));
                    break;
                case "N/A":
                    roadComboBox.setModel(new DefaultComboBoxModel<>(basundharaNARoadNo));
                    break;
                default:
                    roadComboBox.setModel(new DefaultComboBoxModel<>(defaultRoadNo));
                    break;
            }
        });

        imageLabel1.add(areaComboBox);
        imageLabel1.add(blockComboBox);
        imageLabel1.add(roadComboBox);

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        searchButton.setBounds(288, 335, 224, 42);
        searchButton.setForeground(Color.black);
        searchButton.setBackground(new Color(123, 205, 255));
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchButton.setBorderPainted(false);
        searchButton.setFocusable(false);
        searchButton.addMouseListener(this);
        imageLabel1.add(searchButton);

        ImageIcon image2 = new ImageIcon("Photos/profile3.png");
        profileButton = new JButton(image2);

        profileButton.setBounds(15, 62, 69, 69);
        profileButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profileButton.setBorderPainted(false);
        profileButton.setFocusable(false);
        profileButton.addMouseListener(this);
        imageLabel1.add(profileButton);

        this.add(imageLabel1);
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        String selectedArea = (String) areaComboBox.getSelectedItem();
        String selectedBlock = (String) blockComboBox.getSelectedItem();
        String selectedRoad = (String) roadComboBox.getSelectedItem();

        if (selectedArea.equals("Basundhara") && selectedBlock.equals("A") && selectedRoad.equals("1")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage(loggedInUsername);
            }
        } else if (selectedArea.equals("Basundhara") && selectedBlock.equals("A") && selectedRoad.equals("2")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage2(loggedInUsername);
            }
        } else if (selectedArea.equals("Basundhara") && selectedBlock.equals("A") && selectedRoad.equals("3")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage3(loggedInUsername);
            }
        } else if (selectedArea.equals("Basundhara") && selectedBlock.equals("B") && selectedRoad.equals("1")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage4(loggedInUsername);
            }
        } else if (selectedArea.equals("Basundhara") && selectedBlock.equals("C") && selectedRoad.equals("1")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage5(loggedInUsername);
            }
        } else if (selectedArea.equals("Mirpur") && selectedBlock.equals("1") && selectedRoad.equals("1")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage6(loggedInUsername);
            }
        } else if (selectedArea.equals("Mirpur") && selectedBlock.equals("1") && selectedRoad.equals("2")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage7(loggedInUsername);
            }
        } else if (selectedArea.equals("Mirpur") && selectedBlock.equals("2") && selectedRoad.equals("1")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage8(loggedInUsername);
            }
        } else if (selectedArea.equals("Mirpur") && selectedBlock.equals("6") && selectedRoad.equals("4")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage9(loggedInUsername);
            }
        } else if (selectedArea.equals("Mirpur") && selectedBlock.equals("7") && selectedRoad.equals("44")) {
            if (e.getSource() == searchButton) {
                dispose();
                new SearchPage10(loggedInUsername);
            }
        } else if (e.getSource() == profileButton) {
            dispose();
            new ProfilePage(loggedInUsername);
        } else {
            JOptionPane.showMessageDialog(this, "Please select valid options to search.");
        }
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == searchButton) {
            searchButton.setBackground(Color.white);
        }

    }

    ;

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == searchButton) {
            searchButton.setBackground(new Color(123, 205, 255));
        }


    }

    ;

    public void mousePressed(MouseEvent e) {
    }

    ;

    public void mouseReleased(MouseEvent e) {
    }

    ;

    public static void main(String[] args) {
        new HomePage(loggedInUsername);
    }
}
