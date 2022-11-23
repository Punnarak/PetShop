import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;
import javax.sound.sampled.*; // for sounds
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;  
import java.io.BufferedReader;

public class bank extends JFrame  implements KeyListener , ActionListener
{
  // components
  private JPanel con,control;
  private JLabel contentpane,mon,up;
  private JLabel shopee,tf,ff;
  private JCheckBox c1,c2,c3;
  private MyImageIcon interBG,a,ub;
  private MyImageIcon shop,foodfac,toyfac;
  private option  bb1,bb2,bb;
  private JButton backButton,okButton,buyButton;
  private Map bMapI;
  private JComboBox dewith;
  private JTextField income,deposit,struck,balance;
  private JTextField stuck;
  private Player me;
  private String in;
  protected String option,name;
  private int frameWidth = 1366, frameHeight = 768;
  protected  FileWriter meF; 
  protected  FileWriter meO;
  private Font pixel;

 public bank(Player use,String n,int b,int ss,int t1,int t3,int t4) {

    setTitle("bank");
    setBounds( 400, 200, frameWidth, frameHeight);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(0);
      }
    });
    me = use;
    name = n;
    con = (JPanel) getContentPane();
    con.setLayout(new BorderLayout());
    AddComponents(n, b, ss, t1, t3, t4);

    }
    
public void AddComponents(String n,int b,int ss,int t1,int t3,int t4) {
    
    interBG = new MyImageIcon("Lovely/Inside bank.jpg").resize(frameWidth, frameHeight);
    a = new MyImageIcon("Lovely/signb.jpg").resize(1366, 150);
    ub = new MyImageIcon("Lovely/upbanner.png").resize(1366, 150);
    shop = new MyImageIcon("Lovely/shop.PNG").resize(80, 60);
    foodfac = new MyImageIcon("Lovely/food.PNG").resize(80, 70);
    toyfac = new MyImageIcon("Lovely/toy.PNG").resize(80, 60);
    //Font font1 = new Font("DeJaVu Sans", Font.PLAIN, 20);
    //Font font1 = new Font("Consolas", Font.BOLD, 20);
    try{
        pixel = Font.createFont(Font.TRUETYPE_FONT, new File("Lovely/PixelMplus12-Regular.ttf")).deriveFont(20f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Lovely/PixelMplus12-Regular.ttf")));
    }catch(IOException | FontFormatException e)
    {
    
    }

    contentpane = new JLabel();
    contentpane.setIcon(interBG);
    contentpane.setLayout(null);
    
    mon = new JLabel();
    mon.setIcon(a);
    mon.setLayout(null);
    mon.setBounds(0,0,1366,150);
    mon.setVisible(false);

    up = new JLabel();
    up.setIcon(ub);
    up.setBounds(0,0,1366,150);
    up.setLayout(null);
    up.setVisible(false);

    shopee = new JLabel();
    shopee.setIcon(shop);
    shopee.setBounds(700,30,80,60);

    tf = new JLabel();
    tf.setIcon(toyfac);
    tf.setBounds(900,30,80,60);

    ff = new JLabel();
    ff.setIcon(foodfac);
    ff.setBounds(1100,30,80,70);
   
    String[] op = { "Deposit", "Withdraw"};

    dewith = new JComboBox(op);
    dewith.setFont(pixel);
    dewith.setBounds(500,25,150,50);

    balance = new JTextField(Integer.toString(me.getMBank()),10);
    //balance = new JTextField(Integer.toString(b),10);
    balance.setBounds(1100,20,100,50);
    balance.setFont(pixel);
    balance.setHorizontalAlignment(JTextField.RIGHT);
    balance.setEditable(false);
    
    struck = new JTextField(Integer.toString(me.getStruck()),10);
    //struck = new JTextField(Integer.toString(ss),10);
    struck.setBounds(1100,85,100,50);
    struck.setFont(pixel);
    struck.setHorizontalAlignment(JTextField.RIGHT);
    struck.setEditable(false);

    stuck = new JTextField(Integer.toString(me.getMBank()),10);
    stuck.setBounds(350,85,100,50);
    stuck.setFont(pixel);
    stuck.setHorizontalAlignment(JTextField.CENTER);
    stuck.setEditable(false);
    
    control = new JPanel();
    control.setBounds(0, 0, 1366, 150);

    control.add(mon);
    control.add(up);
    control.setLayout(new BorderLayout());

    income = new JTextField(10);
    income.setBounds(480,95,200,30);
    income.setFont(pixel);
    income.setHorizontalAlignment(JTextField.RIGHT);
    income.addKeyListener(this);

    okButton = new JButton("OK");
    okButton.setFont(pixel);
    okButton.addActionListener(this);
    
    c1 = new JCheckBox();
    c1.setOpaque(false);
    c1.setBounds(700,100,40,40);
    if(me.getB1()==1)
    {
      c1.setVisible(false);
    }
   
    c2 = new JCheckBox();
    c2.setOpaque(false);
    c2.setBounds(900,100,40,40);
    if(me.getB3()==1)
    {
      c2.setVisible(false);
    }
    
    c3 = new JCheckBox();
    c3.setOpaque(false);
    c3.setBounds(1100,100,40,40);
    if(me.getB4()==1)
    {
      c3.setVisible(false);
    }
    

    buyButton = new JButton(new MyImageIcon("Lovely/buybtn.png").resize(100,50));
    buyButton.addActionListener(e -> handleOptions(c1,c2,c3));

    bb = new option("Lovely/bb.png",100,100,null,null,"bb","Lovely/bb2.png");
    bb.setPlayer(me);
    bb.setMoveConditions(1200, 200, true, true);  // move conditions & initial position

    bb1 = new option("Lovely/blueboy.PNG",140,140,mon,up,"bb1","null");
    bb1.setMoveConditions(190, 295, true, true);  // move conditions & initial position
    
    bb2 = new option("Lovely/orangeboy.PNG",140,140,up,mon,"bb2","null");
    bb2.setMoveConditions(420, 295, true, true);  // move conditions & initial position
  
    backButton = new JButton(new MyImageIcon("Lovely/backB.png").resize(200,50));
    backButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          //  hitSound.playOnce();
           setVisible(false);
           bMapI = new Map(me,n, b, ss, me.getB1(), me.getB3(), me.getB4());
           bMapI.setVisible(true);
        
      }
    });
    backButton.setBounds(20,668,200,50);
    okButton.setBounds(650,25,100,50);
    buyButton.setBounds(1200,40,100,50);

    mon.add(income);
    mon.add(okButton);
    mon.add(dewith);
    mon.add(struck);
    mon.add(balance);
    
    // up.add();
    up.add(stuck);
    up.add(shopee);
    up.add(tf);
    up.add(ff);
    up.add(c1);
    up.add(c2);
    up.add(c3);
    up.add(buyButton);

    
    con.add(backButton);
    con.add(bb);
    con.add(bb1);
    con.add(bb2);
    con.add(control);
    con.add(contentpane,BorderLayout.CENTER);
    repaint();
  
    validate();
  }

