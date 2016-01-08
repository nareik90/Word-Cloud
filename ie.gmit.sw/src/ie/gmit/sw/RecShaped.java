package ie.gmit.sw;

import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;

public class RecShaped {
	private Set<Rectangle2D> rectList;
	
	public RecShaped()
	{
		rectList = new HashSet<Rectangle2D>();
	}
	public void add (Rectangle2D rect)
	{
		rectList.add(rect);
	}
	public void remove(Rectangle2D rect)
	{
		rectList.remove(rect);
	}
	public boolean checkOverLap(Rectangle2D rect)
	{
		boolean overlapping = false;
		
		for(Rectangle2D rectOne : rectList)
		{
			overlapping = (rectOne.intersects(rect));
			
			if(overlapping)
			{
				break;
			}
		}
		//System.out.println(overlapping);
		return overlapping; 
	}
}
