import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.*;
import javax.sound.sampled.*; // for sounds
import java.util.*;

public class shop extends JFrame 
{
    
  // shop Frame
  protected JLabel contentpane;
  protected JPanel pick;
  private MyImageIcon interBG; 
  protected JTextField name,smoney;
  private int frameWidth = 1366, frameHeight = 768;
  
  //next Frame
  private Map MapI;
  
  private JButton backButton;
  protected Player me;
  protected String Name;
  
  //pet
  protected items i1,i2,i3,s,i4,i5,i6,pro;
  
  //frame snack
  protected int ws = 500, hs = 500;
  
  //snack cat
  protected JLabel sc1,sc2,sc3,sc4,sc5;
  //snack dog
  protected JLabel sd1,sd2,sd3,sd4,sd5;
  //snack rabbit
  protected JLabel sr1,sr2,sr3,sr4,sr5;
  
  //toy cat
  protected JLabel sct1,sct2,sct3,sct4,sct5;
  //toy dog
  protected JLabel sdt1,sdt2,sdt3,sdt4,sdt5;
  //toy rabbit
  protected JLabel srt1,srt2,srt3,srt4,srt5;
  
  //checkbox toy cat
  protected JCheckBox ct1,ct2,ct3,ct4,ct5;
  //checkbox toy dog
  protected JCheckBox dt1,dt2,dt3,dt4,dt5;  
   //checkbox toy rabbit
  protected JCheckBox rt1,rt2,rt3,rt4,rt5;
  
  //con of toy cat
  protected JLabel consct;
  //con of toy dog
  protected JLabel consdt;
  //con of toy rabbit
  protected JLabel consrt;
  
  //stock snack cat
  protected JFrame sc;
  protected JPanel stocksc;
  protected JLabel consc;
  protected JCheckBox c1,c2,c3,c4,c5;
  protected MyImageIcon bgC;
  
  //stock snack dog
  protected JFrame sd;
  protected JPanel stocksb;
  protected JLabel consd;
  protected JCheckBox d1,d2,d3,d4,d5;
  protected MyImageIcon bgD;
  
  //stock snack rabbit
  protected JFrame sr;
  protected JPanel stocksr;
  protected JLabel consr;
  protected JCheckBox r1,r2,r3,r4,r5;
  protected MyImageIcon bgR;
    
  //user object 
  protected int bb,ss,tt1,tt3,tt4;

  //pro
  protected items ban;
 
  //food bucket cat;
  protected int []scb = {0,0,0,0,0};
  //food bucket dog
  protected int []sdb = {0,0,0,0,0};
  //food bucket rabbit
  protected int []srb = {0,0,0,0,0};
  
  //food bucket cat;
  protected int []scbt = {0,0,0,0,0};
  //food bucket dog
  protected int []sdbt = {0,0,0,0,0};
  //food bucket rabbit
  protected int []srbt = {0,0,0,0,0};
  
  //food ,toy frame
  protected JFrame food ,toy;
 
  //thread c
  protected Customer c  = new Customer();
  protected JButton cinButton;
  protected int connum = 1;
  
  protected MySoundEffect hitSound = new MySoundEffect("Lovely/beep.wav");
  protected MySoundEffect hitSoundd = new MySoundEffect("Lovely/drop.wav");
  protected MySoundEffect hitSoundK = new MySoundEffect("Lovely/Kaching.wav");
  protected MySoundEffect hitSoundC = new MySoundEffect("Lovely/doorbell.wav");
  protected MySoundEffect hitSoundN = new MySoundEffect("Lovely/oof.wav");
  protected MySoundEffect hitSoundW = new MySoundEffect("Lovely/wrong.wav");
   
   protected shop m;
  
//Shop page
public shop(Player use,String n,int b,int s,int t1,int t3,int t4) {

    setTitle("shop");
    setBounds( 100, 40, frameWidth, frameHeight);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {

          try{
              PrintWriter mef = new PrintWriter(new File (me.getName()+"O.txt")); 
              mef.printf("%s, %d, %d, %d, %d, %d\r\n",me.getName(),me.getMBank(),me.getStruck(),me.getB1(),me.getB3(),me.getB4());
              mef.close();
          }catch(Exception e1){
              
          }
            dispose();
            new Map(me,n, b, ss, me.getB1(), me.getB3(), me.getB4());
      }
    });
    
    me = use; 
    Name = n;
    bb = b;
    ss = s;
    tt1 = t1;
    tt3 = t3;
    tt4 = t4;
    
    AddComponents();

    }   
