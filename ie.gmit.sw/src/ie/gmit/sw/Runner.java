package ie.gmit.sw;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class Runner extends JFrame{
	
	  
    public Runner() {
        
        initUI();
    }
    
 private void initUI() {
        
        setTitle("Word Cloud");

        add(new ReallySimpleWordCloud());

        setSize(420, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);      
    }
	
	public static void main(String[] args) throws Exception {
		
		 EventQueue.invokeLater(new Runnable() {
	            
	            @Override
	            public void run() {
	                Runner ex = new Runner();
	                ex.setVisible(true);
	            }
	        });
		 
		//FileParser p = new FileParser("../JamesText.txt");	
	}
}
