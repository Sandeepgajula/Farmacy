package projects;
import javax.swing.*;
import javax.swing.border.EmptyBorder; 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager; 
public class sign extends JFrame { 
   static JTextField tf1;
    static JTextField tf2;
   static JTextField tf4;
   static JLabel l1,l2,l3,l4,l5,l0; 
   static JButton b1 ;
   static JPasswordField tf5;
  static JButton b;
   static JPanel f;
   /** 
 */ 
public static void main(String[] args) throws Exception {
   //EventQueue.invokeLater(new Runnable() {
     //new TextFieldExample(); 
          try {
               sign frame = new sign();
              frame.setVisible(true);
          } catch (Exception e) {
              e.printStackTrace();
          }
      } 
public sign(){ 
    //setLocationRelativeTo(null);
     setSize(350,350);
     setResizable(false);
     f=new JPanel(); 
     Color c1=new Color(51,204,255);
     f.setBackground(c1);
     f.setBorder(new EmptyBorder(5,5,5,5));
     setContentPane(f);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     l0=new JLabel("Signup"); 
    l0.setFont(new Font("Serif Bold",Font.BOLD,20));
     l0.setBounds(125,0,100,30);
     l1=new JLabel("Name");
     l1.setBounds(50,40,100,30);
        l2=new JLabel("Phone Number");
        l2.setBounds(50,80,100,30);
        l3=new JLabel("Gender");
        l3.setBounds(50,120,100,30);
        l4=new JLabel("Username");
        l4.setBounds(50,160,100,30);
        l5=new JLabel("Password");
        l5.setBounds(50,200,100,30);
        tf1=new JTextField(); 
        tf1.setBounds(150,45,150,20);  
        tf2=new JTextField(); 
        tf2.setBounds(150,85,150,20);   
        JRadioButton r1=new JRadioButton("Male");
        JRadioButton r2=new JRadioButton("Female");
        r1.setBounds(150,125,75,20);
        r2.setBounds(225,125,75,20);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2); 
        tf4=new JTextField(); 
        tf4.setBounds(150,165,150,20); 
        tf5=new JPasswordField();
        tf5.setBounds(150,205,150,20);
       b=new JButton("Submit");
    b.setBounds(100,270,80,30);  
        f.setLayout(null); 
        f.add(l0);
        f.add(l1);
        f.add(tf1);
        f.add(l2);f.add(tf2);
        f.add(l3);f.add(r1);f.add(r2);
        f.add(l4);f.add(tf4);
        f.add(l5);
        f.add(tf5);
        f.add(b);  
        //addComponentListener((ComponentListener) new MyWindowAdapter()); 
/**
 * @param args
 * @throws Exception
 */ 
   
b.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
        String v1=tf1.getText();
        String v2=tf2.getText();
        String v4=tf4.getText(); 
        String v5=new String(tf5.getPassword()); 
        String v3=" ";  
        if(r1.isSelected())
            v3=v3+" "+"Male";
        if(r2.isSelected())
            v3=v3+" "+ "Female";
        //Frame r2; 
       // String v11=ch.getSelectedItem(); 
       System.out.println(tf5.getPassword());   
        try{
         Connection con=DriverManager.getConnection ("jdbc:mysql:///oop","root","rgukt123");  
           java.sql.Statement st=con.createStatement();
           st.executeUpdate("insert into users(Uname,Pword,Name,Pnumber,Gender) values('"+v4+"','"+v5+"','"+v1+"','"+v2+"','"+v3+" ' )");
           JOptionPane.showMessageDialog(null,"Data is inserted successfully");
        }
           //step1 load the driver class  
    //Class.forName("oracle.jdbc.driver.OracleDriver");   
        catch(Exception ex){
        System.out.println(ex);
         } 
       }
});    
}
/**
 * @param exitOnClose
 */ 
} 