//  public static void main(String[] args) {
//
//    new bank();
//
//  }
 private void handleOptions(JCheckBox ch1,JCheckBox ch2,JCheckBox ch3)
 {
   int price = 0;
   int check1 = me.getB1();
   int check2 = me.getB3();
   int check3 = me.getB4();
   
   boolean u1 = false;
   boolean u2 = false;
   boolean u3 = false;

   try
   {
   meO = new FileWriter(new File (name+"O.txt"),false);

   /*int price = 0;
   int check1 = me.getB1();
   int check2 = me.getB3();
   int check3 = me.getB4();
   
   boolean u1 = false;
   boolean u2 = false;
   boolean u3 = false;*/
   
   if(check1==1)
   {
     ch1.setVisible(false);
   }
   if(check2==1)
   {
     ch2.setVisible(false);
   }
   if(check3==1)
   {
     ch3.setVisible(false);
   }

   if(ch1.isSelected() && check1 != 1)
   {
     price += 100;
     u1 = true;

   }
   if(ch2.isSelected() && check2 != 1)
   {
     price += 200;
     u2 = true;
   }
   if(ch3.isSelected() && check3 != 1)
   {
     price += 300;
     u3 = true;
   }

   if(u1==false && u2==false && u3==false)
   {
     JOptionPane.showMessageDialog(null,"Pick first","Transaction",JOptionPane.PLAIN_MESSAGE);
   }
   else
   {
     if(price <= me.getMBank())
    {
      me.updateMoney(me.getMBank() - price);
      JOptionPane.showMessageDialog(null,"Complete :)","Transaction",JOptionPane.PLAIN_MESSAGE);
      stuck.setText(Integer.toString(me.getMBank()));
      balance.setText(Integer.toString(me.getMBank()));
      struck.setText(Integer.toString(me.getStruck()));
    }
    else if(price > me.getMBank())
    {
      JOptionPane.showMessageDialog(null,"You don't have enough money in your account.","Transaction",JOptionPane.PLAIN_MESSAGE);

    if(ch1.isSelected())
    {
     u1 = false;
     ch1.setSelected(false);
    }
    if(ch2.isSelected())
    {
     u2 = false;
     ch2.setSelected(false);
    }
    if(ch3.isSelected() && check3 != 1)
    {
     u3 = false;
     ch3.setSelected(false);
    }
    
    }
    
    if(u1==true)
    {
      me.updateB1();
    }
    if(u2==true)
    {
      me.updateB3();
    }
    if(u3==true)
    {
      me.updateB4();
    }

    System.out.println(me.getB1());
    System.out.println(me.getB3());
    System.out.println(me.getB4());

   if(me.getB1()==1)
   {
     ch1.setVisible(false);
   }
   if(me.getB3()==1)
   {
     ch2.setVisible(false);
   }
   if(me.getB4()==1)
   {
     ch3.setVisible(false);
   }

   }
  //   if(price <= me.getMBank())
  //   {
  //     me.updateMoney(me.getMBank() - price);
  //     JOptionPane.showMessageDialog(null,"Complete :)","Transaction",JOptionPane.PLAIN_MESSAGE);
  //     stuck.setText(Integer.toString(me.getMBank()));
  //     balance.setText(Integer.toString(me.getMBank()));
  //     struck.setText(Integer.toString(me.getStruck()));
  //   }
  //   else if(price > me.getMBank())
  //   {
  //     JOptionPane.showMessageDialog(null,"You don't have enough money in your account.","Transaction",JOptionPane.PLAIN_MESSAGE);

  //   if(c1.isSelected())
  //   {
  //    u1 = false;
  //   }
  //   if(c2.isSelected())
  //   {
  //    u2 = false;
  //   }
  //   if(c3.isSelected() && check3 != 1)
  //   {
  //    u3 = false;
  //   }
    
  //   }
    
  //   if(u1==true)
  //   {
  //     me.updateB1();
  //   }
  //   if(u2==true)
  //   {
  //     me.updateB3();
  //   }
  //   if(u3==true)
  //   {
  //     me.updateB4();
  //   }

  //   System.out.println(me.getB1());
  //   System.out.println(me.getB3());
  //   System.out.println(me.getB4());

  //  if(me.getB1()==1)
  //  {
  //    c1.setVisible(false);
  //  }
  //  if(me.getB3()==1)
  //  {
  //    c2.setVisible(false);
  //  }
  //  if(me.getB4()==1)
  //  {
  //    c3.setVisible(false);
  //  }

    meO.write(me.getName()+", "+me.getMBank()+", "+me.getStruck()+", "+me.getB1()+", "+me.getB3()+", "+me.getB4()+"\r\n"); 
    meO.close();
    }catch(Exception e){}
 }

 public void actionPerformed(ActionEvent e)
      {
        try{
          meO = new FileWriter(new File (name+"O.txt"),false);
          meF = new FileWriter(new File (name+"B.txt"),true); 
          
   if(me.getB1()==1)
   {
     c1.setVisible(false);
   }
   if(me.getB3()==1)
   {
     c2.setVisible(false);
   }
   if(me.getB4()==1)
   {
     c3.setVisible(false);
   }
          
        option = (String)dewith.getSelectedItem();
        if(option.equals("Deposit"))
        { 
        
          System.out.println(option);
          System.out.println(in);
          if(Integer.parseInt(in) > me.getStruck())
          {
          JOptionPane.showMessageDialog(null,"You don't have enough money right now.","Deposit Denied",JOptionPane.PLAIN_MESSAGE);
          }
          else
          {
          me.updateMBank(option,Integer.parseInt(in));
          System.out.printf("%d\n",me.getMBank());
          meF.write("\t\t"+in+"\t\t-----------------\r\n"); 
          }
          income.setText("");
          
          balance.setText(Integer.toString(me.getMBank()));
          struck.setText(Integer.toString(me.getStruck()));
          stuck.setText(Integer.toString(me.getMBank()));

        }
        else if(option.equals("Withdraw"))
        {
         
          System.out.println(me);
          System.out.println(option);
          System.out.println(in);
          if(Integer.parseInt(in) > me.getMBank())
          {
          JOptionPane.showMessageDialog(null,"You don't have enough money in your account.","Withdraw Denied",JOptionPane.PLAIN_MESSAGE);
          }
          else
          {
          me.updateMBank(option,Integer.parseInt(in));
          System.out.printf("%d\n",me.getMBank());
          meF.write("\t\t---------------  \t\t"+in+"\r\n"); 
          }
          income.setText("");
          
          balance.setText(Integer.toString(me.getMBank()));
          struck.setText(Integer.toString(me.getStruck()));
          stuck.setText(Integer.toString(me.getMBank()));
        }
      
          meO.write(me.getName()+", "+me.getMBank()+", "+me.getStruck()+", "+me.getB1()+", "+me.getB3()+", "+me.getB4()+"\r\n"); 
          meO.close();
          meF.close();
           }catch(Exception e1){}
        } 
   public void keyTyped(KeyEvent e){ 
     
 }
 
 public void keyPressed(KeyEvent e){
     
 }

 public void keyReleased(KeyEvent e){
     in = income.getText();
 }
}

