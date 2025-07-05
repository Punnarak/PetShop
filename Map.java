import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*; 
import java.util.*;

public class Map extends JFrame 

{
  // components
  protected Map MapI;  
  private New NewI;
  private MainApplication bFirstI;
  
  private JLabel contentpane;
  private JButton backButton;
  
  private MyImageIcon interBG;

  private ArrayList<Player> infom;
  private Building b1,b2,b3,b4;
  protected String name;
  protected int bb,ss,tt1,tt3,tt4; 
  protected Player me;
  private int frameWidth = 1366, frameHeight = 768;

 
 public Map(Player use,String n,int b,int s,int t1,int t3,int t4) {

    setTitle("Map");
    setBounds( 100, 40, frameWidth, frameHeight);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
            dispose();
            new MainApplication();
            
      }
    });
    
    me = use;
    name = n;
    bb = b;
    ss = s;
    tt1 = t1;
    tt3 = t3;
    tt4 = t4;
    
    AddComponents();

    }
public void AddComponents() {
    
    setContentPane(contentpane = new JLabel());
    interBG = new MyImageIcon("Lovely/map.jpg");
    contentpane.setIcon(interBG.resize(frameWidth, frameHeight));
    contentpane.setLayout(null);
    System.out.println(name + " mmmmmmmmapppp");
     
     if(tt1 == 1)
    {
    b1 = new Building("Lovely/shop.PNG",400,300,this,"b1","Lovely/shop2.png");
    b1.setMoveConditions(160, 150); contentpane.add(b1); //addShop
    }

    b2 = new Building("Lovely/bank.PNG",250,350,this,"b2","Lovely/bank2.PNG");
    b2.setMoveConditions(620,0);  

    if(tt3 == 1)
    {
    b3 = new Building("Lovely/toy.PNG",400,300,this,"b3","Lovely/toy2.png");
    b3.setMoveConditions(900,170); contentpane.add(b3); //addtoy
    }
    
    if(tt4 == 1)
    {
    b4 = new Building("Lovely/food.PNG",400,350,this,"b4","Lovely/food2.png");
    b4.setMoveConditions(820,400); contentpane.add(b4); //addfood 
    }
    
    backButton = new JButton(new MyImageIcon("Lovely/backB.png").resize(200,50));
    backButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {  
          MySoundEffect hitSound = new MySoundEffect("Lovely/beep.wav");
           hitSound.playOnce();
           setVisible(false);
           bFirstI = new MainApplication();
           bFirstI.setVisible(true);
        
      }
    });
    
    backButton.setBounds(20,668,200,50);
    
    contentpane.add(backButton,BorderLayout.CENTER); //addButton
   
    contentpane.add(b2); //addBank
   
    validate();
  }

  public int build1(){
       
      System.out.println(tt1 );
      return tt1;
  }
  public int build3(){
       
      System.out.println(tt3);
      return tt3;
  }
  public int build4(){
        
         System.out.println(tt4);
         
      return tt4;
  }

}

class Building extends cb implements MouseListener,MouseMotionListener
{
    
    private Building dropLabel;
    private shop shopI;
    private MySoundEffect hitSound;
    private Map set;
    private String Name;
    private bank bankI;
    
    public Building(String file1, int w, int h,Map Dora, String n,String file2)				
    { 
        
        Name = n;
        addMouseListener(this);
        addMouseMotionListener(this);
        width = w; height = h; 
        set = Dora;
        
        iconMode1 = new MyImageIcon(file1).resize(width, height);
        iconMode2 = new MyImageIcon(file2).resize(width, height);      
        
	setHorizontalAlignment(JLabel.CENTER);
	setIcon(iconMode1);
        hitSound = new MySoundEffect("Lovely/beep.wav");
    
   
    }    
    public void setMoveConditions(int x, int y)
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

       if(Name == "b1")
       {
          if(shopI == null)
          {
           set.dispose();
           hitSound.playOnce();
           shopI = new shop(set.me,set.name, set.bb, set.ss, set.tt1, set.tt3, set.tt4);
           shopI.setVisible(true); 
 
          }
       }
       if(Name == "b2")
       {
          if(bankI == null)
          {

          set.dispose();
          hitSound.playOnce();
          bankI = new bank(set.me,set.name, set.bb, set.ss, set.tt1, set.tt3, set.tt4);
          bankI.setVisible(true);
         
          }
       }
        
   }
   public void mouseMoved(MouseEvent fiwh){
     
   }
   public void mouseDragged(MouseEvent fiwh){
       
   
   }
    
}

class cb extends JLabel 
{
    protected MyImageIcon   iconMode1, iconMode2;
    protected int           curX, curY, width, height;


    public cb() { }
    public cb(String file1, String file2, int w, int h)				
    { 
        width = w; height = h;
        iconMode1 = new MyImageIcon(file1).resize(width, height);
        iconMode2 = new MyImageIcon(file2).resize(width, height);
	      setHorizontalAlignment(JLabel.CENTER);
	      setIcon(iconMode1);
    }
    
 
   public void switchIcon()     {  
   setIcon(iconMode2); 
   
   }
   
    public void resetIcon()      { setIcon(iconMode1); }
   
}


 