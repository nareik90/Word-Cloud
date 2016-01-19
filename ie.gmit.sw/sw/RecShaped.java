package ie.gmit.sw;

import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;

public class RecShaped /*implements Background*/{
	private Set<Rectangle2D> rectList;
	
	public RecShaped()
	{
		rectList = new HashSet<Rectangle2D>();
	}
	public void add (Rectangle2D recShape)
	{
		rectList.add(recShape);
	}
	public void remove(Rectangle2D recShape)
	{
		rectList.remove(recShape);
	}
	public boolean checkOverLap(Rectangle2D recShape)
	{
		boolean overlapping = false;
		
		for(Rectangle2D rectOne : rectList)
		{
			overlapping = (rectOne.intersects(recShape));
			
			if(overlapping)
			{
				break;
			}
		}
		//System.out.println(overlapping);
		return overlapping; 
	}
}
