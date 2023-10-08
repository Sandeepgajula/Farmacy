package projects;
import java.awt.*;
import java.sql.*; 
import javax.swing.*; 
import java.awt.event.*;

class  lab1{
    
    public static void main(String[] args) throws Exception{
    Frame f=new Frame();
    Label label1=new Label("Student Name ");
    Label label2=new Label("Father's Name: ");
    Label label3=new Label("Mother's Name ");
    Label label4=new Label("Gender");
    Label label5=new Label("Dateofbirth");
    Label label6=new Label("Address"); 
    Label label7=new Label("Email"); 
    Label label8=new Label("Mobile"); 
    Label label9=new Label("Department"); 
    Label label10=new Label("Attachment"); 
   // Label label11=new Label("Resume");

    final TextField text1=new TextField(10); 
    text1.setBounds(50, 100, 30, 30);
    final TextField text2=new TextField(10); 
    text2.setBounds(50, 120, 30, 30); 
    final TextField text3=new TextField(10);  
    text3.setBounds(50, 140, 30, 30);
    //final RadioButtonBorder text4=new RadioButtonBorder();
    Checkbox c1,c2,c3;
    c1=new Checkbox("Mark Memo");
    c2=new Checkbox("Income");
    c3=new Checkbox("cast certificate");
  
    Checkbox d1,d2;
    CheckboxGroup cbg=new CheckboxGroup();
    d1=new Checkbox("Male",false,cbg);
    d2=new Checkbox("Female",false,cbg);   
   d1.setBounds(50,100,20,40);
   d2.setBounds(100,100,20,40);
    //setLayout(new FlowLayout()); 
    final TextField text5=new TextField(5);  
    final TextArea text6=new TextArea(); 
    final TextField text7=new TextField(5);  
    final TextField text8=new TextField(10); 

    //create an empty choice menu
    //List l=new List(4,true);   
    Choice ch=new Choice(); 
   //add some items to choice menu
    ch.add("CSE");
    ch.add("ECE");
    ch.add("EEE");
    ch.add("MME");
    ch.add("CIVIL");
    ch.add("MECH");  
//add item listener to choice menu   
    Button b=new Button("Submit");

    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        String v1=text1.getText();
        String v2=text2.getText();
        String v3=text3.getText();
        String v4=text6.getText();
        String v5=text5.getText();
        String v6=text7.getText(); 
        String v8=text8.getText();
        String v9=" ";
        if(c1.getState())
            v9=c1.getLabel();
        if(c2.getState())
            v9=c2.getLabel();
        if(c3.getState())
            v9=v9+" "+c3.getLabel();
        String v10=" "; 
        if(d1.getState())
            v10=v10+" "+d1.getLabel();
        if(d2.getState())
            v10=v10+" "+d2.getLabel(); 
        String v11=ch.getSelectedItem();  
        
        try{
           //step1 load the driver class  
    //Class.forName("oracle.jdbc.driver.OracleDriver");  
      
    //step2 create  the connection object  
     Connection con=DriverManager.getConnection ("jdbc:mysql:///cse","root","rgukt123");  
           Statement st=con.createStatement();
            st.executeUpdate("insert into sandeep(StudentName,FathersName,MothersName,Gender,Dateofbirth,Address,Email,Mobile,Department,Attachment) values('"+v1+"','"+v2+"','"+v3+"','"+v10+"','"+v5+" ','"+v4+" ','"+v6+"','"+v8+"','"+v11+" ','"+v9+"')");
           JOptionPane.showMessageDialog(null,"Data is inserted successfully");
        }
        catch(Exception ex){
        System.out.println(ex);
         }
       }
        });
        Panel p=new Panel(new GridLayout(20,2));
        p.add(label1);
        p.add(text1);
        p.add(label2);
        p.add(text2);
        p.add(label3);
        p.add(text3);
        p.add(label4); 
        p.add(d1);
        // p.add(d2); 
        p.add(label5);
        p.add(text5);
        p.add(label6);
        p.add(text6);
        p.add(label7);
        p.add(text7);
        p.add(label8);
        p.add(text8);
        p.add(label9);
        p.add(ch);
        p.add(label10);
        p.add(c1);
        p.add(c2);
        p.add(c3);
        p.add(b);
        f.add(p);
        f.setVisible(true);
        f.pack();
        f.addWindowListener(new MyWindowAdapter());
    }  
    
}
class MyWindowAdapter extends WindowAdapter { 
    public void windowClosing(WindowEvent e){
        System.exit(0);
       }    
     }
 