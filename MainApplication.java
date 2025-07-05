import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.sound.sampled.*; // for sounds
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainApplication extends JFrame 
{
  // components
  private JPanel contentpane;
  private JLabel drawpane;
  private JLabel LcloudLabel, RcloudLabel;
  private JButton NewButton,LoadButton,SettingButton,CreditButton,HowButton;
  private MyImageIcon interBG, cloud1, cloud2;
  private MySoundEffect hitSound, creditSound;
  private int LCCurX = 0, LCCurY = 0;
  private int RCCurX = 800, RCCurY = 0; 
  private JButton backButton;
  private MainApplication FirstI,set;
  private New NewI;
  private Load LoadI; 
  protected How HowI;
  protected JFrame CreditI;
  
  // working variables - adjust the values as you want
  private int frameWidth = 1366, frameHeight = 768;
  
  
 
 public MainApplication() {
   
    setTitle("PetShop");
    setBounds(100, 40, frameWidth, frameHeight);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        
      
        
      }
    });

    contentpane = (JPanel) getContentPane();
    contentpane.setLayout(new BorderLayout());
    AddComponents();
    }

public void AddComponents() {
  
    boolean loop = true;
    interBG = new MyImageIcon("Lovely/bgm.jpg").resize(frameWidth, frameHeight);
    cloud1 = new MyImageIcon("Lovely/Cloud.png").resize(250,170);
    cloud2 = new MyImageIcon("Lovely/Cloud 2.png").resize(250,170);

    drawpane = new JLabel();
    drawpane.setIcon(interBG);
    drawpane.setLayout(null);

    LcloudLabel = new JLabel(cloud1);
    LcloudLabel.setBounds(LCCurX,LCCurY,250,170);
    RcloudLabel = new JLabel(cloud2);
    RcloudLabel.setBounds(RCCurX,RCCurY,250,170);

    if(loop == true)
    {
      Thread move = new Thread()
      {
        public void run() 
        {
          while(true)
          {
            LcloudLabel.setLocation(LCCurX,LCCurY);
            RcloudLabel.setLocation(RCCurX,RCCurY);
            LCCurX = LCCurX-50;
            RCCurX = RCCurX-50;
            if(LCCurX < -200 )
            {
              LCCurX = frameWidth;
            }
            else if(RCCurX < -200)
            {
              RCCurX = frameWidth;
            }
            repaint();
            try {
            Thread.sleep(1000);
            }catch (InterruptedException e){
            e.printStackTrace();
           }
          }
        }
      };
      move.start();
    }

    hitSound = new MySoundEffect("Lovely/beep.wav");
    
    NewButton = new JButton(new MyImageIcon("Lovely/NewButton.png").resize(200,50));
    NewButton.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {

          if(NewI == null)
          {
           dispose();
           hitSound.playOnce();     
           NewI = new New();
           NewI.setVisible(true);

          }
        
      }
      });
    
    File file = new File("Player.txt"); 
       
   if(file.exists() == true){
    LoadButton = new JButton(new MyImageIcon("Lovely/LoadB.png").resize(200,50));
    LoadButton.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {

          if(LoadI == null)
          {

           dispose();
           hitSound.playOnce();     
           LoadI = new Load();
           LoadI.setVisible(true);

          }
        
      }
      });
   }else{
       LoadButton = new JButton(new MyImageIcon("Lovely/nLoadB.png").resize(200,50));
   }

    CreditButton = new JButton(new MyImageIcon("Lovely/credit.png").resize(200,50));
    CreditButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

          if(CreditI == null)
          {
              
         hitSound.playOnce();
         CreditI = new JFrame("Credit");
         CreditI.setBounds(400,150,600,338);
         CreditI.setResizable(false);
         CreditI.setVisible(true);
         CreditI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         creditSound = new MySoundEffect("Lovely/harry.wav");
         creditSound.playLoop();
      
      JPanel p = new JPanel();
      JLabel l = new JLabel();
      
      MyImageIcon icon = new MyImageIcon("Lovely/credit.gif");
      
      l.setIcon(icon);
      p.add(l);
      
      CreditI.getContentPane().add(p);
      CreditI.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
            
     
            creditSound.stop(); 
            CreditI.dispose();
            CreditI = null;
            
      }
    });
        
         
          }
     
      
      
        
      }
    });
    
    HowButton = new JButton(new MyImageIcon("Lovely/how.png").resize(200,50));
    HowButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
            if(HowI==null)
            {  
                hitSound.playOnce();
                HowI = new How();
                dispose();
            }
        
      }
    });
     
    
    
    
    JLabel name = new JLabel(new MyImageIcon("Lovely/nm.png").resize(400,150));
    name.setBounds(450,-50,500,400);
    
    drawpane.add(LcloudLabel);
    drawpane.add(RcloudLabel);
    
    NewButton.setBounds(600,250,200,50);
    LoadButton.setBounds(600,320,200,50);
    HowButton.setBounds(600,390,200,50);

    CreditButton.setBounds(600,460,200,50);
    
    contentpane.add(name);
    
    contentpane.add(NewButton,BorderLayout.CENTER); //addButton
    contentpane.add(LoadButton,BorderLayout.CENTER); //addButton
    contentpane.add(HowButton,BorderLayout.CENTER); //addButton
    contentpane.add(CreditButton,BorderLayout.CENTER); //addButton
    contentpane.add(drawpane, BorderLayout.CENTER); //addBG
    
    validate();

  }

  public static void main(String[] args) {
    
  new MainApplication();

  }
}


  