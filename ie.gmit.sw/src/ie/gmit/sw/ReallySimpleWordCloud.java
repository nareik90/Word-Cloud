package ie.gmit.sw;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ReallySimpleWordCloud extends JPanel {

	private static final long serialVersionUID = 7911935095266425233L;

	private void doDrawing(Graphics g) throws IOException {
	        
	        Graphics2D g2d = (Graphics2D) g;

	        RenderingHints rh =
	            new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
	            RenderingHints.VALUE_ANTIALIAS_ON);

	        rh.put(RenderingHints.KEY_RENDERING,
	               RenderingHints.VALUE_RENDER_QUALITY);

	        g2d.setRenderingHints(rh);

	        g2d.setFont(new Font("Purisa", Font.PLAIN, 13));
       
	        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
			 BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_4BYTE_ABGR);
			 Graphics graphics = image.getGraphics();
			 g2d.setColor(Color.red);
			 g2d.setFont(font);
			 g2d.drawString("Object-Oriented", 0, 100);
			
			 font = new Font(Font.SANS_SERIF, Font.ITALIC, 42);
			 g2d.setFont(font);
			 g2d.setColor(Color.yellow);
			 g2d.drawString("Software Development", 10, 150);
			
			 font = new Font(Font.MONOSPACED, Font.PLAIN, 22);
			 g2d.setFont(font);
			 g2d.setColor(Color.blue);
			 g2d.drawString("2012 Assignment", 40, 180);
			
			 g2d.dispose();
			 ImageIO.write(image, "png", new File("image.png"));
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        try {
				doDrawing(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
