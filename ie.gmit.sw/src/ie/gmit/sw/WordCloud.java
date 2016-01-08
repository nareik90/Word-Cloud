package ie.gmit.sw;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;


public class WordCloud
{
	private Map<String, Integer> map;
	private int maxWords;
	private RecShaped rectList;
	private Graphics2D graphics;
	private Display dis;
	private int xposition;
	private int yposition ;
	private int direction =0;
	private int i;
	
	
	public WordCloud(Map<String, Integer> map, int max) throws Exception
	{
		this.maxWords = max;
		this.map = map;
		dis = new Display();
		rectList = new RecShaped();
		xposition = 1920/2;
		yposition = 1080/2;
		i =0;
	}
	public void drawImage() throws Exception
	{
		BufferedImage image = new BufferedImage(1920, 1080, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = (Graphics2D)image.getGraphics();
		i = 0;
		
		for(String word : map.keySet())
		{  			
			if(direction == 3)
			{
				direction = 0;
			}
			else
			{
				direction++;
			}
			if(map.get(word) <= 1 == false)
			{
				
				System.out.println(map.get(word));
				
				dis.setSize(map.get(word) + 15);
				dis.setFont();
				dis.setColour();
				
	
				drawWord(dis.getFont(), dis.getColour(),word, direction);
			}
			if(i == maxWords)
			{
				break;
			}
			i++;
		}
		graphics.dispose();
		ImageIO.write(image, "png", new File("image.png"));
	}
	private void changeLocation(Rectangle2D r, int direction)
	{
		switch(direction)
		{
			case 0:
				if(!(r.getY() < 0))
					xposition-=3;				
				else
					resetPosition();
				break;
				
			case 1:
				if(!(r.getX() + r.getWidth() > 1500))		
					yposition+=5;				
				else
					resetPosition();
				break;
				
			case 2:
				if(!(r.getY() + r.getHeight() > 750))		
					xposition+=3;				
				else
					resetPosition();
				break;
				
			case 3:
				if(!(r.getX() < 0))				
					yposition-=2;				
				else
					resetPosition();
				break;	
		}	
	}
	private void resetPosition()
	{
		xposition = 1920/2;
		yposition = 1080/2;
		changeDirection();
	}
	private void changeDirection()
	{
		if(direction == 3)
		{
			direction = 0;
		}		
		else
		{
			direction++;
		}
	}
	private Rectangle getBoundaries(Graphics2D g, String word, int x, int y)
	{
		FontRenderContext frc = g.getFontRenderContext();
		GlyphVector gv = g.getFont().createGlyphVector(frc, word);
		return gv.getPixelBounds(null, x, y);
	}
	private void drawWord(Font font, Color color, String word, int direction)
	{	
		Rectangle2D rect ;
		
		graphics.setFont(font);
		graphics.setColor(color);
		
		
		rect = getBoundaries(graphics, word, xposition, yposition); 
        	
		while(rectList.checkOverLap(rect))
		{
			changeLocation(rect, direction);
			rect = getBoundaries(graphics, word, xposition, yposition); 
		}
		
		rectList.add(rect);
		graphics.drawString(word, xposition, yposition);
	}
}
