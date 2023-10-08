package projects; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemOrderFrame extends JFrame implements ActionListener {
  private JCheckBox item1CheckBox;
  private JCheckBox item2CheckBox;
  private JCheckBox item3CheckBox;
  private JCheckBox item4CheckBox;
  private JCheckBox item5CheckBox;
  private JComboBox<Integer> item1QuantityComboBox;
  private JComboBox<Integer> item2QuantityComboBox;
  private JComboBox<Integer> item3QuantityComboBox;
  private JComboBox<Integer> item4QuantityComboBox;
  private JComboBox<Integer> item5QuantityComboBox;
  private JLabel item1Total,item2Total,item3Total,item4Total,item5Total;
  private JLabel item1PriceLabel;
  private JLabel item2PriceLabel;
  private JLabel item3PriceLabel,item4PriceLabel,item5PriceLabel;
  private JLabel totalPriceLabel;
  private JLabel items,pricekg,qua,fp;
  static JButton purchase;
  private JLabel header;

  /**
   * 
   */
  public ItemOrderFrame() {
    setTitle("Item Order");
    setSize(500, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JPanel panel = new JPanel(new GridBagLayout());
    // Color c=new Color(102,255,102);
    //panel.setBackground(Color.DARK_GRAY);
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.insets = new Insets(10, 10, 10, 10);

    JLabel n2 = new JLabel("  ");
    panel.add(n2);

    header = new JLabel("Welcome!!  ");
    panel.add(header);

    JLabel en = new JLabel("Add Items to your Bag");
    panel.add(en);

    items = new JLabel("Available Items");
    constraints.gridx = 0;
    constraints.gridy = 2;
    panel.add(items, constraints);

    item1CheckBox = new JCheckBox("Brinjal");
    constraints.gridx = 0;
    constraints.gridy = 3;
    panel.add(item1CheckBox, constraints);

    item2CheckBox = new JCheckBox("Tomato");
    constraints.gridx = 0;
    constraints.gridy = 4;
    panel.add(item2CheckBox, constraints);

    item3CheckBox = new JCheckBox("Carrot");
    constraints.gridx = 0;
    constraints.gridy = 5;
    panel.add(item3CheckBox, constraints);

    item4CheckBox = new JCheckBox("Potato");
    constraints.gridx = 0;
    constraints.gridy = 6;
    panel.add(item4CheckBox, constraints);

    item5CheckBox = new JCheckBox("Onion");
    constraints.gridx = 0;
    constraints.gridy = 7;
    panel.add(item5CheckBox, constraints);

    qua = new JLabel("Quantity (kg)");
    constraints.gridx = 2;
    constraints.gridy = 2;
    panel.add(qua, constraints);

    Integer[] quantities = {1, 2, 3, 4, 5};
    item1QuantityComboBox = new JComboBox<>(quantities);
    constraints.gridx = 2;
    constraints.gridy = 3;
    panel.add(item1QuantityComboBox, constraints);

    item2QuantityComboBox = new JComboBox<>(quantities);
    constraints.gridx = 2;
    constraints.gridy = 4;
    panel.add(item2QuantityComboBox, constraints);

    item3QuantityComboBox = new JComboBox<>(quantities);
    constraints.gridx = 2;
    constraints.gridy = 5;
    panel.add(item3QuantityComboBox, constraints);

    item4QuantityComboBox = new JComboBox<>(quantities);
    constraints.gridx = 2;
    constraints.gridy = 6;
    panel.add(item4QuantityComboBox, constraints);

    item5QuantityComboBox = new JComboBox<>(quantities);
    constraints.gridx = 2;
    constraints.gridy = 7;
    panel.add(item5QuantityComboBox, constraints);

    pricekg = new JLabel("Price/kg");
    constraints.gridx = 3;
    constraints.gridy = 2;
    panel.add(pricekg, constraints);

    item1PriceLabel = new JLabel("₹10");
    constraints.gridx = 3;
    constraints.gridy = 3;
    panel.add(item1PriceLabel, constraints);

    item2PriceLabel = new JLabel("₹25");
    constraints.gridx = 3;
    constraints.gridy = 4;
    panel.add(item2PriceLabel, constraints);

    item3PriceLabel = new JLabel("₹30");
    constraints.gridx = 3;
    constraints.gridy = 5;
    panel.add(item3PriceLabel, constraints);

    item4PriceLabel = new JLabel("₹15");
    constraints.gridx = 3;
    constraints.gridy = 6;
    panel.add(item4PriceLabel, constraints);

    item5PriceLabel = new JLabel("₹45");
    constraints.gridx = 3;
    constraints.gridy = 7;
    panel.add(item5PriceLabel, constraints);

    fp = new JLabel("Final Price");
    constraints.gridx = 4;
    constraints.gridy = 2;
    panel.add(fp, constraints);

    item1Total = new JLabel("₹0");
    constraints.gridx=4;
    constraints.gridy=3;
    panel.add(item1Total, constraints);

    item2Total = new JLabel("₹0");
    constraints.gridx=4;
    constraints.gridy=4;
    panel.add(item2Total, constraints);

    item3Total = new JLabel("₹0");
    constraints.gridx=4;
    constraints.gridy=5;
    panel.add(item3Total, constraints);

    item4Total = new JLabel("₹0");
    constraints.gridx=4;
    constraints.gridy=6;
    panel.add(item4Total, constraints);

    item5Total = new JLabel("₹0");
    constraints.gridx=4;
    constraints.gridy=7;
    panel.add(item5Total, constraints);

    JLabel totalPriceCaption = new JLabel("Total:");
    constraints.gridx = 3;
    constraints.gridy = 8;
    panel.add(totalPriceCaption, constraints);

    totalPriceLabel = new JLabel("₹0");
    constraints.gridx = 4;
    constraints.gridy = 8;
    panel.add(totalPriceLabel, constraints);

    purchase = new JButton("Purchase");
    constraints.gridx = 4;
    constraints.gridy = 10;
    panel.add(purchase,constraints); 
    add(panel); 
    item1CheckBox.addActionListener(this);
    item2CheckBox.addActionListener(this);
    item3CheckBox.addActionListener(this);
    item4CheckBox.addActionListener(this);
    item5CheckBox.addActionListener(this);
    item1QuantityComboBox.addActionListener(this);
    item2QuantityComboBox.addActionListener(this);
    item3QuantityComboBox.addActionListener(this);
    item4QuantityComboBox.addActionListener(this);
    item5QuantityComboBox.addActionListener(this);
    purchase.addActionListener(this);
  
  purchase.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        NewFrame y = new NewFrame(); 
        y.setVisible(true);
    }
    });
  }
  @Override
  public void actionPerformed(ActionEvent e) {

    int total = 0,t1=0,t2=0,t3=0,t4=0,t5=0;
    if (item1CheckBox.isSelected()) {
      int quantity = (Integer)item1QuantityComboBox.getSelectedItem();
      total += 10 * quantity;
      t1 = 10*quantity;
    }
    if (item2CheckBox.isSelected()) {
      int quantity = (Integer)item2QuantityComboBox.getSelectedItem();
      total += 25 * quantity;
      t2 = 25*quantity;
    }
    if (item3CheckBox.isSelected()) {
      int quantity = (Integer)item3QuantityComboBox.getSelectedItem();
      total += 30 * quantity;
      t3 = 30*quantity;
    }
    if (item4CheckBox.isSelected()) {
        int quantity = (Integer)item4QuantityComboBox.getSelectedItem();
        total += 15 * quantity;
        t4 = 15*quantity;
    }
    if (item5CheckBox.isSelected()) {
        int quantity = (Integer)item5QuantityComboBox.getSelectedItem();
        total += 45 * quantity;
        t5 = 45*quantity;
    }
    item1Total.setText("₹"+t1);
    item2Total.setText("₹"+t2);
    item3Total.setText("₹"+t3);
    item4Total.setText("₹"+t4);
    item5Total.setText("₹"+t5);
    totalPriceLabel.setText("₹" + total);
    if(total!=0){ 
    }  
  }
  
  public static void main(String[] args) {
    ItemOrderFrame frame = new ItemOrderFrame();
    frame.setVisible(true);
  }
}

class NewFrame extends JFrame{ 
    public NewFrame(){  
      JButton b=new JButton("Thank you for your order"); 
      b.setBounds(30,40 ,30 ,40);
      add(b);
      b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        //     MainFrame frame= new MainFrame();
        //     //mainPanel.setVisible(false);
        //     frame.dispose();
        //     frame.setVisible(true);
               System.exit(0);
        }

    });
      setSize(300, 200);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
    }
}