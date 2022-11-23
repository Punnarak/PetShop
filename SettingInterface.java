import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.sound.sampled.*; // for sounds
import java.util.*;

public class SettingInterface extends JFrame implements ChangeListener{
 private JPanel contentpane,control;
 private JButton backButton;
 private ButtonGroup soundg;
 private JToggleButton[] tb;
 private MyImageIcon settingBG;
 private JLabel drawpane;
 private MySoundEffect hitSound, themeSound;
 private Main FirstI;
 protected JSlider volume; 

 private int frameWidth = 500, frameHeight = 500;
 public SettingInterface(){
     
     setTitle("Setting");
     setBounds( 750, 300, frameWidth, frameHeight);
     setResizable(false);
     setVisible(true);
     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
          dispose();
//        themeSound.stop();     
      }
    });
     contentpane = (JPanel) getContentPane();
     contentpane.setLayout(new BorderLayout());
     AddComponents();
 }
 public void AddComponents(){
     
    volume = new JSlider(JSlider.HORIZONTAL,0,100,50);
    volume.setMajorTickSpacing(25);
    volume.setMinorTickSpacing(5);
    volume.setPaintTicks(true);
    volume.setPaintLabels(true);
    volume.addChangeListener(this);    
    
    settingBG = new MyImageIcon("Lovely/cinnamoroll.jpg").resize(frameWidth, frameHeight);
    hitSound = new MySoundEffect("Lovely/beep.wav");
    themeSound = new MySoundEffect("Lovely/theme.wav");
    themeSound.playLoop();
    drawpane = new JLabel();
    drawpane.setIcon(settingBG);
    drawpane.setLayout(null);
    
    control = new JPanel();
    control.setBounds(25,50,425,350);
    control.add(volume);
    control.add(new JLabel("Sound : "));
    soundg = new ButtonGroup();
    tb = new JToggleButton[2];
    tb[0] = new JRadioButton("ON");
    tb[0].setName("ON");
    tb[0].setSelected(true);
    tb[1] = new JRadioButton("OFF");
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
    
    backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          
           hitSound.playOnce();
           setVisible(false);
           FirstI = new Main();
           FirstI.setVisible(true);           
        
      }
    });
    
    backButton.setBounds(950,500,200,50);
    
    contentpane.add(backButton,BorderLayout.CENTER); //addButton
    contentpane.add(control,BorderLayout.CENTER);
    contentpane.add(drawpane, BorderLayout.CENTER); //addBG
    
    validate();

 }
 public void stateChanged(ChangeEvent e){
     
     JSlider source = (JSlider)e.getSource();
     if(!source.getValueIsAdjusting()){
         
         int value  = (int) source.getValue();
         System.out.println(value);
         
     }
     
 }

}
