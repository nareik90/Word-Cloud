package ie.gmit.sw;

import java.awt.Color;
import java.awt.Graphics;

public class BackgroundColorRect {
	public void backColor(int width, int height, Graphics graphics)
	{
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width, height);		
	}
}
