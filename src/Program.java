

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;




public class Program extends JFrame {
    
    JButton[] btns=new JButton[9]; 
    OnClick clickListener;
    boolean step=true; 
    static Program  window;
            
    public static void main(String[] args) {
        window =(new Program());
               window.setVisible(true);
    }

    public Program()  {
        super("TIС TAС TOE");
        this.setBounds(500,300,300,300);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
         this.setLayout(new GridLayout(3,3,1,1));
         
         clickListener=new OnClick();
         for (int i = 0; i < btns.length; i++) {
            
             btns[i]=new JButton();
             btns[i].addActionListener(clickListener);
             btns[i].setFont(new Font("Arial",Font.PLAIN,40));
             btns[i].setFocusable(false);
             this.add(btns[i]);
             
        }
         
        
    }
    
    class OnClick implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
           if(step==true){
           
                 if(((JButton)e.getSource()).getText().equals("")){
                ((JButton)e.getSource()).setText("X");
                    window.setTitle("O");
                    step=false;
                }
             } 
           
           
             if(step==false){
             if(((JButton)e.getSource()).getText().equals("")){
                ((JButton)e.getSource()).setText("O");
                window.setTitle("X");
                step=true;
                }
             
             }
             
             
             for (int i = 0; i < 3; i++) {
                String sym=btns[i*3].getText();
                if(!sym.equals("")){
                 if( sym.equals(btns[i*3+1].getText()) && sym.equals(btns[i*3+2].getText())){
                 
                  JOptionPane.showMessageDialog(null, sym+" win");
                  clearField();
                  
                 }
                }
                
            }
             
              for (int i = 0; i <3 ; i++) {
                String sym=btns[i].getText();
                if(!sym.equals("")){
                 if( sym.equals(btns[i+3].getText()) && sym.equals(btns[i+6].getText())){
                 
                  JOptionPane.showMessageDialog(null, sym+" win");
                  clearField();
                  
                 }
                }
               
            }
              
              
              if(!btns[4].getText().equals("")){
              
                  if(btns[0].getText().equals(btns[4].getText()) && btns[0].getText().equals(btns[8].getText())){
              
                JOptionPane.showMessageDialog(null, btns[0].getText()+" win");
                clearField();
              }
             
              if(btns[2].getText().equals(btns[4].getText()) && btns[2].getText().equals(btns[6].getText())){
              
                JOptionPane.showMessageDialog(null, btns[2].getText()+" win");
                clearField();
              }
              }
         }         
                  
         
        void clearField(){
        
            for (int i = 0; i < btns.length; i++) {
                btns[i].setText("");
            }
        };
        
    }   
            
            
                     
               
            
           
       
    
    
    
    
}