class option extends cb implements MouseListener,MouseMotionListener
{
    private MySoundEffect hitSound, themeSound;
    private JLabel set ,unset;
    private String Name; 
    private Player p;
    private String transaction;

    public option(String file1, int w, int h,JLabel Dora, JLabel dore,String n,String file2)				
    {

        Name = n;
        addMouseListener(this);
        addMouseMotionListener(this);
        width = w; height = h; 
        set = Dora;
        unset = dore;
        iconMode1 = new MyImageIcon(file1).resize(width, height);
        if(file2 != "null")
        {
        iconMode2 = new MyImageIcon(file2).resize(width, height);
        }else{
          iconMode2 = new MyImageIcon(file1).resize(width, height);
        }

        
	      setHorizontalAlignment(JLabel.CENTER);
	      setIcon(iconMode1);
        hitSound = new MySoundEffect("Lovely/beep.wav");
        themeSound = new MySoundEffect("Lovely/theme.wav");
        
    }    
    public void setMoveConditions(int x, int y, boolean hm, boolean vm)
    {
      
              curX = x; curY = y;
	      setBounds(curX, curY, width, height);
  
    }
   public void mousePressed(MouseEvent fiwh){
       
   }
   public void mouseReleased(MouseEvent fiwh){
       
   }
   public void mouseEntered(MouseEvent fiwh){
    
       setCursor(new Cursor(Cursor.HAND_CURSOR));
       switchIcon();
           
   }
   public void mouseExited(MouseEvent fiwh){

       resetIcon();

   }
   public void mouseClicked(MouseEvent fiwh){
      if(Name == "bb")
       {
        JTextArea tarea = new JTextArea();
        tarea.setEditable(false);
        
        try
        {
        //FileReader fr = new FileReader(p.getName()+"B.txt");
        //BufferReader br = new BufferReader(fr);
        //tarea.read(br, null);
        BufferedReader reader = 
        new BufferedReader(new FileReader(p.getName()+"B.txt"));
        tarea.read(reader, null);
        reader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JFrame b = new JFrame("book bank");
        //JTextArea tarea = new JTextArea();
        b.setBounds( 400, 200, 500, 500);
        b.setResizable(false);
        b.setVisible(true);
        b.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        b.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
         
            }
        });
        
        b.getContentPane().add(tarea,BorderLayout.CENTER);
        
       }
       if(Name == "bb1")
       {
         
         set.setVisible(true);
         unset.setVisible(false);

       }
       if(Name == "bb2")
       {
          set.setVisible(true);
          unset.setVisible(false);

       }
        
   }
   public void mouseMoved(MouseEvent fiwh){
     
   }
   public void mouseDragged(MouseEvent fiwh){
       
   
   }

   public void setPlayer(Player q)
   {
       p = q;
   }
    
}