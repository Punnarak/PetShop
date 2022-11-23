import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.sound.sampled.*; // for sounds
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Load extends JFrame implements ActionListener {

 private JPanel contentpane;
 private JButton okButton,cancelButton;
 private MyImageIcon BG;
 private JLabel drawpane;
 private JTextField Name;
 private MySoundEffect hitSound, themeSound;
 private int frameWidth = 500, frameHeight = 500;
 private String value;
 private int b,s,b1,b3,b4;
 private   Scanner scanme;
 private Vector l;
 
 private Map MapI;
 private ProjectGame bFirstI;
 
 protected Player user;
 
 private JList list ;
private ArrayList<String> infon;
private ArrayList<Player> User;
 public Load()
 {
     setTitle("Load Game");
     setBounds( 750, 300, frameWidth, frameHeight);
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
      BG = new MyImageIcon("Lovely/load.png").resize(500,500);
      drawpane = new JLabel();
      drawpane.setIcon(BG);
      drawpane.setLayout(null);
      drawpane.getPreferredSize();
      
     try{
     infon = new ArrayList<String>(); 
     User = new ArrayList<>();    
     

     l = new Vector(infon.size());
     DefaultListModel<String> l1 = new DefaultListModel<>();  
     list = new JList<String>(l1);
     list.setFont(new Font("Qwigley",Font.PLAIN,20));
     list.setSelectedIndex(0);
     list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     list.setBounds(25,80,425,270); 
     JScrollPane scrollPane1 = new JScrollPane(list);
     
     contentpane.add(scrollPane1);
     Scanner scan = new Scanner(new File ("Player.txt"));    
     while(scan.hasNext()){
         
                String line = scan.next();
                infon.add(line);
                            
     }
     for(int i = 0;i<infon.size();i++){
         l1.addElement(infon.get(i));
     } 

      hitSound = new MySoundEffect("Lovely/beep.wav");

     okButton = new JButton("OK");
  
     okButton.addActionListener(this);
     cancelButton = new JButton("Cancel");
     cancelButton.addActionListener(new ActionListener(){
    
       public void actionPerformed(ActionEvent e)
          {     
         
          if(bFirstI == null)
           { 
               
           setVisible(false);
           bFirstI = new ProjectGame();
           bFirstI.setVisible(true);
        
           } 
          }
     });
    okButton.setBounds(120,380,120,30);
    cancelButton.setBounds(260,380,120,30);
    
    
    contentpane.add(okButton,BorderLayout.CENTER); //addButton
    contentpane.add(cancelButton,BorderLayout.CENTER); //addButton
    contentpane.add(list);
    
    contentpane.add(drawpane); 
     }catch(IOException e2){
         
     } 
     validate();
    
 }
 public void actionPerformed(ActionEvent e)
          {     
          try{
          if(MapI == null)
           { 
               
          int index = list.getSelectedIndex();
          value = (String)list.getSelectedValue();
          System.out.println(value);
          setVisible(false);     
          
         hitSound.playOnce();
          
 
          for(int i = 0; i<infon.size() ;i++){
          
          scanme = new Scanner(new File (infon.get(i)+"O.txt"));   
         
           while(scanme.hasNext()){
         
                
                String line = scanme.nextLine();
                String [] column = line.split(",");
                
                Player user = new Player(column[0],Integer.parseInt(column[1].trim()), Integer.parseInt(column[2].trim()), Integer.parseInt(column[3].trim()),Integer.parseInt(column[4].trim()),Integer.parseInt(column[5].trim()));
                User.add(user);    
                
                if(User.get(i).getName().equalsIgnoreCase(value)){
                
                  b = User.get(i).getMBank();
                  s = User.get(i).getStruck();
                  b1 = User.get(i).getB1();
                  b3 = User.get(i).getB3();
                  b4 = User.get(i).getB4();
                  System.out.println(b1+"  Loading"); 
                  MapI = new Map(user,value,b,s,b1,b3,b4); MapI.setVisible(true);

              }       
            }    
              
          }

        
           } 
           }catch(Exception e1){
                   
                   }
          }
 
  public static void main(String[] args) {
    new Load();
  }
}
