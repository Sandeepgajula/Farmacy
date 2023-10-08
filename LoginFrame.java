package projects;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
   private JLabel usernameLabel, passwordLabel,d;
   private JTextField usernameField;
   private JPasswordField passwordField;
   private JButton loginButton;
   String username,password;

   public LoginFrame() {
      super("Login");
      setLayout(new FlowLayout());

      usernameLabel = new JLabel("Username: "); 
      usernameLabel.setBounds(100,40 ,30 ,40);
      add(usernameLabel);

      usernameField = new JTextField(15);
      usernameField.setBounds(200,40 ,30 ,40);
      add(usernameField);

      passwordLabel = new JLabel("Password: "); 
      passwordLabel.setBounds(100,60 ,30 ,40);
      add(passwordLabel);

      passwordField = new JPasswordField(15); 
      passwordField.setBounds(200,60 ,30 ,40);
      add(passwordField);

      loginButton = new JButton("Login");
      loginButton.addActionListener(this);
      add(loginButton);

      d = new JLabel("");
      add(d);
      // loginButton.addActionListener(new ActionListener() {
      //     @Override
      //     public void actionPerformed(ActionEvent e) {
      //          MainFrame2  o= new  MainFrame2();
      //         o.setVisible(true);
      //     }
      // });

      setSize(300, 200);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
      
   }

   public void actionPerformed(ActionEvent event) {
      username = usernameField.getText();
      password = new String(passwordField.getPassword());
      try {
         login();
      } catch (SQLException e) {
         System.out.println("********OOPS***********");
      }
   }
   public void login() throws SQLException{
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop","root","rgukt123");
      PreparedStatement query = con.prepareStatement("Select Uname,Pword from Users WHERE Uname=? and Pword=?");
         query.setString(1,this.username);
         query.setString(2,this.password);
         ResultSet results = query.executeQuery();
         if(results.next()){
         //    d.setText("  User Found  "); 
            MainFrame2  o= new  MainFrame2();
            o.setVisible(true);
         }
         else{
            d.setText("  User Not Found  ");
         }
   }
   public static void main(String[] args) throws Exception{
      new LoginFrame();
      //       try{
      //           PreparedStatement st = con.prepareStatement("insert into Users values (?,?,null,null,null)");
      //           st.setString(1,username);
      //           st.setString(2,password);
      //           st.executeUpdate();
      //           System.out.println("Account creation Complete");
      //       }
      //       catch(Exception e){
      //           System.out.println("Username already exists");
      
      }
}
