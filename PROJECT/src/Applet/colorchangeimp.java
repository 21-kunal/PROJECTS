/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applet;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.*;
import java.util.TimerTask;



public class colorchangeimp extends JPanel{
    
    JFrame f = new JFrame();
    String shape;
    static int H, W, i;
    static boolean show = false;
    
    
    
    java.util.Timer t;
    public colorchangeimp(){
        
       f.setSize(500, 500);
       show = false;
       f.add(this);
       f.setBackground(Color.white);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setVisible(true);
       f.setTitle("Transition Displayer");
       f.setBounds(1000, 500, 850, 500);    
    }
    
    public void draw(String shape, int h, int w){
        this.shape= shape;
        H = h;
        W = w;
        show = true;
        t = new java.util.Timer();
        t.schedule(new Display(),100,1000);    
    }
    
    public void cancel(){
        t.cancel();
    }
  
    @Override
    public void paint(Graphics g) {
        
            
        if(show){
            int rval=(int)(Math.floor(Math.random()*256));
	    int gval=(int)(Math.floor(Math.random()*256));
	    int bval=(int)(Math.floor(Math.random()*256));
	    g.setColor(new Color(rval, gval, bval));
            
                    if(shape.equals("RECTANGLE"))
                        g.fillRect(155, 75, H, W);
                    else if(shape.equals("Oval"))
                        g.fillOval (155, 75, H, W);
            
                    else if(shape.equals("TRIANGLE")){
                        int x[] = {155,155+W,155+W/2};
                        int y[] = {75,75,75+H};
                        g.fillPolygon(x, y, 3);
                    }
                    
                }
        }
    
    class Display extends TimerTask{
        @Override
        public void run(){
            
            f.repaint();
        }
    }   
}
