package projects;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame2 extends JFrame {
    private Image backgroundImage;
    private JPanel mainPanel; 

    public MainFrame2() {
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/sandeep gajula/Pictures//image.jpeg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        };

        mainPanel.setLayout(new GridBagLayout());
    
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        
        JButton button = new JButton("BUY");
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(button, constraints);
    
        
    


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemOrderFrame  o= new ItemOrderFrame();
                o.setVisible(true);
            }
        });

        mainPanel.add(button);
        add(mainPanel);
        

        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        MainFrame2 mainFrame = new MainFrame2();
        mainFrame.setVisible(true);
    }
}

class  ItemOrderFrame extends JFrame {
    public  ItemOrderFrame() {
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
