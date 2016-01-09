package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class Display {
	
	private Font font;
	private int fontSize;
	private Color fontColour;
	
	Random rand = new Random();
	
	float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();
	
	public void setFont(String name, int style, int size)
	{
		font = new Font(name, style, size);
	}

	public void setFont() 
	{
		setFont(randomFont(), Font.PLAIN, getSize());		
	}
	public void setColour()
	{
		//fontColour = fontColour.blue;
		fontColour = getRandomColor();
	}
	public Color getColour()
	{
		return fontColour;
	}
	public void setSize(int size)
	{
		fontSize = (int)(size);
	}
	
	public int getSize()
	{
		return fontSize;
	}
	
	public Font getFont()
	{
		return font;
	}

	private Color getRandomColor()
	{		
		/*Color randomColor = new Color(r, g, b);
		return new Color(r, g, b);*/
		return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));

	}
	
	private String randomFont()
	{
		Random random = new Random();
		
		switch(random.nextInt(3))
		{
		case 0:
			return Font.DIALOG_INPUT;
			
		case 1:
			return Font.MONOSPACED;
			
		case 2:
			return Font.SERIF;
			
		default:
			return Font.SANS_SERIF;
		}		
	}

}
