import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.sound.sampled.*; // for sounds
import java.util.*;

public class New extends JFrame implements KeyListener{

 private JPanel contentpane;
 private JButton okButton,cancelButton;
 private MyImageIcon BG;
 private JLabel drawpane;
 private JTextField Name;
 private MySoundEffect hitSound, themeSound;
 private int frameWidth = 500, frameHeight = 230;
 
 private String NameP;
 private Map MapI;
 private ProjectGame bFirstI;
 protected Player user;

 public New()
 {
     
     setTitle("New Player");
     setBounds( 750, 400, frameWidth, frameHeight);
     setResizable(false);
     setVisible(true);
     contentpane = (JPanel) getContentPane();
     contentpane.setLayout(new BorderLayout());
 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(0);
      }
    });
     AddComponents();
     
 }
 public void AddComponents()
 {
     
     BG = new MyImageIcon("Lovely/Namenotf.jpg").resize(500,230);
     drawpane = new JLabel();
     drawpane.setIcon(BG);
     drawpane.setLayout(null);
     
     hitSound = new MySoundEffect("Lovely/beep.wav");
     themeSound = new MySoundEffect("Lovely/theme.wav");

     Name = new JTextField(20);
     Name.setBounds(75,73,350,30);
     Name.setHorizontalAlignment(JTextField.CENTER);
     Name.addKeyListener(this);
     
    
    okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener(){
    
      public void actionPerformed(ActionEvent e)
         {     
         
         int repeat = 1;
         if(MapI == null)
          { 
     try{  
     FileWriter useo,me;
     useo = new FileWriter(new File ("Player.txt"),true);    
     ArrayList<String> info = new ArrayList();
     Scanner scan = new Scanner(new File ("Player.txt"));    
     while(scan.hasNext()){
         
                String line = scan.next();
                info.add(line);
        
     }
     if(info.size() == 0){
         repeat = 0;
     }
     else{
     for(int i = 0 ; i<info.size();i++){
         
      if(!Name.getText().equalsIgnoreCase(info.get(i)) && !Name.getText().isEmpty()){
                    
        repeat = 0;
                             
         }else if(Name.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter your name ","New Player",JOptionPane.PLAIN_MESSAGE);
                    
         }else if(Name.getText().equalsIgnoreCase(info.get(i))){
                    JOptionPane.showMessageDialog(null,"Your name is already taken ","New Player",JOptionPane.ERROR_MESSAGE);
         }  
     }
     }
     if(repeat == 0){
         user = new Player(NameP,500,0,0,0,0);       
         System.out.println(user.getName());
         
         // new player no file
         PrintWriter output = new PrintWriter(new File (NameP+"O.txt")); 
         
         me = new FileWriter(new File (NameP+"B.txt"),true);
         me.write("\t\tDeposit\t\tWithDraw\r\n");
         output.printf("%s, %d, %d, %d, %d, %d\r\n",NameP,500,0,0,0,0 );

         useo.write(NameP+"\r\n" );
         
         me.close();
         useo.close();
         output.close();
         setVisible(false);     
         hitSound.playOnce();
         Player user = new Player(NameP,500,0,0,0,0);
         MapI = new Map(user,NameP,500,0,0,0,0);
         MapI.setVisible(true);
     }
      
     
  
         
          }catch(IOException e1){

         }
         
         
          } 
         }
    });
      
                 
        
     
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
          //  hitSound.playOnce();
           setVisible(false);
           bFirstI = new ProjectGame();
           bFirstI.setVisible(true);
        
      }
    });
    
    okButton.setBounds(120,120,120,30);
    cancelButton.setBounds(260,120,120,30);
    
    contentpane.add(Name,BorderLayout.CENTER);    
    contentpane.add(okButton,BorderLayout.CENTER); //addButton
    contentpane.add(cancelButton,BorderLayout.CENTER); //addButton
    contentpane.add(drawpane);
    
    validate();
 }
 public void keyTyped(KeyEvent e){ 
        
 }
 
 public void keyPressed(KeyEvent e){
     
 }

 public void keyReleased(KeyEvent e){
      NameP = Name.getText();
 }

 
  public static void main(String[] args) {
    new New();
  }
}
