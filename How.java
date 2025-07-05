
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class How extends MouseAdapter {
  
  protected JFrame HowI;  
  protected JLabel n,b,h1,h2,h3,h4,h5,h6,h7;
  protected JPanel h;
  protected int x = 1;
  protected JButton nb,bB;
  
  public How(){
      
         HowI = new JFrame("How to play");
         HowI.setBounds(100,40,1366,768);
         HowI.setResizable(false);
         HowI.setVisible(true);
         HowI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         HowI.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            
            HowI = null;
            new MainApplication();

      }
    });
     AddComponents();
  }
  
  public void AddComponents()
 {
          HowI.setContentPane(h = new JPanel());
          h.setLayout(null);
          h.setBounds(0,0,1366,768);
          
          MyImageIcon hh1 = new MyImageIcon("Lovely/h1.jpg");
          h1 = new JLabel(hh1.resize(1366,768));
          h1.setBounds(0,-25,1366,768);
          
          MyImageIcon hh2 = new MyImageIcon("Lovely/h2.jpg");
          h2 = new JLabel(hh2.resize(1366,768));
          h2.setBounds(0,-25,1366,768);
          h2.setVisible(false);
          
          
          MyImageIcon hh3 = new MyImageIcon("Lovely/h3.jpg");
          h3 = new JLabel(hh3.resize(1366,768));
          h3.setBounds(0,-25,1366,768);
          h3.setVisible(false);
    
          MyImageIcon hh4 = new MyImageIcon("Lovely/h2.jpg");
          h4 = new JLabel(hh4.resize(1366,768));
          h4.setBounds(0,-25,1366,768);
          h4.setVisible(false);
                   
          MyImageIcon hh5 = new MyImageIcon("Lovely/h5.jpg");
          h5 = new JLabel(hh5.resize(1366,768));
          h5.setBounds(0,-25,1366,768);
          h5.setVisible(false);
          
          MyImageIcon hh6= new MyImageIcon("Lovely/h6.jpg");
          h6 = new JLabel(hh6.resize(1366,768));
          h6.setBounds(0,-25,1366,768);
          h6.setVisible(false);
                    
          MyImageIcon hh7 = new MyImageIcon("Lovely/h7.jpg");
          h7 = new JLabel(hh7.resize(1366,768));
          h7.setBounds(0,-25,1366,768);
          h7.setVisible(false);

          MyImageIcon nn = new MyImageIcon("Lovely/nb.png");    
          nb = new JButton(nn.resize(50,50));
          nb.setBounds(1270,350,50,50);
          nb.addActionListener(new ActionListener(){              
             public void actionPerformed (ActionEvent e){      
                           
                 if(x>=8)
                 {
                     
                 }else{
                     
                 x++;
                 
                 }
                  
                 if(x == 1){
                   
                   h1.setVisible(true);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
               }
               if(x == 2){
                   h1.setVisible(false);
                   h2.setVisible(true);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
               }else if(x == 3 ){
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(true);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
               }else if(x == 4 ){
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(true);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
               }
               else if(x == 5 ){
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(true);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
               }
               else if(x == 6 ){
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(true);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
               }else if(x == 7 ){
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(true);
                   nb.setVisible(false);
                   bB.setVisible(true);
               }
                       
             } 
          });
                   
          MyImageIcon bb = new MyImageIcon("Lovely/bbb.png");
          bB = new JButton(bb.resize(50,50));
          bB.setBounds(20,350,50,50);
          bB.setVisible(false);
          bB.addActionListener(new ActionListener(){
             public void actionPerformed (ActionEvent e){ 
                 if(x<=1)
                 {
                     
                 }else{
                     x--; 
                 }
                
                if(x == 1){
                    
                   h1.setVisible(true);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(false);
                   
               } 
               if(x == 2){
                   
                   h1.setVisible(false);
                   h2.setVisible(true);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
                   
               }else if(x == 3 ){
                   
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(true);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
                   
               }else if(x == 4 ){
                   
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(true);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
                   
               }
               else if(x == 5 ){
                   
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(true);
                   h6.setVisible(false);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
                   
               }
               else if(x == 6 ){
                   
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(true);
                   h7.setVisible(false);
                   nb.setVisible(true);
                   bB.setVisible(true);
                   
               }else if(x == 7 ){
                   
                   h1.setVisible(false);
                   h2.setVisible(false);
                   h3.setVisible(false);
                   h4.setVisible(false);
                   h5.setVisible(false);
                   h6.setVisible(false);
                   h7.setVisible(true);
                   nb.setVisible(false);
                   bB.setVisible(true);
                   
               }      
             } 
          });
          
          //add next and back button
          h.add(nb);
          h.add(bB);

          //scenes
          h.add(h1);
          h.add(h2);
          h.add(h3);
          h.add(h4);
          h.add(h5);
          h.add(h6);
          h.add(h7);
          
          h.repaint();
          }
        
      }
 

