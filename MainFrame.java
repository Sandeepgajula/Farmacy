package projects; 
import java.awt.Dimension; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton signUpButton;
    private LoginFrame loginFrame;
    private sign sign;

    /**
     * 
     */
    public MainFrame() {
        JFrame frame = new JFrame();
    // frame.setVisible(true); 
    // // To dispose the panel and the frame
    // frame.dispose();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label=new JLabel();
        ImageIcon i=new ImageIcon("C:/Users/sandeep gajula/Pictures/final1.PNG");
        i.getImage();
        label.setIcon(i);
        Dimension size=label.getPreferredSize(); 
        label.setBounds(50,100,size.width,size.height);  
        mainPanel = new JPanel(); 
        //mainPanel.setBackground(Color.cyan);   
        loginButton = new JButton("Login"); 
        loginButton.setBounds(200,120 ,30 ,40);
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(300,140 ,30 ,40);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame = new LoginFrame();
                //mainPanel.setVisible(false);
                frame.dispose();
                loginFrame.setVisible(true);
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                sign = new sign();
                sign.setVisible(true);
            }
        }); 
        mainPanel.add(label);
        mainPanel.add(loginButton);
        mainPanel.add(signUpButton);
        
        frame.add(mainPanel);

        add(mainPanel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
 

 
    
