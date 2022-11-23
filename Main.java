import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.sound.sampled.*; // for sounds
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends JFrame 
// public class SlothGame extends JFrame
{
  // components
  private JPanel contentpane;
  private JLabel drawpane;
  private JLabel LcloudLabel, RcloudLabel;
  private JButton NewButton,LoadButton,SettingButton,CreditButton,HowButton;
  private MyImageIcon interBG, cloud1, cloud2;
  private JFrame SettingI;
  private New NewI;
  private Load LoadI;
  private MySoundEffect hitSound, themeSound;
  private int LCCurX = 0, LCCurY = 0;
  private int RCCurX = 800, RCCurY = 0;
  
 private JPanel contents,control;
 private JButton backButton;
 private ButtonGroup soundg;
 private JToggleButton[] tb;
 private MyImageIcon settingBG;
 private JLabel draws;
 private Main FirstI,set;
 protected JSlider volume; 
  
  protected JFrame CreditI,HowI;
  // working variables - adjust the values as you want
  private int frameWidth = 1366, frameHeight = 768;
 
 public Main() {
   
    setTitle("Project Game");
    setBounds( 300, 150, frameWidth, frameHeight);
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        
        themeSound.stop();     

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
    themeSound = new MySoundEffect("Lovely/theme.wav");
    themeSound.playLoop();
    
    NewButton = new JButton(new MyImageIcon("Lovely/NewButton.png").resize(200,50));
    NewButton.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e)
      {

          if(NewI == null)
          {

           setVisible(false);
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

           setVisible(false);
           hitSound.playOnce();     
           LoadI = new Load();
           LoadI.setVisible(true);

          }
        
      }
      });
   }else{
       LoadButton = new JButton(new MyImageIcon("Lovely/nLoadB.png").resize(200,50));
   }
    
    SettingButton = new JButton(new MyImageIcon("Lovely/SettingB.png").resize(200,50));
    SettingButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

          if(SettingI == null)
          {
              SettingI = new JFrame("Setting");
              SettingI.setBounds( 750, 300, 500, 500);
              SettingI.setResizable(false);
              SettingI.setVisible(true);
              SettingI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
              SettingI.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
           
          SettingI = null;
          
      }
    });
    
     contents = (JPanel) SettingI.getContentPane();
     contents.setLayout(new BorderLayout());
     
    volume = new JSlider(JSlider.HORIZONTAL,0,100,50);
    volume.setMajorTickSpacing(25);
    volume.setMinorTickSpacing(5);
    volume.setPaintTicks(true);
    volume.setPaintLabels(true);
    volume.setVisible(true);
    volume.setBounds(50,50,350,50);
    volume.addChangeListener(new ChangeListener(){
        
        public void stateChanged(ChangeEvent e){
     
     JSlider source = (JSlider)e.getSource();
     if(!source.getValueIsAdjusting()){
         
         int value  = (int) source.getValue();
         System.out.println(value);
         
     }
     
 }
    });    
    
    settingBG = new MyImageIcon("Lovely/cinnamoroll.jpg").resize(500, 500);
    hitSound = new MySoundEffect("Lovely/beep.wav");
    themeSound = new MySoundEffect("Lovely/theme.wav");
    themeSound.playLoop();
    draws = new JLabel();
    draws.setIcon(settingBG);
    draws.setLayout(null);
    
    control = new JPanel();
    control.setLayout(null);
    control.setBounds(25,50,425,350);
    JLabel ls = new JLabel("Sound : ");
    ls.setBounds(20,0,50,50);
    control.add(ls);
    soundg = new ButtonGroup();
    tb = new JToggleButton[2];
    tb[0] = new JRadioButton("ON");
    tb[0].setBounds(70,0,50,50);
    tb[0].setName("ON");
    tb[0].setSelected(true);
    tb[1] = new JRadioButton("OFF");
    tb[1].setBounds(140,0,50,50);
    tb[1].setName("OFF");
    tb[0].addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        JRadioButton option = (JRadioButton) e.getItem();
        if(option.isSelected())
        {
            
          themeSound.playLoop();
          tb[1].setSelected(false);
          volume.setVisible(true);
          
        }
        else
        {
          if(!tb[1].isSelected())
          {

            tb[0].setSelected(true);
            
          }
        }
      }
    });
    
    tb[1].addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        JRadioButton option = (JRadioButton) e.getItem();
        if(option.isSelected())
        {
            
          themeSound.stop();
          tb[0].setSelected(false);
          volume.setVisible(false);
        }
        else
        {
          if(!tb[0].isSelected())
          {
           
            tb[1].setSelected(true);
            
          }
        }
      }
    });
    
    control.add(tb[0]);
    control.add(tb[1]);
    control.add(volume);

    contents.add(control,BorderLayout.CENTER);
    contents.add(draws, BorderLayout.CENTER); //addBG    
    
         
           
          }
        
      }
    });
    

    CreditButton = new JButton(new MyImageIcon("Lovely/credit.png").resize(200,50));
    CreditButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

          if(CreditI == null)
          {
              
         CreditI = new JFrame("Credit");
         CreditI.setBounds(750,300,500,500);
         CreditI.setResizable(false);
         CreditI.setVisible(true);
         CreditI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         CreditI.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
            CreditI.dispose();
            CreditI = null;
  
      }
    });
         hitSound.playOnce();
         
          }
        
      }
    });
    
    HowButton = new JButton(new MyImageIcon("Lovely/how.png").resize(200,50));
    HowButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

          if(HowI == null)
          {
              
         HowI = new JFrame("How to play");
         HowI.setBounds(500,250,1000,600);
         HowI.setResizable(false);
         HowI.setVisible(true);
         HowI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         HowI.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
            HowI.dispose();
            HowI = null;
  
      }
    });
         hitSound.playOnce();
          
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
    SettingButton.setBounds(600,460,200,50);
    CreditButton.setBounds(600,530,200,50);
    
    contentpane.add(name);
    
    contentpane.add(NewButton,BorderLayout.CENTER); //addButton
    contentpane.add(LoadButton,BorderLayout.CENTER); //addButton
    contentpane.add(HowButton,BorderLayout.CENTER); //addButton
    contentpane.add(SettingButton,BorderLayout.CENTER); //addButton
    contentpane.add(CreditButton,BorderLayout.CENTER); //addButton
    contentpane.add(drawpane, BorderLayout.CENTER); //addBG
    
    validate();

  }

  public static void main(String[] args) {
    
  new Main();

  }
}


 