public void AddComponents() {
    
    //shop con
    setContentPane(contentpane = new JLabel());
    interBG = new MyImageIcon("Lovely/Ishop.jpg");
    contentpane.setIcon(interBG.resize(frameWidth, frameHeight));
    contentpane.setLayout(null);
   
    m = this;
   //pet
   i1 = new items("Lovely/p1.png",150,150,this,"i1","Lovely/p1.1.png",me);
   i1.setMoveConditions(700, 420);  
   i2 = new items("Lovely/p2.png",100,100,this,"i2","Lovely/p2.1.png",me);
   i2.setMoveConditions(1100, 450);  
   i3 = new items("Lovely/p3.png",150,150,this,"i3","Lovely/p3.2.png",me);
   i3.setMoveConditions(800, 420);  
   i4 = new items("Lovely/p4.png",100,100,this,"i4","Lovely/p4.2.png",me);
   i4.setMoveConditions(900, 220);  
   i5 = new items("Lovely/p5.png",50,100,this,"i5","Lovely/p5.2.png",me);
   i5.setMoveConditions(1100, 210);  
   i6 = new items("Lovely/p6.PNG",60,100,this,"i6","Lovely/p6.2.PNG",me);
   i6.setMoveConditions(1000, 210);  


    
   //cashier
   s = new items("Lovely/s.PNG",1366,200,this,"s","null",me);
   s.setMoveConditions(0, 600);  // move conditions & initial position
   
   //set drag bound
   i1.setDropLabel(s);
   i2.setDropLabel(s);
   i3.setDropLabel(s);
   i4.setDropLabel(s);
   i5.setDropLabel(s);
   i6.setDropLabel(s);
   s.setDropLabel(s);
  
   if(tt4  == 1){
   
    //sign food  
    JButton signf = new JButton();
    signf.setBounds(0,375,50,100);
    MyImageIcon sf = new MyImageIcon("Lovely/signf.png");
    signf.setIcon(sf.resize(50, 100));
    contentpane.add(signf);
    signf.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            hitSound.playOnce();
            foodstock();
        }
    });
     
   }
   if(tt3  == 1){
   
    //toy button
    JButton signt = new JButton();
    signt.setBounds(0,250,50,100);
    MyImageIcon sb = new MyImageIcon("Lovely/signt.png");
    signt.setIcon(sb.resize(50, 100));
    contentpane.add(signt);
    signt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            hitSound.playOnce();
            toystock();
        }
    });
 
   }
   
    //Profile on left above
    pro = new items("Lovely/Me.png",120,120,this,"pro","Lovely/Me2.png",me);
    pro.setMoveConditions(0, 0);  // move conditions & initial position
    ban = new items("Lovely/Banner.png",400,120,this,"s","null",me);
    ban.setMoveConditions(0, 0);  // move conditions & initial position 
    
    pro.setDropLabel(pro);
    ban.setDropLabel(ban);
    
    //show my name
    name = new JTextField(Name,10);
    name.setBounds(150,25,200,30);
    name.setFont(new Font("Qwigley",Font.PLAIN,20));
    name.setHorizontalAlignment(JTextField.CENTER);
    name.setEditable(false);
    
    //Show my money
    smoney = new JTextField(Integer.toString(me.getStruck()),10);
    smoney.setFont(new Font("DeJaVu Sans",Font.PLAIN,20));
    smoney.setBounds(150,70,200,25);
    smoney.setHorizontalAlignment(JTextField.RIGHT);
    smoney.setEditable(false);
    
    backButton = new JButton(new MyImageIcon("Lovely/backB.png").resize(200,50)); 
    backButton.setBounds(1130,668,200,50);
    backButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
            hitSound.playOnce();
          try{
              PrintWriter mef = new PrintWriter(new File (me.getName()+"O.txt")); 
              mef.printf("%s, %d, %d, %d, %d, %d\r\n",me.getName(),me.getMBank(),me.getStruck(),me.getB1(),me.getB3(),me.getB4());
              mef.close();
          }catch(Exception e1){
              
          }
          if(MapI == null){
           MapI = new Map(me,Name, bb, ss, tt1, tt3, tt4);
           MapI.setVisible(true);
           setVisible(false);  
          }
           
        
      }
    });
    
    //call customer
    cinButton = new JButton("Welcome"); 
    cinButton.setBounds(150,668,100,25);
    contentpane.add(cinButton);
    cinButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {    
      hitSoundC.playOnce();

      System.out.println("new");
      c = new Customer();
      if(tt3 == 1){
          c.toy =1;
      }
      if(tt4 == 1){
          c.food= 1;
      }
      c.setc(m);
      c.setp(me);
      c.start();
      c.Conc = new JLabel();
      c.Conc.setBounds(0,0,1366,768);
      contentpane.add(c.Conc);// add conc
      contentpane.add(s); //addButton
      contentpane.repaint();
      }
    });
       
    //bucket
    pick = new JPanel();
    pick.setBackground(Color.YELLOW);
    pick.setBounds(450,600,400,200);
    pick.addContainerListener(new MyContainerListener());
    pick.setLayout(new FlowLayout());
    
  
   contentpane.add(backButton,BorderLayout.CENTER); //addButton
 
   contentpane.add(i1); //addpet
   contentpane.add(i2); //addpet
   contentpane.add(i3); //addpet
   contentpane.add(i4); //addpet
   contentpane.add(i5); //addpet
   contentpane.add(i6); //addpet
  
   contentpane.add(pick);
   
   contentpane.add(smoney); //addJTextField show name 
   contentpane.add(name); //addJTextField show name 
   contentpane.add(pro); //addprofile decorate 
   contentpane.add(ban); 
   
    validate();
    repaint();
    
  }    
    public void foodstock(){
    
    if(food == null){
        
    food = new JFrame("FOOD");
    food.setBounds(20,150,500,500);
    food.setResizable(false);
    food.setVisible(true);
    food.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    food.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
            food = null; 
            
            pick.removeAll();
            pick.validate();
            pick.repaint();
      }
    });
    
    MyImageIcon shelf = new MyImageIcon("Lovely/shelf.jpg").resize(500,500);
    JLabel confood = new JLabel();
    food.setContentPane(confood = new JLabel());
    confood.setIcon(shelf);
    confood.setLayout(null);
    
           //cat shelf
           consc = new JLabel();
           consc.setBounds(0,0,500,500);
           consc.setLayout(null);
           
           sc1 = new JLabel();
           MyImageIcon bsc1 = new MyImageIcon("Lovely/sc1.png").resize(100,100);
           sc1.setIcon(bsc1);
           sc1.setBounds(50, 50,100,100);
           
           sc2 = new JLabel();
           MyImageIcon bsc2 = new MyImageIcon("Lovely/sc2.png").resize(100,100);
           sc2.setIcon(bsc2);
           sc2.setBounds(200, 50,100,100);
           
           sc3 = new JLabel();
           MyImageIcon bsc3 = new MyImageIcon("Lovely/sc3.png").resize(150,150);
           sc3.setIcon(bsc3);
           sc3.setBounds(20, 170,150,150);
           
           sc4 = new JLabel();
           MyImageIcon bsc4 = new MyImageIcon("Lovely/sc4.png").resize(150,150);
           sc4.setIcon(bsc4);
           sc4.setBounds(170, 170,150,150);
           
           sc5 = new JLabel();
           MyImageIcon bsc5 = new MyImageIcon("Lovely/sc5.png").resize(150,150);
           sc5.setIcon(bsc5);
           sc5.setBounds(320, 170,150,150);
           
           c1 = new JCheckBox();
           c1.setBounds(85,150,20,20);
           c1.setOpaque(false);
           c1.addItemListener(new ItemListener(){
               
               JLabel p1 = new JLabel(new MyImageIcon("Lovely/sc1.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   boolean check = !c1.isSelected();
                  
                   if(e.getStateChange() == ItemEvent.SELECTED){
                       
                        System.out.println(check);
                        scb[0] = 1;
                        hitSoundd.playOnce();
                        pick.add(p1);

                   }
                   else{
                       
                       System.out.println(check);
                       scb[0]=0;
                       pick.remove(p1);
                   
   
                   }
                
                   
                       pick.validate();
                       pick.repaint();
               }
               
           });

           c2 = new JCheckBox();
           c2.setBounds(235,150,20,20);
           c2.setOpaque(false);
           c2.addItemListener(new ItemListener(){
               
               JLabel p2 = new JLabel(new MyImageIcon("Lovely/sc2.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       scb[1] = 1;
                       hitSoundd.playOnce();
                       pick.add(p2);
    

                   }else{
                       scb[1] = 0;
                       pick.remove(p2);
                      
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           c3 = new JCheckBox();
           c3.setBounds(85,310,20,20);
           c3.setOpaque(false);
           c3.addItemListener(new ItemListener(){
               
               JLabel p3 = new JLabel(new MyImageIcon("Lovely/sc3.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       scb[2] = 1;
                       hitSoundd.playOnce();
                       pick.add(p3);
 
                   }else{
                       scb[2] = 0;
                       pick.remove(p3);
                   
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           c4 = new JCheckBox();
           c4.setBounds(235,310,20,20);
           c4.setOpaque(false);
           c4.addItemListener(new ItemListener(){
               
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sc4.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       scb[3] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                      scb[3] = 0;
                       pick.remove(p4);
                   }
                        pick.validate();
                       pick.repaint();
               }
               
           });
           
           c5 = new JCheckBox();
           c5.setBounds(385,310,20,20);
           c5.setOpaque(false);
           c5.addItemListener(new ItemListener(){
               
               JLabel p5 = new JLabel(new MyImageIcon("Lovely/sc5.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                        
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       scb[4] = 1;
                       hitSoundd.playOnce();
                       pick.add(p5);

                  
                   }else{
                       scb[4] = 0;                      
                       pick.remove(p5);
           
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
          
           consc.add(sc1);
           consc.add(sc2);
           consc.add(sc3);
           consc.add(sc4);
           consc.add(sc5);
           
           consc.add(c1);
           consc.add(c2);
           consc.add(c3);
           consc.add(c4);
           consc.add(c5);
           
           // dog shelf
           consd = new JLabel();
           consd.setBounds( 0, 0, 500, 500);
           consd.setVisible(false);
           consd.setLayout(null);
                     
           sd1 = new JLabel();
           MyImageIcon bsd1 = new MyImageIcon("Lovely/sd1.png").resize(100,100);
           sd1.setIcon(bsd1);
           sd1.setBounds(50, 50,100,100);
           
           sd2 = new JLabel();
           MyImageIcon bsd2 = new MyImageIcon("Lovely/sd2.png").resize(100,100);
           sd2.setIcon(bsd2);
           sd2.setBounds(200, 50,100,100);
           
           sd3 = new JLabel();
           MyImageIcon bsd3 = new MyImageIcon("Lovely/sd3.png").resize(150,150);
           sd3.setIcon(bsd3);
           sd3.setBounds(20, 170,150,150);
           
           sd4 = new JLabel();
           MyImageIcon bsd4 = new MyImageIcon("Lovely/sd4.png").resize(150,150);
           sd4.setIcon(bsd4);
           sd4.setBounds(170, 170,150,150);
           
           sd5 = new JLabel();
           MyImageIcon bsd5 = new MyImageIcon("Lovely/sd5.png").resize(150,150);
           sd5.setIcon(bsd5);
           sd5.setBounds(320, 170,150,150);
                     
           d1 = new JCheckBox();
           d1.setBounds(85,150,20,20);
           d1.setOpaque(false);
           d1.addItemListener(new ItemListener(){
               
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sd1.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       sdb[0] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                      sdb[0] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           d2 = new JCheckBox();
           d2.setBounds(235,150,20,20);
           d2.setOpaque(false);
           d2.addItemListener(new ItemListener(){
               
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sd2.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       sdb[1] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       sdb[1] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           d3 = new JCheckBox();
           d3.setBounds(85,310,20,20);
           d3.setOpaque(false);
           d3.addItemListener(new ItemListener(){
               
                JLabel p4 = new JLabel(new MyImageIcon("Lovely/sd3.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       sdb[2] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       sdb[2] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           d4 = new JCheckBox();
           d4.setBounds(235,310,20,20);
           d4.setOpaque(false);
           d4.addItemListener(new ItemListener(){
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sd4.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       sdb[3] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                      sdb[3] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           d5 = new JCheckBox();
           d5.setBounds(385,310,20,20);
           d5.setOpaque(false);
           d5.addItemListener(new ItemListener(){
               
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sd5.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       sdb[4] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       sdb[4] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           consd.add(sd1);
           consd.add(sd2);
           consd.add(sd3);
           consd.add(sd4);
           consd.add(sd5);
           
           consd.add(d1);
           consd.add(d2);
           consd.add(d3);
           consd.add(d4);
           consd.add(d5);
           
           //rabbit shelf
           consr = new JLabel();
           consr.setBounds( 0, 0, 500, 500);
           consr.setVisible(false);
           consr.setLayout(null);

           sr1 = new JLabel();
           MyImageIcon bsr1 = new MyImageIcon("Lovely/sr1.png").resize(100,100);
           sr1.setIcon(bsr1);
           sr1.setBounds(50, 50,100,100);
           
           sr2 = new JLabel();
           MyImageIcon bsr2 = new MyImageIcon("Lovely/sr2.png").resize(100,100);
           sr2.setIcon(bsr2);
           sr2.setBounds(200, 50,100,100);
           
           sr3 = new JLabel();
           MyImageIcon bsr3 = new MyImageIcon("Lovely/sr3.png").resize(150,150);
           sr3.setIcon(bsr3);
           sr3.setBounds(20, 170,150,150);
           
           sr4 = new JLabel();
           MyImageIcon bsr4 = new MyImageIcon("Lovely/sr4.png").resize(150,150);
           sr4.setIcon(bsr4);
           sr4.setBounds(170, 170,150,150);
           
           sr5 = new JLabel();
           MyImageIcon bsr5 = new MyImageIcon("Lovely/sr5.png").resize(150,150);
           sr5.setIcon(bsr5);
           sr5.setBounds(320, 170,150,150);
           
           r1 = new JCheckBox();
           r1.setBounds(85,150,20,20);
           r1.setOpaque(false);
           r1.addItemListener(new ItemListener(){
               
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sr1.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       srb[0] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       srb[0] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           r2 = new JCheckBox();
           r2.setBounds(235,150,20,20);
           r2.setOpaque(false);
           r2.addItemListener(new ItemListener(){
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sr2.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       srb[1] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       srb[1] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           r3 = new JCheckBox();
           r3.setBounds(85,310,20,20);
           r3.setOpaque(false);
           r3.addItemListener(new ItemListener(){
              JLabel p4 = new JLabel(new MyImageIcon("Lovely/sr3.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       srb[2] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       srb[2] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           r4 = new JCheckBox();
           r4.setBounds(235,310,20,20);
           r4.setOpaque(false);
           r4.addItemListener(new ItemListener(){
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sr4.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       srb[3] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       srb[3] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           r5 = new JCheckBox();
           r5.setBounds(385,310,20,20);
           r5.setOpaque(false);
           r5.addItemListener(new ItemListener(){
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/sr5.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       srb[4] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       srb[4] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           consr.add(sr1);
           consr.add(sr2);
           consr.add(sr3);
           consr.add(sr4);
           consr.add(sr5);
           
           consr.add(r1);
           consr.add(r2);
           consr.add(r3);
           consr.add(r4);
           consr.add(r5);
           
    JButton okButton = new JButton("OK");
    okButton.setBounds(200,375,100,50);
    confood.add(okButton);
    okButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             
            //cat
            if(scb[0] == 1 ){
                
                if(c.r == 6 && c.c1==1){
                  
                   hitSoundK.playOnce();
                   c.ch1.switchIcon();
                   c.c1 -= 1;
                   c.i +=100;   
                   System.out.println("pick --> c1 --> "+c.c1);
                   me.updateStruck("Withdraw", 30);
                   System.out.println(me.getStruck());
                   smoney.setText(Integer.toString(me.getStruck()));  
                  
                }else{
                   hitSoundW.playOnce();   
                }
                   c1.setSelected(false);
                   contentpane.repaint();
              
            }
            if(scb[1] == 1 ){
              
                if(c.r == 6&& c.c2 == 1){
                  
                 hitSoundK.playOnce();
                 c.ch2.switchIcon();    
                 c.c2 -= 1;
                 c.i +=100;
                 System.out.println("pick --> c2 --> "+c.c2);
                 me.updateStruck("Withdraw", 30);
                 System.out.println(me.getStruck());
                 smoney.setText(Integer.toString(me.getStruck()));  
              
                }else{
                 hitSoundW.playOnce();
                }
              
                 c2.setSelected(false);
                 contentpane.repaint();
              
            }
            if(scb[2] == 1){
                
                if(c.r == 6 && c.c3 == 1){
                  
                  hitSoundK.playOnce();
                  c.ch3.switchIcon();
                  c.c3 -= 1;
                  c.i +=100;   
                  System.out.println("pick --> c3 --> "+c.c3);
                  me.updateStruck("Withdraw", 20);
                  System.out.println(me.getStruck());
                  smoney.setText(Integer.toString(me.getStruck()));
                
                }else{
                  
                  hitSoundW.playOnce();  
                  
                } 
             
                  c3.setSelected(false);
                  contentpane.repaint();
                  
            }
            if(scb[3] == 1 ){
              
                if(c.r == 7&& c.c4 == 1){
                    
                    hitSoundK.playOnce();
                    c.ch1.switchIcon();
                    c.c4 -= 1;
                    c.i +=100;   
                    System.out.println("pick --> c4 --> "+c.c4);
                    me.updateStruck("Withdraw", 20);
                    System.out.println(me.getStruck());
                    smoney.setText(Integer.toString(me.getStruck()));
                 
                }else{
                    
                    hitSoundW.playOnce(); 
                    
                }
              
                    c4.setSelected(false);
                    contentpane.repaint();
              
            }
            if(scb[4] == 1 ){
              
                if(c.r == 7&& c.c5 == 1){
                    
                    hitSoundK.playOnce();
                    c.ch2.switchIcon();
                    c.c5 -= 1;
                    c.i +=100;
                    System.out.println("pick --> c5 --> "+c.c5);
                    me.updateStruck("Withdraw", 20);
                    System.out.println(me.getStruck());
                    smoney.setText(Integer.toString(me.getStruck()));
              
              }else{
                    
                    hitSoundW.playOnce();
                
              }
              
                    c5.setSelected(false);
                     contentpane.repaint();
              
            }
            
            //dog
            if(sdb[0] == 1 ){
                
                if(c.r == 7&& c.d1 == 1){
                  
                    hitSoundK.playOnce();
                    c.ch3.switchIcon();
                    c.d1 -= 1;
                    c.i +=100;
                    System.out.println("pick --> d1 --> "+c.d1);
                    me.updateStruck("Withdraw", 30);
                    System.out.println(me.getStruck());
                    smoney.setText(Integer.toString(me.getStruck()));
              
                }else{
                    
                 hitSoundW.playOnce(); 
                 
                }
             
                 d1.setSelected(false);
                 contentpane.repaint();
              
            }
            if(sdb[1] == 1 ){
              
              if(c.r == 7&& c.d2 == 1){
                  
                  hitSoundK.playOnce();
                  c.ch4.switchIcon();
                  c.d2 -= 1;
                  c.i +=100;
                  System.out.println("pick --> d2 --> "+c.d2);
                  me.updateStruck("Withdraw", 30);
                  System.out.println(me.getStruck());
                  smoney.setText(Integer.toString(me.getStruck())); 
                  
              }else{
                  
                  hitSoundW.playOnce(); 
                  
              }
              
                  d2.setSelected(false);
                  contentpane.repaint();
              
            }
            if(sdb[2] == 1 ){
                
              if(c.r == 8&& c.d3 == 1){
                  
                hitSoundK.playOnce();
                c.ch1.switchIcon();
                c.d3 -= 1;
                c.i +=100;
                System.out.println("pick --> d3 --> "+c.d3);
                me.updateStruck("Withdraw", 20);
                System.out.println(me.getStruck());
                smoney.setText(Integer.toString(me.getStruck()));   
                
              }else{
                  
                hitSoundW.playOnce();
                
              }
              
                d3.setSelected(false);
                contentpane.repaint();
              
            }
            if(sdb[3] == 1 ){
              
                if(c.r == 8&& c.d4 == 1){
                    
                hitSoundK.playOnce();
                c.ch2.switchIcon();
                c.d4 -= 1;
                c.i +=100;
                System.out.println("pick --> d4 --> "+c.d4);
                me.updateStruck("Withdraw", 20);
                System.out.println(me.getStruck());
                smoney.setText(Integer.toString(me.getStruck()));  
                }else{
                    
                  hitSoundW.playOnce();  
                  
                }
              
                d4.setSelected(false);
                contentpane.repaint();
              
            }
            if(sdb[4] == 1 ){
                
                if(c.r == 8&& c.d5 == 1){
                  
                 hitSoundK.playOnce();
                 c.ch3.switchIcon();    
                 c.d5 -= 1;
                 c.i +=100;
                 System.out.println("pick --> d5 --> "+c.d5);
                 me.updateStruck("Withdraw", 20);
                 System.out.println(me.getStruck());
                 smoney.setText(Integer.toString(me.getStruck())); 
                 
                }else{
                  
                hitSoundW.playOnce();  
                
                }  
              
                d5.setSelected(false);
                contentpane.repaint();
              
            }
            
            //rabbit
            if(srb[0] == 1 ){
              
                if(c.r == 8&& c.r1 == 1){
                    
                    hitSoundK.playOnce();
                    c.ch4.switchIcon();
                    c.r1 -= 1;
                    c.i +=100;
                    System.out.println("pick --> r1 --> "+c.r1);
                    me.updateStruck("Withdraw", 30);
                    System.out.println(me.getStruck());
                    smoney.setText(Integer.toString(me.getStruck()));
                    
                }else{
                    
                   hitSoundW.playOnce(); 
                }
              
                   r1.setSelected(false);
                   contentpane.repaint();
              
            }
            if(srb[1] == 1 ){
              
                if(c.r == 9&& c.r2 == 1){
                    hitSoundK.playOnce();
                    c.ch1.switchIcon();
                    c.r2 -= 1;
                    c.i +=100;
                    System.out.println("pick --> r2 --> "+c.r2);
                    me.updateStruck("Withdraw", 30);
                    System.out.println(me.getStruck());
                    smoney.setText(Integer.toString(me.getStruck()));
                    
                }else{
                    
                   hitSoundW.playOnce(); 
                   
                }
             
                    r2.setSelected(false);
                    contentpane.repaint();
              
            }
            if(srb[2] == 1 ){
                
                if(c.r == 9&& c.r3 == 1){
                  
                  hitSoundK.playOnce();
                  c.ch2.switchIcon();
                  c.r3 -= 1;
                  c.i +=100;
                  System.out.println("pick --> r3 --> "+c.r3);
                  me.updateStruck("Withdraw", 20);
                  System.out.println(me.getStruck());
                  smoney.setText(Integer.toString(me.getStruck()));
                  
                }else{
                    
                  hitSoundW.playOnce(); 
                  
                }
              
                  r3.setSelected(false);
                  contentpane.repaint();
              
            }
            if(srb[3] == 1 ){
                
                if(c.r == 9 && c.r4 == 1){
                  
                  hitSoundK.playOnce();
                  c.ch3.switchIcon();
                  c.r4 -= 1;
                  c.i +=100;
                  System.out.println("pick --> r4 --> "+c.r4);
                  me.updateStruck("Withdraw", 20);
                  System.out.println(me.getStruck());
                  smoney.setText(Integer.toString(me.getStruck()));  
                  
                }else{
                    
                  hitSoundW.playOnce(); 
                  
                } 
              
                  r4.setSelected(false);
                  contentpane.repaint();
              
            }
            if(srb[4] == 1 ){
                
                if(c.r == 9 && c.r5 == 1){
                  
                  hitSoundK.playOnce();
                  c.ch4.switchIcon();
                  c.r5 -= 1;
                  c.i +=100;
                  System.out.println("pick --> r5 --> "+c.r5);
                  me.updateStruck("Withdraw", 20);
                  System.out.println(me.getStruck());
                  smoney.setText(Integer.toString(me.getStruck()));  
                  
                }else{
                    
                  hitSoundW.playOnce();  
                
                }
              
                  r5.setSelected(false);
                  contentpane.repaint();
              
            }
            
            pick.removeAll();
            pick.validate();
            pick.repaint();
             
        }
    });
    
    JButton cat = new JButton(new MyImageIcon("Lovely/catbtn.png").resize(100,30));
    cat.setBounds(0,0,100,30);
    confood.add(cat);
    consc.setVisible(true);
    confood.add(consc);
    cat.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            
            consd.setVisible(false);
            consc.setVisible(true);
            consr.setVisible(false);
            
        }
    });
    
    JButton dog = new JButton(new MyImageIcon("Lovely/dogbtn.png").resize(100,30));
    dog.setBounds(100,0,100,30);
    confood.add(dog);
    confood.add(consd);
    dog.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            
            consd.setVisible(true);
            consc.setVisible(false);
            consr.setVisible(false);
            
        }
    });
    
    JButton rabbit = new JButton(new MyImageIcon("Lovely/rabbitbtn.png").resize(100,30));
    rabbit.setBounds(200,0,100,30);
    confood.add(rabbit);
    confood.add(consr);
    rabbit.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            
            consd.setVisible(false);
            consc.setVisible(false);
            consr.setVisible(true);
            
        }
    });
    
    confood.validate();
    confood.repaint();
    }    
}
    public void toystock(){
        
        if(toy == null){
            
    toy = new JFrame("TOY");   
    toy.setBounds(20,150,500,500);
    toy.setResizable(false);
    toy.setVisible(true);
    toy.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    toy.addWindowListener(new WindowAdapter() {
        
      public void windowClosing(WindowEvent e) {
          
            toy = null;           
            pick.removeAll();
            pick.validate();
            pick.repaint();
            
      }
    });
    
    MyImageIcon shelf = new MyImageIcon("Lovely/shelf.jpg").resize(500,500);
    JLabel contoy = new JLabel();
    toy.setContentPane(contoy = new JLabel());
    contoy.setIcon(shelf);
    contoy.setLayout(null); 
    
            //cat shelf
           consct = new JLabel();
           consct.setBounds(0,0,500,500);
           consct.setLayout(null);
           
           sct1 = new JLabel();
           MyImageIcon bsct1 = new MyImageIcon("Lovely/cattoy1.png").resize(100,100);
           sct1.setIcon(bsct1);
           sct1.setBounds(50, 50,100,100);
           
           sct2 = new JLabel();
           MyImageIcon bsct2 = new MyImageIcon("Lovely/cattoy2.png").resize(100,100);
           sct2.setIcon(bsct2);
           sct2.setBounds(200, 50,100,100);
           
           sct3 = new JLabel();
           MyImageIcon bsct3 = new MyImageIcon("Lovely/cattoy3.png").resize(140,140);
           sct3.setIcon(bsct3);
           sct3.setBounds(320, 25,140,140);
           
           ct1 = new JCheckBox();
           ct1.setBounds(85,150,20,20);
           ct1.setOpaque(false);
           ct1.addItemListener(new ItemListener(){
               
               JLabel p1 = new JLabel(new MyImageIcon("Lovely/cattoy1.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   boolean check = !ct1.isSelected();
                  
                   if(e.getStateChange() == ItemEvent.SELECTED){
                       
                        System.out.println(check);
                        hitSoundd.playOnce();
                        scbt[0] = 1;
                        pick.add(p1);

                   }
                   else{
                       
                       System.out.println(check);
                       scbt[0]=0;
                       pick.remove(p1);
                   
   
                   }
                
                   
                       pick.validate();
                       pick.repaint();
               }
               
           });

           ct2 = new JCheckBox();
           ct2.setBounds(235,150,20,20);
           ct2.setOpaque(false);
           ct2.addItemListener(new ItemListener(){
               
               JLabel p2 = new JLabel(new MyImageIcon("Lovely/cattoy2.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       scbt[1] = 1;
                       hitSoundd.playOnce();
                       pick.add(p2);
    

                   }else{
                       scbt[1] = 0;
                       pick.remove(p2);
                      
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           ct3 = new JCheckBox();
           ct3.setBounds(385,150,20,20);
           ct3.setOpaque(false);
           ct3.addItemListener(new ItemListener(){
               
               JLabel p3 = new JLabel(new MyImageIcon("Lovely/cattoy3.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       scbt[2] = 1;
                       hitSoundd.playOnce();
                       pick.add(p3);
 
                   }else{
                       scbt[2] = 0;
                       pick.remove(p3);
                   
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });         
          
           consct.add(sct1);
           consct.add(sct2);
           consct.add(sct3);
           
           consct.add(ct1);
           consct.add(ct2);
           consct.add(ct3);
           
           // dog shelf
           consdt = new JLabel();
           consdt.setBounds( 0, 0, 500, 500);
           consdt.setVisible(false);
           consdt.setLayout(null);
                     
           sdt1 = new JLabel();
           MyImageIcon bsdt1 = new MyImageIcon("Lovely/dogtoy1.png").resize(100,100);
           sdt1.setIcon(bsdt1);
           sdt1.setBounds(50, 50,100,100);
           
           sdt2 = new JLabel();
           MyImageIcon bsd2 = new MyImageIcon("Lovely/dogtoy2.png").resize(100,100);
           sdt2.setIcon(bsd2);
           sdt2.setBounds(200, 50,100,100);
           
           sdt3 = new JLabel();
           MyImageIcon bsd3 = new MyImageIcon("Lovely/dogtoy3.png").resize(150,150);
           sdt3.setIcon(bsd3);
           sdt3.setBounds(320, 10,150,150);           
                     
           dt1 = new JCheckBox();
           dt1.setBounds(85,150,20,20);
           dt1.setOpaque(false);
           dt1.addItemListener(new ItemListener(){
               
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/dogtoy1.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       sdbt[0] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                      sdbt[0] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           dt2 = new JCheckBox();
           dt2.setBounds(235,155,20,20);
           dt2.setOpaque(false);
           dt2.addItemListener(new ItemListener(){
               
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/dogtoy2.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       sdbt[1] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       sdbt[1] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           dt3 = new JCheckBox();
           dt3.setBounds(385,150,20,20);
           dt3.setOpaque(false);
           dt3.addItemListener(new ItemListener(){
               
                JLabel p4 = new JLabel(new MyImageIcon("Lovely/dogtoy3.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       sdbt[2] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       sdbt[2] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });                  
           
           consdt.add(sdt1);
           consdt.add(sdt2);
           consdt.add(sdt3);
           
           consdt.add(dt1);
           consdt.add(dt2);
           consdt.add(dt3);
           
           //rabbit shelf
           consrt = new JLabel();
           consrt.setBounds( 0, 0, 500, 500);
           consrt.setVisible(false);
           consrt.setLayout(null);

           srt1 = new JLabel();
           MyImageIcon bsrt1 = new MyImageIcon("Lovely/rabbittoy1.png").resize(100,100);
           srt1.setIcon(bsrt1);
           srt1.setBounds(50, 50,100,100);
           
           srt2 = new JLabel();
           MyImageIcon bsrt2 = new MyImageIcon("Lovely/rabbittoy2.png").resize(100,100);
           srt2.setIcon(bsrt2);
           srt2.setBounds(200, 50,100,100);
           
           srt3 = new JLabel();
           MyImageIcon bsrt3 = new MyImageIcon("Lovely/rabbittoy3.png").resize(120,120);
           srt3.setIcon(bsrt3);
           srt3.setBounds(330, 20,120,120);
 
           rt1 = new JCheckBox();
           rt1.setBounds(85,150,20,20);
           rt1.setOpaque(false);
           rt1.addItemListener(new ItemListener(){
               
                JLabel p4 = new JLabel(new MyImageIcon("Lovely/rabbittoy1.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       srbt[0] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       srbt[0] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           rt2 = new JCheckBox();
           rt2.setBounds(235,150,20,20);
           rt2.setOpaque(false);
           rt2.addItemListener(new ItemListener(){
               JLabel p4 = new JLabel(new MyImageIcon("Lovely/rabbittoy2.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       srbt[1] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       srbt[1] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           rt3 = new JCheckBox();
           rt3.setBounds(385,150,20,20);
           rt3.setOpaque(false);
           rt3.addItemListener(new ItemListener(){
              JLabel p4 = new JLabel(new MyImageIcon("Lovely/rabbittoy3.png").resize(50,50));
               public void itemStateChanged(ItemEvent e){
                   
                   if(e.getStateChange() == ItemEvent.SELECTED){
                   
                       srbt[2] = 1;
                       hitSoundd.playOnce();
                       pick.add(p4);

                   }else{
                       srbt[2] = 0;
                       pick.remove(p4);
                   }
                       pick.validate();
                       pick.repaint();
               }
               
           });
           
           consrt.add(srt1);
           consrt.add(srt2);
           consrt.add(srt3);

           consrt.add(rt1);
           consrt.add(rt2);
           consrt.add(rt3);  
           
    JButton okButton = new JButton("OK");
    okButton.setBounds(200,375,100,50);
    contoy.add(okButton);
    okButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             
            
            //cat
            if(scbt[0] == 1 ){
              if(c.r == 3&& c.t1 == 1)  {
              hitSoundK.playOnce();
              c.ch1.switchIcon();
              c.t1 -= 1;
              c.i+=100;     
              System.out.println("pick --> t1 --> "+c.t1);
              me.updateStruck("Withdraw", 80);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));
              }else{
                  hitSoundW.playOnce();
              }
             
              ct1.setSelected(false);
              contentpane.repaint();
              
            }
            if(scbt[1] == 1 ){
              
              if(c.r == 4&& c.t2 == 1){
                  hitSoundK.playOnce();
                  c.ch1.switchIcon();
                  c.t2 -= 1;
              c.i+=100;     
              System.out.println("pick --> t2 --> "+c.t2);
                   me.updateStruck("Withdraw", 75);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));
              }else{
                 hitSoundW.playOnce(); 
              }
             
              ct2.setSelected(false);
              contentpane.repaint();
              
            }
            if(scbt[2] == 1){
              
                if(c.r == 3&& c.t3 == 1){
                    hitSoundK.playOnce();
                    c.ch2.switchIcon();
                    c.t3 -= 1;
              c.i+=100;     
              System.out.println("pick --> t3 --> "+c.t3);
                    me.updateStruck("Withdraw", 70);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));
                }else{
                  hitSoundW.playOnce();  
                }
              
              ct3.setSelected(false);
              contentpane.repaint();
              
            }
            
            //dog
            if(sdbt[0] == 1 ){
              if(c.r== 4&& c.t4 == 1){
                  hitSoundK.playOnce();
                  c.ch2.switchIcon();
              c.t4 -= 1;
              c.i+=100;     
              System.out.println("pick --> t4 --> "+c.t4);
                me.updateStruck("Withdraw", 65);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));  
              }else{
                 hitSoundW.playOnce(); 
              }
              
              dt1.setSelected(false);
              contentpane.repaint();
              
            }
            if(sdbt[1] == 1 ){
              
                if(c.r == 4&& c.t5 == 1){
                    hitSoundK.playOnce();
                    c.ch3.switchIcon();
                    c.t5 -= 1;
              c.i+=100;     
              System.out.println("pick --> t5 --> "+c.t5);
                     me.updateStruck("Withdraw", 60);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));
                }else{
                   hitSoundW.playOnce(); 
                }
             
              dt2.setSelected(false);
              contentpane.repaint();
              
            }
            if(sdbt[2] == 1 ){
               if(c.r == 3&& c.t6 == 1){
                   hitSoundK.playOnce();
                   c.ch3.switchIcon();
                   c.t6 -= 1;
              c.i+=100;     
              System.out.println("pick --> t6 --> "+c.t6);
                 me.updateStruck("Withdraw", 55);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));  
               }else{
                   hitSoundW.playOnce();
               }
              
              dt3.setSelected(false);
              contentpane.repaint();
              
            }
            
            //rabbit
            if(srbt[0] == 1 ){
              if(c.r == 5 && c.t7 == 1){
                  hitSoundK.playOnce();
                  c.ch1.switchIcon();
              c.t7 -= 1;
              c.i+=100;     
              System.out.println("pick --> t7 --> "+c.t7); 
              me.updateStruck("Withdraw", 50);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));
              }else{
                  hitSoundW.playOnce();
              }  
             
              rt1.setSelected(false);
              contentpane.repaint();
              
            }
            if(srbt[1] == 1 ){
              if(c.r == 5 && c.t8 == 1){
                  hitSoundK.playOnce();
                  c.ch2.switchIcon();
                  c.t8 -= 1;
              c.i+=100;     
              System.out.println("pick --> t8 --> "+c.t8);
                  me.updateStruck("Withdraw", 45);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));
              }else{
                  hitSoundW.playOnce();
              }
              
              rt2.setSelected(false);
              contentpane.repaint();
              
            }
            if(srbt[2] == 1 ){
              if(c.r == 5 && c.t9 == 1){
                  hitSoundK.playOnce();
                  c.ch3.switchIcon();
              c.t9 -= 1;
              c.i+=100;     
              System.out.println("pick --> t9 --> "+c.t9);
              me.updateStruck("Withdraw", 40);
              System.out.println(me.getStruck());
              smoney.setText(Integer.toString(me.getStruck()));
              }else{
                  hitSoundW.playOnce();
              } 
              
              rt3.setSelected(false);
              contentpane.repaint();
              
            }
            
            
            
            pick.removeAll();
            pick.validate();
            pick.repaint();
            
            
            
        }
    });
    
    JButton catt = new JButton(new MyImageIcon("Lovely/catbtn.png").resize(100,30));
    catt.setBounds(0,0,100,30);
    contoy.add(catt);
    consct.setVisible(true);
    contoy.add(consct);
    catt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            consdt.setVisible(false);
            consct.setVisible(true);
            consrt.setVisible(false);
        }
    });
    
    JButton dogt = new JButton(new MyImageIcon("Lovely/dogbtn.png").resize(100,30));
    dogt.setBounds(100,0,100,30);
    contoy.add(dogt);
    contoy.add(consdt);
    dogt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            consdt.setVisible(true);
            consct.setVisible(false);
            consrt.setVisible(false);
        }
    });
    
    JButton rabbitt = new JButton(new MyImageIcon("Lovely/rabbitbtn.png").resize(100,30));
    rabbitt.setBounds(200,0,100,30);
    contoy.add(rabbitt);
    contoy.add(consrt);
    rabbitt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            consdt.setVisible(false);
            consct.setVisible(false);
            consrt.setVisible(true);
        }
    });
    
    contoy.validate();
    contoy.repaint();
    
        }
    }
       
}

class Customer extends Thread{
    
    protected java.util.Random random;
    protected shop set;
    protected Player me;
    protected String[] c = {"Lovely/girl.png","Lovely/girl2.png","Lovely/hunter.png","Lovely/monopoly.png","Lovely/Pet owner.png","Lovely/depressed salary man.png"};
    protected int p1 = 0; 
    protected int p2 = 0; 
    protected int p3 = 0; 
    protected int p4 = 0; 
    protected int p5 = 0; 
    protected int p6 = 0; 
    
    protected int t1 = 0; 
    protected int t2 = 0; 
    protected int t3 = 0; 
    protected int t4 = 0; 
    protected int t5 = 0; 
    protected int t6 = 0; 
    protected int t7 = 0; 
    protected int t8 = 0;
    protected int t9 = 0; 
    
    protected int c1 = 0; 
    protected int c2 = 0; 
    protected int c3 = 0; 
    protected int c4 = 0; 
    protected int c5 = 0; 
    
    protected int d1 = 0; 
    protected int d2 = 0; 
    protected int d3 = 0; 
    protected int d4 = 0; 
    protected int d5 = 0;
    
    protected int r1 = 0; 
    protected int r2 = 0; 
    protected int r3 = 0; 
    protected int r4 = 0; 
    protected int r5 = 0;
    protected int food =  0;
    protected int toy = 0;
    protected int r;
    //timer
    protected JProgressBar jb;
    protected items ch1 = new items("Lovely/uncheck.png",20,20,set,"ch","Lovely/check.png",me);
    protected items ch2 = new items("Lovely/uncheck.png",20,20,set,"ch","Lovely/check.png",me);
    protected items ch3 = new items("Lovely/uncheck.png",20,20,set,"ch","Lovely/check.png",me);
    protected items ch4 = new items("Lovely/uncheck.png",20,20,set,"ch","Lovely/check.png",me);
    
    protected int i = 2000;
    protected JLabel Conc;
    public Customer(){
       
    }
      public void timer(){
    
        while(i <= 2000){
            
            jb.setValue(i);
            System.out.println(jb.getValue());
            i-=10;
            Conc.repaint(); 
            try{Thread.sleep(150);}catch(Exception e){}
            if(i<=0){
                set.hitSoundN.playOnce();
                break;
            }
            
            //r1 --> p1 , p2 , p6
            if(r==1){
              if(p1 == 0 && p2 == 0 && p3 != 1 && p4 != 1 && p5 != 1 && p6 == 0 && t1 != 1 && t2 != 1 && t3 != 1 && t4 != 1 && t5 != 1 && t6 != 1 && t7 != 1 && t8 != 1 && t9 != 1 && c1 != 1 && c2 != 1 && c3 != 1 && c4 != 1 && c5 != 1 && d1 != 1 && d2 != 1 && d3 != 1 && d4 != 1 && d5 != 1 && r1 != 1 && r2 != 1 && r3 != 1 && r4 != 1 && r5 != 1 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }  
            }
           
            //r2 --> p3 , p4, p5 
            else if(r==2){
            if(p1 !=1 && p2 != 1 && p3 == 0 && p4 == 0 && p5 == 0 && p6 != 1 && t1 != 1 && t2 != 1 && t3 != 1 && t4 != 1 && t5 != 1 && t6 != 1 && t7 != 1 && t8 != 1 && t9 != 1 && c1 != 1 && c2 != 1 && c3 != 1 && c4 != 1 && c5 != 1 && d1 != 1 && d2 != 1 && d3 != 1 && d4 != 1 && d5 != 1 && r1 != 1 && r2 != 1 && r3 != 1 && r4 != 1 && r5 != 1 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }
            }
            //r3--> t1 , t3, t6
            else if(r==3){
            if(p1 !=1 && p2 != 1 && p3 != 1 && p4 != 1 && p5 != 1 && p6 != 1 && t1 == 0 && t2 != 1 && t3 == 0 && t4 != 1 && t5 != 1 && t6 == 0 && t7 != 1 && t8 != 1 && t9 != 1 && c1 != 1 && c2 != 1 && c3 != 1 && c4 != 1 && c5 != 1 && d1 != 1 && d2 != 1 && d3 != 1 && d4 != 1 && d5 != 1 && r1 != 1 && r2 != 1 && r3 != 1 && r4 != 1 && r5 != 1 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }
            }
            
            
            //r4 --> t2 , t5, t7
            else if(r==4){
            if(p1 !=1 && p2 != 1 && p3 == 0 && p4 == 0 && p5 == 0 && p6 != 1 && t1 != 1 && t2 != 1 && t3 != 1 && t4 != 1 && t5 != 1 && t6 != 1 && t7 != 1 && t8 != 1 && t9 != 1 && c1 != 1 && c2 != 1 && c3 != 1 && c4 != 1 && c5 != 1 && d1 != 1 && d2 != 1 && d3 != 1 && d4 != 1 && d5 != 1 && r1 != 1 && r2 != 1 && r3 != 1 && r4 != 1 && r5 != 1 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }
            }
            
            //r5 --> t7 , t8, t9
            else if(r==5){
            if(p1 !=1 && p2 != 1 && p3 != 1 && p4 != 1 && p5 != 1 && p6 != 1 && t1 != 1 && t2 != 1 && t3 != 1 && t4 != 1 && t5 != 1 && t6 != 1 && t7 == 0 && t8 == 0 && t9 == 0 && c1 != 1 && c2 != 1 && c3 != 1 && c4 != 1 && c5 != 1 && d1 != 1 && d2 != 1 && d3 != 1 && d4 != 1 && d5 != 1 && r1 != 1 && r2 != 1 && r3 != 1 && r4 != 1 && r5 != 1 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }
            }
            
            //r6 --> c1 , c2, c3
             else if(r==6){
            if(p1 !=1 && p2 != 1 && p3 != 1 && p4 != 1 && p5 != 1 && p6 != 1 && t1 != 1 && t2 != 1 && t3 != 1 && t4 != 1 && t5 != 1 && t6 != 1 && t7 != 1 && t8 != 1 && t9 != 1 && c1 == 0 && c2 == 0 && c3 == 0 && c4 != 1 && c5 != 1 && d1 != 1 && d2 != 1 && d3 != 1 && d4 != 1 && d5 != 1 && r1 != 1 && r2 != 1 && r3 != 1 && r4 != 1 && r5 != 1 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }
            }
            
            //r7 --> c4 , c5, d1, d2
             else if(r==7){
            if(p1 !=1 && p2 != 1 && p3 != 1 && p4 != 1 && p5 != 1 && p6 != 1 && t1 != 1 && t2 != 1 && t3 != 1 && t4 != 1 && t5 != 1 && t6 != 1 && t7 != 1 && t8 != 1 && t9 != 1 && c1 != 1 && c2 != 1 && c3 != 1 && c4 == 0 && c5 == 0 && d1 == 0 && d2 == 0 && d3 != 1 && d4 != 1 && d5 != 1 && r1 != 1 && r2 != 1 && r3 != 1 && r4 != 1 && r5 != 1 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }
            }
            
            //r8 --> d3 , d4, d5, r1
            else if(r==8){
            if(p1 !=1 && p2 != 1 && p3 != 1 && p4 != 1 && p5 != 1 && p6 != 1 && t1 != 1 && t2 != 1 && t3 != 1 && t4 != 1 && t5 != 1 && t6 != 1 && t7 != 1 && t8 != 1 && t9 != 1 && c1 != 1 && c2 != 1 && c3 != 1 && c4 == 0 && c5 != 1 && d1 != 1 && d2 != 1 && d3 == 0 && d4 == 0 && d5 == 0 && r1 == 0 && r2 != 1 && r3 != 1 && r4 != 1 && r5 != 1 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }
            }
            
            //r9 --> r2 , r3, r4, r5
            else if(r==9){
            if(p1 !=1 && p2 != 1 && p3 != 1 && p4 != 1 && p5 != 1 && p6 != 1 && t1 != 1 && t2 != 1 && t3 != 1 && t4 != 1 && t5 != 1 && t6 != 1 && t7 != 1 && t8 != 1 && t9 != 1 && c1 != 1 && c2 != 1 && c3 != 1 && c4 != 1 && c5 != 1 && d1 != 1 && d2 != 1 && d3 != 1 && d4 != 1 && d5 != 1 && r1 != 1 && r2 == 0 && r3 == 0 && r4 == 0 && r5 == 0 ){ 
                
                Conc.removeAll();     
                Conc.repaint();
                return;
                
            }
            }
        }
    //Pet 
    p1 = 0; 
    p2 = 0; 
    p3 = 0; 
    p4 = 0; 
    p5 = 0; 
    p6 = 0; 
    //toy
    t1 = 0; 
    t2 = 0; 
    t3 = 0; 
    t4 = 0; 
    t5 = 0; 
    t6 = 0; 
    t7 = 0; 
    t8 = 0;
    t9 = 0; 
    //food    
    c1 = 0; 
    c2 = 0; 
    c3 = 0; 
    c4 = 0; 
    c5 = 0; 
    
    d1 = 0; 
    d2 = 0; 
    d3 = 0; 
    d4 = 0; 
    d5 = 0;
    
    r1 = 0; 
    r2 = 0; 
    r3 = 0; 
    r4 = 0; 
    r5 = 0;
               Conc.removeAll();     
               Conc.repaint();

    
      }   

    public void run(){
               
        random = new java.util.Random();
        int rp = 0;
        while(rp==0){
            rp = random.nextInt(7-1)+1;
        }
         
        
        System.out.println("Customer --> "+rp);
        MyImageIcon cc = new MyImageIcon(c[rp]);
        JLabel cin = new JLabel(cc.resize(150,150));
        cin.setBounds(-10,590,150,150);
        Conc.add(cin);
        rc();
        
    jb = new JProgressBar(0,2000);
    jb.setBounds(150,620,150,25);
    jb.setValue(2000);
    jb.setStringPainted(true);
    Conc.add(jb);   
    Conc.repaint();   
    timer();  
    
    
    }
    public void rc(){
        
        
        ch1.setDropLabel(ch1);
        ch2.setDropLabel(ch2);
        ch3.setDropLabel(ch3);
        ch4.setDropLabel(ch4);

        random = new java.util.Random();
        int []sf = {1,2,6,7,8,9};     
        if(food == 0 && toy == 0){
            
         r = 0;
        while(r==0){
            
            r = random.nextInt(3-1)+1;
           
        }
        }
        // mee food
        
        else if(food == 1 && toy == 0){
            
         r = 0;
        while(r==0){
            
           int rp = random.nextInt(7-1)+1;
           r = sf[rp];
        }
          
          
        }
        
        // mee toy
        else if(food == 0 && toy == 1){
            
        r = 0;
        while(r==0){
            
            r = random.nextInt(6-1)+1;
           
        }
          
        }  
        
        // mee everything
        else if(food == 1 && toy == 1 ){
            
         r = 0;
        while(r==0){
            
          r = random.nextInt(10-1)+1;  
           
        }
                    
        }
       
       System.out.println(r);
        if(r == 1){
            p1=1;  
            p2=1;
            p6=1;
            
            MyImageIcon f = new MyImageIcon("Lovely/r1.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 470);  // move conditions & initial position
            ch2.setMoveConditions(190, 505);
            ch3.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(cm);
                    
            Conc.repaint();
                   }
        else if(r == 2){
            p3=1;
            p4=1;
            p5=1;
            
            MyImageIcon f = new MyImageIcon("Lovely/r2.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 470);  // move conditions & initial position
            ch2.setMoveConditions(190, 505);
            ch3.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(cm);
            Conc.repaint();
            
        }
        else if(r == 3){
            t1=1;
            t3=1;
            t6=1;
            MyImageIcon f = new MyImageIcon("Lovely/r3.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 470);  // move conditions & initial position
            ch2.setMoveConditions(190, 505);
            ch3.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(cm);
            Conc.repaint();
            
            
        }
        else if(r == 4){
            t2=1;
            t4=1;
            t5=1;
            MyImageIcon f = new MyImageIcon("Lovely/r4.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 470);  // move conditions & initial position
            ch2.setMoveConditions(190, 505);
            ch3.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(cm);
            Conc.repaint();
        }
        else if(r == 5){
            t7=1;
            t8=1;
            t9=1;
            MyImageIcon f = new MyImageIcon("Lovely/r5.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 470);  // move conditions & initial position
            ch2.setMoveConditions(190, 505);
            ch3.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(cm);
            Conc.repaint();
        }
        else if(r == 6){
            c1=1;
            c2=1;
            c3=1;
            MyImageIcon f = new MyImageIcon("Lovely/r6.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 470);  // move conditions & initial position
            ch2.setMoveConditions(190, 505);
            ch3.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(cm);
            Conc.repaint();
        }
         else if(r == 7){
            c4=1;
            c5=1;
            d1=1;
            d2=1;
            MyImageIcon f = new MyImageIcon("Lovely/r7.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 465);  // move conditions & initial position
            ch2.setMoveConditions(190, 490);
            ch3.setMoveConditions(190, 520);
            ch4.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(ch4);
            Conc.add(cm);
            Conc.repaint();
        }
         else if(r == 8){
            d3=1;
            d4=1;
            d5=1;
            r1=1;
            MyImageIcon f = new MyImageIcon("Lovely/r8.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 465);  // move conditions & initial position
            ch2.setMoveConditions(190, 490);
            ch3.setMoveConditions(190, 520);
            ch4.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(ch4); 
            Conc.add(cm);
            Conc.repaint();
        }
         else if(r == 9){
            r2=1;
            r3=1;
            r4=1;
            r5=1;
            MyImageIcon f = new MyImageIcon("Lovely/r9.png");
            JLabel cm = new JLabel(f.resize(350, 150));
            cm.setBounds(150,450,350,150);
            ch1.setMoveConditions(190, 465);  // move conditions & initial position
            ch2.setMoveConditions(190, 490);
            ch3.setMoveConditions(190, 520);
            ch4.setMoveConditions(190, 545);
            Conc.add(ch1);
            Conc.add(ch2);
            Conc.add(ch3);
            Conc.add(ch4);
            Conc.add(cm);
            Conc.repaint();
        }
        
    }
    public void setc (shop s){set = s;}
    public void setp (Player s){me = s;}
}

class MyContainerListener extends ContainerAdapter{
    
        public void componentAdded(ContainerEvent e){
            e.getContainer().validate();
        }
        public void componentRemoved(ContainerEvent e){
            e.getContainer().validate();
        }
            
}

class items extends cb implements MouseListener,MouseMotionListener
{
    private items dropLabel;
    private shop set;
    private boolean drag;
    private String name;
    private Player me;

    public items(String file1, int w, int h,shop Dora,String n,String file2, Player use)				
    { 
        me = use;
        name = n;
        addMouseListener(this);
        addMouseMotionListener(this);
        width = w; height = h; 
        set = Dora;
        
        iconMode1 = new MyImageIcon(file1).resize(width, height);
        if(file2 != "null")
        {
        iconMode2 = new MyImageIcon(file2).resize(width, height);
        }else{
          iconMode2 = new MyImageIcon(file1).resize(width, height);
        }
	      setHorizontalAlignment(JLabel.CENTER);
	      setIcon(iconMode1);
        drag = false;
    }    
    public void setMoveConditions(int x, int y)
    {

        curX = x; curY = y;
	setBounds(curX, curY, width, height);
       

    }
     public void setDropLabel(items t)   { dropLabel = t;}
    
   public void mousePressed(MouseEvent fiwh){
       
       if(name == "s" || name == "pro" || name == "sc" || name == "sd"|| name == "sr") {setCursor(new Cursor(Cursor.DEFAULT_CURSOR));}
       else{
           if(!drag){
       
           setCursor(new Cursor(Cursor.HAND_CURSOR));
           drag = true;
           
       }else{
           
           setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
           drag = false;
           
       }
       }
       
   }
   public void mouseReleased(MouseEvent fiwh){
       if(name != "s" || name != "sc"){
        if ( !this.getBounds().intersects(dropLabel.getBounds()) )
            {
             set.hitSoundd.playOnce();
             if(name == "i1"){
              
              setBounds(700, 420, 150, 150);
             }else if(name == "i2"){
              setBounds(1100, 450, 100, 100);
             }else if(name == "i3"){
              setBounds(800, 420, 150, 150);
             }else if(name == "i4"){
              setBounds(900, 220, 100, 100);
             }else if(name == "i5"){
             setBounds(1100, 210, 50,100);
             }else if(name == "i6"){
             setBounds(1000, 210, 50,100);
             }
            } 
           
        else if ( this.getBounds().intersects(dropLabel.getBounds()) )
            { 
             //Husky
              if(name == "i1"){
             
              if(set.c.r == 1 && set.c.p1 == 1){
                
                set.c.ch1.switchIcon();
                set.hitSoundK.playOnce();
                set.c.i +=100;
                set.c.p1-=1; 
                System.out.println("pick --> p1 --> "+set.c.p1);
                me.updateStruck("Withdraw", 50); 
                System.out.println(me.getStruck());
                set.smoney.setText(Integer.toString(me.getStruck()));
                
              }else{
               set.hitSoundW.playOnce();   
              }            

              setBounds(700, 420, 150, 150);
              
              set.contentpane.repaint();
              
             }
              //Brown Cat 
              else if(name == "i2"){
                 
              if(set.c.r == 1 && set.c.p2 == 1){
                set.c.ch2.switchIcon();  
                set.hitSoundK.playOnce();
                set.c.i +=100;  
                set.c.p2-=1; 
                System.out.println("pick --> p2 --> "+set.c.p2);
                me.updateStruck("Withdraw", 55); 
                System.out.println(me.getStruck());
                set.smoney.setText(Integer.toString(me.getStruck()));
                
              }else{
                  set.hitSoundW.playOnce();
              }
                              
              setBounds(1100, 450, 100, 100);
              
              set.contentpane.repaint();
             }else if(name == "i3"){
                 
              if(set.c.r == 2 && set.c.p3 == 1){
                set.c.ch1.switchIcon();  
                set.hitSoundK.playOnce();  
                set.c.i +=100;  
                set.c.p3=0; 
                System.out.println("pick --> p3 --> "+set.c.p3);
                me.updateStruck("Withdraw", 60); 
                System.out.println(me.getStruck());
                set.smoney.setText(Integer.toString(me.getStruck()));
                
              }else{
                set.hitSoundW.playOnce();  
              }
                 setBounds(800, 420, 150, 150);
            
              set.contentpane.repaint();
             }else if(name == "i4" ){
                 
              if(set.c.r == 2 && set.c.p4 == 1){
                set.c.ch2.switchIcon();  
                set.hitSoundK.playOnce();  
                set.c.i +=100;  
                set.c.p4=0; 
                System.out.println("pick --> p4 --> "+set.c.p4);
                me.updateStruck("Withdraw", 65); 
                System.out.println(me.getStruck());
                set.smoney.setText(Integer.toString(me.getStruck()));
                
              }else{
                 set.hitSoundW.playOnce(); 
              }
              
              setBounds(900, 220, 100, 100);
              
              set.contentpane.repaint();
              
             }else if(name == "i5"){
                 
              if(set.c.r == 2 && set.c.p5 == 1){
                set.c.ch3.switchIcon();  
                set.hitSoundK.playOnce();  
                set.c.p5=0; 
                System.out.println("pick --> p5 --> "+set.c.p5);
                me.updateStruck("Withdraw", 70); 
                System.out.println(me.getStruck());
                set.smoney.setText(Integer.toString(me.getStruck()));
                
              }else{
                set.hitSoundW.playOnce();  
              }
              
             setBounds(1100, 210, 50,100);
              
             set.contentpane.repaint();
             }else if(name == "i6"){
              
              if(set.c.r == 1 && set.c.p6 == 1){
                  
                set.c.ch3.switchIcon();  
                set.hitSoundK.playOnce();  
                set.c.p6=0; 
                System.out.println("pick --> p6 --> "+set.c.p6);
                me.updateStruck("Withdraw", 75); 
                System.out.println(me.getStruck());
                set.smoney.setText(Integer.toString(me.getStruck()));
                
              }else{
                set.hitSoundW.playOnce();  
              }
              
             setBounds(1000, 210, 50,100);
             
              
             set.contentpane.repaint();
             }
 } 
              
            
            }
            
        
        
   }
   public void mouseEntered(MouseEvent fiwh){
       
         if(name == "s" || name =="pro" || name == "sc"|| name == "sd"|| name == "sr"){
              setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
              switchIcon();
         }else if(name == "ch"){
             
         }
         else{
             setCursor(new Cursor(Cursor.HAND_CURSOR));        
             switchIcon();
         }
         

   }
   public void mouseExited(MouseEvent fiwh){
       if(name != "ch"){
           resetIcon();
       }
       
   }
   public void mouseClicked(MouseEvent fiwh){
       
   }
   public void mouseMoved(MouseEvent fiwh){
     
   }

   public void mouseDragged(MouseEvent fiwh){
        
         if(drag){
 
            curX = curX + fiwh.getX();
            curY = curY + fiwh.getY();
            Container p = getParent();
            if(curX < 0 ) curX = 0;
            if(curY < 0 ) curY = 0;
            if(curX+width > p.getWidth()) curX = p.getWidth() - width;
            if(curY+height > p.getHeight()) curY = p.getHeight() - height;
            setLocation(curX,curY);           
        }
   
   }
    
}